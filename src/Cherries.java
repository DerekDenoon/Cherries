import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Cherries {
    public static void main(String[] args) {
        double total = 0;
        double avg = 0;
        for (int i = 0;i < 10000;i++){
            int cherries = 0;
            int turns = 0;
            while (cherries < 10 ) {
                int random = (int) ((Math.random() * 7) + 1);
                cherries += cherrySpinner(random, cherries);
                turns++;
                if(cherries < 0){
                    cherries = cherries - cherrySpinner(random, cherries);
                }
            }
            total += turns;
        }


        avg = total/10000;
        DecimalFormat df = new DecimalFormat("#.000");
        df.setRoundingMode(RoundingMode.CEILING);
        System.out.println(df.format(avg));
    }


    public static int cherrySpinner(int x,int cherries){
        return switch (x) {
            case 1 -> 1;
            case 2 -> 2;
            case 3 -> 3;
            case 4 -> 4;
            case 5, 6 -> -2;
            case 7 -> (-cherries);
            default -> throw new IllegalStateException("Unexpected value: " + x);
        };
    }
}

