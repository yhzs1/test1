import greenfoot.*;

/**
 * Write a description of class King here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class King extends Menu
{
    /**
     * Act - do whatever the King wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public King(){
        getImage().scale(30,30);
    }
    public void act() 
    {
        if(getY() <= 307){
            setLocation(getX(),getY() + 5);
        }
    }    
}
