import java.util.ArrayList;

public class StartupTestDrive {
    public static void main(String[] args) {
        StartUp dot = new StartUp();
        ArrayList<String> locations = new ArrayList<String>();
        locations.add("A1");
        locations.add("A2");
        locations.add("A3");
        dot.setLocationCells(locations);
        String userGuess = "A1";
        String result = dot.checkYourself(userGuess);
        String testResult = "failed";

        if (result.equals("hit")) {
            testResult = "passed";
        }
        System.out.println(testResult);
    }
}
