import java.util.Scanner;

/**
 * Created by todor on 18.09.2017 г..
 */
public class P01_ReadInput {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
    
        addText(result, scan.next("\\w+"));
        addText(result, scan.next("\\w+"));
        
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();
        scan.nextLine();
    
        addText(result, scan.nextLine());
        
        int sum = num1 + num2 + num3;
    
        result.append(sum);
        
        System.out.println(result);
    }
    
    private static void addText(StringBuilder result, String text) {
        result.append(text);
        result.append(" ");
    }
}
