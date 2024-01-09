package UI.Components.Potion;

import Models.Potion;
import UI.Components.ImagePanels.GifPanel;
import UI.Components.ImagePanels.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PotionButton extends GifPanel {
    ImagePanel img;
    boolean    transparent = false;
    private int                   diameter;
    private int                   x;
    private int                   y;
    private AssetLoader.AssetPath currentPotion;
    
    
    public PotionButton(int x, int y, int width, int height) {
        super(x, y, width, height,AssetLoader.Gifs.FIREBALL.getPath());
        setLayout(null);
        diameter=Integer.min(height,width);
        currentPotion = AssetLoader.TriangleTable.QUESTION_MARK;
        img           = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.TriangleTable.QUESTION_MARK));
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
                    parent.setComponentZOrder(pop, 0);
                    parent.setComponentZOrder(PotionButton.this, 1);
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
        super(x, y, width, height,AssetLoader.getAssetPath(AssetLoader.Gifs.FIREBALL));
        setLayout(null);
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
                    parent.setComponentZOrder(pop, 0);
                    parent.setComponentZOrder(PotionButton.this, 1);
                    parent.repaint();
                    
                } else {
                    System.out.println("Button click outside the circle.");
                    System.out.print(getBounds());
                }
            }
        });
        
        
    }
    
    /*
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
    */
    public AssetLoader.AssetPath getCurrentIngredient() {
        return currentPotion;
    }
    
    public void setCurrentPotionPath(AssetLoader.AssetPath val) {
        currentPotion = val;
    }
    
    public AssetLoader.AssetPath getCurrentPotionPath(){
        return currentPotion;
    }
    
    public void reset(){
        this.setCurrentPotionPath(AssetLoader.TriangleTable.QUESTION_MARK);
        this.img.changeImage(AssetLoader.getAssetPath(AssetLoader.TriangleTable.QUESTION_MARK));
        this.revalidate();
        this.repaint();
    }
    
    //likely unnecessary
    public Potion.IdentityTypes getType() {
        return switch (currentPotion) {
            case AssetLoader.Potions.BLUE_NEGATIVE -> Potion.IdentityTypes.BLUENEGATIVE;
            case AssetLoader.Potions.BLUE_POSITIVE -> Potion.IdentityTypes.BLUEPOSITIVE;
            case AssetLoader.Potions.RED_NEGATIVE -> Potion.IdentityTypes.REDNEGATIVE;
            case AssetLoader.Potions.RED_POSITIVE -> Potion.IdentityTypes.REDPOSITIVE;
            case AssetLoader.Potions.GREEN_NEGATIVE -> Potion.IdentityTypes.GREENNEGATIVE;
            case AssetLoader.Potions.GREEN_POSITIVE -> Potion.IdentityTypes.GREENPOSITIVE;
            case AssetLoader.Potions.NEUTRAL -> Potion.IdentityTypes.NETURAL;
            case AssetLoader.Potions.UNKNOWN -> Potion.IdentityTypes.UNKNOWN;
            default -> throw new IllegalStateException("Unexpected value: " + currentPotion);
        };
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 900);
        frame.getContentPane().setLayout(null);

        PotionButton po= new PotionButton(100,100,50,50);
        
        frame.getContentPane()
              .add(po);
        frame.setVisible(true);
        
        
    }
}


/*

PotionButtonPopup pop =
                            new PotionButtonPopup(x - width / 2, y - height / 2, width * 2, height * 2, img,
                                                  PotionButton.this);

public Potion.Identity getType() {
        return switch (currentPotion) {
            case AssetLoader.Potions.BLUE_NEGATIVE -> Potion.Identity.BLUENEGATIVE;
            case AssetLoader.Potions.BLUE_POSITIVE -> Potion.Identity.BLUEPOSITIVE;
            case AssetLoader.Potions.RED_NEGATIVE -> Potion.Identity.REDNEGATIVE;
            case AssetLoader.Potions.RED_POSITIVE -> Potion.Identity.REDPOSITIVE;
            case AssetLoader.Potions.GREEN_NEGATIVE -> Potion.Identity.GREENNEGATIVE;
            case AssetLoader.Potions.GREEN_POSITIVE -> Potion.Identity.GREENPOSITIVE;
            case AssetLoader.Potions.NEUTRAL -> Potion.Identity.NETURAL;
            case AssetLoader.Potions.UNKNOWN -> Potion.Identity.UNKNOWN;
            default -> throw new IllegalStateException("Unexpected value: " + currentPotion);
        };
    }
 */