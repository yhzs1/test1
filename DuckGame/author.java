import greenfoot.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class author here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class author extends Menu
{
    /**
     * Act - do whatever the author wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */ 
    private static final Color transparent = new Color(255, 255, 255, 0);
    public author()
    {
        List<GreenfootImage> lines = new ArrayList<GreenfootImage>();
        lines.add(new GreenfootImage("Prop usefulness",25,Color.white,transparent));
        lines.add(new GreenfootImage("&",25,Color.white,transparent));
        lines.add(new GreenfootImage("Introduction of weapons",25,Color.white,transparent));  
        int width = 0;
        int height = 0;
        for (GreenfootImage line : lines) {  //根据显示的内容来设置宽度和高度
            height += line.getHeight();
            if (width < line.getWidth()) {
                width = line.getWidth();
            }
        }

        GreenfootImage image = new GreenfootImage(width + 20, height + 20);
        image.setColor(transparent);
        image.fill();
        for (int i = 0, y = 10; i < lines.size(); i++) {  
            GreenfootImage line = lines.get(i);
            image.drawImage(line, (image.getWidth() - line.getWidth()) / 2, y);
            y += line.getHeight();
        }
        setImage(image);      
    }

    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new BackGround());
        }
    }     
}
