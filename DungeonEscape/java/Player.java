import java.util.ArrayList;
import java.util.List;

/**
 * The Player class represents the player in the game,
 * keeping track of their name, health, and inventory.
 * 
 * <p>Author: Rohan</p>
 * <p>Roll Number: 35</p>
 * <p>Version: 1.0</p>
 * <p>Start Date: 2024-08-06</p>
 * <p>Modified Date: 2024-08-11</p>
 */
public class Player {
    private String name;
    private int health;
    private List<String> inventory;

    /**
     * Constructs a Player object with a specified name,
     * setting the initial health and initializing the inventory.
     *
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
        this.health = 100; // Initial health
        this.inventory = new ArrayList<>();
    }

    /**
     * Returns the player's name.
     *
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the player's current health.
     *
     * @return The current health of the player.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Decreases the player's health by the specified amount.
     *
     * @param damage The amount of damage to apply to the player.
     */
    public void takeDamage(int damage) {
        health -= damage;
        System.out.println("You took " + damage + " damage. Your health is now " + health + ".");
    }

    /**
     * Returns the player's inventory.
     *
     * @return The inventory list of the player.
     */
    public List<String> getInventory() {
        return inventory;
    }

    /**
     * Adds an item to the player's inventory.
     *
     * @param item The item to add to the inventory.
     */
    public void addItem(String item) {
        inventory.add(item);
    }
}
