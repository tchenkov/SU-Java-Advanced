import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Joto on 22.10.2017 г..
 */
public class E04 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder text = new StringBuilder();
        text.append(br.readLine());

        String expression = br.readLine();

        while (!expression.equals("Print")){
            expression = expression.replaceAll("[\\<\\(\\[\\{\\\\\\^\\-\\=\\$\\!\\|\\]\\}\\)‌​\\?\\*\\+\\.\\>)]", "\\\\$0");
            expression = expression.replaceAll("%", "[^\\\\s+]*");
            Pattern pattern = Pattern.compile(expression);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()){
                StringBuilder replacer = new StringBuilder();
                replacer.append(matcher.group());
                replacer.reverse();
                int start = text.indexOf(matcher.group());
                int end = start + matcher.group().length();
                text.replace(start, end, replacer.toString());
            }

            expression = br.readLine();
        }

        System.out.println(text);
    }
}
