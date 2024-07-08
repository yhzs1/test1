import greenfoot.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    public static int gw=1;
    ArrayList<Live_1> lives1 = new ArrayList<Live_1>(); //保存生命值
    ArrayList<Live_2> lives2 = new ArrayList<Live_2>(); //保存生命值
    private boolean T = true;
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 650, 1);
        addObject(new Music(), 0, 0);
        stop();
    }
    
    public void addLive_1(){
        for(int k=0;k<3 ; k++){
            Live_1 live_1 = new Live_1();
            int x = 50+22*k;
            addObject(live_1,x ,getHeight() - 20);
            lives1.add(live_1);
        }
    }

    public void addLive_2(){
        for(int k=0;k<3 ; k++){
            Live_2 live_2 = new Live_2();
            int x = 950-22*k;
            addObject(live_2,x ,getHeight() - 20);
            lives2.add(live_2);
        }
    }
    
    public void gameOver(){
        Greenfoot.stop();  //游戏停止
    }

    public void stop(){
        Rifle.G1=0;
        Rifle.G2=0;
        Bazooka.G3=0;
        Bazooka.G4=0;
        Rifle.B1=false;
        Rifle.B2=false;
        Bazooka.B3=false;
        Bazooka.B4=false;
        Rocket.G5=0;
        Rocket.G6=0;
        Rocket.B5=false;
        Rocket.B6=false;
        Staff.G7=0;
        Staff.G8=0;
        Staff.B7=false;
        Staff.B8=false;
        Darts.G9=0;
        Darts.G10=0;
        Darts.B9=false;
        Darts.B10=false;
        P_1.number=0;
        P_2.number2=0;
        Box.Box1=true;
        Box.BoxHP=200;
    }
    public void stopped(){
        Music.screenmusic.stop();
    }
}
