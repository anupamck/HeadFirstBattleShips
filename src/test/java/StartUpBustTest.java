import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StartUpBustTest {
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    public void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void shouldSetupGame() {
        StartUpBust game = new StartUpBust();
        game.setupGame();
        String stdOut = outputStreamCaptor.toString().trim();
        String goal = "Your goal is to sink three startups";
        assertTrue(stdOut.contains(goal));
        String startUpNames = "poniez, hacqi, cabista";
        assertTrue(stdOut.contains(startUpNames));
        String instruction = "Try to sink them all in the fewest number of guesses";
        assertTrue(stdOut.contains(instruction));
        // Should return location for each startup
    }

    @Test
    void shouldFinishGameWithCongratulations() {
        StartUpBust game = new StartUpBust();
        int numOfGuesses = 5;
        game.setNumOfGuesses(numOfGuesses);
        game.finishGame();
        String endAnnouncement = "All Startups are dead! Your stock is now worthless";
        String feedback = "It only took you " + numOfGuesses + " guesses.";
        String optionsStatement = "You got out before your options sank.";
        String stdOut = outputStreamCaptor.toString().trim();
        assertTrue(stdOut.contains(endAnnouncement));
        assertTrue(stdOut.contains(feedback));
        assertTrue(stdOut.contains(optionsStatement));
    }

    @Test
    void shouldFinishGameWithInsult() {
        StartUpBust game = new StartUpBust();
        int numOfGuesses = 20;
        game.setNumOfGuesses(numOfGuesses);
        game.finishGame();
        String endAnnouncement = "All Startups are dead! Your stock is now worthless";
        String feedback = "Took you long enough. " + numOfGuesses + " guesses.";
        String optionsStatement = "Fish are dancing with your options";
        String stdOut = outputStreamCaptor.toString().trim();
        assertTrue(stdOut.contains(endAnnouncement));
        assertTrue(stdOut.contains(feedback));
        assertTrue(stdOut.contains(optionsStatement));
    }
}

