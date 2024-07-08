import greenfoot.*;

/**
 * Write a description of class Music here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Music extends Actor
{
    /**
     * Act - do whatever the Music wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    static GreenfootSound screenmusic = new GreenfootSound("Challenging.wav");
    
    public Music()
    {
        setImage((GreenfootImage)null);
        screenmusic.setVolume(35);
    }
    
    public void act() 
    {
       if(this.getWorld().getClass() == StartInterface.class && !screenmusic.isPlaying() ||
            this.getWorld().getClass() == Endmap.class && !screenmusic.isPlaying() ||
            this.getWorld().getClass() == ItroducationPlay.class && !screenmusic.isPlaying()||
            this.getWorld().getClass() == GW1.class && !screenmusic.isPlaying()||
       this.getWorld().getClass() == GW2.class && !screenmusic.isPlaying()||
       this.getWorld().getClass() == GW3.class && !screenmusic.isPlaying())
        {
            screenmusic.play();
        }
    }    
}
