import java.awt.*;
import javax.swing.JFrame;
import java.awt.image.*;
import java.awt.event.*;
import java.util.Scanner;
/**
 *
 */
public class Startup
{  
    private int medkits=0;
    private Scanner choice;
    private Player main;
    public Startup()
    {
        choice = new Scanner(System.in);
        main = new Player("Sos");
        System.out.println("You wake up to the susurrus of a foreign forest. The rain beats down on you in a similar ");
        
      System.out.println("fashion to the way you treated meat at your old job at the butcher’s place. You reminisce over ");
      System.out.println("years long past. Years you will never get back. Then you notice the land around you and you ");
      System.out.println("are dragged back to the present. The trees are all charred and have what look like human ");
      System.out.println("remains around them. Except, the remains don’t seem quite human. They remind you of the ");
      System.out.println("eery zombies you used to watch all the time on the old tellie. You sit down in despair, confused ");
      System.out.println("at what had happened. Everything after last week seems like a blur. How quaint is all this? Isn’t ");
      System.out.println("this how all horror stories start? Only this time, it’s real. Suddenly, you feel a jolt in your brain ");
      System.out.println("and you collapse. In your head, you see a stout man in a lab coat. He screams to you,”" + main.getPlayerName() + "the ");
      System.out.println("virus… it has gotten out… I’m already infected… Please, please go to the laboratory, it will have ");
      System.out.println("the cure, it is in…AHHHHH.” Right before your eyes he transforms into one of those monsters ");
      System.out.println("that you had just seen. His once kind and rational and intelligent eyes look at you but now all ");
      System.out.println("that was left was an insatiable hunger and wild instincts to fulfill his greed. You wake up. It ");
      System.out.println("seems to be well into the night. With only the moon in sight, you decide that the only choice you ");
      System.out.println("have is to follow the man’s directions.");   
    }

    public void turn()
    {
        boolean victory =false;
        boolean died = false;
        while(victory ==false|| died==false)
        {
            System.out.println("You've entered the labratory do you want to explore or continue into the research room?");
            System.out.println("(Type 1 to explore or 2 to continue into the research room");
            int option = choice.nextInt();
            if(option==1)
            {
                died=explore();
            }
            else if(option==2)
            {
                victory = bossFight();
            }
            else
            {
                System.out.println("Invalid choice please re-enter a valid digit");
            }
        }
        if(victory=true)
        {
            System.out.println("YOU GOT THE CURE! YOU'VE SAVED THE WORLD!!!!!");
        }
        else
        {
            System.out.println("You've died and so has hope for a cure");
        }
    }

