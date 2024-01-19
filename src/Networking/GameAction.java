package Networking;

import Models.Ingredient;
import Models.Player;
import Models.Potion;
import Models.Token;
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
    private Potion.IdentityTypes identityType;
    
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
    
    
    public enum ActionType{
        PLAYER_JOINED("PLAYER JOINED"),
        GOLD(""),
        DEAL_INGREDIENT("DEAL_INGREDIENT"),
        ARTIFACT(""),
        SELL_POTION("SELL_POTION"),
        POTION(""),
        INGREDIENT(""),
        DECK_ARTIFACT(""),
        DECK_INGREDIENT(""),
        SICKNESS(""),
        REPUTATION(""),
        FORAGERIGHT(""),
        PAUSE(""),
        START_LOGIN_SCREEN(""),
        FORAGE("FORAGE"),
        START_START_VIEW(""),
        START_END_GAME_VIEW(""),
        UPDATE_PLAYER(""),
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
    
    public Ingredient.IngredientTypes getIngredientType() {
        return ingredientType;
    }
    
    public Potion.IdentityTypes getIdentityType() {
        return identityType;
    }
    
    public String getTargetPlayerName() {
        return targetPlayerName;
    }
}
