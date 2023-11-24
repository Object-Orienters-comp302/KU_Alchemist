package Domain;

import Models.Player;

import java.awt.*;
import java.util.ArrayList;

public class LoginController {
    public String logPlayerIn(String PlayerID, Image Avatar){
        if(isUniquePlayerID(PlayerID) && isUniqueImage(Avatar) ){
            new Player(PlayerID,Avatar);
            return "Log in is successful";
        }
        else if (isUniquePlayerID(PlayerID)){
            return "PlayerID is taken";
        }
        else{
            return "Avatar is taken";
        }
    }

    private boolean isUniquePlayerID(String PlayerID){
        ArrayList<Player> arrList= Player.getInstances();
        for (int counter = 0; counter < arrList.size(); counter++) {
            if(arrList.get(counter).getPlayerID() == PlayerID){
                return false;
            }
        }
        return true;
    }
    private boolean isUniqueAvatar(Image Avatar){
        ArrayList<Player> arrList= Player.getInstances();
        for (int counter = 0; counter < arrList.size(); counter++) {
            if(arrList.get(counter).getAvatar() == Avatar){
                return false;
            }
        }
        return true;
    }

}
