import java.util.ArrayList;
import java.util.Scanner;
public class GameHelper {
    public String getUserInput(String prompt) {
        System.out.print(prompt + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.toString();
    }

    public ArrayList<String> placeStartUp(int i) {
        ArrayList<String> result = new ArrayList<>();
        return result;
    }
}
