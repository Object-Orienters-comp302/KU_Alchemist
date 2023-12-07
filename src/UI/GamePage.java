package UI;

import Domain.event.*;
import UI.View.ViewFactory;

import javax.swing.*;
import java.awt.*;

public class GamePage extends JFrame implements Listener {
    
    private JPanel cardPanel;
    private CardLayout cardLayout;
    
    public GamePage() {
        /*
        GamePage is our main JFrame which we put other JPanels into. It uses CardLayout.
         */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1300, 800);
        
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        
        cardPanel.add(ViewFactory.getInstance().getLoginView(), Cards.LoginView.getString());
        
        
        this.getContentPane().add(cardPanel);
        
        ViewFactory.getInstance().getLoginView().addListener(this);
        ViewFactory.getInstance().getPauseView().addListener(this);
        cardLayout.show(cardPanel, Cards.LoginView.getString());
        
        setVisible(true);
    }
    
    @Override
    public void onEvent(Domain.event.Type type) {
        if (type == Domain.event.Type.START_MENUVIEW) {
            cardPanel.add(ViewFactory.getInstance().getMenuView(), Cards.MenuView.getString());
            cardLayout.show(cardPanel, Cards.MenuView.getString());
            ViewFactory.getInstance().getMenuView().addListener(this);
        }
        if(type == Domain.event.Type.PAUSE){
            cardPanel.add(ViewFactory.getInstance().getPauseView(), Cards.PauseView.getString());
            cardLayout.show(cardPanel, Cards.PauseView.getString());
        }
    }
    enum Cards{
        LoginView("LoginView"),
        MenuView("MenuView"),
        PauseView("PauseView");
        private final String string;
        
        Cards(String string) {
            this.string = string;
        }
        
        public String getString() {
            return string;
        }
    }
}
