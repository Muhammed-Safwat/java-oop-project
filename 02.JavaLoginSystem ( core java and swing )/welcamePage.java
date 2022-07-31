package JavaLoginSystem;
import java.awt.Font;
import javax.swing.*;
public class welcamePage {
    JFrame frame = new JFrame();
    JLabel WelcomeLabel = new JLabel("Hello!");
    welcamePage(String name){
        WelcomeLabel.setText(name);
        WelcomeLabel.setBounds(0 ,0,200,35);
        WelcomeLabel.setFont(new Font(null ,Font.PLAIN ,25));
        frame.add(WelcomeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420 ,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
