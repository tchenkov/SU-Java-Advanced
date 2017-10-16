import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by todor on 15.10.2017 г..
 */
public class P10_LittleJohn {
    private static final String SMALL_ARROW = ">----->";
    private static final String MEDIUM_ARROW = ">>----->";
    private static final String BIG_ARROW = ">>>----->>";
    
    public static void main(String[] args) throws IOException {
        
        int arrowsStringToInt = Integer.parseInt(getArrowsString());
    
        StringBuilder arrowsNumToBin = new StringBuilder();
        arrowsNumToBin.append(Integer.toString(arrowsStringToInt, 2));
        arrowsNumToBin.reverse();
        arrowsNumToBin.insert(0, Integer.toString(arrowsStringToInt, 2));
    
        int output = Integer.parseInt(arrowsNumToBin.toString(), 2);
        System.out.println(output);
    }
    
    private static String getArrowsString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = "(?<arrow>>----->|>>----->|>>>----->>)";
        Pattern pattern = Pattern.compile(expression);
        
        int smallArrows = 0;
        int mediumArrows = 0;
        int bigArrows = 0;
        
        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            Matcher matcher = pattern.matcher(input);
            
            while (matcher.find()) {
                switch (matcher.group("arrow")) {
                    case SMALL_ARROW:
                        smallArrows++;
                        break;
                    case MEDIUM_ARROW:
                        mediumArrows++;
                        break;
                    case BIG_ARROW:
                        bigArrows++;
                }
            }
        }
        
        return  "" + smallArrows + mediumArrows + bigArrows;
    }
}
