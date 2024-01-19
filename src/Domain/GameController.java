package Domain;

import Domain.Event.Listener;
import Domain.Event.Publisher;
import Domain.Event.Type;
import Models.Player;
import Networking.GameAction;
import Networking.GameClient;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameController implements Publisher {
    private static GameController single_instance;
    
    private LoginController    loginController;
    private HelpController     helpController;
    private MenuController     menuController;
    private RoundZeroController roundZeroController;
    private RoundOneController roundOneController;
    private RoundTwoController roundTwoController;
    private RoundThreeController roundThreeController;
    private Integer TotalNextTurns;
    private boolean online = false;
    private boolean host = false;
    ArrayList<Listener> listeners;
    private String PlayerName; // THIS IS FOR ONLINE PURPOSES
    
    private GameController() {
        // Initialize sub-controllers
        loginController    = new LoginController();
        menuController     = new MenuController();
        helpController     = new HelpController();
        roundZeroController= new RoundZeroController();
        roundOneController = new RoundOneController();
        roundTwoController = new RoundTwoController();
        roundThreeController = new RoundThreeController();
        
        TotalNextTurns = 0;
        listeners = new ArrayList<>();
        
        GameController.single_instance = this;
    }
    
    public static synchronized GameController getInstance() {
        if (single_instance == null) {
            single_instance = new GameController();
        }
        return single_instance;
    }
    
    public LoginController getLoginController() {
        return loginController;
    }
    
    // Method to change views or states, called by sub-controllers
    public void changeState(String newState) {
        // Handle state change logic
        // For example, switch between different panels/views
    }
    
    public HelpController getHelpController() {
        return helpController;
    }
    
    public MenuController getMenuController() {
        return menuController;
    }
    
    public RoundZeroController getRoundZeroController() {
        return roundZeroController;
    }
    
    public RoundOneController getRoundOneController() {
        return roundOneController;
    }
    
    public RoundTwoController getRoundTwoController() {
        return roundTwoController;
    }
   
    public void nextPlayer(){
        if(GameController.getInstance().isOnline()){
            GameClient.getInstance().sendAction(new GameAction(GameAction.ActionType.NEXT_ROUND,"Next Round"));
        }
        else{
            TotalNextTurns +=1;
            Player.nextPlayer();
        }
    }
    public void incrementTotalNextTurns(){
        TotalNextTurns +=1;
    }
    public RoundThreeController getRoundThreeController() { return roundThreeController; }
    public Integer getRound(){
        int totalRounds = (TotalNextTurns/(Player.getPlayers().size()*3)) + 1;
        if(totalRounds < 4){
            return totalRounds;
        }
        publishEvent(Type.START_END_GAME_VIEW);
        return totalRounds;
    }
    
    public void calculateFinalScores(){
        
        for (Player player : Player.getPlayers()) {
            
            //add 2 gold for each artifact card
            int r_artifacts = player.getInventory().getArtifacts().size();
            player.getInventory().addGold(r_artifacts*4);
            
            // 10 point for each reputation point and 1/3 point for each gold
            player.setScore(player.getReputation()*10 + player.getInventory().getGold());
            
        }
    }
    
    public void publishEvent(Type type) {
        for (Listener listener : listeners) {
            listener.onEvent(type);
        }
    }
    public void addListener(Listener lis) {
        listeners.add(lis);
    }
    
    public void setOnline(boolean online) {
        this.online = online;
    }
    
    public boolean isOnline() { return online; }
    
    public void setHost(boolean host) {
        this.host = host;
    }
    
    public boolean isHost() { return host; }
    
    public String getPlayerName() {
        return PlayerName;
    }
    
    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }
}
