package Domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {
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

    // Method to handle actions
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "LOGIN":
                // loginController.handleLogin();
                break;
            case "OPEN_MENU":
                // menuController.openMenu();
                break;
            // ... other cases
            default:
                System.out.println("Unknown command in GameController: " + command);
        }
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
