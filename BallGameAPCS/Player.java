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

    private String name;
    private int exp;
    private int expCap;

    /**
     * Constructor for objects of class Player
     */
    public Player(String pName)
    {
        lvl=1;
        exp=0;
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
        exp=0;
        expCap=5*lvl;
        System.out.println("Your new stats read:");
        System.out.println("Attack: "+ attack);
        System.out.println("HP: "+hp);
    }
    public void updateExp(int bexp)
    {
        exp+=bexp;
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
    
    public String getPlayerName(){
        return playername;
}
}