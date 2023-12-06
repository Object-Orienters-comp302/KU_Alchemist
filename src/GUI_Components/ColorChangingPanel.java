package GUI_Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ColorChangingPanel extends JPanel {
    private Color defColor;
    private Color hoverColor;
    
    // Constructor that takes a Color parameter
    public ColorChangingPanel(Color defColor, Color hoverColor) {
        this.defColor   = defColor;
        this.hoverColor = hoverColor;
        
        this.addMouseListener(new ColorChangeListener(this, hoverColor, defColor));
        this.setBackground(defColor);
    }
    
    public ColorChangingPanel(String defColorHex, String hoverColorHex) {
        this.defColor   = Color.decode(defColorHex);
        this.hoverColor = Color.decode(hoverColorHex);
        
        this.addMouseListener(new ColorChangeListener(this, hoverColor, defColor));
        this.setBackground(defColor);
    }
    
    static class ColorChangeListener extends MouseAdapter {
        private final JPanel panel;
        private final Color  hoverColor;
        private final Color  originalColor;
        
        public ColorChangeListener(JPanel panel, Color hoverColor, Color originalColor) {
            this.panel         = panel;
            this.hoverColor    = hoverColor;
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
}