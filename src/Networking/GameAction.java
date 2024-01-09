package Networking;

import java.io.Serial;
import java.io.Serializable;

public class GameAction implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L; // Ensures version compatibility, not sure how and why
    
    private String actionType;
    private String details;
    
    public GameAction(String actionType, String details) {
        this.actionType = actionType;
        this.details = details;
    }
    
    // Getters and setters for actionType and details
    public String getActionType() {
        return actionType;
    }
    
    public String getDetails() {
        return details;
    }
}
