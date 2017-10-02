import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by todor on 2.10.2017 г..
 */
public class P15_ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String text = br.readLine();
        
        String expression = "(?<=^|[ \\/(\\)\\\\])[A-Za-z]\\w{2,24}(?=[ \\/(\\)\\\\]|$)";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);
        
        int bestIndex = -1;
        int bestLength = 0;
        List<String> usernames = new ArrayList<>();
        int i = 0;
        while (matcher.find()){
            usernames.add(matcher.group());
            
            try {
                int username1 = usernames.get(i - 1).length();
                int username2 = usernames.get(i).length();
                int lengthSum = username1 + username2;
                if (lengthSum > bestLength){
                    bestLength = lengthSum;
                    bestIndex = i - 1;
                }
            } catch (Exception e) {}
            
            i++;
        }
        
        if (bestIndex >= 0){
            System.out.println(usernames.get(bestIndex));
            System.out.println(usernames.get(bestIndex + 1));
        }
    }
}
