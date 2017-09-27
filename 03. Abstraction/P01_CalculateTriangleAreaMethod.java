import java.util.Scanner;

/**
 * Created by todor on 24.09.2017 г..
 */
public class P01_CalculateTriangleAreaMethod {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        double base = scan.nextDouble();
        double height = scan.nextDouble();
        double triangleArea = calcTriangleArea(base, height);
        System.out.printf("Area = %.2f%n", triangleArea);
    }
    
    private static double calcTriangleArea(double base, double height) {
        return (base * height) / 2;
    }
}
