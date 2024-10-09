import java.util.HashMap;
import java.util.Map;

/**
 * The Room class represents a room in the dungeon.
 * It contains the room description, exits, puzzles, enemies,
 * and handles puzzle-solving and enemy management.
 * 
 * <p>Author: Rohan</p>
 * <p>Roll Number: 35</p>
 * <p>Version: 1.0</p>
 * <p>Start Date: 2024-08-06</p>
 * <p>Modified Date: 2024-08-11</p>
 */
public class Room {
    private String description;
    private Map<String, Room> exits;
    private String puzzle;
    private String puzzleAnswer;
    private boolean puzzleSolved;
    private String enemy;
    private int enemyHealth;

    /**
     * Constructs a Room object with a specified description.
     *
     * @param description The description of the room.
     */
    public Room(String description) {
        this.description = description;
        this.exits = new HashMap<>();
        this.puzzleSolved = false;
    }

    /**
     * Sets an exit from this room to another room in a specified direction.
     *
     * @param direction The direction of the exit.
     * @param room The room to which the exit leads.
     */
    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }

    /**
     * Returns the exit room in the specified direction.
     *
     * @param direction The direction of the exit.
     * @return The room in that direction, or null if no exit exists.
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }

    /**
     * Returns the description of the room.
     *
     * @return The description of the room.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets a puzzle for this room.
     *
     * @param puzzle The puzzle question.
     * @param answer The correct answer to the puzzle.
     */
    public void setPuzzle(String puzzle, String answer) {
        this.puzzle = puzzle;
        this.puzzleAnswer = answer;
    }

    /**
     * Returns the puzzle for this room.
     *
     * @return The puzzle question.
     */
    public String getPuzzle() {
        return puzzle;
    }

    /**
     * Attempts to solve the puzzle with the given answer.
     *
     * @param answer The answer to the puzzle.
     * @return True if the answer is correct, false otherwise.
     */
    public boolean solvePuzzle(String answer) {
        if (answer.equalsIgnoreCase(puzzleAnswer)) {
            puzzleSolved = true;
            return true;
        }
        return false;
    }

    /**
     * Checks if the puzzle has been solved.
     *
     * @return True if the puzzle is solved, false otherwise.
     */
    public boolean isPuzzleSolved() {
        return puzzleSolved;
    }

    /**
     * Sets an enemy in this room.
     *
     * @param enemy The name of the enemy.
     * @param health The health of the enemy.
     */
    public void setEnemy(String enemy, int health) {
        this.enemy = enemy;
        this.enemyHealth = health;
    }

    /**
     * Returns the name of the enemy in this room.
     *
     * @return The name of the enemy.
     */
    public String getEnemy() {
        return enemy;
    }

    /**
     * Returns the health of the enemy.
     *
     * @return The health of the enemy.
     */
    public int getEnemyHealth() {
        return enemyHealth;
    }

    /**
     * Damages the enemy by the specified amount.
     *
     * @param damage The amount of damage to apply to the enemy.
     */
    public void damageEnemy(int damage) {
        enemyHealth -= damage;
    }

    /**
     * Checks if the room has an enemy.
     *
     * @return True if there is an enemy, false otherwise.
     */
    public boolean hasEnemy() {
        return enemyHealth > 0;
    }
}
