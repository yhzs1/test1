import greenfoot.*;

/**
 * Write a description of class Rifle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rifle extends Gun
{
    /**
     * Act - do whatever the Rifle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int G1=0;//判断P_1是否拿枪
    public static int G2=0;//判断P_2是否拿枪
    public static boolean B1=false;//判断P_1是否可以发射子弹
    public static boolean B2=false;//判断P_2是否可以发射子弹
    public static boolean D1=true;//防止多次进行判断，导致路过同样的武器进行pick操作
    public char D2;
    public void act() 
    {
        isTurnAd();
        IsHaveGun();
    }

    public void isTurnAd()
    {
        P_1 p1 = (P_1)(getWorld().getObjects(P_1.class).get(0));
        P_2 p2 = (P_2)(getWorld().getObjects(P_2.class).get(0));
        if(P_1.Turn==1&&G1==1)
        {
            setImage("highPowerRifle-.png");
        }
        else if(P_2.Turn2==1)
        {
            setImage("highPowerRifle-.png");
        }
        if(P_1.Turn==2&&G1==1)
        {
            setImage("highPowerRifle.png");
        }
        else if(P_2.Turn2==2&&G2==1)
        {
            setImage("highPowerRifle.png");
        }
    }

    public void IsHaveGun()
    {
        //拿枪的动作及发射子弹
        if(Greenfoot.isKeyDown("e")&& G1==0&& Darts.G9==0 && Bazooka.G3==0 && Rocket.G5==0 && Staff.G7==0 &&!B2){
            P_1 p1 = (P_1)(getWorld().getObjects(P_1.class).get(0));
            if (p1.getX()>=getX()-15&&p1.getX()<=getX()+15&&p1.getY()<=getY()+40&&p1.getY()>=getY()-40)
            {
                G1=1;     
                B1=true; //可以发射子弹，且表示角色一拿了这把武器
                D2='e';
            }
        }
        else if(Greenfoot.isKeyDown("1") && G2==0 && Darts.G10==0 && Bazooka.G4==0 && Rocket.G6==0 && Staff.G8==0 &&!B1){
            P_2 p2 = (P_2)(getWorld().getObjects(P_2.class).get(0));
            if (p2.getX()>=getX()-15&&p2.getX()<=getX()+15&&p2.getY()<=getY()+40&&p2.getY()>=getY()-40)
            {
                G2=1;     
                B2=true; //可以发射子弹，且表示角色二拿了这把武器
            }            
        }

        if(Greenfoot.isKeyDown("r")&&B1){
            P_1 p1 = (P_1)(getWorld().getObjects(P_1.class).get(0));
            if (p1.getX()==getX()||p1.getY()==getY())
            {
                G1=2;  
                B1=false;
            }
        }
        if(Greenfoot.isKeyDown("2")&&B2){
            P_2 p2 = (P_2)(getWorld().getObjects(P_2.class).get(0));
            if (p2.getX()==getX()||p2.getY()==getY())
            {
                G2=2;  
                B2=false;
            }
        }  
        if(G1==1)
        {
            P_1 p1 = (P_1)(getWorld().getObjects(P_1.class).get(0));
            setLocation(p1.getX(),p1.getY()+12);          
        }
        else if(G1==2)
        {
            G1=0;
            P_1.number=0;
           // getWorld().removeObject(this);
            setLocation(getX(),getY()+15);
        }
        if(G2==1)
        {
            P_2 p2 = (P_2)(getWorld().getObjects(P_2.class).get(0));
            setLocation(p2.getX(),p2.getY()+12);
        }        
        else if(G2==2)
        {
            G2=0;
            P_2.number2=0;
            //getWorld().removeObject(this);
            setLocation(getX(),getY()+15);
        }
    }
}    
