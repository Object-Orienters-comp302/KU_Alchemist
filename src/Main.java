import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Domain.GameController;
import Domain.LoginController;
import Models.Token;
import UI.LoginPage;

public class Main {
    public static void main(String[] args) {
        GameController.getInstance().startGame();
    }
}
