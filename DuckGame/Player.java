import greenfoot.*;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        edgeCheck();
    }    
    
    //掉出边界
    public void edgeCheck(){
        if(getY() >= getWorld().getHeight() - 200)
            //setLocation(getX(),100);
            getWorld().showText("sds",100,100);
    }
}
