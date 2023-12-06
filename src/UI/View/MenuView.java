package UI.View;

import GUI_Components.*;
import UI.GamePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuView extends JPanel {
    JPanel basePanel;
    JPanel topPanel;
    JPanel displayerPanel;
    JPanel bottomPanel;
    JPanel sidePanel;
    private JButton btnNewButton;
    
    
    public MenuView() {
        setSize(1280, 760);
        setLayout(null);
        CreateObjects();
        ApplyStuff();
        ApplyFuncs();
        PlacePlayers(3);
        
    }
    
    private void CreateObjects() {
        basePanel      = new JPanel();
        topPanel       = new JPanel();
        displayerPanel = new JPanel();
        bottomPanel    = new JPanel();
        sidePanel      = new JPanel();
        
        btnNewButton = new JButton("New button");
        
        sidePanel.add(btnNewButton);
        
        
    }
    
    private void ApplyStuff() {
        basePanel.setBounds(0, 0, 1280, 720);
        this.add(basePanel);
        basePanel.setBackground(Color.red);
        basePanel.setLayout(null);
        
        topPanel.setBounds(0, 0, 1280, 90);
        basePanel.add(topPanel);
        topPanel.setLayout(null);
        
        displayerPanel.setBounds(0, 90, 1000, 500);
        basePanel.add(displayerPanel);
        displayerPanel.setBackground(Color.red);
        displayerPanel.setLayout(null);
        
        bottomPanel.setBounds(0, 590, 1000, 130);
        basePanel.add(bottomPanel);
        
        sidePanel.setBounds(1000, 90, 280, 630);
        basePanel.add(sidePanel);
    }
    
    private void ApplyFuncs() {
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SummonPuzzle();
            }
        });
    }
    
    public void PlacePlayers(int playerAmount) {
        for (int i = 0; i < playerAmount; i++) {
            PlayerDisplayer comp = new PlayerDisplayer(null);
            comp.setBounds((i * 240 + 40), 5, 200, 80);
            topPanel.add(comp);
        }
        
    }
    
    public void SummonPuzzle() {// ToDo:button stuff needs to be added
        CleanPanel(displayerPanel);
        int[] testArray = new int[28];
        TriangleTableWithImg triTable = new TriangleTableWithImg(testArray);
        triTable.setBounds(0, 50, 400, 400);
        displayerPanel.add(triTable);
        int[][] testArr = new int[8][8];
        RectangleTable rect = new RectangleTable(testArr);
        rect.setBounds(400, 100, 600, 300);
        displayerPanel.add(rect);
        displayerPanel.repaint();
    }
    
    public void CleanPanel(Container panel) {
        panel.removeAll();
        panel.revalidate();
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        MenuView menuView = ViewFactory.getInstance().getMenuView();
        frame.setSize(1300,800);
        frame.add(menuView);
        menuView.setVisible(true);
        frame.setVisible(true);
    }
    
}