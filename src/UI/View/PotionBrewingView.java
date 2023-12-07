package UI.View;

import javax.swing.JPanel;

import Domain.GameController;
import Domain.RoundOneController;
import GUI_Components.ColorChangingPanel;
import GUI_Components.ImagePanel;
import GUI_Components_Potion.IngredientButton;
import Models.Ingredient;
import Models.Inventory;
import Models.Player;
import Models.Potion;
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
    ColorChangingPanel TestOnStudentBox;
    Boolean testOnStudent=false;
    
    public PotionBrewingView() {
        this.setSize(1000,500);
        setLayout(null);
        
        
        
        Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.PotionBrewingViewAssets.Background));
        Background.setLocation(0, 0);
        Background.setSize(1000,500);
        this.add(Background);
        Background.setLayout(null);
        
        
        IngredientButton B1= new IngredientButton(230,125,200,200,true);
        Background.add(B1);
        IngredientButton B2= new IngredientButton(570,125,200,200,true);
        Background.add(B2);
        
        
        makePotionButton = new ColorChangingPanel("#cf9d15", "#FFD700");
        makePotionButton.setBounds(830, 400, 120, 40);
        makePotionButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Inventory inventory = Player.getCurrPlayer().getInventory();
                
                if(inventory.checkIngredientExists(B1.getType()) && inventory.checkIngredientExists(B2.getType())){
                    //TODO Make this better currently this maybe problematic
                    MakeExperiments(new Ingredient(B1.getType()),new Ingredient(B2.getType()),Player.getCurrPlayer(),testOnStudent);
                }
                
            }
        });
        Background.add(makePotionButton);
        makePotionButton.setLayout(null);
        
        JLabel MakePotionLbl = new JLabel("Make Potion");
        MakePotionLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        MakePotionLbl.setHorizontalAlignment(SwingConstants.CENTER);
        MakePotionLbl.setBounds(0, 0, 120, 40);
        makePotionButton.add(MakePotionLbl);
        
        TestOnStudentBox = new ColorChangingPanel("#cf9d15", "#FFD700");
        
        TestOnStudentBox.setBounds(20, 400, 150, 40);
        Background.add(TestOnStudentBox);
        TestOnStudentBox.setLayout(null);
        
        ImagePanel TickPanel = new ImagePanel("./Images/tokens/redX.png");
        TickPanel.setBounds(0, 0, 40, 40);
        TestOnStudentBox.add(TickPanel);
        
        JLabel lblNewLabel = new JLabel("TEST ON STUDENT");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel.setBounds(40, 5, 110, 30);
        TestOnStudentBox.add(lblNewLabel);
        
        ImagePanel Card1 = new ImagePanel("./Images/ForageGroundsAssets/ingredientCard.png");
        Card1.setBounds(250, 100 ,160, 250);
        Background.add(Card1);
        Card1.setLayout(null);
        
        ImagePanel Card2 = new ImagePanel("./Images/ForageGroundsAssets/ingredientCard.png");
        Card2.setBounds(590, 100 ,160, 250);
        Background.add(Card2);
        Card2.setLayout(null);
        
        
        TestOnStudentBox.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		if(PotionBrewingView.this.testOnStudent) {
        			TickPanel.changeImage("./Images/tokens/redX.png");
        		}
        		else {
        			TickPanel.changeImage("./Images/tokens/greenTick.png");
        		}
        		PotionBrewingView.this.testOnStudent=!PotionBrewingView.this.testOnStudent;//Sets it to it's negative
        		
        	}
        });
        
        
        
        this.setVisible(true);
    }
    
    private void MakeExperiments(Ingredient ingredient1, Ingredient ingredient2, Player player, boolean testOnStudent){
        RoundOneController roundOneController = GameController.getInstance().getRoundOneController();
        Potion potion = roundOneController.MakePotion(ingredient1.getAspects(),ingredient2.getAspects());
       
        roundOneController.removeIngredient(player,ingredient1);
        roundOneController.removeIngredient(player,ingredient2);
        
        roundOneController.Make_experiments(player,potion,testOnStudent);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1020,520);
        frame.getContentPane().add(new PotionBrewingView());
        frame.setVisible(true);
    }
}
