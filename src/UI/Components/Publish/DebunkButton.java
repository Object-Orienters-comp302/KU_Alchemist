package UI.Components.Publish;

import Domain.GameController;
import Models.Aspect;
import Models.Ingredient;
import Models.PublicationCard;
import UI.Components.ImagePanels.ImagePanel;
import Utils.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DebunkButton extends JPanel {
    private boolean mouseInside = false;
    int arcRad,state=0;
    Color red,redG,green,greenG,blue,blueG,back;
    ImagePanel img;
    int x,y,size;
    public DebunkButton(int x,int y,int size,BookPanel book){
        this.x=x;
        this.y=y;
        this.size=size;
        setBounds(x,y,size,size);
        this.setLayout(null);
        setOpaque(false);
        
        arcRad=size/4;
        
        red=Color.decode("#C92121");
        redG=Color.decode("#FF3131");
        green=Color.decode("#18D74B");
        greenG=Color.decode("#0FFF50");
        blue=Color.decode("#1B42CB");
        blueG=Color.decode("#1F51FF");
        back=Color.white;
        
        img= new ImagePanel(book.CircleButton.getCurrentPath());
        img.setBounds((size-arcRad)/2,(size-arcRad)/2,arcRad,arcRad);
        add(img,0);
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                //System.out.println("entered");
                mouseInside=true;
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                //System.out.println("exited");
                mouseInside=false;
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (state==1){
                    System.out.println("RED PRESSED");
                    book.debunkAction(1);
                }
                if (state==2){
                    System.out.println("GREEN PRESSED");
                    book.debunkAction(2);
                }
                if (state==3){
                    System.out.println("BLUE PRESSED");
                    book.debunkAction(3);
                }
                
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                //System.out.println("Mouse moved inside: (" + e.getX() + ", " + e.getY() + ")");
                if (mouseInside){
                    
                    int mouseX = e.getX();
                    int mouseY = e.getY();
                    
                    int centerX = DebunkButton.this.size / 2;
                    int centerY = getHeight() / 2;
                    
                    // Calculate distances to the centers of each arc
                    double distance = Math.sqrt(Math.pow(mouseX - centerX, 2) + Math.pow(mouseY - centerY, 2));
                    
                    
                    
                    int Radius = size / 2-5;
                    int arcRadius = Radius - arcRad;
                    // Check if the mouse is inside each arc
                    boolean insideArc = distance >= arcRadius && distance <= Radius;
                    
                    double angle = Math.toDegrees(Math.atan2(mouseY - centerY, mouseX - centerX));
                    if (angle<=0){
                        angle=-angle;
                    }
                    else{
                        angle=360-angle;
                    }
                    
                    //System.out.println("Angle: "+angle+ "  Distance: "+distance+ "  Rad: "+ Radius + "    ArcRad: "+arcRadius);
                    // Print or use the results as needed
                    state=0;
                    repaint();
                    if (insideArc) {
                        if (angle>=90 &&angle<=210) {
                            state=1;
                            repaint();
                            //System.out.println("Mouse is inside the red arc.");
                        } else if (angle>=210 &&angle<=330) {
                            state=2;
                            repaint();
                            //System.out.println("Mouse is inside the green arc.");
                        } else if (angle>=330 || angle<=90) {
                            state=3;
                            repaint();
                            //System.out.println("Mouse is inside the blue arc.");
                        }
                    }
                }
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
       
        
        // Get the dimensions of the panel
        
        // Draw the main outer shape (portion between 0 and 120 degrees)
        int startAngle = 90;
        int arcAngle = 120;
        int arcDiameter = size-5; // Adjusted diameter for better appearance
        int x = (size - arcDiameter) / 2;
        int y = (size - arcDiameter) / 2;
        
        if (state==0){
            g.setColor(red);
            g.fillArc(x, y, arcDiameter, arcDiameter, startAngle, arcAngle);
            
            g.setColor(green);
            g.fillArc(x, y, arcDiameter, arcDiameter, startAngle + 120, arcAngle);
            
            g.setColor(blue);
            g.fillArc(x, y, arcDiameter, arcDiameter, startAngle + 240, arcAngle);
            back=Color.white;
        }
        if (state==1){
            g.setColor(redG);
            g.fillArc(x, y, arcDiameter, arcDiameter, startAngle, arcAngle);
            
            g.setColor(green);
            g.fillArc(x, y, arcDiameter, arcDiameter, startAngle + 120, arcAngle);
            
            g.setColor(blue);
            g.fillArc(x, y, arcDiameter, arcDiameter, startAngle + 240, arcAngle);
            back=redG;
        }
        if (state==2){
            g.setColor(red);
            g.fillArc(x, y, arcDiameter, arcDiameter, startAngle, arcAngle);
            
            g.setColor(greenG);
            g.fillArc(x, y, arcDiameter, arcDiameter, startAngle + 120, arcAngle);
            
            g.setColor(blue);
            g.fillArc(x, y, arcDiameter, arcDiameter, startAngle + 240, arcAngle);
            back=greenG;
        }
        if (state==3){
            g.setColor(red);
            g.fillArc(x, y, arcDiameter, arcDiameter, startAngle, arcAngle);
            
            g.setColor(green);
            g.fillArc(x, y, arcDiameter, arcDiameter, startAngle + 120, arcAngle);
            
            g.setColor(blueG);
            g.fillArc(x, y, arcDiameter, arcDiameter, startAngle + 240, arcAngle);
            back=blueG;
        }
        
        
        // Draw inner circular cutout
        int cutoutDiameter =  arcDiameter - arcRad*2;
        //System.out.println("CUTOUT:  " +cutoutDiameter);
        int cutoutX = (size - cutoutDiameter) / 2;
        int cutoutY = (size - cutoutDiameter) / 2;
        g.setColor(back);
        g.fillArc(cutoutX, cutoutY, cutoutDiameter, cutoutDiameter, 0, 360);
        
        
    }
    public void changeImage(AssetLoader.AssetPath path){
        img.changeImage(path);
    }
    
    public void debunkAction(int i,PublicationCard car){
        /*
        GameController.getInstance().getRoundThreeController().debunkTheory(
                GameController.getInstance().getMenuController().getCurrentPlayer(), car, Aspect.Colors.Red
                                                                           );
    */
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("DebunkButton Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);
            frame.setLayout(null);
            
            DebunkButton debunkButton = new DebunkButton(100,100,200,null);
            frame.add(debunkButton);
            
            frame.setVisible(true);
        });
    }
}
