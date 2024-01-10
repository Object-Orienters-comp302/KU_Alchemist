package UI.Components.Tables;

import Utils.AssetLoader;

import javax.swing.*;

import UI.Components.ImagePanels.ImagePanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RectangleTableButton extends JPanel {
    private ImagePanel img;
    private int        state;
    private static RectangleTableButton[][] list=new RectangleTableButton[8][8];
    private static int[][] data;
    
    
    public RectangleTableButton(int x, int y, int width, int height, int column, int row) {
        setLayout(null);
        setBounds(x, y, width, height);
        list[row][column] = this;
        img = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.TriangleTable.QUESTION_MARK_WHITE));
        img.setBounds(0, 0, width, height);
        setOpaque(false);
        this.add(img);
        state = data[row][column];
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (state == 0) {
                    img.changeImage(AssetLoader.getAssetPath(AssetLoader.Tokens.GREEN_TICK));
                    state       = 1;
                    data[row][column]=1;
                } else if (state == 1) {
                    img.changeImage(AssetLoader.getAssetPath(AssetLoader.Tokens.RED_X));
                    state       = 2;
                    data[row][column]=2;
                } else if (state == 2) {
                    img.changeImage(AssetLoader.getAssetPath(AssetLoader.TriangleTable.QUESTION_MARK_WHITE));
                    state       = 0;
                    data[row][column]=0;
                }
            }
        });
    }
    
    public static void rebuild(){
        for (int row = 0; row <= 7; row++) {
            for (int col = 0; col <= 7; col++) {
                list[row][col].img.changeImage(chooseImg(data[row][col]));
            }
        }
    }
    
    public static AssetLoader.AssetPath chooseImg(int val) {
        AssetLoader.AssetPath path=AssetLoader.TriangleTable.QUESTION_MARK_WHITE;
        switch (val) {
            case 0:
                path = AssetLoader.TriangleTable.QUESTION_MARK_WHITE;
                break;
            case 1:
                path = AssetLoader.Tokens.GREEN_TICK;
                break;
            case 2:
                path = AssetLoader.Tokens.RED_X;
                break;
        }
        return path;
    }
    
    public static void feedData(int[][] dat){
        data=dat;
    }
    
    
    public static void main(String[] args) {
        //TriangleTable tri = new TriangleTable("#34ebcf");
        
        
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.getContentPane().setLayout(new GridBagLayout());
        /*RectangleTableButton login = new RectangleTableButton(0, 0, 200, 200);
        frame.getContentPane()
                .add(login);
                */
        frame.setVisible(true);
        
        
    }
}
