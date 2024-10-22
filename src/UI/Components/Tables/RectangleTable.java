package UI.Components.Tables;

import Utils.AssetLoader;

import javax.swing.*;

import UI.Components.ImagePanels.ImagePanel;

import java.awt.*;

public class RectangleTable extends JPanel {
    
    public RectangleTable(int[][] data) {
        setPreferredSize(new Dimension(600, 300));
        setBackground(Color.WHITE);
        setLayout(null);
        ImagePanel table = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.TriangleTable.RECTANGLE_TABLE));
        table.setLocation(0, 0);
        table.setSize(600, 300);
        add(table);
        RectangleTableButton.feedData(data);
        for (int row = 0; row <= 7; row++) {
            for (int col = 0; col <= 7; col++) {
                RectangleTableButton button = new RectangleTableButton(40 + col * 75, 62+row*30, 25, 25, col, row);
                table.add(button);
                setComponentZOrder(button, 0);
            }
        }
        /*
        for (int i = 0; i <= 7; i++) {
            RectangleTableButton button = new RectangleTableButton(40 + i * 75, 92, 25, 25, i, data[1]);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
        for (int i = 0; i <= 7; i++) {
            RectangleTableButton button = new RectangleTableButton(40 + i * 75, 122, 25, 25, i, data[2]);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
        for (int i = 0; i <= 7; i++) {
            RectangleTableButton button = new RectangleTableButton(40 + i * 75, 152, 25, 25, i, data[3]);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
        for (int i = 0; i <= 7; i++) {
            RectangleTableButton button = new RectangleTableButton(40 + i * 75, 182, 25, 25, i, data[4]);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
        for (int i = 0; i <= 7; i++) {
            RectangleTableButton button = new RectangleTableButton(40 + i * 75, 213, 25, 25, i, data[5]);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
        for (int i = 0; i <= 7; i++) {
            RectangleTableButton button = new RectangleTableButton(40 + i * 75, 242, 25, 25, i, data[6]);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        
        for (int i = 0; i <= 7; i++) {
            RectangleTableButton button = new RectangleTableButton(40 + i * 75, 272, 25, 25, i, data[7]);
            table.add(button);
            setComponentZOrder(button, 0);
        }
        *
         */
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
    
    public void feedData(int[][] dat){
        RectangleTableButton.feedData(dat);
    }
    public void reset(){
        RectangleTableButton.rebuild();
    }
    
    
    public static void main(String[] args) {
        //TriangleTable tri = new TriangleTable("#34ebcf");
        
        int[][] testArr = new int[8][8];
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.getContentPane().setLayout(new GridBagLayout());
        RectangleTable login = new RectangleTable(testArr);
        frame.getContentPane().add(login);
        frame.setVisible(true);
        
        
    }
    
}
