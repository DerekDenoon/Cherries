/*
Author: Denoon, Derek
Date: September 12, 2021
Assignment: Cherries
 */

// imports for rounding to 3 decimal places
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Cherries {
    public static void main(String[] args) {
        // variables for storing the average number of turns
        double total = 0;
        double avg = 0;
        // for loop to run simulation 10000 times
        for (int i = 0;i < 10000;i++){
            int cherries = 0;
            int turns = 0;
            // while cherries is less than 10 it runs the spinner
            while (cherries < 10 ) {
                // generates a random number between 1 and 7
                int random = (int) ((Math.random() * 7) + 1);
                // adds the results of passing that random number as an arg in to the cherrySpinner function
                cherries += cherrySpinner(random, cherries);
                // adds one to the turns
                turns++;
                if(cherries < 0){
                    // if after the spinner result is applied cherries is negative, it reverses it
                    cherries = 0;
                }
            }
            total += turns;
        }

        avg = total/10000;
        // outputs the average after rounding to 3 decimal places
        DecimalFormat df = new DecimalFormat("#.000");
        df.setRoundingMode(RoundingMode.CEILING);
        System.out.println(df.format(avg));
    }

    public static int cherrySpinner(int x,int cherries){
        // takes in the number of cherries and returns the number that should be added to cherries based on the randomly
        // generated number
        return switch (x) {
            case 1,2,3,4 -> x;
            case 5, 6 -> -2;
            case 7 -> (-cherries);
            default -> throw new IllegalStateException("Unexpected value: " + x);
        };
    }


}

