package UI;

import Domain.Event.Listener;
import Domain.Event.Type;
import UI.View.ViewFactory;

import javax.swing.*;
import java.awt.*;

public class GamePage extends JFrame implements Listener {
    public enum DebuggingMode {
        OFF,
        BASIC,
        VERBOSE
    }
    
    
    private CardLayout cardLayout;
    private JPanel     cardPanel;
    
    public GamePage() {
        /*
        GamePage is our main JFrame which we put other JPanels into. It uses CardLayout.
         */
        
        createObjects();
        configureView();
        addListeners();
    }
    private void createObjects(){
        cardLayout = new CardLayout();
        cardPanel  = new JPanel(cardLayout);
    }
    private void configureView(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1290, 750);
        cardPanel.add(ViewFactory.getInstance().getLoginView(), Cards.LoginView.getString());
        this.getContentPane().add(cardPanel);
        cardLayout.show(cardPanel, Cards.LoginView.getString());
        setVisible(true);
    }
    private void addListeners(){
        ViewFactory.getInstance().getLoginView().addListener(this);
        ViewFactory.getInstance().getPauseView().addListener(this);
        ViewFactory.getInstance().getHelpScreenView().addListener(this);
    }
    
    @Override
    public void onEvent(Domain.Event.Type type) {
        if (type == Domain.Event.Type.START_MENUVIEW) {
            cardPanel.add(ViewFactory.getInstance().getMenuView(), Cards.MenuView.getString());
            cardLayout.show(cardPanel, Cards.MenuView.getString());
            ViewFactory.getInstance().getMenuView().addListener(this);
        }
        if (type == Domain.Event.Type.PAUSE) {
            cardPanel.add(ViewFactory.getInstance().getPauseView(), Cards.PauseView.getString());
            cardLayout.show(cardPanel, Cards.PauseView.getString());
        }
        if (type == Domain.Event.Type.HELP){
            cardPanel.add(ViewFactory.getInstance().getHelpScreenView(), Cards.HelpView.getString());
            cardLayout.show(cardPanel, Cards.HelpView.getString());
        }
    }
    
    enum Cards {
        LoginView("LoginView"),
        MenuView("MenuView"),
        PauseView("PauseView"),
        HelpView("HelpView");
        private final String string;
        
        Cards(String string) {
            this.string = string;
        }
        
        public String getString() {
            return string;
        }
    }
}
