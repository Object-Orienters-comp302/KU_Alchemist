package GUI_Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class TriangleTableWithImg extends JPanel {
    
    public TriangleTableWithImg (int[] data) {
        setPreferredSize(new Dimension(900, 900));
        setBackground(Color.WHITE);
        setLayout(null);
        ImagePanel table = new ImagePanel(".//Images//triangleTable//TriangleTable.png");
        table.setLocation(50, 50);
        table.setSize(800, 800);
        add(table);
        table.setLayout(null);
        
        /*   For testing delete after finishing connections
        Button Button = new Button();
        Button.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		System.out.print(Arrays.toString(data));
        	}
        });
        
        
        Button.setBounds(10, 10, 100, 100);
        table.add(Button);
        */
        
        
        ///Buttons           271 70   233,145
        TriangleTableButton Button1_1 = new TriangleTableButton(370, 130, 60, 60,0,data);
        table.add(Button1_1);
        
        TriangleTableButton Button2_1 = new TriangleTableButton(325, 210, 60, 60,1,data);
        table.add(Button2_1);
        
        TriangleTableButton Button2_2 = new TriangleTableButton(415, 210, 60, 60,2,data);
        table.add(Button2_2);
        
        TriangleTableButton Button3_1 = new TriangleTableButton(280, 290, 60, 60,3,data);
        table.add(Button3_1);
        
        TriangleTableButton Button3_2 = new TriangleTableButton(370, 290, 60, 60,4,data);
        table.add(Button3_2);
        
        TriangleTableButton Button3_3 = new TriangleTableButton(460, 290, 60, 60,5,data);
        table.add(Button3_3);
        
        TriangleTableButton Button4_1 = new TriangleTableButton(235, 370, 60, 60,6,data);
        table.add(Button4_1);
        
        TriangleTableButton Button4_2 = new TriangleTableButton(325, 370, 60, 60,7,data);
        table.add(Button4_2);
        
        TriangleTableButton Button4_3 = new TriangleTableButton(415, 370, 60, 60,8,data);
        table.add(Button4_3);
        
        TriangleTableButton Button4_4 = new TriangleTableButton(505, 370, 60, 60,9,data);
        table.add(Button4_4);
        
        TriangleTableButton Button5_1 = new TriangleTableButton(195, 450, 60, 60,10,data);
        table.add(Button5_1);
        
        TriangleTableButton Button5_2 = new TriangleTableButton(282, 450, 60, 60,11,data);
        table.add(Button5_2);
        
        TriangleTableButton Button5_3 = new TriangleTableButton(372, 450, 60, 60,12,data);
        table.add(Button5_3);
        
        TriangleTableButton Button5_4 = new TriangleTableButton(463, 450, 60, 60,13,data);
        table.add(Button5_4);
        
        TriangleTableButton Button5_5 = new TriangleTableButton(550, 450, 60, 60,14,data);
        table.add(Button5_5);
        
        TriangleTableButton Button6_1 = new TriangleTableButton(151, 530, 60, 60,15,data);
        table.add(Button6_1);
        
        TriangleTableButton Button6_2 = new TriangleTableButton(239, 530, 60, 60,16,data);
        table.add(Button6_2);
        
        TriangleTableButton Button6_3 = new TriangleTableButton(328, 530, 60, 60,17,data);
        table.add(Button6_3);
        
        TriangleTableButton Button6_4 = new TriangleTableButton(415, 530, 60, 60,18,data);
        table.add(Button6_4);
        
        TriangleTableButton Button6_5 = new TriangleTableButton(505, 530, 60, 60,19,data);
        table.add(Button6_5);
        
        TriangleTableButton Button6_6 = new TriangleTableButton(593, 530, 60, 60,20,data);
        table.add(Button6_6);
        
        TriangleTableButton Button7_1 = new TriangleTableButton(108, 610, 60, 60,21,data);
        table.add(Button7_1);
        
        TriangleTableButton Button7_2 = new TriangleTableButton(195, 610, 60, 60,22,data);
        table.add(Button7_2);
        
        TriangleTableButton Button7_3 = new TriangleTableButton(284, 610, 60, 60,23,data);
        table.add(Button7_3);
        
        TriangleTableButton Button7_4 = new TriangleTableButton(370, 610, 60, 60,24,data);
        table.add(Button7_4);
        
        TriangleTableButton Button7_5 = new TriangleTableButton(460, 610, 60, 60,25,data);
        table.add(Button7_5);
        
        TriangleTableButton Button7_6 = new TriangleTableButton(552, 610, 60, 60,26,data);
        table.add(Button7_6);
        
        TriangleTableButton Button7_7 = new TriangleTableButton(635, 610, 60, 60,27,data);
        table.add(Button7_7);
        
        
    }
    
    
    public static void main (String[] args) {
        //TriangleTable tri = new TriangleTable("#34ebcf");
        
    	int[] testArray = new int[28];
    	testArray[1]=2;
        
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.getContentPane()
                .setLayout(new GridBagLayout());
        TriangleTableWithImg login = new TriangleTableWithImg(testArray);
        frame.getContentPane()
                .add(login);
        frame.setVisible(true);
        
        
    }
}
