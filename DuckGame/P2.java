import greenfoot.*;

/**
 * Write a description of class P2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P2 extends P_2
{
    /**
     * Act - do whatever the P2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean k = false;
    public void act() 
    {
        isWin();
    }    
    
    public void isWin(){
        if(iswin && getY() >= 347)
            setLocation(getX(),getY() - 5);
        else if(getY() <= 347 && !k){
            getWorld().addObject(new King(),440,100);
            k = true;
        }
        if(P_1.iswin && getY() >= 402)
            setLocation(getX(),getY() - 3);
    }
}
