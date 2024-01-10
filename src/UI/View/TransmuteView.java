package UI.View;

import Domain.GameController;
import Domain.RoundOneController;
import Domain.RoundTwoController;
import Models.Player;
import Models.Potion;
import UI.Components.ColorChangingPanel;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.Potion.IngredientButton;
import UI.Components.Potion.PotionButton;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TransmuteView extends JPanel {
    
    /**
     * Create the panel.
     */
    ImagePanel         Background;
    IngredientButton   B1;
    ImagePanel         Card;
    ColorChangingPanel transmuteIngredient;
    private ImagePanel SwitchButton_Forage;
    private ImagePanel Forage_Text;
    private ImagePanel SwitchButton_Transmutate;
    private ImagePanel Transmutate_Text;
    
    public TransmuteView() {
        this.setSize(1000, 500);
        setLayout(null);
        
        
        B1 = new IngredientButton(430, 105, 140, 140, true);
        
        this.add(B1);
        
        
        Card = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.CARD));
        Card.setBounds(420, 50, 160, 250);
        this.add(Card);
        
        
        transmuteIngredient = new ColorChangingPanel("#cf9d15", "#FFD700");
        transmuteIngredient.setBounds(440, 320, 120, 40);
        transmuteIngredient.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                RoundOneController roundOneController = GameController.getInstance().getRoundOneController();
                roundOneController.TransmuteIngredient(Player.getCurrPlayer(), B1.getType());
                reset();
            }
        });
        this.add(transmuteIngredient);
        transmuteIngredient.setLayout(null);
        JLabel transmuteIngredientLbl = new JLabel("Transmute");
        transmuteIngredientLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        transmuteIngredientLbl.setHorizontalAlignment(SwingConstants.CENTER);
        transmuteIngredientLbl.setBounds(0, 0, 120, 40);
        transmuteIngredient.add(transmuteIngredientLbl);
        
        
        
        Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.TRANSMUTE_BACKGROUND));
        Background.setBounds(0, 0, 1000, 500);
        this.add(Background);
        Background.setLayout(null);
        
        SwitchButton_Forage = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
        SwitchButton_Forage.setLayout(null);
        SwitchButton_Forage.setBounds(290, 380, 200, 100);
        Background.add(SwitchButton_Forage);
        
        Forage_Text = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonTexts.FORAGE));
        Forage_Text.setLayout(null);
        Forage_Text.setBounds(30, 25, 145, 50);
        SwitchButton_Forage.add(Forage_Text);
        
        SwitchButton_Transmutate = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_GOLD));
        SwitchButton_Transmutate.setLayout(null);
        SwitchButton_Transmutate.setBounds(510, 380, 200, 100);
        Background.add(SwitchButton_Transmutate);
        
        Transmutate_Text = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonTexts.TRANSMUTE));
        Transmutate_Text.setLayout(null);
        Transmutate_Text.setBounds(25, 20, 150, 60);
        SwitchButton_Transmutate.add(Transmutate_Text);
        
        SwitchButton_Forage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuView menu= GameController.getInstance().getMenuController().getMenuView();
                menu.cardLay.show(menu.displayerPanel,"Foraging");
                
            }
        });
        
        this.setVisible(true);
    }
    public void reset(){
        B1.reset();
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1020, 520);
        frame.getContentPane().add(new TransmuteView());
        frame.setVisible(true);
    }
}
