package UI.View;

import Domain.GameController;
import Domain.MenuController;
import Domain.event.Listener;
import Domain.event.Publisher;
import Domain.event.Type;
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

public class MenuView extends JPanel implements Publisher{
    private MenuController controller;
    JPanel basePanel;
	JPanel topPanel;
	HQImagePanel backGroundImage;
	
	private ArrayList<Listener> listeners;
	
	JPanel displayerPanel;
	CardLayout cardLay;
	//tables
		JPanel tablesPanel;
		BooksDisplayer theoriesPanel;
		PotionBrewingView PotionBrewingPanel;
		ForageGroundsView ForagePanel;
		PlainView PlainPanel;
		InventoryView InventoryPanel;
		TransmuteView TransmutePanel;
			
		
		//other?
	JPanel bottomPanel;
	
	JPanel sidePanel;
	//buttons of side panel
		ImageChangingPanel side1;
		ImageChangingPanel side2;
		ImageChangingPanel side3;
		ImageChangingPanel side4;
		ImageChangingPanel side5;
		ImageChangingPanel side6;
		ImageChangingPanel side7;
	
	
	
	public MenuView() {
        controller = GameController.getInstance().getMenuController();
        setLayout(null);
		CreateObjects();
		ApplyStuff();
		ApplyFuncs();
		PlacePlayers();
    }
    
    private void CreateObjects() {
		this.listeners = new ArrayList<>();
    	basePanel = new JPanel();
		topPanel = new JPanel();
		cardLay=new CardLayout();
		displayerPanel = new JPanel(cardLay);
			tablesPanel= new JPanel();
			theoriesPanel= new BooksDisplayer();
			PotionBrewingPanel= new PotionBrewingView();
			ForagePanel = new ForageGroundsView();
			PlainPanel = new PlainView();
			InventoryPanel = new InventoryView();
			TransmutePanel = new TransmuteView();
		
		bottomPanel = new JPanel();
		 
		
		sidePanel = new JPanel(); 
			//Add assetloader when a new asset is given.
			side1 = new ImageChangingPanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.BLUE),AssetLoader.getAssetPath(AssetLoader.Backgrounds.YELLOW));
			side2 = new ImageChangingPanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.BLUE),AssetLoader.getAssetPath(AssetLoader.Backgrounds.YELLOW));
			side3 = new ImageChangingPanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.BLUE),AssetLoader.getAssetPath(AssetLoader.Backgrounds.YELLOW));
			side4 = new ImageChangingPanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.BLUE),AssetLoader.getAssetPath(AssetLoader.Backgrounds.YELLOW));
			side5 = new ImageChangingPanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.BLUE),AssetLoader.getAssetPath(AssetLoader.Backgrounds.YELLOW));
			side6 = new ImageChangingPanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.BLUE),AssetLoader.getAssetPath(AssetLoader.Backgrounds.YELLOW));
			side7 = new ImageChangingPanel(AssetLoader.getAssetPath(AssetLoader.Backgrounds.BLUE),AssetLoader.getAssetPath(AssetLoader.Backgrounds.YELLOW));
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
		topPanel.setBackground(Color.black);
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
			
			displayerPanel.add(InventoryPanel,"Inventory");
			
			displayerPanel.add(TransmutePanel,"Transmute");
		
		bottomPanel.setBounds(0, 590, 1000, 130);
		bottomPanel.setOpaque(false);
		basePanel.add(bottomPanel);
		
		
		backGroundImage.setBounds(0,0,1280,720);
		backGroundImage.setLayout(null);
		basePanel.add(backGroundImage);
		sidePanel.setBounds(1000, 90, 280, 630);
		sidePanel.setOpaque(false);
		backGroundImage.add(sidePanel);
		sidePanel.setLayout(null);
		sidePanel.setBackground(Color.black);
		
			side1.setBounds(10, 5, 260, 65);
			sidePanel.add(side1);
			
			side2.setBounds(10, 75, 260, 65);
			sidePanel.add(side2);
			
			side3.setBounds(10, 145, 260, 65);
			sidePanel.add(side3);
			
			side4.setBounds(10, 215, 260, 65);
			sidePanel.add(side4);
			
			side5.setBounds(10, 285, 260, 65);
			sidePanel.add(side5);
		
			side6.setBounds(10, 355, 260, 65);
			sidePanel.add(side6);
		
			side7.setBounds(10, 435, 260, 65);
			sidePanel.add(side7);
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
		side5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLay.show(displayerPanel, "Inventory");
			}
		});
		side6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLay.show(displayerPanel, "Transmute");
			}
		});
		side7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				publishEvent(Type.PAUSE);
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
	
	@Override
	public void addListener(Listener lis) {
		listeners.add(lis);
	}
	
	@Override
	public void publishEvent(Type type) {
		for (Listener listener : listeners) {
			listener.onEvent(type);
		}
	}
}