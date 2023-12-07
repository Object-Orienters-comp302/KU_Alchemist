package UI.View;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI_Components.HQImagePanel;
import GUI_Components.ImagePanel;
import Utils.AssetLoader;

public class PlainView extends JPanel {
    
    HQImagePanel Background;
    
    public PlainView() {
        this.setSize(1000, 500);
        setLayout(null);
        
        Background = new HQImagePanel(AssetLoader.getAssetPath(AssetLoader.PlainViewAssets.Background));
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
