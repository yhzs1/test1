import greenfoot.*;

/**
 * Write a description of class Rifle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bazooka extends Gun
{
    /**
     * Act - do whatever the Rifle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int G3=0;//判断P_1是否拿枪
    public static int G4=0;//判断P_2是否拿枪
    public static boolean B3=false;//判断P_1是否可以发射子弹
    public static boolean B4=false;//判断P_2是否可以发射子弹
    public static int Grole=-1;
    public void act() 
    {
        isTurnAd();
        IsHaveGun();
        
    }


    public void isTurnAd()
    {
        if(P_1.Turn==1&&G3==1)
        {
            setImage("bazooka2.png");
        }
        else if(P_2.Turn2==1&&G4==1)
        {
            setImage("bazooka2.png");
        }
        if(P_1.Turn==2&&G3==1)
        {
            setImage("bazooka.png");
        }
        else if(P_2.Turn2==2&&G4==1)
        {
            setImage("bazooka.png");
        }
    }
    public void IsHaveGun()
    {
        //拿枪的动作及发射子弹
        if(Greenfoot.isKeyDown("e")&& Rifle.G1==0 && G3==0 && Rocket.G5==0 && Staff.G7==0 &&Darts.G9==0 && !B4){
            P_1 p1 = (P_1)(getWorld().getObjects(P_1.class).get(0));
            if (p1.getX()>=getX()-15&&p1.getX()<=getX()+15&&p1.getY()<=getY()+40&&p1.getY()>=getY()-40)
            {
                G3=1;     
                B3=true;
            }
        }
        else if(Greenfoot.isKeyDown("1") && Rifle.G2==0 && G4==0 && Rocket.G6==0 && Staff.G8==0 &&Darts.G10==0 && !B3){
            P_2 p2 = (P_2)(getWorld().getObjects(P_2.class).get(0));
            if (p2.getX()>=getX()-15&&p2.getX()<=getX()+15&&p2.getY()<=getY()+40&&p2.getY()>=getY()-40)
            {
                G4=1;     
                B4=true;
            }            

        }

        if(Greenfoot.isKeyDown("r")&&B3){
            P_1 p1 = (P_1)(getWorld().getObjects(P_1.class).get(0));
            if (p1.getX()==getX()||p1.getY()==getY())
            {
                G3=2;  
                B3=false;
            }
        }
        if(Greenfoot.isKeyDown("2")&&B4){
            P_2 p2 = (P_2)(getWorld().getObjects(P_2.class).get(0));
            if (p2.getX()==getX()||p2.getY()==getY())
            {
                G4=2;  
                B4=false;
            }
        }        
        if(G3==1)
        {
            P_1 p1 = (P_1)(getWorld().getObjects(P_1.class).get(0));
            setLocation(p1.getX(),p1.getY()+12);
        }
        else if(G3==2)
        {
            P_1.number=0;
            G3=0;
            //getWorld().removeObject(this);
            setLocation(getX(),getY()+15);
        }
        if(G4==1)
        {
            P_2 p2 = (P_2)(getWorld().getObjects(P_2.class).get(0));
            setLocation(p2.getX(),p2.getY()+12);
        }
        else if(G4==2)
        {
            P_2.number2=0;
            G4=0;
            //getWorld().removeObject(this);
            setLocation(getX(),getY()+15);
        }
    }
}    
