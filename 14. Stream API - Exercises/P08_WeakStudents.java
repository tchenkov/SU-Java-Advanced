import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by todor on 15.10.2017 г..
 */
@SuppressWarnings("Duplicates")
public class P08_WeakStudents {
    private static final int GRADE = 3;
    
    public static void main(String[] args) throws IOException {
        LinkedList<Student> studentsList = getStudents();
        
        Predicate<Student> hasExcellentGrade = st ->
                st.getGrades().stream()
                        .sorted()
                        .skip(1)
                        .limit(1)
                        .mapToInt(Integer::valueOf)
                        .sum() <= GRADE;
        
        Comparator<Student> gradesSumAscending = Comparator.comparingInt(st -> sumGrades(st.getGrades()));
    
        Consumer<Student> print = st -> {
            String grades = st.getGrades().stream()
                    .sorted()
                    .collect(Collectors.toList())
                    .toString()
                    .replaceAll("[\\[\\],]", "");
            System.out.println(String.format("%s %s %s",
                    st.getFirstName(), st.getLastName(), grades));
        };
        
        studentsList.stream()
                .filter(hasExcellentGrade)
                .sorted(gradesSumAscending)
                .forEach(print);
    }
    
    private static int sumGrades(List<Integer> grades) {
        return grades.stream().mapToInt(Integer::valueOf).sum();
    }
    
    private static LinkedList<Student> getStudents() throws IOException {
        LinkedList<Student> studentsList = new LinkedList<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String command = br.readLine();
        
        while (!command.equals("END")) {
            String[] studentInfo = command.split("\\s+");
            String idNumber = studentInfo[0];
            String firstName = studentInfo[1];
            String lastName = studentInfo[2];
            String eMail = studentInfo[3];
            Integer age = Integer.valueOf(studentInfo[4]);
            Integer groupNumber = Integer.valueOf(studentInfo[5]);
            List<Integer> grades = getGrades(studentInfo);
            String phoneNumber = studentInfo[10];
            Student student = new Student(idNumber, firstName, lastName, eMail, age, groupNumber, grades, phoneNumber);
            studentsList.add(student);
            
            command = br.readLine();
        }
        
        return studentsList;
    }
    
    private static List<Integer> getGrades(String[] studentInfo) {
        return Arrays.stream(studentInfo)
                .skip(6)
                .limit(4)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
    
    static class Student {
        private String idNumber;
        private String firstName;
        private String lastName;
        private String eMail;
        private Integer age;
        private Integer groupNumber;
        private List<Integer> grades;
        private String phoneNumber;
        
        public Student(String idNumber, String firstName, String lastName, String eMail,
                       Integer age, Integer groupNumber, List<Integer> grades, String phoneNumber) {
            this.idNumber = idNumber;
            this.firstName = firstName;
            this.lastName = lastName;
            this.eMail = eMail;
            this.age = age;
            this.groupNumber = groupNumber;
            this.grades = grades;
            this.phoneNumber = phoneNumber;
        }
        
        public String getIdNumber() {
            return idNumber;
        }
        
        public void setIdNumber(String idNumber) {
            this.idNumber = idNumber;
        }
        
        public String getFirstName() {
            return firstName;
        }
        
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        
        public String getLastName() {
            return lastName;
        }
        
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        
        public String geteMail() {
            return eMail;
        }
        
        public void seteMail(String eMail) {
            this.eMail = eMail;
        }
        
        public Integer getAge() {
            return age;
        }
        
        public void setAge(Integer age) {
            this.age = age;
        }
        
        public Integer getGroupNumber() {
            return groupNumber;
        }
        
        public void setGroupNumber(Integer groupNumber) {
            this.groupNumber = groupNumber;
        }
        
        public List<Integer> getGrades() {
            return grades;
        }
        
        public void setGrades(List<Integer> grades) {
            this.grades = grades;
        }
        
        public String getPhoneNumber() {
            return phoneNumber;
        }
        
        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }
}