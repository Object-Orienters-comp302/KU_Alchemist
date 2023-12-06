package GUI_Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Models.Player;
import Utils.AssetLoader;
import javax.swing.JLabel;

public class PlayerDisplayer extends JPanel {// ToDo: needs editing and refactoring
	
	public PlayerDisplayer(Player player) {
		setPreferredSize(new Dimension(200, 80));
		setLayout(null);
		setBackground(Color.decode("#B87333"));
		//player token
		ImagePanel imgPanel = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Tokens.KHORNE));
		imgPanel.setBounds(5, 5, 70, 70);
		add(imgPanel);
		
		JPanel labelPanel_1 = new JPanel();
		labelPanel_1.setBounds(75, 5, 120, 30);
		add(labelPanel_1);
		labelPanel_1.setLayout(null);
		
		JLabel nameLabel = new JLabel("New label");
		nameLabel.setBounds(5, 0, 100, 30);
		labelPanel_1.add(nameLabel);
		
		JPanel labelPanel_2 = new JPanel();
		labelPanel_2.setBounds(75, 35, 60, 40);
		add(labelPanel_2);
		labelPanel_2.setLayout(null);
		//img for coin
		ImagePanel labelPanel_2_1 = new ImagePanel("./Images/triangleTable/minusBlue.png");
		labelPanel_2_1.setLayout(null);
		labelPanel_2_1.setBounds(0, 5, 30, 30);
		labelPanel_2.add(labelPanel_2_1);
		
		JPanel labelPanel_2_2 = new JPanel();
		labelPanel_2_2.setLayout(null);
		labelPanel_2_2.setBounds(30, 5, 30, 30);
		labelPanel_2.add(labelPanel_2_2);
		
		JLabel coinsLabel = new JLabel("123");
		coinsLabel.setBounds(0, 0, 30, 30);
		labelPanel_2_2.add(coinsLabel);
		
		JPanel labelPanel_3 = new JPanel();
		labelPanel_3.setBounds(135, 35, 60, 40);
		add(labelPanel_3);
		labelPanel_3.setLayout(null);
		
		ImagePanel labelPanel_3_1 = new ImagePanel("./Images/triangleTable/minusBlue.png");
		labelPanel_3_1.setBounds(0, 5, 30, 30);
		labelPanel_3.add(labelPanel_3_1);
		labelPanel_3_1.setLayout(null);
		
		JPanel labelPanel_3_2 = new JPanel();
		labelPanel_3_2.setBounds(30, 5, 30, 30);
		labelPanel_3_2.setLayout(null);
		labelPanel_3.add(labelPanel_3_2);
		
		JLabel pointsLabel = new JLabel("123");
		pointsLabel.setBounds(0, 0, 30, 30);
		labelPanel_3_2.add(pointsLabel);
		
	}
	
	public static void main (String[] args) {
        //TriangleTable tri = new TriangleTable("#34ebcf");
        
        
		JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.getContentPane()
                .setLayout(new GridBagLayout());
        PlayerDisplayer login = new PlayerDisplayer(null);
        frame.getContentPane()
                .add(login);
        frame.setVisible(true);
        
        
    
	}
}
