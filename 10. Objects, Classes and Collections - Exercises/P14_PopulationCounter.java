import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * Created by todor on 9.10.2017 г..
 */
public class P14_PopulationCounter {
    public static void main(String[] args) throws IOException {
        
        Map<String, LinkedHashMap<String, Long>> countriesPopulation = getCountriesPopulation();
        
        printCountries(countriesPopulation);
    }
    
    private static void printCountries(Map<String, LinkedHashMap<String, Long>> countriesPopulation) {
        for (Map.Entry<String, LinkedHashMap<String, Long>> country: countriesPopulation.entrySet()) {
            Long countryPopulation = country.getValue().values().stream().mapToLong(Long::valueOf).sum();
    
            System.out.println(String.format("%s (total population: %d)", country.getKey(), countryPopulation));
    
            for (Map.Entry<String, Long> city: country.getValue().entrySet()) {
                System.out.println(String.format("=>%s: %d", city.getKey(), city.getValue()));
            }
        }
    }
    
    private static Map<String, LinkedHashMap<String, Long>> getCountriesPopulation() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, LinkedHashMap<String, Long>> countriesPopulation = new LinkedHashMap<>();
        
        String input = br.readLine();
        
        while (!input.equals("report")) {
            String[] inputArray = input.split("\\|");
            String city = inputArray[0];
            String country = inputArray[1];
            Long population = Long.valueOf(inputArray[2]);
            
            if (!countriesPopulation.containsKey(country)) {
                countriesPopulation.put(country, new LinkedHashMap<>());
            }
            LinkedHashMap<String, Long> cityPopulation = countriesPopulation.get(country);
            cityPopulation.put(city, population);
            countriesPopulation.put(country, cityPopulation);
            
            input = br.readLine();
        }
        
        return sortByPopulation(countriesPopulation);
    }
    
    private static Map<String, LinkedHashMap<String, Long>> sortByPopulation(
            Map<String, LinkedHashMap<String, Long>> countriesPopulation) {
        for (String country : countriesPopulation.keySet()) {
            LinkedHashMap<String, Long> sortedCountry = new LinkedHashMap<>();
            countriesPopulation.get(country).entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .forEach(entry -> sortedCountry.put(entry.getKey(), entry.getValue()));
            countriesPopulation.put(country, sortedCountry);
        }
    
        Map<String, LinkedHashMap<String, Long>> countriesPopulationSorted = new LinkedHashMap<>();
        countriesPopulation.entrySet().stream()
                .sorted((o1, o2) -> {
                    Long sum2 = o2.getValue().values().stream().mapToLong(Long::valueOf).sum();
                    Long sum1 = o1.getValue().values().stream().mapToLong(Long::valueOf).sum();
                    
                    return sum2.compareTo(sum1);
                })
                .forEach(entry -> countriesPopulationSorted.put(entry.getKey(), entry.getValue()));
        
        return countriesPopulationSorted;
    }
}
