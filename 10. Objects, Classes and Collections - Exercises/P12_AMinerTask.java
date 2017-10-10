import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by todor on 8.10.2017 г..
 */
public class P12_AMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        Map<String, Integer> minedResources = new HashMap<>();
        String resource = br.readLine();
    
        while (!resource.equals("stop"))
        {
            Integer quantity = Integer.valueOf(br.readLine());
        
            if (!minedResources.containsKey(resource))
            {
                minedResources.put(resource, 0);
            }
            minedResources.put(resource, quantity + minedResources.get(resource));
            
            resource = br.readLine();
        }
    
        for (Map.Entry<String, Integer> item : minedResources.entrySet())
        {
            System.out.println(String.format("%s -> %s", item.getKey(), item.getValue()));
        }
    }
}
