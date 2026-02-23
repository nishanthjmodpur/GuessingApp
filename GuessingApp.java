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
 * @version 5.0
 */

public class GuessingApp {
	public static void main(String[] args) throws InvalidInputException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=======================");
		System.out.println("Welcome to the Guessing App");
		System.out.println("=======================\n");

		/*
		* Player name is captured once and stored along with game results
		*/
		System.out.println("Enter player name: ");
		String player = scanner.nextLine();

		GameConfig config = new GameConfig();
		config.showRules();

		int attempts = 0;
		int hintCount = 0;

		/*
		* Tracks whether the player successfully guessed the number.	
		*/
		boolean win = false;

		/*
		 * Game loop runs until the player
		 * exhausts the maximum attempts.
		 */
		while (attempts < config.getMaxAttempts()) {
			System.out.print("Enter your guess: ");
			int guess = ValidationService.validateInput(scanner.next());
			attempts++;

			String result = GuessValidator.validateGuess(guess, config.getTargetNumber());
			System.out.println(result);

			/*
			 * Stop the loop immediately if the correct number is guessed.
			 */

			if ("CORRECT".equals(result)) {
				win = true;
				break;
			} else {
				System.out.print("Do you want a hint? [y/n] ");
				String ans = scanner.next();
				if ("y".equals(ans.toLowerCase())) {
					hintCount++;
					String hint = HintService.generateHint(config.getTargetNumber(), hintCount);
					System.out.println(hint);
				}
			}
		}
		StorageService.saveResult(player, attempts, win);
	}
}
