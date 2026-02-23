import java.util.Scanner;

/*
 * MAIN CLASS
 * Coordinates the game flow:
 * 1. Initialize game
 * 2. Accept user guess
 * 3. Validate guess
 * 4. Stop when game ends
 *
 * @author Developer
 * @version 2.0
 */

public class GuessingApp {
	public static void main(String[] args) {
		System.out.println("Welcome to the Guessing App");

		GameConfig gameConfig = new GameConfig();
		gameConfig.showRules();

		Scanner scanner = new Scanner(System.in);
		int attempts = 0;
		int hintCount = 0;

		/*
		 * Game loop runs until the player
		 * exhausts the maximum attempts.
		 */
		while (attempts < gameConfig.getMaxAttempts()) {
			System.out.print("Enter your guess: ");
			int guess = scanner.nextInt();
			attempts++;

			String result = GuessValidator.validateGuess(guess, gameConfig.getTargetNumber());
			System.out.println(result);

			/*
			 * Stop the loop immediately if the correct number is guessed.
			 */

			if ("CORRECT".equals(result)) {
				break;
			} else {
				System.out.print("Do you want a hint? [y/n] ");
				String ans = scanner.next();
				if ("y".equals(ans.toLowerCase())) {
					hintCount++;
					String hint = HintService.generateHint(gameConfig.getTargetNumber(), hintCount);
					System.out.println(hint);
				}
			}
		}
	}
}
