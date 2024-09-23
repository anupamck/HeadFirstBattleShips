import java.util.*;
public class GameHelper {
    private static final String ALPHABET = "abcdefg";
    private static final int GRID_LENGTH = 7;
    private static final int GRID_SIZE = ALPHABET.length() * GRID_LENGTH;
    private static final int MAX_ATTEMPTS = 200;
    static final int HORIZONTAL_INCREMENT = 1;
    static final int VERTICAL_INCREMENT = GRID_LENGTH;

    private final int[] grid = new int[GRID_SIZE]; // holds the state of the grid
    private final Random random = new Random();
    private int startUpCount = 0;

    public String getUserInput(String prompt) {
        System.out.print(prompt + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }

    public ArrayList<String> placeStartUp(int startUpSize) {
        int[] startUpCoords = new int[startUpSize];
        int attempts = 0;
        boolean success = false;

        startUpCount++;
        int increment = getIncrement(); // for even numbered startups, the increment is set to place the startup horizontally. Else vertically

        while (!success & attempts++ < MAX_ATTEMPTS) {
            int location = random.nextInt(GRID_SIZE); // Grid size is the entire grid (rows and columns). Location is any random number on this grid

            for (int i = 0; i < startUpCoords.length; i++) {
                startUpCoords[i] = location;
                location += increment;
            } // Generate startup coordinates
            if (startUpFits(startUpCoords, increment)) {
                success = coordsAvailable(startUpCoords); // loop exits only if coordinates are available. Else, retries random values until limit
            }
        }
        savePostionToGrid(startUpCoords); // places startup on the grid
        ArrayList<String> alphaCells = convertCoordsToAlphaFormat(startUpCoords);
        return alphaCells;
    } // places startup in empty location and returns alpha style coordinates for the startup
    private boolean startUpFits(int[] startUpCoords, int increment) {
        int finalLocation = startUpCoords[startUpCoords.length - 1];
        if (increment == HORIZONTAL_INCREMENT) {
            return calcRowFromIndex(startUpCoords[0]) == calcRowFromIndex(finalLocation); // if startup is horizontal, returns true if first cell and last cell of startup can be on the same row
        } else {
            return finalLocation < GRID_SIZE; // if startup is vertical, returns true if last cell is out of grid bounds
        }
    }

    private boolean coordsAvailable(int[] startupCoords) {
        for (int coord : startupCoords) {
            if (grid[coord] != 0) { // default value of all grid members is 0. If it isn't, a startUp has been placed there
                return false;
            }
        }
        return true;
    }

    private void savePostionToGrid(int[] startUpCoords) {
        for (int index : startUpCoords) {
            grid[index] = 1;
        }
    }

    private ArrayList<String> convertCoordsToAlphaFormat(int[] startUpCoords) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        for (int index : startUpCoords) {
            String alphaCoords = getAlphaCoordsFromIndex(index);
            alphaCells.add(alphaCoords);
        }
        return alphaCells; // store alpha style coordinates after conversion in a list
    }

    private String getAlphaCoordsFromIndex(int index) {
        int row = calcRowFromIndex(index);
        int column = index % GRID_LENGTH;
        String letter = ALPHABET.substring(column, column + 1);
        return letter + row;
    } // convert an index into a (alphabet, number) coordinate (E.g. 01 -> a1)

    private int calcRowFromIndex(int index) {
        return index / GRID_LENGTH;
    }

    private int getIncrement() {
        if (startUpCount % 2 == 0) {
            return HORIZONTAL_INCREMENT;
        }
        else {
            return VERTICAL_INCREMENT;
        }
    }
}
