import greenfoot.*;

/**
 * Write a description of class Rifle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Staff extends Gun
{
    /**
     * Act - do whatever the Rifle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int G7=0;//判断P_1是否拿枪
    public static int G8=0;//判断P_2是否拿枪
    public static boolean B7=false;//判断P_1是否可以发射子弹
    public static boolean B8=false;//判断P_2是否可以发射子弹
    public static boolean D1=true;//防止多次进行判断，导致路过同样的武器进行pick操作
    public Staff()
    {
        getImage().scale(70,18);
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
        if(P_1.Turn==1&&G7==1)
        {
            if (p1.number<10 && p1.dr<0)
            {
                setImage("staff2.png");
                getImage().scale(70,18);
            }
            else if(p1.number==10)  
            {
                setImage("staff3.png");
                getImage().scale(18,70);
            }
        }
        else if(P_2.Turn2==1&&G8==1)
        {
            if (p2.number2<10 && p2.dr<0)
            {
                setImage("staff2.png");
                getImage().scale(70,18);
            }
            else if(p2.number2==10)  
            {
                setImage("staff3.png");
                getImage().scale(18,70);
            }
        }
        if(P_1.Turn==2&&G7==1)
        {
            if (p1.number<10 && p1.dr>0)
            {
                setImage("staff.png");
                getImage().scale(70,18);
            }
            else if(p1.number==10)  
            {
                setImage("staff3.png");
                getImage().scale(18,70);
            }
        }
        else if(P_2.Turn2==2&&G8==1)
        {
            if (p2.number2<10 && p2.dr>0)
            {
                setImage("staff.png");
                getImage().scale(70,18);
            }
            else if(p2.number2==10)  
            {
                setImage("staff3.png");
                getImage().scale(18,70);
            }
        }
    }

    public void IsHaveGun()
    {
        //拿枪的动作及发射子弹
        if(Greenfoot.isKeyDown("e")&& G7==0 && Bazooka.G3==0 && Rifle.G1==0 && Rocket.G5==0 && Darts.G9==0 && !B8){
            P_1 p1 = (P_1)(getWorld().getObjects(P_1.class).get(0));
            if (p1.getX()>=getX()-15&&p1.getX()<=getX()+15&&p1.getY()<=getY()+40&&p1.getY()>=getY()-40)
            {
                G7=1;     
                B7=true;
            }
        }
        else if(Greenfoot.isKeyDown("1") && G8==0 && Bazooka.G4==0 && Rifle.G2==0 && Rocket.G6==0 && Darts.G10==0&& !B7){
            P_2 p2 = (P_2)(getWorld().getObjects(P_2.class).get(0));
            if (p2.getX()>=getX()-15&&p2.getX()<=getX()+15&&p2.getY()<=getY()+40&&p2.getY()>=getY()-40)
            {
                G8=1;     
                B8=true;
            }            
        }

        if(Greenfoot.isKeyDown("r")&&B7){
            P_1 p1 = (P_1)(getWorld().getObjects(P_1.class).get(0));
            if (p1.getX()==getX()||p1.getY()==getY())
            {
                G7=2;  
                B7=false;
            }
        }
        if(Greenfoot.isKeyDown("2")&&B8){
            P_2 p2 = (P_2)(getWorld().getObjects(P_2.class).get(0));
            if (p2.getX()==getX()||p2.getY()==getY())
            {
                G8=2;  
                B8=false;        
            }
        }  
        if(G7==1)
        {
            P_1 p1 = (P_1)(getWorld().getObjects(P_1.class).get(0));
            setLocation(p1.getX(),p1.getY()+12);          
        }
        else if(G7==2)
        {
            P_1.number=0;
            G7=0;
            //getWorld().removeObject(this);
            setLocation(getX(),getY()+15);
        }
        
        if(G8==1)
        {
            P_2 p2 = (P_2)(getWorld().getObjects(P_2.class).get(0));
            setLocation(p2.getX(),p2.getY()+12);
        }
        else if(G8==2)
        {
            P_2.number2=0;
            G8=0;
            //getWorld().removeObject(this);
           setLocation(getX(),getY()+15);
        }
    }


}    
