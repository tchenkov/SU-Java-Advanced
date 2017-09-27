import java.util.*;

/**
 * Created by todor on 24.09.2017 г..
 */
public class P02_EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int namesCount = Integer.parseInt(scan.nextLine());
        
        String[] names = getNames(namesCount, scan);
    
        int[] encryptedNames = new int[namesCount];
    
        for (int i = 0; i < namesCount; i++) {
            encryptedNames[i] = encryptName(names[i]);
        }
    
        Arrays.sort(encryptedNames);
    
        for (int i = 0; i < encryptedNames.length; i++) {
            System.out.println(encryptedNames[i]);
        }
    }
    
    private static int encryptName(String name) {
        int result = 0;
        List<Character> vowels = new ArrayList();
        Collections.addAll(vowels, 'a', 'o', 'u', 'e', 'i', 'A', 'O', 'U', 'E', 'I');
        for (char ch: name.toCharArray()) {
            result += vowels.contains(ch) ?
                    ch * name.length() :
                    ch / name.length();
        }
        
        return result;
    }
    
    private static String[] getNames(int namesCount, Scanner scan) {
        String[] names = new String[namesCount];
        for (int i = 0; i < namesCount; i++) {
            names[i] = scan.nextLine();
        }
        
        return names;
    }
}
