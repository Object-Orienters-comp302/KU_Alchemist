package UI.View;

import Domain.GameController;
import Domain.RoundOneController;
import Models.Ingredient;
import Models.Inventory;
import Models.Player;
import Models.Potion;
import UI.Components.ColorChangingPanel;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.Potion.IngredientButton;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PotionBrewingView extends JPanel {
    
    /**
     * Create the panel.
     */
    ImagePanel         Background;
    ColorChangingPanel MakePotionButton;
    ColorChangingPanel TestOnStudentBox;
    Boolean            testOnStudent = false;
    IngredientButton IngredientB1;
    IngredientButton IngredientB2;
    
    JLabel MakePotionLbl;
    ImagePanel TickPanel;
    JLabel lblNewLabel;
    ImagePanel Card1;
    ImagePanel Card2;
    ImagePanel PotionDisplayer;
    ColorChangingPanel DrinkButton;
    JLabel lblDrink;
    JPanel ButtonPanel;
    
    ImagePanel BG1;
    ImagePanel BG1_Text;
    ImagePanel BG2;
    ImagePanel BG2_Text;
    ImagePanel BG3;
    ImagePanel BG3_Text;
    ImagePanel BG4;
    ImagePanel BG4_Text;
    ImagePanel BG5;
    ImagePanel BG5_Text;
    
    int chosenbg=1;
    
    
    public PotionBrewingView() {
        this.setSize(1000, 500);
        setLayout(null);
        CreateObjects();
        SetupObjects();
        SetupListeners();
        
        
        
        
        
        
        
        
        this.setVisible(true);
    }
    
    private void CreateObjects() {
    	Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.PotionBrewingViewAssets.BACKGROUND1));
    	IngredientB1 = new IngredientButton(150, 155, 140, 140, true);
    	
    	IngredientB2 = new IngredientButton(710, 155, 140, 140, true);
        
    	MakePotionButton = new ColorChangingPanel("#cf9d15", "#FFD700");
    	MakePotionLbl = new JLabel("Make Potion");
    	TestOnStudentBox = new ColorChangingPanel("#cf9d15", "#FFD700");
    	TickPanel = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Tokens.RED_X));
    	lblNewLabel = new JLabel("TEST ON STUDENT");
    	Card1 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.CARD));
    	Card2 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.CARD));
    	PotionDisplayer = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.BLANK));
    	DrinkButton = new ColorChangingPanel("#cf9d15", "#FFD700");
    	lblDrink = new JLabel("DRINK");
    	
    	ButtonPanel = new JPanel();
    	BG1 = new ImagePanel("Images/start/frameGold.png");
    	BG1_Text = new ImagePanel("Images/start/goldInt1.png");
    	BG2 = new ImagePanel("Images/start/frameCopper.png");
    	BG2_Text = new ImagePanel("Images/start/goldInt2.png");
    	BG3 = new ImagePanel("Images/start/frameCopper.png");
    	BG3_Text = new ImagePanel("Images/start/goldInt3.png");
    	BG4 = new ImagePanel("Images/start/frameCopper.png");
    	BG4_Text = new ImagePanel("Images/start/goldInt4.png");
    	BG5 = new ImagePanel("Images/start/frameCopper.png");
    	BG5_Text = new ImagePanel("Images/start/goldInt5.png");
    }
    
    private void SetupObjects() {
    	Background.setLocation(0, 0);
        Background.setSize(1000, 500);
        this.add(Background);
        Background.setLayout(null);
        
        
        Background.add(IngredientB2);
        Background.add(IngredientB1);
        
        
        
        MakePotionButton.setBounds(830, 400, 120, 40);
        Background.add(MakePotionButton);
        MakePotionButton.setLayout(null);
        
        MakePotionLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        MakePotionLbl.setHorizontalAlignment(SwingConstants.CENTER);
        MakePotionLbl.setBounds(0, 0, 120, 40);
        MakePotionButton.add(MakePotionLbl);
        
        TestOnStudentBox.setBounds(425, 375, 150, 40);
        Background.add(TestOnStudentBox);
        TestOnStudentBox.setLayout(null);
    	
        TickPanel.setBounds(0, 0, 40, 40);
        TestOnStudentBox.add(TickPanel);
        
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel.setBounds(40, 5, 110, 30);
        TestOnStudentBox.add(lblNewLabel);
        
        Card1.setBounds(140, 100, 160, 250);
        Background.add(Card1);
        Card1.setLayout(null);
        
        Card2.setBounds(700, 100, 160, 250);
        Background.add(Card2);
        Card2.setLayout(null);
        
        PotionDisplayer.setLayout(null);
        PotionDisplayer.setBounds(375, 100, 250, 250);
        Background.add(PotionDisplayer);
        
        DrinkButton.setLayout(null);
        DrinkButton.setBounds(475, 425, 50, 40);
        Background.add(DrinkButton);
        
        lblDrink.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDrink.setBounds(10, 5, 40, 30);
        DrinkButton.add(lblDrink);
        
        ButtonPanel.setLayout(null);
        ButtonPanel.setOpaque(false);
        ButtonPanel.setBounds(375, 25, 250, 50);
        Background.add(ButtonPanel);
        
        BG1.setLayout(null);
        BG1.setBounds(0, 0, 50, 50);
        ButtonPanel.add(BG1);
        
        BG1_Text.setLayout(null);
        BG1_Text.setBounds(5, 5, 40, 40);
        BG1.add(BG1_Text);
        
        BG2.setLayout(null);
        BG2.setBounds(50, 0, 50, 50);
        ButtonPanel.add(BG2);
        
        BG2_Text.setLayout(null);
        BG2_Text.setBounds(5, 5, 40, 40);
        BG2.add(BG2_Text);
        
        BG3.setLayout(null);
        BG3.setBounds(100, 0, 50, 50);
        ButtonPanel.add(BG3);
        
        BG3_Text.setLayout(null);
        BG3_Text.setBounds(5, 5, 40, 40);
        BG3.add(BG3_Text);
        
        BG4.setLayout(null);
        BG4.setBounds(150, 0, 50, 50);
        ButtonPanel.add(BG4);
        
        BG4_Text.setLayout(null);
        BG4_Text.setBounds(5, 5, 40, 40);
        BG4.add(BG4_Text);
        
        BG5.setLayout(null);
        BG5.setBounds(200, 0, 50, 50);
        ButtonPanel.add(BG5);
        
        BG5_Text.setLayout(null);
        BG5_Text.setBounds(5, 5, 40, 40);
        BG5.add(BG5_Text);
        
    }
    private void SetupListeners() {
    	MakePotionButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Inventory inventory = Player.getCurrPlayer().getInventory();
                
                if (Player.getCurrPlayer().isInInventory(IngredientB1.getType()) && Player.getCurrPlayer()
                        .isInInventory(IngredientB2.getType())) {
                    //TODO Make this better currently this maybe problematic
                    MakePotion(new Ingredient(IngredientB1.getType()), new Ingredient(IngredientB2.getType()), Player.getCurrPlayer());
                    IngredientB1.reset();
                    IngredientB2.reset();
                }
                
            }
        });
    	
        BG1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (chosenbg != 1) {
                    ChangeChosen(chosenbg);
                    BG1.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_GOLD));
                    chosenbg = 1	;
                    ChangeBackground(chosenbg);
                }
            }
        });
        
        BG2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (chosenbg != 2) {
                    ChangeChosen(chosenbg);
                    BG2.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_GOLD));
                    chosenbg = 2;
                    ChangeBackground(chosenbg);
                }
            }
        });
        
        BG3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (chosenbg != 3) {
                    ChangeChosen(chosenbg);
                    BG3.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_GOLD));
                    chosenbg = 3;
                    ChangeBackground(chosenbg);
                }
            }
        });
        
        BG4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (chosenbg != 4) {
                    ChangeChosen(chosenbg);
                    BG4.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_GOLD));
                    chosenbg = 4;
                    ChangeBackground(chosenbg);
                }
            }
        });
        
        BG5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (chosenbg != 5) {
                    ChangeChosen(chosenbg);
                    BG5.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_GOLD));
                    chosenbg = 5;
                    ChangeBackground(chosenbg);
                }
            }
        });
        
        TestOnStudentBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (PotionBrewingView.this.testOnStudent) {
                    TickPanel.changeImage(AssetLoader.getAssetPath(AssetLoader.Tokens.RED_X));
                } else {
                    TickPanel.changeImage(AssetLoader.getAssetPath(AssetLoader.Tokens.GREEN_TICK));
                }
                PotionBrewingView.this.testOnStudent = !PotionBrewingView.this.testOnStudent;//Sets it to it's negative
                
            }
        });
    }

    private void ChangeChosen(int i) {
    	switch (i) {
        case 1:
            BG1.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
            break;
        case 2:
            BG2.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
            break;
        case 3:
            BG3.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
            break;
        case 4:
            BG4.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
            break;
        case 5:
            BG5.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
            break;
    }
    }
    
    private void ChangeBackground(int i) {
    	switch (i) {
        case 1:
        	Background.changeImage(AssetLoader.getAssetPath(
        			AssetLoader.PotionBrewingViewAssets.BACKGROUND1));
            break;
        case 2:
        	Background.changeImage(AssetLoader.getAssetPath(
        			AssetLoader.PotionBrewingViewAssets.BACKGROUND2));
            break;
        case 3:
        	Background.changeImage(AssetLoader.getAssetPath(
        			AssetLoader.PotionBrewingViewAssets.BACKGROUND3));
            break;
        case 4:
        	Background.changeImage(AssetLoader.getAssetPath(
        			AssetLoader.PotionBrewingViewAssets.BACKGROUND4));
            break;
        case 5:
        	Background.changeImage(AssetLoader.getAssetPath(
        			AssetLoader.PotionBrewingViewAssets.BACKGROUND5));
            break;
    }
        
    }
    
    private void MakePotion(Ingredient ingredient1, Ingredient ingredient2, Player player) {
        RoundOneController roundOneController = GameController.getInstance().getRoundOneController();
        Potion potion = roundOneController.MakePotion(ingredient1.getAspects(), ingredient2.getAspects());
        player.getInventory().addPotions(potion, 1);
        
        roundOneController.removeIngredient(player, ingredient1);
        roundOneController.removeIngredient(player, ingredient2);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1020, 520);
        frame.getContentPane().add(new PotionBrewingView());
        frame.setVisible(true);
    }
    
    private void MakeExperiments(Potion potion, Player player, boolean testOnStudent) {
        RoundOneController roundOneController = GameController.getInstance().getRoundOneController();
        roundOneController.Make_experiments(player, potion, testOnStudent);
    }
}
