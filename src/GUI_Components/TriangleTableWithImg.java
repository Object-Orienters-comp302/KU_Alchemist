package GUI_Components;

import javax.swing.*;
import java.awt.*;

public class TriangleTableWithImg extends JPanel {
    
    public TriangleTableWithImg () {
        setPreferredSize(new Dimension(900, 900));
        setBackground(Color.WHITE);
        setLayout(null);
        ImagePanel table = new ImagePanel(".//Images//triangleTable//TriangleTable.png");
        table.setLocation(50, 50);
        table.setSize(800, 800);
        add(table);
        table.setLayout(null);
        
        
        ///Buttons           271 70   233,145
        TriangleTableButton Button1_1 = new TriangleTableButton(370, 130, 60, 60);
        table.add(Button1_1);
        
        TriangleTableButton Button2_1 = new TriangleTableButton(325, 210, 60, 60);
        table.add(Button2_1);
        
        TriangleTableButton Button2_2 = new TriangleTableButton(415, 210, 60, 60);
        table.add(Button2_2);
        
        TriangleTableButton Button3_1 = new TriangleTableButton(280, 290, 60, 60);
        table.add(Button3_1);
        
        TriangleTableButton Button3_2 = new TriangleTableButton(370, 290, 60, 60);
        table.add(Button3_2);
        
        TriangleTableButton Button3_3 = new TriangleTableButton(460, 290, 60, 60);
        table.add(Button3_3);
        
        TriangleTableButton Button4_1 = new TriangleTableButton(235, 370, 60, 60);
        table.add(Button4_1);
        
        TriangleTableButton Button4_2 = new TriangleTableButton(325, 370, 60, 60);
        table.add(Button4_2);
        
        TriangleTableButton Button4_3 = new TriangleTableButton(415, 370, 60, 60);
        table.add(Button4_3);
        
        TriangleTableButton Button4_4 = new TriangleTableButton(505, 370, 60, 60);
        table.add(Button4_4);
        
        TriangleTableButton Button5_1 = new TriangleTableButton(195, 450, 60, 60);
        table.add(Button5_1);
        
        TriangleTableButton Button5_2 = new TriangleTableButton(282, 450, 60, 60);
        table.add(Button5_2);
        
        TriangleTableButton Button5_3 = new TriangleTableButton(372, 450, 60, 60);
        table.add(Button5_3);
        
        TriangleTableButton Button5_4 = new TriangleTableButton(463, 450, 60, 60);
        table.add(Button5_4);
        
        TriangleTableButton Button5_5 = new TriangleTableButton(550, 450, 60, 60);
        table.add(Button5_5);
        
        TriangleTableButton Button6_1 = new TriangleTableButton(151, 530, 60, 60);
        table.add(Button6_1);
        
        TriangleTableButton Button6_2 = new TriangleTableButton(239, 530, 60, 60);
        table.add(Button6_2);
        
        TriangleTableButton Button6_3 = new TriangleTableButton(328, 530, 60, 60);
        table.add(Button6_3);
        
        TriangleTableButton Button6_4 = new TriangleTableButton(415, 530, 60, 60);
        table.add(Button6_4);
        
        TriangleTableButton Button6_5 = new TriangleTableButton(505, 530, 60, 60);
        table.add(Button6_5);
        
        TriangleTableButton Button6_6 = new TriangleTableButton(593, 530, 60, 60);
        table.add(Button6_6);
        
        TriangleTableButton Button7_1 = new TriangleTableButton(108, 610, 60, 60);
        table.add(Button7_1);
        
        TriangleTableButton Button7_2 = new TriangleTableButton(195, 610, 60, 60);
        table.add(Button7_2);
        
        TriangleTableButton Button7_3 = new TriangleTableButton(284, 610, 60, 60);
        table.add(Button7_3);
        
        TriangleTableButton Button7_4 = new TriangleTableButton(370, 610, 60, 60);
        table.add(Button7_4);
        
        TriangleTableButton Button7_5 = new TriangleTableButton(460, 610, 60, 60);
        table.add(Button7_5);
        
        TriangleTableButton Button7_6 = new TriangleTableButton(552, 610, 60, 60);
        table.add(Button7_6);
        
        TriangleTableButton Button7_7 = new TriangleTableButton(635, 610, 60, 60);
        table.add(Button7_7);
        
        
    }
    
    
    public static void main (String[] args) {
        //TriangleTable tri = new TriangleTable("#34ebcf");
        
        
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.getContentPane()
                .setLayout(new GridBagLayout());
        TriangleTableWithImg login = new TriangleTableWithImg();
        frame.getContentPane()
                .add(login);
        frame.setVisible(true);
        
        
    }
}
