package UI;

import Domain.Event.Listener;
import UI.View.ViewFactory;

import javax.swing.*;
import java.awt.*;

public class GamePage extends JFrame implements Listener {
    
    private JPanel     cardPanel;
    private CardLayout cardLayout;
    
    public GamePage() {
        /*
        GamePage is our main JFrame which we put other JPanels into. It uses CardLayout.
         */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1290, 750);
        
        cardLayout = new CardLayout();
        cardPanel  = new JPanel(cardLayout);
        
        cardPanel.add(ViewFactory.getInstance().getStartView(), Cards.StartView.getString());
        
        this.getContentPane().add(cardPanel);
        
        ViewFactory.getInstance().getLoginView().addListener(this);
        ViewFactory.getInstance().getPauseView().addListener(this);
        ViewFactory.getInstance().getStartView().addListener(this);
        cardLayout.show(cardPanel, Cards.StartView.getString());
        
        
        setVisible(true);
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
        if (type == Domain.Event.Type.LOGIN_SCREEN) {
            cardPanel.add(ViewFactory.getInstance().getPauseView(), Cards.LoginView.getString());
            cardLayout.show(cardPanel, Cards.LoginView.getString());
        }
    }
    
    enum Cards {
        LoginView("LoginView"),
        MenuView("MenuView"),
        PauseView("PauseView"),
        StartView("StartView");
        
        private final String string;
        
        Cards(String string) {
            this.string = string;
        }
        
        public String getString() {
            return string;
        }
    }
}
