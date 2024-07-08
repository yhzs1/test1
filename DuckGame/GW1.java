import greenfoot.*;  // （World、Actor、GreenfootImage、GreenfootSound、Greenfoot及MouseInfo）
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Write a description of class GW1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GW1 extends GameWorld
{
    /**
     * Constructor for objects of class GW1.
     * 
     */

    public GW1()
    {    
        prepare();
        addLive_1();
        addLive_2();
        P_2.victorysum2=0;
        P_1.victorysum1=0;
    }
    public void act(){
    }

    /**
     * 开始前先为你的剧本创建场景
     * 添加元件到你的场景
     */
    private void prepare()
    {
        P_1 p_1 = new P_1();
        addObject(p_1, 60, 300);
        P_2 p_2 = new P_2();
        addObject(p_2, 940, 300);

        Grassland_1 grassland_1 = new Grassland_1();
        addObject(grassland_1, 820, 420);
        Grassland_1 grassland_2 = new Grassland_1();
        addObject(grassland_2, 180, 420);
        Grassland_1 grassland_3 = new Grassland_1();
        addObject(grassland_3, 500, 290);

        Box box = new Box();
        addObject(box, 504, 240);
        HPBox hpbox = new HPBox();
        addObject(hpbox, 504, 200);

        WeaponPlace weaponplace = new WeaponPlace();
        addObject(weaponplace, 274, 392);
        Circle circle = new Circle();
        addObject(circle, 256, 369);
        Circle circle2 = new Circle();
        addObject(circle2, 289, 369);

        WeaponPlace weaponplace2 = new WeaponPlace();
        addObject(weaponplace2, 731, 392);
        Circle circle3 = new Circle();
        addObject(circle3, 715, 369);
        Circle circle4 = new Circle();
        addObject(circle4, 745, 369);
        setPaintOrder(P_1.class);
        setPaintOrder(P_2.class);
        setPaintOrder(Rifle.class);
        setPaintOrder(Circle.class);
        int deg;//记录第一把生成的武器
        deg=Greenfoot.getRandomNumber(5);
        switch(deg){
            case 0:addObject(new Rifle(), 275, 369);break;
            case 1:addObject(new Bazooka(), 275, 369);break;
            case 2:addObject(new Staff(), 275, 369);break;
            case 3:addObject(new Rocket(), 275, 369);break;
            case 4:addObject(new Darts(), 275, 369);break;
        }
        int deg2;//记录第二把生成的武器
        deg2=Greenfoot.getRandomNumber(4);
        if(deg==0){ //防止与第一把生成的武器相同
            switch(deg2){
                case 0:addObject(new Bazooka(), 730, 369);break;
                case 1:addObject(new Staff(), 730, 369);break;
                case 2:addObject(new Rocket(), 730, 369);break;
                case 3:addObject(new Darts(), 730, 369);break;
            }
        }             
        else if(deg==1)
            switch(deg2){
                case 0:addObject(new Rifle(), 730, 369);break;
                case 1:addObject(new Staff(), 730, 369);break;
                case 2:addObject(new Rocket(), 730, 369);break;
                case 3:addObject(new Darts(), 730, 369);break;
        }   
        else if(deg==3)
            switch(deg2){
                case 0:addObject(new Rifle(), 730, 369);break;
                case 1:addObject(new Bazooka(), 730, 369);break;
                case 2:addObject(new Staff(), 730, 369);break;
                case 3:addObject(new Darts(), 730, 369);break;
        }
        else if(deg==2)
            switch(deg2){
                case 0:addObject(new Rifle(), 730, 369);break;
                case 1:addObject(new Bazooka(), 730, 369);break;
                case 2:addObject(new Rocket(), 730, 369);break;
                case 3:addObject(new Darts(), 730, 369);break;
        }  
        else if(deg==4)
            switch(deg2){
                case 0:addObject(new Rifle(), 730, 369);break;
                case 1:addObject(new Bazooka(), 730, 369);break;
                case 2:addObject(new Staff(), 730, 369);break;
                case 3:addObject(new Rocket(), 730, 369);break;
        }  
    }
}
