import java.util.Scanner;

/**
 * Abstract base class 
 */
public abstract class Building {

    protected String name;
    protected String description;

    public Building(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    
    public void intro(Player player) {
        System.out.println("\n=== " + this.name + " ===");
        System.out.println(this.description);
        System.out.println("Health: " + player.getHealth());
    }

    
    public abstract void play(Player player, Scanner input);
}
