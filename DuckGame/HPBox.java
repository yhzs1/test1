import greenfoot.*;
import java.awt.Color;
import java.util.List;
/**
 * Write a description of class HPBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HPBox extends Actor
{
    /**
     * Act - do whatever the HPBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage box;
    public HPBox(){
        box = new GreenfootImage(200,20);
        box.setColor(Color.RED);
        box.fillRect(0,0,200,20);
        setImage(box);            
    }

    public void act() 
    {
        if(Box.BoxHP>0){
            box = new GreenfootImage(Box.BoxHP,20);
        box.setColor(Color.RED);
        box.fillRect(0,0,Box.BoxHP,20);
        setImage(box);    
    }
        else if(Box.BoxHP<=0)
            getWorld().removeObject(this);
    }
}
