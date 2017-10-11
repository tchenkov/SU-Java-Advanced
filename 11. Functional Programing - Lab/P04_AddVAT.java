import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

/**
 * Created by todor on 10.10.2017 г..
 */
public class P04_AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        double[] numbers = Arrays.stream(br.readLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();
    
        UnaryOperator<Double> addVat = num -> num * 1.2;
    
        System.out.println("Prices with VAT:");
        for (double n: numbers) {
            System.out.println(String.format("%.2f", addVat.apply(n)).replaceAll("\\.", ","));
        }
    }
}
