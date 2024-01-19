package UI.View;

import Domain.GameController;
import Domain.RoundOneController;
import Models.Ingredient;
import Models.Player;
import Networking.GameAction;
import Networking.GameClient;
import Sound.DJ;
import UI.Components.ImagePanels.BackgroundSelector;
import UI.Components.ImagePanels.GifPanel;
import UI.Components.ImagePanels.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ForageGroundsView extends JPanel {
    
    
    Boolean    showsActiveResult = false;
    GifPanel   circleGif;
    ImagePanel ingreImg;
    
    ImagePanel Background;
    ImagePanel Card;
    
    JTextField textField;

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
        Card       = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.CARD));
        Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.BACKGROUND));
        textField  = new JTextField();
        
    }
    
    private void SetupObjects() {
        
        
        Background.setBounds(0, 0, 1000, 500);
        this.add(Background);
        Background.setLayout(null);
        
        Card.setBounds(421, 100, 158, 250);
        Card.setLayout(null);
        Background.add(Card);
        
        textField.setForeground(Color.BLACK);
        textField.setEditable(false);
        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField.setText(Texts.Start.getText());
        textField.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 26));
        textField.setBounds(200, 10, 900, 32);
        Background.add(textField);
        textField.setColumns(10);
        textField.setOpaque(false);
        
        BackgroundSelector backgroundSelector = new BackgroundSelector(
                true,50,50,Background,AssetLoader.ForageGroundsAssets.BACKGROUND1,
                AssetLoader.ForageGroundsAssets.BACKGROUND2,AssetLoader.ForageGroundsAssets.BACKGROUND3,
                AssetLoader.ForageGroundsAssets.BACKGROUND4,AssetLoader.ForageGroundsAssets.BACKGROUND5);
        Background.add(backgroundSelector);
        
        SwitchButton_Forage = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_GOLD));
        SwitchButton_Forage.setLayout(null);
        SwitchButton_Forage.setBounds(290, 380, 200, 100);
        Background.add(SwitchButton_Forage);
        
        Forage_Text = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonTexts.FORAGE));
        Forage_Text.setLayout(null);
        Forage_Text.setBounds(30, 25, 145, 50);
        SwitchButton_Forage.add(Forage_Text);
        
        SwitchButton_Transmutate = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
        SwitchButton_Transmutate.setLayout(null);
        SwitchButton_Transmutate.setBounds(510, 380, 200, 100);
        Background.add(SwitchButton_Transmutate);
        
        Transmutate_Text = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonTexts.TRANSMUTE));
        Transmutate_Text.setLayout(null);
        Transmutate_Text.setBounds(25, 20, 150, 60);
        SwitchButton_Transmutate.add(Transmutate_Text);
        
        
        circleGif = new GifPanel(26, 75, 100, 100, AssetLoader.getAssetPath(AssetLoader.Gifs.CIRCLE_BLUE));
        circleGif.setLayout(null);
        ingreImg = new ImagePanel(AssetLoader.TriangleTable.QUESTION_MARK);
        ingreImg.setBounds(20, 20, 60, 60);
        circleGif.add(ingreImg);
        
    }
    
    public JTextField getTextField() {
        return textField;
    }
    
    private void SetupListeners() {
        
        Card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(GameController.getInstance().isOnline()){
                    if(Player.getCurrPlayer().getForageRight() >= 1){
                        GameClient.getInstance().sendAction(new GameAction(GameAction.ActionType.FORAGE, "Wants to forage", Player.getCurrPlayer().getID(),
                                                                           (Ingredient.IngredientTypes) null));
                        
                    }
                    else {
                        textField.setText(Texts.Fail.getText());
                    }
                    
                }
                else {
                Ingredient.IngredientTypes ingredientType =
                        CardClicked(Player.getCurrPlayer(), GameController.getInstance().getRoundOneController());
                if (ingredientType != null) {
                    textField.setText(String.format(Texts.Success.getText(), ingredientType.getTypeString()));
                    SwingUtilities.invokeLater(() -> RunForageAnimation(ingredientType));
                    //RunForageAnimation(ingredientType);
                } else {
                    textField.setText(Texts.Fail.getText());
                }
                
            }}
        });
        
        
        SwitchButton_Transmutate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuView menu = GameController.getInstance().getMenuController().getMenuView();
                menu.cardLay.show(menu.displayerPanel, "Transmute");
                
            }
        });
        
    }
    
    private Ingredient.IngredientTypes CardClicked(Player player,
                                                   RoundOneController roundOneController) { //Calls Forage for Ingredient on controller then, returns its type for the function.
        
        Ingredient.IngredientTypes ingredient = roundOneController.ForageForIngredient(player);
        if (ingredient != null) {
            return ingredient;
        } else {
            return null;
        }
    }
    
    public void RunForageAnimation(Ingredient.IngredientTypes ingre) {
        GameController.getInstance().getMenuController().getMenuView().Blockade();
        DJ dj = DJ.getDJ();
        dj.setAndStartEffectSound(DJ.EffectSounds.LEAVES, 2000);
        
        
        GifPanel gif = new GifPanel(0, 0, 1000, 500, AssetLoader.getAssetPath(AssetLoader.Gifs.LEAVES));
        Background.add(gif);
        Background.setComponentZOrder(gif, 0);
        Background.repaint();
        
        Timer timer = new Timer(1530, (e) -> {
            Background.remove(gif);
            
            if (!showsActiveResult) {
                showsActiveResult = true;
                
                Card.add(circleGif);
                ingreImg.changeImage(AssetLoader.getAssetPath(Ingredient.getPathFromType(ingre)));
                ingreImg.repaint();
                Background.repaint();
            } else {
                ingreImg.changeImage(AssetLoader.getAssetPath(Ingredient.getPathFromType(ingre)));
                ingreImg.repaint();
            }
            
            GameController.getInstance().getMenuController().getMenuView().LiftBlockade();
        });
        
        timer.setRepeats(false);
        timer.start();
    }
    

    
    public enum Texts {
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
    public void reset(){
        textField.setText(Texts.Start.getText());
        if (circleGif!=null){
            Card.remove(circleGif);
            showsActiveResult=false;
            Card.repaint();
        }
    }
}