import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by todor on 19.09.2017 г..
 */
public class P07_ProductOfNumbersNtoM {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    
        BigInteger startNum = scan.nextBigInteger();
        BigInteger endNum = scan.nextBigInteger();
        BigInteger product = BigInteger.ONE;
        
        if (startNum.compareTo(endNum) == 1){
            System.out.println("error");
            return;
        }
        
        String outputText = String.format("product[%d..%d] = ", startNum, endNum);
        
        do {
            product = product.multiply(startNum);
            startNum = startNum.add(BigInteger.ONE);
        } while (startNum.compareTo(endNum) != 1);
    
        System.out.println(outputText + product);
    }
}
