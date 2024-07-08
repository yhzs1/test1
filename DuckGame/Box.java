import greenfoot.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Write a description of class Box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Box extends Actor
{
    /**
     * Act - do whatever the Box wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static boolean Box1=true;
    public static int BoxHP=200;
    private int count=0;     //计数
    private int Maxcount=20; //最大放射子弹速度
    private int m=0; //调整角度
    private int Y1=1; //行走的方向
    private int K;
    public Box()
    {
        getImage().scale(50,50);
    }

    public void act() 
    {
        isShoot();
        if(BoxHP<=0)
        {
            shoot();
            randomMove();
        }
    }    

    public void isShoot(){ //箱子的血条
        if(isTouching(Prop.class)&&Box1)
        {
            removeTouching(Prop.class);           
            BoxHP-=20;
        }

        if(isTouching(BazooProp.class)&&Box1)
        {
            removeTouching(BazooProp.class);
            BoxHP-=40;
        }

        if(isTouching(Shell.class)&&Box1)
        {
            removeTouching(Shell.class);
            BoxHP-=20;
        }

        if(isTouching(Orb.class)&&Box1)
        {
            removeTouching(Orb.class);
            BoxHP-=20;
        }
        if(isTouching(Dart.class)&&Box1)
        {
            removeTouching(Dart.class);
            BoxHP-=20;
        }
        if(BoxHP<=0)
        {
            Box1=false;
            setImage("baoxiang2.png");

        }    
    }

    public void shoot(){ //箱子发射子弹
        if(count == Maxcount)
        {
            Prop2 prop2 = new Prop2();
            prop2.setRotation(m);
            getWorld().addObject(prop2,getX(),getY()+12);
            m+=45;   
            count=0;
        }
        else count++;
    }

    public void randomMove(){ //箱子的移动
            int deg2=Greenfoot.getRandomNumber(2);
            if(deg2==0)
            {
                    setLocation(getX()-1,getY());
            }
            else if(deg2==1)
            {
                    setLocation(getX()+1,getY());
            }
        setLocation(getX(),getY()+Y1);
        if(isAtEdge())
        {
            Y1*=-1;
            setLocation(getX(),getY()+Y1);
        }
    }
}
