package com.interfaces;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class indexGUI extends JFrame implements ActionListener {

    JLabel JLogin, JPass, JVersion, JBinome, SolvenciaPng, JConnexionLabel;
    JPanel NorthPanel, CenterPanel, SouthPanel;
    JTextField JLoginText, JPassText;
    JButton JLoginButton;
    Color PrimaryColor , SecondaryColor;

    public void initColors(){
        PrimaryColor = new Color(39, 167, 73);
        SecondaryColor = new Color(102, 183, 255);
    }

    public void initJButton(){
        JLoginButton = new JButton("Se connecter");
            JLoginButton.setBackground( PrimaryColor );
            JLoginButton.addActionListener( this );
    }

    public void initJLabels(){
        /*
        ImageIcon icon = new ImageIcon();
        try {
            BufferedImage img = ImageIO.read(new File("//home//britos//Documents//Solvencia//Solvencia.png"));
            icon = new ImageIcon( img );
        }catch ( IOException e){
            e.printStackTrace();
        }
        SolvenciaPng = new JLabel( );
        SolvenciaPng.setIcon( icon );
         */

        JLogin = new JLabel("Nom d'utilisateur");
        JLogin.setForeground(PrimaryColor);

        JPass = new JLabel("Mot de passe");
        JPass.setForeground(PrimaryColor);

        JBinome = new JLabel(" Made by ASKOUR Hamza & HILALI Ahmed" , SwingConstants.LEFT);
        JBinome.setForeground(SecondaryColor);

        JVersion = new JLabel("version : 0.1" , SwingConstants.RIGHT);
        JVersion.setForeground(Color.RED);

        JConnexionLabel = new JLabel("Connexion");
    }

    public void initJTexts(){
        JLoginText = new JTextField();
        JPassText = new JTextField();
    }

    public void initPanels(){
        NorthPanel = new JPanel();
            NorthPanel.add( new JLabel("Solvencia") );

        CenterPanel = new JPanel( new GridLayout( 3,1 ) );
            // LOGO CenterPanel.add(SolvenciaPng);
            ImageIcon icon = new ImageIcon("Solvencia.png");
            JLabel thumb = new JLabel();
            thumb.setIcon( icon );
        CenterPanel.add( thumb );

            //Login & Password
                JPanel SubCenterPanel = new JPanel( new GridLayout( 3,1));
                    JPanel TmpPanel = new JPanel();
                    TmpPanel.setBorder( new EmptyBorder( 10,10,10,10));
                    TmpPanel.add( JConnexionLabel );
                    SubCenterPanel.add( TmpPanel );
                SubCenterPanel.setBorder( new EmptyBorder( 0,60,0,60));
                    TmpPanel = new JPanel( new GridLayout( 1 ,2 ));
                    TmpPanel.setBorder( new EmptyBorder( 5,10,5,10));
                    TmpPanel.add(JLogin);
                    TmpPanel.add( JLoginText );
                SubCenterPanel.add(TmpPanel);
                    TmpPanel = new JPanel( new GridLayout( 1 ,2 ));
                    TmpPanel.setBorder( new EmptyBorder( 5,10,5,10));
                    TmpPanel.add(JPass);
                    TmpPanel.add( JPassText );
                SubCenterPanel.add(TmpPanel);
            CenterPanel.add( SubCenterPanel );

            //submit
                SubCenterPanel = new JPanel();
                SubCenterPanel.setBorder( new EmptyBorder( 0 , 10 , 10 ,10));
                SubCenterPanel.add( JLoginButton );
            CenterPanel.add(SubCenterPanel);


        SouthPanel = new JPanel( new GridLayout(1,2));
            SouthPanel.add(JBinome);
            SouthPanel.add(JVersion);

        this.getContentPane().add( NorthPanel , BorderLayout.NORTH );
        this.getContentPane().add( CenterPanel , BorderLayout.CENTER );
        this.getContentPane().add( SouthPanel , BorderLayout.SOUTH );
    }


    public indexGUI(){
        this.setTitle("Gestion EMSI");

        this.getContentPane().setLayout( new BorderLayout() );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setSize(900,400);
        this.setLocationRelativeTo( null );
        //this.setUndecorated(true);

        initColors();
        initJButton();
        initJLabels();
        initJTexts();

        initPanels();

        this.setVisible( true );


    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();

        if( source == JLoginButton ){
            System.out.println("TEST");
        }

    }
}
