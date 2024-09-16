import java.util.Scanner;

public class Game
{
    private static final Scanner scanner = new Scanner(System.in);
    private static final int minNum = 1;
    private static final int maxNum = 100;
    private static final int hintAttemptLimit = 3;


    public static int generateRandomNumber()
    {
        return (int)Math.floor(Math.random()*(maxNum-minNum+1) + minNum);
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
        Difficulty difficulty = InputHandler.getGameDifficulty();

        int attempts = difficulty.getAttempts();

        if (0 < attempts && attempts < 11)
        {
            gameMainLoop(attempts, difficulty);
        }
        else
        {
            System.out.println("Invalid difficulty level. Please choose 1, 2, or 3.");
        }
    }

    private static void gameMainLoop(int totalAttempts, Difficulty difficulty)
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

                HighScoreManager.updateHighScore(difficulty , attempt);

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
}
