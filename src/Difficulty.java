public enum Difficulty
{
    EASY(10),
    MEDIUM(5),
    HARD(3);

    private final int attempts;

    Difficulty(int attempts)
    {

        this.attempts = attempts;
    }

    public int getAttempts()
    {
        return attempts;
    }

    public static Difficulty getDifficultyFromString(String difficultyChosen)
    {
        return switch (difficultyChosen)
        {
            case "1" -> EASY;
            case "2" -> MEDIUM;
            case "3" -> HARD;
            default -> throw new IllegalStateException("Invalid value: " + difficultyChosen
            + ". Values should be 1, 2, or 3.");
        };
    }

    public String getName()
    {
        return switch (this)
        {
            case EASY -> "easy";
            case MEDIUM -> "medium";
            case HARD -> "hard";
        };
    }
}
