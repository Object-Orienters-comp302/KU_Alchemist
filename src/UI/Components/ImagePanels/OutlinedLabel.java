package UI.Components.ImagePanels;

import javax.swing.*;
import java.awt.*;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

public class OutlinedLabel extends JLabel {
    private Color textColor;
    private Color outlineColor;
    private Versions version;
    private int offset=1;
    
    public OutlinedLabel(String text, Color textColor, Color outlineColor) {
        super(text);
        this.textColor    = textColor;
        this.outlineColor = outlineColor;
        version= Versions.MULTILINE;
    }
    public OutlinedLabel(String text, String textColor, String outlineColor) {
        super(text);
        this.textColor    = Color.decode(textColor);
        this.outlineColor = Color.decode(outlineColor);
        version=Versions.MULTILINE;
    }
    public OutlinedLabel(String text, String textColor, String outlineColor,Versions vers) {
        super(text);
        this.textColor    = Color.decode(textColor);
        this.outlineColor = Color.decode(outlineColor);
        version=vers;
    }
    
    public void changeFontStyle(int style ){
        this.setFont(new Font(this.getFont().getFontName(), style, this.getFont().getSize()));
    }
    public void changeFontSize(int size ){
        this.setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), size));
    }
    public void changeFontName(String name ){
        this.setFont(new Font(name, this.getFont().getStyle(), this.getFont().getSize()));
    }
    public void changeOffset(int i){
        offset=i;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        if (version==Versions.MULTILINE) {
            Graphics2D g2d = (Graphics2D) g.create();
            
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            
            FontMetrics fm = g2d.getFontMetrics(getFont());
            int x = 1;
            int y = fm.getAscent(); // Adjusted to align text to the top
            
            // Use TextLayout for accurate rendering
            AttributedString attributedString = new AttributedString(getText());
            attributedString.addAttribute(TextAttribute.FONT, getFont());
            AttributedCharacterIterator charIterator = attributedString.getIterator();
            LineBreakMeasurer lineBreakMeasurer = new LineBreakMeasurer(charIterator, g2d.getFontRenderContext());
            
            // Draw each line
            while (lineBreakMeasurer.getPosition() < charIterator.getEndIndex()) {
                int nextLine = lineBreakMeasurer.nextOffset(getWidth());
                String line = getText().substring(lineBreakMeasurer.getPosition(), nextLine);
                
                // Draw the outline
                g2d.setColor(outlineColor);
                g2d.drawString(line, x, y);
                
                // Draw the text on top of the outline
                g2d.setColor(textColor);
                g2d.drawString(line, x - offset, y - offset); // Adjusted to align text to the top
                
                y += fm.getHeight(); // Move to the next line
                lineBreakMeasurer.setPosition(nextLine);
            }
            
            g2d.dispose();
        }
        else if (version == Versions.MID_ORIENTED) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            
            FontMetrics fm = g2d.getFontMetrics(getFont());
            
            // Calculate the maximum font size that fits the label width
            int maxSize = (int) (getWidth() * 0.8); // Adjust as needed
            int fontSize = getFont().getSize();
            
            while (fm.stringWidth(getText()) > getWidth() && fontSize > 1) {
                fontSize--;
                setFont(new Font(getFont().getFontName(), getFont().getStyle(), fontSize));
                fm = g2d.getFontMetrics(getFont());
            }
            
            // Calculate the x and y coordinates to center the text horizontally and vertically
            int x = (getWidth() - fm.stringWidth(getText())) / 2;
            int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
            
            // Draw the outline
            g2d.setColor(outlineColor);
            g2d.drawString(getText(), x, y);
            
            // Draw the text on top of the outline
            g2d.setColor(textColor);
            g2d.drawString(getText(), x - offset, y - offset);
            
            g2d.dispose();
        }
    }
    
    public enum Versions {
        MULTILINE,
        MID_ORIENTED
        
    }
    
    public static void main(String[] args) {
        // Get the local graphics environment
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        // Get the array of font names
        String[] fontNames = ge.getAvailableFontFamilyNames();
        
        // Display the list of font names
        System.out.println("Available Fonts:");
        for (String fontName : fontNames) {
            System.out.println(fontName);
        }
        
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Outlined Text JLabel Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            OutlinedLabel outlinedLabel = new OutlinedLabel("Hello, Swing!", "#fffff", "#00000",Versions.MID_ORIENTED);
            outlinedLabel.setFont(new Font("Arial", Font.BOLD, 20));
            outlinedLabel.changeOffset(2);
            // Set the size and position of the JLabel
            outlinedLabel.setBounds(10, 10, 200, 50);
            
            // Use a layout manager to avoid manual layout calculations
            frame.setLayout(new BorderLayout());
            frame.add(outlinedLabel, BorderLayout.CENTER);
            
            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
    
}

