import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by todor on 3.10.2017 г..
 */
public class P02_Searching {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int[] numArray = Arrays.stream(br.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
                
        int searchFor = Integer.parseInt(br.readLine());
        
        Arrays.sort(numArray);
        Integer searchForIndex;
        
        searchForIndex = linearSearch(numArray, searchFor);
        //searchForIndex = binarySearch(numArray, searchFor);
    
        System.out.println(searchForIndex);
    }
    
    private static Integer binarySearch(int[] numArray, int searchFor) {
        int startIndex = 0;
        int endIndex = numArray.length -1;
        while (startIndex <= endIndex){
            int middleIndex = (startIndex + endIndex) / 2;
            if (numArray[middleIndex] == searchFor){
                return middleIndex;
            }
            else if (numArray[middleIndex] < searchFor){
                startIndex = middleIndex + 1;
            }
            else {
                endIndex = middleIndex - 1;
            }
        }
        
        return -1;
    }
    
    private static Integer linearSearch(int[] numArray, int searchFor) {
        for (int i = 0; i < numArray.length; i++) {
           if (numArray[i] == searchFor){
               return i;
           }
        }
        
        return -1;
    }
}
