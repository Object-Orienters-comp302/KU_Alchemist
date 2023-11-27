package GUI_Components;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class ColorChangingPanel extends JPanel {
	private Color defColor;//TODO: can be changed to hexcode later
	private Color hoverColor;//TODO: can be changed to hexcode later

    // Constructor that takes a Color parameter
    public ColorChangingPanel(Color defColor, Color hoverColor) {
        this.defColor = defColor;
        this.hoverColor = hoverColor;
        this.addMouseListener(new ColorChangeListener(this, hoverColor,defColor ));
        this.setBackground(defColor);
    }
    
    public ColorChangingPanel(String defColorHex, String hoverColorHex) {
        this.defColor = Color.decode(defColorHex);
        this.hoverColor = Color.decode(hoverColorHex);

        this.addMouseListener(new ColorChangeListener(this, hoverColor, defColor));
        this.setBackground(defColor);
    }

    static class ColorChangeListener extends MouseAdapter {
        private final JPanel panel;
        private final Color hoverColor;
        private final Color originalColor;

        public ColorChangeListener(JPanel panel, Color hoverColor, Color originalColor) {
            this.panel = panel;
            this.hoverColor = hoverColor;
            this.originalColor = originalColor;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            panel.setBackground(hoverColor);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            panel.setBackground(originalColor);
        }
            
    }
    
    
    
    
    
    public static void main(String[] args) {

		JFrame frame = new JFrame("Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().setLayout(new GridBagLayout());
        ColorChangingPanel tri = new ColorChangingPanel(Color.red,Color.black);
        frame.getContentPane().add(tri);
        frame.setVisible(true);
	}
    

    
}