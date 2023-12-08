package UI.Components.Publish;

import UI.Components.ImageChangingPanel;
import UI.Components.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class BookPanel extends JPanel {
    public static HashMap<AssetLoader.AssetPath, Boolean> published = new HashMap<AssetLoader.AssetPath, Boolean>();
    public static ArrayList<AssetLoader.AssetPath>        traitUsed = new ArrayList<>();
    
    static {
        published.put(AssetLoader.IngredientAssets.Feather, false);
        published.put(AssetLoader.IngredientAssets.Feet, false);
        published.put(AssetLoader.IngredientAssets.Flower, false);
        published.put(AssetLoader.IngredientAssets.Frog, false);
        published.put(AssetLoader.IngredientAssets.Mandrake, false);
        published.put(AssetLoader.IngredientAssets.Mushroom, false);
        published.put(AssetLoader.IngredientAssets.Scorpion, false);
        published.put(AssetLoader.IngredientAssets.Weed, false);
    }
    
    public BookPanel(AssetLoader.AssetPath path) {
        setPreferredSize(new Dimension(500, 250));
        setLayout(null);
        setOpaque(false);
        ImagePanel book = new ImagePanel("./Images/book/book.png");
        book.setBounds(0, 0, 300, 160);
        add(book);
        book.setLayout(null);
        
        
        ImagePanel panel = new ImagePanel(AssetLoader.getAssetPath(path));
        panel.setBounds(30, 5, 80, 80);
        book.add(panel);
        
        ImagePanel endorsePanel = new ImagePanel("./Images/triangleTable/empty.png");
        endorsePanel.setBounds(160, 5, 120, 90);
        book.add(endorsePanel);
        
        ImageChangingPanel confirmButton =
                new ImageChangingPanel("./Images/book/envelope.png", "./Images/book/publish.png");
        
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
                    confirmButton.setDefImage("./Images/book/published.png");
                    confirmButton.setHoverImage("./Images/book/published.png");
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
        BookPanel login = new BookPanel(AssetLoader.Book.allPositive);
        frame.getContentPane().add(login);
        frame.setVisible(true);
    }
    
}
