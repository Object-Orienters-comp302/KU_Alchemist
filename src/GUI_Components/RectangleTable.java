package GUI_Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class RectangleTable extends JPanel {
    
    public RectangleTable (int[][] data) {
        setPreferredSize(new Dimension(800, 400));
        setBackground(Color.WHITE);
        setLayout(null);
        ImagePanel table = new ImagePanel(".//Images//triangleTable//RectangleTable.png");
        table.setLocation(0, 0);
        table.setSize(800, 400);
        add(table);
        
        for (int i = 0; i <= 7; i++) {
            RectangleTableButton button = new RectangleTableButton(60 + i * 100, 82, 35, 35,i, data[0]);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
        for (int i = 0; i <= 7; i++) {
            RectangleTableButton button = new RectangleTableButton(60 + i * 100, 122, 35, 35,i,data[1]);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
        for (int i = 0; i <= 7; i++) {
            RectangleTableButton button = new RectangleTableButton(60 + i * 100, 162, 35, 35,i,data[2]);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
        for (int i = 0; i <= 7; i++) {
            RectangleTableButton button = new RectangleTableButton(60 + i * 100, 202, 35, 35,i,data[3]);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
        for (int i = 0; i <= 7; i++) {
            RectangleTableButton button = new RectangleTableButton(60 + i * 100, 242, 35, 35,i,data[4]);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
        for (int i = 0; i <= 7; i++) {
            RectangleTableButton button = new RectangleTableButton(60 + i * 100, 282, 35, 35,i,data[5]);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
        for (int i = 0; i <= 7; i++) {
            RectangleTableButton button = new RectangleTableButton(60 + i * 100, 322, 35, 35,i,data[6]);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
        for (int i = 0; i <= 7; i++) {
            RectangleTableButton button = new RectangleTableButton(60 + i * 100, 362, 35, 35,i,data[7]);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        /*   // testing purposes
        Button but=new Button();
        but.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		System.out.print(Arrays.deepToString(data));
        	}
        });
        but.setBounds(100, 100, 50, 50);
        but.setBackground(Color.red);
        this.setComponentZOrder(but, 1);
        table.add(but);
        */
        
    }
    
    public static void main (String[] args) {
        //TriangleTable tri = new TriangleTable("#34ebcf");
        
    	int[][] testArr= new int[8][8];
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.getContentPane()
                .setLayout(new GridBagLayout());
        RectangleTable login = new RectangleTable(testArr);
        frame.getContentPane()
                .add(login);
        frame.setVisible(true);
        
        
    }
    
}
