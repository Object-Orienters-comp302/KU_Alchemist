package UI;

import Models.Token;

import javax.swing.*;
import java.awt.*;

public class LoginView {
    public void displayLoginView() {
        new Token("khorne","./Images/tokens/khorne.png","./Images/backgrounds/khorne_background.png");
        new Token("nurgle","./Images/tokens/nurgle.png","./Images/backgrounds/nurgle_background.png");
        new Token("slaanesh","./Images/tokens/slaanesh.png","./Images/backgrounds/slaanesh_background.png");
        new Token("tzeentch","./Images/tokens/tzeentch.png","./Images/backgrounds/tzeentch_background.png");

        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 900);
        frame.getContentPane().setLayout(new GridBagLayout());
        JPanel login = new LoginPage();
        frame.getContentPane().add(login);
        frame.setVisible(true);
    }
}
