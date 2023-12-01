package UI;

import DataTypes.CircularLinkedList;
import Domain.GameController;
import Domain.LoginController;
import GUI_Components.ColorChangingPanel;
import GUI_Components.ImagePanel;
import Models.Token;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class LoginPage extends JPanel {
    static int iter = 0;
    String TriColor;
    private JTextField textField;

    protected LoginPage() {
        //// non GUI
        int wanted = 2;
        LoginController loginControl = GameController.getInstance().getLoginController();

        // works with Image
        CircularLinkedList<BufferedImage> tokenList = loginControl.getTokenImages();

        CircularLinkedList<BufferedImage> backgroundList = loginControl.getTokenBackgrounds();

        setPreferredSize(new Dimension(1200, 900));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{1200, 0};
        gridBagLayout.rowHeights = new int[]{900, 0};
        gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        ImagePanel MainPanel = new ImagePanel(backgroundList.get());
        GridBagConstraints gbc_MainPanel = new GridBagConstraints();
        gbc_MainPanel.fill = GridBagConstraints.BOTH;
        gbc_MainPanel.gridx = 0;
        gbc_MainPanel.gridy = 0;
        add(MainPanel, gbc_MainPanel);
        MainPanel.setLayout(null);

        JPanel TokenSelectorPanel = new JPanel();
        TokenSelectorPanel.setBounds(150, 150, 900, 450);
        MainPanel.add(TokenSelectorPanel);
        TokenSelectorPanel.setLayout(null);

        JPanel TokenSelectorPanel_Left = new ColorChangingPanel("#cf9d15", "#FFD700");

        TokenSelectorPanel_Left.setBounds(0, 0, 75, 450);
        TokenSelectorPanel.add(TokenSelectorPanel_Left);
        TokenSelectorPanel_Left.setLayout(null);

        JPanel TokenSelectorPanel_Left_Label_Holder = new JPanel();
        TokenSelectorPanel_Left_Label_Holder.setLayout(null);
        TokenSelectorPanel_Left_Label_Holder.setBounds(23, 195, 30, 60);
        TokenSelectorPanel_Left.add(TokenSelectorPanel_Left_Label_Holder);
        TokenSelectorPanel_Left_Label_Holder.setOpaque(false);

        JLabel TokenSelectorPanel_Left_Label = new JLabel("<");
        TokenSelectorPanel_Left_Label.setHorizontalAlignment(SwingConstants.CENTER);
        TokenSelectorPanel_Left_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        TokenSelectorPanel_Left_Label.setBounds(0, 0, 30, 60);
        TokenSelectorPanel_Left_Label_Holder.add(TokenSelectorPanel_Left_Label);

        ImagePanel TokenSelectorPanel_Displayer = new ImagePanel(tokenList.get());
        TokenSelectorPanel_Displayer.setBounds(75, 0, 750, 450);
        TokenSelectorPanel.add(TokenSelectorPanel_Displayer);
        TokenSelectorPanel_Displayer.setLayout(null);

        JPanel TokenSelectorPanel_Right = new ColorChangingPanel("#cf9d15", "#FFD700");
        TokenSelectorPanel_Right.setBounds(825, 0, 75, 450);
        TokenSelectorPanel.add(TokenSelectorPanel_Right);
        TokenSelectorPanel_Right.setLayout(null);

        JPanel TokenSelectorPanel_Right_Label_Holder = new JPanel();
        TokenSelectorPanel_Right_Label_Holder.setBounds(22, 195, 30, 60);
        TokenSelectorPanel_Right.add(TokenSelectorPanel_Right_Label_Holder);
        TokenSelectorPanel_Right_Label_Holder.setLayout(null);
        TokenSelectorPanel_Right_Label_Holder.setOpaque(false);

        JLabel TokenSelectorPanel_Right_Label = new JLabel(">");
        TokenSelectorPanel_Right_Label.setHorizontalAlignment(SwingConstants.CENTER);
        TokenSelectorPanel_Right_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        TokenSelectorPanel_Right_Label.setBounds(0, 0, 30, 60);
        TokenSelectorPanel_Right_Label_Holder.add(TokenSelectorPanel_Right_Label);

        JPanel UserNamePanel = new JPanel();
        UserNamePanel.setBounds(450, 645, 300, 50);
        UserNamePanel.setBackground(Color.decode("#FFD700"));
        MainPanel.add(UserNamePanel);
        UserNamePanel.setLayout(null);

        textField = new JTextField();

        textField.setBounds(75, 0, 175, 50);
        UserNamePanel.add(textField);
        textField.setBorder(null);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Username:  ");
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setBounds(0, 0, 75, 50);
        UserNamePanel.add(lblNewLabel);

        ImagePanel UserNamePanel_CheckPanel = new ImagePanel("./Images/tokens/redX.png");
        UserNamePanel_CheckPanel.setBounds(255, 5, 40, 40);
        UserNamePanel_CheckPanel.setBackground(Color.decode("#FFD700"));
        UserNamePanel.add(UserNamePanel_CheckPanel);

        JPanel NextPanel = new ColorChangingPanel("#cf9d15", "#FFD700");

        NextPanel.setBounds(450, 750, 300, 75);
        MainPanel.add(NextPanel);
        NextPanel.setLayout(null);

        JLabel NextPanel_Label = new JLabel("NEXT");
        NextPanel_Label.setBounds(105, 8, 90, 60);
        NextPanel_Label.setHorizontalAlignment(SwingConstants.CENTER);
        NextPanel_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        NextPanel.add(NextPanel_Label);

        //events

        TokenSelectorPanel_Left.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TokenSelectorPanel_Displayer.changeImage(tokenList.getPrev());
                MainPanel.changeImage(backgroundList.getPrev());
            }
        });

        TokenSelectorPanel_Right.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TokenSelectorPanel_Displayer.changeImage(tokenList.getNext());
                MainPanel.changeImage(backgroundList.getNext());
            }
        });


        NextPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (loginControl.isUniquePlayerID(textField.getText()) && (!textField.getText().isBlank())) {
                    loginControl.logPlayerIn(textField.getText(), tokenList.delete());
                    backgroundList.delete();
                    textField.setText("");
                    TokenSelectorPanel_Displayer.changeImage(tokenList.get());
                    MainPanel.changeImage(backgroundList.get());
                    LoginPage.iter += 1;
                    System.out.print(LoginPage.iter);
                    if (NextPanel_Label.getText() == "START") {
                        System.exit(0);
                    }
                    if ((LoginPage.iter) == wanted - 1) {
                        NextPanel_Label.setText("START");
                    }
                }

            }
        });


        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!loginControl.isUniquePlayerID(textField.getText()) || (textField.getText().isBlank())) {
                    UserNamePanel_CheckPanel.changeImage("./Images/tokens/redX.png");

                } else {
                    UserNamePanel_CheckPanel.changeImage("./Images/tokens/greenTick.png");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!loginControl.isUniquePlayerID(textField.getText()) || (textField.getText().isBlank())) {
                    UserNamePanel_CheckPanel.changeImage("./Images/tokens/redX.png");

                } else {
                    UserNamePanel_CheckPanel.changeImage("./Images/tokens/greenTick.png");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // TODO Auto-generated method stub
            }
        });
    }

    public static void main(String[] args) {
        new Token("khorne","./Images/tokens/khorne.png","./Images/backgrounds/khorne_background.png");
        new Token("nurgle","./Images/tokens/nurgle.png","./Images/backgrounds/nurgle_background.png");
        new Token("slaanesh","./Images/tokens/slaanesh.png","./Images/backgrounds/slaanesh_background.png");
        new Token("tzeentch","./Images/tokens/tzeentch.png","./Images/backgrounds/tzeentch_background.png");

        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 900);
        frame.getContentPane().setLayout(new GridBagLayout());
        JPanel login = new LoginPage();
        frame.getContentPane().add(login);
        frame.setVisible(true);
    }
}