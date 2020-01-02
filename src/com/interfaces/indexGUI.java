package com.interfaces;

import com.interfaces.Customer.CustomerGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        SolvenciaPng = new JLabel();
            String URL = "src/Solvencia.png" ;
            SolvenciaPng.setIcon(new ImageIcon(new ImageIcon(URL).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));


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
            JPanel SubCenterPanel = new JPanel();
            // LOGO CenterPanel.add(SolvenciaPng);
            SubCenterPanel.add( SolvenciaPng );
        CenterPanel.add( SubCenterPanel );

            //Login & Password
                SubCenterPanel = new JPanel( new GridLayout( 3,1));
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

    }

    public indexGUI(){
        this.setTitle("Solvencia");

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

        this.getContentPane().add( NorthPanel , BorderLayout.NORTH );
        this.getContentPane().add( CenterPanel , BorderLayout.CENTER );
        this.getContentPane().add( SouthPanel , BorderLayout.SOUTH );

        this.setVisible( true );


    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();

        if( source == JLoginButton ){

            CustomerGUI Customer = new CustomerGUI();

            this.dispose();


        }

    }
}
