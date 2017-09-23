import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by todor on 22.09.2017 г..
 */
public class P08_FirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[] numbersArray = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        scan.next("\\w+");
        int count = scan.nextInt();
        String command = scan.next("\\w+");
        
        List<Integer> output = new ArrayList<>();
        if (command.equals("even")) {
            IntStream.of(numbersArray)
                    .filter(i -> i % 2 == 0)
                    .limit(count)
                    .forEach(output::add);
        }
        if (command.equals("odd")) {
            IntStream.of(numbersArray)
                    .filter(i -> i % 2 != 0)
                    .limit(count)
                    .forEach(output::add);
        }
        
        if (output.size() > 0) {
            System.out.println(output.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
