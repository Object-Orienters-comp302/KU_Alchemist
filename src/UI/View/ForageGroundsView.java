package UI.View;

import Domain.GameController;
import Domain.RoundOneController;
import Models.Ingredient;
import Models.Player;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.Potion.PotionButton;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ForageGroundsView extends JPanel {
	
	
    
    ImagePanel Background;
    ImagePanel Card;
    JTextField textField;
    
    JPanel     ButtonPanel;
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
    private ImagePanel SwitchButton_Forage;
    private ImagePanel Forage_Text;
    private ImagePanel SwitchButton_Transmutate;
    private ImagePanel Transmutate_Text;
    
   
    
    
    public ForageGroundsView() {
        
        
        this.setSize(1000, 500);
        setLayout(null);
        
        CreateObjects();
        SetupObjects();
        SetupListeners();
        

        
    }
    
    
    private void CreateObjects() {
    	Card = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.CARD));
    	Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.BACKGROUND));
    	textField = new JTextField();

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
    	Card.setBounds(421, 100, 158, 250);
        this.add(Card);
    	
        Background.setBounds(0, 0, 1000, 500);
        this.add(Background);
        Background.setLayout(null);
        
        textField.setForeground(Color.BLACK);
        textField.setEditable(false);
        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField.setText(Texts.Start.getText());
        textField.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 26));
        textField.setBounds(200, 10, 900, 32);
        Background.add(textField);
        textField.setColumns(10);
        textField.setOpaque(false);
        
        
        ButtonPanel.setLayout(null);
        ButtonPanel.setOpaque(false);
        ButtonPanel.setBounds(50, 50, 50, 250);
        Background.add(ButtonPanel);
        
        BG1.setLayout(null);
        BG1.setBounds(0, 0, 50, 50);
        ButtonPanel.add(BG1);
        
        BG1_Text.setLayout(null);
        BG1_Text.setBounds(5, 5, 40, 40);
        BG1.add(BG1_Text);
        
        BG2.setLayout(null);
        BG2.setBounds(0, 50, 50, 50);
        ButtonPanel.add(BG2);
        
        BG2_Text.setLayout(null);
        BG2_Text.setBounds(5, 5, 40, 40);
        BG2.add(BG2_Text);
        
        BG3.setLayout(null);
        BG3.setBounds(0, 100, 50, 50);
        ButtonPanel.add(BG3);
        
        BG3_Text.setLayout(null);
        BG3_Text.setBounds(5, 5, 40, 40);
        BG3.add(BG3_Text);
        
        BG4.setLayout(null);
        BG4.setBounds(0, 150, 50, 50);
        ButtonPanel.add(BG4);
        
        BG4_Text.setLayout(null);
        BG4_Text.setBounds(5, 5, 40, 40);
        BG4.add(BG4_Text);
        
        BG5.setLayout(null);
        BG5.setBounds(0, 200, 50, 50);
        ButtonPanel.add(BG5);
        
        BG5_Text.setLayout(null);
        BG5_Text.setBounds(5, 5, 40, 40);
        BG5.add(BG5_Text);
        
        SwitchButton_Forage = new ImagePanel("Images/start/frameGold.png");
        SwitchButton_Forage.setLayout(null);
        SwitchButton_Forage.setBounds(290, 380, 200, 100);
        Background.add(SwitchButton_Forage);
        
        Forage_Text = new ImagePanel("Images/buttonText/forageText.png");
        Forage_Text.setLayout(null);
        Forage_Text.setBounds(30, 25, 145, 50);
        SwitchButton_Forage.add(Forage_Text);
        
        SwitchButton_Transmutate = new ImagePanel("Images/start/frameCopper2.png");
        SwitchButton_Transmutate.setLayout(null);
        SwitchButton_Transmutate.setBounds(510, 380, 200, 100);
        Background.add(SwitchButton_Transmutate);
        
        Transmutate_Text = new ImagePanel("Images/buttonText/transmutateText.png");
        Transmutate_Text.setLayout(null);
        Transmutate_Text.setBounds(25, 20, 150, 60);
        SwitchButton_Transmutate.add(Transmutate_Text);


    	
    }
    
    private void SetupListeners() {
    	
    	 Card.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 Ingredient.IngredientTypes ingredientType =
                         CardClicked(Player.getCurrPlayer(), GameController.getInstance().getRoundOneController());
                 if (ingredientType != null) {
                     textField.setText(String.format(Texts.Success.getText(), ingredientType.getTypeString()));
                 } else {
                     textField.setText(Texts.Fail.getText());
                 }
                 
             }
         });
    	 
    	 SwitchButton_Transmutate.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 MenuView menu= GameController.getInstance().getMenuController().getMenuView();
                 menu.cardLay.show(menu.displayerPanel,"Transmute");
                 
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
    	
    }
    
    private Ingredient.IngredientTypes CardClicked(Player player,
                                                   RoundOneController roundOneController) { //Calls Forage for Ingredient on controller then, returns its type for the function.
        Ingredient ingredient = roundOneController.ForageForIngredient(player);
        if (ingredient != null) {
            return ingredient.getType();
        } else {
            return null;
        }
    }
    
    private enum Texts {
        Start("To forage press the card!! It costs 1 forage right."),
        Success("Foraging successful!! Ingredient:%s"),
        Fail("Foraging is not successful!!You can't forage more.");
        
        private final String Text;
        
        Texts(String text) {
            Text = text;
        }
        
        public String getText() {
            return Text;
        }
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
        			AssetLoader.ForageGroundsAssets.BACKGROUND1));
            break;
        case 2:
        	Background.changeImage(AssetLoader.getAssetPath(
        			AssetLoader.ForageGroundsAssets.BACKGROUND2));
            break;
        case 3:
        	Background.changeImage(AssetLoader.getAssetPath(
        			AssetLoader.ForageGroundsAssets.BACKGROUND3));
            break;
        case 4:
        	Background.changeImage(AssetLoader.getAssetPath(
        			AssetLoader.ForageGroundsAssets.BACKGROUND4));
            break;
        case 5:
        	Background.changeImage(AssetLoader.getAssetPath(
        			AssetLoader.ForageGroundsAssets.BACKGROUND5));
            break;
    }
        
    }
}