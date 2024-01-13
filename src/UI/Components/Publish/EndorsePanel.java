package UI.Components.Publish;

import Domain.GameController;
import Models.Player;
import Models.PublicationCard;
import UI.Components.ColorChangingPanel;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.ImagePanels.OutlinedLabel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class EndorsePanel extends JPanel{
    
    PublicationCard card;
    ColorChangingPanel tier1,tier2,tier3;
    OutlinedLabel tier1Label,tier2Label,tier3Label;

    public EndorsePanel(PublicationCard card){
        setSize(120,100);
        setLayout(null);
        setOpaque(false);
        this.card=card;
        setupEndorsers();
        
    }
    
    public void setupEndorsers(){
        tier1 = new ColorChangingPanel("#32a852", "#20bd4b", 20, ColorChangingPanel.RoundingStyle.BOTH);
        tier1.setBounds(0,0,120,30);
        add(tier1);
        tier1.setLayout(null);
        tier1Label = new OutlinedLabel("ENDORSE","#D4AF37","#FFD700");
        tier1Label.setBounds(40,5,100,50);
        tier1.add(tier1Label);
        
        tier2 = new ColorChangingPanel("#32a852","#20bd4b", 20, ColorChangingPanel.RoundingStyle.BOTH);
        tier2.setBounds(0,35,120,30);
        add(tier2);
        tier2.setLayout(null);
        tier2Label = new OutlinedLabel("ENDORSE","#D4AF37","#FFD700");
        tier2Label.setBounds(40,5,100,50);
        tier2.add(tier2Label);
        
        tier3 = new ColorChangingPanel("#32a852","#20bd4b", 20, ColorChangingPanel.RoundingStyle.BOTH);
        tier3.setBounds(0,70,120,30);
        add(tier3);
        tier3.setLayout(null);
        tier3Label = new OutlinedLabel("ENDORSE","#D4AF37","#FFD700");
        tier3Label.setBounds(40,5,100,50);
        tier3.add(tier3Label);
        
        HashMap<Integer, Player> map= card.getEndorsers();
        for(int i=1; i<=3;i++){
            if (map.get(i)!=null){
                ImagePanel endorserImage= new ImagePanel(map.get(i).getToken().getImage());
                endorserImage.setBounds(0,0,30,30);
                endorserImage.addCorner(10);
                ColorChangingPanel pan =getTierPanel(i);
                pan.add(endorserImage);
                pan.changeColors("#bbbbbb","#bbbbbb");
                getTierLabel(i).setText("ENDORSES");
                pan.addMouseListener(new MouseAdapter() {
                                                     @Override
                                                     public void mouseClicked(MouseEvent e) {
                                                         e.consume();
                                                     }});
                
            }
            else{
                addEndorseClicked( getTierPanel(i),i);
            }
            
        }
        card.getEndorsers().get(1);
    
    }
    public ColorChangingPanel getTierPanel(int i){
        return  switch (i){
            case 1->tier1;
            case 2->tier2;
            case 3->tier3;
            default -> throw new IllegalStateException("Unexpected value: " + i);
        };
    }
    public OutlinedLabel getTierLabel(int i){
        return  switch (i){
            case 1->tier1Label;
            case 2->tier2Label;
            case 3->tier3Label;
            default -> throw new IllegalStateException("Unexpected value: " + i);
        };
    }
    
    public void addEndorseClicked(JPanel pan,int i){
    pan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GameController game = GameController.getInstance();
                if(game.getRound() >2) {
                    System.out.print(" reached stage 1 ");
                    
                    if (game.getRoundTwoController().canEndorse(game.getMenuController().getCurrentPlayer(), card)) {
                        System.out.print(" reached stage 2 ");
                        game.getRoundTwoController().endorseTheory(game.getMenuController().getCurrentPlayer(), card, i);
                        setupEndorsers();
                        pan.getParent().remove(pan); // this is how it works I don't know why
                    }
                }
            }
        });
    }
    
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.getContentPane().setLayout(new GridBagLayout());
        BookPanel login = new BookPanel(AssetLoader.IngredientAssets.SCORPION);
        frame.getContentPane().add(login);
        frame.setVisible(true);
        
    }
}
