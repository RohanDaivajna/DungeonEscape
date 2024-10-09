import java.util.List;
import java.util.Scanner;

/**
 * The Game class manages the main logic of the Dungeon Escape game.
 * It handles player interactions, including movement, inventory management,
 * solving puzzles, and fighting enemies.
 * 
 * <p>Author: Rohan</p>
 * <p>Roll Number: 35</p>
 * <p>Version: 1.0</p>
 * <p>Start Date: 2024-08-06</p>
 * <p>Modified Date: 2024-08-11</p>
 */
public class Game {
    private Player player;
    private Dungeon dungeon;
    private Room currentRoom;
    private Scanner scanner;

    /**
     * Constructs a Game object with the specified player and dungeon.
     *
     * @param player The player participating in the game.
     * @param dungeon The dungeon to be explored.
     */
    public Game(Player player, Dungeon dungeon) {
        this.player = player;
        this.dungeon = dungeon;
        this.currentRoom = dungeon.getStartRoom();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts the game loop, handling player actions and game progression.
     * The game continues until the player either escapes, is defeated, or exits.
     */
    public void start() {
        System.out.println("=====================================");
        System.out.println("   Welcome to the Dungeon Escape!   ");
        System.out.println("=====================================");
        System.out.println("Navigate through the dungeon, solve puzzles, and find the exit.");
        System.out.println("Type 'help' for a list of commands.\n");

        // Main game loop
        while (player.getHealth() > 0) {
            System.out.println(currentRoom.getDescription());

            // Handle enemy encounter if present
            if (currentRoom.hasEnemy()) {
                fightEnemy();
                if (player.getHealth() <= 0) {
                    System.out.println("You have been defeated. Game over.");
                    return;
                }
            }

            // Handle puzzle if present and not solved
            if (!currentRoom.isPuzzleSolved()) {
                solvePuzzle();
                if (!currentRoom.isPuzzleSolved()) {
                    // If the puzzle isn't solved, the player can't move forward.
                    continue;
                }
            }

            System.out.print("\n> ");
            String command = scanner.nextLine().trim().toLowerCase();

            // Process player commands
            switch (command) {
                case "north":
                case "south":
                case "east":
                case "west":
                    move(command);
                    break;
                case "inventory":
                    showInventory();
                    break;
                case "help":
                    showHelp();
                    break;
                case "exit":
                    System.out.println("Thanks for playing!");
                    return;
                default:
                    System.out.println("Invalid command. Type 'help' for a list of commands.");
                    break;
            }

            // Check if the player has reached the exit
            if (currentRoom.getDescription().contains("exit")) {
                System.out.println("Congratulations! You found the exit and escaped the dungeon!");
                break;
            }
        }
    }

    /**
     * Moves the player in the specified direction if an exit exists.
     *
     * @param direction The direction to move (e.g., "north", "south").
     */
    private void move(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            System.out.println("You moved " + direction + ".");
        } else {
            System.out.println("You can't go that way.");
        }
    }

    /**
     * Displays the player's inventory.
     */
    private void showInventory() {
        List<String> inventory = player.getInventory();
        if (inventory.isEmpty()) {
            System.out.println("You have nothing in your inventory.");
        } else {
            System.out.println("You have: " + String.join(", ", inventory));
        }
    }

    /**
     * Displays a list of available commands and their descriptions.
     */
    private void showHelp() {
        System.out.println("Commands:");
        System.out.println("north, south, east, west - Move in that direction");
        System.out.println("inventory - Check your inventory");
        System.out.println("help - Show this help message");
        System.out.println("exit - Quit the game");
    }

    /**
     * Presents and solves the puzzle in the current room.
     */
    private void solvePuzzle() {
        System.out.println("Puzzle: " + currentRoom.getPuzzle());
        System.out.print("Enter your answer: ");
        String answer = scanner.nextLine().trim();
        if (currentRoom.solvePuzzle(answer)) {
            System.out.println("You solved the puzzle!");
        } else {
            System.out.println("That's not the correct answer. Try again!");
        }
    }

    /**
     * Manages the combat between the player and an enemy in the current room.
     */
    private void fightEnemy() {
        System.out.println("A " + currentRoom.getEnemy() + " is attacking you!");

        // Combat loop
        while (currentRoom.hasEnemy() && player.getHealth() > 0) {
            System.out.println("Your health: " + player.getHealth());
            System.out.println("Enemy health: " + currentRoom.getEnemyHealth());

            System.out.print("Enter 'attack' to fight: ");
            String action = scanner.nextLine().trim().toLowerCase();

            if (action.equals("attack")) {
                int damage = (int) (Math.random() * 20) + 1;
                currentRoom.damageEnemy(damage);
                System.out.println("You hit the " + currentRoom.getEnemy() + " for " + damage + " damage.");

                if (!currentRoom.hasEnemy()) {
                    System.out.println("You defeated the enemy!");
                } else {
                    int enemyDamage = (int) (Math.random() * 15) + 1;
                    player.takeDamage(enemyDamage);
                    System.out.println("The " + currentRoom.getEnemy() + " hit you for " + enemyDamage + " damage.");
                }
            } else {
                System.out.println("Invalid action. The enemy attacks you!");
                int enemyDamage = (int) (Math.random() * 15) + 1;
                player.takeDamage(enemyDamage);
                System.out.println("The " + currentRoom.getEnemy() + " hit you for " + enemyDamage + " damage.");
            }
        }
    }
}
