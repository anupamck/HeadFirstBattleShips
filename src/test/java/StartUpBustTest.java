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
        StartupBust game = new StartupBust();
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

//    @Test
//    void shouldCheckUserGuess() {
//        // Should return hit
//        // Should return miss
//        // Should return miss if hit, then repeat
//    }
//
//    @Test
//    void shouldfinishGame() {
//        // Should return congratulations
//        // Should return insult
//        // Should return game-over message
//    }
//
//    @Test
//    void shouldStartPlaying() {
//        // should prompt for user input
//        // should accept legit input
//    }
}

