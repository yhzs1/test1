import greenfoot.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Write a description of class GW2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GW2 extends GameWorld
{
    
    /**
     * Constructor for objects of class GW2.
     * 
     */
    public GW2()
    {
        prepare();
        addLive_1();
        addLive_2();
    }
    
    private void prepare()
    {
        P_1 p_1 = new P_1();
        addObject(p_1, 135, 400);
        P_2 p_2 = new P_2();
        addObject(p_2, 875, 400);
        
        Grassland_2 grassland_1 = new Grassland_2();
        addObject(grassland_1, 765, 220);
        Grassland_2 grassland_2 = new Grassland_2();
        addObject(grassland_2, 245, 220);
        Grassland_2 grassland_3 = new Grassland_2();
        addObject(grassland_3, 500, 375);
        Grassland_2 grassland_4 = new Grassland_2();
        addObject(grassland_4, 245, 520);
        Grassland_2 grassland_5 = new Grassland_2();
        addObject(grassland_5, 765, 520);
        
        Grassland_3 grassland1 = new Grassland_3();
        addObject(grassland1, 35, 360);
        Grassland_3 grassland2 = new Grassland_3();
        addObject(grassland2, 970, 360);
        
        WeaponPlace weaponplace = new WeaponPlace();
        addObject(weaponplace, 220, 490);
        Circle circle = new Circle();
        addObject(circle, 200, 470);
        Circle circle2 = new Circle();
        addObject(circle2, 240, 470);
        
        WeaponPlace weaponplace2 = new WeaponPlace();
        addObject(weaponplace2, 780, 490);
        Circle circle3 = new Circle();
        addObject(circle3, 760, 470);
        Circle circle4 = new Circle();
        addObject(circle4, 800, 470);
        setPaintOrder(Rifle.class);
        setPaintOrder(Circle.class);
        int deg;
        deg=Greenfoot.getRandomNumber(5);
        switch(deg){
            case 0:addObject(new Rifle(), 220, 470);break;
            case 1:addObject(new Bazooka(), 220, 470);break;
            case 2:addObject(new Staff(), 220, 470);break;
            case 3:addObject(new Rocket(), 220, 470);break;
            case 4:addObject(new Darts(), 220, 470);break;
        }
        int deg2;
        deg2=Greenfoot.getRandomNumber(4);
        if(deg==0){
            switch(deg2){
                case 0:addObject(new Bazooka(), 780, 470);break;
                case 1:addObject(new Staff(), 780, 470);break;
                case 2:addObject(new Rocket(), 780, 470);break;
                case 3:addObject(new Darts(), 780, 470);break;
            }
        }             
        else if(deg==1)
            switch(deg2){
                case 0:addObject(new Rifle(), 780, 470);break;
                case 1:addObject(new Staff(), 780, 470);break;
                case 2:addObject(new Rocket(), 780, 470);break;
                case 3:addObject(new Darts(), 780, 470);break;
        }   
        else if(deg==3)
            switch(deg2){
                case 0:addObject(new Rifle(), 780, 470);break;
                case 1:addObject(new Bazooka(), 780, 470);break;
                case 2:addObject(new Staff(), 780, 470);break;
                case 3:addObject(new Darts(), 780, 470);break;
        }
        else if(deg==2)
            switch(deg2){
                case 0:addObject(new Rifle(), 780, 470);break;
                case 1:addObject(new Bazooka(), 780, 470);break;
                case 2:addObject(new Rocket(), 780, 470);break;
                case 3:addObject(new Darts(), 780, 470);break;
        }  
        else if(deg==4)
            switch(deg2){
            case 0:addObject(new Rifle(), 780, 470);break;
            case 1:addObject(new Bazooka(), 780, 470);break;
            case 2:addObject(new Staff(), 780, 470);break;
            case 3:addObject(new Rocket(), 780, 470);break;
        }  
    }
    
}
