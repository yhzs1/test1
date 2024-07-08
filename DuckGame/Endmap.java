import greenfoot.*;

/**
 * Write a description of class Endmap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Endmap extends GameMenu
{

    /**
     * Constructor for objects of class Endmap.
     * 
     */
    End end = new End();
    Continue continue1 = new Continue();
    private int v1;
    private int v2;
    boolean k = false;
    public Endmap()
    {
        addObject(end,74,598);
        addObject(continue1,832,598);
        v1 = P_1.victorysum1;
        v2 = P_2.victorysum2;
    }

    public void act()
    {
        checkWinner(v1,v2);
    }

    public void checkWinner(int v1,int v2){
        GameWorld.gw=-1;
        if(v1 > v2 && !k){  //P_1 win
            addObject(new P1(),437,547);
            addObject(new P2(),568,547);
            P_1.iswin = true;
            k = true;
        }else if(v1 < v2 && !k){  //P_2 win
            addObject(new P2(),437,547);
            addObject(new P1(),568,547);
            P_2.iswin = true;
            k = true;
        }
    }
}