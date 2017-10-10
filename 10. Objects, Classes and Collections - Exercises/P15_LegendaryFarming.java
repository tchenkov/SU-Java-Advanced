import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by todor on 9.10.2017 г..
 */
public class P15_LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Integer> legendaryMats = new LinkedHashMap<>();
        TreeMap<String, Integer> junkMats = new TreeMap<>();
        legendaryMats.put("shards", 0);
        legendaryMats.put("fragments", 0);
        legendaryMats.put("motes", 0);
    
        Map<String, String> itemName = new HashMap<>();
        itemName.put("shards", "Shadowmourne");
        itemName.put("fragments", "Valanyr");
        itemName.put("motes", "Dragonwrath");
        
        String legendaryItem = "";
        
        while (legendaryItem.isEmpty()) {
            String[] input = br.readLine().toLowerCase().split(" ");
            
            for (int j = 0; j < input.length; j += 2) {
                Integer quantity = Integer.valueOf(input[j]);
                String matName = input[j+1];
                
                if (legendaryMats.containsKey(matName)){
                    legendaryMats.put(matName, quantity + legendaryMats.get(matName));
                    
                    if (legendaryMats.get(matName) >= 250){
                        legendaryMats.put(matName, legendaryMats.get(matName) - 250);
                        legendaryItem = itemName.get(matName);
                        break;
                    }
                }
                else {
                    if (!junkMats.containsKey(matName)){
                        junkMats.put(matName, 0);
                    }
                    
                    junkMats.put(matName, quantity + junkMats.get(matName));
                }
            }
        }
    
        System.out.println(String.format("%s obtained!", legendaryItem));
        
        legendaryMats.entrySet().stream()
                .sorted((m1, m2) -> {
                    int value = m2.getValue().compareTo(m1.getValue());
                    
                    if (value != 0){
                        return value;
                    }
                    
                    return m1.getKey().compareTo(m2.getKey());
                })
                .forEach(mat -> System.out.println(String.format("%s: %d", mat.getKey(), mat.getValue())));
        
        junkMats.entrySet().stream()
                .forEach(mat -> System.out.println(String.format("%s: %d", mat.getKey(), mat.getValue())));
    }
}

