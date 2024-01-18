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

public class ElixirOfInsightView extends JPanel {
    private static final Color STEEL = Color.decode("#aaaaaa");
    private static final Color GOLD = Color.decode("#ffd700");
    private HashMap<Integer, Ingredient.IngredientTypes> firstThree;
    private ImagePanel background, ingredientCard1, ingredientCard2, ingredientCard3;
    private JPanel card1, card2, card3, active;
    private ColorChangingPanel confirmButton;
    private GifPanel gif1, gif2, gif3;
    private ImagePanel ingredient1, ingredient2, ingredient3;
    
    public ElixirOfInsightView() {
        setBounds(0,0,1000,500);
        setLayout(null);
        
        Deck deck =GameController.getInstance().getRoundThreeController().getDeck();
        firstThree= deck.getFirstThree();
        
        
        background= new ImagePanel(AssetLoader.Backgrounds.INVENTORY);
        background.setBounds(0,0,1000,500);
        background.setLayout(null);
        add(background);
        
        confirmButton = new ColorChangingPanel(STEEL, GOLD, 30, ColorChangingPanel.RoundingStyle.BOTH);
        confirmButton.setBounds(400,375,200,100);
        background.add(confirmButton);
        confirmButton.setLayout(null);
        OutlinedLabel confirmLabel = new OutlinedLabel("CONFIRM", "#ddddd", "#ccccc", OutlinedLabel.Versions.MID_ORIENTED);
        confirmLabel.setBounds(0,0,200,100);
        confirmLabel.changeFontSize(35);
        confirmButton.add(confirmLabel);
        
        card1= new JPanel();
        card1.setBounds(100,50,200,290);
        card1.setLayout(null);
        card1.setBackground(STEEL);
        background.add(card1);
        
        ingredientCard1= new ImagePanel(AssetLoader.ForageGroundsAssets.CARD);
        ingredientCard1.setBounds(5,5,190,280);
        ingredientCard1.setLayout(null);
        card1.add(ingredientCard1);
        
        card2= new JPanel();
        card2.setBounds(400,50,200,290);
        card2.setLayout(null);
        card2.setBackground(STEEL);
        background.add(card2);
        
        ingredientCard2= new ImagePanel(AssetLoader.ForageGroundsAssets.CARD);
        ingredientCard2.setBounds(5,5,190,280);
        ingredientCard2.setLayout(null);
        card2.add(ingredientCard2);
        
        card3= new JPanel();
        card3.setBounds(700,50,200,290);
        card3.setLayout(null);
        card3.setBackground(STEEL);
        background.add(card3);
        
        ingredientCard3= new ImagePanel(AssetLoader.ForageGroundsAssets.CARD);
        ingredientCard3.setBounds(5,5,190,280);
        ingredientCard3.setLayout(null);
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
        
        ingredient1 = new ImagePanel(Ingredient.getPathFromType(firstThree.get(0)));
        ingredient2 = new ImagePanel(Ingredient.getPathFromType(firstThree.get(1)));
        ingredient3 = new ImagePanel(Ingredient.getPathFromType(firstThree.get(2)));
        ingredient1.setBounds(40,80,120,120);
        ingredient2.setBounds(40,80,120,120);
        ingredient3.setBounds(40,80,120,120);
        card1.add(ingredient1,0);
        card2.add(ingredient2,0);
        card3.add(ingredient3,0);
        applyFunctions();
    }
    private ColorChangingPanel createConfirmButton() {
        ColorChangingPanel button = new ColorChangingPanel(STEEL, GOLD, 30, ColorChangingPanel.RoundingStyle.BOTH);
        button.setBounds(400, 375, 200, 100);
        button.setLayout(null);
        
        OutlinedLabel confirmLabel = new OutlinedLabel("CONFIRM", "#ddddd", "#ccccc", OutlinedLabel.Versions.MID_ORIENTED);
        confirmLabel.setBounds(0, 0, 200, 100);
        confirmLabel.changeFontSize(35);
        button.add(confirmLabel);
        
        return button;
    }
    private void applyFunctions() {
        addMouseListenerToCard(card1, card2, card3);
        addMouseListenerToConfirmButton(confirmButton);
    }
    private void addMouseListenerToCard(JPanel... cards) {
        for (JPanel card : cards) {
            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (active == null){
                        setActivePanel(card);
                    }
                    else{
                        swapIngredientsAndReset(card);
                    }
                }
            });
        }
    }
    private void addMouseListenerToConfirmButton(JPanel button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GameController.getInstance().getRoundOneController().ElixirOfInsightAbility(firstThree);
                MenuView menu = GameController.getInstance().getMenuController().getMenuView();
                menu.LiftBlockade();
                menu.reset();
            }
        });
    }
    private void switchPanel(JPanel selectedPanel) {
        if (active == null) {
            setActivePanel(selectedPanel);
            return;
        }
        
        swapIngredientsAndReset(selectedPanel);
    }
    private void setActivePanel(JPanel panel) {
        active = panel;
        panel.setBackground(GOLD);
        repaint();
    }
    
    private void swapIngredientsAndReset(JPanel selectedPanel) {
        if (active != selectedPanel) {
            swapIngredients(selectedPanel);
        }
        resetActivePanel(selectedPanel);
    }
    private void swapIngredients(JPanel selectedPanel) {
        int activeIndex = getPanelIndex(active);
        int selectedIndex = getPanelIndex(selectedPanel);
        ImagePanel activeIngredient = getIngredientPanel(activeIndex);
        ImagePanel selectedIngredient = getIngredientPanel(selectedIndex);
        
        Ingredient.IngredientTypes temp = firstThree.get(activeIndex);
        firstThree.put(activeIndex, firstThree.get(selectedIndex));
        firstThree.put(selectedIndex, temp);
        
        activeIngredient.changeImage(Ingredient.getPathFromType(firstThree.get(activeIndex)));
        selectedIngredient.changeImage(Ingredient.getPathFromType(firstThree.get(selectedIndex)));
    }
    
    private void resetActivePanel(JPanel panel) {
        if (active != null) {
            active.setBackground(STEEL);
        }
        active = null;
        panel.repaint();
    }
    
    private int getPanelIndex(JPanel panel) {
        if (panel == card1) return 0;
        if (panel == card2) return 1;
        if (panel == card3) return 2;
        return -1; // Or handle this case appropriately
    }
    
    private ImagePanel getIngredientPanel(int index) {
        if (index == 0) return ingredient1;
        if (index == 1) return ingredient2;
        if (index == 2) return ingredient3;
        return null; // Or handle this case appropriately
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
            
            ElixirOfInsightView elixirView = new ElixirOfInsightView();
            frame.add(elixirView);
            
            frame.setVisible(true);
        });
    }
    
}
