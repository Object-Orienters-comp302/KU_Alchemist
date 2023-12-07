package GUI_Components_Potion;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI_Components.ImagePanel;
import Models.Ingredient;
import Models.Potion;
import Utils.AssetLoader;

public class PotionButton extends JPanel {
    ImagePanel img;
    boolean    transparent = false;
    private int                   diameter;
    private int                   x;
    private int                   y;
    private AssetLoader.AssetPath currentPotion;
    
    
    public PotionButton(int x, int y, int width, int height) {
        this.setOpaque(false);
        setLayout(null);
        this.setBounds(x, y, width, height);
        currentPotion = AssetLoader.TriangleTable.QUESTION_MARK;
        img               = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.TriangleTable.QUESTION_MARK));
        img.setBounds(width * 9 / 40, width * 9 / 40, width * 9 / 16, height * 9 / 16);
        add(img);
        
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clickX = e.getX();
                int clickY = e.getY();
                //Rectangle bounds = getBounds();
                
                if (isClickInsideCircle(clickX, clickY)) {
                    //System.out.println("Button click inside the circle!");
                    PotionButtonPopup pop =
                            new PotionButtonPopup(x - width / 2, y - height / 2, width * 2, height * 2, img,
                            		PotionButton.this);
                    Container parent = getParent();
                    parent.add(pop);
                    parent.setComponentZOrder(pop, 1);
                    
                    parent.repaint();
                    
                } else {
                    System.out.println("Button click outside the circle.");
                    System.out.print(getBounds());
                }
            }
        });
        
        
    }
    
    private boolean isClickInsideCircle(int clickX, int clickY) {
        int radius = diameter / 2;
        int centerX = x + radius;
        int centerY = y + radius;
        
        double distance = Math.sqrt(Math.pow(clickX - centerX, 2) + Math.pow(clickY - centerY, 2));
        
        return distance <= radius;
    }
    
    public PotionButton(int x, int y, int width, int height, boolean transparent) {
        this.setOpaque(false);
        setLayout(null);
        this.setBounds(x, y, width, height);
        AssetLoader.AssetPath currentValue = AssetLoader.TriangleTable.QUESTION_MARK;
        img = new ImagePanel(AssetLoader.getAssetPath(currentValue));
        img.setBounds(width * 9 / 40, width * 9 / 40, width * 9 / 16, height * 9 / 16);
        add(img);
        this.transparent = transparent;
        
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clickX = e.getX();
                int clickY = e.getY();
                //Rectangle bounds = getBounds();
                
                if (isClickInsideCircle(clickX, clickY)) {
                    //System.out.println("Button click inside the circle!");
                    PotionButtonPopup pop =
                            new PotionButtonPopup(x - width / 2, y - height / 2, width * 2, height * 2, img,
                            		PotionButton.this);
                    Container parent = getParent();
                    parent.add(pop);
                    parent.setComponentZOrder(pop, 1);
                    
                    parent.repaint();
                    
                } else {
                    System.out.println("Button click outside the circle.");
                    System.out.print(getBounds());
                }
            }
        });
        
        
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int originalDiameter = Math.min(getWidth(), getHeight());
        int customDiameter = originalDiameter * 3 / 4;
        
        int x = (getWidth() - customDiameter) / 2;
        int y = (getHeight() - customDiameter) / 2;
        diameter = originalDiameter;
        if (!this.transparent) {
            g.setColor(Color.decode("#ebd2a9"));
            g.fillOval(x, y, customDiameter, customDiameter);
        }
    }
    
    public AssetLoader.AssetPath getCurrentIngredient() {
        return currentPotion;
    }
    
    public void setCurrentIngredient(AssetLoader.AssetPath val) {
        currentPotion = val;
    }
    
    public Potion.Identity getType() {
        return switch (currentPotion) {
        case AssetLoader.Potions.BLUENEGATIVE -> Potion.Identity.BLUENEGATIVE;
        case AssetLoader.Potions.BLUEPOSITIVE -> Potion.Identity.BLUEPOSITIVE;
        case AssetLoader.Potions.REDNEGATIVE -> Potion.Identity.REDNEGATIVE;
        case AssetLoader.Potions.REDPOSITIVE -> Potion.Identity.REDPOSITIVE;
        case AssetLoader.Potions.GREENNEGATIVE -> Potion.Identity.GREENNEGATIVE;
        case AssetLoader.Potions.GREENPOSITIVE -> Potion.Identity.GREENPOSITIVE;
        case AssetLoader.Potions.NETURAL -> Potion.Identity.NETURAL;
        case AssetLoader.Potions.UNKNOWN -> Potion.Identity.UNKNOWN;
            default -> throw new IllegalStateException("Unexpected value: " + currentPotion);
        };
    }
}