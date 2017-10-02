import java.util.Scanner;

/**
 * Created by todor on 29.09.2017 г..
 */
public class P01_CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    
        StringBuilder text = new StringBuilder();
        text.append(scan.nextLine().toLowerCase());
        String target = scan.nextLine().toLowerCase();
        int counter = 0;
        int startIndex = 0;
        while (text.toString().contains(target)){
            counter++;
            startIndex = text.indexOf(target);
            text = text.delete(0, startIndex + 1);
        }
    
        System.out.println(counter);
    }
}
