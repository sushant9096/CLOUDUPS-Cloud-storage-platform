import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class signup extends JFrame{
    private JLabel logo_lbl;
    private JButton create_account_btn;
    private JButton signin_btn;
    private JTextField email_field;
    private JTextField user_field;
    private JPasswordField password_field;
    private JPanel main_panel_of_signup;

    signup(){
        add(main_panel_of_signup);
        setTitle(Res.signup_title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);


        create_account_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try_to_create_account(user_field.getText(),password_field.getText(),email_field.getText());

            }
        });
        signin_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login_page();
                dispose();
            }
        });

        setVisible(true);
    }




    private void try_to_create_account(String username,String password,String email){

        if(username.equals("") || password.equals("") || email.equals("")){
            JOptionPane.showMessageDialog(null,Res.textfield_required);
            return;
        }
        try {
            HttpHandler sh = new HttpHandler();
            String jsonStr = sh.makeServiceCall(Res.server_url+"signup.php?username="+username+"&password="+password+"&email="+email);
            JSONObject jsondata = (JSONObject) new JSONParser().parse(jsonStr);

            JOptionPane.showMessageDialog(null,jsondata.get("status").toString());
            new Login_page();
            setVisible(false);
            dispose();

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,Res.internet_error);
        }


    }



    private void createUIComponents() {
        logo_lbl=new JLabel(new ImageIcon(Res.logo_location));
        // TODO: place custom component creation code here
    }
}
