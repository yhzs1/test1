import greenfoot.*;

/**
 * Write a description of class Rifle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Gun
{
    /**
     * Act - do whatever the Rifle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int G5=0;//判断P_1是否拿枪
    public static int G6=0;//判断P_2是否拿枪
    public static boolean B5=false;//判断P_1是否可以发射子弹
    public static boolean B6=false;//判断P_2是否可以发射子弹
    public static boolean D1=true;//防止多次进行判断，导致路过同样的武器进行pick操作
    public char D2;
    public Rocket()
    {
        getImage().scale(50,30);
    }
    public void act() 
    {
        isTurnAd();
        IsHaveGun();
    }
    
    public void isTurnAd()
    {
        P_1 p1 = (P_1)(getWorld().getObjects(P_1.class).get(0));
        P_2 p2 = (P_2)(getWorld().getObjects(P_2.class).get(0));
        if(P_1.Turn==1&&G5==1)
        {
            setImage("rocket2.png");
            getImage().scale(50,30);
        }
        else if(P_2.Turn2==1&&G6==1)
        {
            setImage("rocket2.png");
            getImage().scale(50,30);
        }
        if(P_1.Turn==2&&G5==1)
        {
            setImage("rocket.png");
            getImage().scale(50,30);
        }
        else if(P_2.Turn2==2&&G6==1)
        {
            setImage("rocket.png");
            getImage().scale(50,30);
        }
    }
    
    public void IsHaveGun()
    {
        //拿枪的动作及发射子弹
        if(Greenfoot.isKeyDown("e")&& G5==0 && Bazooka.G3==0 && Rifle.G1==0 && Staff.G7==0 && Darts.G9==0 && !B6){
            P_1 p1 = (P_1)(getWorld().getObjects(P_1.class).get(0));
            if (p1.getX()>=getX()-15&&p1.getX()<=getX()+15&&p1.getY()<=getY()+40&&p1.getY()>=getY()-40)
            {
                G5=1;     
                B5=true;
            }
        }
        else if(Greenfoot.isKeyDown("1") && G6==0 && Bazooka.G4==0 && Rifle.G2==0 && Staff.G8==0 && Darts.G10==0 && !B5){
            P_2 p2 = (P_2)(getWorld().getObjects(P_2.class).get(0));
            if (p2.getX()>=getX()-15&&p2.getX()<=getX()+15&&p2.getY()<=getY()+40&&p2.getY()>=getY()-40)
            {
                G6=1;     
                B6=true;
            }            

        }

        if(Greenfoot.isKeyDown("r")&&B5){
            P_1 p1 = (P_1)(getWorld().getObjects(P_1.class).get(0));
            if (p1.getX()==getX()||p1.getY()==getY())
            {
                G5=2;  
                B5=false;
                
            }
        }
        if(Greenfoot.isKeyDown("2")&&B6){
            P_2 p2 = (P_2)(getWorld().getObjects(P_2.class).get(0));
            if (p2.getX()==getX()||p2.getY()==getY())
            {
                G6=2;  
                B6=false;
                
            }
        }  
        if(G5==1)
        {
            P_1 p1 = (P_1)(getWorld().getObjects(P_1.class).get(0));
            setLocation(p1.getX(),p1.getY()+15);          
        }
        else if(G5==2)
        {
            P_1.number=0;
            G5=0;
            //getWorld().removeObject(this);
            setLocation(getX(),getY()+15);
        }
        if(G6==1)
        {
            P_2 p2 = (P_2)(getWorld().getObjects(P_2.class).get(0));
            setLocation(p2.getX(),p2.getY()+15);
        }
        else if(G6==2)
        {
            P_2.number2=0;
            G6=0;
            //getWorld().removeObject(this);
            setLocation(getX(),getY()+15);
        }
    }
}    
