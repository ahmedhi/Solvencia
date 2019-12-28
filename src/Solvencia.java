import com.interfaces.*;

import java.io.File;

public class Solvencia {

    public static void main( String[] args ){

        System.out.println("Solvencia");

        System.out.println( new File("Solvencia.png").getAbsolutePath() );

        indexGUI index = new indexGUI();

    }

}
