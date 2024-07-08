import greenfoot.*;

/**
 * Write a description of class end here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End extends Menu
{
    /**
     * Act - do whatever the end wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new StartInterface());
        }
    }    
}
