import java.util.Scanner;

/**
 * Created by todor on 22.09.2017 г..
 */
public class P07_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String string1 = scan.next("\\w+");
        String string2 = scan.next("\\w+");
        scan.nextLine();
    
        String shorterString = string1.length() < string2.length() ?
                string1 :
                string2;
        String longerString = string1.length() < string2.length() ?
                string2 :
                string1;
    
        int output = 0;
        int i = 0;
        while (i < shorterString.length()){
            output += shorterString.charAt(i) * longerString.charAt(i);
            i++;
        }
        
        while (i < longerString.length()){
            output += longerString.charAt(i);
            i++;
        }
    
        System.out.println(output);
    }
}
