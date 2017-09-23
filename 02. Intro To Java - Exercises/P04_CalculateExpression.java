import java.util.Scanner;

/**
 * Created by todor on 20.09.2017 г..
 */
public class P04_CalculateExpression {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        double numA = scan.nextDouble();
        double numB = scan.nextDouble();
        double numC = scan.nextDouble();
        
        double f1Power = (numA + numB + numC) / Math.sqrt(numC);
        
        double f1 = Math.pow ((numA * numA + numB * numB) / (numA * numA - numB * numB), f1Power);
        
        double f2 = Math.pow((numA * numA + numB * numB - numC * numC * numC), numA - numB);
        
        double result = Math.abs(((numA + numB + numC)/3) - ((f1 + f2) / 2));
        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f%n", f1, f2, result);
    }
}
