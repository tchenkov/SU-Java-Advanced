import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by todor on 23.09.2017 г..
 */
public class P13_BlurFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        
        int blurPower = Integer.parseInt(bReader.readLine());
        
        
        int[] picSize = Arrays.stream(bReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int pictureSizeX = picSize[0];
        int pictureSizeY = picSize[1];
        
        long[][] picture = getPicture(pictureSizeX, bReader);
    
        int[] blur = Arrays.stream(bReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int blurCenterX = blur[0];
        int blurCenterY = blur[1];
    
        if (blurCenterX < 0 || pictureSizeX - 1 < blurCenterX ||
                blurCenterY < 0 || pictureSizeY - 1 < blurCenterY){
            printPicture(pictureSizeX, pictureSizeY, picture);
            return;
        }
        
        applyBlur(blurPower, picture, blurCenterX, blurCenterY);
        
        printPicture(pictureSizeX, pictureSizeY, picture);
    }
    
    private static void printPicture(int pictureSizeX, int pictureSizeY, long[][] picture) {
        for (int i = 0; i < pictureSizeX; i++) {
            for (int j = 0; j < pictureSizeY; j++) {
                System.out.printf("%d ", picture[i][j]);
            }
            System.out.println();
        }
    }
    
    private static void applyBlur(int blurPower, long[][] picture, int blurCenterX, int blurCenterY) {
        for (int i = blurCenterX - 1; i <= blurCenterX + 1; i++) {
            for (int j = blurCenterY - 1; j <= blurCenterY + 1; j++) {
                try{
                    picture[i][j] += blurPower;
                }
                catch (IndexOutOfBoundsException e){}
            }
        }
    }
    
    private static long[][] getPicture(int pictureSizeX, BufferedReader bReader) throws IOException {
        long[][] picture = new long[pictureSizeX][];
        for (int i = 0; i < pictureSizeX; i++) {
            picture[i] = Arrays.stream(bReader.readLine().split("\\s+")).mapToLong(Integer::parseInt).toArray();
        }
        
        return picture;
    }
}
