import java.util.Scanner;

/**
 * Created by todor on 20.09.2017 г..
 */
public class P03_FormattingNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int a =  scan.nextInt();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
    
        String intToBin = String.format("%10s", Integer.toBinaryString(a)).replace(" ", "0");
        System.out.printf("|%-10X|%10s|%10.2f|%-10.3f|", a, intToBin, b, c);
    }
}
