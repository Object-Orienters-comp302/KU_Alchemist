package UI;

import javax.swing.*;
import java.awt.*;

public class LoginView {
    protected JFrame    frame;
    protected LoginPage loginPage;
    
    public LoginView() {
        // This function creates a JFrame and adds the LoginPage JPanel to it.
        
        // Setup JFrame
        frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 900);
        frame.getContentPane().setLayout(new GridBagLayout());
        
        // Setup LoginPage JPanel
        loginPage = new LoginPage();
        
        // Add LoginPage JPanel to JFrame
        frame.getContentPane().add(loginPage);
        
    }
    
    public void setVisible(boolean b) {
        loginPage.setVisible(b);
        frame.setVisible(b);
    }
}
