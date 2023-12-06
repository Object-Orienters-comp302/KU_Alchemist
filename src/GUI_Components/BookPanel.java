package GUI_Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookPanel extends JPanel {
	public static Boolean[] published =new Boolean[]{false, false, false, false, false, false, false, false};
	//public static int[] traitUsed =new int[8];
	public static int[] traitUsed =new int[] {0,0,0,0,0,0,0,0};
	public BookPanel(int index) {
		setPreferredSize(new Dimension(500, 250));
		setLayout(null);
		setOpaque(false);
		ImagePanel book= new ImagePanel("./Images/book/book.png");
		book.setBounds(0, 0, 300, 160);
		add(book);
		book.setLayout(null);
		
		
		ImagePanel panel = new ImagePanel(BookPanel.chooseImg(index));
		panel.setBounds(30, 5, 80, 80);
		book.add(panel);
		
		ImagePanel endorsePanel = new ImagePanel("./Images/triangleTable/empty.png");
		endorsePanel.setBounds(160, 5, 120, 100);
		book.add(endorsePanel);
		
		ImageChangingPanel confirmButton = new ImageChangingPanel("./Images/book/book.png","./Images/book/feet.png");
		
		confirmButton.setBounds(160, 105, 120, 50);
		book.add(confirmButton);
		BookButton CircleButton = new BookButton(35, 90, 65, 65,index);
		
		//panel_1.setBounds(70, 110, 80, 80);
		add(CircleButton);
		setComponentZOrder(CircleButton, 0);
		
		
		confirmButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int val=CircleButton.getCurrentValue();
				if(val!=0) {
					System.out.print(val);
					traitUsed[index]=val;
					published[index]=true;
				}
			}
		});
		
	}
	
	
	
	
	
	
	
	 public static String chooseImg(int val) {
	    	String path;
	    	switch (val) {
	    	case 0:
	            path = ".\\Images\\book\\feather.png";
	            break;
	        case 1:
	            path = ".\\Images\\book\\feet.png";
	            break;
	        case 2:
	            path = ".\\Images\\book\\flower.png";
	            break;
	        case 3:
	            path = ".\\Images\\book\\frog.png";
	            break;
	        case 4:
	            path = ".\\Images\\book\\mandrake.png";
	            break;
	        case 5:
	            path = ".\\Images\\book\\mushroom.png";
	            break;
	        case 6:
	            path = ".\\Images\\book\\weed.png";
	            break;
	        case 7:
	            path = ".\\Images\\book\\scorpion.png";
	            break;
	        default:
	            path = ".\\Images\\book\\empty.png";
	            break;
	    	}
	    	return path;
	    }
	
	
	 public static void main (String[] args) {
	 JFrame frame = new JFrame("test");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(1200, 1000);
     frame.getContentPane()
             .setLayout(new GridBagLayout());
     BookPanel login = new BookPanel(1);
     frame.getContentPane()
             .add(login);
     frame.setVisible(true);
	 }

}
