import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sAuth.*;

public class Login_page extends JFrame{
    private JPanel panel;
    private JLabel logo_lbl;
    private JTextField user_field;
    private JPasswordField pass_field;
    private JButton submit_btn;
    private JButton signup_btn;

    public Login_page(){
        setTitle(Res.login_title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setSize(600,500);















        submit_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try_to_login(user_field.getText(),pass_field.getText());
            }
        });



        signup_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new signup();
                //setVisible(false);
                dispose();
            }
        });


        setVisible(true);



    }



    private void try_to_login(String username,String password){


        if(username.equals("") || password.equals("")){
            JOptionPane.showMessageDialog(null,Res.textfield_required);
            return;
        }
        try {
            HttpHandler sh = new HttpHandler();
            String jsonStr = sh.makeServiceCall(Res.server_url+"signin.php?username="+username+"&password="+password);
            JSONObject jsondata = (JSONObject) new JSONParser().parse(jsonStr);

            if(jsondata.get("status").toString().equals("success")){

                Res.user_username=username;
                Res.user_password=password;

                new authWrite(Res.user_data_file,username,password);

                setVisible(false);
                new Home_page();
                dispose();


            }else {
                JOptionPane.showMessageDialog(null,jsondata.get("status").toString());



            }



        }catch (Exception e){
            JOptionPane.showMessageDialog(null,Res.internet_error);
        }



    }




    private void createUIComponents() {
        logo_lbl=new JLabel(new ImageIcon(Res.logo_location));
        // TODO: place custom component creation code here
    }
}
