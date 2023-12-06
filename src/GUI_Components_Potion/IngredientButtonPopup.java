package GUI_Components_Potion;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI_Components.CircleTransparentPanel;
import GUI_Components.ImagePanel;
import GUI_Components_Publish.BookButton;
import GUI_Components_Publish.BookButtonPopup;
import GUI_Components_Publish.BookPanel;

public class IngredientButtonPopup extends JPanel {
    private int width, height, x, y;
    
    public IngredientButtonPopup (int x, int y, int width, int height, ImagePanel imgPanel,IngredientButton ingre) {
        this.setBounds(x, y, width, height);
        this.setOpaque(false);
        this.setLayout(null);
        int [] data=new int[3];
        int current=1;
        
        ///did not work when I put the block in another function
        
        IngredientPopupButton B0 = new IngredientPopupButton(width * 4 / 8, height * 4 / 8, width * 8 / 16, height * 8 / 16,
        		8, imgPanel, ingre, true);
        add(B0);
        
        if(CheckIfInventory(1)) {
        	CircleTransparentPanel T1=new CircleTransparentPanel
        			((width * 3 / 8)-((width * 5 / 16)/2), (height * 1/8)-((height * 5 / 16)/2)
        					, width * 5 / 16, height * 5 / 16);
        add(T1);
        }
        IngredientPopupButton B1 = new IngredientPopupButton(width * 3 / 8, height * 1/8, width * 5 / 16, height * 5 / 16,
        		0, imgPanel, ingre,!CheckIfInventory(1));
        add(B1);
        
        
        if(CheckIfInventory(2)) {
        	CircleTransparentPanel T2 = new CircleTransparentPanel(
                    (width * 1 / 8) - ((width * 5 / 16) / 2), (height * 3 / 8) - ((height * 5 / 16) / 2),
                    width * 5 / 16, height * 5 / 16);
        add(T2);
        }
        IngredientPopupButton B2 = new IngredientPopupButton(width* 1 / 8, height * 3/8 , width * 5 / 16, height * 5 / 16,
        		1, imgPanel, ingre,!CheckIfInventory(2));
        add(B2);
        
        
        if(CheckIfInventory(3)) {
        	CircleTransparentPanel T3 = new CircleTransparentPanel(
                    (width * 1 / 8) - ((width * 5 / 16) / 2), (height * 5 / 8) - ((height * 5 / 16) / 2),
                    width * 5 / 16, height * 5 / 16);
        add(T3);
        }
        IngredientPopupButton B3 = new IngredientPopupButton(width *1/ 8, height * 5/8 , width * 5 / 16, height * 5 / 16,
        		2, imgPanel, ingre,!CheckIfInventory(3));
        add(B3);
        
        if(CheckIfInventory(4)) {
        	 CircleTransparentPanel T4 = new CircleTransparentPanel(
                     (width * 3 / 8) - ((width * 5 / 16) / 2), (height * 7 / 8) - ((height * 5 / 16) / 2),
                     width * 5 / 16, height * 5 / 16);
        add(T4);
        }
        IngredientPopupButton B4 = new IngredientPopupButton(width * 3 / 8, height * 7 / 8, width * 5 / 16, height * 5 / 16,
        		3, imgPanel, ingre,!CheckIfInventory(4));
        add(B4);
        
        
        if(CheckIfInventory(5)) {
        	CircleTransparentPanel T5 = new CircleTransparentPanel(
                    (width * 5 / 8) - ((width * 5 / 16) / 2), (height * 7 / 8) - ((height * 5 / 16) / 2),
                    width * 5 / 16, height * 5 / 16);
        add(T5);
        }IngredientPopupButton B5 = new IngredientPopupButton(width * 5/ 8, height *7/ 8, width * 5 / 16, height * 5 / 16,
        		4, imgPanel, ingre,!CheckIfInventory(5));
        add(B5);
        
        
        if(CheckIfInventory(6)) {
        	CircleTransparentPanel T6 = new CircleTransparentPanel(
                    (width * 7 / 8) - ((width * 5 / 16) / 2), (height * 5 / 8) - ((height * 5 / 16) / 2),
                    width * 5 / 16, height * 5 / 16);
        add(T6);
        }IngredientPopupButton B6 = new IngredientPopupButton(width * 7 / 8, height * 5 / 8, width * 5 / 16, height * 5 / 16,
        		5, imgPanel, ingre,!CheckIfInventory(6));
        add(B6);
        
        
        if(CheckIfInventory(7)) {
        	CircleTransparentPanel T7 = new CircleTransparentPanel(
                    (width * 7 / 8) - ((width * 5 / 16) / 2), (height * 3 / 8) - ((height * 5 / 16) / 2),
                    width * 5 / 16, height * 5 / 16);
        add(T7);
        }IngredientPopupButton B7 = new IngredientPopupButton(width * 7 / 8, height * 3 / 8, width * 5 / 16, height * 5 / 16,
        		6, imgPanel, ingre,!CheckIfInventory(7));
        add(B7);
        
        
        if(CheckIfInventory(8)) {
        	CircleTransparentPanel T8 = new CircleTransparentPanel(
                    (width * 5 / 8) - ((width * 5 / 16) / 2), (height * 1 / 8) - ((height * 5 / 16) / 2),
                    width * 5 / 16, height * 5 / 16);
        add(T8);
        }IngredientPopupButton B8 = new IngredientPopupButton(width * 5 / 8, height * 1 / 8, width * 5 / 16, height * 5 / 16,
        		7, imgPanel, ingre,!CheckIfInventory(8));
        add(B8);
        
        
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                Container parent = IngredientButtonPopup.this.getParent();
                
                if (parent != null) {
                    
                    parent.remove(IngredientButtonPopup.this);
                    parent.revalidate();
                    parent.repaint();
                    
                }
                
            }
            
            @Override
            public void mouseExited (MouseEvent e) {
                Container parent = IngredientButtonPopup.this.getParent();
                if (parent != null) {
                    Point mousePoint = e.getPoint();
                    
                    // Check if the mouse is still within the bounds of the parent component
                    if (IngredientButtonPopup.this.contains(mousePoint)) {
                        return;
                    }
                    parent.remove(IngredientButtonPopup.this);
                    parent.revalidate();
                    parent.repaint();
                }
                
            }
        });
        
    }
    
    public static boolean CheckIfInventory(int toCheck) { //TODO:backend connect
    	
    	return false;
    	
    }
    
    
    public static void main (String[] args) {
        // TODO Auto-generated method stub
        
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.getContentPane()
                .setLayout(new GridBagLayout());
        BookPanel login = new BookPanel(1);
        frame.getContentPane()
                .add(login);
        frame.setVisible(true);
        
    	
        
        
    }
}
