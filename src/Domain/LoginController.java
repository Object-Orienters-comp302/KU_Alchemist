package Domain;

import Models.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

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

    private boolean isUniquePlayerID(String PlayerID) {
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

}
