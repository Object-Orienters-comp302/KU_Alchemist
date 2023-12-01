package UI;

import Models.Token;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;

public class LoginView {
    public void displayLoginView () {
        // This function creates a JFrame and adds the LoginPage JPanel to it.
        // This function is called from the LoginController.
        new Token("khorne", AssetLoader.getAssetPath(AssetLoader.Tokens.KHORNE),
                  AssetLoader.getAssetPath(AssetLoader.Backgrounds.KHORNE));
        new Token("nurgle", AssetLoader.getAssetPath(AssetLoader.Tokens.NURGLE),
                  AssetLoader.getAssetPath(AssetLoader.Backgrounds.NURGLE));
        new Token("slaanesh", AssetLoader.getAssetPath(AssetLoader.Tokens.SLAANESH),
                  AssetLoader.getAssetPath(AssetLoader.Backgrounds.SLAANESH));
        new Token("tzeentch", AssetLoader.getAssetPath(AssetLoader.Tokens.TZEENTCH),
                  AssetLoader.getAssetPath(AssetLoader.Backgrounds.TZEENTCH));
        
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 900);
        frame.getContentPane()
                .setLayout(new GridBagLayout());
        JPanel login = new LoginPage();
        frame.getContentPane()
                .add(login);
        frame.setVisible(true);
    }
}
