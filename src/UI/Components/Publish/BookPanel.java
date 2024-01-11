package UI.Components.Publish;

import Domain.GameController;
import Domain.RoundTwoController;
import Models.*;
import UI.Components.ColorChangingPanel;
import UI.Components.ImagePanels.OutlinedLabel;
import Utils.AssetLoader;

import javax.swing.*;

import UI.Components.ImagePanels.ImageChangingPanel;
import UI.Components.ImagePanels.ImagePanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class BookPanel extends JPanel {
    public static ArrayList<AssetLoader.AssetPath>        traitUsed = new ArrayList<>();
    
    //public static ArrayList<AssetLoader.AssetPath>        traitRam  = new ArrayList<>();
    //purpose was for it to check if one is selected even when not published but decided to use traitUsed for this
    //keeping this because in future it might cause a bug in backend
    
    Ingredient.IngredientTypes ingreType;
    BookButton                 CircleButton;
    ImagePanel book;
    ImageChangingPanel confirmButton;
    EndorsePanel       endorsePanel;
    ColorChangingPanel endorserPanel;
    DebunkButton       debunkButton;
    
    
    
    public BookPanel(AssetLoader.AssetPath ingredientPath) {
        ingreType = Ingredient.getTypeFromPath(ingredientPath);
        
        setPreferredSize(new Dimension(500, 250));
        setLayout(null);
        setOpaque(false);
        book = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Book.BOOK));
        book.setBounds(0, 0, 300, 160);
        add(book);
        book.setLayout(null);
        
        classicSetup(ingredientPath);
        
        
        
    }
    
    public void classicSetup(AssetLoader.AssetPath ingredientPath){
        ImagePanel panel = new ImagePanel(AssetLoader.getAssetPath(ingredientPath));
        panel.setBounds(30, 5, 80, 80);
        book.add(panel);
        
        if (confirmButton==null) {
            confirmButton = new ImageChangingPanel(AssetLoader.getAssetPath(AssetLoader.Book.ENVELOPE),
                                                   AssetLoader.getAssetPath(AssetLoader.Book.PUBLISH));
            
            confirmButton.setBounds(160, 112, 120, 40);
        }
        confirmButton.changeCurrentImage(AssetLoader.Book.ENVELOPE);
        book.add(confirmButton,0);
        book.repaint();
        
        if (CircleButton==null) {
            CircleButton = new BookButton(35, 90, 65, 65, ingredientPath);
        }
        add(CircleButton,0);
        
        if (debunkButton!=null){
            book.remove(debunkButton);
        }
        
        if (PublicationTrack.getInstance().isPublished(ingreType)){
            isAlreadyPublishedSetup(Ingredient.getTypeFromPath(ingredientPath));
        }
        else {
            
            
            
            confirmButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    AssetLoader.AssetPath val = CircleButton.getCurrentPath();
                    if (val != AssetLoader.TriangleTable.QUESTION_MARK &&
                            GameController.getInstance().getRoundTwoController().canPublish(Player.getCurrPlayer(),
                                                                                            ingreType)) {
                        publish(val);
                    }
                }
            });
        }
        book.repaint();
    }
    public void startDebunkView(PublicationCard pub){
        book.remove(endorsePanel);
        book.remove(endorserPanel);
        debunkButton = new DebunkButton(140,5,150,pub,this);
        //debunkButton.setBounds(140,5,150,150);
        book.add(debunkButton);
        
        
    }
    
    public void publish(AssetLoader.AssetPath path){
        
        Player cur = GameController.getInstance().getMenuController().getCurrentPlayer();
        RoundTwoController cont2 = GameController.getInstance().getRoundTwoController();
        cont2.publishTheory(cur, ingreType, Ingredient.getTrioFromPath(path));
        isAlreadyPublishedSetup(ingreType);
        System.out.println("Published a new theory!"); //TODO: Fix this
    }
    
    public void isAlreadyPublishedSetup(Ingredient.IngredientTypes ingredientType){
        Player cur = GameController.getInstance().getMenuController().getCurrentPlayer();
        RoundTwoController cont2 = GameController.getInstance().getRoundTwoController();
        PublicationCard pubCard= PublicationTrack.getInstance().
                getPublicationCardOf(ingredientType);
        Ingredient.AspectTrio aspect= pubCard.getAspects();
        AssetLoader.AssetPath aspectPath = Ingredient.getPathFromTrio(aspect);
        
        CircleButton.setCurrentPath(aspectPath);
        CircleButton.disable();
        
        endorserPanel=new ColorChangingPanel("#7D7C7C", "#F1EFEF", 20, ColorChangingPanel.RoundingStyle.BOTH);
        endorserPanel.setOpaque(false);
        endorserPanel.setBounds(confirmButton.getBounds());
        book.remove(confirmButton);
        book.add(endorserPanel);
        
        endorserPanel.setLayout(null);
        OutlinedLabel endorserLabel = new OutlinedLabel("DEBUNK", "#D4AF37", "#FFD700");
        endorserLabel.setBounds(50,15,70,20);
        endorserLabel.setFont(new Font("Arial", Font.BOLD, 10));
        
        endorserPanel.add(endorserLabel);
        
        System.out.println("Theory: "+ PublicationTrack.getInstance().getPublicationCards());
        
        endorserPanel.setLayout(null);
        ImagePanel publisherImage = new ImagePanel(cur.getToken().getImage());
        publisherImage.addCorner(20);
        publisherImage.setBounds(0,0,40,40);
        endorserPanel.add(publisherImage);
        
        endorsePanel= new EndorsePanel(cont2.getCardForIngredient(ingreType));
        endorsePanel.setLocation(160, 10);
        book.add(endorsePanel);
        
        System.out.print(aspectPath);
        
        
        endorserPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            startDebunkView(pubCard);
            
            }});
            
        
        BookPanel.this.revalidate();
        BookPanel.this.repaint();
    
    }
    public void reset(){
        System.out.println("Book  ResetReached");
        
        if (!GameController.getInstance().getRoundThreeController().checkIfIngredientIsPublished(ingreType)){
            CircleButton.reset();
        }
        classicSetup(Ingredient.getPathFromType( ingreType));
    }
    public void spawnDebunkButton(){
    
    
    
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        Player cur = new Player("joe",new Token("jo",AssetLoader.getAssetPath(AssetLoader.Avatars.RED)
                ,AssetLoader.getAssetPath(AssetLoader.Avatars.RED)));
        cur.getInventory().addGold(10);
        GameController.getInstance().getRoundTwoController()
                .publishTheory(cur,Ingredient.IngredientTypes.Scorpion,Ingredient.AspectTrio.allPositive);
        
        
        Player sec = new Player("joe",new Token("biden",AssetLoader.getAssetPath(AssetLoader.Avatars.BLUE)
                ,AssetLoader.getAssetPath(AssetLoader.Avatars.BLUE)));
        GameController.getInstance().getRoundTwoController()
                .endorseTheory(sec,PublicationTrack.getInstance().getPublicationCardOf(
                Ingredient.IngredientTypes.Scorpion),2);
        
        
        frame.getContentPane().setLayout(new GridBagLayout());
        BookPanel login = new BookPanel(AssetLoader.IngredientAssets.SCORPION);
        frame.getContentPane().add(login);
        
        // Create a JButton
        JButton myButton = new JButton("Click Me");
        
        // Add an ActionListener to handle button clicks
        myButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GameController.getInstance().nextPlayer();
            }
        });
        
        // Add the button to the frame
        frame.getContentPane().add(myButton);
        
        
        frame.setVisible(true);
    }
    
}
