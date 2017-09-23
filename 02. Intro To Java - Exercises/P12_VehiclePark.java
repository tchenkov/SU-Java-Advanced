import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by todor on 23.09.2017 г..
 */
public class P12_VehiclePark {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    
        List<String> vehiclesOnStock = new ArrayList<>(Arrays.asList(scan.nextLine().split("\\s+")));
        
        String command = scan.nextLine();
        int soldVehiclesCount = 0;
        
        while (!command.equals("End of customers!")){
            char vehicleType = Character.toLowerCase(command.charAt(0));
            int seatsCount = Arrays.stream(command.split("\\s+"))
                    .skip(2)
                    .limit(1)
                    .mapToInt(Integer::parseInt)
                    .sum();
            String wantedVehicle = "" + vehicleType + seatsCount;
            if (vehiclesOnStock.contains(wantedVehicle)){
                int vehiclePrice = vehicleType * seatsCount;
                System.out.printf("Yes, sold for %d$%n", vehiclePrice);
                int index = vehiclesOnStock.indexOf(wantedVehicle);
                vehiclesOnStock.remove(index);
                soldVehiclesCount++;
            }
            else {
                System.out.println("No");
            }
            
            command = scan.nextLine();
        }
    
        System.out.print("Vehicles left: ");
        System.out.println(vehiclesOnStock.toString().replaceAll("[\\[\\]]", ""));
        System.out.print("Vehicles sold: ");
        System.out.println(soldVehiclesCount);
    }
}
