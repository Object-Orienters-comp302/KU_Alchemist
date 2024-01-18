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
    OutlinedLabel endorserLabel;
    ImagePanel publisherImage;
    
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
        }
        confirmButton.setBounds(160, 112, 120, 40);
        confirmButton.setActiveImage(AssetLoader.Book.ENVELOPE);
        book.add(confirmButton);
        
        if (CircleButton==null){
        CircleButton = new BookButton(35, 90, 65, 65, ingredientPath);
        }
        //panel_1.setBounds(70, 110, 80, 80);
        add(CircleButton);
        setComponentZOrder(CircleButton, 0);
        
        
        
        if (PublicationTrack.getInstance().isPublished(ingreType)){
            alreadyPublishedSetup(Ingredient.getTypeFromPath(ingredientPath));
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
    public void startDebunkView(){
        book.remove(endorsePanel);
        book.remove(endorserPanel);
        if (debunkButton==null) {
            debunkButton = new DebunkButton(140, 5, 150, this);
        }
        else {
            debunkButton.changeImage(CircleButton.getCurrentPath());
        }
        //debunkButton.setBounds(140,5,150,150);
        book.add(debunkButton);
    }
    public void endDebunkView(){
        book.remove(debunkButton);
        book.repaint();
    }
    
    public void publish(AssetLoader.AssetPath path){
        
        Player cur = GameController.getInstance().getMenuController().getCurrentPlayer();
        RoundTwoController cont2 = GameController.getInstance().getRoundTwoController();
        cont2.publishTheory(cur, ingreType, Ingredient.getTrioFromPath(path));
        alreadyPublishedSetup(ingreType);
        System.out.println("Published a new theory!"); //TODO: Fix this
    }
    
    public void alreadyPublishedSetup(Ingredient.IngredientTypes ingredientType){
        Player cur = GameController.getInstance().getMenuController().getCurrentPlayer();
        RoundTwoController cont2 = GameController.getInstance().getRoundTwoController();
        PublicationCard pubCard= PublicationTrack.getInstance().
                getPublicationCardOf(ingredientType);
        Ingredient.AspectTrio aspect= pubCard.getAspects();
        AssetLoader.AssetPath aspectPath = Ingredient.getPathFromTrio(aspect);
        
        CircleButton.setCurrentPath(aspectPath);
        CircleButton.disable();
        if (endorserPanel==null) {
            endorserPanel = new ColorChangingPanel("#C97222","#DE710D",  20, ColorChangingPanel.RoundingStyle.BOTH);
        }
        endorserPanel.setOpaque(false);
        endorserPanel.setBounds(confirmButton.getBounds());
        book.remove(confirmButton);
        book.add(endorserPanel);
        
        endorserPanel.setLayout(null);
        if (endorserLabel==null) {
            endorserLabel = new OutlinedLabel("DEBUNK", "#D4AF37", "#FFD700");
        }
        endorserLabel.setBounds(50,15,70,20);
        endorserLabel.setFont(new Font("Arial", Font.BOLD, 10));
        
        endorserPanel.add(endorserLabel);
        
        System.out.println("Theories: "+ PublicationTrack.getInstance().getPublicationCards());
        
        endorserPanel.setLayout(null);
        if (publisherImage==null) {
            publisherImage = new ImagePanel(pubCard.getOwner().getToken().getImage());
        }
        publisherImage.addCorner(20);
        publisherImage.setBounds(0,0,40,40);
        endorserPanel.add(publisherImage);
        
        if (endorsePanel==null) {
            endorsePanel = new EndorsePanel(cont2.getCardForIngredient(ingreType));
        }
        endorsePanel.setLocation(160, 10);
        book.add(endorsePanel);
        
        //System.out.print(aspectPath);
        //traitUsed.add(aspectPath);
        
        endorserPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                if(GameController.getInstance().getRound() > 2) {
                    startDebunkView();
                }
                
            }});
            
        book.repaint();
        BookPanel.this.revalidate();
        BookPanel.this.repaint();
    
    }
    public void reset(){
        if (!GameController.getInstance().getRoundThreeController().checkIfIngredientIsPublished(ingreType)){
            CircleButton.reset();
        }
    }
    public void spawnDebunkButton(){
    
    
    
    }
    
    public void debunkAction(int i){
        endDebunkView();
        PublicationCard pubCard= PublicationTrack.getInstance().
                getPublicationCardOf(ingreType);
        Aspect.Colors col = null;
        switch (i){
            case 1->col= Aspect.Colors.Red;
            case 2->col= Aspect.Colors.Green;
            case 3->col= Aspect.Colors.Blue;
        }
        if (GameController.getInstance().getRoundThreeController().debunkTheory
                (GameController.getInstance().getMenuController().getCurrentPlayer(),pubCard,col)) {
            theoryGotDebunked();
        }
        classicSetup(Ingredient.getPathFromType( ingreType));
        //TODO:add debunk action here
    }
    public void theoryGotDebunked(){
        System.out.println("Theory get debunked runned");
        book.remove(endorserPanel);
        book.remove(endorsePanel);
        endorserPanel=null;
        endorsePanel=null;
        publisherImage=null;
        CircleButton.reset();
        book.repaint();
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        Player cur = new Player("joe",new Token("jo",AssetLoader.Avatars.RED
                ,AssetLoader.Avatars.RED));
        cur.getInventory().addGold(10);
        GameController.getInstance().getRoundTwoController()
                .publishTheory(cur,Ingredient.IngredientTypes.Scorpion,Ingredient.AspectTrio.allPositive);
        
        
        Player sec = new Player("joe",new Token("biden",AssetLoader.Avatars.BLUE
                ,AssetLoader.Avatars.BLUE));
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
