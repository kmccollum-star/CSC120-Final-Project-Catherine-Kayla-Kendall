import java.util.Scanner;

public class Tyler extends Building {
    
    public Tyler (){
        super (
            "Tyler House",
            "Violently out of breath, you stumble into Tyler. Desperately in need of supplies, you decide which rooms to search"
        );
    }

    /**
     * This is the sequence logic for Tyler House
     */
    @Override

    public void play (Player player, Scanner input){
        System.out.println ("You observe the cozy lobby of Tyler house and see...");
        System.out.println("1) A large arched door frame leading into the living room");
        System.out.println("2) A creepy staircase leading into the basement");
        System.out.println("3) A dark hallway leading into the dining room");

        System.out.println("Where do you wish to explore?");
        String choice =  input.nextLine();

        switch (choice){
            case "1" -> exploreLivingRoom (player, input);
            case "2" -> exploreTylerBasement (player, input);
            case "3" -> exploreTylerCafeteria (player, input);
            default -> {
                System.out.println("You hesitate for too long... ");
                System.out.println("A zombie bursts through the door behind you and mauls you to death");
                player.changeHealth(-100);
                System.out.println("You are now dead.");

            //What happens when a user input something that isnt in the choices?
                
            }
        }
    }

    //Living Room Path
    private void exploreLivingRoom(Player player, Scanner input) {
        System.out.println("You walk through the arched walkway leading into the living room.");
        System.out.println("The room is littered with tons of comfy couches and littered bookshelves. A well lit fire blazes in the fire place.");
        System.out.println("You see many weapons on shelves in the room.");
        System.out.println("Do you: ");
        System.out.println("a) Near the fireplace to reach for the katana on the mantle? ");
        System.out.println("b) Approach the bookshelves to take the pistol?");
        
        System.out.print("What's your choice, a or b?");
        String action = input.nextLine().toLowerCase();

        switch (action) {
            case "a" -> {
                System.out.println("You move towards the fireplace carefully");
                System.out.println("As you get closer to the mantle, the fire cackles loudly");
                System.out.println("You quickly reach for the katana on the mantle");
                System.out.println("As you step back from the fireplace, katana in hand, you smell smoke");
                System.out.println("Your shirt caught on fire, and without water to put it out, your skin is burnt.");
                player.changeHealth(-10);
                player.addWeapon("katana");
                System.out.println("You have lost some health.");
                System.out.println("You return to the lobby of Tyler House");
                
            }

            case "b" -> {
                System.out.println("You move towards the bookshelves, in awe of the large collection");
                System.out.println("The pistol lies on the second bookshelf right infront of you.");
                System.out.println("You carefully reach for the pistol and put it in your pocket. ");
                player.addWeapon("Pistol");
            }

            default -> {
                System.out.println("You decide that violence is not the answer");
                //System.out.println("You have lost some health.");
                System.out.println("You do not reach for any weapons, and end up resting on the couch");
                System.out.println("You stay here until you fall asleep. You will let the apocalyspe run its course");
            }
        }
    }

