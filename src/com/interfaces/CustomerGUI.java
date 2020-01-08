package com.interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerGUI extends JFrame implements ActionListener {
    JPanel NorthPanel , CenterPanel, SouthPanel;
    JButton NextButton , AdminButton , DecButton ;
    JLabel NameLabel , PrenomLabel  , CINLabel , AgeLabel , HeaderLabel , FooterLabel ;
    JTextField NameText , PrenomText , CINText , AgeText;
    Color GrayGUI , GreenGUI , GreenGrayGUI , DangerGUI ;

    public void initColors(){
        GrayGUI = new Color(24, 37, 48);
        GreenGUI = new Color(139, 193, 64);
        GreenGrayGUI = new Color(116, 145, 134);
        DangerGUI = new Color(144, 8, 14);
    }
    public void initButtons(){
        NextButton = new JButton("Suivant");
        NextButton.setBackground(GreenGUI);
        NextButton.setForeground(Color.WHITE);
        NextButton.setFont(new Font("Bodoni MT", Font.BOLD, 15));
        NextButton.addActionListener( this );

        DecButton = new JButton("Deconnexion");
        DecButton.setBackground(Color.WHITE);
        DecButton.setForeground(DangerGUI);
        DecButton.setFont(new Font("Bodoni MT", Font.BOLD, 15));
        DecButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, DangerGUI));
        DecButton.addActionListener( this );

        AdminButton = new JButton("DashBoard");
        AdminButton.setBackground(Color.WHITE);
        AdminButton.setForeground(GreenGUI);
        AdminButton.setFont(new Font("Bodoni MT", Font.BOLD, 15));
        AdminButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, GreenGUI));
        AdminButton.addActionListener( this );
    }
    public void initTexts(){
        NameText = new JTextField();
        NameText.setBackground((Color.WHITE));

        PrenomText = new JTextField();
        PrenomText.setBackground((Color.WHITE));

        CINText = new JTextField();
        CINText.setBackground((Color.WHITE));

        AgeText = new JTextField();
        AgeText.setBackground((Color.WHITE));
    }
    public void initLabels(){
        Font font = new Font("standard", Font.BOLD, 12);

        NameLabel = new JLabel("Nom Client :") ;
        NameLabel.setFont(font);
        NameLabel.setForeground(GreenGrayGUI);

        PrenomLabel = new JLabel (" Prenom Client :");
        PrenomLabel.setFont(font);
        PrenomLabel.setForeground(GreenGrayGUI);

        CINLabel = new JLabel( "CIN Client :");
        CINLabel.setFont(font);
        CINLabel.setForeground(GreenGrayGUI);

        AgeLabel = new JLabel (" Age Client :" );
        AgeLabel.setFont(font);
        AgeLabel.setForeground(GreenGrayGUI);

        HeaderLabel = new JLabel ();
        HeaderLabel.setIcon(new ImageIcon(CustomerGUI.class.getResource("/Img/header.png")));
        HeaderLabel.setPreferredSize(new Dimension(500,100));

        FooterLabel = new JLabel ();
        FooterLabel.setIcon(new ImageIcon(CustomerGUI.class.getResource("/Img/footer.png")));
        FooterLabel.setPreferredSize(new Dimension(800,20));
    }
    public void initPanels(){
        NorthPanel = new JPanel();
        NorthPanel.setBackground(GrayGUI);
        NorthPanel.setPreferredSize(new Dimension(500,100));
        NorthPanel.add(HeaderLabel);

        SouthPanel = new JPanel();
        SouthPanel.setBackground(GrayGUI);
        SouthPanel.setPreferredSize(new Dimension(100,25));
        SouthPanel.add(FooterLabel);

        CenterPanel = new JPanel() ;
        CenterPanel.setBackground((Color.WHITE));
        CenterPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(0, 10, 5, 10);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.ipady = gc.anchor = GridBagConstraints.CENTER;
        gc.ipadx = GridBagConstraints.CENTER;
        gc.weightx = 6;
        gc.weighty = 4;

        gc.gridx = 0;
        gc.gridy = 0;
        CenterPanel.add(AdminButton, gc);

        gc.gridx = 5;
        gc.gridy = 0;
        CenterPanel.add(DecButton, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        CenterPanel.add(NameLabel, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        CenterPanel.add(CINLabel, gc);

        gc.gridx = 3;
        gc.gridy = 1;
        CenterPanel.add(PrenomLabel, gc);

        gc.gridx = 3;
        gc.gridy = 2;
        CenterPanel.add(AgeLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.gridwidth = 2;
        CenterPanel.add(NameText, gc);

        gc.gridx = 4;
        gc.gridy = 1;
        gc.gridwidth = 2;
        CenterPanel.add(PrenomText, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.gridwidth = 2;
        CenterPanel.add(CINText, gc);

        gc.gridx = 4;
        gc.gridy = 2;
        gc.gridwidth = 2;
        CenterPanel.add(AgeText, gc);

        gc.gridx = 5;
        gc.gridy = 3;
        CenterPanel.add(NextButton, gc);



    }

    public CustomerGUI(){
        this.setTitle("Information Personnel <1> Solvencia");

        this.getContentPane().setLayout( new BorderLayout() );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setSize(900,430);
        this.setLocationRelativeTo( null );

        initColors();
        initButtons();
        initTexts();
        initLabels();
        initPanels();

        this.getContentPane().add( NorthPanel , BorderLayout.NORTH);
        this.getContentPane().add(CenterPanel , BorderLayout.CENTER);
        this.getContentPane().add(SouthPanel,BorderLayout.SOUTH);

        this.setVisible( true );


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if( source == NextButton ){
            CustomerSuiteGUI index = new CustomerSuiteGUI();
            this.dispose();
        }
        else if ( source == DecButton){
            LoginGUI index = new LoginGUI();
            this.dispose();
        }
        else if ( source == AdminButton){
            CustomerSuiteGUI index = new CustomerSuiteGUI();
            this.dispose();
        }
    }

}
