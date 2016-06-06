import java.util.Scanner;

/**
 * Describes player and player stats
 */
public class Player
{
    private int lvl;
    private int attack;
    private int hp;
    private String playername;
    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        lvl=1;
        attack= (int)(Math.pow(2.0,(double)lvl));
        hp=75+(25*lvl);
        System.out.println("What is your character's name?");
        Scanner ev = new Scanner(System.in);
        playername = ev.next();

        
    }
    
    /*
     * Updates stats in case of a "level up"
     */
    public void levelUp()
    {
        System.out.println("You've leveled up! You are now level "+ ++lvl);
        lvl++;
        attack= (int)(Math.pow(2.0,(double)lvl));
        hp=75+(25*lvl);
        System.out.println("Your new stats read:");
        System.out.println("Attack: "+ attack);
        System.out.println("HP: "+hp);
    }
    /*
     * Returns player level.
     */
    public int getLvl()
    {
        return lvl;
    }
     /*
     * Returns player health.
     */
    public int getHP()
    {
        return hp;
    }
    /*
     * Returns player attack.
     */
    public int getAttack()
    {
        return attack;
    }
}
