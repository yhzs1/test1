import greenfoot.*;
import java.awt.*;
/**
 * Write a description of class Return here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Return extends Menu
{
    /**
     * Act - do whatever the Return wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final Color transparent = new Color(255, 255, 255, 0);
    public Return()
    {
        GreenfootImage image = new GreenfootImage("Press      here      to      return  ",40,Color.white,transparent);
            setImage(image);
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new StartInterface());
        }
    }    
}
