package com.interfaces.Customer;

import com.interfaces.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerGUI extends JFrame implements ActionListener {

    JPanel NorthPanel , CenterPanel, SouthPanel;
    JButton AdminButton , SignOutButton , SolvabiliteButton ;
    JLabel NomLabel , PrenomLabel , CINLabel ,
            SFLabel , NbrEnfantLabel , DateLabel , SalaryLabel , DepenseLabel ,
            JVersion , JBinome ;
    JTextField NomText , PrenomText , CINText ,
            SFText , NbrEnfantText , DateText , SalaryText , DepenseText;
    Color PrimaryColor , SecondaryColor ;
    JComboBox SFComboBox;
    CardLayout CL;

    public void initColors(){
        PrimaryColor = new Color(39, 167, 73);
        SecondaryColor = new Color(102, 183, 255);
    }

    public void initCombo(){
        Object[] elements = new Object[]{"Element 1", "Element 2", "Element 3", "Element 4", "Element 5"};
        SFComboBox = new JComboBox( elements );

    }

    public CustomerGUI(){
        this.setTitle("Solvencia");
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setSize(900,400);
        this.setLocationRelativeTo( null );

        initTexts();
        initLabels();
        initJButtons();

        initPanels();
        this.setVisible(true);

    }

    public void initTexts(){
        NomText = new JTextField();
        PrenomText = new JTextField();
        CINText = new JTextField();
        SFText = new JTextField();
        NbrEnfantText = new JTextField();
        DateText = new JTextField();
        SalaryText = new JTextField();
        DepenseText = new JTextField();
    }

    public void initLabels(){
        NomLabel = new JLabel("Nom : ", SwingConstants.CENTER);
            NomLabel.setBackground(  new Color(196, 255, 199) );
        PrenomLabel = new JLabel("Prenom : ", SwingConstants.CENTER);
            PrenomLabel.setBackground(  new Color(196, 255, 199) );
        CINLabel = new JLabel("CIN : ", SwingConstants.CENTER);
            CINLabel.setBackground(  new Color(196, 255, 199) );
        SFLabel = new JLabel("Situation Familial : ", SwingConstants.CENTER);
            SFLabel.setBackground(  new Color(196, 255, 199) );
        NbrEnfantLabel = new JLabel("Nombre d'enfant : ", SwingConstants.CENTER);
            NbrEnfantLabel.setBackground(  new Color(196, 255, 199) );
        DateLabel = new JLabel("Date de naissance : ", SwingConstants.CENTER);
            DateLabel.setBackground(  new Color(196, 255, 199) );
        SalaryLabel = new JLabel("Salaire : ", SwingConstants.CENTER);
            SalaryLabel.setBackground(  new Color(196, 255, 199) );
        DepenseLabel = new JLabel("Dépense : ", SwingConstants.CENTER);
            DepenseLabel.setBackground(  new Color(196, 255, 199) );

        JBinome = new JLabel(" Made by ASKOUR Hamza & HILALI Ahmed" , SwingConstants.LEFT);
        JBinome.setForeground(SecondaryColor);

        JVersion = new JLabel("version : 0.1" , SwingConstants.RIGHT);
        JVersion.setForeground(Color.RED);
    }

    private void initPanels() {
            JPanel TmpPanel = new JPanel( new GridLayout(1,2));
                JPanel SubTmpPanel = new JPanel( new GridLayout(1,4) );
                SubTmpPanel.add( AdminButton );
                SubTmpPanel.add( new JLabel());
                SubTmpPanel.add( new JLabel());
            TmpPanel.add( SubTmpPanel );
                SubTmpPanel = new JPanel( new GridLayout(1,3));
                SubTmpPanel.add( new JLabel(""));
                SubTmpPanel.add( new JLabel(""));
                SubTmpPanel.add( SignOutButton );
            TmpPanel.add(SubTmpPanel);
        NorthPanel = new JPanel( new GridLayout(1,2));
            NorthPanel.add(TmpPanel);

        CL = new CardLayout();
        CenterPanel = new JPanel();
        CenterPanel.setLayout( CL );

        /**
         * IndexPanel represente le card principale
         */
            JPanel IndexPanel = new JPanel( new GridBagLayout() );
            IndexPanel.setBackground(  new Color(196, 255, 199) );
            GridBagConstraints gc = new GridBagConstraints();
                gc.fill = GridBagConstraints.HORIZONTAL;
                gc.ipady = gc.anchor = GridBagConstraints.CENTER;
                gc.insets = new Insets( 10,20,10,20);
                gc.weightx = 2;
                gc.weighty = 4;

            TmpPanel = new JPanel( new GridLayout( 1 , 2) );
                    TmpPanel.add( NomLabel );
                    TmpPanel.add( NomText );
                    gc.gridx = 0;
                    gc.gridy = 0;
                IndexPanel.add( TmpPanel , gc );

            TmpPanel = new JPanel( new GridLayout( 1 , 2) );
                    TmpPanel.add( CINLabel );
                    TmpPanel.add( CINText );
                    gc.gridy = 1;
                IndexPanel.add( TmpPanel , gc );

            TmpPanel = new JPanel( new GridLayout( 1 , 2) );
                    TmpPanel.add( NbrEnfantLabel );
                    TmpPanel.add( NbrEnfantText );
                    gc.gridy = 2;
                IndexPanel.add( TmpPanel , gc );

            TmpPanel = new JPanel( new GridLayout( 1 , 2) );
                    TmpPanel.add( SalaryLabel );
                    TmpPanel.add( SalaryText );
                    gc.gridy = 3;
                IndexPanel.add( TmpPanel , gc );

            TmpPanel = new JPanel( new GridLayout( 1 , 2) );
                    TmpPanel.add( PrenomLabel );
                    TmpPanel.add( PrenomText );
                    gc.gridx = 1;
                    gc.gridy = 0;
                IndexPanel.add( TmpPanel , gc );

            TmpPanel = new JPanel( new GridLayout( 1 , 2) );
                    TmpPanel.add( SFLabel );
                    TmpPanel.add( SFText );
                    gc.gridy = 1;
                IndexPanel.add( TmpPanel , gc );

            TmpPanel = new JPanel( new GridLayout( 1 , 2) );
                    TmpPanel.add( DateLabel );
                    TmpPanel.add( DateText );
                    gc.gridy = 2;
                IndexPanel.add( TmpPanel , gc );

            TmpPanel = new JPanel( new GridLayout( 1 , 2) );
                TmpPanel.add( DepenseLabel );
                TmpPanel.add( DepenseText );
                gc.gridy = 3;
                IndexPanel.add( TmpPanel , gc );

        CenterPanel.add( IndexPanel , "index");

            JPanel AdminPanel = new JPanel( new GridBagLayout() );
            gc.weightx = 2 ;
            gc.weighty = 8 ;

                gc.gridx = 0;
                gc.gridy = 0;
            AdminPanel.add( new JLabel("Nom : HILALI ", SwingConstants.CENTER) , gc );
                gc.gridx = 1;
            AdminPanel.add( new JLabel("Prénom : Ahmed ", SwingConstants.CENTER) , gc );

                gc.gridx = 0;
                gc.gridy = 1;
                    gc.gridwidth = 2;
                    TmpPanel = new JPanel( new GridLayout( 1 , 3));
                    TmpPanel.add( new JButton("Actualiser"));
                    TmpPanel.add( new JButton("Contrainte"));
                    TmpPanel.add( new JButton("Historique"));
            AdminPanel.add( TmpPanel , gc );
            for( int i = 2 ; i < 7 ; i++ ){
                gc.gridy = i;
                AdminPanel.add( new JLabel() , gc );
            }

        CenterPanel.add( AdminPanel , "Admin");

        CL.show( CenterPanel , "index" );


        SouthPanel = new JPanel( new GridLayout(1,2));
        SouthPanel.add(JBinome);
        SouthPanel.add(JVersion);


        this.getContentPane().add( NorthPanel , BorderLayout.NORTH );
        this.getContentPane().add( CenterPanel , BorderLayout.CENTER );
        this.getContentPane().add( SouthPanel , BorderLayout.SOUTH );
    }

    public void initJButtons(){
        AdminButton = new JButton("Administrateur" );
            AdminButton.addActionListener( this );
        SignOutButton = new JButton("Se deconnecter");
            SignOutButton.addActionListener( this );
            SignOutButton.setAlignmentX( SwingConstants.LEFT );
            SignOutButton.setBorder( new EmptyBorder(5,10,5,10));
            //SignOutButton.setBorder( new EmptyBorder(0, 40,0,0));
            SignOutButton.setBackground( new Color(254, 173, 173));

        SolvabiliteButton = new JButton(" Étudier solvabilité : ");
            SolvabiliteButton.addActionListener( this );
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();

        if( source == AdminButton ){
            CL.show( CenterPanel , "Admin" );
        }
        if( source == SignOutButton ){
            indexGUI Customer = new indexGUI();
            this.dispose();
        }
    }
}
