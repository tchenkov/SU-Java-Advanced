import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by todor on 14.10.2017 г..
 */
public class P07_MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, LinkedList<Integer>> population = getPopulation(br);
        int minPopulation = Integer.parseInt(br.readLine());
        
        population.entrySet()
                .stream()
                .filter(getFilter(minPopulation))
                .sorted(getSort())
                .forEach(print());
    }
    
    private static Consumer<Map.Entry<String, LinkedList<Integer>>> print() {
        return entry -> System.out.printf("%s: %s%n", entry.getKey(),
                Arrays.toString(entry.getValue()
                        .stream()
                        .sorted(Comparator.reverseOrder())
                        .limit(5)
                        .toArray()).replaceAll("[\\[\\],]", ""));
    }
    
    private static Comparator<Map.Entry<String, LinkedList<Integer>>> getSort() {
        return (e1, e2) -> Integer.compare(getListSum(e2.getValue()), getListSum(e1.getValue()));
    }
    
    private static Predicate<Map.Entry<String, LinkedList<Integer>>> getFilter(int minPopulation) {
        return entry -> entry.getValue()
                .stream()
                .mapToInt(Integer::valueOf)
                .sum() >= minPopulation;
    }
    
    private static int getListSum(List<Integer> list) {
        return list.stream().mapToInt(Integer::valueOf).sum();
    }
    
    private static LinkedHashMap<String, LinkedList<Integer>> getPopulation(BufferedReader br) throws IOException {
        LinkedHashMap<String, LinkedList<Integer>> population = new LinkedHashMap<>();
        
        String[] input = br.readLine().split("\\s+");
        
        for (String item : input) {
            String[] cityAndDistrictPopulation = item.split(":");
            String city = cityAndDistrictPopulation[0];
            Integer districtPopulation = Integer.valueOf(cityAndDistrictPopulation[1]);
            
//            if (!population.containsKey(city)) {
//                population.put(city, new LinkedList<>());
//            }
            
            population.putIfAbsent(city, new LinkedList<>());
            population.get(city).add(districtPopulation);
        }
        
        return population;
    }
}
