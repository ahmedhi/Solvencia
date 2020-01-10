package com.interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUI extends JFrame implements ActionListener {
    JPanel NorthPanel , SouthPanel , CenterPanel;
    JLabel NomLabel , PrenomLabel , HeaderLabel , FooterLabel ;
    JButton ActButton , LogButton  , AddConButton , DecButton , SolvButton;
    JTable Table ;
    Color GrayGUI , GreenGUI , GreenGrayGUI , DangerGUI ;

    public void initColors(){
        GrayGUI = new Color(24, 37, 48);
        GreenGUI = new Color(139, 193, 64);
        GreenGrayGUI = new Color(116, 145, 134);
        DangerGUI = new Color(144, 8, 14);
    }
    public void initLabels(){
        HeaderLabel = new JLabel ();
        HeaderLabel.setIcon(new ImageIcon(CustomerGUI.class.getResource("/Img_Dash/admin_header.png")));
        HeaderLabel.setPreferredSize(new Dimension(110,110));

        FooterLabel = new JLabel ();
        FooterLabel.setIcon(new ImageIcon(CustomerGUI.class.getResource("/Img_Footer/footer.png")));
        FooterLabel.setPreferredSize(new Dimension(800,20));

        Font font = new Font("standard", Font.BOLD, 12);

        NomLabel = new JLabel("Nom : ASKOUR") ;
        NomLabel.setFont(font);
        NomLabel.setForeground(GreenGrayGUI);

        PrenomLabel = new JLabel (" Prénom  : HILALI");
        PrenomLabel.setFont(font);
        PrenomLabel.setForeground(GreenGrayGUI);
    }
    public void initTables()
    {
        Object[][] donnees = {
                /*   {"Johnathan", "Sykes", Color.red, true, Sport.TENNIS},
                   {"Nicolas", "Van de Kampf", Color.black, true, Sport.FOOTBALL},
                   {"Damien", "Cuthbert", Color.cyan, true, Sport.RIEN},
                   {"Corinne", "Valance", Color.blue, false, Sport.NATATION},
                   {"Emilie", "Schrödinger", Color.magenta, false, Sport.FOOTBALL},
                   {"Delphine", "Duke", Color.yellow, false, Sport.TENNIS},
                   {"Eric", "Trump", Color.pink, true, Sport.FOOTBALL},*/
                {"Situation Familiale", "SF", 0.518},
                {"Nombre d'enfant", "NbrEnfant",0.213},
                {"Salaire", "Salaire_Client", 0.698},
                {"Dépense", "Depense_Client",0.600},
        };
        String[] entetes = {"Nom", "Slug", "Coef"};
        Table = new JTable(donnees, entetes);
        Table.setSize(600,200);
        //Table.add(new JScrollPane(Table));
    }
    public void initButtons()
    {
        ActButton = new JButton("Actualiser");
        ActButton.setBackground(Color.WHITE);
        ActButton.setForeground(GreenGUI);
        ActButton.setFont(new Font("Bodoni MT", Font.BOLD, 15));
        ActButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, GreenGUI));
        ActButton.addActionListener((ActionListener) this);

        LogButton = new JButton("Historique");
        LogButton.setBackground(Color.WHITE);
        LogButton.setForeground(GreenGUI);
        LogButton.setFont(new Font("Bodoni MT", Font.BOLD, 15));
        LogButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, GreenGUI));
        LogButton.addActionListener( this );

        AddConButton = new JButton("Ajouter Contrainte ");
        AddConButton.setBackground(Color.WHITE);
        AddConButton.setForeground(GreenGUI);
        AddConButton.setFont(new Font("Bodoni MT", Font.BOLD, 15));
        AddConButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, GreenGUI));
        AddConButton.addActionListener( this );

        DecButton = new JButton("Deconnexion");
        DecButton.setBackground(Color.WHITE);
        DecButton.setForeground(DangerGUI);
        DecButton.setFont(new Font("Bodoni MT", Font.BOLD, 15));
        DecButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, DangerGUI));
        DecButton.addActionListener( this );

        SolvButton = new JButton("Solvencia");
        SolvButton.setBackground(Color.WHITE);
        SolvButton.setForeground(DangerGUI);
        SolvButton.setFont(new Font("Bodoni MT", Font.BOLD, 15));
        SolvButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, DangerGUI));
        SolvButton.addActionListener( this );

    }
    public void initPanels(){
        NorthPanel = new JPanel();
        NorthPanel.setBackground(GrayGUI);
        NorthPanel.setPreferredSize(new Dimension(100,115));
        NorthPanel.add(HeaderLabel);

        SouthPanel = new JPanel();
        SouthPanel.setBackground(GrayGUI);
        SouthPanel.setPreferredSize(new Dimension(100,25));
        SouthPanel.add(FooterLabel);

        CenterPanel = new JPanel() ;
        CenterPanel.setBackground((Color.WHITE));
        CenterPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 10, 5, 10);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.ipady = gc.anchor = GridBagConstraints.CENTER;
        gc.ipadx = GridBagConstraints.CENTER;
        gc.weightx = 2;
        gc.weighty = 7;

        gc.gridx = 0;
        gc.gridy = 0;
        CenterPanel.add(SolvButton, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        CenterPanel.add(DecButton, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        CenterPanel.add(NomLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        CenterPanel.add(PrenomLabel, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        CenterPanel.add(AddConButton, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        CenterPanel.add(LogButton, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        gc.gridwidth = 2;
        gc.gridheight = 3;
        CenterPanel.add(Table, gc);


        gc.gridx = 1;
        gc.gridy = 6;
        CenterPanel.add(ActButton, gc);
    }
    public  AdminGUI(){
        this.setTitle("Administrateur <1> Solvencia");

        this.getContentPane().setLayout( new BorderLayout() );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setSize(900,430);
        this.setLocationRelativeTo( null );

        initColors();
        initLabels();
        initButtons();
        initTables();
        initPanels();

        this.getContentPane().add( NorthPanel , BorderLayout.NORTH);
        this.getContentPane().add(CenterPanel , BorderLayout.CENTER);
        this.getContentPane().add(SouthPanel,BorderLayout.SOUTH);

        this.setVisible( true );


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if( source == ActButton ){
            AdminGUI index = new AdminGUI();
            this.dispose();
        }
        else if ( source == DecButton){
            LoginGUI index = new LoginGUI();
            this.dispose();
        }
        else if ( source == SolvButton){
            CustomerGUI index = new CustomerGUI();
            this.dispose();
        }
        else if ( source == LogButton){
            LogGUI index = new LogGUI();
            this.dispose();
        }
        else if ( source == AddConButton){
            ContrainteGUI index = new ContrainteGUI();
            this.dispose();
        }

    }
}
