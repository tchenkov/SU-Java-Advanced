import java.util.*;

/**
 * Created by todor on 23.09.2017 г..
 */
public class P11_GameOfNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int playersCount = Integer.parseInt(scan.nextLine());
        Map<String, Integer> scoreTable = new LinkedHashMap<>();
       
        Integer maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < playersCount; i++) {
            String playerName = scan.nextLine();
            Integer playerScore = Integer.parseInt(scan.nextLine());
            
            playerScore += getScoreByName(playerName);
    
            scoreTable.put(playerName, playerScore);
            if (maxScore < scoreTable.get(playerName)){
                maxScore = scoreTable.get(playerName);
            }
        }
        Map.Entry<String, Integer> winner = null;
    
        for (Map.Entry<String, Integer> entry : scoreTable.entrySet()) {
            if (maxScore == entry.getValue()) {
                winner = entry;
                break;
            }
        }        
        
        System.out.printf("The winner is %s - %d points%n", winner.getKey(), winner.getValue());
    }
    
    private static Integer getScoreByName(String playerName) {
        Integer score = 0;
        for (char ch :
                playerName.toCharArray()) {
            score = ch % 2 == 0 ?
                    score + ch :
                    score - ch;
        }
        
        return score;
    }
}
