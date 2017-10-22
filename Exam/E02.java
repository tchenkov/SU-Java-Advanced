import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Joto on 22.10.2017 г..
 */
public class E02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> stones = new ArrayDeque<>();
                Arrays.stream(br.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .forEach(stones::offer);

        int gold = 0;

        String command = br.readLine();

        while (!command.equals("Revision")) {
            String[] input = command.split("\\s+");
            int power = Integer.parseInt(input[2]);
            switch (input[0]) {
                case "Apply":
                    if (stones.size() > 0) {
                        gold = applyAcid(stones, gold, power);
                    }
                    break;
                case "Air":
                    if (gold != 0) {
                        gold = airLeak(stones, gold, power);
                    }
            }

            command = br.readLine();
        }

        System.out.println(stones.toString().replaceAll("[\\[\\],]", ""));
        System.out.println(gold);
    }

    private static int airLeak(Queue<Integer> stones, int gold, int power) {
        if (gold > 0) {
            gold--;
            stones.offer(power);
        }

        return gold;
    }

    private static int applyAcid(Queue<Integer> stones, int gold, int power) {
        for (int i = 0; i < power; i++) {
            if (stones.size() == 0){
                break;
            }
            int stone = stones.poll() - 1;
            if (stone == 0) {
                gold++;
            } else {
                stones.offer(stone);
            }
        }

        return gold;
    }
}
