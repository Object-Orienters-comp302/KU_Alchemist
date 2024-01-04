package UI.Components.Sound;

import Sound.DJ;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.Potion.IngredientButtonPopup;
import UI.Components.RoundedPanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SoundButtonPopup extends JPanel {
    
    int x,y,size;
    boolean paused=false,muted=false;
    double verticalM=5,horizontalM=3;
    public SoundButtonPopup(int x,int y,int size,ImagePanel parent){
        this.x=x;this.y=y;this.size=size;
        this.setOpaque(false);
        
        
        int i=1;
        for (DJ.BackgroundSounds Song:DJ.BackgroundSounds.values()){
            SongSelectionButton track = new SongSelectionButton(i,Song);
            track.setBounds(size+size/20,size*(i+1)+i*size/20+size/3,size,size);
            add(track);
            i++;
        }
        
        setBounds(x-size,y-size,size*3+size/10,size*(i+2));
        this.setBackground(Color.red);
        this.setLayout(null);
        RoundedPanel horizon = new RoundedPanel(size);
        horizon.setBounds(size/20, size+size/10, (int) (size*horizontalM), size);
        add(horizon);
        horizon.setLayout(null);
        RoundedPanel vertical = new RoundedPanel(size);
        vertical.setLayout(null);
        vertical.setBounds(size+size/20,size/10,size,size*(i+1)+i*size/10);
        add(vertical);
        
        ImagePanel continuePause = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Sound.PAUSEGOLD));
        continuePause.setBounds((size*3-size*11/8)/2+size/20,size+size/10-((size*11/8)/2)+size/2,size*11/8,size*11/8);
        add(continuePause);
        setComponentZOrder(continuePause,0);
        
        ImagePanel lower = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Sound.MINUS));
        lower.setBounds(size/16,size/8,size*3/4,size*3/4);
        horizon.add(lower);
        
        ImagePanel higher = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Sound.PLUS));
        higher.setBounds(size*3-size/16-size*3/4,size/8,size*3/4,size*3/4);
        horizon.add(higher);
        
        ImagePanel mute = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Sound.NOTEANTIGOLD));
        mute.setBounds(size/8,size/16,size*3/4,size*3/4);
        vertical.add(mute);
        
        
        mute.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DJ dj=DJ.getDJ();
                if (muted){
                    dj.startBackgroundSound();
                    mute.changeImage(AssetLoader.Sound.NOTEGOLD.getPath());
                    parent.changeImage(AssetLoader.Sound.NOTEGOLD.getPath());
                    muted=false;
                    
                }
                else{
                    dj.stopBackgroundSound();
                    mute.changeImage(AssetLoader.Sound.NOTEANTIGOLD.getPath());
                    parent.changeImage(AssetLoader.Sound.NOTEANTIGOLD.getPath());
                    muted=true;
                }
                
            }
        });
        
        continuePause.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DJ dj=DJ.getDJ();
                if (paused){
                    dj.startBackgroundSound();
                    continuePause.changeImage(AssetLoader.Sound.PAUSEGOLD.getPath());
                    paused=false;
                    
                }
                else{
                    dj.stopBackgroundSound();
                    continuePause.changeImage(AssetLoader.Sound.CONTINUEGOLD.getPath());
                    paused=true;
                }
                
            }
        });
        
        lower.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DJ.getDJ().adjustBackgroundVolume(-5f);
            }
        });
        
        higher.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DJ.getDJ().adjustBackgroundVolume(5f);
            }
        });
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Container parent = SoundButtonPopup.this.getParent();
                
                if (parent != null) {
                    
                    parent.remove(SoundButtonPopup.this);
                    parent.revalidate();
                    parent.repaint();
                    
                }
                
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                Container parent = SoundButtonPopup.this.getParent();
                if (parent != null) {
                    Point mousePoint = e.getPoint();
                    
                    // Check if the mouse is still within the bounds of the parent component
                    if (SoundButtonPopup.this.contains(mousePoint)) {
                        return;
                    }
                    parent.remove(SoundButtonPopup.this);
                    parent.revalidate();
                    parent.repaint();
                }
                
            }
        });
        
    }
    
    
    
    public static void main(String[] args) { // TODO: Move to UnitTests
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1294, 757);
        frame.getContentPane().setLayout(null);
        
        
        SoundButtonPopup ro = new SoundButtonPopup(100,100,100,null);
        frame.getContentPane().add(ro);
        frame.setVisible(true);
    }
    
}
