import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * Created by todor on 9.10.2017 г..
 */
public class P16_DragonArmy {
    public static void main(String[] args) throws IOException {
        
        LinkedHashMap<String, TreeMap<String, Dragon>> dragonsBook = getDragons();
        
        printDragons(dragonsBook);
    }
    
    private static void printDragons(LinkedHashMap<String, TreeMap<String, Dragon>> dragonsBook) {
        
        for (String type : dragonsBook.keySet()) {
            printDragonTypeStats(dragonsBook.get(type), type);
            for (Dragon dragon : dragonsBook.get(type).values()) {
                dragon.print();
            }
        }
    }
    
    private static void printDragonTypeStats(TreeMap<String, Dragon> dragons, String type) {
        Double averageDamage = dragons.values().stream()
                .mapToInt(d -> d.getDamage())
                .average()
                .getAsDouble();
        Double averageHealth = dragons.values().stream()
                .mapToInt(d -> d.getHealth())
                .average()
                .getAsDouble();
        Double averageArmor = dragons.values().stream()
                .mapToInt(d -> d.getArmor())
                .average()
                .getAsDouble();
        
        System.out.println(String.format("%s::(%.2f/%.2f/%.2f)",
                type, averageDamage, averageHealth, averageArmor));
    }
    
    public static LinkedHashMap<String, TreeMap<String, Dragon>> getDragons() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, TreeMap<String, Dragon>> dragons = new LinkedHashMap<>();
        
        int dragonsCount = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < dragonsCount; i++) {
            String[] dragonInput = br.readLine().split(" ");
            Dragon newDragon = new Dragon(dragonInput[0], dragonInput[1], dragonInput[2], dragonInput[3], dragonInput[4]);
            if (!dragons.containsKey(newDragon.getType())) {
                dragons.put(newDragon.getType(), new TreeMap<>());
            }
            TreeMap<String, Dragon> dragonType = dragons.get(newDragon.getType());
            dragonType.put(newDragon.getName(), newDragon);
            
            dragons.get(newDragon.getType()).put(newDragon.getName(), newDragon);
            dragons.put(newDragon.getType(), dragonType);
        }
        
        return dragons;
    }
    
    private static class Dragon {
        private String type;
        private String name;
        private Integer damage;
        private Integer health;
        private Integer armor;
        
        public Dragon(String type, String name, String damage, String health, String armor) {
            this.type = type;
            this.name = name;
            this.damage = damage.equals("null") ? 45 : Integer.valueOf(damage);
            this.health = health.equals("null") ? 250 : Integer.valueOf(health);
            this.armor = armor.equals("null") ? 10 : Integer.valueOf(armor);
        }
        
        public String getType() {
            return type;
        }
        
        public String getName() {
            return name;
        }
        
        public Integer getDamage() {
            return damage;
        }
        
        public Integer getHealth() {
            return health;
        }
        
        public Integer getArmor() {
            return armor;
        }
        
        public void print() {
            System.out.println(
                    String.format("-%s -> damage: %d, health: %d, armor: %d",
                            this.name, this.damage, this.health, this.armor));
        }
    }
}
