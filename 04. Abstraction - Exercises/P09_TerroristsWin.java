import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by todor on 26.09.2017 г..
 */
public class P09_TerroristsWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        StringBuilder text = new StringBuilder(scan.nextLine());
        
        String expression = "(?<bomb>\\|.*?\\|)";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            String bomb = matcher.group("bomb");
            int bombPower = bomb.substring(1, bomb.length() - 1).chars().sum() % 10;
            int start = Math.max(matcher.start() - bombPower, 0);
            int end = Math.min(matcher.end() + bombPower, text.length());
            int repeat = end - start;
            String replacer = stringRepeater(".", repeat);
            text.replace(start, end, replacer);
    
        }
        
        System.out.println(text);
    }
    
    private static String stringRepeater(String s, int repeat) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < repeat -1; i++) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}

