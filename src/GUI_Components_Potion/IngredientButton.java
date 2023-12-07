package GUI_Components_Potion;

import GUI_Components.ImagePanel;
import Models.Ingredient;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//ToDo:invantory checks
public class IngredientButton extends JPanel {
    ImagePanel img;
    boolean    transparent = false;
    private int                   diameter;
    private int                   x;
    private int                   y;
    private AssetLoader.AssetPath currentValue;
    
    
    public IngredientButton(int x, int y, int width, int height) {
        this.setOpaque(false);
        setLayout(null);
        this.setBounds(x, y, width, height);
        currentValue = AssetLoader.TriangleTable.QUESTION_MARK;
        img          = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.TriangleTable.QUESTION_MARK));
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
                    IngredientButtonPopup pop =
                            new IngredientButtonPopup(x - width / 2, y - height / 2, width * 2, height * 2, img,
                                                      IngredientButton.this);
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
    
    public IngredientButton(int x, int y, int width, int height, boolean transparent) {
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
                    IngredientButtonPopup pop =
                            new IngredientButtonPopup(x - width / 2, y - height / 2, width * 2, height * 2, img,
                                                      IngredientButton.this);
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
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1500);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.red);
        IngredientButton book = new IngredientButton(50, 50, 100, 100);
        frame.getContentPane().add(book);
        IngredientButton book1 = new IngredientButton(250, 50, 100, 100);
        frame.getContentPane().add(book1);
        IngredientButton book2 = new IngredientButton(450, 50, 100, 100);
        frame.getContentPane().add(book2);
        IngredientButton book3 = new IngredientButton(650, 50, 100, 100);
        frame.getContentPane().add(book3);
        IngredientButton book4 = new IngredientButton(50, 250, 100, 100);
        frame.getContentPane().add(book4);
        IngredientButton book5 = new IngredientButton(250, 250, 100, 100);
        frame.getContentPane().add(book5);
        IngredientButton book6 = new IngredientButton(450, 250, 100, 100);
        frame.getContentPane().add(book6);
        IngredientButton book7 = new IngredientButton(650, 250, 100, 100);
        frame.getContentPane().add(book7);
        IngredientButton book8 = new IngredientButton(50, 450, 100, 100);
        frame.getContentPane().add(book8);
        frame.setVisible(true);
        
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
    
    public AssetLoader.AssetPath getCurrentValue() {
        return currentValue;
    }
    
    public void setCurrentValue(AssetLoader.AssetPath val) {
        currentValue = val;
    }
    
    public Ingredient.IngredientTypes getType() {
        return switch (currentValue) {
            case AssetLoader.IngredientAssets.Feather -> Ingredient.IngredientTypes.Feather;
            case AssetLoader.IngredientAssets.Frog -> Ingredient.IngredientTypes.Toad;
            case AssetLoader.IngredientAssets.Mandrake -> Ingredient.IngredientTypes.Mandrake;
            case AssetLoader.IngredientAssets.Weed -> Ingredient.IngredientTypes.Plant;
            case AssetLoader.IngredientAssets.Scorpion -> Ingredient.IngredientTypes.Scorpion;
            case AssetLoader.IngredientAssets.Feet -> Ingredient.IngredientTypes.ChickenLeg;
            case AssetLoader.IngredientAssets.Flower -> Ingredient.IngredientTypes.Flower;
            case AssetLoader.IngredientAssets.Mushroom -> Ingredient.IngredientTypes.Mushroom;
            default -> throw new IllegalStateException("Unexpected value: " + currentValue);
        };
    }
}