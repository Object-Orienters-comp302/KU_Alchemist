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
        
        JLabel MakePotionLbl = new JLabel("Resume Game");
        MakePotionLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
        MakePotionLbl.setHorizontalAlignment(SwingConstants.CENTER);
        MakePotionLbl.setBounds(0, 0, 200, 200);
        resumeButton.add(MakePotionLbl);
        
        
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
