import java.util.Scanner;

/**
 * The Main class is the entry point of the application.
 * It initializes the game, creates a player, and starts the game loop.
 * 
 * <p>Author: Rohan</p>
 * <p>Roll Number: 35</p>
 * <p>Version: 1.0</p>
 * <p>Start Date: 2024-08-06</p>
 * <p>Modified Date: 2024-08-11</p>
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name, brave adventurer: ");
        String playerName = scanner.nextLine();

        // Create player and dungeon
        Player player = new Player(playerName);
        Dungeon dungeon = new Dungeon();

        // Start the game
        Game game = new Game(player, dungeon);
        game.start();

        scanner.close();
    }
}
