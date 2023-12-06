package GUI_Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TriangleTableButton extends JPanel {
    private int diameter, x, y;
    private ImagePanel img;
    
    
    public TriangleTableButton(int x, int y, int width, int height, int index, int[] data) {
        this.setOpaque(false);
        setLayout(null);
        this.setBounds(x, y, width, height);
        
        img = new ImagePanel(chooseImg(data[index]));
        img.setBounds(0, 0, width, height);
        add(img);
        
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clickX = e.getX();
                int clickY = e.getY();
                //Rectangle bounds = getBounds();
                
                if (isClickInsideCircle(clickX, clickY)) {
                    System.out.println("Button click inside the circle!");
                    TriangleTableButtonPopup pop =
                            new TriangleTableButtonPopup(x - width, y - height, width * 3, height * 3, img, index,
                                                         data);
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
    
    public static String chooseImg(int val) {
        String path;
        switch (val) {
            case 0:
                path = ".\\Images\\triangleTable\\outline.png";
                break;
            case 1:
                path = ".\\Images\\triangleTable\\plusRed.png";
                break;
            case 2:
                path = ".\\Images\\triangleTable\\plusGreen.png";
                break;
            case 3:
                path = ".\\Images\\triangleTable\\plusBlue.png";
                break;
            case 4:
                path = ".\\Images\\triangleTable\\minusRed.png";
                break;
            case 5:
                path = ".\\Images\\triangleTable\\minusGreen.png";
                break;
            case 6:
                path = ".\\Images\\triangleTable\\minusBlue.png";
                break;
            case 7:
                path = ".\\Images\\triangleTable\\empty.png";
                break;
            
            default:
                path = ".\\Images\\triangleTable\\outline.png";
        }
        return path;
    }
    
    private boolean isClickInsideCircle(int clickX, int clickY) {
        int radius = diameter / 2;
        int centerX = x + radius;
        int centerY = y + radius;
        
        double distance = Math.sqrt(Math.pow(clickX - centerX, 2) + Math.pow(clickY - centerY, 2));
        
        return distance <= radius;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] testArray = new int[28];
        
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1500);
        frame.getContentPane().setLayout(null);
        TriangleTableButton login = new TriangleTableButton(300, 300, 400, 400, 0, testArray);
        
        
        frame.getContentPane().add(login);
        frame.setVisible(true);
        
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int diameter = Math.min(getWidth(), getHeight());
        this.diameter = diameter;
        
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;
        this.x = x;
        this.y = y;
        
        
        g.setColor(Color.WHITE);
        g.fillOval(x + 5, y + 5, diameter - 10, diameter - 10);/// these fixed values can be changed to dynamics later
    }
    
}
