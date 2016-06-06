
/**
 * Describes Boss and player stats
 */
public class Player
{
    private int lvl;
    private int attack;
    private int hp;
    private String name;
    private int exp;
    /**
     * Constructor for objects of class Player
     */
    public Player(String bName, int plvl)
    {
        lvl=((plvl/10)+1)*10;
        attack= (int)(Math.pow(2.0,(double)lvl));
        hp=75+(25*lvl);
        
    }
    /*
     * Returns exp
     */
    public int getExp()
    {
        return 5*lvl;
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
