package UI.View;

import Domain.GameController;
import UI.Components.ImagePanels.ImagePanel;
import UI.Components.Tables.RectangleTable;
import UI.Components.Tables.TriangleTableWithImg;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;

public class DeductionView extends JPanel {
    ImagePanel Background;
    TriangleTableWithImg triTable;
    RectangleTable rectangleTable;
    public DeductionView() {
        this.setSize(1000, 500);
        setLayout(null);
        
        Background = new ImagePanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.DEDUCTION_BACKGROUND));
        Background.setForeground(SystemColor.desktop);
        Background.setLocation(0, 0);
        Background.setSize(1000, 500);
        add(Background);
        Background.setLayout(null);
        
        triTable = new TriangleTableWithImg(
                GameController.getInstance().getMenuController().getCurrentPlayer().getTriangleTableArray());
        triTable.setBounds(10, 80, 400, 400);
        triTable.setOpaque(false);
        Background.add(triTable);
        
        rectangleTable = new RectangleTable(
                GameController.getInstance().getMenuController().getCurrentPlayer().getRectangleTableArray());
        rectangleTable.setBounds(360, 10, 600, 300);
        rectangleTable.setOpaque(false);
        Background.add(rectangleTable);
        revalidate();
        repaint();
        
        this.setVisible(true);
    }
    public  void reset(){
        triTable.feedData(GameController.getInstance().getMenuController().getCurrentPlayer().getTriangleTableArray());
        triTable.reset();
        
        rectangleTable.feedData(GameController.getInstance().getMenuController().getCurrentPlayer().getRectangleTableArray());
        rectangleTable.reset();
    }
}




