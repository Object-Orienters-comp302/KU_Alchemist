package GUI_Components_Subviews;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI_Components.ForageGrounds;
import GUI_Components.ImageChangingPanel;
import GUI_Components.PlayerDisplayer;
import GUI_Components_Publish.BooksDisplayer;
import GUI_Components_Tables.RectangleTable;
import GUI_Components_Tables.TriangleTableWithImg;
import UI.View.PotionBrewingView;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainPage extends JFrame {
	JPanel basePanel;
	JPanel topPanel;
	
	JPanel displayerPanel;
	CardLayout cardLay;
	//tables
		JPanel tablesPanel;
		BooksDisplayer theoriesPanel;
		PotionBrewingView PotionBrewingPanel;
			
		
		//other?
	JPanel bottomPanel;
	
	JPanel sidePanel;
	//buttons of side panel
		ImageChangingPanel side1;
		ImageChangingPanel side2;
		ImageChangingPanel side3;
	
	
	public MainPage() {	
		setSize(1294,757);
		getContentPane().setLayout(null);
		CreateObjects();
		ApplyStuff();
		ApplyFuncs();
		PlacePlayers(3);
		
		
		this.setResizable(false);
		setVisible(true);
	}
	private void CreateObjects() {
		basePanel = new JPanel();
		topPanel = new JPanel();
		cardLay=new CardLayout();
		displayerPanel = new JPanel(cardLay);
			tablesPanel= new JPanel();
			theoriesPanel= new BooksDisplayer();
			PotionBrewingPanel= new PotionBrewingView();
		
		bottomPanel = new JPanel();
		 
		
		sidePanel = new JPanel(); 
			
			side1 = new ImageChangingPanel("./Images/backgrounds/blueBackground.png","./Images/backgrounds/yellowBackground.png");
			side2 = new ImageChangingPanel("./Images/backgrounds/blueBackground.png","./Images/backgrounds/yellowBackground.png");
			side3 = new ImageChangingPanel("./Images/backgrounds/blueBackground.png","./Images/backgrounds/yellowBackground.png");

		 
	}
	
	private void ApplyStuff() {
		basePanel.setBounds(0, 0, 1280, 720);
		getContentPane().add(basePanel);
		basePanel.setBackground(Color.red);
		basePanel.setLayout(null);
		
		topPanel.setBounds(0, 0, 1280, 90);
		basePanel.add(topPanel);
		topPanel.setLayout(null);
		
		displayerPanel.setBounds(0, 90, 1000, 500);
		basePanel.add(displayerPanel);
		displayerPanel.setBackground(Color.red);
		
		
			tablesPanel.setBounds(0,0,1000,500);
			tablesPanel.setLayout(null);
			SummonPuzzle(tablesPanel);
			
			
			displayerPanel.add(tablesPanel,"Tables");
			
			displayerPanel.add(theoriesPanel,"Theories");
			
			displayerPanel.add(PotionBrewingPanel,"Brewing");
		
		bottomPanel.setBounds(0, 590, 1000, 130);
		basePanel.add(bottomPanel);
		
		sidePanel.setBounds(1000, 90, 280, 630);
		basePanel.add(sidePanel);
		sidePanel.setLayout(null);
		
			side1.setBounds(0, 0, 280, 65);
			sidePanel.add(side1);
			
			side2.setBounds(0, 65, 280, 65);
			sidePanel.add(side2);
			
			side3.setBounds(0, 130, 280, 65);
			sidePanel.add(side3);
			
	}
	
	private void ApplyFuncs()
	{
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
	}
	public void PlacePlayers(int playerAmount) {
		for(int i=0;i<playerAmount;i++) {
			PlayerDisplayer comp=new PlayerDisplayer(null);
			comp.setBounds((i*240+40), 5, 200, 80);
			topPanel.add(comp);
		}
		
	}
	
	public void CleanPanel(Container panel) {
		panel.removeAll();
		panel.revalidate();
	}
	
	public void SummonPuzzle(JPanel pan) {// ToDo:button stuff needs to be added
		int[] testArray = new int[28];
		TriangleTableWithImg triTable = new TriangleTableWithImg(testArray);
		triTable.setBounds(0, 50,400 , 400);
		pan.add(triTable);
		int[][] testArr= new int[8][8];
		RectangleTable rect= new RectangleTable(testArr);
		rect.setBounds(400, 100, 600, 300);
		pan.add(rect);
		pan.revalidate();
		pan.repaint();
	}
	
	
	public static void main (String[] args) {
		new MainPage();
	}
}
