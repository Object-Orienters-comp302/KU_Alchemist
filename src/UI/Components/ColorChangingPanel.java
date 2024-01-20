package UI.Components;

import Sound.DJ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;

public class ColorChangingPanel extends JPanel {
    private Color         defColor;
    private Color         hoverColor;
    private int           cornerRadius;
    private RoundingStyle roundingStyle;
    
    // Constructor that takes color hex strings, corner radius, and rounding style
    public ColorChangingPanel(String defColorHex, String hoverColorHex, int cornerRadius, RoundingStyle roundingStyle) {
        this(Color.decode(defColorHex), Color.decode(hoverColorHex), cornerRadius, roundingStyle);
    }
    
    // Constructor that takes Color parameters, corner radius, and rounding style
    public ColorChangingPanel(Color defColor, Color hoverColor, int cornerRadius, RoundingStyle roundingStyle) {
        this.defColor      = defColor;
        this.hoverColor    = hoverColor;
        this.cornerRadius  = cornerRadius;
        this.roundingStyle = roundingStyle;
        
        this.addMouseListener(new ColorChangeListener(this, hoverColor, defColor));
        this.setBackground(defColor);
    }
    
    public ColorChangingPanel(String defColorHex, String hoverColorHex) {
        this(Color.decode(defColorHex), Color.decode(hoverColorHex), 10, RoundingStyle.BOTH);
    }
    
    public void changeColors(String def,String hover){
        defColor=Color.decode(def);
        hoverColor=Color.decode(hover);
        this.addMouseListener(new ColorChangeListener(this, hoverColor, defColor));
        this.setBackground(defColor);
        repaint();
    }
    public void changeHoverColor(String hover){
        hoverColor=Color.decode(hover);
        this.addMouseListener(new ColorChangeListener(this, hoverColor, defColor));
        this.setBackground(defColor);
        repaint();
    }
    public void changeDefaultColors(String def){
        defColor=Color.decode(def);
        this.addMouseListener(new ColorChangeListener(this, hoverColor, defColor));
        this.setBackground(defColor);
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        
        // Enable anti-aliasing for smoother corners
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Custom shape based on rounding style
        Path2D.Float path = new Path2D.Float();
        switch (roundingStyle) {
            case LEFT:
                drawLeftRounded(path);
                break;
            case RIGHT:
                drawRightRounded(path);
                break;
            case BOTH:
                drawBothRounded(path);
                break;
            case NONE:
                drawNoRounded(path);
                break;
        }
        
        // Draw the custom shape with the panel's background color
        g2d.setColor(getBackground());
        g2d.fill(path);
        g2d.dispose();
    }
    
    private void drawLeftRounded(Path2D.Float path) {
        path.moveTo(cornerRadius, 0);
        path.lineTo(getWidth(), 0);
        path.lineTo(getWidth(), getHeight());
        path.lineTo(cornerRadius, getHeight());
        path.curveTo(cornerRadius, getHeight(), 0, getHeight(), 0, getHeight() - cornerRadius);
        path.lineTo(0, cornerRadius);
        path.curveTo(0, cornerRadius, 0, 0, cornerRadius, 0);
        path.closePath();
    }
    
    private void drawRightRounded(Path2D.Float path) {
        path.moveTo(0, 0);
        path.lineTo(getWidth() - cornerRadius, 0);
        path.curveTo(getWidth() - cornerRadius, 0, getWidth(), 0, getWidth(), cornerRadius);
        path.lineTo(getWidth(), getHeight() - cornerRadius);
        path.curveTo(getWidth(), getHeight() - cornerRadius, getWidth(), getHeight(), getWidth() - cornerRadius,
                     getHeight());
        path.lineTo(0, getHeight());
        path.closePath();
    }
    
    private void drawBothRounded(Path2D.Float path) {
        float width = getWidth();
        float height = getHeight();
        float radiusPercentage = ((float) cornerRadius / 100) * Math.min(width, height);
        
        // Top-left corner
        path.moveTo(0, radiusPercentage);
        path.quadTo(0, 0, radiusPercentage, 0);
        
        // Top-right corner
        path.lineTo(width - radiusPercentage, 0);
        path.quadTo(width, 0, width, radiusPercentage);
        
        // Bottom-right corner
        path.lineTo(width, height - radiusPercentage);
        path.quadTo(width, height, width - radiusPercentage, height);
        
        // Bottom-left corner
        path.lineTo(radiusPercentage, height);
        path.quadTo(0, height, 0, height - radiusPercentage);
        
        path.closePath();
    }
    
    private void drawNoRounded(Path2D.Float path) {
        path.moveTo(0, 0);
        path.lineTo(getWidth(), 0);
        path.lineTo(getWidth(), getHeight());
        path.lineTo(0, getHeight());
        path.closePath();
    }
    
    @Override
    public boolean isOpaque() {
        return false;
    }
    
    public void addTheEnterSound(){
        this.removeMouseListener(this.getMouseListeners()[0]);
        this.addMouseListener(new ColorChangeListener(this, hoverColor, defColor,true));
    }
    
    // Enum for specifying the rounding style
    public enum RoundingStyle {
        LEFT,
        RIGHT,
        BOTH,
        NONE
    }
    
    static class ColorChangeListener extends MouseAdapter {
        private final JPanel panel;
        private final Color  hoverColor;
        private final Color  originalColor;
        private boolean hasEnterSound=false;
        
        public ColorChangeListener(JPanel panel, Color hoverColor, Color originalColor) {
            this.panel         = panel;
            this.hoverColor    = hoverColor;
            this.originalColor = originalColor;
        }
        public ColorChangeListener(JPanel panel, Color hoverColor, Color originalColor,boolean hasSound) {
            this.panel         = panel;
            this.hoverColor    = hoverColor;
            this.originalColor = originalColor;
            this.hasEnterSound=hasSound;
        }
        
        @Override
        public void mouseEntered(MouseEvent e) {
            panel.setBackground(hoverColor);
            if (hasEnterSound){
                DJ.getDJ().setAndStartEffectSound(DJ.EffectSounds.BUTTON,1000);
            }
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
            panel.setBackground(originalColor);
        }
    }
}
