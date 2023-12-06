package GUI_Components;

import javax.swing.*;

public class TriangleTable extends JPanel {
	/*
    String TriColor;
    
    public TriangleTable () {
        setPreferredSize(new Dimension(605, 700));
        setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel MainPanel = new JPanel();
        MainPanel.setBounds(0, 25, 605, 675);
        add(MainPanel);
        MainPanel.setLayout(null);
        
        AngledLinePanel OutlineR = new AngledLinePanel("#b18f12", 5);
        OutlineR.setBounds(301, 0, 303, 606);
        MainPanel.add(OutlineR);
        
        AngledLinePanel OutlineL = new AngledLinePanel("#b18f12", 5, false);
        OutlineL.setBounds(0, 0, 301, 602);
        MainPanel.add(OutlineL);
        
        TrianglePanel Tri1 = new TrianglePanel("#824166");
        Tri1.setBounds(0, 0, 600, 600);
        Tri1.setLayout(null);
        MainPanel.add(Tri1);
        
        TrianglePanel Tri2 = new TrianglePanel("#789319");
        Tri2.setLayout(null);
        Tri2.setBounds(75, 75, 525, 525);
        Tri2.setOpaque(false);
        Tri1.add(Tri2);
        
        TrianglePanel Tri3 = new TrianglePanel("#7d3d2b");
        Tri3.setLayout(null);
        Tri3.setOpaque(false);
        Tri3.setBounds(75, 75, 450, 450);
        Tri2.add(Tri3);
        
        TrianglePanel Tri4 = new TrianglePanel("#cc9d07");
        Tri4.setLayout(null);
        Tri4.setOpaque(false);
        Tri4.setBounds(75, 75, 375, 375);
        Tri3.add(Tri4);
        
        TrianglePanel Tri5 = new TrianglePanel("#387090");
        Tri5.setLayout(null);
        Tri5.setOpaque(false);
        Tri5.setBounds(75, 75, 300, 300);
        Tri4.add(Tri5);
        
        TrianglePanel Tri6 = new TrianglePanel("#987546");
        Tri6.setLayout(null);
        Tri6.setOpaque(false);
        Tri6.setBounds(75, 75, 225, 225);
        Tri5.add(Tri6);
        
        TrianglePanel Tri7 = new TrianglePanel("#b13c2a");
        Tri7.setLayout(null);
        Tri7.setOpaque(false);
        Tri7.setBounds(75, 75, 150, 150);
        Tri6.add(Tri7);
        
        TrianglePanel Tri8 = new TrianglePanel("#3c312b");
        Tri8.setLayout(null);
        Tri8.setOpaque(false);
        Tri8.setBounds(75, 75, 75, 75);
        Tri7.add(Tri8);
        
        AngledLinePanel Line1 = new AngledLinePanel("#b18f12", 5);
        Line1.setBounds(37, 525, 39, 79);
        Tri1.add(Line1);
        Tri1.setComponentZOrder(Line1, 0);
        
        AngledLinePanel Line2 = new AngledLinePanel("#b18f12", 5);
        Line2.setBounds(75, 450, 77, 154);
        Tri1.add(Line2);
        Tri1.setComponentZOrder(Line2, 0);
        
        AngledLinePanel Line3 = new AngledLinePanel("#b18f12", 5);
        Line3.setBounds(112, 375, 114, 229);
        Tri1.add(Line3);
        Tri1.setComponentZOrder(Line3, 0);
        
        AngledLinePanel Line4 = new AngledLinePanel("#b18f12", 5);
        Line4.setBounds(150, 300, 152, 304);
        Tri1.add(Line4);
        Tri1.setComponentZOrder(Line4, 0);
        
        AngledLinePanel Line5 = new AngledLinePanel("#b18f12", 5);
        Line5.setBounds(187, 225, 189, 379);
        Tri1.add(Line5);
        Tri1.setComponentZOrder(Line5, 0);
        
        AngledLinePanel Line6 = new AngledLinePanel("#b18f12", 5);
        Line6.setBounds(225, 150, 227, 454);
        Tri1.add(Line6);
        Tri1.setComponentZOrder(Line6, 0);
        
        AngledLinePanel Line7 = new AngledLinePanel("#b18f12", 5);
        Line7.setBounds(262, 75, 264, 529);
        Tri1.add(Line7);
        Tri1.setComponentZOrder(Line7, 0);
        
        JPanel BottomPanel = new JPanel();
        BottomPanel.setBounds(0, 600, 605, 75);
        MainPanel.add(BottomPanel);
        BottomPanel.setLayout(null);
        
        JPanel BottomPanel_Border_0 = new JPanel();
        BottomPanel_Border_0.setBounds(0, 0, 5, 75);
        BottomPanel.add(BottomPanel_Border_0);
        BottomPanel_Border_0.setBackground(Color.decode("#b18f12"));
        
        JPanel BottomPanel_1 = new JPanel();
        BottomPanel_1.setBounds(5, 0, 67, 75);
        BottomPanel.add(BottomPanel_1);
        BottomPanel_1.setBackground(Color.decode("#824166"));
        
        JPanel BottomPanel_Border_1 = new JPanel();
        BottomPanel_Border_1.setBounds(72, 0, 5, 75);
        BottomPanel.add(BottomPanel_Border_1);
        BottomPanel_Border_1.setBackground(Color.decode("#b18f12"));
        
        JPanel BottomPanel_2 = new JPanel();
        BottomPanel_2.setBounds(77, 0, 70, 75);
        BottomPanel.add(BottomPanel_2);
        BottomPanel_2.setBackground(Color.decode("#789319"));
        
        JPanel BottomPanel_Border_2 = new JPanel();
        BottomPanel_Border_2.setBounds(147, 0, 5, 75);
        BottomPanel.add(BottomPanel_Border_2);
        BottomPanel_Border_2.setBackground(Color.decode("#b18f12"));
        
        JPanel BottomPanel_3 = new JPanel();
        BottomPanel_3.setBounds(152, 0, 70, 75);
        BottomPanel.add(BottomPanel_3);
        BottomPanel_3.setBackground(Color.decode("#7d3d2b"));
        
        JPanel BottomPanel_Border_3 = new JPanel();
        BottomPanel_Border_3.setBounds(222, 0, 5, 75);
        BottomPanel.add(BottomPanel_Border_3);
        BottomPanel_Border_3.setBackground(Color.decode("#b18f12"));
        
        JPanel BottomPanel_4 = new JPanel();
        BottomPanel_4.setBounds(227, 0, 70, 75);
        BottomPanel.add(BottomPanel_4);
        BottomPanel_4.setBackground(Color.decode("#cc9d07"));
        
        JPanel BottomPanel_Border_4 = new JPanel();
        BottomPanel_Border_4.setBounds(297, 0, 5, 75);
        BottomPanel.add(BottomPanel_Border_4);
        BottomPanel_Border_4.setBackground(Color.decode("#b18f12"));
        
        JPanel BottomPanel_5 = new JPanel();
        BottomPanel_5.setBounds(302, 0, 70, 75);
        BottomPanel.add(BottomPanel_5);
        BottomPanel_5.setBackground(Color.decode("#387090"));
        
        JPanel BottomPanel_Border_5 = new JPanel();
        BottomPanel_Border_5.setBounds(372, 0, 5, 75);
        BottomPanel.add(BottomPanel_Border_5);
        BottomPanel_Border_5.setBackground(Color.decode("#b18f12"));
        
        JPanel BottomPanel_6 = new JPanel();
        BottomPanel_6.setBounds(377, 0, 70, 75);
        BottomPanel.add(BottomPanel_6);
        BottomPanel_6.setBackground(Color.decode("#987546"));
        
        JPanel BottomPanel_Border_6 = new JPanel();
        BottomPanel_Border_6.setBounds(447, 0, 5, 75);
        BottomPanel.add(BottomPanel_Border_6);
        BottomPanel_Border_6.setBackground(Color.decode("#b18f12"));
        
        JPanel BottomPanel_7 = new JPanel();
        BottomPanel_7.setBounds(452, 0, 70, 75);
        BottomPanel.add(BottomPanel_7);
        BottomPanel_7.setBackground(Color.decode("#b13c2a"));
        
        JPanel BottomPanel_Border_7 = new JPanel();
        BottomPanel_Border_7.setBounds(521, 0, 5, 75);
        BottomPanel.add(BottomPanel_Border_7);
        BottomPanel_Border_7.setBackground(Color.decode("#b18f12"));
        
        JPanel BottomPanel_8 = new JPanel();
        BottomPanel_8.setBounds(526, 0, 74, 75);
        BottomPanel.add(BottomPanel_8);
        BottomPanel_8.setBackground(Color.decode("#3c312b"));
        
        JPanel BottomPanel_Border_8 = new JPanel();
        BottomPanel_Border_8.setBounds(600, 0, 5, 75);
        BottomPanel.add(BottomPanel_Border_8);
        BottomPanel_Border_8.setBackground(Color.decode("#b18f12"));
        
        
        ///Buttons
        TriangleTableButton Button1 = new TriangleTableButton(271, 70, 60, 60);
        add(Button1);
        setComponentZOrder(Button1, 0);
        
        TriangleTableButton Button2 = new TriangleTableButton(233, 145, 60, 60);
        add(Button2);
        setComponentZOrder(Button2, 0);
        
        TriangleTableButton Button3 = new TriangleTableButton(307, 145, 60, 60);
        add(Button3);
        setComponentZOrder(Button3, 0);
        
        TriangleTableButton Button4 = new TriangleTableButton(197, 220, 60, 60);
        add(Button4);
        setComponentZOrder(Button4, 0);
        
        TriangleTableButton Button5 = new TriangleTableButton(271, 220, 60, 60);
        add(Button5);
        setComponentZOrder(Button5, 0);
        
        TriangleTableButton Button6 = new TriangleTableButton(344, 220, 60, 60);
        add(Button6);
        setComponentZOrder(Button6, 0);
        
        TriangleTableButton Button7 = new TriangleTableButton(160, 295, 60, 60);
        add(Button7);
        setComponentZOrder(Button7, 0);
        
        TriangleTableButton Button8 = new TriangleTableButton(233, 295, 60, 60);
        add(Button8);
        setComponentZOrder(Button8, 0);
        
        TriangleTableButton Button9 = new TriangleTableButton(307, 295, 60, 60);
        add(Button9);
        setComponentZOrder(Button9, 0);
        
        TriangleTableButton Button10 = new TriangleTableButton(382, 295, 60, 60);
        add(Button10);
        setComponentZOrder(Button10, 0);
        
        TriangleTableButton Button11 = new TriangleTableButton(123, 370, 60, 60);
        add(Button11);
        setComponentZOrder(Button11, 0);
        
        TriangleTableButton Button12 = new TriangleTableButton(196, 370, 60, 60);
        add(Button12);
        setComponentZOrder(Button12, 0);
        
        TriangleTableButton Button13 = new TriangleTableButton(270, 370, 60, 60);
        add(Button13);
        setComponentZOrder(Button13, 0);
        
        TriangleTableButton Button14 = new TriangleTableButton(345, 370, 60, 60);
        add(Button14);
        setComponentZOrder(Button14, 0);
        
        TriangleTableButton Button15 = new TriangleTableButton(419, 370, 60, 60);
        add(Button15);
        setComponentZOrder(Button15, 0);
        
        TriangleTableButton Button16 = new TriangleTableButton(83, 445, 60, 60);
        add(Button16);
        setComponentZOrder(Button16, 0);
        
        TriangleTableButton Button17 = new TriangleTableButton(157, 445, 60, 60);
        add(Button17);
        setComponentZOrder(Button17, 0);
        
        TriangleTableButton Button18 = new TriangleTableButton(232, 445, 60, 60);
        add(Button18);
        setComponentZOrder(Button18, 0);
        
        TriangleTableButton Button19 = new TriangleTableButton(307, 445, 60, 60);
        add(Button19);
        setComponentZOrder(Button19, 0);
        
        TriangleTableButton Button20 = new TriangleTableButton(382, 445, 60, 60);
        add(Button20);
        setComponentZOrder(Button20, 0);
        
        TriangleTableButton Button21 = new TriangleTableButton(457, 445, 60, 60);
        add(Button21);
        setComponentZOrder(Button21, 0);
        
        TriangleTableButton Button22 = new TriangleTableButton(47, 520, 60, 60);
        add(Button22);
        setComponentZOrder(Button22, 0);
        
        TriangleTableButton Button23 = new TriangleTableButton(120, 520, 60, 60);
        add(Button23);
        setComponentZOrder(Button23, 0);
        
        TriangleTableButton Button24 = new TriangleTableButton(195, 520, 60, 60);
        add(Button24);
        setComponentZOrder(Button24, 0);
        
        TriangleTableButton Button25 = new TriangleTableButton(270, 520, 60, 60);
        add(Button25);
        setComponentZOrder(Button25, 0);
        
        TriangleTableButton Button26 = new TriangleTableButton(345, 520, 60, 60);
        add(Button26);
        setComponentZOrder(Button26, 0);
        
        TriangleTableButton Button27 = new TriangleTableButton(420, 520, 60, 60);
        add(Button27);
        setComponentZOrder(Button27, 0);
        
        TriangleTableButton Button28 = new TriangleTableButton(495, 520, 60, 60);
        add(Button28);
        setComponentZOrder(Button28, 0);
        
        
    }
    
    
    public static void main (String[] args) {
        //TriangleTable tri = new TriangleTable("#34ebcf");
        
        
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.getContentPane()
                .setLayout(new GridBagLayout());
        TriangleTable login = new TriangleTable();
        frame.getContentPane()
                .add(login);
        frame.setVisible(true);
        
        
    }
    */
    
}

