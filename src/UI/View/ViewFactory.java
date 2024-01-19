package UI.View;

import UI.Components.SuperViews.FinalView;
import UI.Components.SuperViews.StartView;
import UI.Components.SuperViews.WaitingRoomView;

public class ViewFactory {
    
    private static ViewFactory single_instance;
    
    // All of the ViewFactory views
    private HelpScreenView  helpScreenView;
    private MenuView        menuView;
    private PauseView       pauseView;
    private LoginView       loginView;
    private OnlineLoginView onlineLoginView;
    private CustomPlainView customPlainView;
    private InventoryView   inventoryView;
    private TransmuteView transmuteView;
    private MarketView    marketView;
    private StartView     startView;
    private FinalView       finalView;
    private WaitingRoomView waitingRoomView;
    
    
    private ViewFactory() {
        // Constructor remains empty as views will be created on demand
    }
    
    public static synchronized ViewFactory getInstance() {
        if (single_instance == null) {
            single_instance = new ViewFactory();
        }
        return single_instance;
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
    
    public OnlineLoginView getOnlineLoginView() {
        if (onlineLoginView == null) {
            onlineLoginView = new OnlineLoginView();
        }
        return onlineLoginView;
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
    
    public MarketView getMarketView() {
        if (marketView == null) {
            marketView = new MarketView();
        }
        return marketView;
    }
    
    public StartView getStartView() {
        if (startView == null) {
            startView = new StartView();
        }
        return startView;
    }
    
    public FinalView getFinalView() {
        if (finalView == null) {
            finalView = new FinalView();
        }
        return finalView;
    }
    
    public WaitingRoomView getWaitingRoomView() {
        if (waitingRoomView == null) {
            waitingRoomView = new WaitingRoomView();
        }
        return waitingRoomView;
    }
}
