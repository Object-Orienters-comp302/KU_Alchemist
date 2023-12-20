package UI.Components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;

public class CutRoundedPanel extends JPanel {

	private int cornerRadius;

	public CutRoundedPanel() {
        this.cornerRadius = 15;
        setOpaque(false);
    }
	
    public CutRoundedPanel(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        setOpaque(false);
    }
    public CutRoundedPanel(int cornerRadius, boolean addEnterListener) {
        this.cornerRadius = cornerRadius;
        setOpaque(false);
        if(addEnterListener) {
        	this.addMouseListener(new EnterListener(this));
        }
    }
    
    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setClip(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
        super.paintChildren(g2);
        g2.dispose();
    }
    
    static class EnterListener extends MouseAdapter {
    	CutRoundedPanel self;
    	public EnterListener(CutRoundedPanel self) {
    		this.self=self;
    	}
    	
    	@Override
        public void mouseEntered(MouseEvent e) {
        	self.repaint();
        	self.revalidate();
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
        	self.repaint();
        	self.revalidate();
        }
    	
    }
    
    
}
