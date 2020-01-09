package com.algorithme;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataSet {
    // Features = x1 , x2 , x3 ...
    Matrice features ;

    // Target = 0 | 1 ( solvable ou non solvable )
    List<Integer> targets ;

    File Source ;

    //Taille de la DataSet ( sans prendre en consideration les targets )
    int height , width;

    // Getter and Setter
    public List<Integer> getTargets() {
        return targets;
    }

    public Matrice getFeatures() {
        return features;
    }
    public void setFeatures(Matrice features) {
        this.features = features;
    }
    public void setTargets(List<Integer> targets) {
        this.targets = targets;
    }
    public int getHeight() {
        return features.getHeight();
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWidth() {
        return features.getWidth();
    }
    public void setWidth(int width) {
        this.width = width;
    }

    void InitFile( String PathFile ){
        Source = new File( PathFile );
    }

    //Initialisation des features
    void InitFeatures() throws FileNotFoundException {
        System.out.println("Initialisation des features ...");
        features = new Matrice( Source.getPath());
        height = features.getHeight();
        width = features.getWidth();
    }

    //Initialisation des targets
    void InitTargets() throws FileNotFoundException {
        Scanner sc = new Scanner( Source );
        sc.nextLine();

        targets = new ArrayList<>();

        while( sc.hasNextLine() ){
            String L = sc.nextLine();
            String[] tab = L.split(" ");
            targets.add( Integer.parseInt( tab[0]) );
        }
    }

     @Override
     public String toString(){
         String toString = "";
         for (int row = 0; row < height; row++) {
             for (int col = 0; col < width ; col++) {
                 BigDecimal bd = new BigDecimal(features.getValue(col , row)).setScale(3, RoundingMode.HALF_EVEN);
                 toString += " " + bd.doubleValue() + " |";
             }
             String Target;
             if( targets.get( row ) == 1){
                 Target = "Solvable";
             }
             else {
                 Target = "Non Solvable";
             }
             toString += "| "+ Target + " ||\n";
         }
         return toString;
     }

    /**
     * Creation de la DataSet
     */
    public DataSet( int _height , int _width) throws FileNotFoundException {
        height = _height;
        width = _width;
        InitFile( "src/com/algorithme/DataSet.txt" );
        InitTargets();
        InitFeatures();
        System.out.println("Création de la DataSet");
    }

}

/**
 *
 *
 *
 *
 */
