import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by todor on 7.10.2017 г..
 */
public class P06_SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int commandsCount = Integer.parseInt(br.readLine());
        
        Text text = new Text();
    
        for (int i = 0; i < commandsCount; i++) {
            String command = br.readLine();
            text.edit(command);
        }
    }
    
    static class Text{
        private StringBuilder text = new StringBuilder();
        private Deque<StringBuilder> editHistory = new ArrayDeque<>();
        
        // methods
        public void edit (String command){
            String[] commandArray = command.split("\\s+");
    
            switch (commandArray[0]){
                case "1":
                    // append text
                    addText(commandArray[1]);
                    break;
                case "2":
                    // delete last N characters
                    deleteLastCharacters(Integer.parseInt(commandArray[1]));
                    break;
                case "3":
                    // print char at index
                    printCharAt(Integer.parseInt(commandArray[1]));
                    break;
                case "4":
                    //undo
                    undoLastChange();
            }
        }
    
        public void addText (String textToAdd){
            this.text.append(textToAdd);
            StringBuilder undoAppend = new StringBuilder("2 ").append(textToAdd.length());
            this.editHistory.push(undoAppend);
        }
        
        public void deleteLastCharacters(int count) {
            int deleteStartIndex = this.text.length() - count;
            StringBuilder undoDelete = new StringBuilder("1 ").append(this.text.substring(deleteStartIndex));
            this.editHistory.push(undoDelete);
            this.text.delete(deleteStartIndex, text.length());
        }
        
        public void printCharAt(int position){
            int index = position - 1;
            System.out.println(this.text.charAt(index));
        }
        
        public void undoLastChange(){
            edit(this.editHistory.pop().toString());
            this.editHistory.pop();
        }
    }
}
