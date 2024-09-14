import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game
{
    private static final int minNum = 1;
    private static final int maxNum = 100;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Integer> difficultyLevels = new HashMap<>();

    static
    {
        difficultyLevels.put("1", 10);
        difficultyLevels.put("2", 5);
        difficultyLevels.put("3", 3);
    }

    public Game()
    {
        gameMenu();
    }

    public static int generateRandomNumber()
    {
        return (int)Math.floor(Math.random()*(maxNum-minNum+1) + minNum);
    }

    public static void gameMenu ()
    {
        Scanner scanner = new Scanner(System.in);
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
                    gameLoop();
                    break;
                }
                case "2": {
                    // Display scores (currently not implemented)
                    System.out.println("Scoreboard functionality is not yet available.");
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

        scanner.close();
    }

    public static void gameLoop ()
    {
        int attempts = gameDifficulty();

        if (attempts > 0)
        {
            playGame(attempts);
        }
        else
        {
            System.out.println("Invalid difficulty level. Please choose 1, 2, or 3.");
        }
    }

    private static void playGame(int attempts)
    {
        int targetNumber = generateRandomNumber();

        for (int attempt = 1; attempt <= attempts; attempt++)
        {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();

            if (guess == targetNumber)
            {
                System.out.println(
                        "Congratulations! You guessed the correct number in "
                                + attempt + " attempts."
                );

                System.out.println("The number was " + targetNumber);

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


            System.out.println("You have " + (attempts - attempt) + " chances to guess the number.");
        }

        System.out.println("Sorry, you ran out of chances. The number was "
                + targetNumber);
    }

    public static int gameDifficulty ()
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
