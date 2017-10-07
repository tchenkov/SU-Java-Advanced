import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by todor on 7.10.2017 г..
 */
public class P03_MathPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        Queue<String> kids = new ArrayDeque<>();
    
        kids.addAll(Arrays.asList(br.readLine().split("\\s+")));
    
        int n = Integer.parseInt(br.readLine());
        int counter = 0;
        while (kids.size() > 1){
            counter++;
            for (int i = 1; i < n; i++) {
                kids.offer(kids.poll());
            }
            if (isPrime(counter)){
                System.out.printf("Prime %s%n",kids.peek());
            }
            else {
                System.out.printf("Removed %s%n",kids.poll());
            }
        }
    
        System.out.printf("Last is %s%n",kids.poll());
    }
    
    private static boolean isPrime(int number) {
        if (number < 2){
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(number); i++)
        {
            if (number % i == 0)
            {
                return false;
            }
        }
        
        return true;
    }
}
