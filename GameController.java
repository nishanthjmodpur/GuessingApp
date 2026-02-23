import java.util.Scanner;

class GameController {
    public static boolean restratGame(Scanner scanner) {
        System.out.println("Do you want to play again? (yes/no): ");
        return scanner.next().equalsIgnoreCase("yes");
    }
}
