import java.util.Scanner;

/**
 * Created by todor on 19.09.2017 г..
 */
public class P04_Greeting {
    
    private final static String ASTERISKS = "*****";
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String firstName = scan.nextLine();
        String lastName = scan.nextLine();
        
        if (firstName.isEmpty()){
            firstName = ASTERISKS;
        }
        
        if (lastName.isEmpty()){
            lastName = ASTERISKS;
        }
    
        System.out.printf("Hello, %s %s!%n", firstName, lastName);
    }
}
