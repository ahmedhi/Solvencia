package com.interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame implements ActionListener {
    JPanel LeftPanel , RightPanel  , SouthPanel , TitlePanel , FormPanel;
    JButton ConnexionButton ;
    JLabel LoginLabel , NameUserLabel , PasswordLabel , TitleLabel;
    JTextField LoginText , PassText ;
    Color GrayGUI , GreenGUI;


    public void initColors(){
        GrayGUI = new Color(24, 37, 48);
        GreenGUI = new Color(139, 193, 64);
    }
    public void initButtons(){
        ConnexionButton = new JButton("Connexion");
        ConnexionButton.setBackground(GreenGUI);
        ConnexionButton.setForeground(GrayGUI);
        ConnexionButton.setFont(new Font("Bodoni MT", Font.BOLD, 15));
        ConnexionButton.addActionListener( this );
    }
    public void initTexts(){
        LoginText = new JTextField();
        LoginText.setBackground((Color.WHITE));

        PassText = new JTextField();
        PassText.setBackground((Color.WHITE));
    }
    public void initLabels(){
        TitleLabel = new JLabel();
        TitleLabel.setIcon(new ImageIcon(LoginGUI.class.getResource("/Img/Login2.png")));
        TitleLabel.setPreferredSize(new Dimension(300,150));

        LoginLabel = new JLabel();
        LoginLabel.setIcon(new ImageIcon(LoginGUI.class.getResource("/Img/login.png")));
        LoginLabel.setPreferredSize(new Dimension(250,400));


        Font font1 = new Font("standard", Font.BOLD, 12);
        NameUserLabel  = new JLabel("User Name : ");
        NameUserLabel.setFont(font1);
        NameUserLabel.setForeground(new Color(116, 145, 134));

        PasswordLabel = new JLabel ("Password : ");
        PasswordLabel.setFont(font1);
        PasswordLabel.setForeground(new Color(116, 145, 134));


    }
    public void initPanels(){
       LeftPanel = new JPanel();
       LeftPanel.setBackground(GrayGUI);
       LeftPanel.setPreferredSize(new Dimension(250,415));
       LeftPanel.add(LoginLabel);

        TitlePanel = new JPanel();
        TitlePanel.setBackground((Color.WHITE));
        TitlePanel.setPreferredSize(new Dimension(300,150));
        TitlePanel.add(TitleLabel);

        FormPanel = new JPanel();
        FormPanel.setBackground((Color.WHITE));
        FormPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 10, 5, 10);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.ipady = gc.anchor = GridBagConstraints.CENTER;
        gc.ipadx = GridBagConstraints.CENTER;
        gc.weightx = 4;
        gc.weighty = 3;

        gc.gridx = 0;
        gc.gridy = 0;
        FormPanel.add(new JLabel(), gc);

        gc.gridx = 3;
        gc.gridy = 0;
        FormPanel.add(new JLabel(), gc);

        gc.gridx = 0;
        gc.gridy = 1;
        FormPanel.add(NameUserLabel, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        gc.gridwidth = 2;
        FormPanel.add(LoginText, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        FormPanel.add(PasswordLabel, gc);

        gc.gridx = 2;
        gc.gridy = 2;
        gc.gridwidth = 2;
        FormPanel.add(PassText, gc);

       SouthPanel = new JPanel();
       SouthPanel.add(ConnexionButton);
       SouthPanel.setBackground(Color.WHITE);
       SouthPanel.setPreferredSize(new Dimension(350,50));


       RightPanel = new JPanel();
       RightPanel.setLayout(new BorderLayout());
       RightPanel.add(TitlePanel, BorderLayout.NORTH);
       RightPanel.add(FormPanel,BorderLayout.CENTER);
       RightPanel.add(SouthPanel,BorderLayout.SOUTH);

    }
    public LoginGUI(){
        this.setTitle("Solvencia");

        this.getContentPane().setLayout( new BorderLayout() );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setSize(600,430);
        this.setLocationRelativeTo( null );

        initColors();
        initButtons();
        initTexts();
        initLabels();
        initPanels();

        this.getContentPane().add( LeftPanel , BorderLayout.WEST);
        this.getContentPane().add(RightPanel,BorderLayout.CENTER);

        this.setVisible( true );


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if( source == ConnexionButton ){
            CustomerGUI index = new CustomerGUI();
            this.dispose();
        }

    }
}
