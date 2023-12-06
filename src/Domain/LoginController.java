package Domain;

import DataTypes.CircularLinkedList;
import Models.Player;
import Models.Token;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

// NOTE: I think the LoginController shouldn't be handling ANYTHING related to the UI. Including the image processing.
// TODO: Move the image processing to a different class, possibly to the view. The LoginController should only be handling the login logic.

public class LoginController {
    protected LoginController() { }
    
    public logPlayerInEnums logPlayerIn(String PlayerID, Image Avatar) {
        if (isUniquePlayerID(PlayerID) && isUniqueAvatar(Avatar)) {
            new Player(PlayerID, Avatar, 0);// Later will have shuffle
            return logPlayerInEnums.LogInSuccesful;
        } else if (isUniquePlayerID(PlayerID)) {
            return logPlayerInEnums.PlayerIDTaken;
        } else {
            return logPlayerInEnums.AvatarTaken;
        }
    }
    
    public boolean isUniquePlayerID(String PlayerID) {
        ArrayList<Player> arrList = Player.getInstances();
        for (Player player : arrList) {
            if (Objects.equals(player.getPlayerID(), PlayerID)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isUniqueAvatar(Image Avatar) {
        ArrayList<Player> arrList = Player.getInstances();
        for (Player player : arrList) {
            if (player.getAvatar() == Avatar) {
                return false;
            }
        }
        return true;
    }
    
    public CircularLinkedList<BufferedImage> getTokenImages() {
        return Token.tokenImages;
    }
    
    public CircularLinkedList<BufferedImage> getTokenBackgrounds() {
        return Token.tokenBackgrounds;
    }
    
    public enum logPlayerInEnums {
        LogInSuccesful,
        PlayerIDTaken,
        AvatarTaken
        
    }
}
