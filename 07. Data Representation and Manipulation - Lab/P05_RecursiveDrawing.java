import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

/**
 * Created by todor on 3.10.2017 г..
 */
public class P05_RecursiveDrawing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        draw(n);
    }
    
    private static void draw(int n) {
        if (n <= 0){
            return;
        }
        System.out.println(String.join("", Collections.nCopies(n, "*")));
        draw(n - 1);
        System.out.println(String.join("", Collections.nCopies(n, "#")));
    }
}
