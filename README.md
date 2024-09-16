# Number Guessing Game

##### Solution for the [Number Guessing Game](https://roadmap.sh/projects/number-guessing-game) backend project from [roadmap](https://roadmap.sh/).
[![](https://avatars.githubusercontent.com/u/120650344?s=40&v=4)](https://roadmap.sh/)

This is a simple number guessing game where the computer randomly selects a number and the user has to guess it. If the user guesses the number correctly, the game will end, and the user will win. Otherwise, the game will continue until the user runs out of chances.

## Features
- **Multiple Rounds**: Allows user to play until they decide to quit.
- **Multiple Difficulty Levels**: Choose from Easy, Medium, or Hard difficulty levels, each offering a different number of attempts to guess the correct number.
- **Simple Hint and High Score System**: Keeps track of user's score and provides a hint when user is stuck.


## Usage

1. Clone the repository:
   ```bash
   git clone https://github.com/LuisDavidAsmat/number-guessing-game.git
   ```
2. Navigate to the project directory and enter *src* folder
   ```bash
   cd number-guessing-game/src
   ```
3. Compile the project
    ```bash
   javac Difficulty.java Game.java HighScoreManager.java InputHandler.java Main.java
   ```
4. Run the application by using the following command
    ```bash
    java Main
    ```
5. The game will start with the following menu:
    ```bash
    Guessing Game:
   1. Play
   2. See scores
   3. Exit Game
   Enter option: 
   ```  
6. Example gameplay
    ```bash 
    1
   
   Select difficulty level:
   1 for Easy
   2 for Medium
   3 for Hard:
   1
   
   ...
   
   Enter your guess: 35
   Too high! Try again.
   Hint: quite close
   You have 7 chances to guess the number.
   
   Enter your guess: 31
   Congratulations! You guessed the correct number in 4 attempts and 21 seconds.
   The number was 31
   New high scores for easy difficulty: 4 attempts.
   
   Do you want to play again? (yes/no): no
   
   Guessing Game:
   1. Play
   2. See scores
   3. Exit Game
   Enter option:
   2
   
   High scores
   medium: No high score yet.
   hard: No high score yet.
   easy: 4 attempts.
   
   Guessing Game:
   1. Play
   2. See scores
   3. Exit Game
   Enter option:
   3
   
   Exiting Guessing Game.
   ```

## Contributing
Contributions are welcome! Please open an issue or submit a pull request for any enhancements or bug fixes.