package GUI_Components;

import javax.swing.*;
import java.awt.*;

public class TriangleTable extends JPanel {
    String TriColor;

    public TriangleTable(String col) {
        setPreferredSize(new Dimension(800, 400));
        setBackground(Color.RED);
        setLayout(null);

        JPanel MainPanel = new JPanel();
        MainPanel.setBounds(0, 0, 800, 400);
        add(MainPanel);
        MainPanel.setLayout(null);

        JPanel Tri1 = new TrianglePanel(Color.BLUE);
        Tri1.setBounds(0, 0, 800, 400);
        Tri1.setLayout(null);
        MainPanel.add(Tri1);

        TrianglePanel Tri2 = new TrianglePanel(Color.RED);
        Tri2.setLayout(null);
        Tri2.setBounds(100, 50, 700, 350);
        Tri2.setOpaque(false);
        Tri1.add(Tri2);

        TrianglePanel Tri3 = new TrianglePanel(Color.BLUE);
        Tri3.setLayout(null);
        Tri3.setOpaque(false);
        Tri3.setBounds(100, 50, 600, 300);
        Tri2.add(Tri3);
    }


    public static void main(String[] args) {

        JFrame frame = new JFrame("Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().setLayout(new GridBagLayout());
        TriangleTable tri = new TriangleTable("#34ebcf");
        frame.getContentPane().add(tri);
        frame.setVisible(true);
    }
}
