package UI.View;

import Domain.Event.Listener;
import Domain.Event.Publisher;
import Domain.Event.Type;
import Models.Player;
import Models.Token;
import UI.Components.ColorChangingPanel;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.SuperViews.WaitingRoomView;
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
        
        this.Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.HELP_BACKGROUND));
        Background.setBounds(0, 0, 1280, 720);
        Background.setLayout(null);
        this.add(Background);
        
        goBackToPause = new ColorChangingPanel("#cf9d15", "#FFD700");
        goBackToPause.setBounds(1080, 0, 200, 100);
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
        MakePotionLbl.setBounds(0, 0, 200, 100);
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
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setSize(1290, 720);
        frame.add(new HelpScreenView());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
