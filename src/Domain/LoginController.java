package Domain;

import Models.Player;
import Models.Token;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

import DataTypes.CircularLinkedList;

public class LoginController {
    public String logPlayerIn(String PlayerID, Image Avatar) {
        if (isUniquePlayerID(PlayerID) && isUniqueAvatar(Avatar)) {
            new Player(PlayerID, Avatar, 0);// Later will have shuffle
            return "Log in is successful";
        } else if (isUniquePlayerID(PlayerID)) {
            return "PlayerID is taken";
        } else {
            return "Avatar is taken";
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
    
    public CircularLinkedList<BufferedImage> getTokenImages(){
    	return Token.tokenImages;
    }
    public CircularLinkedList<BufferedImage> getTokenBackgrounds(){
    	return Token.tokenBackgrounds;
    }
    

}
