package com.algorithme;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Matrice {

    int width , height;
    List< List<Double> > Array ;

    List<Double> setRandomList( int _width){
        List<Double> tmpfeatures = new ArrayList<>();
        for ( int i =0 ; i < _width ; i++){
            tmpfeatures.add(Math.random());
        }
        return tmpfeatures;
    }

    List<Double> InitWithValue( int _width , double _Value){
        List<Double> tmpfeatures = new ArrayList<>();
        for ( int i =0 ; i < _width ; i++){
            tmpfeatures.add(_Value);
        }
        return tmpfeatures;
    }

    List<Double> setIntList( int _width ){
        List<Double> tmpfeatures = new ArrayList<>();
        for ( int i =0 ; i < _width ; i++){
            if( Math.round( Math.random()) == 1 ){
                tmpfeatures.add(Math.random() * 2);
            }
            else {
                tmpfeatures.add(Math.random() * -2);
            }
        }
        return tmpfeatures;
    }

    public int getWidth() {
        return Array.get(0).size();
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return Array.size();
    }
    public List<List<Double>> getArray() {
        return Array;
    }
    public void setArray(List<List<Double>> array) {
        Array = array;
    }

    public Matrice getRow( int _Row ){
        Matrice tmp = new Matrice( 1 , this.getWidth() );
        tmp.add( Array.get( _Row ));
        return tmp;
    }

    public List<Double> getListRow(int _Row){
        return Array.get( _Row );
    }

    public void InitMatrice(){
        for(int i=0; i < height; i++) {
            Array.add( setRandomList( width ) );
        }
    }

    public void add(){
        this.add( setRandomList( width ) );
    }

    public void add( List<Double> ListArray ){
        Array.add( ListArray );
    }

    public void setValue( int x , int y , Double Value ){
        Array.get(y).set( x , Value);
    }

    public Double getValue( int x , int y ){
        return Array.get(y).get(x);
    }

    public Matrice( String FilePath ) throws FileNotFoundException {
        File source = new File( FilePath );
        Scanner sc = new Scanner( source );
        sc.nextLine();

        Array = new ArrayList<>();

        while( sc.hasNextLine() ){
            List<Double> tmp = new ArrayList<>();
            String L = sc.nextLine();
            String[] tab = L.split(" ");
            for ( int i = 1 ; i < tab.length ; i++) {
                int x = Integer.parseInt( tab[i] );
                tmp.add((double) x );
            }
            System.out.println();
            Array.add( tmp );
        }

        System.out.println( Array );
    }

    public Matrice( int _height , int _width ){
        height = _height;
        width = _width;

        Array = new ArrayList<>();

        for(int i=0; i < height; i++) {
            this.add( setRandomList( width ) );
        }
    }

    public Matrice( int _height , int _width , double _Value ){
        height = _height;
        width = _width;

        Array = new ArrayList<>();

        for(int i=0; i < height; i++) {
            this.add( InitWithValue( width , _Value ) );
        }
    }

    public Matrice( int _height , int _width , boolean _ifInt ){
        height = _height;
        width = _width;

        Array = new ArrayList<>();

        for(int i=0; i < height; i++) {
            this.add( setIntList( width ) );
        }
    }

    @Override
    public String toString(){
        String toString = "";
        for (int row = 0; row < this.getHeight(); row++) {
            for (int col = 0; col < this.getWidth() ; col++) {
                BigDecimal bd = new BigDecimal(this.getValue(col , row)).setScale(3, RoundingMode.HALF_EVEN);
                toString += " " + bd.doubleValue() + " |";
            }
            toString += "\n";
        }
        return toString;
    }

}
