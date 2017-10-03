import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by todor on 3.10.2017 г..
 */
public class P04_RecursiveFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        
        int factorial = calcFactorial(num);
    
        System.out.println(factorial);
    }
    
    private static int calcFactorial(int num) {
        if (num < 1){
            return 1;
        }
        
        return num * calcFactorial(num - 1);
    }
}