    private void exploreTylerCafeteria (Player player, Scanner input) {
        System.out.println("You wander into the Tyler Dining Hall, deserted and abandoned.");
        System.out.println("Do you:");
        System.out.println("a) Scavenge for food in the kitchen");
        System.out.println("b) Search for food in the salad bar?");
        
        System.out.println("Your choice? (a/b) ");
        String action = input.nextLine().toLowerCase();

        switch (action) {
            case "a" -> {
                System.out.println("You wander around the kitchen looking for any morsel of food to eat.");
                System.out.println("You see a sandwich on the countertop but also hear the low rumble of the refridgerator.");
                System.out.println("Do you: ");
                System.out.println("1) Open the fridge to look for more?");
                System.out.println("2) Approach the sandwich carefully wrapped on the countertop?");
                
                System.out.print("Your choice? (1/2) ");
                String num = input.nextLine();

                if (num.equals("1")) {
                    System.out.println("You open the fridge but there is only a burger on the shelf.");
                    System.out.println("It looks fresh enough to eat.");
                    System.out.println("As you eat it you realise that it is a Tyler special burger. It is mostly undercooked making you sick");
                    System.out.println("You end up violently vomiting, and feel more famished than ever (-40 health) ");
                    player.changeHealth(-40);
                    System.out.println("The moment you finish vomiting you gather the strength to return to the lobby.");

                } else if (num.equals("2")) {
                    System.out.println("You reach for the sandwich wrapped in cling film on the countertop.");
                    System.out.println("In the process you knock over numerous pots and pans, making a loud clang");
                    System.out.println("You quickly eat the sandwich, unaware of what is coming");
                    player.changeHealth(30);
                    System.out.println("Following the loud sound, zombies rush into the kitchen");
                    if (player.weapons.isEmpty()){
                        System.out.println("You are unable to fight back, and are mauled to death by the zombies");
                        player.changeHealth(-100); //We need a method to kill the player
                    } else {
                        System.out.println("You are able to fight the zombies back with the first item you could find in your pocket");
                        System.out.println("You use the" + player.weapons.get(0));
                        //Methods to use weapons on the zombie
                        System.out.println("This wounds the zombies enough. You rush back to a corner in the lobby of the house.");
                    }

                } else {
                    System.out.println("You decide that escaping is more important than eating food.");
                    System.out.println("You end up returning to the Tyler Lobby where you faint from a lack of food.");
                    System.out.println("You're knocked out cold");
                    player.changeHealth(-50);
                }
            }
            case "b" -> {
                System.out.println("You observe the salad bar, and there is absolutely nothing apart from the salad dressings and crackers.");
                System.out.println("Being extremely hungry, you end up eating the crackers with blue cheese dressing.");
                System.out.println("Although not the best, the food is enough sustinence (+11 Health)");
                player.changeHealth(11);
            }
            default -> {
                System.out.println("You are extremely famished and end up fainting.");
                System.out.println("Your body gets impaled by a stray chair leg. You immediately die.");
                player.changeHealth(-100);
                System.out.println("ENDING: Death because you couldn't choose");
            }
        }
    }


    // Basement Path
    private void exploreTylerBasement (Player player, Scanner input){
        System.out.println("You go down the eerie staircase to the basement....");
        System.out.println("Each step screeches as you descend upon it.");
        System.out.println("You can hear low rumbles of noise from the laundry and trunk rooms...");

        System.out.println("Do you:");
        System.out.println("a) Explore the Laundry Room?");
        System.out.println("b) Explore the trunk room?");

        System.out.print("Your choice? (a/b)");
        String action = input.nextLine().toLowerCase();

        switch (action) {
            case "a" -> {
                System.out.println("You creep into the laundry machine and suddenly realize that the noises were not from the machines...");
                System.out.println("IT WAS ZOMBIES");
                System.out.println("QUICK! Do you...");
                System.out.println("HIDE");
                System.out.println("RUN");
                System.out.println("Type in your choice...");
                String user_answer = input.nextLine();
                user_answer.toLowerCase();
                if (user_answer.equals("hide")){
                    System.out.println("You hide behind a laundry machine and let the zombies pass");
                    System.out.println("Then you run up the stairs back into the lobby.");
                }
                else if (user_answer.equals("run")){
                    System.out.println("You immediately make a run for it out of the laundry room.");
                    System.out.println("Whilst running you slip on some laundry detergent and break your chin. (-50 health) ");
                    player.changeHealth(-50);
                    if (player.weapons.isEmpty()){
                        System.out.println("You keep running but you bleed some more (-13 Health)");
                        player.changeHealth(-13);
                    } else {
                        System.out.println("One of your weapons falls out of your pocket. Too bad.");
                        String current_weapon = player.weapons.get(0);
                        player.removeWeapon(current_weapon);
                    }
                    System.out.println("You make it back to the lobby panting, deciding what to do next.");
                }
            }
            case "b" -> {
                System.out.println("You enter the trunk rooms, millions of plastic containers are infront of you.");
                System.out.println("You spot something shiny on the shelf...");
                System.out.println("You near the shelf...");
                System.out.println("Do you take the shiny object? YES/NO");
                String answer = input.nextLine();
                answer.toLowerCase();
                if (answer.equals("yes")) {
                    System.out.println("You collect the shiny pocket knife!");
                    player.addWeapon("Pocket Knife");
                    System.out.println("It gives you a tiny paper cut (-15 Health) ");
                    player.changeHealth(-15);
                    System.out.println("You make your way to the lobby with haste");
                }
                else {
                    System.out.println("You return back upstairs, empty handed.");
                }
            }
            default -> {
                System.out.println("You remain frozen in the basement hallway");
                System.out.println("Whilst you observe the rats darting across the hall, a spider crawls down from the ceiling & bites you.");
                player.changeHealth(-100);
                System.out.println("ENDING: Death by Spider Bite");
            }
        }
    }
}




