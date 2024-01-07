package UI.Components.ImagePanels;

import Utils.AssetLoader;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BackgroundSelector extends JPanel {

    ImagePanel BG1,BG2,BG3,BG4,BG5,BG1_Text,BG2_Text,BG3_Text,BG4_Text,BG5_Text,Background;
    int chosenbg=1,x,y;
    
    AssetLoader.AssetPath path1,path2,path3,path4,path5;
    
    public BackgroundSelector(boolean vertical,int x,int y,ImagePanel background,AssetLoader.AssetPath p1
            ,AssetLoader.AssetPath p2,AssetLoader.AssetPath p3,AssetLoader.AssetPath p4,AssetLoader.AssetPath p5){
        this.x=x;this.y=y;
        Background=background;
        path1=p1;
        path2=p2;
        path3=p3;
        path4=p4;
        path5=p5;
        
        BG1         = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_GOLD));
        BG1_Text    = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.GOLD_1));
        BG2         = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
        BG2_Text    = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.GOLD_2));
        BG3         = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
        BG3_Text    = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.GOLD_3));
        BG4         = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
        BG4_Text    = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.GOLD_4));
        BG5         = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
        BG5_Text    = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.GOLD_5));
        
        if (vertical) { VerticalSetup(); } else { HorizontalSetup(); }
        
        
        BG1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (chosenbg != 1) {
                    ChangeChosen(chosenbg);
                    BG1.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_GOLD));
                    chosenbg = 1;
                    ChangeBackground(chosenbg);
                }
            }
        });
        
        BG2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (chosenbg != 2) {
                    ChangeChosen(chosenbg);
                    BG2.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_GOLD));
                    chosenbg = 2;
                    ChangeBackground(chosenbg);
                }
            }
        });
        
        BG3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (chosenbg != 3) {
                    ChangeChosen(chosenbg);
                    BG3.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_GOLD));
                    chosenbg = 3;
                    ChangeBackground(chosenbg);
                }
            }
        });
        
        BG4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (chosenbg != 4) {
                    ChangeChosen(chosenbg);
                    BG4.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_GOLD));
                    chosenbg = 4;
                    ChangeBackground(chosenbg);
                }
            }
        });
        
        BG5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (chosenbg != 5) {
                    ChangeChosen(chosenbg);
                    BG5.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_GOLD));
                    chosenbg = 5;
                    ChangeBackground(chosenbg);
                }
            }
        });
        
        
    }
    
    public void VerticalSetup(){
        setLayout(null);
        setOpaque(false);
        setBounds(x, y, 50, 250);
        
        
        BG1.setLayout(null);
        BG1.setBounds(0, 0, 50, 50);
        add(BG1);
        
        BG1_Text.setLayout(null);
        BG1_Text.setBounds(5, 5, 40, 40);
        BG1.add(BG1_Text);
        
        BG2.setLayout(null);
        BG2.setBounds(0, 50, 50, 50);
        add(BG2);
        
        BG2_Text.setLayout(null);
        BG2_Text.setBounds(5, 5, 40, 40);
        BG2.add(BG2_Text);
        
        BG3.setLayout(null);
        BG3.setBounds(0, 100, 50, 50);
        add(BG3);
        
        BG3_Text.setLayout(null);
        BG3_Text.setBounds(5, 5, 40, 40);
        BG3.add(BG3_Text);
        
        BG4.setLayout(null);
        BG4.setBounds(0, 150, 50, 50);
        add(BG4);
        
        BG4_Text.setLayout(null);
        BG4_Text.setBounds(5, 5, 40, 40);
        BG4.add(BG4_Text);
        
        BG5.setLayout(null);
        BG5.setBounds(0, 200, 50, 50);
        add(BG5);
        
        BG5_Text.setLayout(null);
        BG5_Text.setBounds(5, 5, 40, 40);
        BG5.add(BG5_Text);
    }
    
    public void HorizontalSetup(){
        setLayout(null);
        setOpaque(false);
        setBounds(x, y, 250, 50);
        
        BG1.setLayout(null);
        BG1.setBounds(0, 0, 50, 50);
        add(BG1);
        
        BG1_Text.setLayout(null);
        BG1_Text.setBounds(5, 5, 40, 40);
        BG1.add(BG1_Text);
        
        BG2.setLayout(null);
        BG2.setBounds(50, 0, 50, 50);
        add(BG2);
        
        BG2_Text.setLayout(null);
        BG2_Text.setBounds(5, 5, 40, 40);
        BG2.add(BG2_Text);
        
        BG3.setLayout(null);
        BG3.setBounds(100, 0, 50, 50);
        add(BG3);
        
        BG3_Text.setLayout(null);
        BG3_Text.setBounds(5, 5, 40, 40);
        BG3.add(BG3_Text);
        
        BG4.setLayout(null);
        BG4.setBounds(150, 0, 50, 50);
        add(BG4);
        
        BG4_Text.setLayout(null);
        BG4_Text.setBounds(5, 5, 40, 40);
        BG4.add(BG4_Text);
        
        BG5.setLayout(null);
        BG5.setBounds(200, 0, 50, 50);
        add(BG5);
        
        BG5_Text.setLayout(null);
        BG5_Text.setBounds(5, 5, 40, 40);
        BG5.add(BG5_Text);
    
    }
    
    private void ChangeChosen(int i) {
        switch (i) {
            case 1:
                BG1.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
                break;
            case 2:
                BG2.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
                break;
            case 3:
                BG3.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
                break;
            case 4:
                BG4.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
                break;
            case 5:
                BG5.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_COPPER));
                break;
        }
    }
    
    private void ChangeBackground(int i) {
        switch (i) {
            case 1:
                Background.changeImage(path1);
                break;
            case 2:
                Background.changeImage(path2);
                break;
            case 3:
                Background.changeImage(path3);
                break;
            case 4:
                Background.changeImage(path4);
                break;
            case 5:
                Background.changeImage(path5);
                break;
        }
    }
    
    
}
