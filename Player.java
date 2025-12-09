import java.util.ArrayList;

public class Player {
    private String name;
    private int health;
    ArrayList<String> weapons;

    public Player(String name, int startingHealth) {
        this.name = name;
        this.health = startingHealth;
        this.weapons = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public void changeHealth(int change) {
        this.health += change;
        if (this.health < 0) {
            this.health = 0;
        }
        if (this.health > 100) {
            this.health = 100;
        }
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public void addWeapon(String weapon){
        weapon.toLowerCase();
        this.weapons.add(weapon);
    }

    public void removeWeapon(String weapon){
        if (weapons.contains(weapon)){
            this.weapons.remove(weapon);
        } else {
            System.out.println("This weapon cannot be removed");
        }
    }
}
