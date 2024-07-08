import greenfoot.*;

/**
 * Write a description of class GW3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GW3 extends GameWorld
{

    /**
     * Constructor for objects of class GW3.
     * 
     */
    public GW3()
    {
        prepare();
        addLive_1();
        addLive_2();
    }
    private void prepare()
    {
        P_1 p_1 = new P_1();
        addObject(p_1, 60, 300);
        P_2 p_2 = new P_2();
        addObject(p_2, 940, 300);
        
        Grassland_4 grassland_1 = new Grassland_4();
        addObject(grassland_1, 95, 520);
        Grassland_4 grassland_2 = new Grassland_4();
        addObject(grassland_2, 285, 440);
        Grassland_4 grassland_3 = new Grassland_4();
        addObject(grassland_3, 905, 520);
        Grassland_4 grassland_4 = new Grassland_4();
        addObject(grassland_4, 715, 440);
        Grassland_6 grassland = new Grassland_6();
        addObject(grassland, 500, 360);
        Grassland_6 grasslanda = new Grassland_6();
        addObject(grasslanda, 220, 280);
        Grassland_6 grasslandb = new Grassland_6();
        addObject(grasslandb, 780, 280);
        
        Grassland_5 grassland1 = new Grassland_5();
        addObject(grassland1, 95, 593);
        Grassland_5 grassland2 = new Grassland_5();
        addObject(grassland2, 285, 593);
        Grassland_5 grassland3 = new Grassland_5();
        addObject(grassland3, 285, 513);
        Grassland_5 grassland4 = new Grassland_5();
        addObject(grassland4, 500, 593);
        Grassland_5 grassland5 = new Grassland_5();
        addObject(grassland5, 500, 493);
        Grassland_5 grassland6 = new Grassland_5();
        addObject(grassland6, 500, 431);
        Grassland_5 grassland7 = new Grassland_5();
        addObject(grassland7, 905, 593);
        Grassland_5 grassland8 = new Grassland_5();
        addObject(grassland8, 715, 593);
        Grassland_5 grassland9 = new Grassland_5();
        addObject(grassland9, 715, 513);
        
        Box box = new Box();
        addObject(box, 504, 325);
        HPBox hpbox = new HPBox();
        addObject(hpbox, 504, 285);
        
        WeaponPlace weaponplace = new WeaponPlace();
        addObject(weaponplace, 285, 420);
        Circle circle = new Circle();
        addObject(circle, 275, 400);
        Circle circle2 = new Circle();
        addObject(circle2, 295, 400);
      
        WeaponPlace weaponplace2 = new WeaponPlace();
        addObject(weaponplace2, 715, 420);
        Circle circle3 = new Circle();
        addObject(circle3, 705, 400);
        Circle circle4 = new Circle();
        addObject(circle4, 725, 400);
        setPaintOrder(P_1.class);
        setPaintOrder(P_2.class);
        setPaintOrder(Rifle.class);
        setPaintOrder(Circle.class);
         int deg;
        deg=Greenfoot.getRandomNumber(5);
        switch(deg){
            case 0:addObject(new Rifle(), 285, 400);break;
            case 1:addObject(new Bazooka(), 285, 400);break;
            case 2:addObject(new Staff(), 285, 400);break;
            case 3:addObject(new Rocket(), 285, 400);break;
             case 4:addObject(new Darts(), 285, 400);break;
        }
        int deg2;
        deg2=Greenfoot.getRandomNumber(4);
        if(deg==0){
            switch(deg2){
                case 0:addObject(new Bazooka(), 715, 400);break;
                case 1:addObject(new Staff(), 715, 400);break;
                case 2:addObject(new Rocket(), 715, 400);break;
                case 3:addObject(new Darts(), 715, 400);break;                
            }
        }             
        else if(deg==1)
            switch(deg2){
                case 0:addObject(new Rifle(), 715, 400);break;
                case 1:addObject(new Staff(), 715, 400);break;
                case 2:addObject(new Rocket(), 715, 400);break;
                case 3:addObject(new Darts(), 715, 400);break;
        }   
        else if(deg==3)
            switch(deg2){
                case 0:addObject(new Rifle(), 715, 400);break;
                case 1:addObject(new Bazooka(), 715, 400);break;
                case 2:addObject(new Staff(), 715, 400);break;
                case 3:addObject(new Darts(), 715, 400);break;
        }
        else if(deg==2)
            switch(deg2){
                case 0:addObject(new Rifle(), 715, 400);break;
                case 1:addObject(new Bazooka(), 715, 400);break;
                case 2:addObject(new Rocket(), 715, 400);break;
                case 3:addObject(new Darts(), 715, 400);break;
        }  
        else if(deg==4)
            switch(deg2){
            case 0:addObject(new Rifle(), 715, 400);break;
            case 1:addObject(new Bazooka(), 715, 400);break;
            case 2:addObject(new Staff(), 715, 400);break;
            case 3:addObject(new Rocket(), 715, 400);break;
        }  
    }
}
