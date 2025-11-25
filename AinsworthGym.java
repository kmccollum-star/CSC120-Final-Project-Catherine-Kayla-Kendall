import java.util.Scanner;

public class AinsworthGym extends Building {

    public AinsworthGym() {
        super(
            "Ainsworth Gym",
            "You wake up alone in Ainsworth. The lights flicker and distant groans echo off the walls."
        );
    }

    /**
     * This is thesequence logic for Ainsworth. 
     * For Ainsworth, players have a choice to explore the locker room, basketball court, and the climbing wall.
     * 
     */
    @Override
    public void play(Player player, Scanner input) {
        System.out.println("You look around the gym. You see:");
        System.out.println("1) The Locker Room door, slightly open");
        System.out.println("2) The Basketball Court, lights flickering");
        System.out.println("3) The Climbing Wall, cords hanging");

        System.out.print("Where do you go? (1/2/3) ");
        String choice = input.nextLine();

        if (choice.equals("1")) {
            exploreLockerRoom(player, input);
        } else if (choice.equals("2")) {
            exploreBasketballCourt(player, input);
        } else if (choice.equals("3")) {
            exploreclimbingWall(player, input);
        } else {
            System.out.println("You freeze, unable to decide where to go to next, you hear groaning in the distance. The groans get closer...");
            System.out.println("A group of zombies surrond you as you're stuck, unable to decide where to go next");
            player.changeHealth(-100);
            System.out.println("You are now dead");
        }
    }

    // Locker room path
    private void exploreLockerRoom(Player player, Scanner input) {
        
    }

    // Basketball court path 
    private void exploreBasketballCourt(Player player, Scanner input) {
        
    }

    // Climbing Wall Path 
    private void exploreclimbingWall(Player player, Scanner input) {
        
    }
}
