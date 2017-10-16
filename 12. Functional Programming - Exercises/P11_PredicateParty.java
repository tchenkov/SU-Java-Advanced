import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * Created by todor on 13.10.2017 г..
 */
public class P11_PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        LinkedList<String> guestList = new LinkedList<>(Arrays.asList(br.readLine().split("\\s+")));
        
        String command = br.readLine();
        
        
        while (!command.equals("Party!")) {
            String[] commandArr = command.split("\\s+");
            String action = commandArr[0];
            String filter = commandArr[1];
            String value = commandArr[2];
            
            Predicate<String> isEligible = getTest(value, filter);
            
            switch (action) {
                case "Double":
                    doubleGuests(guestList, isEligible);
                    break;
                case "Remove":
                    removeGuests(guestList, isEligible);
            }
            command = br.readLine();
        }
    
        System.out.println(
                guestList.size() > 0 ?
                        String.format("%s are going to the party!", guestList.toString().replaceAll("[\\[\\]]", "")) :
                        "Nobody is going to the party!"
        );
    }
    
    private static void removeGuests(LinkedList<String> guestList, Predicate<String> isEligible) {
        for (int i = guestList.size() - 1; i >= 0; i--) {
            String guest = guestList.get(i);
            if (isEligible.test(guest)) {
                guestList.remove(i);
            }
        }
    }
    
    private static void doubleGuests(LinkedList<String> guestList, Predicate<String> isEligible) {
        for (int i = guestList.size() - 1; i >= 0; i--) {
            String guest = guestList.get(i);
            if (isEligible.test(guest)) {
                guestList.add(i, guest);
            }
        }
    }
    
    private static Predicate<String> getTest(String value, String filter) {
        switch (filter) {
            case "StartsWith":
                return s -> s.startsWith(value);
            case "EndsWith":
                return s -> s.endsWith(value);
            case "Length":
                return s -> s.length() == Integer.parseInt(value);
        }
        
        return null;
    }
}
