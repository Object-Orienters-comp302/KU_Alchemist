package UI.View;

import Domain.Event.Listener;
import Domain.Event.Publisher;
import Domain.Event.Type;
import UI.Components.ColorChangingPanel;
import UI.Components.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PauseView extends JPanel implements Publisher {
    ImagePanel         Background;
    ColorChangingPanel resumeButton;
    ColorChangingPanel goToHelpScreen;
    private ArrayList<Listener> listeners;
    
    protected PauseView() {
        this.listeners = new ArrayList<>();
        
        this.setBounds(0, 0, 1280, 720);
        this.setOpaque(false);
        setLayout(null);
        
        this.Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.MAIN_BACKGROUND));
        Background.setBounds(0, 0, 1280, 720);
        Background.setLayout(null);
        this.add(Background);
        
        resumeButton = new ColorChangingPanel("#cf9d15", "#FFD700");
        resumeButton.setBounds(540, 260, 200, 200);
        resumeButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                publishEvent(Type.START_MENUVIEW);
            }
        });
        Background.add(resumeButton);
        resumeButton.setLayout(null);
        
        
        goToHelpScreen = new ColorChangingPanel("#cf9d15", "#FFD700");
        goToHelpScreen.setBounds(1080, 0, 200, 200);
        goToHelpScreen.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                publishEvent(Type.HELP);
            }
        });
        Background.add(goToHelpScreen);
        goToHelpScreen.setLayout(null);
        
        JLabel goToHelpScreenLbl = new JLabel("Resume Game");
        goToHelpScreenLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
        goToHelpScreenLbl.setHorizontalAlignment(SwingConstants.CENTER);
        goToHelpScreenLbl.setBounds(0, 0, 200, 200);
        goToHelpScreen.add(goToHelpScreenLbl);
        
        JLabel goToHelpLbl = new JLabel("Go To Help");
        goToHelpLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
        goToHelpLbl.setHorizontalAlignment(SwingConstants.CENTER);
        goToHelpLbl.setBounds(0, 0, 200, 200);
        resumeButton.add(goToHelpLbl);
        
        
        this.setVisible(true);
    }
    
    @Override
    public void publishEvent(Type type) {
        for (Listener listener : listeners) {
            listener.onEvent(type);
        }
    }
    
    @Override
    public void addListener(Listener lis) {
        listeners.add(lis);
    }
    
}
