package GUI_Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RectangleTableButton extends JPanel {
    private ImagePanel img;
    private int        state;
    
    
    public RectangleTableButton(int x, int y, int width, int height, int index, int[] data) {
        setLayout(null);
        setBounds(x, y, width, height);
        img = new ImagePanel(".//Images//triangleTable//questionMarkWhite.png");
        img.setBounds(0, 0, width, height);
        setOpaque(false);
        this.add(img);
        state = data[index];
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (state == 0) {
                    img.changeImage(".//Images//tokens//greenTick.png");
                    state       = 1;
                    data[index] = 1;
                } else if (state == 1) {
                    img.changeImage(".//Images//tokens//redX.png");
                    state       = 2;
                    data[index] = 2;
                } else if (state == 2) {
                    img.changeImage(".//Images//triangleTable//questionMarkWhite.png");
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
