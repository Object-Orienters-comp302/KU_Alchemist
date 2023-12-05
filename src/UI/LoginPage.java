package UI;

import DataTypes.CircularLinkedList;
import Domain.GameController;
import Domain.LoginController;
import GUI_Components.ColorChangingPanel;
import GUI_Components.ImagePanel;
import Models.Token;
import Utils.AssetLoader;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class LoginPage extends JPanel {
    static int iter = 0;
    int playerAmount;
    String TriColor;
    private JTextField textField;
    LoginController loginControl;
    CircularLinkedList<BufferedImage> tokenList;
    CircularLinkedList<BufferedImage> backgroundList;
    GridBagLayout gridBagLayout;
    ImagePanel MainPanel;
    GridBagConstraints gbc_MainPanel;
    JPanel TokenSelectorPanel;
    JPanel TokenSelectorPanel_Left;
    JPanel TokenSelectorPanel_Left_Label_Holder;
    JLabel TokenSelectorPanel_Left_Label;
    ImagePanel TokenSelectorPanel_Displayer;
    JPanel TokenSelectorPanel_Right;
    JPanel TokenSelectorPanel_Right_Label_Holder;
    JLabel TokenSelectorPanel_Right_Label;
    JPanel UserNamePanel;
    JLabel lblNewLabel;
    ImagePanel UserNamePanel_CheckPanel;
    JPanel NextPanel;
    JLabel NextPanel_Label;


    protected LoginPage () {
        new Token("khorne", AssetLoader.getAssetPath(AssetLoader.Tokens.KHORNE),
        AssetLoader.getAssetPath(AssetLoader.Backgrounds.KHORNE));
        new Token("nurgle", AssetLoader.getAssetPath(AssetLoader.Tokens.NURGLE),
                AssetLoader.getAssetPath(AssetLoader.Backgrounds.NURGLE));
        new Token("slaanesh", AssetLoader.getAssetPath(AssetLoader.Tokens.SLAANESH),
                AssetLoader.getAssetPath(AssetLoader.Backgrounds.SLAANESH));
        new Token("tzeentch", AssetLoader.getAssetPath(AssetLoader.Tokens.TZEENTCH),
                AssetLoader.getAssetPath(AssetLoader.Backgrounds.TZEENTCH));


        playerAmount = 2;

        setPreferredSize(new Dimension(1200, 900));
        CreateObjects();
        SetupObjets();
        SetupListeners();
    }
    
    private void CreateObjects() {
    	loginControl = GameController.getInstance().getLoginController();
    	tokenList = loginControl.getTokenImages();
    	backgroundList = loginControl.getTokenBackgrounds();
        
    	gridBagLayout = new GridBagLayout();
    	MainPanel = new ImagePanel(backgroundList.get());
    	gbc_MainPanel = new GridBagConstraints();
    	TokenSelectorPanel = new JPanel();
    	TokenSelectorPanel_Left = new ColorChangingPanel("#cf9d15", "#FFD700");
    	TokenSelectorPanel_Left_Label_Holder = new JPanel();
    	TokenSelectorPanel_Left_Label = new JLabel("<");
    	TokenSelectorPanel_Displayer = new ImagePanel(tokenList.get());
    	TokenSelectorPanel_Right = new ColorChangingPanel("#cf9d15", "#FFD700");
    	TokenSelectorPanel_Right_Label_Holder = new JPanel();
    	TokenSelectorPanel_Right_Label = new JLabel(">");
    	UserNamePanel= new JPanel();
    	textField = new JTextField();
    	lblNewLabel = new JLabel("Username:  ");
    	UserNamePanel_CheckPanel = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Tokens.RED_X));
    	NextPanel = new ColorChangingPanel("#cf9d15", "#FFD700");
    	NextPanel_Label = new JLabel("NEXT");
    }
    
    private void SetupObjets() {
        gridBagLayout.columnWidths  = new int[]{ 1200, 0 };
        gridBagLayout.rowHeights    = new int[]{ 900, 0 };
        gridBagLayout.columnWeights = new double[]{ 0.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights    = new double[]{ 0.0, Double.MIN_VALUE };
        setLayout(gridBagLayout);
        
        gbc_MainPanel.fill  = GridBagConstraints.BOTH;
        gbc_MainPanel.gridx = 0;
        gbc_MainPanel.gridy = 0;
        add(MainPanel, gbc_MainPanel);
        
        MainPanel.setLayout(null);
        
        TokenSelectorPanel.setBounds(150, 150, 900, 450);
        MainPanel.add(TokenSelectorPanel);
        TokenSelectorPanel.setLayout(null);
        
        TokenSelectorPanel_Left.setBounds(0, 0, 75, 450);
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
        
        TokenSelectorPanel_Displayer.setBounds(75, 0, 750, 450);
        TokenSelectorPanel.add(TokenSelectorPanel_Displayer);
        TokenSelectorPanel_Displayer.setLayout(null);
        
        TokenSelectorPanel_Right.setBounds(825, 0, 75, 450);
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
        
        UserNamePanel.setBounds(450, 645, 300, 50);
        UserNamePanel.setBackground(Color.decode("#FFD700"));
        MainPanel.add(UserNamePanel);
        UserNamePanel.setLayout(null);
        
        textField.setBounds(75, 0, 175, 50);
        UserNamePanel.add(textField);
        textField.setBorder(null);
        textField.setColumns(10);
        
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setBounds(0, 0, 75, 50);
        UserNamePanel.add(lblNewLabel);
        
        UserNamePanel_CheckPanel.setBounds(255, 5, 40, 40);
        UserNamePanel_CheckPanel.setBackground(Color.decode("#FFD700"));
        UserNamePanel.add(UserNamePanel_CheckPanel);
        
        NextPanel.setBounds(450, 750, 300, 75);
        MainPanel.add(NextPanel);
        NextPanel.setLayout(null);
        
        NextPanel_Label.setBounds(105, 8, 90, 60);
        NextPanel_Label.setHorizontalAlignment(SwingConstants.CENTER);
        NextPanel_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        NextPanel.add(NextPanel_Label);
        
    }
    
    private void SetupListeners() {
    	TokenSelectorPanel_Left.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                TokenSelectorPanel_Displayer.changeImage(tokenList.getPrev());
                MainPanel.changeImage(backgroundList.getPrev());
            }
        });
        
        TokenSelectorPanel_Right.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                TokenSelectorPanel_Displayer.changeImage(tokenList.getNext());
                MainPanel.changeImage(backgroundList.getNext());
            }
        });
        
        
        NextPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                if (loginControl.isUniquePlayerID(textField.getText()) && (!textField.getText()
                        .isBlank())) {
                    loginControl.logPlayerIn(textField.getText(), tokenList.delete());
                    backgroundList.delete();
                    textField.setText("");
                    TokenSelectorPanel_Displayer.changeImage(tokenList.get());
                    MainPanel.changeImage(backgroundList.get());
                    LoginPage.iter += 1;
                    //System.out.print(LoginPage.iter);
                    if (NextPanel_Label.getText() == "START") {
                        System.exit(0);
                    }
                    if ((LoginPage.iter) == playerAmount - 1) {
                        NextPanel_Label.setText("START");
                    }
                }
                
            }
        });
        
                
            textField.getDocument().addDocumentListener(new DocumentListener() {
            
            
            @Override
            public void insertUpdate (DocumentEvent e) {
                if (!loginControl.isUniquePlayerID(textField.getText()) || (textField.getText()
                        .isBlank())) {
                    UserNamePanel_CheckPanel.changeImage(AssetLoader.getAssetPath(AssetLoader.Tokens.RED_X));
                    
                } else {
                    UserNamePanel_CheckPanel.changeImage(
                            AssetLoader.getAssetPath(AssetLoader.Tokens.GREEN_TICK));
                }
            }
            
            @Override
            public void removeUpdate (DocumentEvent e) {
                if (!loginControl.isUniquePlayerID(textField.getText()) || (textField.getText()
                        .isBlank())) {
                    UserNamePanel_CheckPanel.changeImage(AssetLoader.getAssetPath(AssetLoader.Tokens.RED_X));
                    
                } else {
                    UserNamePanel_CheckPanel.changeImage(
                            AssetLoader.getAssetPath(AssetLoader.Tokens.GREEN_TICK));
                }
            }
            
            @Override
            public void changedUpdate (DocumentEvent e) {
                // TODO Auto-generated method stub
            }
        });
    }

    
    public static void main (String[] args) { // TODO: Move to UnitTests
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 900);
        frame.getContentPane()
                .setLayout(new GridBagLayout());
        JPanel login = new LoginPage();
        frame.getContentPane()
                .add(login);
        frame.setVisible(true);
    }
}