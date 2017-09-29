import java.util.Scanner;

/**
 * Created by todor on 28.09.2017 г..
 */
public class P02_ParseURL {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String[] input = scan.nextLine().split("://");
        
        if (input.length != 2){
            System.out.println("Invalid URL");
            return;
        }
        
        String protocol = input[0];
        String server = input[1].substring(0, input[1].indexOf('/'));
        String resources = input[1].substring(input[1].indexOf('/') + 1);
    
        System.out.printf("Protocol = %s%n", protocol);
        System.out.printf("Server = %s%n", server);
        System.out.printf("Resources = %s%n", resources);
    }
}
