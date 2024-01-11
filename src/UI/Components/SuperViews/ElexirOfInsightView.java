package UI.Components.SuperViews;

import Domain.GameController;
import Models.Deck;
import Models.Ingredient;
import UI.Components.ColorChangingPanel;
import UI.Components.ImagePanels.GifPanel;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.ImagePanels.OutlinedLabel;
import UI.View.MenuView;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class ElexirOfInsightView extends JPanel {
    Color steel,gold;
    HashMap<Integer, Ingredient> firstThree;
    ImagePanel Background,ingredientCard1,ingredientCard2,ingredientCard3,ingredient1,ingredient2,ingredient3;
    JPanel card1,card2,card3,active;
    ColorChangingPanel confirmButton;
    GifPanel gif1,gif2,gif3;
   
    
    public ElexirOfInsightView(){
        setBounds(0,0,1000,500);
        setLayout(null);
        
        Deck deck =GameController.getInstance().getRoundThreeController().getDeck();
        firstThree= deck.getFirstThree();
        
        
        steel=Color.decode("#aaaaaa");
        gold=Color.decode("#ffd700");
        
        Background= new ImagePanel(AssetLoader.Backgrounds.INVENTORY);
        Background.setBounds(0,0,1000,500);
        Background.setLayout(null);
        add(Background);
        
        confirmButton = new ColorChangingPanel(steel, gold, 30, ColorChangingPanel.RoundingStyle.BOTH);
        confirmButton.setBounds(400,375,200,100);
        Background.add(confirmButton);
        confirmButton.setLayout(null);
        OutlinedLabel confirmLabel = new OutlinedLabel("CONFIRM", "#ddddd", "#ccccc", OutlinedLabel.Versions.MID_ORIENTED);
        confirmLabel.setBounds(0,0,200,100);
        confirmLabel.changeFontSize(35);
        confirmButton.add(confirmLabel);
        
        card1= new JPanel();
        card1.setBounds(100,50,200,290);
        card1.setLayout(null);
        card1.setBackground(steel);
        Background.add(card1);
        
        ingredientCard1= new ImagePanel(AssetLoader.ForageGroundsAssets.CARD);
        ingredientCard1.setBounds(5,5,190,280);
        ingredientCard1.setLayout(null);
        card1.add(ingredientCard1);
        
        card2= new JPanel();
        card2.setBounds(400,50,200,290);
        card2.setLayout(null);
        card2.setBackground(steel);
        Background.add(card2);
        
        ingredientCard2= new ImagePanel(AssetLoader.ForageGroundsAssets.CARD);
        ingredientCard2.setBounds(5,5,190,280);
        ingredientCard1.setLayout(null);
        card2.add(ingredientCard2);
        
        card3= new JPanel();
        card3.setBounds(700,50,200,290);
        card3.setLayout(null);
        card3.setBackground(steel);
        Background.add(card3);
        
        ingredientCard3= new ImagePanel(AssetLoader.ForageGroundsAssets.CARD);
        ingredientCard3.setBounds(5,5,190,280);
        ingredientCard1.setLayout(null);
        card3.add(ingredientCard3);
        
        gif1= new GifPanel(20,60,160,160,AssetLoader.Gifs.CIRCLE_BLUE.getPath());
        card1.add(gif1);
        
        card1.setComponentZOrder(gif1,0);
        gif2= new GifPanel(20,60,160,160,AssetLoader.Gifs.CIRCLE_BLUE.getPath());
        card2.add(gif2);
        card2.setComponentZOrder(gif2,0);
        gif3= new GifPanel(20,60,160,160,AssetLoader.Gifs.CIRCLE_BLUE.getPath());
        card3.add(gif3);
        card3.setComponentZOrder(gif3,0);
        
        ingredient1 = new ImagePanel(Ingredient.getPathFromType(firstThree.get(0).getType()));
        ingredient2 = new ImagePanel(Ingredient.getPathFromType(firstThree.get(1).getType()));
        ingredient3 = new ImagePanel(Ingredient.getPathFromType(firstThree.get(2).getType()));
        ingredient1.setBounds(40,80,120,120);
        ingredient2.setBounds(40,80,120,120);
        ingredient3.setBounds(40,80,120,120);
        card1.add(ingredient1,0);
        card2.add(ingredient2,0);
        card3.add(ingredient3,0);
        
        applyFunctions();
        
    }
    public void applyFunctions(){
        card1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Switcheroo(card1);
            }});
        card2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Switcheroo(card2);
            }});
        card3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Switcheroo(card3);
            }});
        confirmButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GameController.getInstance().getRoundThreeController().getDeck().setFirstThree(firstThree);
                System.out.println(GameController.getInstance().getRoundThreeController().getDeck().getIngredients());
                MenuView menu= GameController.getInstance().getMenuController().getMenuView();
                menu.LiftBlockade();
                menu.reset();
            }});
        
    }
    
    public void Switcheroo(JPanel pan){
        if (active==null){
            active=pan;
            pan.setBackground(gold);
            repaint();
            return;
        }
        Ingredient ing;
        if (active==card1){
            if (pan==card1){
                active=null;
                pan.setBackground(steel);
            }
            if (pan==card2){
                active.setBackground(steel);
                active=null;
                ingredient1.changeImage(Ingredient.getPathFromType(firstThree.get(1).getType()));
                ingredient2.changeImage(Ingredient.getPathFromType(firstThree.get(0).getType()));
                ing=firstThree.get(0);
                firstThree.put(0,firstThree.get(1));
                firstThree.put(1,ing);
            }
            if (pan==card3){
                active.setBackground(steel);
                active=null;
                ingredient1.changeImage(Ingredient.getPathFromType(firstThree.get(2).getType()));
                ingredient3.changeImage(Ingredient.getPathFromType(firstThree.get(0).getType()));
                ing=firstThree.get(0);
                firstThree.put(0,firstThree.get(2));
                firstThree.put(2,ing);
            }
        }
        if (active==card2){
            if (pan==card2){
                active=null;
                pan.setBackground(steel);
                pan.repaint();
            }
            if (pan==card1){
                active.setBackground(steel);
                active=null;
                ingredient1.changeImage(Ingredient.getPathFromType(firstThree.get(1).getType()));
                ingredient2.changeImage(Ingredient.getPathFromType(firstThree.get(0).getType()));
                
                ing=firstThree.get(0);
                firstThree.put(0,firstThree.get(1));
                firstThree.put(1,ing);
            }
            if (pan==card3){
                active.setBackground(steel);
                active=null;
                ingredient2.changeImage(Ingredient.getPathFromType(firstThree.get(2).getType()));
                ingredient3.changeImage(Ingredient.getPathFromType(firstThree.get(1).getType()));
                ing=firstThree.get(1);
                firstThree.put(1,firstThree.get(2));
                firstThree.put(2,ing);
            }
        }
        if (active==card3){
            if (pan==card3){
                active=null;
                pan.setBackground(steel);
            }
            if (pan==card1){
                active.setBackground(steel);
                active=null;
                ingredient1.changeImage(Ingredient.getPathFromType(firstThree.get(2).getType()));
                ingredient3.changeImage(Ingredient.getPathFromType(firstThree.get(0).getType()));
                ing=firstThree.get(0);
                firstThree.put(0,firstThree.get(2));
                firstThree.put(2,ing);
            }
            if (pan==card2){
                active.setBackground(steel);
                active=null;
                ingredient2.changeImage(Ingredient.getPathFromType(firstThree.get(2).getType()));
                ingredient3.changeImage(Ingredient.getPathFromType(firstThree.get(1).getType()));
                ing=firstThree.get(1);
                firstThree.put(1,firstThree.get(2));
                firstThree.put(2,ing);
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Elixir of Insight View");
            frame.setSize(1200, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            GameController.getInstance().getRoundZeroController().initializeIngredients(5);
            GameController.getInstance().getRoundThreeController().getDeck().shuffleIngredients();
            System.out.println(GameController.getInstance().getRoundThreeController().getDeck().getIngredients());
            
            ElexirOfInsightView elixirView = new ElexirOfInsightView();
            frame.add(elixirView);
            
            frame.setVisible(true);
        });
    }
    
}
