
/**
 *Describes an enemy
 */
public class Enemy
{
    private int lvl;
    private int attack;
    private int hp;
    private String name;
    /**
     * Constructor for objects of class Player
     */
    public Enemy(String eName, int elvl)
    {
        lvl=elvl;
        name=eName;
        attack= 2*lvl;
        hp=25+(lvl);
    }
    /*
     * Updates stats in case of a "level up"
     */
    public int getExp()
    {
        int exp = lvl;
        System.out.println("You've beaten the level " + lvl + name + "!");
        System.out.println("You got " +exp+ "experience from this battle");
        return exp;
    }
    /*
     * Returns Enemy level.
     */
    public int getLvl()
    {
        return lvl;
    }
    public void setHp(int newHp)
    {
        hp=newHp;
    }
     /*
     * Returns Enemy health.
     */
    public int getHp()
    {
        return hp;
    }
    /*
     * Returns Enemy attack.
     */
    public int getAttack()
    {
        return attack;
    }
}
