package UI.Components.Potion;

import Models.Player;
import Models.Potion;
import UI.Components.CircleTransparentPanel;
import UI.Components.ImagePanels.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PotionButtonPopup extends JPanel {
    private int width, height, x, y;
    
    public PotionButtonPopup(int x, int y, int width, int height, ImagePanel imgPanel, PotionButton potio) {
        this.setBounds(x, y, width, height);
        this.setOpaque(false);
        this.setLayout(null);
        
        int buttonSizeW = width * 4 / 16;
        int buttonSizeH = height * 4 / 16;
        
        ///did not work when I put the block in another function
        
        PotionPopupButton B0 = new PotionPopupButton(width * 4 / 8, height * 4 / 8, buttonSizeW*3/2, buttonSizeW*3/2,
                                                     AssetLoader.TriangleTable.QUESTION_MARK, imgPanel, potio, true);
        add(B0);
        
        if (!CheckIfInventory(AssetLoader.Potions.UNKNOWN)) {
            CircleTransparentPanel T1 = new CircleTransparentPanel((width * 3 / 8) - (buttonSizeW / 2),
                                                                   (height*3 / 16) - (buttonSizeH / 2), buttonSizeW, buttonSizeH);
            add(T1);
        }
        PotionPopupButton B1 = new PotionPopupButton(width * 3 / 8, height*3 / 16, buttonSizeW, buttonSizeH,
                                                     AssetLoader.Potions.UNKNOWN, imgPanel, potio,
                                                     !CheckIfInventory(AssetLoader.Potions.UNKNOWN));
        add(B1);
        
        
        if (!CheckIfInventory(AssetLoader.Potions.BLUE_NEGATIVE)) {
            CircleTransparentPanel T2 = new CircleTransparentPanel((width*3 / 16) - (buttonSizeW / 2),
                                                                   (height * 3 / 8) - (buttonSizeH / 2), buttonSizeW,
                                                                   buttonSizeH);
            add(T2);
        }
        PotionPopupButton B2 = new PotionPopupButton(width*3 / 16, height * 3 / 8, buttonSizeW, buttonSizeH,
                                                     AssetLoader.Potions.BLUE_NEGATIVE, imgPanel, potio,
                                                     !CheckIfInventory(AssetLoader.Potions.BLUE_NEGATIVE));
        add(B2);
        
        
        if (!CheckIfInventory(AssetLoader.Potions.BLUE_POSITIVE)) {
            CircleTransparentPanel T3 = new CircleTransparentPanel((width*3 / 16) - (buttonSizeW / 2),
                                                                   (height * 5 / 8) - (buttonSizeH / 2), buttonSizeW,
                                                                   buttonSizeH);
            add(T3);
        }
        PotionPopupButton B3 = new PotionPopupButton(width*3 / 16, height * 5 / 8, buttonSizeW, buttonSizeH,
                                                     AssetLoader.Potions.BLUE_POSITIVE, imgPanel, potio,
                                                     !CheckIfInventory(AssetLoader.Potions.BLUE_POSITIVE));
        add(B3);
        
        if (!CheckIfInventory(AssetLoader.Potions.RED_NEGATIVE)) {
            CircleTransparentPanel T4 = new CircleTransparentPanel((width * 3 / 8) - (buttonSizeW / 2),
                                                                   (height * 13 / 16) - (buttonSizeH / 2), buttonSizeW,
                                                                   buttonSizeH);
            add(T4);
        }
        PotionPopupButton B4 = new PotionPopupButton(width * 3 / 8, height * 13 / 16, buttonSizeW, buttonSizeH,
                                                     AssetLoader.Potions.RED_NEGATIVE, imgPanel, potio,
                                                     !CheckIfInventory(AssetLoader.Potions.RED_NEGATIVE));
        add(B4);
        
        
        if (!CheckIfInventory(AssetLoader.Potions.RED_POSITIVE)) {
            CircleTransparentPanel T5 = new CircleTransparentPanel((width * 5 / 8) - (buttonSizeW / 2),
                                                                   (height * 13 / 16) - (buttonSizeH / 2), buttonSizeW,
                                                                   buttonSizeH);
            add(T5);
        }
        PotionPopupButton B5 = new PotionPopupButton(width * 5 / 8, height* 13 / 16, buttonSizeW, buttonSizeH,
                                                     AssetLoader.Potions.RED_POSITIVE, imgPanel, potio,
                                                     !CheckIfInventory(AssetLoader.Potions.RED_POSITIVE));
        add(B5);
        
        
        if (!CheckIfInventory(AssetLoader.Potions.GREEN_NEGATIVE)) {
            CircleTransparentPanel T6 = new CircleTransparentPanel((width * 13 / 16) - (buttonSizeW / 2),
                                                                   (height * 5 / 8) - (buttonSizeH / 2), buttonSizeW,
                                                                   buttonSizeH);
            add(T6);
        }
        PotionPopupButton B6 = new PotionPopupButton(width * 13 / 16, height * 5 / 8, buttonSizeW, buttonSizeH,
                                                     AssetLoader.Potions.GREEN_NEGATIVE, imgPanel, potio,
                                                     !CheckIfInventory(AssetLoader.Potions.GREEN_NEGATIVE));
        add(B6);
        
        
        if (!CheckIfInventory(AssetLoader.Potions.GREEN_POSITIVE)) {
            CircleTransparentPanel T7 = new CircleTransparentPanel((width * 13 / 16) - (buttonSizeW / 2),
                                                                   (height * 3 / 8) - (buttonSizeH / 2), buttonSizeW,
                                                                   buttonSizeH);
            add(T7);
        }
        PotionPopupButton B7 = new PotionPopupButton(width * 13 / 16, height * 3 / 8, buttonSizeW, buttonSizeH,
                                                     AssetLoader.Potions.GREEN_POSITIVE, imgPanel, potio,
                                                     !CheckIfInventory(AssetLoader.Potions.GREEN_POSITIVE));
        add(B7);
        
        
        if (!CheckIfInventory(AssetLoader.Potions.NEUTRAL)) {
            CircleTransparentPanel T8 = new CircleTransparentPanel((width * 5 / 8) - (buttonSizeW / 2),
                                                                   (height * 3 / 16) - (buttonSizeH / 2), buttonSizeW, buttonSizeH);
            add(T8);
        }
        PotionPopupButton B8 = new PotionPopupButton(width * 5 / 8, height * 3 / 16, buttonSizeW, buttonSizeH,
                                                     AssetLoader.Potions.NEUTRAL, imgPanel, potio,
                                                     !CheckIfInventory(AssetLoader.Potions.NEUTRAL));
        add(B8);
        
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Container parent = PotionButtonPopup.this.getParent();
                
                if (parent != null) {
                    
                    parent.remove(PotionButtonPopup.this);
                    parent.revalidate();
                    parent.repaint();
                    
                }
                
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                Container parent = PotionButtonPopup.this.getParent();
                if (parent != null) {
                    Point mousePoint = e.getPoint();
                    
                    // Check if the mouse is still within the bounds of the parent component
                    if (PotionButtonPopup.this.contains(mousePoint)) {
                        return;
                    }
                    parent.remove(PotionButtonPopup.this);
                    parent.revalidate();
                    parent.repaint();
                }
                
            }
        });
        
    }
    
    public static boolean CheckIfInventory(AssetLoader.AssetPath toCheck) {
        Potion.Identity potionIdentity = switch (toCheck) {
            case AssetLoader.Potions.BLUE_NEGATIVE -> Potion.Identity.BLUENEGATIVE;
            case AssetLoader.Potions.BLUE_POSITIVE -> Potion.Identity.BLUEPOSITIVE;
            case AssetLoader.Potions.RED_NEGATIVE -> Potion.Identity.REDNEGATIVE;
            case AssetLoader.Potions.RED_POSITIVE -> Potion.Identity.REDPOSITIVE;
            case AssetLoader.Potions.GREEN_NEGATIVE -> Potion.Identity.GREENNEGATIVE;
            case AssetLoader.Potions.GREEN_POSITIVE -> Potion.Identity.GREENPOSITIVE;
            case AssetLoader.Potions.NEUTRAL -> Potion.Identity.NETURAL;
            case AssetLoader.Potions.UNKNOWN -> Potion.Identity.UNKNOWN;
            default -> throw new IllegalStateException("Unexpected value: " + toCheck);
        };
        
        return Player.getCurrPlayer().getInventory().getPotions().entrySet().stream()
                .anyMatch(entry -> entry.getKey().getIdentity() == potionIdentity && entry.getValue() > 0);
        
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.getContentPane().setLayout(new GridBagLayout());
        BookPanel login = new BookPanel(1);
        frame.getContentPane().add(login);
        frame.setVisible(true);
        */
        
    }
}