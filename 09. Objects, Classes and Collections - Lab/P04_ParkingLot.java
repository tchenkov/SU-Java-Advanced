import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by todor on 7.10.2017 г..
 */
public class P04_ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        Set<String> parking = new HashSet<>();
        
        String command = br.readLine();
        
        while (!command.equals("END")){
            String[] car = command.split(", ");
            
            if (car[0].equals("IN")){
                parking.add(car[1]);
            }
            
            if (car[0].equals("OUT")){
                parking.remove(car[1]);
            }
            
            command = br.readLine();
        }
        
        if (parking.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
        else {
            parking.forEach(System.out::println);
        }
    }
}
