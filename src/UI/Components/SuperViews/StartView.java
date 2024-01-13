package UI.Components.SuperViews;

import Domain.Event.Listener;
import Domain.Event.Publisher;
import Domain.Event.Type;
import Sound.DJ;
import UI.Components.ColorChangingPanel;
import UI.Components.CutRoundedPanel;
import UI.Components.ImagePanels.HQImagePanel;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.ImagePanels.OutlinedLabel;
import UI.View.ViewFactory;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class StartView extends JPanel implements Publisher {
    
    int             chosen = 2;
    int             version;
    ImagePanel      Background;
    ImagePanel      NamePanel;
    ImagePanel      StartButton;
    JPanel          ButtonPanel;
    ColorChangingPanel versionSelection1,versionSelection2,versionSelection3;
    OutlinedLabel vLabel1,vLabel2,vLabel3;
    HQImagePanel        B1,B2,B3;

    ImagePanel    selectHost,selectJoin;
    ArrayList<Listener> Listeners;
    
    
    public StartView() {
        this.Listeners = new ArrayList<>();
        setBounds(0, 0, 1280, 720);
        setBackground(Color.BLUE);
        setLayout(null);
        
        Random random = new Random();
        
        
        version = random.nextInt(3) + 1;
        
        CreateBase();
        SetupBase();
        SetupListenersBase();
        /*
        CreateObjectsForHost();
        SetupObjectsForHost();
        SetupListenersForHost();
        */
        
        DJ dj=DJ.getDJ();
        //dj.setAndStartBackgroundSound(DJ.BackgroundSounds.TRACK1);
        //dj.adjustBackgroundVolume(-20f);
    }
    
    private void CreateBase(){
        Background  = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.START_BACKGROUND));
        NamePanel   = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.NAME_TEXT));
        
        selectHost  = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_YELLOW));
        
        selectJoin  = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_YELLOW));
        versionSelection1= new ColorChangingPanel("#FFEB7E", "#FCB709", 30, ColorChangingPanel.RoundingStyle.BOTH);
        versionSelection2=new  ColorChangingPanel("#FFEB7E", "#FCB709", 30, ColorChangingPanel.RoundingStyle.BOTH);
        versionSelection3=new  ColorChangingPanel("#FFEB7E", "#FCB709", 30, ColorChangingPanel.RoundingStyle.BOTH);
        
        vLabel1=new OutlinedLabel("BASE", "#FFFFFF", "#CCCCCC", OutlinedLabel.Versions.MID_ORIENTED);
        vLabel2=new OutlinedLabel("PRESIDENT", "#FFFFFF", "#CCCCCC", OutlinedLabel.Versions.MID_ORIENTED);
        vLabel3=new OutlinedLabel("ANIME", "#FFFFFF", "#CCCCCC", OutlinedLabel.Versions.MID_ORIENTED);
        
    }
    private void SetupBase(){
        Background.setBounds(0, 0, 1280, 720);
        add(Background);
        Background.setLayout(null);
        Background.setOpaque(false);
        
        NamePanel.setBounds(340, 50, 600, 200);
        Background.add(NamePanel);
        
        selectHost.setBounds(100,250,500,200);
        Background.add(selectHost);
        selectHost.setLayout(null);
        
        ImagePanel hostText = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonTexts.HOST));
        hostText.setLayout(null);
        hostText.setBounds(150, 50, 200, 100);
        selectHost.add(hostText);
        
        selectJoin.setBounds(600,250,500,200);
        Background.add(selectJoin);
        selectJoin.setLayout(null);
        
        ImagePanel joinText = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonTexts.JOIN));
        joinText.setLayout(null);
        joinText.setBounds(150, 50, 200, 100);
        selectJoin.add(joinText);
        
        versionSelection1.setBounds(200,550,200,100);
        Background.add(versionSelection1);
        versionSelection1.setLayout(null);
        
        vLabel1.setBounds(0,0,200,100);
        vLabel1.changeFontSize(30);
        versionSelection1.add(vLabel1);
        
        versionSelection2.setBounds(500,550,200,100);
        Background.add(versionSelection2);
        versionSelection2.setLayout(null);
       
        vLabel2.setBounds(0,0,200,100);
        vLabel2.changeFontSize(30);
        versionSelection2.add(vLabel2);
        
        versionSelection3.setBounds(800,550,200,100);
        Background.add(versionSelection3);
        versionSelection3.setLayout(null);
        
        vLabel3.setBounds(0,0,200,100);
        vLabel3.changeFontSize(30);
        versionSelection3.add(vLabel3);
        
        VersionSelection(version);
    }
    private void SetupListenersBase() {
        selectHost.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CleanupBase();
                CreateObjectsForHost();
                SetupObjectsForHost();
                SetupListenersForHost();
                repaint();
            }
        });
        versionSelection1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                VersionSelection(1);
            }
        });
        versionSelection2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                VersionSelection(2);
            }
        });
        versionSelection3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                VersionSelection(3);
            }
        });
        
    }
    public void VersionSelection(int i){
        //"#FFEB7E", "#FCB709"
        getVersionPanel(version).changeDefaultColors("#FFEB7E");
        version=i;
        getVersionPanel(version).changeDefaultColors("#FCB709");
        
    }
    
    public ColorChangingPanel getVersionPanel(int i){
        switch (i){
            case 1-> {
                return versionSelection1;
            }
            case 2->{
                return versionSelection2;
            }
            case 3->{
                return versionSelection3;
            }
        }
        return null;
    }
    
    public void CleanupBase(){
        Background.remove(selectJoin);
        Background.remove(selectHost);
        Background.remove(versionSelection1);
        Background.remove(versionSelection2);
        Background.remove(versionSelection3);
        Background.repaint();
    }
    
    private void CreateObjectsForHost() {
        
        
        ButtonPanel = new JPanel();
        B1          = new HQImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_YELLOW));
        B2          = new HQImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_WHITE));
        B3          = new HQImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_WHITE));
    }
    
    private void SetupObjectsForHost() {

        
       
        
        ButtonPanel.setBounds(240, 260, 800, 200);
        ButtonPanel.setOpaque(false);
        Background.add(ButtonPanel);
        ButtonPanel.setLayout(null);
        
        B1.setLayout(null);
        B1.setBounds(0, 0, 200, 200);
        ButtonPanel.add(B1);
        
        ImagePanel B1_Text = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.GOLD_2));
        B1_Text.setLayout(null);
        B1_Text.setBounds(55, 55, 90, 90);
        B1.add(B1_Text);
        
        B2.setLayout(null);
        B2.setBounds(300, 0, 200, 200);
        ButtonPanel.add(B2);
        
        ImagePanel B2_Text = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.GOLD_3));
        B2_Text.setLayout(null);
        B2_Text.setBounds(55, 55, 90, 90);
        B2.add(B2_Text);
        
        B3.setLayout(null);
        B3.setBounds(600, 0, 200, 200);
        ButtonPanel.add(B3);
        
        ImagePanel B3_Text = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.GOLD_4));
        B3_Text.setLayout(null);
        B3_Text.setBounds(55, 55, 90, 90);
        B3.add(B3_Text);
        
        StartButton = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_YELLOW));
        StartButton.setBounds(435, 500, 400, 120);
        StartButton.setLayout(null);
        
        Background.add(StartButton);
        
        ImagePanel StartButtonText = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.NAME_TEXT));
        StartButtonText.setLayout(null);
        StartButtonText.setBounds(140, 43, 120, 30);
        StartButton.add(StartButtonText);
    }
    
    private void SetupListenersForHost() {
        StartButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ViewFactory.getInstance().getLoginView().setPlayerAmount(chosen);
                ViewFactory.getInstance().getLoginView().generateTokens(version);
                publishEvent(Type.START_LOGIN_SCREEN);
                
            }
        });
        B1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (chosen != 2) {
                    ChangeChosen(chosen);
                    B1.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_YELLOW));
                    
                    chosen = 2;
                }
            }
        });
        
        B2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (chosen != 3) {
                    ChangeChosen(chosen);
                    B2.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_YELLOW));
                    
                    chosen = 3;
                }
            }
        });
        
        B3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (chosen != 4) {
                    ChangeChosen(chosen);
                    B3.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_YELLOW));
                    chosen = 4;
                }
            }
        });
        
    }
    
    @Override
    public void publishEvent(Type type) {
        for (Listener listener : Listeners) {
            listener.onEvent(type);
        }
    }
    
    private void ChangeChosen(int i) {
        switch (i) {
            case 2:
                B1.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_WHITE));
                break;
            case 3:
                B2.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_WHITE));
                break;
            case 4:
                B3.changeImage(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_WHITE));
                break;
        }
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.getContentPane().setLayout(null);
        StartView login = new StartView();
        frame.getContentPane().add(login);
        frame.setVisible(true);
    }
    
    @Override
    public void addListener(Listener lis) {
        this.Listeners.add(lis);
    }
    
}