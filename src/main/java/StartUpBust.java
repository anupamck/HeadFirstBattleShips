import java.util.ArrayList;

public class StartUpBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<StartUp> startUps = new ArrayList<StartUp>();
    private int numOfGuesses = 0;

    public void setNumOfGuesses (int number) {
        numOfGuesses = number;
    }

    public void setupGame() {
        StartUp one = new StartUp();
        one.setName("poniez");
        StartUp two = new StartUp();
        two.setName("hacqi");
        StartUp three = new StartUp();
        three.setName("cabista");
        startUps.add(one);
        startUps.add(two);
        startUps.add(three);

        System.out.println("Your goal is to sink three startups.");
        System.out.println(one.getName() + ", " + two.getName() + ", " + three.getName());
        System.out.println("Try to sink them all in the fewest number of guesses");

        for (StartUp startUp : startUps) {
            ArrayList<String> newLocation = helper.placeStartUp(3);
            startUp.setLocationCells(newLocation);
        }
    }

    public void startPlaying() {
        while (!startUps.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";

        for (StartUp startUpToCheck : startUps) {
            result = startUpToCheck.checkYourself(userGuess);

            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                startUps.remove(startUpToCheck);
                break;
            }
        }

        System.out.println(result);
    }

    public void finishGame() {
        System.out.println("All Startups are dead! Your stock is now worthless");
        if (numOfGuesses < 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
        }
    }

}