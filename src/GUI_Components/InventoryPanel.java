package GUI_Components;

import java.awt.GridLayout;

import javax.swing.JPanel;

import Models.Player;
import Utils.AssetLoader;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;

public class InventoryPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	Player player;
	
	ImagePanel Background;
	
	JPanel Ingredient_panel;
	JPanel Potion_panel;
	
	ImagePanel feather;
	ImagePanel feet;
	ImagePanel flower;
	ImagePanel frog;
	ImagePanel mandrake;
	ImagePanel mushroom;
	ImagePanel scorpion;
	ImagePanel weed;
	
	JLabel Ingredient_card_title;
	JLabel Potion_title;
	
	JLabel feather_quantity;
	JLabel feet_quantity;
	JLabel flower_quantity;
	JLabel frog_quantity;
	JLabel mandrake_quantity;
	JLabel mushroom_quantity;
	JLabel scorpion_quantity;
	JLabel weeed_quantity;
	

	/**
	 * Create the panel.
	 */
	
	public InventoryPanel(Player player) {
		
		this.player = player;
	    this.setSize(1000,500);
        setLayout(null);
        this.PlacePlayer();
        
        Background = new ImagePanel("C:/Users/baris/Documents/GitHub/KU_Alchemist/Images/ForageGroundsAssets/forageGrounds.png");
        Background.setForeground(SystemColor.desktop);
        Background.setLocation(0, 0);
        Background.setSize(1000,500);
        this.add(Background);
        Background.setLayout(null);
        
        JPanel Ingredient_panel = new JPanel();
        Ingredient_panel.setOpaque(false);
        Ingredient_panel.setBounds(100, 120, 800, 100);
        Background.add(Ingredient_panel);
        Ingredient_panel.setLayout(new GridLayout(1,8));
        
        JPanel Potion_panel = new JPanel();
        Potion_panel.setOpaque(false);
        Potion_panel.setBounds(100, 340, 800, 100);
        Background.add(Potion_panel);
        Potion_panel.setLayout(new GridLayout(1,7));
        

        // adding Ingredient Images
        feather = new ImagePanel("./Images/book/flower.png");
        Ingredient_panel.add(feather);
        
        feet = new ImagePanel("./Images/book/feather.png");
        Ingredient_panel.add(feet);
        
        flower = new ImagePanel("./Images/book/feet.png");
        Ingredient_panel.add(flower);

        frog = new ImagePanel("./Images/book/frog.png");
        Ingredient_panel.add(frog);
        
        mandrake = new ImagePanel("./Images/book/mandrake.png");
        Ingredient_panel.add(mandrake);
        
        mushroom = new ImagePanel("./Images/book/mushroom.png");
        Ingredient_panel.add(mushroom);
        
        scorpion = new ImagePanel("./Images/book/scorpion.png");
        Ingredient_panel.add(scorpion);
        
        weed = new ImagePanel("./Images/book/weed.png");
        Ingredient_panel.add(weed);
        
        
        // Titles
        JLabel Ingredient_card_title = new JLabel("Ingredient Cards");
        Ingredient_card_title.setForeground(SystemColor.desktop);
        Ingredient_card_title.setFont(new Font("Tahoma", Font.BOLD, 25));
        Ingredient_card_title.setBounds(400, 80, 300, 34);
        Background.add(Ingredient_card_title);
        
        JLabel Potion_title = new JLabel("Potions");
        Potion_title.setForeground(SystemColor.desktop);
        Potion_title.setFont(new Font("Tahoma", Font.BOLD, 25));
        Potion_title.setBounds(400, 300, 300, 34);
        Background.add(Potion_title);
        
        //Quantity Labels
        feather_quantity = new JLabel("0");
        feather_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        feather_quantity.setBounds(140, 210, 45, 50);
        Background.add(feather_quantity);
        
        feet_quantity = new JLabel("0");
        feet_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        feet_quantity.setBounds(240, 210, 45, 50);
        Background.add(feet_quantity);
        
        flower_quantity = new JLabel("0");
        flower_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        flower_quantity.setBounds(340, 210, 45, 50);
        Background.add(flower_quantity);
        
        frog_quantity = new JLabel("0");
        frog_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        frog_quantity.setBounds(440, 210, 45, 50);
        Background.add(frog_quantity);
        
        mandrake_quantity = new JLabel("0");
        mandrake_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        mandrake_quantity.setBounds(540, 210, 45, 50);
        Background.add(mandrake_quantity);
        
        mushroom_quantity = new JLabel("0");
        mushroom_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        mushroom_quantity.setBounds(640, 210, 45, 50);
        Background.add(mushroom_quantity);
        
        scorpion_quantity = new JLabel("0");
        scorpion_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        scorpion_quantity.setBounds(740, 210, 45, 50);
        Background.add(scorpion_quantity);
       
        weeed_quantity = new JLabel("0");
        weeed_quantity.setFont(new Font("Tahoma", Font.PLAIN, 35));
        weeed_quantity.setBounds(840, 210, 45, 50);
        Background.add(weeed_quantity);
        
        
        
        this.setVisible(true);
        
        
		
	}
	
	public void PlacePlayer() {
        PlayerDisplayer comp=new PlayerDisplayer(null);
        comp.setBounds(10, 10, 200, 80);
        this.add(comp);
        comp.setLayout(null);
	}
	

}
