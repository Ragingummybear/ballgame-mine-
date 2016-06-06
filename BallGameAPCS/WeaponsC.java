import java.util.ArrayList;
import java.util.Arrays;

/**
 * weapons
 */
public class WeaponsC {
    private int damage;
    private String weaponName;
    /**
     * Constructor for objects of class weapon
     */
    public WeaponsC(int dmg, String name) {
        damage =  dmg; //needs to account for player damage
        weaponName = name;

    }

    /**
     * Returns damage
     */
    public int getDamage() {
        return damage;
    }

    public String getWeaponName(){
        return weaponName;
    }
}