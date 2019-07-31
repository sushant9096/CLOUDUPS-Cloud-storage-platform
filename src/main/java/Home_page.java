import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.io.IOException;
import javax.swing.event.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.*;
import java.util.ArrayList;
import downloader.*;


public class Home_page extends JFrame {
    

    private JPanel main_panel;

    private JLabel username_lable;
    private JLabel app_logo;
    private JButton uploadBtn;
    private JButton logOut;

    private JProgressBar progressBar1;
    private JScrollPane scroller;
    private JButton downloadButton;
    private JButton deleteFileButton;
    private JLabel filename_field;
    private JLabel extimg;
    private JButton refresh_btn;
    private JLabel filesize_field;
    private JLabel fileext_field;
    private JLabel fileid_field;
    private JPanel headerPanel;
    JList jList1;

    JSONObject filesobj;
    int totalfiles=0;

    int selectedfileindex;



    Home_page(){

        //initialization
        username_lable.setText(Res.user_username);
        add(main_panel);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle(Res.app_name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
        setVisible(true);
        deleteFileButton.setVisible(false);
        downloadButton.setVisible(false);
        //end ini










        //*******Onclick Listners**********

        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File(Res.user_data_file);

                if(file.delete())
                {
                    System.out.println("File deleted successfully");
                    setVisible(false);
                    new Login_page();
                    dispose();
                }
                else
                {
                    System.out.println("Failed to Logout");
                }

            }
        });


        uploadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UploadAdapter upthread=new UploadAdapter();
                upthread.start();
            }
        });


        refresh_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new Home_page();
            dispose();

            }
        });

        deleteFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //System.out.println(selectedfileindex);

                deleteFile( ( (JSONObject)filesobj.get(Integer.toString(selectedfileindex)) ).get("id").toString()  );
            }
        });

        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String f= ( (JSONObject)filesobj.get(Integer.toString(selectedfileindex)) ).get("filename").toString();
                System.out.println(f);
                new SwingFileDownloadHTTP(Res.server_url+"uploads/"+f).setVisible(true);

            }
        });
        //end of constructon
    }
    public void setImgExtension(String ext){
            try {
                extimg.setIcon(new ImageIcon(new ImageIcon("extension_ico/" + ext + ".png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

            }catch (Exception e){
               //System.out.println(e.toString());
                extimg = new JLabel(new ImageIcon(new ImageIcon("extension_ico/unknown.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

            }




    }
    private void createUIComponents() {
       username_lable=new JLabel(new ImageIcon( new ImageIcon("profile.png").getImage().getScaledInstance(50, 50,  Image.SCALE_SMOOTH)));
       app_logo=new JLabel(new ImageIcon( new ImageIcon(Res.logo_location).getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH)));

        // TODO: place custom component creation code here



        try {
            listupdater();
            scroller = new JScrollPane(jList1);
        }catch (Exception e){}
    }




    public void listupdater()throws Exception {


            filesobj = getdataofuser();
        if(filesobj==null){
            System.out.println("null from server");
            throw new Exception("its exc");
        }else {
            jList1 = new JList();


            ArrayList a = new ArrayList();
            for (int i = 0; i <= totalfiles; i++) {
                a.add(((JSONObject) filesobj.get(Integer.toString(i))).get("filename").toString());
            }


            jList1.setModel(new DefaultListModel() {
                ArrayList strings = a;

                public int getSize() {
                    return strings.size();
                }

                public Object getElementAt(int i) {
                    return (String) strings.get(i);
                }
            });
            jList1.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent evt) {
                    if (!jList1.getValueIsAdjusting()) {
                        //here my code
                        System.out.println((String) jList1.getSelectedValue());
                        System.out.println(jList1.getSelectedIndex());

                        deleteFileButton.setVisible(true);
                        downloadButton.setVisible(true);

                        selectedfileindex = jList1.getSelectedIndex();

                        fileclick(jList1.getSelectedIndex());

                    }
                }
            });


            setImgExtension("unknown");

        }

    }

    public void fileclick(int i){

        JSONObject data=(JSONObject) filesobj.get(Integer.toString(i));
        filename_field.setText(data.get("filename").toString());
        fileext_field.setText(data.get("ext").toString());
        fileid_field.setText(data.get("id").toString());
        filesize_field.setText(data.get("filesize").toString()+" bytes" );
        setImgExtension(data.get("ext").toString());
    }


    private JSONObject getdataofuser() throws Exception {


        try {
            HttpHandler sh = new HttpHandler();
            String jsonStr = sh.makeServiceCall(Res.server_url+"getdata.php?u="+Res.user_username);
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonStr);
            totalfiles=jsonObject.size() -1;
//            System.out.println(" asdadasdsadasd   "+((JSONObject) jsonObject.get("0") ).get("filename") );

            return jsonObject;




        }catch (Exception e){
            System.out.println(" errorrr  ");
            throw new Exception("getdataofuser method error ");
            //return null;
        }


    }


    public void deleteFile(String id){

        try {
            URL url = new URL(Res.server_url+"deletefile.php?id="+id);
            URLConnection urlcon = url.openConnection(); //creating connection between client(game) and server
            InputStream stream = urlcon.getInputStream(); //Download data from server(server response)
            int i;
            while ((i = stream.read()) != -1) { //prints returned data character by character to the console
                System.out.print((char) i);

            }

        } catch(Exception e) {
            System.out.println(e);
        }
        setVisible(false);
        new Home_page();
        dispose();
    }





    //-----------end--------------

}


