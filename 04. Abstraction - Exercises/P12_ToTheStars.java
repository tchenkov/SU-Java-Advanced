import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by todor on 28.09.2017 г..
 */
public class P12_ToTheStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Star[] stars = new Star[3];
        
        for (int i = 0; i < 3; i++) {
            String input = scan.nextLine();
            String starName = input.toLowerCase().split("\\s+")[0];
            double[] starCoordinates = Arrays.stream(input.split("\\s+"))
                    .skip(1)
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            
            stars[i] = new Star(starName, starCoordinates[0], starCoordinates[1]);
        }
    
        double[] starshipCoordinates = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
    
        double starshipX = starshipCoordinates[0];
        double starshipY = starshipCoordinates[1];
        
        Integer fuel = scan.nextInt();
        scan.nextLine();
        
        while (fuel >= 0) {
            boolean isInSpace = true;
            for (Star s : stars) {
                if (s.getX() - 1 <= starshipX && starshipX <= s.getX() + 1 &&
                        s.getY() - 1 <= starshipY && starshipY <= s.getY() + 1) {
                    System.out.println(s.getName());
                    isInSpace = false;
                }
            }
            
            if (isInSpace) {
                System.out.println("space");
            }
            
            starshipY++;
            fuel--;
        }
    }
    
    static class Star {
        String name;
        double x;
        double y;
        
        public Star(String name, double x, double y) {
            this.name = name.toLowerCase();
            this.x = x;
            this.y = y;
        }
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name.toLowerCase();
        }
        
        public double getX() {
            return x;
        }
        
        public void setX(int x) {
            this.x = x;
        }
        
        public double getY() {
            return y;
        }
        
        public void setY(int y) {
            this.y = y;
        }
    }
}
