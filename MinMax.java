import java.util.Scanner;
import java.util.ArrayList;
public class MinMax {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No command line arguments provided.");
            return;
        }

        ArrayList<Double> argarr = new ArrayList<Double>();
        for (int i = 0; i < args.length; i++){
            argarr.add(Double.parseDouble(args[i]));
        }
        System.out.println("Minimum element (CLI): " + findMinimum(argarr));
        System.out.println("Maximum element (CLI): " + findMaximum(argarr));

        System.out.println("Enter numbers (non-numeric input to stop):");
        ArrayList<Double> arr = new ArrayList<Double>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextDouble()){
            arr.add(sc.nextDouble());
        }
        System.out.println("Minimum element (Scanner): " + findMinimum(arr));
        System.out.println("Maximum element (Scanner): " + findMaximum(arr));
    }

    public static double findMinimum(ArrayList<Double> arr){
        double min = arr.get(0);
        for (int i = 0; i < arr.size(); i++){
            if (arr.get(i) < min) min = arr.get(i);
        }
        return min;
    }

    public static double findMaximum(ArrayList<Double> arr){
        double max = arr.get(0);
        for (int i = 0; i < arr.size(); i++){
            if (arr.get(i) > max) max = arr.get(i);
        }
        return max;
    }
}