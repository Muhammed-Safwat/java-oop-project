package JavaLoginSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;
public class LoginPage implements ActionListener{
    JFrame frame  = new JFrame("Login");
    JButton loginButton =new JButton("Login");
    JButton restButton =new JButton("Reset");
    JTextField usrIDfield = new JTextField();
    JPasswordField userPasswordfield = new JPasswordField();
    JLabel  userIdLabel = new JLabel("user Id:");
    JLabel userPasswordLabel =new JLabel("password:");
    JLabel massageLable = new JLabel("");
    HashMap <String , String> loginInfo = new HashMap<>();
    LoginPage(HashMap<String,String> loginInfoOriginal){
        loginInfo = loginInfoOriginal;
        userIdLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);
        massageLable.setBounds(125, 250, 250, 35);
        usrIDfield.setBounds(125, 100, 200, 25);
        userPasswordfield.setBounds(125, 150, 200, 25);
        
        loginButton.setBounds(125,200,100,25);
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);
        restButton.setBounds(225,200,100,25);   
        restButton.addActionListener(this);
        restButton.setFocusable(false);
        massageLable.setFont(new Font(null, Font.ITALIC ,25));
        frame.add(loginButton);
        frame.add(restButton);
        frame.add(userIdLabel);
        frame.add(userPasswordLabel);
        frame.add(massageLable);
        frame.add(usrIDfield);
        frame.add(userPasswordfield);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420 ,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==restButton){
            usrIDfield.setText("");
            userPasswordfield.setText("");
            massageLable.setText(""); 
        }
        if(ae.getSource()==loginButton){
           String userId =   usrIDfield.getText();
           String pass = String.valueOf(userPasswordfield.getPassword());
           System.out.println(userId);
           if(loginInfo.containsKey(userId)){
               if(loginInfo.get(userId).equals(pass)){
                   massageLable.setForeground(Color.green);
                   massageLable.setText("login successful");
                   frame.dispose();
                   welcamePage welcamepage = new welcamePage("Hello ,"+userId);
                   
               }else{
                   massageLable.setForeground(Color.red);
                   massageLable.setText("correct password!"); 
               }
            }else{
                   massageLable.setForeground(Color.red);
                   massageLable.setText("user not Found!"); 
               }
        }
    }
    
    
    
    
}
