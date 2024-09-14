import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game
{
    private static final int minNum = 1;
    private static final int maxNum = 100;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Integer> difficultyLevels = new HashMap<>();
    private static final Map<String, Integer> highScores = new HashMap<>();
    private static final int hintAttemptLimit = 3;

    static
    {
        difficultyLevels.put("1", 10);
        difficultyLevels.put("2", 5);
        difficultyLevels.put("3", 3);

        highScores.put("1", Integer.MAX_VALUE);
        highScores.put("2",Integer.MAX_VALUE);
        highScores.put("3", Integer.MAX_VALUE);
    }

    public Game()
    {
        gameMainMenu();
    }

    public static int generateRandomNumber()
    {
        return (int)Math.floor(Math.random()*(maxNum-minNum+1) + minNum);
    }

    public static void gameMainMenu ()
    {

        boolean keepRunning = true;

        while (keepRunning)
        {
            System.out.println("Guessing Game:");
            System.out.println("1. Play");
            System.out.println("2. See scores");
            System.out.println("3. Exit Game");
            System.out.println("Enter option: ");

            String menuOptionChosen = scanner.next();

            switch (menuOptionChosen) {
                case "1":
                {
                    playMultipleTimes();
                    break;
                }
                case "2":
                {
                    displayHighScores ();
                    break;
                }
                case "3":
                {
                    keepRunning = false;  // Exit the game loop
                    System.out.println("Exiting Guessing Game.");
                    break;
                }
                default:
                {
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
                }
            }
        }
    }

    private static void displayHighScores()
    {
        System.out.println("High scores");

        for (Map.Entry<String, Integer> entry : highScores.entrySet())
        {
            String difficulty = entry.getKey();
            int score = entry.getValue();

            if (score == Integer.MAX_VALUE)
            {
                System.out.println(getDifficultyName(difficulty) + ": No high score yet.");
            }
            else
            {
                System.out.println(getDifficultyName(difficulty)
                        + ": " + score + " attempts.");
            }
        }
    }

    public static void playMultipleTimes ()
    {
        boolean playAgain;

        // Allow the user to play multiple rounds of the game
        do
        {
            playGame();

            System.out.print("Do you want to play again? (yes/no): ");

            String userChoice = scanner.next();

            playAgain = userChoice.equalsIgnoreCase("yes");
        }while (playAgain);
    }

    public static void playGame ()
    {
        int attempts = getGameAttempts();

        if (0 < attempts && attempts < 11)
        {
            gameMainLoop(attempts);
        }
        else
        {
            System.out.println("Invalid difficulty level. Please choose 1, 2, or 3.");
        }
    }

    private static void gameMainLoop(int totalAttempts)
    {
        int targetNumber = generateRandomNumber();

        long startTime = System.currentTimeMillis();

        for (int attempt = 1; attempt <= totalAttempts; attempt++)
        {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();

            if (guess == targetNumber)
            {
                long endingTime = System.currentTimeMillis();

                long gameDuration = (endingTime - startTime) / 1000;

                System.out.println("Congratulations! You guessed the correct number in "
                        + attempt + " attempts and " + gameDuration + " seconds.");
                System.out.println("The number was " + targetNumber);

                updateHighScore (totalAttempts);

                return;

            }
            else if (guess < targetNumber)
            {
                System.out.println("Too low! Try again.");
            }
            else
            {
                System.out.println("Too high! Try again.");
            }

            if (attempt >= hintAttemptLimit)
            {
                provideHint (guess, targetNumber);
            }

            System.out.println("You have " + (totalAttempts - attempt) + " chances to guess the number.");
        }

        System.out.println("Sorry, you ran out of chances. The number was "
                + targetNumber);
    }

    private static void provideHint(int guess, int targetNumber)
    {
        int range = (maxNum - minNum + 1) / 4;

        if (Math.abs(guess - targetNumber) <= range)
        {
            System.out.println("Hint: quite close");
        }
        else if (Math.abs(guess - targetNumber) <= 2 * range)
        {
            System.out.println("Hint: close");
        }
        else
        {
            System.out.println("Hint: Far off");
        }
    }

    private static void updateHighScore(int attemptsTaken)
    {
        String difficulty = getDifficultyFromAttempts (attemptsTaken);

        if (difficulty != null && attemptsTaken < highScores.get(difficulty))
        {
            highScores.put(difficulty, attemptsTaken);

            System.out.println("New high scores for " +
                    getDifficultyName(difficulty) +
                    " difficulty: " + attemptsTaken + " attempts.");
        }
    }

    private static String getDifficultyName(String difficulty)
    {
        return switch (difficulty)
        {
            case "1" -> "Easy";
            case "2" -> "Medium";
            case "3" -> "Hard";
            default -> "Unknown";
        };
    }

    private static String getDifficultyFromAttempts(int attempts)
    {
        for (Map.Entry<String, Integer> entry : difficultyLevels.entrySet())
        {
            if (entry.getValue() == attempts)
            {
                return entry.getKey();
            }
        }

        return null;
    }

    public static int getGameAttempts ()
    {
        int attempts = 0;

        while (attempts == 0)
        {
            System.out.println("Select difficulty level: "
                    + "\n1 for Easy \n2 for Medium \n3 for Hard:");

            String menuOptionChosen = scanner.next();

            attempts = difficultyLevels.getOrDefault(menuOptionChosen, 0);

            if (attempts == 0)
            {
                System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }

        return attempts;
    }
}
