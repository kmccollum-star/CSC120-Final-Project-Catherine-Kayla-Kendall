import java.util.Scanner;

public class Game {
    private Player player;
    private Scanner input;
    private Building [] route;

    public Game() {
        this.input = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to Escape Smith: Zombie Apocalypse");
        System.out.println("What is your name? ");
        String name = input.nextLine();

        this.player = new Player(name, 100);
        System.out.println("Hi! " + player.getName() + "!");
        System.out.println("Your starting health is: " + player.getHealth());
        System.out.println();

        this.route = new Building[] {
            new AinsworthGym(),
            new Tyler()
            // new SeelyeHall()
            // new SmithArtMuseum
        };

        for (Building b : route) {
            if (player.isAlive() == false) {
                System.out.println("You have died, you did not survive long enough to continue");
                break;
            }
            b.intro(player);
            b.play(player, input);
        }

        System.out.println("Game over!");
        System.out.println("Final health: " + player.getHealth());
        System.out.println("Thanks for playing, " + player.getName());
        input.close();
    } 

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
    
}