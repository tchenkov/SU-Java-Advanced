import java.util.Scanner;

/**
 * Created by todor on 19.09.2017 г..
 */
public class P05_TransportPrice {
    
    private final static double TAXI_INITIAL_TAX = 0.70;
    private final static double TAXI_DAYTIME_TAX = 0.79;
    private final static double TAXI_NIGHTTIME_TAX = 0.90;
    
    private final static double BUS_TAX = 0.09;
    private final static int MIN_BUS_DISTANCE = 20;
    
    private final static double TRAIN_TAX = 0.06;
    private final static int MIN_TRAIN_DISTANCE = 100;
    
    private final static String DAY_STATE_DAY = "day";
    private final static String DAY_STATE_NIGHT = "night";
    
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        double distance = Double.parseDouble(scan.nextLine());
        String dayState = scan.nextLine().toLowerCase();
        
        double travelPrice = getTravelPrice(distance, dayState);
    
        System.out.printf("%.2f", travelPrice);
    }
    
    private static double getTravelPrice(double distance, String dayState) {
        if (distance < MIN_BUS_DISTANCE){
            if (dayState.equals(DAY_STATE_DAY)){
                return calcPrice(distance, TAXI_DAYTIME_TAX, TAXI_INITIAL_TAX);
            }
            
            if (dayState.equals(DAY_STATE_NIGHT)){
                return calcPrice(distance, TAXI_NIGHTTIME_TAX, TAXI_INITIAL_TAX);
            }
            return 0; // Day state error
        }
        
        if (distance < MIN_TRAIN_DISTANCE){
            return calcPrice(distance, BUS_TAX);
        }
        
        return calcPrice(distance, TRAIN_TAX);
    }
    
    private static double calcPrice(double distance, double tax) {
        return calcPrice(distance, tax, 0);
    }
    
    private static double calcPrice(double distance, double tax, double initialTax) {
        return distance * tax + initialTax;
    }
}
