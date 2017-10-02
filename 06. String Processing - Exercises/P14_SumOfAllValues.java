import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by todor on 1.10.2017 г..
 */
public class P14_SumOfAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String keyString = br.readLine();
        String text = br.readLine();
        
        String keyExpression = "^(?<start>[A-Za-z_]+)\\d(.*\\d)?(?<end>[A-Za-z_]+)$";
        Pattern keyPattern = Pattern.compile(keyExpression);
        Matcher matcher = keyPattern.matcher(keyString);
        
        String startKey;
        String endKey;
        if (matcher.find()){
            startKey = matcher.group("start");
            endKey = matcher.group("end");
        }
        else {
            System.out.println("<p>A key is missing</p>");
            return;
        }
        
        String numExpression = String.format("%s(?<num>.*?)%s", startKey, endKey);
        Pattern numPattern = Pattern.compile(numExpression);
        matcher = numPattern.matcher(text);
        
        double sum = 0;
    
        while (matcher.find()){
            try {
                double num = Double.parseDouble(matcher.group("num"));
                sum += num;
            } catch (Exception e){}
        }
        
    
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(0);
        df.setMaximumFractionDigits(2);
        df.setGroupingUsed(false);
        
        if (sum != 0){
            System.out.println(String.format("<p>The total value is: <em>%s</em></p>", df.format(sum)));
        }
        else {
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        }
    }
}
