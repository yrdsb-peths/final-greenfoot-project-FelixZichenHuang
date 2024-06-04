import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitileScreen here.
 * 
 * @author Felix Huang 
 * @version May 2024
 */
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author Felix Huang 
 * @version May 2024
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("TOP GUN: GAMING", 80);
    GreenfootSound opening = new GreenfootSound("TopGun.mp3");
    
    /**
     * 
     * Constructor for objects of class TitleScreen.
     */
    public TitleScreen()
    {    
        // Create a new world with 1200 x 800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false);
        setPaintOrder(Label.class);
        addObject(titleLabel, 750, 300);
        MyJet myJet = new MyJet();
        addObject(myJet, 200, 400);
        Label label = new Label("Use \u2190 key to move the jet upward\nUse \u2192 key to move the jet downward\nUse <Space> bar to launch missiles", 40);
        addObject(label, 750, 410);
        Label label2 = new Label("Press <Enter> key to start", 40);
        addObject(label2, 750, 500);
    }

    /**
     * 
     * The main world act loop.
     */
    public void act()
    {
        // Start the game if user presses the enter key.
        String pressedKey = Greenfoot.getKey();
        if(pressedKey != null && pressedKey.equals("enter"))
        {
            opening.stop();
            NewLevelIntroScreen levelOneIntro = new NewLevelIntroScreen(1);
            Greenfoot.setWorld(levelOneIntro);
        }
    }
    
    /**
     * 
     * Start playing the opening music when the "Run" button is clicked.
     */
    public void started()
    {
        opening.playLoop();
    }
    
    /**
     * 
     * Pause the opening music when the "Pause" button is clicked.
     */
    public void stopped()
    {
        opening.pause();
    }
}
