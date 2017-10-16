import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
// by Indiana Jones
public class P13_Inferno3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> gems = Arrays.stream(bf.readLine().split("\\s+"))
                .map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> filteredGems = new ArrayList<>();
        
        while (true) {
            String line = bf.readLine();
            if ("forge".equalsIgnoreCase(line)) {
                break;
            }
            
            String[] commands = line.split(";");
            String command = commands[0];
            String filterType = commands[1];
            String filterParam = commands[2];
            //Predicate<Integer> tester = createTester("", "", 0, 0, 0);
            
            if ("exclude".equalsIgnoreCase(command)) {
                for (int index = 0; index < gems.size(); index++) {
                    int gemLeft = index == 0 ? 0 : gems.get(index - 1);
                    int gem = gems.get(index);
                    int gemRigth = index == gems.size() - 1 ? 0 : gems.get(index + 1);
                    Predicate<Integer> tester = createTester(filterType, filterParam, gemLeft, gem, gemRigth);
                    
                    if (tester.test(gem)) {
                        filteredGems.add(index);
                    }
                }
            } else if ("reverse".equalsIgnoreCase(command)) {
                for (int index = 0; index < gems.size(); index++) {
                    int gemLeft = index == 0 ? 0 : gems.get(index - 1);
                    int gem = gems.get(index);
                    int gemRigth = index == gems.size() - 1 ? 0 : gems.get(index + 1);
                    Predicate<Integer> tester = createTester(filterType, filterParam, gemLeft, gem, gemRigth);
                    
                    filteredGems.removeIf(tester);
                }
            } else {
                System.out.println("No such command!");
            }
        }
        
        
        if (filteredGems.size() > 0) {
            for (Integer filteredGem : filteredGems) {
                int index = filteredGem;
                gems.remove(index);
                gems.add(index, null);
            }
        }
        
        for (Integer gem : gems) {
            if (gem != null) {
                System.out.printf(gem + " ");
            }
        }
    }
    
    private static Predicate<Integer> createTester(String filterType, String filterParam
            , int gemLeft, int gem, int gemRigth) {
        
        if ("sum left".equalsIgnoreCase(filterType)) {
            return sum -> (gemLeft + gem) == Integer.valueOf(filterParam);
        } else if ("sum right".equalsIgnoreCase(filterType)) {
            return sum -> (gemRigth + gem) == Integer.valueOf(filterParam);
        } else if ("sum left right".equalsIgnoreCase(filterType)) {
            return sum -> (gemLeft + gem + gemRigth) == Integer.valueOf(filterParam);
        } else {
            return null;
        }
    }
}