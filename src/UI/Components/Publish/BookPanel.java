package UI.Components.Publish;

import Utils.AssetLoader;

import javax.swing.*;

import UI.Components.ImagePanels.ImageChangingPanel;
import UI.Components.ImagePanels.ImagePanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class BookPanel extends JPanel {
    public static HashMap<AssetLoader.AssetPath, Boolean> published = new HashMap<AssetLoader.AssetPath, Boolean>();
    public static ArrayList<AssetLoader.AssetPath>        traitUsed = new ArrayList<>();
    
    static {
        published.put(AssetLoader.IngredientAssets.FEATHER, false);
        published.put(AssetLoader.IngredientAssets.FEET, false);
        published.put(AssetLoader.IngredientAssets.FLOWER, false);
        published.put(AssetLoader.IngredientAssets.FROG, false);
        published.put(AssetLoader.IngredientAssets.MANDRAKE, false);
        published.put(AssetLoader.IngredientAssets.MUSHROOM, false);
        published.put(AssetLoader.IngredientAssets.SCORPION, false);
        published.put(AssetLoader.IngredientAssets.WEED, false);
    }
    
    public BookPanel(AssetLoader.AssetPath path) {
        setPreferredSize(new Dimension(500, 250));
        setLayout(null);
        setOpaque(false);
        ImagePanel book = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Book.BOOK));
        book.setBounds(0, 0, 300, 160);
        add(book);
        book.setLayout(null);
        
        
        ImagePanel panel = new ImagePanel(AssetLoader.getAssetPath(path));
        panel.setBounds(30, 5, 80, 80);
        book.add(panel);
        
        ImagePanel endorsePanel = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.TriangleTable.Empty));
        endorsePanel.setBounds(160, 5, 120, 90);
        book.add(endorsePanel);
        
        ImageChangingPanel confirmButton = new ImageChangingPanel(AssetLoader.getAssetPath(AssetLoader.Book.ENVELOPE),
                                                                  AssetLoader.getAssetPath(AssetLoader.Book.PUBLISH));
        
        confirmButton.setBounds(160, 95, 120, 50);
        book.add(confirmButton);
        BookButton CircleButton = new BookButton(35, 90, 65, 65, path);
        
        //panel_1.setBounds(70, 110, 80, 80);
        add(CircleButton);
        setComponentZOrder(CircleButton, 0);
        
        
        confirmButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AssetLoader.AssetPath val = CircleButton.getCurrentPath();
                if (val != AssetLoader.TriangleTable.QUESTION_MARK) {
                    System.out.print(val);
                    traitUsed.add(val);
                    published.put(path, true);
                    confirmButton.setDefImage(AssetLoader.getAssetPath(AssetLoader.Book.PUBLISHED));
                    confirmButton.setHoverImage(AssetLoader.getAssetPath(AssetLoader.Book.PUBLISHED));
                    BookPanel.this.revalidate();
                    BookPanel.this.repaint();
                }
            }
        });
        
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.getContentPane().setLayout(new GridBagLayout());
        BookPanel login = new BookPanel(AssetLoader.Book.ALL_POSITIVE);
        frame.getContentPane().add(login);
        frame.setVisible(true);
    }
    
}
