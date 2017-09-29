import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by todor on 28.09.2017 г..
 */
public class P01_StudentsResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String[] input = scan.nextLine().split(" - ");
        
        String name = input[0];
        double[] grades = Arrays.stream(input[1].split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        double averageGrade = Arrays.stream(grades).average().getAsDouble();
    
        System.out.println(
                String.format("%-10s|%7s|%7s|%7s|%7s|",
                                "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));
        System.out.println(
                String.format("%-10s|%7.2f|%7.2f|%7.2f|%7.4f|",
                                name, grades[0], grades[1], grades[2], averageGrade));
    }
}
