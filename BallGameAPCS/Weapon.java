import java.util.ArrayList;
import java.util.Arrays;

/**
 * weapons
 */
public class Weapon {
    private int damage;
    /**
     * Constructor for objects of class weapon
     */
    public Weapon(int dmg) {
        damage =  dmg; //needs to account for player damage
    }
    /**
     * Returns damage
     */
    public int getDamage() {
        return damage;
    }
}