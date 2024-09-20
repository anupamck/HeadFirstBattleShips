import java.util.ArrayList;

public class StartupBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<StartUp> startups = new ArrayList<StartUp>();
    private int numOfGuesses = 0;

    public void setupGame() {
        StartUp one = new StartUp();
        one.setName("poniez");
        StartUp two = new StartUp();
        two.setName("hacqi");
        StartUp three = new StartUp();
        three.setName("cabista");
        startups.add(one);
        startups.add(two);
        startups.add(three);

        System.out.println("Your goal is to sink three startups.");
        System.out.println( one.getName() + ", " + two.getName() + ", " + three.getName());
        System.out.println("Try to sink them all in the fewest number of guesses");
    }

//    public static void main(String[] args) {
//        int numOfGuesses = 0;
//        GameHelper helper = new GameHelper();
//
//        Startup theStartup = new Startup();
//        int randomNum = (int) (Math.random() * 5);
//
//        ArrayList<String> locations = {randomNum, randomNum + 1, randomNum + 2};
//        theStartup.setLocationCells(locations);
//        boolean isAlive = true;
//
//        while (isAlive) {
//            int guess = helper.getUserInput("enter a number");
//            String result = theStartup.checkYourself(guess);
//            numOfGuesses++;
//            if(result.equals("kill")) {
//                isAlive = false;
//                System.out.println("You took " + numOfGuesses + " guesses");
//            }
//        }
//    }
}
