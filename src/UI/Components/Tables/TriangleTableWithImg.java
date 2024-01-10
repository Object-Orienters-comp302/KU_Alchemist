package UI.Components.Tables;

import Utils.AssetLoader;

import javax.swing.*;

import UI.Components.ImagePanels.ImagePanel;

import java.awt.*;

public class TriangleTableWithImg extends JPanel {
    
    public TriangleTableWithImg(int[] data) {
        setPreferredSize(new Dimension(425, 425));
        setOpaque(false);
        setLayout(null);
        ImagePanel table = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.TriangleTable.TRIANGLE_TABLE));
        table.setLocation(0, 0);
        table.setSize(400, 400);
        add(table);
        table.setLayout(null);
        TriangleTableButton.feedData(data);
        TriangleTableButton Button1_1 = new TriangleTableButton(185, 65, 30, 30, 0);
        TriangleTableButton Button2_1 = new TriangleTableButton(162, 105, 30, 30, 1);
        TriangleTableButton Button2_2 = new TriangleTableButton(208, 105, 30, 30, 2);
        TriangleTableButton Button3_1 = new TriangleTableButton(140, 145, 30, 30, 3);
        TriangleTableButton Button3_2 = new TriangleTableButton(185, 145, 30, 30, 4);
        TriangleTableButton Button3_3 = new TriangleTableButton(230, 145, 30, 30, 5);
        TriangleTableButton Button4_1 = new TriangleTableButton(120, 185, 30, 30, 6);
        TriangleTableButton Button4_2 = new TriangleTableButton(165, 185, 30, 30, 7);
        TriangleTableButton Button4_3 = new TriangleTableButton(207, 185, 30, 30, 8);
        TriangleTableButton Button4_4 = new TriangleTableButton(250, 185, 30, 30, 9);
        TriangleTableButton Button5_1 = new TriangleTableButton(97, 225, 30, 30, 10);
        TriangleTableButton Button5_2 = new TriangleTableButton(142, 225, 30, 30, 11);
        TriangleTableButton Button5_3 = new TriangleTableButton(185, 225, 30, 30, 12);
        TriangleTableButton Button5_4 = new TriangleTableButton(230, 225, 30, 30, 13);
        TriangleTableButton Button5_5 = new TriangleTableButton(272, 225, 30, 30, 14);
        TriangleTableButton Button6_1 = new TriangleTableButton(75, 265, 30, 30, 15);
        TriangleTableButton Button6_2 = new TriangleTableButton(120, 265, 30, 30, 16);
        TriangleTableButton Button6_3 = new TriangleTableButton(163, 265, 30, 30, 17);
        TriangleTableButton Button6_4 = new TriangleTableButton(208, 265, 30, 30, 18);
        TriangleTableButton Button6_5 = new TriangleTableButton(252, 265, 30, 30, 19);
        TriangleTableButton Button6_6 = new TriangleTableButton(295, 265, 30, 30, 20);
        TriangleTableButton Button7_1 = new TriangleTableButton(53, 305, 30, 30, 21);
        TriangleTableButton Button7_2 = new TriangleTableButton(97, 305, 30, 30, 22);
        TriangleTableButton Button7_3 = new TriangleTableButton(142, 305, 30, 30, 23);
        TriangleTableButton Button7_4 = new TriangleTableButton(186, 305, 30, 30, 24);
        TriangleTableButton Button7_5 = new TriangleTableButton(230, 305, 30, 30, 25);
        TriangleTableButton Button7_6 = new TriangleTableButton(275, 305, 30, 30, 26);
        TriangleTableButton Button7_7 = new TriangleTableButton(318, 305, 30, 30, 27);
        
        table.add(Button1_1);
        table.add(Button2_1);
        table.add(Button2_2);
        table.add(Button3_1);
        table.add(Button3_2);
        table.add(Button3_3);
        table.add(Button4_1);
        table.add(Button4_2);
        table.add(Button4_3);
        table.add(Button4_4);
        table.add(Button5_1);
        table.add(Button5_2);
        table.add(Button5_3);
        table.add(Button5_4);
        table.add(Button5_5);
        table.add(Button6_1);
        table.add(Button6_2);
        table.add(Button6_3);
        table.add(Button6_4);
        table.add(Button6_5);
        table.add(Button6_6);
        table.add(Button7_1);
        table.add(Button7_2);
        table.add(Button7_3);
        table.add(Button7_4);
        table.add(Button7_5);
        table.add(Button7_6);
        table.add(Button7_7);
        
        
    }
    public void feedData(int[] dat){
        TriangleTableButton.feedData(dat);
    }
    public void reset(){
        TriangleTableButton.rebuild();
    }
    
    public static void main(String[] args) {
        //TriangleTable tri = new TriangleTable("#34ebcf");
        
        int[] testArray = new int[28];
        testArray[1] = 2;
        
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().setLayout(new GridBagLayout());
        TriangleTableWithImg login = new TriangleTableWithImg(testArray);
        frame.getContentPane().add(login);
        frame.setVisible(true);
        
        
    }
}
