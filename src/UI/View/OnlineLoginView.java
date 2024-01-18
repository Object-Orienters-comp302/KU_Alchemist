package UI.View;

import Domain.Event.Listener;
import Domain.Event.Publisher;
import Domain.Event.Type;
import Domain.GameController;
import Domain.LoginController;
import Models.Token;
import Networking.GameAction;
import Networking.GameClient;
import Networking.GameServer;
import UI.Components.ColorChangingPanel;
import UI.Components.CutRoundedPanel;
import UI.Components.ImagePanels.GifPanel;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.RoundedPanel;
import Utils.AssetLoader;
import Utils.CircularLinkedList;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class OnlineLoginView extends JPanel implements Publisher {
    LoginController           loginControl;
    CircularLinkedList<Token> tokenList;
    ImagePanel                MainPanel;
    CutRoundedPanel           TokenSelectorPanel;
    JPanel                    TokenSelectorPanel_Left;
    JPanel                    TokenSelectorPanel_Left_Label_Holder;
    JLabel                    TokenSelectorPanel_Left_Label;
    ImagePanel                TokenSelectorPanel_Displayer;
    JPanel                    TokenSelectorPanel_Right;
    JPanel                    TokenSelectorPanel_Right_Label_Holder;
    JLabel                    TokenSelectorPanel_Right_Label;
    RoundedPanel              UserNamePanel;
    JLabel                    lblNewLabel;
    ImagePanel                UserNamePanel_CheckPanel;
    JPanel                    NextPanelContainer;
    ColorChangingPanel        NextPanel;
    JLabel                    NextPanel_Label;
    
    
    
    ArrayList<Listener> Listeners;
    private JTextField TextField;
    
    
    protected OnlineLoginView() {
        new Token("blue", AssetLoader.Tokens.BLUE,
                  AssetLoader.Backgrounds.BLUE);
        new Token("red", AssetLoader.Tokens.RED,
                  AssetLoader.Backgrounds.RED);
        new Token("green", AssetLoader.Tokens.GREEN,
                  AssetLoader.Backgrounds.GREEN);
        new Token("purple", AssetLoader.Tokens.PURPLE,
                  AssetLoader.Backgrounds.PURPLE);
        new Token("yellow", AssetLoader.Tokens.YELLOW, AssetLoader.Backgrounds.YELLOW);
        this.Listeners = new ArrayList<>();
        
        
        
        setPreferredSize(new Dimension(1280, 720));
        CreateObjects();
        SetupObjets();
        SetupListeners();
    }
    
    private void CreateObjects() {
        loginControl = GameController.getInstance().getLoginController();
        tokenList    = loginControl.getCirularTokens();
        MainPanel    = new ImagePanel(tokenList.get().getBluredBackground());
        MainPanel.setBounds(0, 0, 1280, 720);
        TokenSelectorPanel                    = new CutRoundedPanel(60, true);
        TokenSelectorPanel_Left               =
                new ColorChangingPanel("#cf9d15", "#FFD700", 60, ColorChangingPanel.RoundingStyle.LEFT);
        TokenSelectorPanel_Left_Label_Holder  = new JPanel();
        TokenSelectorPanel_Left_Label         = new JLabel("<");
        TokenSelectorPanel_Displayer          = new ImagePanel(tokenList.get().getImage());
        TokenSelectorPanel_Right              =
                new ColorChangingPanel("#cf9d15", "#FFD700", 60, ColorChangingPanel.RoundingStyle.RIGHT);
        TokenSelectorPanel_Right_Label_Holder = new JPanel();
        TokenSelectorPanel_Right_Label        = new JLabel(">");
        UserNamePanel = new RoundedPanel(50);
        TextField     = new JTextField();
        lblNewLabel   = new JLabel("Username:  ");
        UserNamePanel_CheckPanel              = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Tokens.RED_X));
        NextPanelContainer                    = new JPanel();
        NextPanel                             =
                new ColorChangingPanel("#cf9d15", "#FFD700", 40, ColorChangingPanel.RoundingStyle.BOTH);
        NextPanel_Label                       = new JLabel("JOIN");
        
        
    }
    
    private void SetupObjets() {
        setLayout(null);
        add(MainPanel);
        
        MainPanel.setLayout(null);
        
        TokenSelectorPanel.setBounds(243, 73, 754, 404);
        MainPanel.add(TokenSelectorPanel);
        TokenSelectorPanel.setLayout(null);
        
        TokenSelectorPanel_Left.setBounds(2, 2, 75, 400);
        TokenSelectorPanel.add(TokenSelectorPanel_Left);
        TokenSelectorPanel_Left.setLayout(null);
        
        TokenSelectorPanel_Left_Label_Holder.setLayout(null);
        TokenSelectorPanel_Left_Label_Holder.setBounds(23, 195, 30, 60);
        TokenSelectorPanel_Left.add(TokenSelectorPanel_Left_Label_Holder);
        TokenSelectorPanel_Left_Label_Holder.setOpaque(false);
        
        TokenSelectorPanel_Left_Label.setHorizontalAlignment(SwingConstants.CENTER);
        TokenSelectorPanel_Left_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        TokenSelectorPanel_Left_Label.setBounds(0, 0, 30, 60);
        TokenSelectorPanel_Left_Label_Holder.add(TokenSelectorPanel_Left_Label);
        
        TokenSelectorPanel_Displayer.setBounds(77, 2, 600, 400);
        TokenSelectorPanel.add(TokenSelectorPanel_Displayer);
        TokenSelectorPanel_Displayer.setLayout(null);
        
        TokenSelectorPanel_Right.setBounds(677, 2, 75, 400);
        TokenSelectorPanel.add(TokenSelectorPanel_Right);
        TokenSelectorPanel_Right.setLayout(null);
        
        TokenSelectorPanel_Right_Label_Holder.setBounds(22, 195, 30, 60);
        TokenSelectorPanel_Right.add(TokenSelectorPanel_Right_Label_Holder);
        TokenSelectorPanel_Right_Label_Holder.setLayout(null);
        TokenSelectorPanel_Right_Label_Holder.setOpaque(false);
        
        TokenSelectorPanel_Right_Label.setHorizontalAlignment(SwingConstants.CENTER);
        TokenSelectorPanel_Right_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        TokenSelectorPanel_Right_Label.setBounds(0, 0, 30, 60);
        TokenSelectorPanel_Right_Label_Holder.add(TokenSelectorPanel_Right_Label);
        
        UserNamePanel.setBounds(470, 525, 300, 50);
        UserNamePanel.setBackground(Color.decode("#FFD700"));
        MainPanel.add(UserNamePanel);
        UserNamePanel.setLayout(null);
        
        TextField.setBounds(75, 2, 175, 46);
        UserNamePanel.add(TextField);
        TextField.setBorder(null);
        TextField.setColumns(10);
        
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setBounds(0, 0, 75, 50);
        UserNamePanel.add(lblNewLabel);
        
        UserNamePanel_CheckPanel.setBounds(255, 10, 30, 30);
        UserNamePanel_CheckPanel.setBackground(Color.decode("#FFD700"));
        UserNamePanel.add(UserNamePanel_CheckPanel);
        
        NextPanelContainer.setBounds(469, 599, 302, 77);
        MainPanel.add(NextPanelContainer);
        NextPanelContainer.setLayout(null);
        NextPanelContainer.setOpaque(false);
        
        
        NextPanel.setLayout(null);
        NextPanel.setBounds(1, 1, 300, 75);
        NextPanelContainer.add(NextPanel);
        NextPanel.setFocusable(true);
        NextPanel.requestFocus();
        
        NextPanel_Label.setHorizontalAlignment(SwingConstants.CENTER);
        NextPanel_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        NextPanel_Label.setBounds(105, 8, 90, 60);
        NextPanel.add(NextPanel_Label);
        
    }
    
    private void SetupListeners() {
        TokenSelectorPanel_Left.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tokenList.getPrev();
                TokenSelectorPanel_Displayer.changeImage(tokenList.get().getImage());
                MainPanel.changeImage(tokenList.get().getBluredBackground());
            }
        });
        
        TokenSelectorPanel_Right.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tokenList.getNext();
                TokenSelectorPanel_Displayer.changeImage(tokenList.get().getImage());
                MainPanel.changeImage(tokenList.get().getBluredBackground());
            }
        });
        
        
        NextPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NextButtonPress();
            }
        });
        
        NextPanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    NextButtonPress();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        
        TextField.getDocument().addDocumentListener(new DocumentListener() {
            
            
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!loginControl.isUniquePlayerID(TextField.getText()) || (TextField.getText().isBlank())) {
                    UserNamePanel_CheckPanel.changeImage(AssetLoader.getAssetPath(AssetLoader.Tokens.RED_X));
                    
                } else {
                    UserNamePanel_CheckPanel.changeImage(AssetLoader.getAssetPath(AssetLoader.Tokens.GREEN_TICK));
                }
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!loginControl.isUniquePlayerID(TextField.getText()) || (TextField.getText().isBlank())) {
                    UserNamePanel_CheckPanel.changeImage(AssetLoader.getAssetPath(AssetLoader.Tokens.RED_X));
                    
                } else {
                    UserNamePanel_CheckPanel.changeImage(AssetLoader.getAssetPath(AssetLoader.Tokens.GREEN_TICK));
                }
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                // TODO Auto-generated method stub
            }
        });
        
        TextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    NextButtonPress();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
    
    
    
    private void NextButtonPress(){
        if (loginControl.isUniquePlayerID(TextField.getText()) && (!TextField.getText().isBlank())) {
            loginControl.logPlayerIn(TextField.getText(), tokenList.get()); //tokenList.get() should be used
            tokenList.delete();
            TextField.setText("");
            TokenSelectorPanel_Displayer.changeImage(tokenList.get().getImage());
            MainPanel.changeImage(tokenList.get().getBluredBackground());
            
            //System.out.print(LoginView.iter);
            if (Objects.equals(NextPanel_Label.getText(), "JOIN")) {
                ThrowLoadingGif();
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        
                            GameController.getInstance().getRoundZeroController().gameSetup();
                            publishEvent(Type.START_MENUVIEW);
                            return null;

                    }
                    
                    @Override
                    protected void done() {
                    
                    }
                };
                
                worker.execute();
            }
        }
    }
    
    @Override
    public void publishEvent(Type type) {
        for (Listener listener : Listeners) {
            listener.onEvent(type);
        }
    }
    
    public static void main(String[] args) { // TODO: Move to UnitTests
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1294, 757);
        frame.getContentPane().setLayout(new GridBagLayout());
        JPanel login = new OnlineLoginView();
        frame.getContentPane().add(login);
        frame.setVisible(true);
    }
    
    @Override
    public void addListener(Listener lis) {
        this.Listeners.add(lis);
    }
    
    private void ThrowLoadingGif(){
        JPanel blurPanel = new JPanel();
        
        blurPanel.setBackground(new Color(255,255,255,125));
  
        blurPanel.setBounds(0,0,1280,720);
        blurPanel.setLayout(null);
        
        
        blurPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                e.consume();
            }
        });
        
        GifPanel LoadingGif = new GifPanel(540,260,200,200,AssetLoader.getAssetPath(AssetLoader.Gifs.POTION));
        
        this.add(blurPanel);
        this.setComponentZOrder(blurPanel,0);
        this.setVisible(true);
        this.add(LoadingGif);
        this.grabFocus();

        this.setComponentZOrder(LoadingGif,0);
        
        this.repaint();
        
    }
}