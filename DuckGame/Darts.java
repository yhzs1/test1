import greenfoot.*;

/**
 * Write a description of class Rifle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Darts extends Gun
{
    /**
     * Act - do whatever the Rifle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int G9=0;//判断P_1是否拿枪
    public static int G10=0;//判断P_2是否拿枪
    public static boolean B9=false;//判断P_1是否可以发射子弹
    public static boolean B10=false;//判断P_2是否可以发射子弹
    public static boolean D1=true;//防止多次进行判断，导致路过同样的武器进行pick操作
    public char D2;
    public Darts()
    {
        setImage("feibiao.png");
     getImage().scale(40,40);
    }
    public void act() 
    {
        IsHaveGun();

    }

    public void IsHaveGun()
    {
        //拿枪的动作及发射子弹
        if(Greenfoot.isKeyDown("e")&& G9==0 && Bazooka.G3==0 && Rifle.G1==0 && Rocket.G5==0 && Staff.G7==0 && !B10){
            P_1 p1 = (P_1)(getWorld().getObjects(P_1.class).get(0));
            if (p1.getX()>=getX()-15&&p1.getX()<=getX()+15&&p1.getY()<=getY()+40&&p1.getY()>=getY()-40)
            {
                G9=1;     
                B9=true;
                D2='e';
            }
        }
        else if(Greenfoot.isKeyDown("1") && G10==0 && Bazooka.G4==0 && Rifle.G2==0 && Rocket.G6==0 && Staff.G8==0 && !B9){
            P_2 p2 = (P_2)(getWorld().getObjects(P_2.class).get(0));
            if (p2.getX()>=getX()-15&&p2.getX()<=getX()+15&&p2.getY()<=getY()+40&&p2.getY()>=getY()-40)
            {
                G10=1;     
                B10=true;
            }            
        }

        if(Greenfoot.isKeyDown("r")&&B9){
            P_1 p1 = (P_1)(getWorld().getObjects(P_1.class).get(0));
            if (p1.getX()==getX()||p1.getY()==getY())
            {
                G9=2;  
                B9=false;
            }
        }
        if(Greenfoot.isKeyDown("2")&&B10){
            P_2 p2 = (P_2)(getWorld().getObjects(P_2.class).get(0));
            if (p2.getX()==getX()||p2.getY()==getY())
            {
                G10=2;  
                B10=false;
            }
        }  
        if(G9==1)
        {
            turn(3);
            P_1 p1 = (P_1)(getWorld().getObjects(P_1.class).get(0));
            setLocation(p1.getX(),p1.getY()+12);  
            
        }
        else if(G9==2)
        {
            G9=0;
            P_1.number=0;
           // getWorld().removeObject(this);
           setImage("feibiao.png");
            getImage().scale(40,40);
            setLocation(getX(),getY()+15);
        }
        if(G10==1)
        {
            //getImage().scale(1,1);
            turn(3);
            P_2 p2 = (P_2)(getWorld().getObjects(P_2.class).get(0));
            setLocation(p2.getX(),p2.getY()+12);
            
        }        
        else if(G10==2)
        {
            G10=0;
            P_2.number2=0;
            //getWorld().removeObject(this);
            setImage("feibiao.png");
            getImage().scale(40,40);
            setLocation(getX(),getY()+15);
        }
    }
}    
