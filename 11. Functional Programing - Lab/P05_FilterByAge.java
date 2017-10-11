import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by todor on 11.10.2017 г..
 */
public class P05_FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int personsCount = Integer.parseInt(br.readLine());
        
        LinkedHashMap<String, Integer> persons = new LinkedHashMap<>();
        
        for (int i = 0; i < personsCount; i++) {
            String[] person = br.readLine().split(", ");
            String name = person[0];
            Integer age = Integer.valueOf(person[1]);
            
            persons.put(name, age);
        }
        
        String filterCondition = br.readLine();
        Integer filterValue = Integer.valueOf(br.readLine());
        String printFormat = br.readLine();
        
        Predicate<Integer> tester = getTester(filterCondition, filterValue);
        Consumer<Map.Entry<String, Integer>> printer = getPrinter(printFormat);
        
        printFilteredPersons(persons, tester, printer);
    }
    
    private static void printFilteredPersons(
            LinkedHashMap<String, Integer> persons,
            Predicate<Integer> tester,
            Consumer<Map.Entry<String, Integer>> printer) {
        
        for (Map.Entry<String, Integer> person : persons.entrySet()) {
            if (tester.test(person.getValue())){
                printer.accept(person);
            }
        }
    }
    
    private static Consumer<Map.Entry<String, Integer>> getPrinter(String printFormat) {
        switch (printFormat) {
            case "name":
                return person -> System.out.println(String.format("%s", person.getKey()));
            case "age":
                return person -> System.out.println(String.format("%d", person.getValue()));
            case "name age":
                return person -> System.out.println(String.format("%s - %d", person.getKey(), person.getValue()));
                default:
                    return null;
        }
    }
    
    private static Predicate<Integer> getTester(String filterCondition, Integer filterValue) {
        switch (filterCondition) {
            case "older":
                return integer -> integer >= filterValue;
            case "younger":
                return integer -> integer < filterValue;
            default:
                return null;
        }
    }
}
