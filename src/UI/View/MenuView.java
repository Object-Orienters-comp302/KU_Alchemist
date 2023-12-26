package UI.View;

import Domain.Event.Listener;
import Domain.Event.Publisher;
import Domain.Event.Type;
import Domain.GameController;
import Domain.MenuController;
import Models.Player;
import UI.Components.CutRoundedPanel;
import UI.Components.ImagePanels.HQImagePanel;
import UI.Components.ImagePanels.ImageChangingPanel;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.Player.PlayerDisplayer;
import UI.Components.Publish.BooksDisplayer;
import Utils.AssetLoader;
import Utils.GUtil;
import Utils.KawaseBlur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

public class MenuView extends JPanel implements Publisher,Listener {
    JPanel             basePanel;
    JPanel             topPanel;
    ImagePanel         pause;
    HQImagePanel       backGroundImage;
    CutRoundedPanel    displayerPanel;
    CardLayout         cardLay;
    //tables
    JPanel             tablesPanel;
    BooksDisplayer     theoriesPanel;
    PotionBrewingView  PotionBrewingPanel;
    ForageGroundsView  ForagePanel;
    PlainView          PlainPanel;
    InventoryView      InventoryPanel;
    TransmuteView      TransmutePanel;
    BuyArtifactView    BuyArtifactPanel;
    //other?
    JPanel             bottomPanel;
    JPanel             sidePanel;
    //buttons of side panel
    ImageChangingPanel side1;
    ImageChangingPanel side2;
    ImageChangingPanel side3;
    ImageChangingPanel side4;
    ImageChangingPanel side5;
    ImageChangingPanel side6;
    ImageChangingPanel side7;
    ImageChangingPanel nextPlayerButton;
    
    private MenuController      controller;
    private ArrayList<Listener> listeners;
    
    
    public MenuView() {
        controller = GameController.getInstance().getMenuController();
        setLayout(null);
        CreateObjects();
        ApplyStuff();
        ApplyFuncs();
        PlacePlayers();
        
        GameController.getInstance().addListener(this);
    }
    
