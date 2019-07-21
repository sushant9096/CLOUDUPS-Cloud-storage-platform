import javax.swing.*;
import java.awt.*;


public class Home_page extends JFrame {
    

    private JPanel main_panel;
    private JLabel username_lable;
    private JLabel app_logo;
    private JButton log_out_btn;
    private JButton download_btn;
    private JButton delete_btn;
    private JLabel img1;
    private JLabel img2;
    private JLabel img3;
    private JLabel img4;
    private JLabel img5;
    private JLabel img6;
    private JLabel img7;
    private JLabel img8;
    private JLabel img9;
    private JLabel img10;
    private JLabel img11;
    private JLabel img12;
    private JLabel img13;
    private JLabel img14;
    private JLabel img15;
    private JLabel img16;
    private JButton upload_btn;
    private JProgressBar progressBar1;
    private JLabel left_arrow;
    private JLabel right_arrow;
    private JScrollPane sscrollpane;
    private JList slist;

    Home_page(){


        username_lable.setText(Res.user_username);

        //add(sscrollpane);

        add(main_panel);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setTitle(Res.app_name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);

        setVisible(true);
    }

    private void createUIComponents() {
        username_lable=new JLabel(new ImageIcon( new ImageIcon("profile.png").getImage().getScaledInstance(50, 50,  Image.SCALE_SMOOTH)));
        app_logo=new JLabel(new ImageIcon( new ImageIcon(Res.logo_location).getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH)));
        left_arrow =new JLabel(new ImageIcon( new ImageIcon(Res.left_arrow).getImage().getScaledInstance(100, 80,  Image.SCALE_SMOOTH)));
        right_arrow =new JLabel(new ImageIcon( new ImageIcon(Res.right_arrow).getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH)));
        img1 =new JLabel(new ImageIcon( new ImageIcon(Res.logo_location).getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH)));
        img2 =new JLabel(new ImageIcon( new ImageIcon(Res.logo_location).getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH)));
        img3 =new JLabel(new ImageIcon( new ImageIcon(Res.logo_location).getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH)));
        img4 =new JLabel(new ImageIcon( new ImageIcon(Res.logo_location).getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH)));
        img5 =new JLabel(new ImageIcon( new ImageIcon(Res.logo_location).getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH)));
        img6 =new JLabel(new ImageIcon( new ImageIcon(Res.logo_location).getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH)));
        img7 =new JLabel(new ImageIcon( new ImageIcon(Res.logo_location).getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH)));
        img8=new JLabel(new ImageIcon( new ImageIcon(Res.logo_location).getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH)));
        img9 =new JLabel(new ImageIcon( new ImageIcon(Res.logo_location).getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH)));
        img10 =new JLabel(new ImageIcon( new ImageIcon(Res.logo_location).getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH)));
        img11 =new JLabel(new ImageIcon( new ImageIcon(Res.logo_location).getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH)));
        img12 =new JLabel(new ImageIcon( new ImageIcon(Res.logo_location).getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH)));
        img13 =new JLabel(new ImageIcon( new ImageIcon(Res.logo_location).getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH)));
        img14 =new JLabel(new ImageIcon( new ImageIcon(Res.logo_location).getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH)));
        img15 =new JLabel(new ImageIcon( new ImageIcon(Res.logo_location).getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH)));
        img16 =new JLabel(new ImageIcon( new ImageIcon(Res.logo_location).getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH)));
        // TODO: place custom component creation code here
    }


    //-----------end--------------

}


