public class Player {
    private String name;
    private int health;

    public Player(String name, int startingHealth) {
        this.name = name;
        this.health = startingHealth;
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
}
