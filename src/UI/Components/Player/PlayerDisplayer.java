package UI.Components.Player;

import Domain.Event.Listener;
import Domain.Event.Type;
import Models.Player;
import UI.Components.CutRoundedPanel;
import UI.Components.ImagePanels.ImagePanel;

import UI.Components.RoundedPanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;

public class PlayerDisplayer extends RoundedPanel implements Listener {// ToDo: needs editing and refactoring
    protected Player playerInstance;
    CutRoundedPanel container;
    ImagePanel avatarImgPanel;
    JPanel labelPanel_1;
    JLabel nameLabel;
    JPanel labelPanel_2;
    ImagePanel labelPanel_2_1;
    JPanel labelPanel_2_2;
    JLabel coinsLabel;
    JPanel labelPanel_3;
    ImagePanel labelPanel_3_1;
    JPanel labelPanel_3_2;
    JLabel pointsLabel;
    PlayerPotionsDisplayer potionsPanel;

    public PlayerDisplayer(Player player) {
        super(20);
        playerInstance = player;
        setPreferredSize(new Dimension(260, 80));
        setLayout(null);
        this.setBackground(Color.decode("#B87333"));//TODO:add color change for current player

        playerInstance.getInventory().addListener(this);
        CreateObjects();
        SetupObjects();
    }

    private void CreateObjects() {
    	container = new CutRoundedPanel(20);
        avatarImgPanel = new ImagePanel(playerInstance.getToken().getImage());
        labelPanel_1 = new JPanel();
        nameLabel = new JLabel(playerInstance.getID());
        labelPanel_2 = new JPanel();
        labelPanel_2_1 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.EU4));
        labelPanel_2_2 = new JPanel();
        coinsLabel = new JLabel(String.valueOf(playerInstance.getInventory().getGold()));
        labelPanel_3 = new JPanel();
        labelPanel_3_1 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.EU4));
        labelPanel_3_2 = new JPanel();
        pointsLabel = new JLabel(String.valueOf(playerInstance.getReputation()));
        potionsPanel = new PlayerPotionsDisplayer();
    }

    public void SetupObjects() {
        container.setLayout(null);
        container.setBounds(5, 5, 250, 70);

        avatarImgPanel.setBounds(0, 0, 70, 70);
        container.add(avatarImgPanel);

        labelPanel_1.setBounds(70, 0, 125, 30);
        container.add(labelPanel_1);
        labelPanel_1.setLayout(null);

        nameLabel.setBounds(5, 0, 115, 30);
        labelPanel_1.add(nameLabel);

        labelPanel_2.setBounds(195, 0, 55, 35);
        container.add(labelPanel_2);
        labelPanel_2.setLayout(null);

        labelPanel_2_1.setLayout(null);
        labelPanel_2_1.setBounds(0, 2, 30, 30);
        labelPanel_2.add(labelPanel_2_1);

        labelPanel_2_2.setLayout(null);
        labelPanel_2_2.setBounds(30, 2, 30, 30);
        labelPanel_2.add(labelPanel_2_2);

        coinsLabel.setBounds(0, 0, 30, 30);
        labelPanel_2_2.add(coinsLabel);

        labelPanel_3.setBounds(195, 35, 55, 35);
        container.add(labelPanel_3);
        labelPanel_3.setLayout(null);

        labelPanel_3_1.setBounds(0, 2, 30, 30);
        labelPanel_3.add(labelPanel_3_1);
        labelPanel_3_1.setLayout(null);

        labelPanel_3_2.setBounds(30, 2, 30, 30);
        labelPanel_3_2.setLayout(null);
        labelPanel_3.add(labelPanel_3_2);

        pointsLabel.setBounds(0, 0, 30, 30);
        labelPanel_3_2.add(pointsLabel);

        potionsPanel.setLayout(null);
        potionsPanel.setBounds(70, 30, 125, 40);
        container.add(potionsPanel);

        add(container); 
    }
    
    
    

    @Override
    public void onEvent(Type type) {
        if (type == Type.GOLD) {
            coinsLabel.setText(String.valueOf(playerInstance.getInventory().getGold()));
            this.revalidate();
            this.repaint();
        }
    }
}