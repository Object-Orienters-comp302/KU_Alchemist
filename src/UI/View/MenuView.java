package UI.View;

import Domain.Event.Listener;
import Domain.Event.Publisher;
import Domain.Event.Type;
import Domain.GameController;
import Domain.MenuController;
import Models.Ingredient;
import Models.Player;
import Models.PublicationTrack;
import Sound.DJ;
import UI.Components.ColorChangingPanel;
import UI.Components.CutRoundedPanel;
import UI.Components.ImagePanels.HQImagePanel;
import UI.Components.ImagePanels.ImageBlurPanel;
import UI.Components.ImagePanels.ImageChangingPanel;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.Player.PlayerDisplayer;
import UI.Components.Publish.BooksDisplayer;
import UI.Components.Sound.SoundButton;
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
    
    ColorChangingPanel TESTBUTTON;
    
    JPanel             Block;
    
    JPanel             basePanel;
    JPanel             topPanel;
    ImagePanel         pause;
    HQImagePanel       backGroundImage;
    CutRoundedPanel    displayerPanel;
    CardLayout         cardLay;
    //tables
    DeductionView             tablesPanel;
    BooksDisplayer     theoriesPanel;
    PotionBrewingView  PotionBrewingPanel;
    ForageGroundsView ForagePanel;
    CustomPlainView         CustomPlainPanel;
    InventoryView     InventoryPanel;
    TransmuteView TransmutePanel;
    MarketView    MarketPanel;
    //other?
    JPanel        bottomPanel;
    JPanel             sidePanel;
    //buttons of side panel
    ImageBlurPanel     side1;
    ImageBlurPanel side2;
    ImageBlurPanel side3;
    ImageBlurPanel side4;
    ImageBlurPanel side5;
    ImageBlurPanel side6;
    ImageBlurPanel side7;
    ImageBlurPanel nextPlayerButton;
    private JPanel RoundCounterPanel;
    private JLabel roundLabel;
    
    SoundButton soundSettings;
    
    private MenuController      controller;
    private ArrayList<Listener> listeners;
    
    
    public MenuView() {
        controller = GameController.getInstance().getMenuController();
        GameController.getInstance().getMenuController().setMenuView(this);
        setLayout(null);
        CreateObjects();
        ApplyStuff();
        ApplyFuncs();
        PlacePlayers();
        
        GameController.getInstance().addListener(this);
    }
    
    private void CreateObjects() {
        TESTBUTTON = new ColorChangingPanel("#fcbe03","#a9fc03");
        
        this.listeners = new ArrayList<>();
        basePanel      = new JPanel();
        topPanel       = new JPanel();
        pause          = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.PAUSE));
        Block          = new JPanel();
        
        
        cardLay            = new CardLayout();
        displayerPanel     = new CutRoundedPanel(10);
        tablesPanel        = new DeductionView();
        theoriesPanel      = new BooksDisplayer();
        PotionBrewingPanel = new PotionBrewingView();
        ForagePanel      = new ForageGroundsView();
        CustomPlainPanel = new CustomPlainView();
        InventoryPanel   = new InventoryView();
        TransmutePanel = new TransmuteView();
        MarketPanel    = new MarketView();
        
        bottomPanel = new JPanel();
        
        
        sidePanel = new JPanel();
        //Add assetloader when a new asset is given.
        side1 = new ImageBlurPanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.TABLE_0),1);
        side2 = new ImageBlurPanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.PUBLISH_1),1);
        side3 = new ImageBlurPanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.LAB_0),1);
        side4 = new ImageBlurPanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.JUNGLE_0),1);
        side5 = new ImageBlurPanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.INVENTORY_0),1);
        side6 = new ImageBlurPanel(AssetLoader.getAssetPath(AssetLoader.ButtonBackgrounds.TRANS_0),1);
        nextPlayerButton = new ImageBlurPanel(AssetLoader.getAssetPath(AssetLoader.Artifacts.INQUISITION),1);
        
        BufferedImage background = KawaseBlur.applyKawaseBlur(Objects.requireNonNull(
                GUtil.fetchImage(AssetLoader.getAssetPath(AssetLoader.Backgrounds.MAIN_BACKGROUND))), 3, 2);
        backGroundImage = new HQImagePanel(background);
        
        RoundCounterPanel = new JPanel();

        
        roundLabel = new JLabel("1");
    }
    
    private void ApplyStuff() {
        Block.setBackground(new Color(255,255,255,0));
        Block.setBounds(0,0,1280,720);
        
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
        
        pause.setBounds(1180, 5, 80, 80);
        topPanel.add(pause);
        
        soundSettings= new SoundButton(40,40,40);
        basePanel.add(soundSettings);
        
        
        displayerPanel.setBounds(5, 90, 1000, 500);
        displayerPanel.setOpaque(false);
        basePanel.add(displayerPanel);
        displayerPanel.setBackground(Color.red);
        displayerPanel.setLayout(cardLay);
        
        displayerPanel.add(CustomPlainPanel, "Plain");
        
        displayerPanel.add(tablesPanel, "Tables");
        
        displayerPanel.add(theoriesPanel, "Theories");
        
        displayerPanel.add(PotionBrewingPanel, "Brewing");
        
        displayerPanel.add(ForagePanel, "Foraging");
        
        displayerPanel.add(InventoryPanel, "Inventory");
        
        displayerPanel.add(TransmutePanel, "Transmute");
        
        displayerPanel.add(MarketPanel, "BuyArtifact");
        
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
        
        side1.setBounds(10, 0, 260, 80);
        sidePanel.add(side1);
        
        
        ImagePanel sideText2 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonTexts.PUBLISH));
        sideText2.setBounds(20, 99, 240, 55);
        sidePanel.add(sideText2);
        
        side2.setBounds(10, 84, 260, 80);
        sidePanel.add(side2);
        
        
        ImagePanel sideText3 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonTexts.EXPERIMENT));
        sideText3.setBounds(20, 183, 240, 55);
        sidePanel.add(sideText3);
        
        side3.setBounds(10, 168, 260, 80);
        sidePanel.add(side3);
        
        
        ImagePanel sideText4 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonTexts.FORAGE));
        sideText4.setBounds(20, 267, 240, 55);
        sidePanel.add(sideText4);
        
        side4.setBounds(10, 252, 260, 80);
        sidePanel.add(side4);
        
        
        ImagePanel sideText5 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonTexts.INVENTORY));
        sideText5.setBounds(20, 351, 240, 55);
        sidePanel.add(sideText5);
        
        side5.setBounds(10, 336, 260, 80);
        sidePanel.add(side5);
        
        
        ImagePanel sideText6 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonTexts.MARKET));
        sideText6.setBounds(20, 435, 240, 55);
        sidePanel.add(sideText6);
        
        side6.setBounds(10, 420, 260, 80);
        sidePanel.add(side6);
        
        //side7.setBounds(10, 490, 260, 75);
        //sidePanel.add(side7);
        
        ImagePanel sideText7 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ButtonTexts.NEXT));
        sideText7.setBounds(20, 535, 240, 55);
        sidePanel.add(sideText7);
        
        
        nextPlayerButton.setBounds(10, 510, 260, 100);
        sidePanel.add(nextPlayerButton);
        
        RoundCounterPanel.setBounds(1100, 1, 57, 90);
        RoundCounterPanel.setOpaque(false);
        topPanel.add(RoundCounterPanel);
        RoundCounterPanel.setLayout(null);
        
        roundLabel.setFont(new Font("Tahoma", Font.PLAIN, 99));
        roundLabel.setForeground(Color.WHITE);
        roundLabel.setBounds(2, 0, 57, 89);
        RoundCounterPanel.add(roundLabel);
        
        bottomPanel.setLayout(null);
        //TESTBUTTON.setBounds(20,20,200,100);
        //bottomPanel.add(TESTBUTTON);
        
    }
    
    private void ApplyFuncs() {
        
        getClass().getResource("/artifact/artifactCard.png");
        
        side1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLay.show(displayerPanel, "Tables");
            }
        });
        side2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                if (GameController.getInstance().getRound() > 1) {
                    if(GameController.getInstance().isOnline()) {
                        if(Player.getCurrPlayer().getID().equals(GameController.getInstance().getPlayerName())){
                            cardLay.show(displayerPanel, "Theories");
                        }
                    }else{
                        cardLay.show(displayerPanel, "Theories");
                    }
                }
           
            }
        });
        side3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
    
                if(GameController.getInstance().isOnline()) {
                    if(Player.getCurrPlayer().getID().equals(GameController.getInstance().getPlayerName())){
                        cardLay.show(displayerPanel, "Brewing");
                    }
                }else{
                    cardLay.show(displayerPanel, "Brewing");
                }
                
            }
        });
        side4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(GameController.getInstance().isOnline()) {
                    if(Player.getCurrPlayer().getID().equals(GameController.getInstance().getPlayerName())){
                        cardLay.show(displayerPanel, "Foraging");
                    }
                    
                }else{
                    cardLay.show(displayerPanel, "Foraging");
                }
            }
        });
        side5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                if(GameController.getInstance().isOnline()) {
                    if(Player.getCurrPlayer().getID().equals(GameController.getInstance().getPlayerName())){
                        cardLay.show(displayerPanel, "Inventory");
                    }
                }else{
                    cardLay.show(displayerPanel, "Inventory");
                }
            }
        });
        side6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                if(GameController.getInstance().isOnline()) {
                    if(Player.getCurrPlayer().getID().equals(GameController.getInstance().getPlayerName())){
                        cardLay.show(displayerPanel, "BuyArtifact");
                    }
                }else{
                    cardLay.show(displayerPanel, "BuyArtifact");               
                  DJ.getDJ().setAndStartEffectSound(DJ.EffectSounds.CHACHING,2000);

                }
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
                if(GameController.getInstance().isOnline()){
                    if(Player.getCurrPlayer().getID().equals(GameController.getInstance().getPlayerName())) {
                        GameController.getInstance().nextPlayer();
                        roundLabel.setText(GameController.getInstance().getRound().toString());
                        PlayerDisplayer.repaintAll();
                        reset();
                    }
                }else {
                    GameController.getInstance().nextPlayer();
                    roundLabel.setText(GameController.getInstance().getRound().toString());
                    PlayerDisplayer.repaintAll();
                    reset();
                }
            }
        });
        side1.addTheEnterSound();
        side2.addTheEnterSound();
        side3.addTheEnterSound();
        side4.addTheEnterSound();
        side5.addTheEnterSound();
        side6.addTheEnterSound();
        nextPlayerButton.addTheEnterSound();
        
        Block.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                e.consume();
            }
        });
        
        TESTBUTTON.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               System.out.println(PublicationTrack.getInstance().getPublicationCards());
               System.out.println(Ingredient.getIngredientTypeToAspectTrioMap());
                MarketPanel.reset();
            }
        });
    }
    
    public void PlacePlayers() {
        ArrayList<Player> playerList = controller.getPlayers();
        System.out.println(playerList);
        int playerCount = playerList.size();
        
        for (int i = 0; i < playerCount; i++) {
            PlayerDisplayer displayer = new PlayerDisplayer(playerList.get(i));
            
            
            displayer.setBounds((i * 250 + 90), 5, 240, 80);
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
    
    public void addAndRunPage(JPanel page){
        displayerPanel.add(page,"page");
        cardLay.show(displayerPanel,"page");
        displayerPanel.repaint();
        setComponentZOrder(displayerPanel,0);
        repaint();
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
    
    public void Blockade(){
        this.basePanel.add(this.Block);
        this.basePanel.setComponentZOrder(this.Block,0);
        this.repaint();
    }
    
    public void LiftBlockade(){
        this.basePanel.remove(this.Block);
        this.repaint();
    }
    public void reset(){
        cardLay.show(displayerPanel,"Plain");
        TransmutePanel.reset();
        PotionBrewingPanel.reset();
        MarketPanel.reset();
        ForagePanel.reset();
        tablesPanel.reset();
        theoriesPanel.reset();
    }
    
    public JLabel getRoundLabel() {
        return roundLabel;
    }
    
    public ForageGroundsView getForagePanel() {
        return ForagePanel;
    }
    
    public MarketView getMarketPanel() {
        return MarketPanel;
    }
    
    public PotionBrewingView getPotionBrewingPanel() {
        return PotionBrewingPanel;
    }
    
    public void showDeduction() {
        cardLay.show(displayerPanel, "Tables");
    }

    public BooksDisplayer getTheoriesPanel() {
        return theoriesPanel;

    }
}