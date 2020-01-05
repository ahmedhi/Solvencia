package com.algorithme;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class DataSet {
    //Features = x1 , x2 , x3 ...
    Matrice features ;

    //Target = 0 | 1 ( solvable ou non solvable )
    List<Integer> targets = new ArrayList<>();

    //Taille de la DataSet ( sans prendre ne consideration les targets
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
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    //Initialisation des features
    void InitFeatures(){
        System.out.println("Initialisation des features ...");
        features = new Matrice( height , width , true);
    }

    //Initialisation des targets
    void InitTargets(){
        for( int i = 0 ; i < height ; i++){
            targets.add((int) Math.round( Math.random() ));
        }
    }

     @Override
     public String toString(){
         String toString = "";
         for (int row = 0; row < height; row++) {
             for (int col = 0; col < width ; col++) {
                 //BigDecimal bd = new BigDecimal(features.getValue(col , row)).setScale(3, RoundingMode.HALF_EVEN);
                 //toString += " " + bd.doubleValue() + " |";
                 toString += " " + features.getValue( col , row);
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
    public DataSet( int _height , int _width){
        height = _height;
        width = _width;
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
