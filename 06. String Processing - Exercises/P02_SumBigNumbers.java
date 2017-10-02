import java.util.Scanner;

/**
 * Created by todor on 29.09.2017 г..
 */
public class P02_SumBigNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        StringBuilder num1 = new StringBuilder();
        num1.append(scan.nextLine().replaceAll("^0+(?=\\d)", ""));
        StringBuilder num2 = new StringBuilder();
        num2.append(scan.nextLine().replaceAll("^0+(?=\\d)", ""));
        
        if (num1.length() < num2.length()){
            int diff = num2.length() - num1.length();
            while (diff > 0){
                num1.insert(0, "0");
                diff--;
            }
        }
        
        if (num1.length() > num2.length()){
            int diff = num1.length() - num2.length();
            while (diff > 0){
                num2.insert(0, "0");
                diff--;
            }
        }
        
        
        StringBuilder result = new StringBuilder();
        int add = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int digit1 = Integer.parseInt(num1.substring(i, i+1));
            int digit2 = Integer.parseInt(num2.substring(i, i+1));
            int remainder = (digit1 + digit2 + add) % 10;
            result.append(remainder);
            add = (digit1 + digit2 + add) / 10;
        }
        if (add > 0){
            result.append(add);
        }
        
        result.reverse();
    
        System.out.println(result);
    }
}
