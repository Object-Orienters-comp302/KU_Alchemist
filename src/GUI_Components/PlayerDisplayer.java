package GUI_Components;

import Domain.event.Listener;
import Domain.event.Type;
import Models.Player;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;

public class PlayerDisplayer extends JPanel implements Listener {// ToDo: needs editing and refactoring
    protected Player playerIntance;
    ImagePanel avatarImgPanel;
    JPanel     labelPanel_1;
    JLabel     nameLabel;
    JPanel     labelPanel_2;
    ImagePanel labelPanel_2_1;
    JPanel     labelPanel_2_2;
    JLabel     coinsLabel;
    JPanel     labelPanel_3;
    ImagePanel labelPanel_3_1;
    JPanel     labelPanel_3_2;
    JLabel     pointsLabel;
    
    
    public PlayerDisplayer(Player player) { //TODO: Add event listener
        playerIntance = player;
        setPreferredSize(new Dimension(200, 80));
        setLayout(null);
        setBackground(Color.decode("#B87333"));
        
        playerIntance.getInventory().addListener(this);
        CreateObjects();
        SetupObjects();
    }
    
    private void CreateObjects() {
        avatarImgPanel = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Tokens.RED));
        labelPanel_1   = new JPanel();
        nameLabel      = new JLabel(playerIntance.getID());
        labelPanel_2   = new JPanel();
        labelPanel_2_1 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.EU4));
        labelPanel_2_2 = new JPanel();
        coinsLabel     = new JLabel(String.valueOf(playerIntance.getInventory().getGold()));
        labelPanel_3   = new JPanel();
        labelPanel_3_1 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.EU4));
        labelPanel_3_2 = new JPanel();
        pointsLabel    = new JLabel(String.valueOf(playerIntance.getReputation()));
    }
    
    public void SetupObjects() {
        avatarImgPanel.setBounds(5, 5, 70, 70);
        add(avatarImgPanel);
        
        labelPanel_1.setBounds(75, 5, 120, 30);
        add(labelPanel_1);
        labelPanel_1.setLayout(null);
        
        nameLabel.setBounds(5, 0, 100, 30);
        labelPanel_1.add(nameLabel);
        
        labelPanel_2.setBounds(75, 35, 60, 40);
        add(labelPanel_2);
        labelPanel_2.setLayout(null);
        //img for coin
        labelPanel_2_1.setLayout(null);
        labelPanel_2_1.setBounds(0, 5, 30, 30);
        labelPanel_2.add(labelPanel_2_1);
        
        labelPanel_2_2.setLayout(null);
        labelPanel_2_2.setBounds(30, 5, 30, 30);
        labelPanel_2.add(labelPanel_2_2);
        
        coinsLabel.setBounds(0, 0, 30, 30);
        labelPanel_2_2.add(coinsLabel);
        
        labelPanel_3.setBounds(135, 35, 60, 40);
        add(labelPanel_3);
        labelPanel_3.setLayout(null);
        
        labelPanel_3_1.setBounds(0, 5, 30, 30);
        labelPanel_3.add(labelPanel_3_1);
        labelPanel_3_1.setLayout(null);
        
        labelPanel_3_2.setBounds(30, 5, 30, 30);
        labelPanel_3_2.setLayout(null);
        labelPanel_3.add(labelPanel_3_2);
        
        pointsLabel.setBounds(0, 0, 30, 30);
        labelPanel_3_2.add(pointsLabel);
    }
    
    public static void main(String[] args) {
        Player testPlayer = new Player("TestName", null);
        
        
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.getContentPane().setLayout(new GridBagLayout());
        PlayerDisplayer login = new PlayerDisplayer(null);
        frame.getContentPane().add(login);
        frame.setVisible(true);
	}
	
	@Override
	public void onEvent(Type type) {
		if (type == Type.GOLD) {
			coinsLabel.setText(String.valueOf(playerIntance.getInventory().getGold()));
			this.revalidate();
			this.repaint();
			
		}
	}
}
