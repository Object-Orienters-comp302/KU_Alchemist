package UI.Components.Player;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Models.Potion;
import UI.Components.ImagePanels.ImagePanel;
import UI.View.MenuView;
import UI.View.ViewFactory;
import Utils.AssetLoader;

public class PlayerPotionsDisplayer extends JPanel {
	static Color shadow = new Color(44, 53, 57,150);
	
	 	JPanel con1;
	    JPanel con2;
	    JPanel con3;
	    JPanel con4;
	    JPanel con5;
	    JPanel con6;
	    JPanel con7;
	    JPanel con8;

	    ImagePanel potion1;
	    ImagePanel potion2;
	    ImagePanel potion3;
	    ImagePanel potion4;
	    ImagePanel potion5;
	    ImagePanel potion6;
	    ImagePanel potion7;
	    ImagePanel potion8;

	    JPanel shadow1;
	    JPanel shadow2;
	    JPanel shadow3;
	    JPanel shadow4;
	    JPanel shadow5;
	    JPanel shadow6;
	    JPanel shadow7;
	    JPanel shadow8;

	    public PlayerPotionsDisplayer() {
	        setLayout(null);
	        setBounds(0, 0, 125, 40);
	        CreateObjects();
	        SetupObjects();
	    }

	    private void CreateObjects() {
	        con1 = new JPanel();
	        con2 = new JPanel();
	        con3 = new JPanel();
	        con4 = new JPanel();
	        con5 = new JPanel();
	        con6 = new JPanel();
	        con7 = new JPanel();
	        con8 = new JPanel();

	        potion1 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Potions.RED_POSITIVE));
	        potion2 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Potions.GREEN_POSITIVE));
	        potion3 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Potions.BLUE_POSITIVE));
	        potion4 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Potions.RED_NEGATIVE));
	        potion5 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Potions.GREEN_NEGATIVE));
	        potion6 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Potions.BLUE_NEGATIVE));
	        potion7 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Potions.NEUTRAL));
	        potion8 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Potions.UNKNOWN));
	        
	        shadow1 = new JPanel();
	        shadow2 = new JPanel();
	        shadow3 = new JPanel();
	        shadow4 = new JPanel();
	        shadow5 = new JPanel();
	        shadow6 = new JPanel();
	        shadow7 = new JPanel();
	        shadow8 = new JPanel();
	    }

	    public void SetupObjects() {
	        setupPotionContainer(con1, potion1, 3, 5, shadow1);
	        setupPotionContainer(con2, potion2, 18, 5, shadow2);
	        setupPotionContainer(con3, potion3, 33, 5, shadow3);
	        setupPotionContainer(con4, potion4, 48, 5, shadow4);
	        setupPotionContainer(con5, potion5, 63, 5, shadow5);
	        setupPotionContainer(con6, potion6, 78, 5, shadow6);
	        setupPotionContainer(con7, potion7, 93, 5, shadow7);
	        setupPotionContainer(con8, potion8, 108, 5, shadow8);
	    }

	    private void setupPotionContainer(JPanel container, ImagePanel potion, int x, int y, JPanel shadow) {
	        container.setBounds(x, y, 15, 30);
	        container.setLayout(null);
	        add(container);

	        potion.setBounds(0, 0, 15, 30);
	        potion.setLayout(null);
	        container.add(potion);

	        shadow.setBounds(0, 0, 15, 30);
	        shadow.setBackground(PlayerPotionsDisplayer.shadow);
	        container.add(shadow);
	        container.setComponentZOrder(shadow, 0);
	    }

	    public void RemoveShadow(HashMap<Potion, Integer> map) {  //TODO: add checks
	        
	        map.forEach((key, value) -> {
				if (value>0){
					getShadow(key.getIdentity()).setOpaque(false);
				}
			});
	    }

	    private void applyShadow(JPanel shadow) {
	        boolean makeCheck = true;

	        if (makeCheck) {
	            shadow.setOpaque(true);
	        }
	    }
	public JPanel getShadow(Potion.IdentityTypes type) {
		return switch (type) {
			case  Potion.IdentityTypes.REDPOSITIVE -> shadow1;
			case  Potion.IdentityTypes.REDNEGATIVE -> shadow4;
			case  Potion.IdentityTypes.GREENPOSITIVE ->shadow2;
			case  Potion.IdentityTypes.GREENNEGATIVE -> shadow5;
			case  Potion.IdentityTypes.BLUEPOSITIVE -> shadow3;
			case  Potion.IdentityTypes.BLUENEGATIVE -> shadow6;
			case  Potion.IdentityTypes.NETURAL -> shadow7;
			case  Potion.IdentityTypes.UNKNOWN -> shadow8;
			default -> throw new IllegalStateException("Unexpected type: ");
		};
	}
		

   

    public static void main(String[] args) {
    	JFrame frame = new JFrame();
    	PlayerPotionsDisplayer disp = new PlayerPotionsDisplayer();
        frame.setSize(1300, 800);
        frame.getContentPane().setLayout(null);
        
        disp.setBackground(Color.red);
        disp.setBounds(200, 200, 200, 40);
        frame.getContentPane().add(disp);
        disp.setVisible(true);
        frame.setVisible(true);
        
    }
}