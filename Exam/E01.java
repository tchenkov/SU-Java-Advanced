import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Joto on 22.10.2017 г..
 */
public class E01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numbersStr = br.readLine().split(",\\s+");
        int[] numbers = new int[numbersStr.length];
        for (int i = 0; i < numbersStr.length; i++) {
            numbers[i] = Short.parseShort(numbersStr[i]);
        }


        boolean isChanged = true;
        while (isChanged){
            isChanged = false;

            for (int i = 0; i < numbers.length - 1; i++) {
//                short upperNum = numbers[i];
//                short lowerNum = numbers[i+1];

                int newUpper = numbers[i] & numbers[i+1];
                int newLower = numbers[i] | numbers[i+1];

                if (numbers[i+1] != newLower){
                    isChanged = true;
                    numbers[i] = newUpper;
                    numbers[i+1] = newLower;
                }
            }
        }

        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\]]", ""));
    }
}
