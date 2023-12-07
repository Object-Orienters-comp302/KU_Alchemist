package UI.View;

import Domain.GameController;
import Domain.MenuController;
import GUI_Components.*;
import GUI_Components_Publish.BooksDisplayer;
import GUI_Components_Tables.RectangleTable;
import GUI_Components_Tables.TriangleTableWithImg;
import Models.Player;
import UI.GamePage;
import Utils.AssetLoader;
import Utils.GUtil;
import Utils.KawaseBlur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

public class MenuView extends JPanel {
    private MenuController controller;
    JPanel basePanel;
	JPanel topPanel;
	HQImagePanel backGroundImage;
	
	JPanel displayerPanel;
	CardLayout cardLay;
	//tables
		JPanel tablesPanel;
		BooksDisplayer theoriesPanel;
		PotionBrewingView PotionBrewingPanel;
		ForageGroundsView ForagePanel;
		PlainView PlainPanel;
			
		
		//other?
	JPanel bottomPanel;
	
	JPanel sidePanel;
	//buttons of side panel
		ImageChangingPanel side1;
		ImageChangingPanel side2;
		ImageChangingPanel side3;
		ImageChangingPanel side4;
		ImageChangingPanel side5;
    
    
    public MenuView() {
        controller = GameController.getInstance().getMenuController();
        setLayout(null);
		CreateObjects();
		ApplyStuff();
		ApplyFuncs();
		PlacePlayers();
    }
    
    private void CreateObjects() {
    	basePanel = new JPanel();
		topPanel = new JPanel();
		cardLay=new CardLayout();
		displayerPanel = new JPanel(cardLay);
			tablesPanel= new JPanel();
			theoriesPanel= new BooksDisplayer();
			PotionBrewingPanel= new PotionBrewingView();
			ForagePanel = new ForageGroundsView();
			PlainPanel = new PlainView();
		
		bottomPanel = new JPanel();
		 
		
		sidePanel = new JPanel(); 
			
			side1 = new ImageChangingPanel("./Images/backgrounds/blueBackground.png","./Images/backgrounds/yellowBackground.png");
			side2 = new ImageChangingPanel("./Images/backgrounds/blueBackground.png","./Images/backgrounds/yellowBackground.png");
			side3 = new ImageChangingPanel("./Images/backgrounds/blueBackground.png","./Images/backgrounds/yellowBackground.png");
			side4 = new ImageChangingPanel("./Images/backgrounds/blueBackground.png","./Images/backgrounds/yellowBackground.png");
		
		BufferedImage
				background = KawaseBlur.applyKawaseBlur(Objects.requireNonNull(GUtil.fetchImage(AssetLoader.getAssetPath(AssetLoader.Backgrounds.MAIN_BACKGROUND))),3 ,2);
		backGroundImage = new HQImagePanel(background);
    }
    
    private void ApplyStuff() {
    	basePanel.setBounds(0, 0, 1280, 720);
		add(basePanel);
		basePanel.setBackground(Color.red);
		basePanel.setLayout(null);
		
		
		topPanel.setBounds(0, 0, 1280, 90);
		topPanel.setOpaque(false);
		basePanel.add(topPanel);
		topPanel.setLayout(null);
		
		displayerPanel.setBounds(0, 90, 1000, 500);
		basePanel.add(displayerPanel);
		displayerPanel.setBackground(Color.red);
		
		
			tablesPanel.setBounds(0,0,1000,500);
			tablesPanel.setLayout(null);
			
			SummonPuzzle(tablesPanel);
			
			displayerPanel.add(PlainPanel,"Plain");
			displayerPanel.add(tablesPanel,"Tables");
			
			displayerPanel.add(theoriesPanel,"Theories");
			
			displayerPanel.add(PotionBrewingPanel,"Brewing");
			
			displayerPanel.add(ForagePanel,"Foraging");
		
		bottomPanel.setBounds(0, 590, 1000, 130);
		bottomPanel.setOpaque(false);
		basePanel.add(bottomPanel);
		
		
		backGroundImage.setBounds(0,0,1280,720);
		basePanel.add(backGroundImage);
		sidePanel.setBounds(1000, 90, 280, 630);
		basePanel.add(sidePanel);
		sidePanel.setLayout(null);
		
			side1.setBounds(0, 0, 280, 65);
			sidePanel.add(side1);
			
			side2.setBounds(0, 65, 280, 65);
			sidePanel.add(side2);
			
			side3.setBounds(0, 130, 280, 65);
			sidePanel.add(side3);
			
			side4.setBounds(0, 195, 280, 65);
			sidePanel.add(side4);
    }
    
    private void ApplyFuncs() {
    	side1.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		cardLay.show(displayerPanel, "Tables");
		 	}
		 });
		side2.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		cardLay.show(displayerPanel, "Theories");
		 	}
		 });
		side3.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		cardLay.show(displayerPanel, "Brewing");
		 	}
		 });
		side4.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		cardLay.show(displayerPanel, "Foraging");
		 	}
		 });
    }
    
    public void PlacePlayers() {
        ArrayList<Player> playerList = controller.getPlayers();
        System.out.println(playerList);
        int playerCount = playerList.size();
        
        for (int i = 0; i < playerCount; i++) {
            PlayerDisplayer displayer = new PlayerDisplayer(playerList.get(i));
            
            
            displayer.setBounds((i * 240 + 40), 5, 200, 80);
            topPanel.add(displayer);
        }
        
    }
    
    public void SummonPuzzle(JPanel pan) {// ToDo:button stuff needs to be added
		
		TriangleTableWithImg triTable = new TriangleTableWithImg(controller.getCurrentPlayer().getTriangleTableArray());
		triTable.setBounds(0, 50,400 , 400);
		pan.add(triTable);
		
		RectangleTable rect= new RectangleTable(controller.getCurrentPlayer().getRectangleTableArray());
		rect.setBounds(400, 100, 600, 300);
		pan.add(rect);
		pan.revalidate();
		pan.repaint();
	}
    
    public void CleanPanel(Container panel) {
        panel.removeAll();
        panel.revalidate();
    }
    public static void main(String[] args) {
        new Player("01", null);
        new Player("02", null);
        JFrame frame = new JFrame();
        MenuView menuView = ViewFactory.getInstance().getMenuView();
        frame.setSize(1300,800);
        frame.add(menuView);
        menuView.setVisible(true);
        frame.setVisible(true);
    }
    
}