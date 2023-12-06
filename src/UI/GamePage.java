package UI;

import UI.View.ViewFactory;

import javax.swing.*;
import java.awt.*;

public class GamePage extends JFrame {
    
    public GamePage() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridBagLayout());
        this.setSize(1200, 900);
        
        getContentPane().add(ViewFactory.getInstance().getLoginView());
        setVisible(true);
        
    }
}
