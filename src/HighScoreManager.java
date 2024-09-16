import java.util.HashMap;
import java.util.Map;

public class HighScoreManager
{
    private static final Map<Difficulty, Integer> highScores = new HashMap<>();

    static
    {
        // Iterate over each Difficulty enum constant
        for (Difficulty difficulty : Difficulty.values())
        {
            highScores.put(difficulty, Integer.MAX_VALUE);
        }
    }

    public static void updateHighScore(Difficulty difficulty, int attempt)
    {
        if (attempt < highScores.get(difficulty))
        {
            highScores.put(difficulty, attempt);

            System.out.println("New high scores for " +
                    difficulty.getName() +
                    " difficulty: " + attempt + " attempts.");
        }
    }

    public static void displayHighScores()
    {
        System.out.println("High scores");

        // Each element in the loop will be an entry
        // containing a key of type Difficulty and a value of type Integer
        for (Map.Entry<Difficulty, Integer> entry : highScores.entrySet())
        {
            // Easy, hard or medium
            Difficulty difficulty = entry.getKey();

            int score = entry.getValue();

            if (score == Integer.MAX_VALUE)
            {
                System.out.println(difficulty.getName() + ": No high score yet.");
            }
            else
            {
                System.out.println(difficulty.getName()
                        + ": " + score + " attempts.");
            }
        }
    }
}
