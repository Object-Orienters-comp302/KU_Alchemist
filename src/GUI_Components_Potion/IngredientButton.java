package GUI_Components_Potion;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI_Components.ImagePanel;
import GUI_Components_Publish.BookButton;
import GUI_Components_Publish.BookButtonPopup;
import GUI_Components_Publish.BookPanel;
import Models.Ingredient;

//ToDo:invantory checks
public class IngredientButton extends JPanel {
	private int diameter, x, y,currentValue;
	ImagePanel img;
	boolean transparent=false;
	

	public IngredientButton(int x, int y, int width, int height) {
        this.setOpaque(false);
        setLayout(null);
        this.setBounds(x, y, width, height);
        currentValue=8;
        img = new ImagePanel(ChooseImg(8));
        img.setBounds(width*9/40, width*9/40, width*9/16, height*9/16);
        add(img);
        
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                int clickX = e.getX();
                int clickY = e.getY();
                //Rectangle bounds = getBounds();
                
                if (isClickInsideCircle(clickX, clickY)) {
                    //System.out.println("Button click inside the circle!");
                    IngredientButtonPopup pop =
                            new IngredientButtonPopup(x - width/2, y - height/2, width * 2, height * 2,img,IngredientButton.this);
                    Container parent = getParent();
                    parent.add(pop);
                    parent.setComponentZOrder(pop,1);
                    
                    parent.repaint();
                    
                } else {
                    System.out.println("Button click outside the circle.");
                    System.out.print(getBounds());
                }
            }
        });
        
        
        
        
    }
	public IngredientButton(int x, int y, int width, int height,boolean transparent) {
        this.setOpaque(false);
        setLayout(null);
        this.setBounds(x, y, width, height);
        currentValue=8;
        img = new ImagePanel(ChooseImg(8));
        img.setBounds(width*9/40, width*9/40, width*9/16, height*9/16);
        add(img);
        this.transparent=transparent;
        
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                int clickX = e.getX();
                int clickY = e.getY();
                //Rectangle bounds = getBounds();
                
                if (isClickInsideCircle(clickX, clickY)) {
                    //System.out.println("Button click inside the circle!");
                    IngredientButtonPopup pop =
                            new IngredientButtonPopup(x - width/2, y - height/2, width * 2, height * 2,img,IngredientButton.this);
                    Container parent = getParent();
                    parent.add(pop);
                    parent.setComponentZOrder(pop,1);
                    
                    parent.repaint();
                    
                } else {
                    System.out.println("Button click outside the circle.");
                    System.out.print(getBounds());
                }
            }
        });
        
        
        
        
    }
	@Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        
        int originalDiameter = Math.min(getWidth(), getHeight());
        int customDiameter = originalDiameter * 3 / 4;
        
        int x = (getWidth() - customDiameter) / 2;
        int y = (getHeight() - customDiameter) / 2;
        diameter = originalDiameter;
        if(!this.transparent) {
        g.setColor(Color.decode("#ebd2a9"));
        g.fillOval(x, y, customDiameter, customDiameter);
        }
    }
    
    private boolean isClickInsideCircle (int clickX, int clickY) {
        int radius = diameter / 2;
        int centerX = x + radius;
        int centerY = y + radius;
        
        double distance = Math.sqrt(Math.pow(clickX - centerX, 2) + Math.pow(clickY - centerY, 2));
        
        return distance <= radius;
    }
    public static String ChooseImg(int val) {
    	String path;
    	switch (val) {
    	case 0:
            path = ".\\Images\\book\\feather.png";
            break;
        case 1:
            path = ".\\Images\\book\\feet.png";
            break;
        case 2:
            path = ".\\Images\\book\\flower.png";
            break;
        case 3:
            path = ".\\Images\\book\\frog.png";
            break;
        case 4:
            path = ".\\Images\\book\\mandrake.png";
            break;
        case 5:
            path = ".\\Images\\book\\mushroom.png";
            break;
        case 6:
            path = ".\\Images\\book\\weed.png";
            break;
        case 7:
            path = ".\\Images\\book\\scorpion.png";
            break;
        case 8:
            path = ".\\Images\\triangleTable\\questionMark.png";
            break;
        default:
            path = ".\\Images\\triangleTable\\empty.png";
            break;
    	}
    	return path;
    }
    public Ingredient.IngredientTypes getType(){
        switch (this.getCurrentValue()){
            case 0:
                return Ingredient.IngredientTypes.Feather;
            case 1:
                return Ingredient.IngredientTypes.ChickenLeg;
            case 2:
                return Ingredient.IngredientTypes.Flower;
            case 3:
                return Ingredient.IngredientTypes.Toad;
            case 4:
                return Ingredient.IngredientTypes.Mandrake;
            case 5:
                return Ingredient.IngredientTypes.Mushroom;
            case 6:
                return Ingredient.IngredientTypes.Plant;
            case 7:
                return Ingredient.IngredientTypes.Scorpion;
            default:
                return null;
                
        }
    }
    
    public void setCurrentValue(int val) {
    	currentValue=val;
    }
    public int getCurrentValue() {
    	return currentValue;
    }
    public static void main (String[] args) {
        // TODO Auto-generated method stub
        
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1500);
        frame.getContentPane()
                .setLayout(null);
        frame.getContentPane().setBackground(Color.red);
        IngredientButton book= new IngredientButton(50,50,100,100);
        frame.getContentPane().add(book);
        IngredientButton book1= new IngredientButton(250,50,100,100);
        frame.getContentPane().add(book1);
        IngredientButton book2= new IngredientButton(450,50,100,100);
        frame.getContentPane().add(book2);
        IngredientButton book3= new IngredientButton(650,50,100,100);
        frame.getContentPane().add(book3);
        IngredientButton book4= new IngredientButton(50,250,100,100);
        frame.getContentPane().add(book4);
        IngredientButton book5= new IngredientButton(250,250,100,100);
        frame.getContentPane().add(book5);
        IngredientButton book6= new IngredientButton(450,250,100,100);
        frame.getContentPane().add(book6);
        IngredientButton book7= new IngredientButton(650,250,100,100);
        frame.getContentPane().add(book7);
        IngredientButton book8= new IngredientButton(50,450,100,100);
        frame.getContentPane().add(book8);
        frame.setVisible(true);
        
    }

}