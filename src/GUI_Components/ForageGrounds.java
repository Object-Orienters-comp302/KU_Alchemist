package GUI_Components;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import GUI_Components.ImagePanel;

public class ForageGrounds extends JPanel {
    
    /**
     * Create the panel.
     */
    ImagePanel Background;
    ImagePanel Card;
    public ForageGrounds() {
        this.setSize(1000,500);
        setLayout(null);
        
        Card = new ImagePanel("C:/Workspace/GameBoard/Images/backgrounds/CardSized.png"); //Dummy Path.
        Card.setBounds(832,240 ,158, 250);
        this.add(Card);
        
        Background = new ImagePanel("C:/Workspace/GameBoard/Images/backgrounds/forageGrounds.png");//Dummy Path Because I didn't use enum
        Background.setBounds(0,0 ,1000, 500);
        this.add(Background);
        
        Card.addMouseMotionListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //Dummy Code
            }
        });
        
    }
    
}