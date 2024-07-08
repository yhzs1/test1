import greenfoot.*;
import java.awt.*;
/**
 * Write a description of class Introducation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Introducation extends Menu
{
    /**
     * Act - do whatever the Introducation wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final Color transparent = new Color(255, 255, 255, 0);
    public Introducation()
    {
           GreenfootImage image = new GreenfootImage("How to play",25,Color.white,transparent);
            setImage(image);    
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new ItroducationPlay());
        }
    }    
}
