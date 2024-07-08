import greenfoot.*;

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameMenu extends World
{

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public GameMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 650, 1); 
        addObject(new Music(), 0, 0);
    }
        public void started(){
    }
    public void stopped(){
        Music.screenmusic.stop();
    }
}
