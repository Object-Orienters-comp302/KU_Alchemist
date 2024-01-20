package UI.View;

import Domain.GameController;
import Domain.RoundOneController;
import Models.*;
import Networking.GameAction;
import Networking.GameClient;
import Sound.DJ;
import UI.Components.ColorChangingPanel;
import UI.Components.ImagePanels.BackgroundSelector;
import UI.Components.ImagePanels.GifPanel;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.ImagePanels.OutlinedLabel;
import UI.Components.Potion.IngredientButton;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PotionBrewingView extends JPanel {
    
    /**
     * Create the panel.
     */
    ImagePanel         Background;
    ColorChangingPanel MakePotionButton;
    ColorChangingPanel TestOnStudentBox;
    Boolean            testOnStudent = false;
    IngredientButton IngredientB1;
    IngredientButton IngredientB2;
    
    OutlinedLabel MakePotionLbl;
    ImagePanel    TickPanel;
    OutlinedLabel lblNewLabel;
    ImagePanel    Card1;
    ImagePanel Card2;
    ImagePanel Cauldron;
    
    boolean potionIsBeingDisplayed=false;
    GifPanel FlameGif;
    GifPanel GlowGif;
    GifPanel PotionBackground;
    ImagePanel PotionImage;
   
    public PotionBrewingView() {
        this.setSize(1000, 500);
        setLayout(null);
        CreateObjects();
        SetupObjects();
        SetupListeners();
        this.setVisible(true);
    }
    
    private void CreateObjects() {
    	Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.PotionBrewingViewAssets.BACKGROUND1));
    	IngredientB1 = new IngredientButton(150, 155, 140, 140, true);
    	IngredientB2 = new IngredientButton(710, 155, 140, 140, true);
        
    	MakePotionButton = new ColorChangingPanel("#cf9d15", "#FFD700", 30, ColorChangingPanel.RoundingStyle.BOTH);
    	MakePotionLbl = new OutlinedLabel("Make Potion","#0d0100", "#CCCCCC", OutlinedLabel.Versions.MID_ORIENTED);
    	TestOnStudentBox = new ColorChangingPanel("#cf9d15", "#FFD700", 30, ColorChangingPanel.RoundingStyle.BOTH);
    	TickPanel = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Tokens.RED_X));
    	lblNewLabel = new OutlinedLabel("TEST ON STUDENT", "#0d0100", "#CCCCCC", OutlinedLabel.Versions.MID_ORIENTED);
    	Card1 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.CARD));
    	Card2 = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.ForageGroundsAssets.CARD));
  
        Cauldron = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.PotionBrewingViewAssets.CAULDRON));
        FlameGif=new GifPanel(315, 0, 360, 225,"resources/Gifs/Animations/flame.gif");
        GlowGif=new GifPanel(100, 0, 800, 500,"resources/Gifs/Animations/radiatingWhiteGlow.gif");
        PotionBackground = new GifPanel(375, 100, 250, 260,"resources/Gifs/Animations/orbFire.gif");
        PotionImage= new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Potions.UNKNOWN));
        
    }
    
    private void SetupObjects() {
    	Background.setLocation(0, 0);
        Background.setSize(1000, 500);
        this.add(Background);
        Background.setLayout(null);
        
        IngredientB1.setPair(IngredientB2);
        IngredientB2.setPair(IngredientB1);
        
        Background.add(IngredientB2);
        Background.add(IngredientB1);
   
        MakePotionButton.setBounds(830, 400, 120, 40);
        Background.add(MakePotionButton);
        MakePotionButton.setLayout(null);
        
        MakePotionLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        MakePotionLbl.setHorizontalAlignment(SwingConstants.CENTER);
        MakePotionLbl.setBounds(0, 0, 120, 40);
        MakePotionButton.add(MakePotionLbl);
        
        TestOnStudentBox.setBounds(425, 375, 160, 40);
        Background.add(TestOnStudentBox);
        TestOnStudentBox.setLayout(null);
    	
        TickPanel.setBounds(5, 5, 30, 30);
        TestOnStudentBox.add(TickPanel);
        
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel.setBounds(40, 5, 110, 30);
        TestOnStudentBox.add(lblNewLabel);
        
        Card1.setBounds(140, 100, 160, 250);
        Background.add(Card1);
        Card1.setLayout(null);
        
        Card2.setBounds(700, 100, 160, 250);
        Background.add(Card2);
        Card2.setLayout(null);
        
        Cauldron.setLayout(null);
        Cauldron.setBounds(375, 100, 250, 250);
        Background.add(Cauldron);
        
        BackgroundSelector backgroundSelector = new BackgroundSelector(
                false,375,25,Background, AssetLoader.PotionBrewingViewAssets.BACKGROUND1,
                AssetLoader.PotionBrewingViewAssets.BACKGROUND2,AssetLoader.PotionBrewingViewAssets.BACKGROUND3,
                AssetLoader.PotionBrewingViewAssets.BACKGROUND4,AssetLoader.PotionBrewingViewAssets.BACKGROUND5);
        Background.add(backgroundSelector);
        
        
        
        PotionImage.setBounds(425, 125, 150, 200);
        
    }
    private void SetupListeners() {
    	MakePotionButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (!potionIsBeingDisplayed) {
                    if(GameController.getInstance().isOnline()){
                        GameClient.getInstance().sendAction(new GameAction(GameAction.ActionType.MAKE_EXPERIMENT,"Make Experiment",Player.getCurrPlayer()
                                .getID(),IngredientB1.getType()
                                                           ,IngredientB2.getType(),testOnStudent));
                        
                    }
                    else {
                        if (Player.getCurrPlayer().getInventory().isInInventory(IngredientB1.getType()) && Player.getCurrPlayer().getInventory()
                                .isInInventory(IngredientB2.getType())) {
                            //TODO Make this better currently this maybe problematic
                            
                            PotionAnimation();
                            
                        }
                    }

                }
                else{
                    reset();
                }
            }
        });
    	
       
        
        TestOnStudentBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (PotionBrewingView.this.testOnStudent) {
                    TickPanel.changeImage(AssetLoader.getAssetPath(AssetLoader.Tokens.RED_X));
                    PotionBrewingView.this.testOnStudent = false;
                    
                } else {
                    
                    TickPanel.changeImage(AssetLoader.getAssetPath(AssetLoader.Tokens.GREEN_TICK));
                    PotionBrewingView.this.testOnStudent = true;
                }
                //PotionBrewingView.this.testOnStudent = !PotionBrewingView.this.testOnStudent;//Sets it to it's negative
                
            }
        });
    }

   
        
    
    
    // TODO: Bu niye burda amk
    public Potion MakePotion(Ingredient.IngredientTypes ingredient1, Ingredient.IngredientTypes ingredient2, Player player) {
        RoundOneController roundOneController = GameController.getInstance().getRoundOneController();
        Potion potion = roundOneController.MakePotion(Ingredient.getAspects(ingredient1), Ingredient.getAspects(ingredient2));
        System.out.print(potion.getIdentity());
        MakeExperiments(potion, player, !this.testOnStudent);
        player.getInventory().addPotions(potion, 1);
        
        roundOneController.removeIngredient(player, ingredient1);
        roundOneController.removeIngredient(player, ingredient2);
        roundOneController.MagicMortar(player, Artifact.Name.Magic_Mortar, ingredient2);
        return potion;
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1020, 520);
        frame.getContentPane().add(new PotionBrewingView());
        frame.setVisible(true);
    }
    
    public void MakeExperiments(Potion potion, Player player, boolean testOnStudent) {
        RoundOneController roundOneController = GameController.getInstance().getRoundOneController();
        roundOneController.Make_experiments(player, potion, testOnStudent);
    }
    
    public void OnlinePotionAnimation(Potion pot){
        
        GameController.getInstance().getMenuController().getMenuView().Blockade();
        
        int duration3 = 1000;//Background.add(GlowGif);
        Timer timer3 = new Timer(10, new ActionListener() {
            private long startTime = -1;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startTime == -1) {
                    startTime = System.currentTimeMillis();
                    Background.add(GlowGif);
                    Background.setComponentZOrder(GlowGif,0);
                    Background.repaint();
                }
                
                long elapsedTime = System.currentTimeMillis() - startTime;
                
                if (elapsedTime < duration3) {
                    // Perform animation logic here
                } else {
                    // Stop the timer when the duration is reached
                    ((Timer) e.getSource()).stop();
                    System.out.println("Animation completed!");
                    
                }
            }
        });
        
        
        int duration2 = 900;//Background.add(GlowGif);
        Timer timer2 = new Timer(10, new ActionListener() {
            private long startTime = -1;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startTime == -1) {
                    startTime = System.currentTimeMillis();
                }
                
                long elapsedTime = System.currentTimeMillis() - startTime;
                
                if (elapsedTime < duration2) {
                    // Perform animation logic here
                    IngredientB1.ChangeLocationBy(1,1);
                    IngredientB2.ChangeLocationBy(-1,1);
                    repaint();
                } else {
                    // Stop the timer when the duration is reached
                    ((Timer) e.getSource()).stop();
                    System.out.println("Animation completed!");
                    Background.remove(IngredientB1);
                    Background.remove(IngredientB2);
                    Background.add(FlameGif);
                    Background.setComponentZOrder(FlameGif,0);
                    Background.repaint();
                    DJ.getDJ().setAndStartEffectSound(DJ.EffectSounds.FIRE,1500);
                    
                    Timer delayedTimer1 = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Background.remove(FlameGif);
                            Background.repaint();
                            //timer3.start();
                            ((Timer) e.getSource()).stop();
                        }
                    });
                    
                    delayedTimer1.setRepeats(false);
                    delayedTimer1.start();
                    
                    Timer delayedTimer2 = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            DJ.getDJ().setAndStartEffectSound(DJ.EffectSounds.EXPLOSION,1500);
                            Background.add(GlowGif);
                            Background.setComponentZOrder(GlowGif,0);
                            Background.repaint();
                            ((Timer) e.getSource()).stop();
                            
                            Timer delayedTimer3 = new Timer(2000, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    
                                    
                                    Background.remove(GlowGif);
                                    Background.add(PotionBackground);
                                    Background.setComponentZOrder(PotionBackground,0);
                                    PotionImage.changeImage(Potion.getPathFromIdentity(pot.getIdentity()));
                                    Background.add(PotionImage);
                                    
                                    Background.setComponentZOrder(PotionImage,0);
                                    Background.repaint();
                                    potionIsBeingDisplayed=true;
                                    GameController.getInstance().getMenuController().getMenuView().LiftBlockade();
                                    ((Timer) e.getSource()).stop();
                                }
                            });
                            
                            delayedTimer3.setRepeats(false);
                            delayedTimer3.start();
                            
                        }
                    });
                    
                    delayedTimer2.setRepeats(false);
                    delayedTimer2.start();
                    
                    
                }
            }
        });
        int duration1 = 1500;
        Timer timer1 = new Timer(10, new ActionListener() {
            private long startTime = -1;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startTime == -1) {
                    startTime = System.currentTimeMillis();
                }
                
                long elapsedTime = System.currentTimeMillis() - startTime;
                
                if (elapsedTime < duration1) {
                    // Perform animation logic here
                    IngredientB1.ChangeLocationBy(2,-1);
                    IngredientB2.ChangeLocationBy(-2,-1);
                    repaint();
                } else {
                    // Stop the timer when the duration is reached
                    ((Timer) e.getSource()).stop();
                    System.out.println("Animation completed!");
                    timer2.start();
                    
                }
            }
        });
        
        timer1.start();
        
        
    }
    private void PotionAnimation(){
        
        GameController.getInstance().getMenuController().getMenuView().Blockade();
        
        int duration3 = 1000;//Background.add(GlowGif);
        Timer timer3 = new Timer(10, new ActionListener() {
            private long startTime = -1;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startTime == -1) {
                    startTime = System.currentTimeMillis();
                    Background.add(GlowGif);
                    Background.setComponentZOrder(GlowGif,0);
                    Background.repaint();
                }
                
                long elapsedTime = System.currentTimeMillis() - startTime;
                
                if (elapsedTime < duration3) {
                    // Perform animation logic here
                } else {
                    // Stop the timer when the duration is reached
                    ((Timer) e.getSource()).stop();
                    System.out.println("Animation completed!");

                }
            }
        });
        
        
        int duration2 = 900;//Background.add(GlowGif);
        Timer timer2 = new Timer(10, new ActionListener() {
            private long startTime = -1;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startTime == -1) {
                    startTime = System.currentTimeMillis();
                }
                
                long elapsedTime = System.currentTimeMillis() - startTime;
                
                if (elapsedTime < duration2) {
                    // Perform animation logic here
                    IngredientB1.ChangeLocationBy(1,1);
                    IngredientB2.ChangeLocationBy(-1,1);
                    repaint();
                } else {
                    // Stop the timer when the duration is reached
                    ((Timer) e.getSource()).stop();
                    System.out.println("Animation completed!");
                    Background.remove(IngredientB1);
                    Background.remove(IngredientB2);
                    Background.add(FlameGif);
                    Background.setComponentZOrder(FlameGif,0);
                    Background.repaint();
                    DJ.getDJ().setAndStartEffectSound(DJ.EffectSounds.FIRE,1500);
                    Timer delayedTimer1 = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Background.remove(FlameGif);
                            Background.repaint();
                            //timer3.start();
                            ((Timer) e.getSource()).stop();
                        }
                    });
                    
                    delayedTimer1.setRepeats(false);
                    delayedTimer1.start();
                    
                    Timer delayedTimer2 = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            DJ.getDJ().setAndStartEffectSound(DJ.EffectSounds.EXPLOSION,1500);
                            Background.add(GlowGif);
                            Background.setComponentZOrder(GlowGif,0);
                            Background.repaint();
                            ((Timer) e.getSource()).stop();
                            
                            Timer delayedTimer3 = new Timer(2000, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    
                                    Potion pot = MakePotion(IngredientB1.getType(), IngredientB2.getType(), Player.getCurrPlayer());
                                    
                                    Background.remove(GlowGif);
                                    Background.add(PotionBackground);
                                    Background.setComponentZOrder(PotionBackground,0);
                                    PotionImage.changeImage(Potion.getPathFromIdentity(pot.getIdentity()));
                                    Background.add(PotionImage);
                                    
                                    Background.setComponentZOrder(PotionImage,0);
                                    Background.repaint();
                                    potionIsBeingDisplayed=true;
                                    GameController.getInstance().getMenuController().getMenuView().LiftBlockade();
                                    ((Timer) e.getSource()).stop();
                                }
                            });
                            
                            delayedTimer3.setRepeats(false);
                            delayedTimer3.start();
                            
                        }
                    });
                    
                    delayedTimer2.setRepeats(false);
                    delayedTimer2.start();
                    
                    
                }
            }
        });
        int duration1 = 1500;
        Timer timer1 = new Timer(10, new ActionListener() {
            private long startTime = -1;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startTime == -1) {
                    startTime = System.currentTimeMillis();
                }
                
                long elapsedTime = System.currentTimeMillis() - startTime;
                
                if (elapsedTime < duration1) {
                    // Perform animation logic here
                    IngredientB1.ChangeLocationBy(2,-1);
                    IngredientB2.ChangeLocationBy(-2,-1);
                    repaint();
                } else {
                    // Stop the timer when the duration is reached
                    ((Timer) e.getSource()).stop();
                    System.out.println("Animation completed!");
                    timer2.start();
                    
                }
            }
        });
        
        timer1.start();
        
        
    }
    
    public void reset(){
        potionIsBeingDisplayed=false;
        Background.remove(PotionBackground);
        Background.remove(PotionImage);
        Background.add(IngredientB1);
        Background.setComponentZOrder(IngredientB1,0);
        IngredientB1.reset();
        IngredientB1.ChangeLocationTo(150,155);
        Background.add(IngredientB2);
        Background.setComponentZOrder(IngredientB2,0);
        IngredientB2.reset();
        IngredientB2.ChangeLocationTo(710,155);
        Background.repaint();
    }
}
