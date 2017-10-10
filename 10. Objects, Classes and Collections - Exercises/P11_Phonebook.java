import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by todor on 8.10.2017 г..
 */
public class P11_Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String command = br.readLine();
    
        Map<String, String> phonebook = new HashMap<>();
        
        while (!command.equals("search")){
            String[] entry = command.split("-");
            String name = entry[0];
            String phoneNumber = entry[1];
            phonebook.put(name, phoneNumber);
    
            command = br.readLine();
        }
    
        command = br.readLine();
        
        while (!command.equals("stop")){
            if (phonebook.containsKey(command)){
                System.out.println(String.format("%s -> %s", command, phonebook.get(command)));
            }
            else {
                System.out.println(String.format("Contact %s does not exist.", command));
            }
    
            command = br.readLine();
        }
    }
}
