package UI.Components.Publish;

import Domain.GameController;
import Domain.RoundTwoController;
import Models.*;
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
    public static HashMap<AssetLoader.AssetPath, Boolean> published = new HashMap<AssetLoader.AssetPath, Boolean>();
    public static ArrayList<AssetLoader.AssetPath>        traitUsed = new ArrayList<>();
    
    //public static ArrayList<AssetLoader.AssetPath>        traitRam  = new ArrayList<>();
    //purpose was for it to check if one is selected even when not published but decided to use traitUsed for this
    //keeping this because in future it might cause a bug in backend
    
    Ingredient.IngredientTypes ingreType;
    BookButton                 CircleButton;
    ImagePanel book;
    ImageChangingPanel confirmButton;
    EndorsePanel endorsePanel;
    JPanel endorserPanel;
    DebunkButton debunkButton;
    
    static {
        published.put(AssetLoader.IngredientAssets.FEATHER, false);
        published.put(AssetLoader.IngredientAssets.FEET, false);
        published.put(AssetLoader.IngredientAssets.FLOWER, false);
        published.put(AssetLoader.IngredientAssets.FROG, false);
        published.put(AssetLoader.IngredientAssets.MANDRAKE, false);
        published.put(AssetLoader.IngredientAssets.MUSHROOM, false);
        published.put(AssetLoader.IngredientAssets.SCORPION, false);
        published.put(AssetLoader.IngredientAssets.WEED, false);
    }
    
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
        
        confirmButton = new ImageChangingPanel(AssetLoader.getAssetPath(AssetLoader.Book.ENVELOPE),
                                               AssetLoader.getAssetPath(AssetLoader.Book.PUBLISH));
        
        confirmButton.setBounds(160, 112, 120, 40);
        book.add(confirmButton);
        
        CircleButton = new BookButton(35, 90, 65, 65, ingredientPath);
        //panel_1.setBounds(70, 110, 80, 80);
        add(CircleButton);
        setComponentZOrder(CircleButton, 0);
        
        
        
        if (PublicationTrack.getInstance().isPublished(ingreType)){
            isAlreadyPublished(Ingredient.getTypeFromPath( ingredientPath));
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
    }
    public void startDebunkView(PublicationCard pub){
        book.remove(endorsePanel);
        book.remove(endorserPanel);
        debunkButton = new DebunkButton(140,5,150,pub);
        //debunkButton.setBounds(140,5,150,150);
        book.add(debunkButton);
        
        
    }
    
    public void publish(AssetLoader.AssetPath path){
        
        Player cur = GameController.getInstance().getMenuController().getCurrentPlayer();
        RoundTwoController cont2 = GameController.getInstance().getRoundTwoController();
        cont2.publishTheory(cur, ingreType, Ingredient.getTrioFromPath(path));
        isAlreadyPublished(ingreType);
        System.out.println("Published a new theory!"); //TODO: Fix this
    }
    
    public void isAlreadyPublished(Ingredient.IngredientTypes ingredientType){
        Player cur = GameController.getInstance().getMenuController().getCurrentPlayer();
        RoundTwoController cont2 = GameController.getInstance().getRoundTwoController();
        PublicationCard pubCard= PublicationTrack.getInstance().
                getPublicationCardOf(ingredientType);
        Ingredient.AspectTrio aspect= pubCard.getAspects();
        AssetLoader.AssetPath aspectPath = Ingredient.getPathFromTrio(aspect);
        
        CircleButton.setCurrentPath(aspectPath);
        CircleButton.disable();
        
        endorserPanel=new JPanel();
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
        traitUsed.add(aspectPath);
        published.put(Ingredient.getPathFromType(ingreType), true);
        
        endorserPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            
            
            }});
            
        
        BookPanel.this.revalidate();
        BookPanel.this.repaint();
    
    }
    public void reset(){
        if (!published.get(Ingredient.getPathFromType(ingreType))){
            System.out.println("INGRE: "+published);
            CircleButton.reset();
        }
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
