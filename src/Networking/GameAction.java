package Networking;

import Models.*;
import Utils.AssetLoader;

import javax.swing.*;
import java.io.Serial;
import java.io.Serializable;

public class GameAction implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L; // Ensures version compatibility, not sure how and why
    
    private ActionType actionType;
    private String details;
    private Token  token;
    private int    gold;
    private String targetPlayerName;
    private Ingredient.IngredientTypes ingredientType;
    private Ingredient.IngredientTypes ingredientType1;
    private Potion.IdentityTypes identityType;
    
    private Artifact artifact;
    private boolean testOnStudent;
    private Potion pot;
    private AssetLoader.AssetPath val;
    private Aspect.Colors aspectColorToDebunk;
    
    public GameAction(ActionType actionType, String details) { // THIS IS FOR DEFAULT
        this.actionType = actionType;
        this.details = details;
    }
    
    public GameAction(ActionType actionType, String details, Token token) { // THIS IS FOR PLAYERS
        this.actionType = actionType;
        this.details = details;
        this.token = token;
    }
    public GameAction(ActionType actionType, String details, int gold,String targetPlayerName) { // THIS IS FOR GOLD
        this.actionType = actionType;
        this.details = details;
        this.gold = gold;
        this.targetPlayerName = targetPlayerName;
    }
    public GameAction(ActionType actionType, String details,String targetPlayerName, Ingredient.IngredientTypes ingredientType){
        this.actionType = actionType;
        this.details = details;
        this.ingredientType = ingredientType;
        this.targetPlayerName = targetPlayerName;
    }
    public GameAction(ActionType actionType, String details, Potion.IdentityTypes identityType) { // THIS IS FOR DEFAULT
        this.actionType = actionType;
        this.details = details;
        this.identityType = identityType;
    }
    public GameAction(ActionType actionType, String details,String targetPlayerName) { // THIS IS FOR REQUESTS
        this.actionType = actionType;
        this.details    = details;
        this.targetPlayerName = targetPlayerName;
    }
    public GameAction(ActionType actionType, String details,String targetPlayerName, Artifact artifact) { // THIS IS FOR ARTIFACT RETURNING
        this.actionType = actionType;
        this.details = details;
        this.targetPlayerName= targetPlayerName;
        this.artifact = artifact;
    }
    public GameAction(ActionType actionType, String details, String targetPlayerName, Ingredient.IngredientTypes ingredientType, Ingredient.IngredientTypes ingredientType1,boolean testOnStudent) { // THIS IS FOR REQUESTS
        this.actionType = actionType;
        this.testOnStudent = testOnStudent;
        this.details    = details;
        this.targetPlayerName = targetPlayerName;
        this.ingredientType = ingredientType;
        this.ingredientType1 = ingredientType1;
    }
    public GameAction(ActionType actionType, String details, Potion pot, boolean testOnStudent, Ingredient.IngredientTypes ingredientType, Ingredient.IngredientTypes ingredientType1){
        this.actionType = actionType;
        this.details    = details;
        
        this.pot = pot;
        this.testOnStudent = testOnStudent;
        this.ingredientType = ingredientType;
        this.ingredientType1 = ingredientType1;
        
    }
    public GameAction(ActionType actionType, String details, AssetLoader.AssetPath val, Ingredient.IngredientTypes ingredientType) {
        this.actionType = actionType;
        this.details    = details;
        this.val = val;
        this.ingredientType = ingredientType;
    }
    
    public GameAction(ActionType actionType, String details, String targetPlayerName, Aspect.Colors col) {
        this.actionType = actionType;
        this.details    = details;
        this.targetPlayerName = targetPlayerName;
        this.aspectColorToDebunk = col;
    }
    
    
    public enum ActionType{
        PLAYER_JOINED("PLAYER JOINED"),
        GOLD(""),
        DEAL_INGREDIENT("DEAL_INGREDIENT"),
        REQUEST_ARTIFACT("REQUEST_ARTIFACT"),
        GET_ARTIFACT("GET_ARTIFACT"),
        SELL_POTION("SELL_POTION"),
        MAKE_EXPERIMENT("MAKE_EXPERIMENT"),
        SEND_POTION("SEND_POTION"),
        DECK_INGREDIENT(""),
        FORAGE("FORAGE"),
        REQUEST_PUBLISH("REQUEST_PUBLISH"),
        REQUEST_DEBUNK("REQUEST_DEBUNK"),
        UPDATE_DECK(""),
        START_GAME("START_GAME"),
        INIT_PLAYER("INIT_PLAYER"),
        NEXT_ROUND("NEXT_ROUND"),
        TRANSMUTE("TRANSMUTE");
        
        private final String string;
        
        ActionType(String string) {
            this.string = string;
        }
        
        @Override
        public String toString() {
            return string;
        }
    }
    
    // Getters and setters for actionType and details
    public ActionType getActionType() {
        return actionType;
    }
    
    public String getDetails() {
        return details;
    }
    
    public Token getToken() {
        return token;
    }
    
    public int getGold() {
        return gold;
    }
    
    public Artifact getArtifact() {
        return artifact;
    }
    
    public Ingredient.IngredientTypes getIngredientType() {
        return ingredientType;
    }
    
    public Potion.IdentityTypes getIdentityType() {
        return identityType;
    }
    
    public String getTargetPlayerName() {
        return targetPlayerName;
    }
    
    public Ingredient.IngredientTypes getIngredientType1() {
        return ingredientType1;
    }
    
    public boolean isTestOnStudent() {
        return !testOnStudent;
    }
    
    public Potion getPot() {
        return pot;
    }
    
    public AssetLoader.AssetPath getVal() {
        return val;
    }
    
    public PublicationCard getPublicationCardToDebunk() {
        return publicationCardToDebunk;
    }
    
    public Aspect.Colors getAspectColorToDebunk() {
        return aspectColorToDebunk;
    }
}
