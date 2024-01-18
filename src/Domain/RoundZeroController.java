package Domain;

import Models.Artifact;
import Models.Deck;
import Models.Ingredient;
import Models.Player;

public class RoundZeroController {
    private final Deck deck;
    
    public RoundZeroController() {
        this.deck = Deck.getInstance();
    }
    
    public void gameSetup() {
        
        //Creates 4 of each ingredient card in deck
        initializeIngredients(4);
        initializeArtifacts();
        initializeExtraArtifacts();
        
        this.deck.shuffleIngredients();
        this.deck.shuffleArtifact();
        
        for (Player player : Player.getPlayers()) {
            
            //Distributes starting gold
            gold_setup(player, 10);
            
            // Deal 2 cards to each player
            dealIngredientCards(player, 2);
        }
    }
    
    public void initializeIngredients(int quantity) {
        for (Ingredient.IngredientTypes type : Ingredient.IngredientTypes.values()) {
            deck.addIngredient(type, quantity);
        }
    }
    
    public void  initializeArtifacts(){
        Artifact artifact1 = new Artifact(Artifact.Name.Elixir_of_Insight, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        this.deck.addArtifactCard(artifact1,1);
        
        Artifact artifact2 = new Artifact(Artifact.Name.Magic_Mortar, Artifact.AbilityType.MULTIPLE_TIMES_EFFECT_PER_ROUND);
        this.deck.addArtifactCard(artifact2,1);
        
        Artifact artifact3 = new Artifact(Artifact.Name.Printing_Press, Artifact.AbilityType.MULTIPLE_TIMES_EFFECT_PER_ROUND);
        this.deck.addArtifactCard(artifact3,1);
        
        Artifact artifact4 = new Artifact(Artifact.Name.Wisdom_Idol, Artifact.AbilityType.MULTIPLE_TIMES_EFFECT_PER_ROUND);
        this.deck.addArtifactCard(artifact4,1);
        
    }
    public void initializeExtraArtifacts(){
        Artifact artifact5 = new Artifact(Artifact.Name.Pistol_of_Sickness_Classic, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        this.deck.addArtifactCard(artifact5,1);
        
        Artifact artifact6 = new Artifact(Artifact.Name.Pistol_of_Sickness_Silver, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        this.deck.addArtifactCard(artifact6,1);
        
        Artifact artifact7 = new Artifact(Artifact.Name.Pistol_of_Sickness_Gold, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        this.deck.addArtifactCard(artifact7,1);
        
        Artifact artifact8 = new Artifact(Artifact.Name.Syringe_Kit_Basic1, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        this.deck.addArtifactCard(artifact8,1);
        
        Artifact artifact9 = new Artifact(Artifact.Name.Syringe_Kit_Basic2, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        this.deck.addArtifactCard(artifact9,1);
        
        Artifact artifact10 = new Artifact(Artifact.Name.Elixir_of_Healing, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        this.deck.addArtifactCard(artifact10,1);
        
        Artifact artifact11 = new Artifact(Artifact.Name.Letter_of_DissContent_Blue, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        this.deck.addArtifactCard(artifact11,1);
        
        Artifact artifact12 = new Artifact(Artifact.Name.Letter_of_DissContent_Red, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        this.deck.addArtifactCard(artifact12,1);
        
        Artifact artifact13 = new Artifact(Artifact.Name.Inquisition_Accusation, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        this.deck.addArtifactCard(artifact13,1);
        
        Artifact artifact14 = new Artifact(Artifact.Name.Elixir_of_Healing, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        this.deck.addArtifactCard(artifact14,1);
        
        Artifact artifact15 = new Artifact(Artifact.Name.Big_Black_Chicken, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        this.deck.addArtifactCard(artifact15,1);
        
        Artifact artifact16 = new Artifact(Artifact.Name.Magical_Boar, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        this.deck.addArtifactCard(artifact16,1);
        
        Artifact artifact17 = new Artifact(Artifact.Name.Hunting_Phoenix, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        this.deck.addArtifactCard(artifact17,1);
        
        Artifact artifact18 = new Artifact(Artifact.Name.Mystic_Meerkat, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        this.deck.addArtifactCard(artifact18,1);
        
        Artifact artifact19 = new Artifact(Artifact.Name.Chair_of_Alchemy, Artifact.AbilityType.IMMEDIATE_ONE_TIME_EFFECT);
        this.deck.addArtifactCard(artifact19,1);
    }
    
    public void gold_setup(Player player, int gold) {
        player.getInventory().setGold(gold);
    }
    
    private void dealIngredientCards(Player player, int count) {
        for (int i = 0; i < count; i++) {
            Ingredient.IngredientTypes card = deck.popIngredient();
            player.getInventory().addIngredient(card, 1);
        }
    }
}
