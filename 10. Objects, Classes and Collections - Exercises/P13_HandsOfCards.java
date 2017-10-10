import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by todor on 8.10.2017 г..
 */
public class P13_HandsOfCards {
    public static void main(String[] args) throws IOException {
        
        Map<String, Set<String>> playersHands = getAllHands();
        Map<String, Integer> playersHandsValues = getHandsValues(playersHands);
        
        printScore(playersHandsValues);
    }
    
    private static void printScore(Map<String, Integer> score) {
        score.forEach((k, v) -> System.out.println(String.format("%s: %d",k , v)));
    }
    
    private static Map<String, Set<String>> getAllHands() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Set<String>> playersHands = new LinkedHashMap<>();
        
        String expression = "^(?<name>[^:]*?):\\s+(?<cards>[^:]*?)$";
        Pattern pattern = Pattern.compile(expression);
        
        String command = br.readLine();
        
        while (!command.equals("JOKER")) {
            Matcher matcher = pattern.matcher(command);
            if (!matcher.find()) {
                System.out.println("match error");
                return null;
            }
            
            String name = matcher.group("name");
            String cards = matcher.group("cards");
            Set<String> hand = new HashSet<>(Arrays.asList(cards.split(", ")));
            
            if (!playersHands.containsKey(name)){
                playersHands.put(name, new HashSet<>());
            }
            
            hand.addAll(playersHands.get(name));
            playersHands.put(name, hand);
            
            command = br.readLine();
        }
        
        return playersHands;
    }
    
    private static Map<String, Integer> getHandsValues(Map<String, Set<String>> playersHands) {
        Map<String, Integer> cardsValues = getCardsValues();
        Map<String, Integer> playersHandsValues = new LinkedHashMap<>();
    
        for (Map.Entry<String, Set<String>> hand: playersHands.entrySet()) {
            Integer handValue = 0;
            for (String card: hand.getValue()) {
                handValue += calcValue(cardsValues, card);
            }
            if (!playersHandsValues.containsKey(hand.getKey())){
                playersHandsValues.put(hand.getKey(), 0);
            }
            
            handValue += playersHandsValues.get(hand.getKey());
            playersHandsValues.put(hand.getKey(), handValue);
            
        }
        return playersHandsValues;
    }
    
    private static Integer calcValue(Map<String, Integer> cardsValues, String card) {
        String expression = "^(?<power>[^SDHC]*?)(?<type>[SDHC])$";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(card);
        matcher.find();
        
        return cardsValues.get(matcher.group("power")) * cardsValues.get(matcher.group("type"));
    }
    
    private static Map<String, Integer> getCardsValues() {
        Map<String, Integer> cardsValues = new HashMap<>();
        
        cardsValues.put("C", 1);
        cardsValues.put("D", 2);
        cardsValues.put("H", 3);
        cardsValues.put("S", 4);
        
        cardsValues.put("2", 2);
        cardsValues.put("3", 3);
        cardsValues.put("4", 4);
        cardsValues.put("5", 5);
        cardsValues.put("6", 6);
        cardsValues.put("7", 7);
        cardsValues.put("8", 8);
        cardsValues.put("9", 9);
        cardsValues.put("10", 10);
        cardsValues.put("J", 11);
        cardsValues.put("Q", 12);
        cardsValues.put("K", 13);
        cardsValues.put("A", 14);
        
        return cardsValues;
    }
}
