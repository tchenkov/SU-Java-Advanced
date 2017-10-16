import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * Created by todor on 13.10.2017 г..
 */
public class P12_ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        LinkedList<String> guestList = new LinkedList<>(Arrays.asList(br.readLine().split("\\s+")));
    
        LinkedList<String> filters = new LinkedList<>();
        
        String command = br.readLine();
    
    
        while (!command.equals("Print")) {
            String[] commandArr = command.split(";");
            String instruction = commandArr[0];
            String filterType = commandArr[1];
            String filterValue = commandArr[2];
            
            getFilter(instruction, filterType, filterValue, filters);
    
            command = br.readLine();
        }
    
        for (String filterAndValue:filters) {
            String[] filterArr = filterAndValue.split(":");
            String filter = filterArr[0];
            String value = filterArr[1];
    
            Predicate<String> isEligible = getTest(value, filter);
    
            for (int i = guestList.size() - 1; i >= 0; i--) {
                String guest = guestList.get(i);
                if (isEligible.test(guest)){
                    guestList.remove(i);
                }
            }
        }
    
        System.out.println(guestList.toString().replaceAll("[\\[\\],]", ""));
    
    }
    
    private static void getFilter(String instruction, String filterType, String filterValue, LinkedList<String> filters) {
        String filter = String.format("%s:%s", filterType, filterValue);
        switch (instruction){
            case "Add filter":
                if (!filters.contains(filter)){
                    filters.add(filter);
                }
                break;
            case "Remove filter":
                if (filters.contains(filter)){
                    filters.remove(filter);
                }
        }
    }
    
    private static Predicate<String> getTest(String value, String filter) {
        switch (filter) {
            case "Starts with":
                return s -> s.startsWith(value);
            case "Ends with":
                return s -> s.endsWith(value);
            case "Length":
                return s -> s.length() == Integer.parseInt(value);
            case "Contains":
                return s -> s.contains(value);
        }
        
        return null;
    }
}
