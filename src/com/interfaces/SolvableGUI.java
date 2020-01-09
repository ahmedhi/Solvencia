package com.interfaces;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolvableGUI extends JFrame implements ActionListener {
    JPanel MasterPanel , SouthPanel ;
    JLabel AccueilLabel ;
    JButton RetButton ;
    Color GrayGUI , GreenGUI , GreenGrayGUI ;


    public void initColors()
    {
        GrayGUI = new Color(24, 37, 48);
        GreenGUI = new Color(139, 193, 64);
        GreenGrayGUI = new Color(116, 145, 134);
    }
    public void initButtons(){
        RetButton = new JButton("Retour");
        RetButton.setBackground(GreenGUI);
        RetButton.setForeground(Color.WHITE);
        RetButton.setFont(new Font("Bodoni MT", Font.BOLD, 15));
        RetButton.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, GreenGUI));
        RetButton.addActionListener((ActionListener) this);
    }
    public void initLabel()
    {
        AccueilLabel = new JLabel();
        AccueilLabel.setIcon(new ImageIcon(AccueilGUI.class.getResource("/Img_Solvable/Solvable.png")));
        //AccueilLabel.setPreferredSize(new Dimension(100,100));
    }
    public void initPanel(){
        MasterPanel = new JPanel();
        MasterPanel.setBackground(GrayGUI);
        //MasterPanel.setPreferredSize(new Dimension(500,400));
        MasterPanel.add(AccueilLabel);

        SouthPanel = new JPanel();
        SouthPanel.setBackground(GrayGUI);
        SouthPanel.setPreferredSize(new Dimension(100,80));
        SouthPanel.add(RetButton);
    }

    public SolvableGUI(){
        this.getContentPane().setLayout( new BorderLayout() );
        this.getContentPane().setBackground(new Color(0x182530));
        this.setSize(600,425);
        this.setLocationRelativeTo( null );
        this.setUndecorated(true);
        initColors();
        initLabel();
        initButtons();
        initPanel();
        this.getContentPane().add( MasterPanel , BorderLayout.CENTER );
        this.getContentPane().add( SouthPanel , BorderLayout.SOUTH );
        this.setVisible( true );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if( source == RetButton ){
            CustomerGUI index = new CustomerGUI();
            this.dispose();
        }

    }
}
