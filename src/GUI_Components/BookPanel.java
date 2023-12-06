package GUI_Components;

import javax.swing.*;
import java.awt.*;

public class BookPanel extends JPanel {
    
    public BookPanel() {
        setPreferredSize(new Dimension(400, 200));
        setLayout(null);
        setBackground(Color.red);
        ImagePanel book = new ImagePanel("./Images/book/book.png");
        book.setBounds(0, 0, 400, 200);
        add(book);
        book.setLayout(null);
        
        ImagePanel panel = new ImagePanel("./Images/book/feet.png");
        panel.setBounds(60, 10, 100, 100);
        book.add(panel);
        
        BookButton panel_1 = new BookButton(70, 110, 60, 60, 1);
        //panel_1.setBounds(70, 110, 80, 80);
        book.add(panel_1);
    }
    
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.getContentPane().setLayout(new GridBagLayout());
        BookPanel login = new BookPanel();
        frame.getContentPane().add(login);
        frame.setVisible(true);
    }
    
}
