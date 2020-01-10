package com.interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CustomerSuiteGUI extends JFrame implements ActionListener {
    JPanel NorthPanel , CenterPanel, SouthPanel;
    JButton SendButton , PreButton ,  AdminButton , DecButton ;
    JLabel NbrLabel , SalaireLabel  , DepenseLabel , SFLabel ,  HLabel , FLabel ;
    JTextField NbrText , SalaireText , DepenseText;
    JComboBox SFComboBox ;
    Color GrayGUI , GreenGUI , GreenGrayGUI , DangerGUI  ;

    Double Age ;

    public void initComoboBox(){
        Object[] elements = new Object[]{"Marié", "Célebataire", "Divorcé"};
        SFComboBox = new JComboBox(elements);
    }
    public void initColors(){
        GrayGUI = new Color(24, 37, 48);
        GreenGUI = new Color(139, 193, 64);
        GreenGrayGUI = new Color(116, 145, 134);
        DangerGUI = new Color(144, 8, 14);
    }
    public void initButtons(){
        SendButton = new JButton("Etudier La Solvabilité");
        SendButton.setBackground(GreenGUI);
        SendButton.setForeground(Color.WHITE);
        SendButton.setFont(new Font("Bodoni MT", Font.BOLD, 15));
        SendButton.addActionListener((ActionListener) this);

        PreButton = new JButton("Retour");
        PreButton.setBackground(GreenGUI);
        PreButton.setForeground(Color.WHITE);
        PreButton.setFont(new Font("Bodoni MT", Font.BOLD, 15));
        PreButton.addActionListener( this );

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
        NbrText = new JTextField();
        NbrText.setBackground((Color.WHITE));

        SalaireText = new JTextField();
        SalaireText.setBackground((Color.WHITE));

        DepenseText = new JTextField();
        DepenseText.setBackground((Color.WHITE));
    }
    public void initLabels(){
        Font font = new Font("standard", Font.BOLD, 12);

        NbrLabel = new JLabel("Nombre d'enfant :") ;
        NbrLabel.setFont(font);
        NbrLabel.setForeground(GreenGrayGUI);

        SalaireLabel = new JLabel (" Salaire :");
        SalaireLabel.setFont(font);
        SalaireLabel.setForeground(GreenGrayGUI);

        DepenseLabel = new JLabel( "Dépense :");
        DepenseLabel.setFont(font);
        DepenseLabel.setForeground(GreenGrayGUI);

        SFLabel = new JLabel (" Situation Familiale :" );
        SFLabel.setFont(font);
        SFLabel.setForeground(GreenGrayGUI);

        HLabel = new JLabel ();
        //HLabel.setIcon(new ImageIcon(CustomerGUI.class.getResource("/Img/solvencia.gif")));
        HLabel.setIcon(new ImageIcon(CustomerGUI.class.getResource("/Img_Gif/solv.gif")));
        HLabel.setPreferredSize(new Dimension(400,100));

        FLabel = new JLabel ();
        FLabel.setIcon(new ImageIcon(CustomerGUI.class.getResource("/Img_Footer/footer.png")));
        FLabel.setPreferredSize(new Dimension(800,20));
    }
    public void initPanels(){
        NorthPanel = new JPanel();
        NorthPanel.setBackground(Color.WHITE);
        NorthPanel.setPreferredSize(new Dimension(100,100));
        NorthPanel.add(HLabel);

        SouthPanel = new JPanel();
        SouthPanel.setBackground(GrayGUI);
        SouthPanel.setPreferredSize(new Dimension(100,25));
        SouthPanel.add(FLabel);

        CenterPanel = new JPanel() ;
        CenterPanel.setBackground((Color.WHITE));
        CenterPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 10, 5, 10);
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
        CenterPanel.add(NbrLabel, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        CenterPanel.add(SalaireLabel, gc);

        gc.gridx = 3;
        gc.gridy = 1;
        CenterPanel.add(SFLabel, gc);

        gc.gridx = 3;
        gc.gridy = 2;
        CenterPanel.add(DepenseLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.gridwidth = 2;
        CenterPanel.add(NbrText, gc);

        gc.gridx = 4;
        gc.gridy = 1;
        gc.gridwidth = 2;
        CenterPanel.add(SFComboBox, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.gridwidth = 2;
        CenterPanel.add(SalaireText, gc);

        gc.gridx = 4;
        gc.gridy = 2;
        gc.gridwidth = 2;
        CenterPanel.add(DepenseText, gc);

        gc.gridx = 5;
        gc.gridy = 3;
        CenterPanel.add(SendButton, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        CenterPanel.add(PreButton, gc);

    }

    public CustomerSuiteGUI(Double age){
        Age = age ;

        this.setTitle("Information Personnel <2> Solvencia");

        this.getContentPane().setLayout( new BorderLayout() );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setSize(900,430);
        this.setLocationRelativeTo( null );

        initColors();
        initButtons();
        initTexts();
        initLabels();
        initComoboBox();
        initPanels();

        this.getContentPane().add( NorthPanel , BorderLayout.NORTH);
        this.getContentPane().add(CenterPanel , BorderLayout.CENTER);
        this.getContentPane().add(SouthPanel,BorderLayout.SOUTH);

        this.setVisible( true );


    }
    @Override
    public void actionPerformed(ActionEvent e ) {
        Object source = e.getSource();

        if( source == PreButton ){
            CustomerGUI index = new CustomerGUI();
            this.dispose();
        }
        else if ( source == DecButton){
            LoginGUI index = new LoginGUI();
            this.dispose();
        }
        else if ( source == AdminButton){
            AdminGUI index = new AdminGUI();
            this.dispose();
        }
        else if ( source == SendButton){
            List<Double> DataSolvencia  ;
            DataSolvencia = new ArrayList<>();
            if(SFComboBox.getSelectedItem().toString().equals("Marié") )
            {
                DataSolvencia.add(1.0);
                DataSolvencia.add(0.0);
                DataSolvencia.add(0.0);
            }
            else if(SFComboBox.getSelectedItem().toString().equals("Célibataire") )
            {
                DataSolvencia.add(0.0);
                DataSolvencia.add(1.0);
                DataSolvencia.add(0.0);
            }
            else {
                DataSolvencia.add(0.0);
                DataSolvencia.add(0.0);
                DataSolvencia.add(1.0);
            }
            if (Age <= 25 )
            {
                DataSolvencia.add(1.0);
                DataSolvencia.add(0.0);
            }
            else{
                DataSolvencia.add(0.0);
                DataSolvencia.add(1.0);
            }
            if(Double.parseDouble(SalaireText.getText()) <= 10000)
            {
                DataSolvencia.add(1.0);
                DataSolvencia.add(0.0);
            }
            else {
                DataSolvencia.add(0.0);
                DataSolvencia.add(1.0);
            }
            if(Double.parseDouble(DepenseText.getText()) <= 7000)
            {
                DataSolvencia.add(1.0);
                DataSolvencia.add(0.0);
            }
            else {
                DataSolvencia.add(0.0);
                DataSolvencia.add(1.0);
            }
            if(Double.parseDouble(NbrText.getText()) <= 2)
            {
                DataSolvencia.add(1.0);
                DataSolvencia.add(0.0);
            }
            else {
                DataSolvencia.add(0.0);
                DataSolvencia.add(1.0);
            }

            //if (Solvencia( DataSolvencia ))
            // SolvableGUI index = new SolvableGUI();
            //else
            NonSolvableGUI index2 = new NonSolvableGUI();
            this.dispose();
        }


    }

}
