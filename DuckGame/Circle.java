import greenfoot.*;

/**
 * Write a description of class Circle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Circle extends Actor
{
    /**
     * Act - do whatever the Circle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int k=0;
    public void act() 
    {
        if(GameWorld.gw==1){
            if(getX()==256||getX()==715)
            k=1;
            else if(getX()==289||getX()==745)
            k=2;
            if(k==1)
            setLocation(getX()+1,getY());
            else if(k==2)
            setLocation(getX()-1,getY());
        }
        
        else if(GameWorld.gw==2){
            if(getX()==200||getX()==760)
            k=1;
            else if(getX()==240||getX()==800)
            k=2;
            if(k==1)
            setLocation(getX()+1,getY());
            else if(k==2)
            setLocation(getX()-1,getY());
        }
        
        else if(GameWorld.gw==3){
            if(getX()==275||getX()==705)
            k=1;
            else if(getX()==295||getX()==725)
            k=2;
            if(k==1)
            setLocation(getX()+1,getY());
            else if(k==2)
            setLocation(getX()-1,getY());
        }
    }   
    
    
}
