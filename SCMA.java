import java.util.Scanner;

public class SCMA extends Building {
    public SCMA() {
        super("Smith College Museum Of Art", 
        "With your newly found survivor and map, you make it to the Smith College Museum Of Art.");
    }

    @Override
    public void play(Player player, Scanner input) {
        System.out.println("You enter Smith College Museum Of Art."); 
        System.out.println("You have no time to stall as a HORDE of Zombies start chasing you");
        System.out.println("You grab your friends hand and you run");
        System.out.println("As you run, you realize the only way to escape to safety is through");
        System.out.println("Do you go back to Tyler for supplies or do you fight your way through the Zombies? (1 for Tyler 2 for Challenges");

        String choice = input.nextLine();
        switch (choice){
            case "1" -> {
                //Tyler();
            }
            case "2" -> {
                playChallenges(player, input);
            }
        }

    }
 private void playChallenges(Player player, Scanner input) {
    System.out.println("\nYou have decided to fight");
    System.out.println("Your first challenge is  ");
 }

}
