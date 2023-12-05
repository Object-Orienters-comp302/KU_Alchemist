package GUI_Components;

import javax.swing.*;
import java.awt.*;

public class RectangleTable extends JPanel {
    
    public RectangleTable () {
        setPreferredSize(new Dimension(800, 400));
        setBackground(Color.WHITE);
        setLayout(null);
        ImagePanel table = new ImagePanel(".//Images//triangleTable//RectangleTable.png");
        table.setLocation(0, 0);
        table.setSize(800, 400);
        add(table);
        
        for (int i = 1; i <= 8; i++) {
            TickButton button = new TickButton(60 + (i - 1) * 100, 82, 35, 35);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
        for (int i = 1; i <= 8; i++) {
            TickButton button = new TickButton(60 + (i - 1) * 100, 122, 35, 35);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
        for (int i = 1; i <= 8; i++) {
            TickButton button = new TickButton(60 + (i - 1) * 100, 162, 35, 35);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
        for (int i = 1; i <= 8; i++) {
            TickButton button = new TickButton(60 + (i - 1) * 100, 202, 35, 35);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
        for (int i = 1; i <= 8; i++) {
            TickButton button = new TickButton(60 + (i - 1) * 100, 242, 35, 35);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
        for (int i = 1; i <= 8; i++) {
            TickButton button = new TickButton(60 + (i - 1) * 100, 282, 35, 35);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
        for (int i = 1; i <= 8; i++) {
            TickButton button = new TickButton(60 + (i - 1) * 100, 322, 35, 35);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
        for (int i = 1; i <= 8; i++) {
            TickButton button = new TickButton(60 + (i - 1) * 100, 362, 35, 35);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
    }
    
    public static void main (String[] args) {
        //TriangleTable tri = new TriangleTable("#34ebcf");
        
        
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.getContentPane()
                .setLayout(new GridBagLayout());
        RectangleTable login = new RectangleTable();
        frame.getContentPane()
                .add(login);
        frame.setVisible(true);
        
        
    }
    
}
