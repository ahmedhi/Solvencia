package com.interfaces;

import javax.swing.*;

public class indexGUI {

    JFrame index;

    public indexGUI( String JFramName ){
        index = new JFrame(JFramName);

        index.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        index.setSize(1800,900);
        index.setLocationRelativeTo( null );
        index.setVisible( true );
    }

}
