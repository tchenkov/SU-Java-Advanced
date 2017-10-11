import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by todor on 10.10.2017 г..
 */
public class P01_SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        Integer[] input = Arrays.stream(br.readLine().split(", "))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
        List<Integer> numList = new ArrayList<>(Arrays.asList(input));
        
        numList.removeIf(n -> n % 2 != 0);
        System.out.println(numList.toString().replaceAll("[\\[\\]]", ""));
        numList.sort((n1, n2) -> n1.compareTo(n2));
        System.out.println(numList.toString().replaceAll("[\\[\\]]", ""));
    }
}
