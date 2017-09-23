import java.util.Scanner;

/**
 * Created by todor on 20.09.2017 г..
 */
public class P02_TriangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int aX = scan.nextInt();
        int aY = scan.nextInt();
        int bX = scan.nextInt();
        int bY = scan.nextInt();
        int cX = scan.nextInt();
        int cY = scan.nextInt();
    
        int area = Math.abs( (aX * (bY - cY) + bX * (cY - aY) + cX * (aY - bY)) / 2 );
        
        System.out.printf("%d%n", area);
    }
}