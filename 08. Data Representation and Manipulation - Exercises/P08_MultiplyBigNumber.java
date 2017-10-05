import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by todor on 4.10.2017 г..
 */
public class P08_MultiplyBigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String bigNum = br.readLine().replaceFirst("^0+(?!$)", "");
        
        
        int num = Integer.parseInt(br.readLine());
        
        StringBuilder result = new StringBuilder();
        int add = 0;
        for (int i = bigNum.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(String.valueOf(bigNum.charAt(i)));
            int product = digit * num + add;
            result.insert(0, product % 10);
            add = product / 10;
        }
        
        if (add > 0){
            result.insert(0, add);
        }
    
        System.out.println(result.toString().replaceFirst("^0+(?!$)", ""));
    }
}
