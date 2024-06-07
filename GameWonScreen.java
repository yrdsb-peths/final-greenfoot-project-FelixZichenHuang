import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWonScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWonScreen extends World
{
    Label label1;
    Label label2;
    GreenfootSound theme = new GreenfootSound("TopGun.mp3");
    
    /**
     * Constructor for objects of class LevelPassedScreen.
     * 
     */
    public GameWonScreen()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false);
        
        ChampionTrophy trophy = new ChampionTrophy();
        addObject(trophy, 600, 300);
        label1 = new Label("You've won the game.", 60);
        addObject(label1, 600, 490);
        label2 = new Label("Congratulations!", 80);
        addObject(label2, 600, 550);
        
        theme.playLoop();
    }
    
    /**
     * Start playing the background music again if the start button is pressed.
     * 
     */
    public void started()
    {
        theme.playLoop();
    }
    
    /**
     * Pause the music again if the pause button is pressed.
     * 
     */
    public void stopped()
    {
        theme.pause();
    }
}
