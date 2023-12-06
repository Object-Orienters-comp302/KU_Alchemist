package GUI_Components;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BookButton extends JPanel {
	private int diameter, x, y,currentValue;
	ImagePanel img;
	public static ArrayList<Integer> taken= new ArrayList<Integer>();

	public BookButton(int x, int y, int width, int height,int index) {
        this.setOpaque(false);
        setLayout(null);
        this.setBounds(x, y, width, height);
        currentValue=BookPanel.traitUsed[index];
        img = new ImagePanel(chooseImg(currentValue));
        img.setBounds(15, 12, width*11/16, height*11/16);
        add(img);
        
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                int clickX = e.getX();
                int clickY = e.getY();
                //Rectangle bounds = getBounds();
                
                if (isClickInsideCircle(clickX, clickY)&&!BookPanel.published[index]) {
                    System.out.println("Button click inside the circle!");
                    BookButtonPopup pop =
                            new BookButtonPopup(x - width/2, y - height/2, width * 2, height * 2,img,BookButton.this);
                    //how to make it add to it
                    Container parent = getParent();
                    parent.add(pop);
                    parent.setComponentZOrder(pop, 0);
                    parent.repaint();
                    
                } else {
                    System.out.println("Button click outside the circle.");
                    System.out.print(getBounds());
                }
            }
        });
        
        
        
        
    }
	@Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        
        int originalDiameter = Math.min(getWidth(), getHeight());
        int customDiameter = originalDiameter * 3 / 4;
        
        int x = (getWidth() - customDiameter) / 2;
        int y = (getHeight() - customDiameter) / 2;
        diameter = originalDiameter;
        
        g.setColor(Color.decode("#ebd2a9"));
        g.fillOval(x, y, customDiameter, customDiameter);
    }
    
    private boolean isClickInsideCircle (int clickX, int clickY) {
        int radius = diameter / 2;
        int centerX = x + radius;
        int centerY = y + radius;
        
        double distance = Math.sqrt(Math.pow(clickX - centerX, 2) + Math.pow(clickY - centerY, 2));
        
        return distance <= radius;
    }
    public static String chooseImg(int val) {
    	String path;
    	switch (val) {
    	case 0:
            path = ".\\\\Images\\\\triangleTable\\\\questionMark.png";
            break;
        case 1:
            path = ".\\Images\\book\\C1.png";
            break;
        case 2:
            path = ".\\Images\\book\\C2.png";
            break;
        case 3:
            path = ".\\Images\\book\\C3.png";
            break;
        case 4:
            path = ".\\Images\\book\\C4.png";
            break;
        case 5:
            path = ".\\Images\\book\\C5.png";
            break;
        case 6:
            path = ".\\Images\\book\\C6.png";
            break;
        case 7:
            path = ".\\Images\\book\\C7.png";
            break;
        case 8:
        	path = ".\\Images\\book\\C8.png";
            break;
        
        default:
            path = ".\\Images\\triangleTable\\questionMark.png";
    	}
    	return path;
    }
    
    public void setCurrentValue(int val) {
    	currentValue=val;
    }
    public int getCurrentValue() {
    	return currentValue;
    }
    public static void main (String[] args) {
        // TODO Auto-generated method stub
        
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1500);
        frame.getContentPane()
                .setLayout(null);
        frame.getContentPane().setBackground(Color.red);
        BookButton book= new BookButton(50,50,100,100,0);
        frame.getContentPane().add(book);
        BookButton book1= new BookButton(250,50,100,100,1);
        frame.getContentPane().add(book1);
        BookButton book2= new BookButton(450,50,100,100,2);
        frame.getContentPane().add(book2);
        BookButton book3= new BookButton(650,50,100,100,3);
        frame.getContentPane().add(book3);
        BookButton book4= new BookButton(50,250,100,100,4);
        frame.getContentPane().add(book4);
        BookButton book5= new BookButton(250,250,100,100,5);
        frame.getContentPane().add(book5);
        BookButton book6= new BookButton(450,250,100,100,6);
        frame.getContentPane().add(book6);
        BookButton book7= new BookButton(650,250,100,100,7);
        frame.getContentPane().add(book7);
        BookButton book8= new BookButton(50,450,100,100,0);
        frame.getContentPane().add(book8);
        frame.setVisible(true);
        
    }

}
