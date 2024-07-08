import greenfoot.*;
import java.util.List;
/**
 * Write a description of class P_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class P_2 extends Player
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
    public static int Turn2=0;  //判断移动方位
    public static int GetX=0;  //获得角色横坐标
    public static int number2=0; //子弹数量
    public static int victorysum2=0;//判断胜负
    public static boolean iswin;  //最终胜利判定
    public P_2(){
        speed = FLAP_SPEED;
        direction = direction0;
        isJump = true;
        start = true;
        iswin = false;
        setImage("duckstandLeft2.png");
        counter = 0;
    }

    public void act() 
    {
        control();
        //checkBox();
        flap(isJump,dr);
        Walk();
        checkGameOver();
    }    
    public void checkBox(){ //判断是否碰到道具
            if(isTouching(Box.class)&&!Box.Box1)
            {
                removeTouching(Box.class);
            }
    }
    public void control(){
        if(!isDown && Greenfoot.isKeyDown("left") && !lTouching){   
            direction = 1;
            walkAnimation(direction);
            setLocation(getX()-5,getY()); 
            dr = -1;
            dr_j = -1;
            if(Rifle.G2==1||Bazooka.G4==1||Rocket.G6==1||Staff.G8==1)
                Turn2=1;
            else Turn2=0;
        }else if(!Greenfoot.isKeyDown("left") && direction == 1){
            setImage("duckstandLeft2.png");
            direction = -1;
        }
        if(!isDown && Greenfoot.isKeyDown("right") && !rTouching){
            direction = 2;
            walkAnimation(direction);
            setLocation(getX()+5,getY());  
            dr = 1;
            dr_j = 1;
            if(Rifle.G2==1||Bazooka.G4==1||Rocket.G6==1||Staff.G8==1)
                Turn2=2;
            else Turn2=0;
        }else if(!Greenfoot.isKeyDown("right") && direction == 2){
            setImage("duckstandRight2.png");
            direction = -1;
        }
        if(!Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("right")){
            dr_j = 0;           //重置跳跃水平方向初速度
        }
        if(!isJump && Greenfoot.isKeyDown("up") && count<2){
            isDown = true;
            speed = FLAP_SPEED;
            count++;
            isJump = true;
        }
        if(isJump &&!Greenfoot.isKeyDown("up")){
            isJump = false;
        }
        if(!isDown && Greenfoot.isKeyDown("down")){
            //setLocation(getX(),getY()+5); 
        }
        if(!isDown_j && Greenfoot.isKeyDown("3")&&Rifle.B2){
            isDown_j = true;
            if(number2<10)
                getWorld().addObject(new Prop(dr),getX(),getY()+12);
            number2++;
            if(number2>=15)
                number2=0;
            GetX=getX();
            Greenfoot.playSound("laifu.mp3");
        }
        else if(!isDown_j && Greenfoot.isKeyDown("3")&&Bazooka.B4)
        {
            isDown_j = true;
            if(number2<1){
                getWorld().addObject(new BazooProp(dr),getX(),getY()+7);
                Greenfoot.playSound("huopao.mp3");
            }
            number2++;
            if(number2>=4)
                number2=0;
            GetX=getX();

        }
        else if(!isDown_j && Greenfoot.isKeyDown("3")&&Rocket.B6){
            isDown_j = true;
            if(number2<3){
                getWorld().addObject(new Shell(dr),getX(),getY()+1);
                getWorld().addObject(new Shell(dr),getX(),getY()+15);
                getWorld().addObject(new Shell(dr),getX(),getY()+29);
                Greenfoot.playSound("huojianpao.mp3");
            }
            number2++;
            if(number2>=7)
                number2=0;
            GetX=getX();
        }
        else if(!isDown_j && Greenfoot.isKeyDown("3")&&Staff.B8){
            isDown_j = true;
            if(number2<10){
                getWorld().addObject(new Orb(dr),getX(),getY()+12);
                Greenfoot.playSound("faqiu.mp3");
            }
            GetX=getX();
            number2++;
            if(number2>=15)
                number2=0;
        }
        if(!isDown_j && Greenfoot.isKeyDown("3")&&Darts.B10){
            isDown_j = true;
            if(number2<10){
                getWorld().addObject(new Dart(dr),getX(),getY()+12);
                Greenfoot.playSound("feibiao.mp3");
            }
            number2++;
            if(number2>=15)
                number2=0;
            GetX=getX();
            
        }
        if(isDown_j && !Greenfoot.isKeyDown("3")&&Rifle.B2){
            isDown_j = false;
        }
        else if(isDown_j && !Greenfoot.isKeyDown("3")&&Bazooka.B4){
            isDown_j = false;
        }
        else if(isDown_j && !Greenfoot.isKeyDown("3")&&Rocket.B6){
            isDown_j = false;
        }
        else if(isDown_j && !Greenfoot.isKeyDown("3")&&Staff.B8){
            isDown_j = false;
        }
        else if(isDown_j && !Greenfoot.isKeyDown("3")&&Darts.B10){
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
                setImage("duck2Left1.png");
            }
            else if (counter == 5) {
                setImage("duck2Left2.png");
            }
            else if (counter == 10) {
                setImage("duck2Left3.png");
            }
            else if (counter == 15) {
                setImage("duck2Left4.png");
            }
            else if (counter == 20) {
                setImage("duck2Left5.png");
                counter=0;      //计数器清零
            }
            break;
            case 2:
            if (counter == 0) {
                setImage("duck2Right1.png");
            }
            else if (counter == 5) {
                setImage("duck2Right2.png");
            }
            else if (counter == 10) {
                setImage("duck2Right3.png");
            }
            else if (counter == 15) {
                setImage("duck2Right4.png");
            }
            else if (counter == 20) {
                setImage("duck2Right5.png");
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
            List<Live_2> lives2 = space.getObjects(Live_2.class);
            Live_2 live2 = new Live_2();
            space.removeObject(lives2.get(0));
        }
        if(GameWorld.gw==1){
            GameWorld space = (GameWorld) getWorld();
            if (space.getObjects(Live_2.class).size()==0 ) {
                //space.gameOver();
                P_1.victorysum1++;
                Greenfoot.setWorld(new RW2());
                Greenfoot.delay(30);
                Greenfoot.setWorld(new GW2());
                GameWorld.gw=2;
            }
        }
        else if(GameWorld.gw==2){
            GameWorld space = (GameWorld) getWorld();
            if (space.getObjects(Live_2.class).size()==0 ) {
                P_1.victorysum1++;
                Greenfoot.setWorld(new RW3());
                Greenfoot.delay(30);
                Greenfoot.setWorld(new GW3());
                GameWorld.gw=3;
            }
        }
        else if(GameWorld.gw==3){
            GameWorld space = (GameWorld) getWorld();
            if (space.getObjects(Live_2.class).size()==0 ) {
                P_1.victorysum1++;
                space.repaint();
                Greenfoot.setWorld(new Endmap());
            }
        }
    }
}
