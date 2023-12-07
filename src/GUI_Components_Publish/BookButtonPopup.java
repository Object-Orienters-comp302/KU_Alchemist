package GUI_Components_Publish;

import GUI_Components.CircleTransparentPanel;
import GUI_Components.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookButtonPopup extends JPanel {
    private int width, height, x, y;
    
    public BookButtonPopup(int x, int y, int width, int height, ImagePanel imgPanel, BookButton book) {
        this.setBounds(x, y, width, height);
        this.setOpaque(false);
        this.setLayout(null);
        int[] data = new int[3];
        int current = 1;
        
        ///did not work when I put the block in another function
        
        BookPopupButton B0 = new BookPopupButton(width * 4 / 8, height * 4 / 8, width * 8 / 16, height * 8 / 16,
                                                 AssetLoader.TriangleTable.QUESTION_MARK, imgPanel, book);
        add(B0);
        
        if (BookPanel.traitUsed.contains(AssetLoader.Book.allPositive)) {
            CircleTransparentPanel T1 = new CircleTransparentPanel((width * 3 / 8) - ((width * 5 / 16) / 2),
                                                                   (height / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T1);
        }
        BookPopupButton B1 = new BookPopupButton(width * 3 / 8, height / 8, width * 5 / 16, height * 5 / 16,
                                                 AssetLoader.Book.allPositive, imgPanel, book);
        add(B1);
        
        
        if (BookPanel.traitUsed.contains(AssetLoader.Book.allNegative)) {
            CircleTransparentPanel T2 = new CircleTransparentPanel((width / 8) - ((width * 5 / 16) / 2),
                                                                   (height * 3 / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T2);
        }
        BookPopupButton B2 = new BookPopupButton(width / 8, height * 3 / 8, width * 5 / 16, height * 5 / 16,
                                                 AssetLoader.Book.allNegative, imgPanel, book);
        add(B2);
        
        
        if (BookPanel.traitUsed.contains(AssetLoader.Book.negativeGreen)) {
            CircleTransparentPanel T3 = new CircleTransparentPanel((width / 8) - ((width * 5 / 16) / 2),
                                                                   (height * 5 / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T3);
        }
        BookPopupButton B3 = new BookPopupButton(width / 8, height * 5 / 8, width * 5 / 16, height * 5 / 16,
                                                 AssetLoader.Book.negativeGreen, imgPanel, book);
        add(B3);
        
        if (BookPanel.traitUsed.contains(AssetLoader.Book.positiveRed)) {
            CircleTransparentPanel T4 = new CircleTransparentPanel((width * 3 / 8) - ((width * 5 / 16) / 2),
                                                                   (height * 7 / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T4);
        }
        BookPopupButton B4 = new BookPopupButton(width * 3 / 8, height * 7 / 8, width * 5 / 16, height * 5 / 16,
                                                 AssetLoader.Book.positiveRed, imgPanel, book);
        add(B4);
        
        
        if (BookPanel.traitUsed.contains(AssetLoader.Book.negativeBlue)) {
            CircleTransparentPanel T5 = new CircleTransparentPanel((width * 5 / 8) - ((width * 5 / 16) / 2),
                                                                   (height * 7 / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T5);
        }
        BookPopupButton B5 = new BookPopupButton(width * 5 / 8, height * 7 / 8, width * 5 / 16, height * 5 / 16,
                                                 AssetLoader.Book.negativeBlue, imgPanel, book);
        add(B5);
        
        
        if (BookPanel.traitUsed.contains(AssetLoader.Book.negativeRed)) {
            CircleTransparentPanel T6 = new CircleTransparentPanel((width * 7 / 8) - ((width * 5 / 16) / 2),
                                                                   (height * 5 / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T6);
        }
        BookPopupButton B6 = new BookPopupButton(width * 7 / 8, height * 5 / 8, width * 5 / 16, height * 5 / 16,
                                                 AssetLoader.Book.negativeRed, imgPanel, book);
        add(B6);
        
        
        if (BookPanel.traitUsed.contains(AssetLoader.Book.positiveGreen)) {
            CircleTransparentPanel T7 = new CircleTransparentPanel((width * 7 / 8) - ((width * 5 / 16) / 2),
                                                                   (height * 3 / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T7);
        }
        BookPopupButton B7 = new BookPopupButton(width * 7 / 8, height * 3 / 8, width * 5 / 16, height * 5 / 16,
                                                 AssetLoader.Book.positiveGreen, imgPanel, book);
        add(B7);
        
        
        if (BookPanel.traitUsed.contains(AssetLoader.Book.positiveBlue)) {
            CircleTransparentPanel T8 = new CircleTransparentPanel((width * 5 / 8) - ((width * 5 / 16) / 2),
                                                                   (height / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T8);
        }
        BookPopupButton B8 = new BookPopupButton(width * 5 / 8, height / 8, width * 5 / 16, height * 5 / 16,
                                                 AssetLoader.Book.positiveBlue, imgPanel, book);
        add(B8);
        
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Container parent = BookButtonPopup.this.getParent();
                
                if (parent != null) {
                    
                    parent.remove(BookButtonPopup.this);
                    parent.revalidate();
                    parent.repaint();
                    
                }
                
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                Container parent = BookButtonPopup.this.getParent();
                if (parent != null) {
                    Point mousePoint = e.getPoint();
                    
                    // Check if the mouse is still within the bounds of the parent component
                    if (BookButtonPopup.this.contains(mousePoint)) {
                        return;
                    }
                    parent.remove(BookButtonPopup.this);
                    parent.revalidate();
                    parent.repaint();
                }
                
            }
        });
        
    }
    
    
    
    /*
    private void ApplyBlock() {
    	
    	CircleTransparentPanel T1=new CircleTransparentPanel
        		((width * 3 / 8)-((width * 5 / 16)/2), (height * 1/8)-((height * 5 / 16)/2)
        				, width * 5 / 16, height * 5 / 16);
        CircleTransparentPanel T2 = new CircleTransparentPanel(
                (width * 1 / 8) - ((width * 5 / 16) / 2), (height * 3 / 8) - ((height * 5 / 16) / 2),
                width * 5 / 16, height * 5 / 16);

        CircleTransparentPanel T3 = new CircleTransparentPanel(
                (width * 1 / 8) - ((width * 5 / 16) / 2), (height * 5 / 8) - ((height * 5 / 16) / 2),
                width * 5 / 16, height * 5 / 16);

        CircleTransparentPanel T4 = new CircleTransparentPanel(
                (width * 3 / 8) - ((width * 5 / 16) / 2), (height * 7 / 8) - ((height * 5 / 16) / 2),
                width * 5 / 16, height * 5 / 16);

        CircleTransparentPanel T5 = new CircleTransparentPanel(
                (width * 5 / 8) - ((width * 5 / 16) / 2), (height * 7 / 8) - ((height * 5 / 16) / 2),
                width * 5 / 16, height * 5 / 16);

        CircleTransparentPanel T6 = new CircleTransparentPanel(
                (width * 7 / 8) - ((width * 5 / 16) / 2), (height * 5 / 8) - ((height * 5 / 16) / 2),
                width * 5 / 16, height * 5 / 16);

        CircleTransparentPanel T7 = new CircleTransparentPanel(
                (width * 7 / 8) - ((width * 5 / 16) / 2), (height * 3 / 8) - ((height * 5 / 16) / 2),
                width * 5 / 16, height * 5 / 16);

        CircleTransparentPanel T8 = new CircleTransparentPanel(
                (width * 5 / 8) - ((width * 5 / 16) / 2), (height * 1 / 8) - ((height * 5 / 16) / 2),
                width * 5 / 16, height * 5 / 16);
        
        
        int[] copy=BookPanel.traitUsed.clone();
        
       
        
        
        
        this.add(T1);
    }
    */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.getContentPane().setLayout(new GridBagLayout());
        BookPanel login = new BookPanel(AssetLoader.Book.allPositive);
        frame.getContentPane().add(login);
        frame.setVisible(true);
        
        
    }
}
