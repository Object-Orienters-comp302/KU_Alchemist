package UI.Components.Potion;

import Models.Player;
import Models.Potion;
import UI.Components.CircleTransparentPanel;
import UI.Components.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PotionButtonPopup extends JPanel {
    private int width, height, x, y;
    
    public PotionButtonPopup(int x, int y, int width, int height, ImagePanel imgPanel, PotionButton ingre) {
        this.setBounds(x, y, width, height);
        this.setOpaque(false);
        this.setLayout(null);
        
        int current = 1;
        
        ///did not work when I put the block in another function
        
        PotionPopupButton B0 = new PotionPopupButton(width * 4 / 8, height * 4 / 8, width * 8 / 16, height * 8 / 16,
                                                     AssetLoader.TriangleTable.QUESTION_MARK, imgPanel, ingre, true);
        add(B0);
        
        if (CheckIfInventory(AssetLoader.Potions.UNKNOWN)) {
            CircleTransparentPanel T1 = new CircleTransparentPanel((width * 3 / 8) - ((width * 5 / 16) / 2),
                                                                   (height / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T1);
        }
        PotionPopupButton B1 = new PotionPopupButton(width * 3 / 8, height / 8, width * 5 / 16, height * 5 / 16,
                                                     AssetLoader.Potions.UNKNOWN, imgPanel, ingre,
                                                     !CheckIfInventory(AssetLoader.Potions.UNKNOWN));
        add(B1);
        
        
        if (CheckIfInventory(AssetLoader.Potions.BLUENEGATIVE)) {
            CircleTransparentPanel T2 = new CircleTransparentPanel((width / 8) - ((width * 5 / 16) / 2),
                                                                   (height * 3 / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T2);
        }
        PotionPopupButton B2 = new PotionPopupButton(width / 8, height * 3 / 8, width * 5 / 16, height * 5 / 16,
                                                     AssetLoader.Potions.BLUENEGATIVE, imgPanel, ingre,
                                                     !CheckIfInventory(AssetLoader.Potions.BLUENEGATIVE));
        add(B2);
        
        
        if (CheckIfInventory(AssetLoader.Potions.BLUEPOSITIVE)) {
            CircleTransparentPanel T3 = new CircleTransparentPanel((width / 8) - ((width * 5 / 16) / 2),
                                                                   (height * 5 / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T3);
        }
        PotionPopupButton B3 = new PotionPopupButton(width / 8, height * 5 / 8, width * 5 / 16, height * 5 / 16,
                                                     AssetLoader.Potions.BLUEPOSITIVE, imgPanel, ingre,
                                                     !CheckIfInventory(AssetLoader.Potions.BLUEPOSITIVE));
        add(B3);
        
        if (CheckIfInventory(AssetLoader.Potions.REDNEGATIVE)) {
            CircleTransparentPanel T4 = new CircleTransparentPanel((width * 3 / 8) - ((width * 5 / 16) / 2),
                                                                   (height * 7 / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T4);
        }
        PotionPopupButton B4 = new PotionPopupButton(width * 3 / 8, height * 7 / 8, width * 5 / 16, height * 5 / 16,
                                                     AssetLoader.Potions.REDNEGATIVE, imgPanel, ingre,
                                                     !CheckIfInventory(AssetLoader.Potions.REDNEGATIVE));
        add(B4);
        
        
        if (CheckIfInventory(AssetLoader.Potions.REDPOSITIVE)) {
            CircleTransparentPanel T5 = new CircleTransparentPanel((width * 5 / 8) - ((width * 5 / 16) / 2),
                                                                   (height * 7 / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T5);
        }
        PotionPopupButton B5 = new PotionPopupButton(width * 5 / 8, height * 7 / 8, width * 5 / 16, height * 5 / 16,
                                                     AssetLoader.Potions.REDPOSITIVE, imgPanel, ingre,
                                                     !CheckIfInventory(AssetLoader.Potions.REDPOSITIVE));
        add(B5);
        
        
        if (CheckIfInventory(AssetLoader.Potions.GREENNEGATIVE)) {
            CircleTransparentPanel T6 = new CircleTransparentPanel((width * 7 / 8) - ((width * 5 / 16) / 2),
                                                                   (height * 5 / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T6);
        }
        PotionPopupButton B6 = new PotionPopupButton(width * 7 / 8, height * 5 / 8, width * 5 / 16, height * 5 / 16,
                                                     AssetLoader.Potions.GREENNEGATIVE, imgPanel, ingre,
                                                     !CheckIfInventory(AssetLoader.Potions.GREENNEGATIVE));
        add(B6);
        
        
        if (CheckIfInventory(AssetLoader.Potions.GREENPOSITIVE)) {
            CircleTransparentPanel T7 = new CircleTransparentPanel((width * 7 / 8) - ((width * 5 / 16) / 2),
                                                                   (height * 3 / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T7);
        }
        PotionPopupButton B7 = new PotionPopupButton(width * 7 / 8, height * 3 / 8, width * 5 / 16, height * 5 / 16,
                                                     AssetLoader.Potions.GREENPOSITIVE, imgPanel, ingre,
                                                     !CheckIfInventory(AssetLoader.Potions.GREENPOSITIVE));
        add(B7);
        
        
        if (CheckIfInventory(AssetLoader.Potions.NEUTRAL)) {
            CircleTransparentPanel T8 = new CircleTransparentPanel((width * 5 / 8) - ((width * 5 / 16) / 2),
                                                                   (height / 8) - ((height * 5 / 16) / 2),
                                                                   width * 5 / 16, height * 5 / 16);
            add(T8);
        }
        PotionPopupButton B8 = new PotionPopupButton(width * 5 / 8, height / 8, width * 5 / 16, height * 5 / 16,
                                                     AssetLoader.Potions.NEUTRAL, imgPanel, ingre,
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
            case AssetLoader.Potions.BLUENEGATIVE -> Potion.Identity.BLUENEGATIVE;
            case AssetLoader.Potions.BLUEPOSITIVE -> Potion.Identity.BLUEPOSITIVE;
            case AssetLoader.Potions.REDNEGATIVE -> Potion.Identity.REDNEGATIVE;
            case AssetLoader.Potions.REDPOSITIVE -> Potion.Identity.REDPOSITIVE;
            case AssetLoader.Potions.GREENNEGATIVE -> Potion.Identity.GREENNEGATIVE;
            case AssetLoader.Potions.GREENPOSITIVE -> Potion.Identity.GREENPOSITIVE;
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