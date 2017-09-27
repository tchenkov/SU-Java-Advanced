import java.util.Scanner;

/**
 * Created by todor on 26.09.2017 г..
 */
public class P07_CollectTheCoins {
    public static final int GAME_BOARD_SIZE = 4;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        char[][] gameBoard = new char[GAME_BOARD_SIZE][];
    
        for (int i = 0; i < GAME_BOARD_SIZE; i++) {
            gameBoard[i] = scan.nextLine().toCharArray();
        }
        
        char[] moves = scan.nextLine().toLowerCase().toCharArray();
    
        int coinsCount = 0;
        int wallsHitCount = 0;
        int row = 0;
        int col = 0;
        
        for (int i = 0; i < moves.length; i++) {
            switch (moves[i]){
                case '<':
                    try {
                        char ch = gameBoard[row][col - 1];
                        col--;
                        coinsCount += ch == '$' ? 1 : 0;
                    } catch (Exception e) { wallsHitCount++; }
                    break;
                case '>':
                    try {
                        char ch = gameBoard[row][col + 1];
                        col++;
                        coinsCount += ch == '$' ? 1 : 0;
                    } catch (Exception e) { wallsHitCount++; }
                    break;
                case '^':
                    try {
                        char ch = gameBoard[row - 1][col];
                        row--;
                        coinsCount += ch == '$' ? 1 : 0;
                    } catch (Exception e) { wallsHitCount++; }
                    break;
                case 'v':
                    try {
                        char ch = gameBoard[row + 1][col];
                        row++;
                        coinsCount += ch == '$' ? 1 : 0;
                    } catch (Exception e) { wallsHitCount++; }
                    break;
            }
        }
        
        System.out.printf("Coins = %d%n", coinsCount);
        System.out.printf("Walls = %d%n", wallsHitCount);
    }
}
