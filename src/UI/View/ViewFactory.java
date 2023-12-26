package UI.View;

public class ViewFactory {
    
    private static ViewFactory single_instance;
    
    private BoardView      boardView;
    private DashboardView  dashboardView;
    private HelpScreenView helpScreenView;
    private MenuView       menuView;
    private PauseView      pauseView;
    private LoginView      loginView;
    private CustomPlainView customPlainView;
    private InventoryView inventoryView;
    private TransmuteView transmuteView;
    private BuyArtifactView buyArtifactView;
    
    
    private ViewFactory() {
        // Constructor remains empty as views will be created on demand
    }
    
    public static synchronized ViewFactory getInstance() {
        if (single_instance == null) {
            single_instance = new ViewFactory();
        }
        return single_instance;
    }
    
    public BoardView getBoardView() {
        if (boardView == null) {
            boardView = new BoardView();
        }
        return boardView;
    }
    
    public DashboardView getDashboardView() {
        if (dashboardView == null) {
            dashboardView = new DashboardView();
        }
        return dashboardView;
    }
    
    public HelpScreenView getHelpScreenView() {
        if (helpScreenView == null) {
            helpScreenView = new HelpScreenView();
        }
        return helpScreenView;
    }
    
    public MenuView getMenuView() {
        if (menuView == null) {
            menuView = new MenuView();
        }
        return menuView;
    }
    
    public PauseView getPauseView() {
        if (pauseView == null) {
            pauseView = new PauseView();
        }
        return pauseView;
    }
    
    public LoginView getLoginView() {
        if (loginView == null) {
            loginView = new LoginView();
        }
        return loginView;
    }
    public CustomPlainView getPlainView() {
        if (customPlainView == null) {
            customPlainView = new CustomPlainView();
        }
        return customPlainView;
    }
    
    public InventoryView getInventoryView() {
        if (inventoryView == null) {
            inventoryView = new InventoryView();
        }
        return inventoryView;
    }
    public TransmuteView getTransmuteView() {
        if (transmuteView == null) {
            transmuteView = new TransmuteView();
        }
        return transmuteView;
    }
    public BuyArtifactView getBuyArtifactView() {
        if (buyArtifactView == null) {
            buyArtifactView = new BuyArtifactView();
        }
        return buyArtifactView;
    }
}
