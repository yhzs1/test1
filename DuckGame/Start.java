import greenfoot.*;
import java.awt.*;
/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Menu
{
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final Color transparent = new Color(255, 255, 255, 0);
    public Start()
    {
        GreenfootImage image = new GreenfootImage("Press      here      to      sduck  !  !",40,Color.white,transparent);
            setImage(image);
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new RW1());
            Greenfoot.delay(30);
            Greenfoot.setWorld(new GW1());
        }
    }    
}
