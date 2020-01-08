package com.interfaces;

import javax.swing.*;
import java.awt.*;

public class AccueilGUI extends JFrame {
    JPanel MasterPanel ;
    JLabel AccueilLabel ;
    JProgressBar ProgressBar;
    Color GrayGUI , GreenGUI , GreenGrayGUI ;


    public void initColors()
    {
        GrayGUI = new Color(24, 37, 48);
        GreenGUI = new Color(139, 193, 64);
        GreenGrayGUI = new Color(116, 145, 134);
    }
    public void initLabel()
    {
        AccueilLabel = new JLabel();
        AccueilLabel.setIcon(new ImageIcon(AccueilGUI.class.getResource("/Img/accueil.png")));
    }
    public void initPanel(){
        MasterPanel = new JPanel();
        MasterPanel.setBackground(GrayGUI);
        MasterPanel.add(AccueilLabel);
    }
    public void  Run() {
        int i=0;
        while( i<=100)
        {
            try{
                Thread.sleep(25);
                i++;
                    if(i== 100)
                        this.dispose();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        new LoginGUI();
    }


    public AccueilGUI(){
        this.getContentPane().setLayout( new BorderLayout() );
        this.getContentPane().setBackground(new Color(0x182530));
        this.setSize(600,415);
        this.setLocationRelativeTo( null );
        this.setUndecorated(true);
        initColors();
        initLabel();
        initPanel();
        this.getContentPane().add( MasterPanel , BorderLayout.CENTER );
        this.setVisible( true );
        Run();
    }

}
