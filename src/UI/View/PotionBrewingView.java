package UI.View;

import javax.swing.JPanel;

import GUI_Components.ColorChangingPanel;
import GUI_Components.ImagePanel;
import GUI_Components_Potion.IngredientButton;
import UI.GamePage;
import Utils.AssetLoader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PotionBrewingView extends JPanel {
    
    /**
     * Create the panel.
     */
    ImagePanel Background;
    IngredientButton ingredientButton1;
    IngredientButton ingredientButton2;
    ColorChangingPanel makePotionButton;
    JCheckBox TestOnStudentBox;
    
    public PotionBrewingView() {
        this.setSize(1000,500);
        setLayout(null);
        
        
        
        Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.PotionBrewingViewAssets.Background));
        Background.setLocation(0, 0);
        Background.setSize(1000,500);
        this.add(Background);
        Background.setLayout(null);
        
        IngredientButton ingredientButton1 = new IngredientButton(910,332,60,60);
        ingredientButton1.setBounds(910, 332, 60, 60);
        Background.add(ingredientButton1);
        IngredientButton ingredientButton2 = new IngredientButton(810,332,60,60);
        ingredientButton2.setBounds(810, 332, 60, 60);
        Background.add(ingredientButton2);
        
        makePotionButton = new ColorChangingPanel("#cf9d15", "#FFD700");
        makePotionButton.setBounds(830, 400, 120, 40);
        makePotionButton.addMouseListener(new MouseAdapter() {
            public void MouseClicked(MouseEvent e) {
                System.out.println("mouseclicked");
            }
        });
        Background.add(makePotionButton);
        makePotionButton.setLayout(null);
        
        JLabel MakePotionLbl = new JLabel("Make Potion");
        MakePotionLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        MakePotionLbl.setHorizontalAlignment(SwingConstants.CENTER);
        MakePotionLbl.setBounds(0, 0, 120, 40);
        makePotionButton.add(MakePotionLbl);
        
        TestOnStudentBox = new JCheckBox("Test on student");
        TestOnStudentBox.setBackground(new Color(207,157,21));
        TestOnStudentBox.setFont(new Font("Tahoma", Font.BOLD, 12));
        TestOnStudentBox.setBounds(20, 400, 130, 40);
        Background.add(TestOnStudentBox);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1020,520);
        frame.getContentPane().add(new PotionBrewingView());
        frame.setVisible(true);
        
    }
}
