import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by todor on 27.09.2017 г..
 */
public class P10_PlusRemove {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    
        List<String> strings = new ArrayList<>();
        
        String command = scan.nextLine();
        
        while (!command.equals("END")){
            strings.add(command);
    
            command = scan.nextLine();
        }
        
        boolean[][] removeMap = new boolean[strings.size()][];
        
        removeMap = mapCharsToRemove(strings, removeMap);
        
        strings = removeMappedChars(strings, removeMap);
        
        strings.forEach(System.out::println);
    }
    
    private static List<String> removeMappedChars(List<String> strings, boolean[][] removeMap) {
        for (int i = removeMap.length - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder(strings.get(i));
            for (int j = removeMap[i].length - 1; j >= 0; j--) {
                if (removeMap[i][j]){
                    sb.replace(j, j +1, "");
                }
            }
            strings.set(i, sb.toString());
        }
        
        return strings;
    }
    
    private static boolean[][] mapCharsToRemove(List<String> strings, boolean[][] removeMap) {
        removeMap[0] = new boolean[strings.get(0).length()];
        removeMap[1] = new boolean[strings.get(1).length()];
        for (int i = 1; i < strings.size() - 1; i++) {
            
            removeMap[i + 1] = new boolean[strings.get(i + 1).length()];
            
            for (int j = 0; j < strings.get(i).length() - 2; j++) {
                try {
                    char ch1 = Character.toLowerCase(strings.get(i).charAt(j));
                    char ch2 = Character.toLowerCase(strings.get(i).charAt(j + 1));
                    char ch3 = Character.toLowerCase(strings.get(i).charAt(j + 2));
                    char ch4 = Character.toLowerCase(strings.get(i - 1).charAt(j + 1));
                    char ch5 = Character.toLowerCase(strings.get(i + 1).charAt(j + 1));
                    boolean isPlusShape = ch1 == ch2 && ch1 == ch3 &&ch1 == ch4 &&ch1 == ch5;
    
                    if (isPlusShape){
                        removeMap[i][j] = true;
                        removeMap[i][j + 1] = true;
                        removeMap[i][j + 2] = true;
                        removeMap[i - 1][j + 1] = true;
                        removeMap[i + 1][j + 1] = true;
                    }
    
                } catch (Exception e) {}
            }
        }
        
        return removeMap;
    }
}
