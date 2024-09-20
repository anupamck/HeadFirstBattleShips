import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StartUpTest {

    private StartUp testStartUp = new StartUp();
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    public void setup(TestInfo testInfo) {
        ArrayList<String> location = new ArrayList<String>();
        location.add("A1");
        location.add("A2");
        location.add("A3");
        testStartUp.setLocationCells(location);
        testStartUp.setName("poniez");

        if (testInfo.getTags().contains("terminalOut")) {
            outputStreamCaptor = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStreamCaptor));
        }
    }

    @AfterEach
    public void teardown(TestInfo testInfo) {
        if(testInfo.getTags().contains("terminalOut")) {
            System.setOut(System.out);
        }
    }

    @Test
    void shouldReturnHit() {
        assertEquals("hit", testStartUp.checkYourself("A1"));
    }

    @Test
    void shouldReturnMiss() {
        assertEquals("miss", testStartUp.checkYourself("B1"));
    }

    @Test
    void repeatStrikeShouldMiss() {
        assertEquals("hit", testStartUp.checkYourself("A1"));
        assertEquals("miss", testStartUp.checkYourself("A1"));
    }

    @Test
    @Tag("terminalOut")
    void shouldReturnKill() {
        testStartUp.checkYourself("A1");
        testStartUp.checkYourself("A2");
        assertEquals("kill", testStartUp.checkYourself("A3"));
        String stdOut = outputStreamCaptor.toString().trim();
        assertEquals("Ouch! You sunk poniez : (", stdOut);
    }
}
