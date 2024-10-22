package Domain;

import Models.Player;
import Models.Token;
import Networking.GameAction;
import Networking.GameClient;
import Utils.CircularLinkedList;

import java.util.ArrayList;
import java.util.Objects;

// NOTE: I think the LoginController shouldn't be handling ANYTHING related to the UI. Including the image processing.
// TODO: Move the image processing to a different class, possibly to the view. The LoginController should only be handling the login logic.

public class LoginController {
    protected LoginController() { }
    
    public logPlayerInEnums logPlayerIn(String PlayerID) {
        return logPlayerIn(PlayerID, Token.tokenCircularList.get());
    }
    
    public logPlayerInEnums logPlayerIn(String PlayerID, Token token) {
        if (GameController.getInstance().isOnline() && !GameController.getInstance().isHost()) {
            GameController.getInstance().setPlayerName(PlayerID);
            GameAction action = new GameAction(GameAction.ActionType.PLAYER_JOINED, PlayerID, token);
            GameClient.getInstance().sendAction(action);
        }
        else{
            if (isUniquePlayerID(PlayerID)) {
                new Player(PlayerID, token);
                return logPlayerInEnums.LogInSuccesful;
            } else if (isUniquePlayerID(PlayerID)) {
                return logPlayerInEnums.PlayerIDTaken;
            } else {
                return logPlayerInEnums.AvatarTaken;
            }
        }
        // TODO: Add to event log viewer
        
        return null;
    }
    
    public boolean isUniquePlayerID(String PlayerID) {
        ArrayList<Player> arrList = Player.getPlayers();
        for (Player player : arrList) {
            if (Objects.equals(player.getID(), PlayerID)) {
                return false;
            }
        }
        return true;
    }
    
    public CircularLinkedList<Token> getCirularTokens() {
        return Token.tokenCircularList;
    }
    
    
    public enum logPlayerInEnums {
        LogInSuccesful,
        PlayerIDTaken,
        AvatarTaken
        
    }
}
