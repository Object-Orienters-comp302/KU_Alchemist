package UI;

import Domain.event.*;
import UI.View.ViewFactory;

import javax.swing.*;
import java.awt.*;

public class GamePage extends JFrame implements Listener {
    
    private JPanel cardPanel;
    private CardLayout cardLayout;
    
    public GamePage() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1300, 800);
        
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        
        cardPanel.add(ViewFactory.getInstance().getLoginView(), "LoginView");
        cardPanel.add(ViewFactory.getInstance().getMenuView(), "MenuView");
        
        this.getContentPane().add(cardPanel);
        
        ViewFactory.getInstance().getLoginView().addListener(this);
        
        cardLayout.show(cardPanel, "LoginView");
        
        setVisible(true);
    }
    
    @Override
    public void onEvent(Domain.event.Type type) {
        if (type == Domain.event.Type.START_MENUVIEW) {
            cardLayout.show(cardPanel, "MenuView");
        }
    }
}
