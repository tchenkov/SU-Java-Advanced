import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by todor on 18.09.2017 г..
 */
public class P03_EuroTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    
        double wurstQuantity = scan.nextDouble();
        double pricePerKilo = 1.20;
        BigDecimal price = new BigDecimal(wurstQuantity * pricePerKilo);
        BigDecimal exchangeRate = new BigDecimal("4210500000000");
        
        BigDecimal result = price.multiply(exchangeRate);
        System.out.printf("%.2f marks", result);
    }
}
