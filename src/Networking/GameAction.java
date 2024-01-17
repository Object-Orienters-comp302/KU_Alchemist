package Networking;

import Utils.AssetLoader;

import javax.swing.*;
import java.io.Serial;
import java.io.Serializable;

public class GameAction implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L; // Ensures version compatibility, not sure how and why
    
    private ActionType actionType;
    private String details;
    private AssetLoader.Tokens tokens;
    public GameAction(ActionType actionType, String details) {
        this.actionType = actionType;
        this.details = details;
    }
    public GameAction(ActionType actionType, String details, AssetLoader.Tokens tokens) {
        this.actionType = actionType;
        this.details = details;
        this.tokens = tokens;
        
    }
    
    public enum ActionType{
        PLAYER_JOINED("PLAYER JOINED"),
        GOLD(""),
        ARTIFACT(""),
        POTION(""),
        INGREDIENT(""),
        DECK_ARTIFACT(""),
        DECK_INGREDIENT(""),
        SICKNESS(""),
        REPUTATION(""),
        FORAGERIGHT(""),
        PAUSE(""),
        START_LOGIN_SCREEN(""),
        START_START_VIEW(""),
        START_END_GAME_VIEW(""),
        UPDATE_PLAYER(""),
        UPDATE_DECK("");
        
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
    
    public AssetLoader.Tokens getTokens() {
        return tokens;
    }
}
