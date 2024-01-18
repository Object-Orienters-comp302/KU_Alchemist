package UI.Components.SuperViews;

import Domain.Event.Listener;
import Domain.Event.Publisher;
import Domain.Event.Type;
import Domain.GameController;
import Networking.GameClient;
import Networking.GameServer;
import Sound.DJ;
import UI.Components.ColorChangingPanel;
import UI.Components.ImagePanels.HQImagePanel;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.ImagePanels.OutlinedLabel;
import UI.Components.RoundedPanel;
import UI.View.ViewFactory;
import Utils.AssetLoader;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class StartView extends JPanel implements Publisher {
    
    int chosen = 2;
    
    ImagePanel Background;
    ImagePanel NamePanel;
    ImagePanel StartButton;
    ImagePanel selectJoinReal;
    JPanel     ButtonPanel;
    
    HQImagePanel        B1,B2,B3;

    ImagePanel    selectHost,selectJoin;
    ArrayList<Listener> Listeners;
    private ImagePanel selectSinglePlayer;
    private ImagePanel singleText;
    private ImagePanel selectMultiPlayer;
    private ImagePanel multiText;
    
    
    public StartView() {
        this.Listeners = new ArrayList<>();
        setBounds(0, 0, 1280, 720);
        setBackground(Color.BLUE);
        setLayout(null);
        
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
        
        selectJoinReal = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_YELLOW_CROPPED));
        
        selectMultiPlayer = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_YELLOW_FULL));
        selectSinglePlayer = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Start.FRAME_YELLOW_FULL));
        
    }
    private void SetupBase(){
        Background.setBounds(0, 0, 1280, 720);
        add(Background);
        Background.setLayout(null);
        Background.setOpaque(false);
        
        NamePanel.setBounds(340, 50, 600, 200);
        Background.add(NamePanel);
        
        selectHost.setBounds(100,250,500,200);
        selectHost.setLayout(null);
        
        ImagePanel hostText = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonTexts.HOST));
        hostText.setLayout(null);
        hostText.setBounds(150, 50, 200, 100);
        selectHost.add(hostText);
        
        selectJoin.setBounds(600,250,500,200);
        selectJoin.setLayout(null);
        
        /*
        selectJoinReal.setBounds(600,450,500,200);
        Background.add(selectJoinReal);
        selectJoinReal.setLayout(null);
        */
        ImagePanel joinText = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonTexts.JOIN));
        joinText.setLayout(null);
        joinText.setBounds(150, 50, 200, 100);
        selectJoin.add(joinText);
        
        
        selectSinglePlayer.setLayout(null);
        selectSinglePlayer.setBounds(350, 475, 500, 200);
        Background.add(selectSinglePlayer);
        
        singleText = new ImagePanel(AssetLoader.ButtonTexts.SINGLE);
        singleText.setLayout(null);
        singleText.setBounds(50, 50, 400, 100);
        selectSinglePlayer.add(singleText);
        
        
        selectMultiPlayer.setLayout(null);
        selectMultiPlayer.setBounds(350, 250, 500, 200);
        Background.add(selectMultiPlayer);
        
        multiText = new ImagePanel(AssetLoader.ButtonTexts.MULTI);
        multiText.setLayout(null);
        multiText.setBounds(50, 50, 400, 100);
        selectMultiPlayer.add(multiText);
        
    }
    private void SetupMultiplayer(){
        Background.remove(selectSinglePlayer);
        Background.remove(selectMultiPlayer);
        Background.add(selectHost);
        Background.add(selectJoin);
        Background.repaint();
        
    }
    private void SetupListenersBase() {
        selectMultiPlayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SetupMultiplayer();
            }
        });

        selectHost.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Thread(() -> {
                    try {
                        GameServer.init(12345); // Port number
                        GameController.getInstance().setOnline(true);
                        GameServer.getInstance().addListener(ViewFactory.getInstance().getWaitingRoomView());
                        SwingUtilities.invokeLater(() -> {
                            publishEvent(Type.START_WAITING_ROOM);
                        });
                        
                        GameServer.getInstance().start();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }).start();
                GameController.getInstance().setOnline(true);
                GameController.getInstance().setHost(true);
            }
        });
        
        selectJoin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    GameClient.init("localhost", 12345); //TODO: Ask for port and ip in gui
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                GameController.getInstance().setOnline(true);
                //ViewFactory.getInstance().getLoginView().setPlayerAmount(1);
                publishEvent(Type.START_ONLINE_LOGIN_SCREEN);
            }
        });
        
        selectSinglePlayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CleanupBase();
                CreateObjectsForHost();
                SetupObjectsForHost();
                SetupListenersForHost();
                repaint();
            }
        });
        
        
    }
    
    public void CleanupBase(){
        Background.remove(selectJoin);
        Background.remove(selectHost);
        Background.remove(selectJoinReal);
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
        
        Background.remove(selectSinglePlayer);
        Background.remove(selectMultiPlayer);
    }
    
    private void SetupListenersForHost() {
        StartButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ViewFactory.getInstance().getLoginView().setPlayerAmount(chosen);
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
    private void setupObjectsForMulti(boolean isHost){
        CleanupBase();
        RoundedPanel panel = new RoundedPanel(40);
        panel.setLayout(null);
        panel.setBounds(515,300,250,250);
        
        OutlinedLabel portLabel = new OutlinedLabel("PORT:", "#aaafff", "#fffaaf", OutlinedLabel.Versions.MID_ORIENTED);
        portLabel.setBounds(25,20,200,30);
        panel.add(portLabel);
        
        
        // Text Field 1
        JTextField textField1 = new JTextField(); //Port
        textField1.setBounds(25, 50, 200, 30);
        textField1.setBorder(null);
        panel.add(textField1);
        
        OutlinedLabel ipLabel = new OutlinedLabel("IP:", "#aaafff", "#fffaaf", OutlinedLabel.Versions.MID_ORIENTED);
        ipLabel.setBounds(25, 80, 200, 30);
        
        JTextField textField2 = new JTextField(); // IP
        textField2.setBounds(25, 110, 200, 30);
        textField2.setBorder(null);
        if (!isHost) {
            panel.add(ipLabel);
            panel.add(textField2);
        }
        // Button
        ColorChangingPanel button = new ColorChangingPanel("#fffaaf", "#aaafff", 40, ColorChangingPanel.RoundingStyle.BOTH);
        button.setBounds(50, 160, 150, 50);
        button.setLayout(null);
        OutlinedLabel lab = new OutlinedLabel("JOIN", "#aaafff", "#fffaaf", OutlinedLabel.Versions.MID_ORIENTED);
        lab.setSize(button.getSize());lab.setLocation(0,0);
        button.add(lab);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle button click event
                String text1 = textField1.getText(); //Port
                if (!isHost) {
                    String text2 = textField2.getText(); //IP
                }
                //do stuff functions go wild
            }
        });
        panel.add(button);
        Background.add(panel);
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