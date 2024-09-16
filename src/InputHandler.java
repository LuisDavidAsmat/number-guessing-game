import java.util.Scanner;

public class InputHandler
{
    private static final Scanner scanner = new Scanner(System.in);

    public static Difficulty getGameDifficulty()
    {
        Difficulty difficulty = null;

        while (difficulty == null)
        {
            System.out.println("Select difficulty level: "
                    + "\n1 for Easy \n2 for Medium \n3 for Hard:");

            String difficultyChosen = scanner.next();

            difficulty = Difficulty.getDifficultyFromString(difficultyChosen);

            if (difficulty == null)
            {
                System.err.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }

        return difficulty;
    }
}
