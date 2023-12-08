package UI.Components.Subviews;

import UI.Components.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartView extends JPanel {
    
    int chosen = 2;
    
    ImagePanel Background;
    ImagePanel NamePanel;
    JPanel     ButtonPanel;
    
    ImagePanel B1;
    ImagePanel B2;
    ImagePanel B3;
    ImagePanel B4;
    
    public StartView() {
        setBounds(0, 0, 1280, 720);
        setBackground(Color.BLUE);
        setLayout(null);
        
        CreateObjects();
        SetupObjects();
        SetupListeners();
    }
    
    private void CreateObjects() {
        Background  = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.BACKGROUND));
        NamePanel   = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.NAME_TEXT));
        ButtonPanel = new JPanel();
        B1          = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_GOLD));
        B2          = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
        B3          = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
        B4          = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
    }
    
    private void SetupObjects() {
        Background.setBounds(0, 0, 1280, 720);
        add(Background);
        Background.setLayout(null);
        
        NamePanel.setBounds(340, 50, 600, 200);
        Background.add(NamePanel);
        
        ButtonPanel.setBounds(240, 260, 800, 200);
        ButtonPanel.setOpaque(false);
        Background.add(ButtonPanel);
        ButtonPanel.setLayout(null);
        
        B1.setLayout(null);
        B1.setBounds(0, 0, 200, 200);
        ButtonPanel.add(B1);
        
        ImagePanel B1_Text = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.GOLD_2));
        B1_Text.setLayout(null);
        B1_Text.setBounds(10, 10, 180, 180);
        B1.add(B1_Text);
        
        B2.setLayout(null);
        B2.setBounds(200, 0, 200, 200);
        ButtonPanel.add(B2);
        
        ImagePanel B2_Text = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.GOLD_3));
        B2_Text.setLayout(null);
        B2_Text.setBounds(10, 10, 180, 180);
        B2.add(B2_Text);
        
        B3.setLayout(null);
        B3.setBounds(400, 0, 200, 200);
        ButtonPanel.add(B3);
        
        ImagePanel B3_Text = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.GOLD_4));
        B3_Text.setLayout(null);
        B3_Text.setBounds(10, 10, 180, 180);
        B3.add(B3_Text);
        
        B4.setLayout(null);
        B4.setBounds(600, 0, 200, 200);
        ButtonPanel.add(B4);
        
        ImagePanel B4_Text = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.GOLD_5));
        B4_Text.setLayout(null);
        B4_Text.setBounds(10, 10, 180, 180);
        B4.add(B4_Text);
        
        ImagePanel StartButton = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_GOLD));
        StartButton.setBounds(490, 500, 300, 100);
        StartButton.setLayout(null);
        Background.add(StartButton);
        
        ImagePanel StartButtonText = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.NAME_TEXT));
        StartButtonText.setLayout(null);
        StartButtonText.setBounds(30, 20, 240, 60);
        StartButton.add(StartButtonText);
    }
    
    private void SetupListeners() {
        B1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (chosen != 2) {
                    ChangeChosen(chosen);
                    B1.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_GOLD));
                    
                    chosen = 2;
                }
            }
        });
        
        B2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (chosen != 3) {
                    ChangeChosen(chosen);
                    B2.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_GOLD));
                    
                    chosen = 3;
                }
            }
        });
        
        B3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (chosen != 4) {
                    ChangeChosen(chosen);
                    B3.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_GOLD));
                    chosen = 4;
                }
            }
        });
        
        B4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (chosen != 5) {
                    ChangeChosen(chosen);
                    B4.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_GOLD));
                    chosen = 5;
                }
            }
        });
    }
    
    private void ChangeChosen(int i) {
        switch (i) {
            case 2:
                B1.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
                break;
            case 3:
                B2.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
                break;
            case 4:
                B3.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
                break;
            case 5:
                B4.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
                break;
        }
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1294, 757);
        frame.getContentPane().setLayout(null);
        StartView login = new StartView();
        frame.getContentPane().add(login);
        frame.setVisible(true);
    }
}