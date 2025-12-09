import java.util.ArrayList;
import java.util.Scanner;

//this class is where the player will meet a new survivor
//should have reversable decisions
public class Seelye extends Building {
    
    public ArrayList<String> inventory = new ArrayList<String>();
    public String s = "Fellow Smithie Survivor";

    public Seelye(){
        super("Seelye Hall", 
        "You make it to Seelye. The sun is shining, your health is refilled and you have new supplies.");
        String b = "";
        inventory.add(b);
    }

    @Override
    public void play(Player player, Scanner input){
        System.out.println("You enter Seelye Hall. You can either: ");
        System.out.println("1: Go to the basement."); //will find survivor in basement
        //must have map and collect survivor for next step
        System.out.println("2: Explore the Jacobsen Center (hint: may find a map here).");//will find map in jacobsen center
        System.out.println("3: Explore the Spinelli Center.");

        System.out.println("Where do you want to go? (1/2/3)");

        String choice = input.nextLine();

        switch (choice) {
            case "1" -> exploreBasement(player, input);
            case "2" -> exploreJacobsen(player, input);
            case "3" -> exploreSpinelli(player, input);
            //def need to change this part
            default -> {
                System.out.println("You freeze, unable to decide where to go to next, you hear groaning in the distance. The groans get closer...");
                System.out.println("A group of zombies surrond you as you're stuck, unable to decide where to go next");
                player.changeHealth(-100);
                System.out.println("You are now dead");
            }
        }
    }

    //basement path
    private void exploreBasement(Player player, Scanner input){
        
        if(inventory.contains(s)){
            System.out.println("You have already explored the basement. Return to the ground floor. ");
            returnToGround(player, input);
        }else{
        
        System.out.println("You head downstairs to the basement.");
        System.out.println("The lights are dim and flickering. You call out, 'Hello?'");
        System.out.println("You hear a groan in response and a faint help. Do you: ");
        System.out.println("1: Go back to the first floor");
        System.out.println("2: Go towards the voice.");

        System.out.println("Where do you want to go? (1/2)");

        String choice = input.nextLine();
        //add default choice
        switch (choice){
            case "1" -> {
                System.out.println("You trek back up the stairs.");
                returnToGround(player, input);
            }
            case "2" -> {
                System.out.println("You walk closer to the sound and find a fellow Smithie laying on the ground helpless.");
                System.out.println("There's a chance she's been injured by a zombie. If she has, it's a matter of time before she transitions. If not, you can bring her with you.");
                System.out.println("Do you want to 1: take the risk and inspect her or 2: leave while you still can?");
                System.out.println("Where do you want to go? (1/2)");

                String secChoice = input.nextLine();
                    
                    switch (secChoice) {
                        case "1" -> {
                        System.out.println("The Smithie has no wounds, but she is severely dehydrated. You give her some of your water and choose to bring her along.");
                        inventory.add(s);
                        System.out.println("You explore the rest of the basement and don't find anything useful.");
                        System.out.println("You head back to the ground floor with your new friend in tow.");
                        returnToGround(player, input);
                        }
                        case "2" -> {
                            returnToGround(player, input);
                        }
                    }
                }
            }
        }
    }
    

    private void exploreJacobsen(Player player, Scanner input){
        System.out.println("You are now in the Jacobsen Center.");
        System.out.println("The zombies' destruction is obvious; obstacles stand between you and the Spinelli Center.");
        System.out.println("In order to continue exploring, you need to move some of the rubble out of the way.");

        if(inventory.contains(s)){
            System.out.println("Would you like to remove the rubble or return to the ground floor? (1/2)");
            String choice = input.nextLine();
            
            switch (choice){
                case "1" -> {
                    System.out.println("You successfully remove the rubble and find many useful resources, one being a map of the Art Museum.");
                    returnToGround(player, input);
                    //maybe add map to inventory??
                }
                case "2" -> {
                    returnToGround(player, input);
                }
            }
        }else{
            System.out.println("You try to remove the rubble, but it looks like you need an extra set of hands to move this rubble. (Hint: check the basement)");
            returnToGround(player, input);
        }
    }

    private void exploreSpinelli(Player player, Scanner input){
        System.out.println("You are in the Spinelli Center.");
        System.out.println("You explore the floor and find nothing of use.");
        System.out.println("You head back to the ground floor.");
        returnToGround(player, input);
    }

    private void returnToGround(Player player, Scanner input){
        System.out.println("You are now on the ground floor. You can either: ");
        System.out.println("1: Leave Seelye.");
        System.out.println("2: Go to the Jacobsen Center.");
        System.out.println("3: Go to the Spinelli Center.");
        System.out.println("4: Go to the Basement.");

        System.out.println("Where do you go? (1/2/3/4)");
        String choice = input.nextLine();

        switch(choice){
            case "1" -> {
                System.out.println("You have left Seelye. Do you want to return to Tyler, or progress to the final destination?");
                System.out.println("Where do you go? Tyler of Art Museum");

                String destination = input.nextLine();
                if(destination == "Tyler"){
                    System.out.println("You head over to Tyler for more supplies.");
                } else if (destination == "Art Museum"){
                    System.out.println("You head to the Art Musuem, the last obstacle between you and safety.");
                }
            }
            case "2" -> exploreJacobsen(player, input);
            case "3" -> exploreSpinelli(player, input);
            case "4" -> exploreBasement(player, input);
        }
    }

    public static void main(String[] args) {
        Seelye seelye = new Seelye();
        Player player = new Player ("name", 100);
        Scanner input = new Scanner(System.in);
        seelye.play(player, input);
    }
}

