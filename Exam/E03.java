import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Joto on 22.10.2017 г..
 */
public class E03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Vlogger> vLogger = new LinkedHashMap<>();

        String command = br.readLine();

        while (!command.equals("Statistics")) {
            String[] input = command.split("\\s+");

            String user = input[0];
            String instruction = input[1];

            switch (instruction) {
                case "joined":
                    vLogger.putIfAbsent(user, new Vlogger(user));
                    break;
                case "followed":
                    String vloggerFollowedBy = input[2];
                    if (vloggerFollowedBy.equals(user)) {
                        break;
                    }
                    if (vLogger.containsKey(vloggerFollowedBy) && vLogger.containsKey(user)) {
                        boolean isAlreadyFollowedByUser = vLogger.get(vloggerFollowedBy).followers.contains(user);
                        if (!isAlreadyFollowedByUser) {
                            vLogger.get(vloggerFollowedBy).followers.add(user);
                            vLogger.get(user).following++;
                        }
                    }
            }

            command = br.readLine();
        }

        Comparator<Vlogger> vloggerComparator = (v1, v2) -> {
            if (v1.followers.size() != v2.followers.size()) {
                return Integer.compare(v2.followers.size(), v1.followers.size());
            }
            return Integer.compare(v1.following, v2.following);
        };

        LinkedList<Vlogger> sortedVloggers = new LinkedList<>();
        vLogger.values().stream()
                .sorted(vloggerComparator)
                .forEach(sortedVloggers::add);
        System.out.println(String.format("The V-Logger has a total of %d vloggers in its logs.",
                vLogger.size()));
        boolean isFirst = true;
        int counter = 0;
        for (Vlogger vlogger : sortedVloggers) {
            counter++;
            System.out.println(String.format("%d. %s : %d followers, %d following",
                    counter, vlogger.userName, vlogger.followers.size(), vlogger.following));
            if (isFirst) {
                vlogger.followers.forEach(f ->
                        System.out.println(String.format("*  %s", f)));
                isFirst = false;
            }
        }
    }

    static class Vlogger {
        public String userName;
        public TreeSet<String> followers;
        public int following;

        public Vlogger(String userName) {
            this.userName = userName;
            this.followers = new TreeSet<>();
            this.following = 0;
        }
    }
}
