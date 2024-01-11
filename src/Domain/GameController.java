package Domain;

import Domain.Event.Listener;
import Domain.Event.Publisher;
import Domain.Event.Type;
import Models.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameController implements Publisher {
    private static GameController single_instance;
    
    private LoginController    loginController;
    private HelpController     helpController;
    private PauseController    pauseController;
    private MenuController     menuController;
    private RegisterController registerController;
    private RoundZeroController roundZeroController;
    private RoundOneController roundOneController;
    private RoundTwoController roundTwoController;
    private RoundThreeController roundThreeController;
    private Integer TotalNextTurns;
    ArrayList<Listener> listeners;
    
    private GameController() {
        // Initialize sub-controllers
        loginController    = new LoginController();
        menuController     = new MenuController();
        helpController     = new HelpController();
        pauseController    = new PauseController();
        registerController = new RegisterController();
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
    
    public PauseController getPauseController() {
        return pauseController;
    }
    
    public MenuController getMenuController() {
        return menuController;
    }
    
    public RegisterController getRegisterController() {
        return registerController;
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
        TotalNextTurns +=1;
        Player.nextPlayer();
    }
    public RoundThreeController getRoundThreeController() { return roundThreeController; }
    public Integer getRound(){
        return (TotalNextTurns/(Player.getPlayers().size()*3)) + 1;
    }
    
    public void publishEvent(Type type) {
        for (Listener listener : listeners) {
            listener.onEvent(type);
        }
    }
    public void addListener(Listener lis) {
        listeners.add(lis);
    }
}
