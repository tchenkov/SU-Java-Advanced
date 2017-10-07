import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by todor on 7.10.2017 г..
 */
public class P06_AcademyGraduation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int studentsCount = Integer.parseInt(br.readLine());
    
        Map<String, Double> studentsAverageScores = new TreeMap<>();
    
        for (int i = 0; i < studentsCount; i++) {
            String name = br.readLine();
    
            double[] grades = Arrays.stream(br.readLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            double sum = 0.0;
    
            for (double grade: grades) {
                sum += grade;
            }
            
            double averageGrade = sum/grades.length;
            
            studentsAverageScores.put(name, averageGrade);
        }
    
        for (Map.Entry<String, Double> student: studentsAverageScores.entrySet()) {
            System.out.println(String.format("%s is graduated with %s", student.getKey(), student.getValue()));
        }
    }
}
