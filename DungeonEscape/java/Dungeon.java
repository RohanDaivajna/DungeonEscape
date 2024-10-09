
/**
 * The Dungeon class represents the dungeon in the game.
 * It initializes the rooms, connects them, sets puzzles and enemies,
 * and defines the starting room for the player.
 * 
 * <p>Author: Rohan</p>
 * <p>Roll Number: 35</p>
 * <p>Version: 1.0</p>
 * <p>Start Date: 2024-08-06</p>
 * <p>Modified Date: 2024-08-11</p>
 */
public class Dungeon {
    private Room startRoom;

    /**
     * Constructs a Dungeon object by creating and connecting rooms,
     * setting puzzles, and assigning enemies.
     */
    public Dungeon() {
        // Create rooms
        Room room1 = new Room("You are in a dark, damp room.");
        Room room2 = new Room("You enter a room with a strange smell.");
        Room room3 = new Room("This room is lit by torches, and you see a locked door to the east.");
        Room room4 = new Room("You find yourself in a room with an eerie silence.");
        Room exitRoom = new Room("You see a light ahead. It's the exit!");

        // Connect rooms
        room1.setExit("north", room2);
        room2.setExit("south", room1);
        room2.setExit("east", room3);
        room3.setExit("west", room2);
        room3.setExit("north", room4);
        room4.setExit("south", room3);
        room4.setExit("north", exitRoom);

        // Add puzzles to rooms
        room1.setPuzzle("Solve this puzzle: What gets wetter as it dries?", "towel");
        room2.setPuzzle("Solve this puzzle: I speak without a mouth and hear without ears. I have no body, but I come alive with wind. What am I?", "echo");
        room3.setPuzzle("Solve this puzzle: What has keys but can't open locks?", "piano");
        room4.setPuzzle("Solve this puzzle: What has to be broken before you can use it?", "egg");

        // Add enemies to some rooms
        room2.setEnemy("Goblin", 30);
        room4.setEnemy("Troll", 50);

        // Start at room 1
        startRoom = room1;
    }

    /**
     * Returns the starting room of the dungeon.
     *
     * @return The starting room.
     */
    public Room getStartRoom() {
        return startRoom;
    }
}
