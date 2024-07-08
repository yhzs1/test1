import greenfoot.*;
import java.util.List;
/**
 * Write a description of class Prop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Prop2 extends Bullet
{
    /**
     * Act - do whatever the Prop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int ddr = 0;
    private boolean Pro=false;
    public Prop2(){
        
    }

    public void act() 
    {       
        move(5);
        isTouch();
    }    

    public void isTouch()
    {
        GameWorld space = (GameWorld) getWorld();
        if (space.getObjects(Live_2.class).size()>0&&space.getObjects(Live_1.class).size()>0 ){
            if(isTouching(Box.class))
            {
                removeTouching(Prop.class);
            }
            else if(isTouching(P_2.class)){
                
                List<Live_2> lives2 = space.getObjects(Live_2.class);
                Live_2 live2 = new Live_2();
                space.removeObject(lives2.get(0));
                getWorld().removeObject(this);
            }
            else if(isTouching(P_1.class)){
                
                List<Live_1> lives1 = space.getObjects(Live_1.class);
                Live_1 live1 = new Live_1();
                space.removeObject(lives1.get(0));
                getWorld().removeObject(this);
            }
            else if(isAtEdge())
            {
                getWorld().removeObject(this);
            }
        }
    }
}
