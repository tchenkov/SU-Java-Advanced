import java.util.Scanner;
import java.util.stream.DoubleStream;

/**
 * Created by todor on 18.09.2017 г..
 */
public class P02_AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        double num1 = scan.nextDouble();
        double num2 = scan.nextDouble();
        double num3 = scan.nextDouble();
        double[] nums = {num1, num2, num3};
        
        double average = DoubleStream.of(nums).average().getAsDouble();
    
        System.out.printf("%.2f%n", average);
    }
}
