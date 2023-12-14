package UI.Components.Tables;

import Utils.AssetLoader;

import javax.swing.*;

import UI.Components.ImagePanels.ImagePanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RectangleTableButton extends JPanel {
    private ImagePanel img;
    private int        state;
    
    
    public RectangleTableButton(int x, int y, int width, int height, int index, int[] data) {
        setLayout(null);
        setBounds(x, y, width, height);
        img = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.TriangleTable.QUESTION_MARK_WHITE));
        img.setBounds(0, 0, width, height);
        setOpaque(false);
        this.add(img);
        state = data[index];
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (state == 0) {
                    img.changeImage(AssetLoader.getAssetPath(AssetLoader.Tokens.GREEN_TICK));
                    state       = 1;
                    data[index] = 1;
                } else if (state == 1) {
                    img.changeImage(AssetLoader.getAssetPath(AssetLoader.Tokens.RED_X));
                    state       = 2;
                    data[index] = 2;
                } else if (state == 2) {
                    img.changeImage(AssetLoader.getAssetPath(AssetLoader.TriangleTable.QUESTION_MARK_WHITE));
                    state       = 0;
                    data[index] = 3;
                }
            }
        });
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
