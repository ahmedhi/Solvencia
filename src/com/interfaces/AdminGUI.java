package com.interfaces;

import com.algorithme.Solvabilite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class AdminGUI extends JFrame implements ActionListener {
    JPanel NorthPanel , SouthPanel , CenterPanel;
    JLabel NomLabel , PrenomLabel , HeaderLabel , FooterLabel , AccuranyLabel;
    JButton ActButton , LogButton , ValidationButton , AddConButton , DecButton , SolvButton;
    JTable Table ;
    Color GrayGUI , GreenGUI , GreenGrayGUI , DangerGUI ;
    Solvabilite Solvencia;

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

        AccuranyLabel = new JLabel ("Accurancy " + Solvencia.getAccurancy() + " %" );
        AccuranyLabel.setFont(font);
        AccuranyLabel.setForeground(GreenGrayGUI);
    }
    public void initTables() throws IOException {
        String[][] data = new String[5][11];

        File Source = new File( "src/com/algorithme/WeightLog.txt" );
        Scanner sc = new Scanner( Source );

        String L = sc.nextLine();
        String[] tab = L.split("-");
        String[] NomContrainte = new String[5];
        System.arraycopy(tab, 0, NomContrainte, 0, 5);

        L = sc.nextLine();
        tab = L.split(" ");
        String[] WeightContrainte = new String[5];;
        System.arraycopy(tab, 0, WeightContrainte, 0, 5);

        for( int i = 0 ; i < 5 ; i++ ){
            data[i][0] = NomContrainte[i];
            data[i][1] = WeightContrainte[i];
        }

        String[] title = {"Nom de la contrainte", "Weight"};
        Table = new JTable(data, title){
            @Override
            public Dimension getPreferredScrollableViewportSize()
            {
                return new Dimension(400, 100);
            }
        };
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

        ValidationButton = new JButton("Besoin de validation");
        ValidationButton.setBackground(Color.WHITE);
        ValidationButton.setForeground(GreenGUI);
        ValidationButton.setFont(new Font("Bodoni MT", Font.BOLD, 15));
        ValidationButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, GreenGUI));
        ValidationButton.addActionListener( this );

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


        gc.gridwidth = 2;
        gc.gridx = 0;
        gc.gridy = 2;
        JPanel Tmp = new JPanel( new GridLayout(1 , 3));
        Tmp.add( AddConButton );
        Tmp.add( LogButton );
        Tmp.add( ValidationButton );
        Tmp.setBackground( new Color( 0 , 0 , 0, 0));
        CenterPanel.add( Tmp , gc);

        gc.gridx = 0;
        gc.gridy = 3;
        gc.gridheight = 3;
        JScrollPane TmpScroll = new JScrollPane( Table );
        CenterPanel.add( TmpScroll , gc );
        CenterPanel.add(TmpScroll, gc);

        gc.gridx = 0;
        gc.gridy = 6;
        CenterPanel.add(AccuranyLabel, gc);

        gc.gridx = 1;
        gc.gridy = 6;
        CenterPanel.add(ActButton, gc);
    }
    public  AdminGUI( Solvabilite _Solvencia ) throws IOException {
        this.setTitle("Administrateur | Solvencia");
        Solvencia = new Solvabilite( _Solvencia );

        this.getContentPane().setLayout( new BorderLayout() );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setSize(900,500);
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
            try {
                Solvencia.train();
                AdminGUI index = new AdminGUI( Solvencia );
                this.dispose();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if ( source == DecButton){
            LoginGUI index = new LoginGUI();
            this.dispose();
        }
        else if ( source == SolvButton){
            try {
                CustomerGUI index = new CustomerGUI();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        }
        else if ( source == LogButton){
            try {
                LogGUI index = new LogGUI( Solvencia );
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        }
        else if ( source == AddConButton){
            ContrainteGUI index = new ContrainteGUI( Solvencia );
            this.dispose();
        }
        else if ( source == ValidationButton){
            try {
                Validation index = new Validation( Solvencia );
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        }

    }
}
