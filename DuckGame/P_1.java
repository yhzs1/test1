import greenfoot.*;
import java.util.List;
/**
 * Write a description of class P_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P_1 extends Player
{
    public static final int GRAVITY = 1;  //重力加速度
    public static int SPEEDX = 5;  //水平速度
    public static final int FLAP_SPEED = -15;  //飞扬速度
    private int speed = 0;    //垂直速度
    private boolean isJump = false;
    private int count = 0;  //跳跃次数
    public int dr = 1;    //子弹发射方向
    private int dr_j = 0;   //跳跃方向，0：竖直向上，1：向右初速度，-1：向左初速度
    private boolean isDown = false;
    private boolean isDown_j = false; //子弹单发限制条件
    private boolean start = true;    //开始时下坠
    private boolean lTouching = false;  //左地形触碰判断条件
    private boolean rTouching = false;  //右地形触碰判断条件
    private int counter = 0;  //动画计数器
    private static int direction0 = -1;      //记录运动方向 左1右2
    int direction = -1;
    public static int Turn=0;  //判断移动方位
    public static int GetX1=0;  //获取角色横坐标
    public static int number=0; //子弹数量
    public static int victorysum1=0;//判断胜负
    public static boolean iswin;  //最终胜利判定
    public P_1(){
        speed = FLAP_SPEED;
        direction = direction0;
        isJump = true;
        start = true;
        iswin = false;
        setImage("duckstandRight.png");
        counter = 0;
    }

    public void act() 
    {
        control();
        flap(isJump,dr);
        Walk();
       // checkBox();
        checkGameOver();
    }    
    public void checkBox(){ //判断是否碰到道具
            if(isTouching(Box.class)&&!Box.Box1)
            {
                removeTouching(Box.class);
            }
    }
    public void control(){
        if(!isDown && Greenfoot.isKeyDown("a") && !lTouching){
            direction = 1;
            walkAnimation(direction);
            setLocation(getX()-5,getY()); 
            dr = -1;
            dr_j = -1;
            if(Rifle.G1==1||Bazooka.G3==1||Rocket.G5==1||Staff.G7==1)
                Turn=1;  //向左移动
            else Turn=0; 
        }else if(!Greenfoot.isKeyDown("a") && direction == 1){
            setImage("duckstandLeft.png");
            direction = -1;
        }
        if(!isDown && Greenfoot.isKeyDown("d") && !rTouching){      
            direction = 2;
            walkAnimation(direction);
            setLocation(getX()+5,getY());  
            dr = 1;
            dr_j = 1;
            if(Rifle.G1==1||Bazooka.G3==1||Rocket.G5==1||Staff.G7==1)
                Turn=2;  //向右移动
            else Turn=0;
        }else if(!Greenfoot.isKeyDown("d") && direction == 2){
            setImage("duckstandRight.png");
            direction = -1;
        }
        if(!Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d")){
            dr_j = 0;           //重置跳跃水平方向初速度
        }
        if(!isJump && Greenfoot.isKeyDown("w") && count<2){
            isDown = true;
            speed = FLAP_SPEED;
            count++;
            isJump = true;
        }
        if(isJump &&!Greenfoot.isKeyDown("w")){
            isJump = false;
        }
        if(!isDown && Greenfoot.isKeyDown("s")){
            //setLocation(getX(),getY()+5); 
        }
        if(!isDown_j && Greenfoot.isKeyDown("space")&&Rifle.B1){
            isDown_j = true;
            if(number<10)
                getWorld().addObject(new Prop(dr),getX(),getY()+12);
            number++;
            if(number>=15) //限制武器多次发射子弹
                number=0;
            GetX1=getX();
            Greenfoot.playSound("laifu.mp3");
        }
        else if(!isDown_j && Greenfoot.isKeyDown("space")&&Bazooka.B3){
            isDown_j = true;
            if(number<1){
                getWorld().addObject(new BazooProp(dr),getX(),getY()+7);
                Greenfoot.playSound("huopao.mp3");
            }
            number++;
            if(number>=4)
                number=0;
            GetX1=getX();
        }
        else if(!isDown_j && Greenfoot.isKeyDown("space")&&Rocket.B5){
            isDown_j = true;
            if(number<3){
                getWorld().addObject(new Shell(dr),getX(),getY()+1);
                getWorld().addObject(new Shell(dr),getX(),getY()+15);
                getWorld().addObject(new Shell(dr),getX(),getY()+29);
                Greenfoot.playSound("huojianpao.mp3");
            }
            number++;
            if(number>=7)
                number=0;
            GetX1=getX();
        }
        else if(!isDown_j && Greenfoot.isKeyDown("space")&&Staff.B7){
            isDown_j = true;
            if(number<10){
                getWorld().addObject(new Orb(dr),getX(),getY()+12);
                Greenfoot.playSound("faqiu.mp3");
            }
            GetX1=getX();
            number++;
            if(number>=15)
                number=0;
        }
        else if(!isDown_j && Greenfoot.isKeyDown("space")&&Darts.B9){
            isDown_j = true;
            if(number<10){
                getWorld().addObject(new Dart(dr),getX(),getY()+12);
                Greenfoot.playSound("feibiao.mp3");
                }
           number++;
            if(number>=15)
                number=0;
            GetX1=getX();
            
        }
        if(isDown_j && !Greenfoot.isKeyDown("space")&&Rifle.B1){
            isDown_j = false;
        }
        else if(isDown_j && !Greenfoot.isKeyDown("space")&&Bazooka.B3){
            isDown_j = false;
        }
        else if(isDown_j && !Greenfoot.isKeyDown("space")&&Rocket.B5){
            isDown_j = false;
        }
        else if(isDown_j && !Greenfoot.isKeyDown("space")&&Staff.B7){
            isDown_j = false;
        }
        else if(isDown_j && !Greenfoot.isKeyDown("space")&&Darts.B9){
            isDown_j = false;
        }
    }

    public void Walk(){
        checkTouchingGround();
        checkTouchingAround();
        checkTouchingTop();
    }

    //行走动画
    public void walkAnimation(int direction){
        counter ++;         //计数器自加1
        switch(direction){      //判断面对方向
            case 1:
            if (counter == 0) {
                setImage("duckLeft1.png");
            }
            else if (counter == 5) {
                setImage("duckLeft2.png");
            }
            else if (counter == 10) {
                setImage("duckLeft3.png");
            }
            else if (counter == 15) {
                setImage("duckLeft4.png");
            }
            else if (counter == 20) {
                setImage("duckLeft5.png");
                counter=0;      //计数器清零
            }
            break;
            case 2:
            if (counter == 0) {
                setImage("duckRight1.png");
            }
            else if (counter == 5) {
                setImage("duckRight2.png");
            }
            else if (counter == 10) {
                setImage("duckRight3.png");
            }
            else if (counter == 15) {
                setImage("duckRight4.png");
            }
            else if (counter == 20) {
                setImage("duckRight5.png");
                counter=0;      //计数器清零
            }
            break;
        }
    }

    private void flap(boolean isJump,int dr) {
        if(isDown || start){
            speed = speed + GRAVITY;  //垂直速度受重力影响
            setLocation(getX()+5*dr_j, getY() + speed);  //更新坐标位置
        }
    }

    public void checkTouchingGround(){  // 地面
        if(getOneObjectAtOffset(0 , 40 , Ground.class)!=null){
            isDown = false;
            start = false;
            setLocation(getX(), getY() - 8);
            count = 0;
            dr_j = 0;
            speed = 0;
        }
        if(getOneObjectAtOffset(0 , 46 , Ground.class)==null){
            isDown = true;
        }
    }

    public void checkTouchingAround(){  //左右障碍
        if(getOneObjectAtOffset(20 , 0 , Ground.class)!=null){
            rTouching = true;
            SPEEDX = 0;
            setLocation(getX() - 10,getY());
        }else{
            rTouching = false;
            SPEEDX = 5;
        }
        if(getOneObjectAtOffset(-20 , 0 , Ground.class)!=null){
            lTouching = true;
            SPEEDX = 0;
            setLocation(getX() + 10,getY());
        }else{
            lTouching = false;
            SPEEDX = 5;
        }
    }

    public void checkTouchingTop(){ //触顶判断
        if(getOneObjectAtOffset(0 , -24 , Ground.class)!=null){
            speed = -speed;
        }
    }

    private void checkGameOver() {
        if(getY() >= getWorld().getHeight() - 10){
            GameWorld space = (GameWorld) getWorld();
            setLocation(getX(),10);
            speed = 0;
            List<Live_1> lives1 = space.getObjects(Live_1.class);
            Live_1 live1 = new Live_1();
            space.removeObject(lives1.get(0));
        }
        if(GameWorld.gw==1){
            GameWorld space = (GameWorld) getWorld();
            if (space.getObjects(Live_1.class).size()==0 ) {
                //space.gameOver();
                P_2.victorysum2++;
                Greenfoot.setWorld(new RW2());
                Greenfoot.delay(30);
                GameWorld.gw=2;
                Greenfoot.setWorld(new GW2());
            }
        }
        else if(GameWorld.gw==2){
            GameWorld space = (GameWorld) getWorld();
            if (space.getObjects(Live_1.class).size()==0 ) {
                P_2.victorysum2++;
                Greenfoot.setWorld(new RW3());
                Greenfoot.delay(30);
                GameWorld.gw=3;
                Greenfoot.setWorld(new GW3());
            }
        }
        else if(GameWorld.gw==3){
            GameWorld space = (GameWorld) getWorld();
            if (space.getObjects(Live_1.class).size()==0 ) {
                P_2.victorysum2++;      
                space.repaint();
                Greenfoot.setWorld(new Endmap());
            }
        }
    }
}
