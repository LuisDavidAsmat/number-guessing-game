import java.util.Scanner;

public class Main
{
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        gameMainMenu();
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
                    Game.playMultipleTimes();
                    break;
                }
                case "2":
                {
                    HighScoreManager.displayHighScores ();
                    break;
                }
                case "3":
                {
                    keepRunning = false;
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
}