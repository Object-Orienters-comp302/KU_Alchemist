package UI.View;

import Domain.Event.Listener;
import Domain.Event.Publisher;
import Domain.Event.Type;
import UI.Components.ColorChangingPanel;
import UI.Components.ImagePanels.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class HelpScreenView extends JPanel implements Publisher {
    ImagePanel         Background;
    ColorChangingPanel goBackToPause;
    private ArrayList<Listener> listeners;
    
    protected HelpScreenView() {
        this.listeners = new ArrayList<>();
        
        this.setBounds(0, 0, 1280, 720);
        this.setOpaque(false);
        setLayout(null);
        
        this.Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.MAIN_BACKGROUND));
        Background.setBounds(0, 0, 1280, 720);
        Background.setLayout(null);
        this.add(Background);
        
        goBackToPause = new ColorChangingPanel("#cf9d15", "#FFD700");
        goBackToPause.setBounds(540, 260, 200, 200);
        goBackToPause.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                publishEvent(Type.PAUSE);
            }
        });
        Background.add(goBackToPause);
        goBackToPause.setLayout(null);
        
        JLabel MakePotionLbl = new JLabel("GoBackToPause");
        MakePotionLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
        MakePotionLbl.setHorizontalAlignment(SwingConstants.CENTER);
        MakePotionLbl.setBounds(0, 0, 200, 200);
        goBackToPause.add(MakePotionLbl);
        
        
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