    private void CreateObjects() {
        this.listeners = new ArrayList<>();
        basePanel      = new JPanel();
        topPanel       = new JPanel();
        pause          = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.PAUSE));
        
        
        cardLay            = new CardLayout();
        displayerPanel     = new CutRoundedPanel(10);
        tablesPanel        = new DeductionView();
        theoriesPanel      = new BooksDisplayer();
        PotionBrewingPanel = new PotionBrewingView();
        ForagePanel        = new ForageGroundsView();
        PlainPanel         = new PlainView();
        InventoryPanel     = new InventoryView();
        TransmutePanel     = new TransmuteView();
        BuyArtifactPanel    = new BuyArtifactView();
        
        bottomPanel = new JPanel();
        
        
        sidePanel = new JPanel();
        //Add assetloader when a new asset is given.
        side1 = new ImageChangingPanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.TABLE_0),
                                       AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.TABLE_1),1);
        side2 = new ImageChangingPanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.PUBLISH_1),
                                       AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.PUBLISH_0),1);
        side3 = new ImageChangingPanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.LAB_0),
                                       AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.LAB_1),1);
        side4 = new ImageChangingPanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.JUNGLE_0),
                                       AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.JUNGLE_1),1);
        side5 = new ImageChangingPanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.INVENTORY_0),
                                       AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.INVENTORY_1),1);
        side6 = new ImageChangingPanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.TRANS_0),
                                       AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.TRANS_1));
        side7 = new ImageChangingPanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.TRANS_0),
                                       AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.TRANS_1));
        nextPlayerButton = new ImageChangingPanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.TRANS_0),
                                       AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.TRANS_1));
        
        BufferedImage background = KawaseBlur.applyKawaseBlur(Objects.requireNonNull(
                GUtil.fetchImage(AssetLoader.getAssetPath(AssetLoader.Backgrounds.MAIN_BACKGROUND))), 3, 2);
        backGroundImage = new HQImagePanel(background);
    }
    
    private void ApplyStuff() {
        basePanel.setBounds(0, 0, 1280, 720);
        add(basePanel);
        //basePanel.setBackground(Color.red);
        basePanel.setOpaque(false);
        basePanel.setLayout(null);
        
        
        topPanel.setBounds(0, 0, 1280, 90);
        topPanel.setOpaque(false);
        basePanel.add(topPanel);
        topPanel.setBackground(Color.black);
        topPanel.setLayout(null);
        
        pause.setBounds(1170, 5, 80, 80);
        topPanel.add(pause);
        
        displayerPanel.setBounds(5, 90, 1000, 500);
        displayerPanel.setOpaque(false);
        basePanel.add(displayerPanel);
        displayerPanel.setBackground(Color.red);
        displayerPanel.setLayout(cardLay);
        
        displayerPanel.add(PlainPanel, "Plain");
        
        displayerPanel.add(tablesPanel, "Tables");
        
        displayerPanel.add(theoriesPanel, "Theories");
        
        displayerPanel.add(PotionBrewingPanel, "Brewing");
        
        displayerPanel.add(ForagePanel, "Foraging");
        
        displayerPanel.add(InventoryPanel, "Inventory");
        
        displayerPanel.add(TransmutePanel, "Transmute");
        
        displayerPanel.add(BuyArtifactPanel, "BuyArtifact");
        
        bottomPanel.setBounds(0, 590, 1000, 130);
        bottomPanel.setOpaque(false);
        basePanel.add(bottomPanel);
        
        
        backGroundImage.setBounds(0, 0, 1280, 720);
        backGroundImage.setLayout(null);
        basePanel.add(backGroundImage);
        sidePanel.setBounds(1000, 90, 280, 630);
        sidePanel.setOpaque(false);
        backGroundImage.add(sidePanel);
        sidePanel.setLayout(null);
        sidePanel.setBackground(Color.black);
        
        
        ImagePanel sideText1 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonTexts.DEDUCT));
        sideText1.setBounds(20, 15, 240, 55);
        sidePanel.add(sideText1);
        
        side1.setBounds(10, 5, 260, 75);
        sidePanel.add(side1);
        
        
        ImagePanel sideText2 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonTexts.PUBLISH));
        sideText2.setBounds(20, 95, 240, 55);
        sidePanel.add(sideText2);
        
        side2.setBounds(10, 85, 260, 75);
        sidePanel.add(side2);
        
        
        ImagePanel sideText3 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonTexts.EXPERIMENT));
        sideText3.setBounds(20, 180, 240, 55);
        sidePanel.add(sideText3);
        
        side3.setBounds(10, 165, 260, 75);
        sidePanel.add(side3);
        
        
        ImagePanel sideText4 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonTexts.FORAGE));
        sideText4.setBounds(20, 260, 240, 55);
        sidePanel.add(sideText4);
        
        side4.setBounds(10, 245, 260, 75);
        sidePanel.add(side4);
        
        
        ImagePanel sideText5 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonTexts.INVENTORY));
        sideText5.setBounds(20, 340, 240, 55);
        sidePanel.add(sideText5);
        
        side5.setBounds(10, 325, 260, 75);
        sidePanel.add(side5);
        
        
        ImagePanel sideText6 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonTexts.TRANSMUTE));
        sideText6.setBounds(20, 420, 240, 55);
        sidePanel.add(sideText6);
        
        side6.setBounds(10, 405, 260, 75);
        sidePanel.add(side6);
        
        side7.setBounds(10, 490, 260, 75);
        sidePanel.add(side7);
        
        nextPlayerButton.setBounds(10, 570, 260, 75);
        sidePanel.add(nextPlayerButton);
        
        
    }
    
    private void ApplyFuncs() {
        side1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLay.show(displayerPanel, "Tables");
            }
        });
        side2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLay.show(displayerPanel, "Theories");
            }
        });
        side3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLay.show(displayerPanel, "Brewing");
            }
        });
        side4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLay.show(displayerPanel, "Foraging");
            }
        });
        side5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLay.show(displayerPanel, "Inventory");
            }
        });
        side6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLay.show(displayerPanel, "Transmute");
            }
        });
        side7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLay.show(displayerPanel, "BuyArtifact");
            }
        });
        pause.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                publishEvent(Type.PAUSE);
            }
        });
        nextPlayerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GameController.getInstance().nextPlayer();
            }
        });
    }
    
    public void PlacePlayers() {
        ArrayList<Player> playerList = controller.getPlayers();
        System.out.println(playerList);
        int playerCount = playerList.size();
        
        for (int i = 0; i < playerCount; i++) {
            PlayerDisplayer displayer = new PlayerDisplayer(playerList.get(i));
            
            
            displayer.setBounds((i * 265 + 40), 5, 260, 80);
            topPanel.add(displayer);
        }
        
    }
    
    @Override
    public void publishEvent(Type type) {
        for (Listener listener : listeners) {
            listener.onEvent(type);
        }
    }
    
    public static void main(String[] args) {
        new Player("01", null);
        new Player("02", null);
        JFrame frame = new JFrame();
        MenuView menuView = ViewFactory.getInstance().getMenuView();
        frame.setSize(1300, 800);
        frame.add(menuView);
        menuView.setVisible(true);
        frame.setVisible(true);
    }
    
    public void CleanPanel(Container panel) {
        panel.removeAll();
        panel.revalidate();
    }
    
    @Override
    public void addListener(Listener lis) {
        listeners.add(lis);
    }
    
    @Override
    public void onEvent(Type type) {
        if (type == Type.INGREDIENT) {
        }

    }
}