    public boolean explore() //look at google doc for more enemies
    {
        int outcome = (int)(Math.random()*7.0)+1;
        int option;
        boolean fought = false;
        if(outcome==6)
        {
            int lootChoice = (int)(Math.random()*4.0)+1;
            fought = true;
            if(lootChoice == 1)
            {
                System.out.println("You found a drawrer you open it and find a medkit.");
                ++medkits;
            }
            else if(lootChoice ==2 )
            {
                System.out.println("You found a locked box you find the key, open it and find a weapon.");
                Weapon newW = new Weapon((int)(Math.random()*5.0)+1);
                System.out.println("It has " + newW.getDamage() + "attack would you like to equip it now? (1 (yes)/ 2 (no))");
                option = choice.nextInt();
                if(option==1)
                {
                    main.equipWeapon(newW);
                }
            }
            else if(lootChoice == 3)
            {
                System.out.println("You found a locker you open it and find some clothes.");
                Armor newA = new Armor((int)(Math.random()*5.0)+1);
                System.out.println("It has " + newA.getDef() + "defense would you like to equip it now? (1 (yes)/ 2 (no))");
                option = choice.nextInt();
                if(option == 1)
                {
                    main.equipArmor(newA);
                }
            }
            return false;
        }
        else
        {
            int php=2;
            int ehp=2;
            int enemyChoice = (int)(Math.random()*4.0)+1;
            if(enemyChoice==1)
            {
                System.out.println("You encounter a mutated dog and it looks ready to fight");
                Enemy enemy = new Enemy("Mutated Dog", main.getLvl());
                int turn;
                int pdmg;
                int edmg;
                while(php>0||ehp>0)
                {
                    System.out.println("Do you attack(1) or use a medkit(2)?");
                    turn=choice.nextInt();
                    if(turn==1)
                    {
                        pdmg = (int)(Math.random()*(double)main.getAttack())+(main.getAttack()-2*main.getLvl());
                        edmg=(int)(Math.random()*(double)enemy.getAttack())+(enemy.getAttack()-2*enemy.getLvl());
                        enemy.setHp(enemy.getHp()-pdmg);
                        main.setHp(main.getHp()-edmg);
                        php=main.getHp();
                        ehp=enemy.getHp();
                        System.out.println("You have" + php + "health.");
                        System.out.println("Your enemy has" + ehp + "health.");
                    }
                    else if(turn ==2)
                    {
                        if(medkits>0)
                        {
                            System.out.println("You used a medkit");
                            main.setHp(main.getHp()+(main.getLvl()*20));
                            medkits--;
                            System.out.println("You have" + php + "health.");
                        }
                        else
                        {
                            System.out.println("You are out of medkits");
                            System.out.println("You have" + php + "health. Good luck without those health kits!");
                        }
                    }
                    else
                    {
                        System.out.println("Invalid command please try agian");
                    }
                }
                int exp=enemy.getExp();
                main.updateExp(exp);
            }
            else if(enemyChoice==2)
            {
                fought = true;
                System.out.println("You encounter a mutated human and it looks ready to fight");
                Enemy enemy = new Enemy("Mutated Human", main.getLvl()+1);
                int turn;
                int pdmg;
                int edmg;
                while(php>0||ehp>0)
                {
                    System.out.println("Do you attack(1) or use a medkit(2)?");
                    turn=choice.nextInt();
                    if(turn==1)
                    {
                        pdmg = (int)(Math.random()*(double)main.getAttack())+(main.getAttack()-2*main.getLvl());
                        edmg=(int)(Math.random()*(double)enemy.getAttack())+(enemy.getAttack()-2*enemy.getLvl());
                        enemy.setHp(enemy.getHp()-pdmg);
                        main.setHp(main.getHp()-edmg);
                        php=main.getHp();
                        ehp=enemy.getHp();
                        System.out.println("You have" + php + "health.");
                        System.out.println("Your enemy has" + ehp + "health.");
                    }
                    else if(turn ==2)
                    {
                        if(medkits>0)
                        {
                            System.out.println("You used a medkit");
                            main.setHp(main.getHp()+(main.getLvl()*20));
                            medkits--;
                            System.out.println("You have" + php + "health.");
                        }
                        else
                        {
                            System.out.println("You are out of medkits");
                            System.out.println("You have" + php + "health. Good luck without those health kits!");
                        }
                    }
                    else
                    {
                        System.out.println("Invalid command please try agian");
                    }
                }
                int exp=enemy.getExp();
                main.updateExp(exp);
            }
            else if(enemyChoice==3)
            {
                fought = true;
                System.out.println("You encounter a security bot and it looks ready to fight");
                Enemy enemy = new Enemy("Security Bot", main.getLvl());
                int turn;
                int pdmg;
                int edmg;
                while(php>0||ehp>0)
                {
                    System.out.println("Do you attack(1) or use a medkit(2)?");
                    turn=choice.nextInt();
                    if(turn==1)
                    {
                        pdmg = (int)(Math.random()*(double)main.getAttack())+(main.getAttack()-2*main.getLvl());
                        edmg=(int)(Math.random()*(double)enemy.getAttack())+(enemy.getAttack()-2*enemy.getLvl());
                        enemy.setHp(enemy.getHp()-pdmg);
                        main.setHp(main.getHp()-edmg);
                        php=main.getHp();
                        ehp=enemy.getHp();
                        System.out.println("You have" + php + "health.");
                        System.out.println("Your enemy has" + ehp + "health.");
                    }
                    else if(turn ==2)
                    {
                        if(medkits>0)
                        {
                            System.out.println("You used a medkit");
                            main.setHp(main.getHp()+(main.getLvl()*20));
                            medkits--;
                            System.out.println("You have" + php + "health.");
                        }
                        else
                        {
                            System.out.println("You are out of medkits");
                            System.out.println("You have" + php + "health. Good luck without those health kits!");
                        }
                    }
                    else
                    {
                        System.out.println("Invalid command please try agian");
                    }
                }
                int exp=enemy.getExp();
                main.updateExp(exp);
            }
            if(php<=0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public boolean bossFight()
    {
        System.out.println("There you see the serum. However something stands between you and the panacea. It's PATIENT 0 and he look reay to fight");
        Boss patient = new Boss("Patient 0",main.getLvl());
        int turn;
        int pdmg;
        int edmg;
        int php=2;
        int ehp=2;
        while(php>0||ehp>0)
        {
            System.out.println("Do you attack(1) or use a medkit(2)?");
            turn=choice.nextInt();
            if(turn==1)
            {
                pdmg = (int)(Math.random()*(double)main.getAttack())+(main.getAttack()-2*main.getLvl());
                edmg=(int)(Math.random()*(double)patient.getAttack())+(patient.getAttack()-2*patient.getLvl());
                patient.setHp(patient.getHP()-pdmg);
                main.setHp(main.getHp()-edmg);
                php=main.getHp();
                ehp=patient.getHP();
            }
            else if(turn ==2)
            {
                if(medkits>0)
                {
                    System.out.println("You used a medkit");
                    main.setHp(main.getHp()+(main.getLvl()*20));
                    medkits--;
                }
                else
                {
                    System.out.println("You are out of medkits");
                }
            }
            else
            {
                System.out.println("Invalid command please try agian");
            }
        }
        if(php==0)
        {
            System.out.println("Patient 0 was to strong for you! You fled and are now back in the labratory");
            return false;
        }
        else
        {
            return true;
        }
    }
}

