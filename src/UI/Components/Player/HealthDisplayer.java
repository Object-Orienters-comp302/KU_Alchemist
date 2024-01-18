package UI.Components.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HealthDisplayer extends JPanel {
    JPanel H1,H2,H3,H4,H5,H6;
    int health=0;
    ArrayList<JPanel> list;
    public HealthDisplayer(){
        setSize(10,70);
        setLayout(null);
        setBackground(Color.black);
        list = new ArrayList<>();
        for (int i=0;i<=7;i++){
            JPanel pan= new JPanel();
            pan.setBounds(0,10*i,10,9);
            add(pan);
            if (i<3+health){
                pan.setBackground(Color.gray);
            }
            else {
                pan.setBackground(Color.green);
            }
            list.add(pan);
        }
    }
    
    public void setHealth(int health){
        System.out.print("Health: "+ health);
        if (health>3 || health<-3){
            throw new IllegalArgumentException("how is the health below -3");
        }
        Color healthColor= Color.green;
        if (health <0){
            healthColor = Color.red;
        }
        for (int i=0;i<=7;i++){
            JPanel pan=list.get(i);
            if (i<3-health){
                pan.setBackground(Color.gray);
            }
            else {
                pan.setBackground(healthColor);
            }
        }
    }
    
}
