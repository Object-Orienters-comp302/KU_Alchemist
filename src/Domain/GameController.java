package Domain;

public class GameController {
    private static GameController single_instance;

    private LoginController loginController;
    private HelpController helpController;
    private PauseController pauseController;
    private MenuController menuController;
    private RegisterController registerController;
    private RoundOneController roundOneController;
    private RoundTwoController roundTwoController;

    // Constructor
    private GameController() {
        // Initialize sub-controllers
        loginController = new LoginController();
        menuController = new MenuController();
        helpController = new HelpController();
        pauseController = new PauseController();
        registerController = new RegisterController();
        roundOneController = new RoundOneController();
        roundTwoController = new RoundTwoController();

        GameController.single_instance = this;
    }

    public static synchronized GameController getInstance() {
        if (single_instance == null)
            single_instance = new GameController();
        return single_instance;
    }

    // Method to start the game, called by Main
    // The method initializes the GameController instance,
    // Binds the sub-controllers to the GameController instance,
    // and calls the loginController to start the login process
    public static void startGame() {
        GameController.getInstance().loginController    = new LoginController();
        GameController.getInstance().menuController     = new MenuController();
        GameController.getInstance().helpController     = new HelpController();
        GameController.getInstance().pauseController    = new PauseController();
        GameController.getInstance().registerController = new RegisterController();
        GameController.getInstance().roundOneController = new RoundOneController();
        GameController.getInstance().roundTwoController = new RoundTwoController();

        GameController.getInstance().getLoginController().startLogin();
    }

    // Method to change views or states, called by sub-controllers
    public void changeState(String newState) {
        // Handle state change logic
        // For example, switch between different panels/views
    }

    public LoginController getLoginController() {
        return loginController;
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

    public RoundOneController getRoundOneController() {
        return roundOneController;
    }

    public RoundTwoController getRoundTwoController() {
        return roundTwoController;
    }
}
