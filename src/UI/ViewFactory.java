package UI;

import Domain.*;

public class ViewFactory {

    private static ViewFactory single_instance;

    private BoardView  boardView;
    private DashboardView  dashboardView;
    private HelpScreenView  helpScreenView;
    private LoginPage  loginPage;
    private LoginView  loginView;
    private MenuView  menuView;
    private PauseView  pauseView;

    private ViewFactory() {
        // Initialize sub-controllers
        boardView      = new BoardView();
        dashboardView  = new DashboardView();
        helpScreenView = new HelpScreenView();
        loginPage      = new LoginPage();
        loginView      = new LoginView();
        menuView       = new MenuView();
        pauseView      = new PauseView();

        ViewFactory.single_instance = this;
    }

    public static synchronized ViewFactory getInstance() {
        if (single_instance == null)
            single_instance = new ViewFactory();

        return single_instance;
    }


    public BoardView getBoardView() {
        return boardView;
    }

    public DashboardView getDashboardView() {
        return dashboardView;
    }

    public HelpScreenView getHelpScreenView() {
        return helpScreenView;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public MenuView getMenuView() {
        return menuView;
    }

    public PauseView getPauseView() {
        return pauseView;
    }
}

