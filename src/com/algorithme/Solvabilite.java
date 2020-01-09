package com.algorithme;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class Solvabilite {

    DataSet DataSet;
    List<Double> Weights;
    Double bias;

    List<Double> setRandomList( int _width){
        List<Double> tmpfeatures = new ArrayList<>();
        for ( int i =0 ; i < _width ; i++){
            tmpfeatures.add(Math.random());
        }
        return tmpfeatures;
    }

    void InitVariable(){
        Weights = new ArrayList<>();
            for( int i  = 0 ; i < DataSet.getWidth() ; i++){
                Weights.add(Math.random());
            }
        bias = Math.random();
    }

    //Round Value of List
    List<Integer> ListRound( List<Double> _Array ){
        List<Integer> List = new ArrayList<>();
        int _true = 0, _false = 0;
        for ( int i = 0 ; i < _Array.size() ; i++){
            if( Math.round( _Array.get(i) ) == 1){
                _true++;
            }
            else {
                _false++;
            }
            List.add( (int) Math.round( _Array.get(i) ));
        }
        return List;
    }

    // Preactivation = bias + w1*x1 + w2*x2 + ... + wN*xN
    List<Double> compute_preactivation( Matrice _Features , List<Double> _Weight , Double _Bias ){
        List<Double> preactivation = new ArrayList<>();
        for( int i = 0 ; i < _Features.getHeight() ; i++){
            double tmp = 0.0;
            for ( int j = 0 ; j < _Features.getWidth() ; j++){
                tmp += _Features.getValue( j , i) * _Weight.get(j);
            }
            preactivation.add( tmp + _Bias);
        }
        return preactivation;
    }
        //Override
        double compute_preactivation( List<Double> _Features , List<Double> _Weight , Double _Bias ){
            double tmp = _Bias;
            for( int i = 0 ; i < _Features.size() ; i++){
                tmp += _Features.get(i) * _Weight.get(i);
            }
            return tmp;
        }

    // Activation = 1 / ( 1 + exp( - @preactivation ) )
    List<Double> compute_activation( List<Double> _preactivation ){
        List<Double> activation = new ArrayList<>();
        for( int i = 0 ; i < _preactivation.size() ; i++){
            activation.add( 1 / ( 1 + Math.exp( -_preactivation.get(i) )) );
        }
        return activation;
    }
        //Override
        double compute_activation( double _preactivation ){
            List<Double> activation = new ArrayList<>();
            activation.add( _preactivation );
            return compute_activation( activation ).get(0);
        }

    double derivative_activation( double _preactivation , double _indewFeature){
        return ( _indewFeature * Math.exp( -_preactivation ) ) / Math.pow( 1 + Math.exp( -_preactivation ) , 2);
    }

    // Accuracy | Precision => Comparaison des @predictions et les @targets
    double compute_accuracy( List<Integer> _predictions , List<Integer> _targets ){
        double _true = 0;
        for ( int i = 0 ; i < _predictions.size() ; i++ ){
            if(_predictions.get(i).equals(_targets.get(i))){
                _true++;
            }
        }
        System.out.println( "\n Summary => True = "+ (int)_true );
        return (_true/_predictions.size())*100;
    }

    // Cost | Erreur
    double cost( List<Integer> _predictions , List<Integer> _targets ){
        List<Double> tmp = new ArrayList<>();
        double cost = 0;
        for ( int i = 0 ; i < _predictions.size() ; i++){
            tmp.add( Math.pow(_predictions.get(i) - _targets.get(i) , 2) );
            cost += Math.pow(_predictions.get(i) - _targets.get(i) , 2);
        }
        return (cost/_predictions.size()) * 100;
    }

    List<Integer> predict(Matrice _features , List<Double> _weight , Double _bias ){
        List<Double> z = compute_preactivation( _features , _weight , _bias );
        List<Double> y = compute_activation( z );
        System.out.println( " y = " + y );
        return ListRound( y );
    }

    // Update Weight of Gradient
    List<Double> UpdateWeightOfGradient(List<Double> Weight_gradient , double _Sigmoid , int _target , Matrice _feature ){
        double Init = (_Sigmoid - _target ) ;
        List<Double> tmp = new ArrayList<>();
        for( int i = 0 ; i <  _feature.getWidth() ; i++){
            tmp.add( Init * _feature.getValue(i , 0)  * derivative_activation( _Sigmoid , _feature.getValue(i , 0) ) );
        }

        List<Double> Result = new ArrayList<>();
        for ( int i = 0 ; i < tmp.size() ; i++ ){
            Result.add( Weight_gradient.get(i) + tmp.get(i) );
        }

        return Result;
    }

    // Update Variable
    List<Double> UpdateWeights( double _learning_rate , List<Double> _Weight_Gradient ){
        List<Double> tmp = new ArrayList<>();
        for ( int i = 0 ; i < _Weight_Gradient.size() ; i++){
            tmp.add( _Weight_Gradient.get(i) * _learning_rate );
        }
        List<Double> Result = new ArrayList<>();
        for ( int i = 0 ; i < _Weight_Gradient.size() ; i++){
            Result.add( Weights.get(i) - tmp.get(i) );
        }
        return Result;
    }

    void train(){
        Matrice _features = DataSet.getFeatures();
        List<Integer> _targets  = DataSet.getTargets();

        System.out.println( "\n Features : \n" + _features.toString() );

        //Initialiser l'epochs
        int epochs = 100;

        //Initialiser le pas
        double learning_rate = 0.1;

        //Calculer la précision du modèle
        List<Integer> predictions = predict( _features , Weights , bias );
        System.out.println( " Prediction = " + predictions );
        System.out.println( " Accurancy = " + (int) compute_accuracy( predictions , _targets) + "%");

        boolean error;
        do {
            System.out.println("************************************\n\tNouveau test\n************************************");
            error = true;
            for (int i = 0; error && (int) compute_accuracy(predict(_features, Weights, bias), _targets) < 70; i++) {

                double LastAccurancy = (int) compute_accuracy(predictions, _targets);

                System.out.println(" accurancy = " + (int) compute_accuracy(predict(_features, Weights, bias), _targets) + " %");
                //Initialiser le gradient
                List<Double> Weight_gradient = new ArrayList<>();
                // Initialiser la Weight_gradient a 0
                for (int j = 0; j < _features.getWidth(); j++) {
                    Weight_gradient.add(0.0);
                }

                double Bias_gradient = 0;

                for (int j = 0; j < _features.getHeight(); j++) {
                    // Compute prediction
                    double z = compute_preactivation(_features.getListRow(j), Weights, bias);
                    double y = compute_activation(z);
                    // Update gradients
                    Weight_gradient = UpdateWeightOfGradient(Weight_gradient, y, _targets.get(j), _features.getRow(j));
                    // pour le _Bias_gradient le x0 = 1
                    Bias_gradient += (y - _targets.get(j)) * derivative_activation(z, 1);
                }

                // Update Variable
                Weights = UpdateWeights(learning_rate, Weight_gradient);
                bias = bias - learning_rate * Bias_gradient;

                // l'objectif du if et de tracer l'évolution de l'algorithme
                if (i % 10 == 0) {
                    System.out.println("\t Cost = " + cost(predictions, _targets));
                    System.out.println(" Weight = " + Weights);
                    System.out.println(" Bias = " + bias);
                    System.out.println("\t\tWeight Gradient = " + Weight_gradient);
                    System.out.println("\t\tBias Gradient = " + Bias_gradient);
                }

                if (LastAccurancy > (int) compute_accuracy(predict(_features, Weights, bias), _targets)
                        || (i > 50 && (int)compute_accuracy(predict(_features, Weights, bias) , _targets) < 50 )) {
                    System.out.println(" ERREUR !! ");
                    error = false;
                }

                if (i == 100) {
                    break;
                }
            }
            predictions = predict(_features, Weights, bias);
            System.out.println(" Accurancy = " + (int) compute_accuracy(predictions, _targets) + "%");
            System.out.println("\t Cost = " + (int) cost(predictions, _targets) + "%");
        }while ( !error );

        System.out.println("\nWeight = \n" + Weights );
        System.out.println("Bias = " + bias);

    }

    public boolean Solvencia( List<Double> _Data ){
        if( _Data.size() != DataSet.getWidth() ){
            System.err.println(" Impossible de calculer la solvabilité de ce client !");
            return false;
        }
        else{
            double z = compute_preactivation( _Data , Weights , bias );
            double y = compute_activation( z );
            if( y > 0.5 ){
                return true;
            }else {
                return false;
            }
        }
    }

    public Solvabilite() throws IOException {
        System.out.println("Initialisation de la DataSet");
                FileReader input = new FileReader("src/com/algorithme/DataSet.txt");
                LineNumberReader count = new LineNumberReader(input);
                        while (count.skip(Long.MAX_VALUE) > 0) {}
            DataSet = new DataSet( count.getLineNumber() , 11);
            System.out.println( " Features + Targets : \n" + DataSet );
        System.out.println("Fin de l'initialisation de la DataSet ");
        System.out.println("*************************************");

        System.out.print("Initialisation des variables ... ");
            InitVariable();
                System.out.println( " Bias : " + bias);
                System.out.println( " Weights : \n" + Weights);
        System.out.println("Fin de l'initialisation des variables");
        System.out.println("*************************************");

        /*
        System.out.print("Calcule de la Pré-Activation ... ");
        List<Double> preactivation = compute_preactivation( DataSet.getFeatures() , Weights , bias);
        System.out.println( "\n La matrice de Pré-Activation : \n" + preactivation);
        System.out.println("Fin du calcule de la Pré-Activation");
        System.out.println("*************************************");

        System.out.print("Calcule de l'Activation ... ");
        List<Double> activation = compute_activation( preactivation );
        System.out.println( "\n La matrice d'Activation : \n" + activation);
        System.out.println( "\n Les targets : \n" + DataSet.getTargets());
        System.out.println("Fin du calcule de l'Activation");
        System.out.println("*************************************");
         */

        System.out.print("Début de l'entrainement ... ");
        train();
        System.out.println("Fin de l'entrainement");
        System.out.println("*************************************");

        System.out.print("Début du test ... ");
            List<Double> Data = new ArrayList<>();
                for ( int i = 0 ; i < DataSet.getWidth() ; i++){
                    Data.add( (double)Math.round( Math.random() ) );
                }
                System.out.println(" Feature de test : " + Data);
            boolean result = Solvencia( Data );
                if( result )
                    System.out.println("Le client est : Solvable ");
                else
                    System.out.println("Le client est : Non Solvable ");
        System.out.println("Fin du test");
        System.out.println("*************************************");

    }

}
