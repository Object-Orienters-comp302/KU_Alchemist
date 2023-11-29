package Domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {
    private LoginController loginController;
    private HelpController helpController;
    private PauseController pauseController;
    private MenuController menuController;
    private RegisterController registerController;
    private RoundOneController roundOneController;
    private RoundTwoController roundTwoController;

    // Constructor
    public GameController() {
        // Initialize sub-controllers
        loginController = new LoginController();
        menuController = new MenuController();
        helpController = new HelpController();
        pauseController = new PauseController();
        registerController = new RegisterController();
        roundOneController = new RoundOneController();
        roundTwoController = new RoundTwoController();
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
    // ... other methods to interact with models or manage application state
}
