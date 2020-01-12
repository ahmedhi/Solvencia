package com.interfaces;

import com.algorithme.Solvabilite;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LogGUI extends JFrame implements ActionListener {
    JPanel NorthPanel , SouthPanel , CenterPanel;
    JLabel NomLabel , PrenomLabel , HeaderLabel , FooterLabel ;
    JButton RetButton , DecButton , LogButton  , AddConButton ,  SolvButton;
    JTable Table ;
    Color GrayGUI , GreenGUI , GreenGrayGUI , DangerGUI ;
    Solvabilite Solvencia;

    public void initColors(){
        GrayGUI = new Color(24, 37, 48);
        GreenGUI = new Color(139, 193, 64);
        GreenGrayGUI = new Color(116, 145, 134);
        DangerGUI = new Color(144, 8, 14);
    }
    public void initTables() throws IOException {
        FileReader input = new FileReader("src/com/algorithme/Log.txt");
        LineNumberReader count = new LineNumberReader(input);
        while (count.skip(Long.MAX_VALUE) > 0) {}

        String[][] data = new String[ count.getLineNumber() ][8];

        File Source = new File( "src/com/algorithme/Log.txt" );
        Scanner sc = new Scanner( Source );
        sc.nextLine();

        for( int i = 0 ; sc.hasNextLine() ; i++){
            String L = sc.nextLine();
            String[] tab = L.split(" ");
            data[i][0] = tab[ tab.length-2 ];
            data[i][1] = tab[ tab.length-1 ];
            data[i][7] = tab[0];
            for ( int j = 1 ; j < tab.length-2 ; j++) {
                data[i][j+1] = tab[j];
            }
        }
        String[] title = {"Nom", "Prenom", "Situation" , "Age" , "Salaire" , " Depense" , "Enfant(s)" , "Target"};
        Table = new JTable(data, title){
            @Override
            public Dimension getPreferredScrollableViewportSize()
            {
                return new Dimension(400, 100);
            }
        };
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
    public void initButtons()
    {
        RetButton = new JButton("Retour");
        RetButton.setBackground(GreenGUI);
        RetButton.setForeground(Color.WHITE);
        RetButton.setFont(new Font("Bodoni MT", Font.BOLD, 15));
        RetButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, GreenGUI));
        RetButton.addActionListener((ActionListener) this);

        DecButton = new JButton("Deconnexion");
        DecButton.setBackground(Color.WHITE);
        DecButton.setForeground(DangerGUI);
        DecButton.setFont(new Font("Bodoni MT", Font.BOLD, 15));
        DecButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, DangerGUI));
        DecButton.addActionListener( this );

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
        CenterPanel.setPreferredSize( new Dimension(100,100));
        gc.insets = new Insets(5, 10, 5, 10);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.ipady = gc.anchor = GridBagConstraints.CENTER;
        gc.ipadx = GridBagConstraints.CENTER;
        gc.weightx = 2;
        gc.weighty = 9;

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
        gc.gridheight = 5;
        JScrollPane TmpScroll = new JScrollPane( Table );
        CenterPanel.add( TmpScroll , gc );

        gc.gridx = 0;
        gc.gridy = 8;
        CenterPanel.add(RetButton, gc);

    }
    public LogGUI( Solvabilite _Solvencia) throws IOException {
        this.setTitle("Administrateur : Historique - Solvencia");
        Solvencia = _Solvencia;

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

        if( source == RetButton ){
            try {
                AdminGUI index = new AdminGUI( Solvencia );
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        }
        else if ( source == DecButton){
            LoginGUI index = new LoginGUI();
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
        else if ( source == SolvButton){
            try {
                CustomerGUI index = new CustomerGUI();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        }

    }
}
