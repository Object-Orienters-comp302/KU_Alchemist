package UI;

import Domain.Event.Listener;
import Domain.Event.Type;
import Domain.GameController;
import Domain.RoundOneController;
import UI.Components.SuperViews.WaitingRoomView;
import UI.View.ViewFactory;

import javax.swing.*;
import java.awt.*;

public class GamePage extends JFrame implements Listener {
    private CardLayout cardLayout;
    private JPanel     cardPanel;
    
    public GamePage() {
        /*
        GamePage is our main JFrame which we put other JPanels into. It uses CardLayout.
         */
        
        createPage();
        configurePage();
        onEvent(Domain.Event.Type.START_START_VIEW);
        addListeners();
        // Manually trigger the event to start START_VIEW
    }
    private void createPage(){
        cardLayout = new CardLayout();
        cardPanel  = new JPanel(cardLayout);
    }
    private void configurePage(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1290, 750);
        setVisible(true);
        this.getContentPane().add(cardPanel);
        
    }
    private void addListeners(){
        ViewFactory.getInstance().getLoginView().addListener(this);
        ViewFactory.getInstance().getOnlineLoginView().addListener(this);
        ViewFactory.getInstance().getPauseView().addListener(this);
        ViewFactory.getInstance().getHelpScreenView().addListener(this);
        ViewFactory.getInstance().getStartView().addListener(this);
        GameController.getInstance().addListener(this);
    }
    
    @Override
    public void onEvent(Domain.Event.Type type) {
        if (type == Domain.Event.Type.START_START_VIEW){
            cardPanel.add(ViewFactory.getInstance().getStartView(), Cards.StartView.getString());
            cardLayout.show(cardPanel, Cards.StartView.getString());
            setVisible(true);
        }
        else if (type == Domain.Event.Type.START_LOGIN_SCREEN) {
            cardPanel.add(ViewFactory.getInstance().getLoginView(), Cards.LoginView.getString());
            cardLayout.show(cardPanel, Cards.LoginView.getString());
            setVisible(true);
        }
        else if (type == Domain.Event.Type.START_ONLINE_LOGIN_SCREEN) {
            cardPanel.add(ViewFactory.getInstance().getOnlineLoginView(), Cards.OnlineLoginView.getString());
            cardLayout.show(cardPanel, Cards.OnlineLoginView.getString());
            setVisible(true);
        }
        else if (type == Domain.Event.Type.START_MENUVIEW) {
            cardPanel.add(ViewFactory.getInstance().getMenuView(), Cards.MenuView.getString());
            cardLayout.show(cardPanel, Cards.MenuView.getString());
            setVisible(true);
            ViewFactory.getInstance().getMenuView().addListener(this);
            
        }
        else if (type == Domain.Event.Type.PAUSE) {
            cardPanel.add(ViewFactory.getInstance().getPauseView(), Cards.PauseView.getString());
            cardLayout.show(cardPanel, Cards.PauseView.getString());
            setVisible(true);
        }
        else if (type == Domain.Event.Type.HELP){
            cardPanel.add(ViewFactory.getInstance().getHelpScreenView(), Cards.HelpView.getString());
            cardLayout.show(cardPanel, Cards.HelpView.getString());
            setVisible(true);
        }
        else if(type == Domain.Event.Type.START_END_GAME_VIEW){
            cardPanel.add(ViewFactory.getInstance().getFinalView(), Cards.FinalView.getString());
            cardLayout.show(cardPanel, Cards.FinalView.getString());
            setVisible(true);
        }
        else if(type == Domain.Event.Type.START_WAITING_ROOM){
            cardPanel.add(ViewFactory.getInstance().getWaitingRoomView(), Cards.WaitingRoomView.getString());
            cardLayout.show(cardPanel, Cards.WaitingRoomView.getString());
            setVisible(true);
        }
    }
    
    enum Cards {
        LoginView("LoginView"),
        OnlineLoginView("OnlineLoginView"),
        MenuView("MenuView"),
        PauseView("PauseView"),
        HelpView("HelpView"),
        StartView("StartView"),
        FinalView("FinalView"),
        WaitingRoomView("WaitingRoomView");
        
        
        private final String string;
        
        Cards(String string) {
            this.string = string;
        }
        
        public String getString() {
            return string;
        }
    }
}
