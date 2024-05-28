import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelPassedScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelPassedScreen extends World
{
    Label label1;
    Label label2;
    Label label3;
    Label label4;
    int nextLevel;
    GreenfootSound theme = new GreenfootSound("DarkStar.mp3");
    
    /**
     * Constructor for objects of class LevelPassedScreen.
     * 
     */
    public LevelPassedScreen(int passedLevel)
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false);
        
        nextLevel = passedLevel + 1;
        
        label1 = new Label("You've passed Level " + passedLevel + ". Congratulations!", 40);
        addObject(label1, 600, 250);
        label2 = new Label("You need to shoot down " + nextLevel * 10 + " jets to pass Level " + nextLevel, 40);
        addObject(label2, 600, 350);
        label3 = new Label("Your jet will have " + (nextLevel * 10 + 5) + " missiles in Level " + nextLevel + "", 40);
        addObject(label3, 600, 450);
        label4 = new Label("Press <Enter> key to continue. Good Luck!", 40);
        addObject(label4, 600, 550);
        
        theme.playLoop();
    }
    
    public void act()
    {
        String pressedKey = Greenfoot.getKey();
        if(pressedKey != null && pressedKey.equals("enter"))
        {
            theme.stop();
            MyWorld gameWorld = new MyWorld(nextLevel);
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    public void started()
    {
        theme.playLoop();
    }
    
    public void stopped()
    {
        theme.pause();
    }
}
