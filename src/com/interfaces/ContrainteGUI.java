package com.interfaces;

import com.algorithme.Solvabilite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ContrainteGUI extends JFrame implements ActionListener {
    JPanel NorthPanel , SouthPanel , CenterPanel;
    JLabel NomLabel , PrenomLabel , ConNameLabel , ConSlugLabel , HeaderLabel , FooterLabel ;
    JButton RetButton , DecButton , AddButton , SolvButton;
    JTextField NomText , SlugText;
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

        ConNameLabel = new JLabel("Nom du Contrainte : ");
        ConNameLabel.setFont(font);
        ConNameLabel.setForeground(GreenGrayGUI);

        ConSlugLabel = new JLabel("Slug du Contrainte : ");
        ConSlugLabel.setFont(font);
        ConSlugLabel.setForeground(GreenGrayGUI);
    }
    public void initTexts(){
        NomText = new JTextField();
        NomText.setBackground((Color.WHITE));

        SlugText = new JTextField();
        SlugText.setBackground((Color.WHITE));
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

        AddButton = new JButton("Ajouter");
        AddButton.setBackground(GreenGUI);
        AddButton.setForeground(Color.WHITE);
        AddButton.setFont(new Font("Bodoni MT", Font.BOLD, 15));
        AddButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, GreenGUI));
        AddButton.addActionListener( this );

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
        gc.insets = new Insets(5, 50, 5, 50);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.ipady = gc.anchor = GridBagConstraints.CENTER;
        gc.ipadx = GridBagConstraints.CENTER;
        gc.weightx = 2;
        gc.weighty = 5;

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
        CenterPanel.add(ConNameLabel,gc);

        gc.gridx = 1;
        gc.gridy = 2;
        CenterPanel.add(NomText,gc);

        gc.gridx = 0;
        gc.gridy = 3;
        CenterPanel.add(ConSlugLabel,gc);

        gc.gridx = 1;
        gc.gridy = 3;
        CenterPanel.add(SlugText,gc);

        gc.gridx = 0;
        gc.gridy = 4;
        CenterPanel.add(RetButton,gc);

        gc.gridx = 1;
        gc.gridy = 4;
        CenterPanel.add(AddButton,gc);

    }
    public ContrainteGUI( Solvabilite _Solvencia ){
        this.setTitle("Administrateur : Ajouter Contraintes - Solvencia");
        Solvencia = new Solvabilite( _Solvencia );

        this.getContentPane().setLayout( new BorderLayout() );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setSize(900,500);
        this.setLocationRelativeTo( null );

        initColors();
        initLabels();
        initButtons();
        initTexts();
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
