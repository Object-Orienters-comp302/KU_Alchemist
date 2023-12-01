package GUI_Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TickButton extends JPanel{
	private ImagePanel img;
	private int state=0;

	
	public TickButton(int x,int y,int width, int height){
		setLayout(null);
		setBounds(x,y,width,height);
		img =new ImagePanel(".//Images//triangleTable//questionMarkWhite.png");
		img.setBounds(0,0,width,height);
		setOpaque(false);
		this.add(img);
	
		this.addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if(state==0) {
            		img.changeImage(".//Images//tokens//greenTick.png");
            		state=1;
            	}
            	else if(state==1) {
            		img.changeImage(".//Images//tokens//redX.png");
            		state=2;
            	}
            	else if(state==2) {
            		img.changeImage(".//Images//triangleTable//questionMarkWhite.png");
            		state=0;
            	}
            }
            });
	}
	
	
	
	
	public static void main(String[] args) {
		//TriangleTable tri = new TriangleTable("#34ebcf");


		JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.getContentPane().setLayout(new GridBagLayout());
        TickButton login = new TickButton(0,0,200,200);
        frame.getContentPane().add(login);
        frame.setVisible(true);
        
        
	}
}
