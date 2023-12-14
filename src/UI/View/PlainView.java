package UI.View;

import Utils.AssetLoader;

import javax.swing.*;

import UI.Components.ImagePanels.HQImagePanel;

public class PlainView extends JPanel {
    
    HQImagePanel Background;
    
    public PlainView() {
        this.setSize(1000, 500);
        setLayout(null);
        
        Background = new HQImagePanel(AssetLoader.getAssetPath(AssetLoader.PlainViewAssets.BACKGROUND));
        Background.setVisible(true);
        
        Background.setBounds(0, 0, 1000, 500);
        this.add(Background);
        
        
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1020, 520);
        frame.getContentPane().add(new PlainView());
        frame.setVisible(true);
        
    }
    
}
