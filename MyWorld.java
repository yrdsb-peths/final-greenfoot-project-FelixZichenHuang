import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Felix Huang 
 * @version May 2024
 */
public class MyWorld extends World
{
    int score = 0;
    int level;
    int missilesLeft;
    int finalLevel = 10;
    boolean levelFailed = false;
    Label scoreLabel;
    Label levelLabel;
    Label missilesLeftLabel;
    GreenfootSound myJetSound = new GreenfootSound("MyJetSound.mp3");
    GreenfootSound levelFailedMusic = new GreenfootSound("Tenessee.mp3");
    SimpleTimer timer = new SimpleTimer();
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(int currentLevel)
    {    
        super(1200, 800, 1, false);
        setPaintOrder(Label.class, MyJet.class);
        
        level = currentLevel;
        missilesLeft = level * 10 + 5;
        
        MyJet myJet = new MyJet();
        addObject(myJet, 200, 400);
        myJetSound.playLoop();
        
        scoreLabel = new Label("Score: ", 30);
        scoreLabel.setValue("Score: " + score);
        levelLabel = new Label("Level: ", 30);
        levelLabel.setValue("Level: " + level);
        missilesLeftLabel = new Label("Missiles Left: ", 30);
        missilesLeftLabel.setValue("Missiles Left: " + missilesLeft);
        addObject(scoreLabel, 200, 50);
        addObject(levelLabel, 600, 50);
        addObject(missilesLeftLabel, 1000, 50);
        
        createEnemyJet();
        createEnemyMissile();
        int r = Greenfoot.getRandomNumber(3) + 2;
        for (int i = 0; i < r; i++)
        {
            createCloud();
        }
    }
    
    /**
     * Randomly select one type of enemy jet and add it to MyWorld.
     * 
     */
    public void createEnemyJet()
    {
        int r = Greenfoot.getRandomNumber(4);
        if (r == 0)
        {
            EnemyJet1 enemyJet1 = new EnemyJet1();
            int y = Greenfoot.getRandomNumber(600) + 100;
            addObject(enemyJet1, 1400, y);
        }
        else if (r == 1)
        {
            EnemyJet2 enemyJet2 = new EnemyJet2();
            int y = Greenfoot.getRandomNumber(600) + 100;
            addObject(enemyJet2, 1400, y);
        }
        else if (r == 2)
        {
            EnemyJet3 enemyJet3 = new EnemyJet3();
            int y = Greenfoot.getRandomNumber(600) + 100;
            addObject(enemyJet3, 1400, y);
        }
        else if (r == 3)
        {
            EnemyJet4 enemyJet4 = new EnemyJet4();
            int y = Greenfoot.getRandomNumber(500) + 150;
            addObject(enemyJet4, 1400, y);
        }
    }
    
    /**
     * Randomly select one type of enemy missile and add it to MyWorld.
     * 
     */
    public void createEnemyMissile()
    {
        int r = Greenfoot.getRandomNumber(2);
        if (r == 0)
        {
            EnemyMissile1 enemyMissile1 = new EnemyMissile1();
            int y = Greenfoot.getRandomNumber(600) + 100;
            addObject(enemyMissile1, 1400, y);
        }
        else if (r == 1)
        {
            EnemyMissile2 enemyMissile2 = new EnemyMissile2();
            int y = Greenfoot.getRandomNumber(600) + 100;
            addObject(enemyMissile2, 1400, y);
        }
    }
    
    /**
     * Randomly select one type of clound and add it to MyWorld.
     * 
     */
    public void createCloud()
    {
        int r = Greenfoot.getRandomNumber(3);
        if (r == 0)
        {
            Cloud1 cloud1 = new Cloud1();
            int y = Greenfoot.getRandomNumber(600) + 100;
            addObject(cloud1, 1400, y);
        }
        else if (r == 1)
        {
            Cloud2 cloud2 = new Cloud2();
            int y = Greenfoot.getRandomNumber(600) + 100;
            addObject(cloud2, 1400, y);
        }
        else if (r == 2)
        {
            Cloud3 cloud3 = new Cloud3();
            int y = Greenfoot.getRandomNumber(600) + 100;
            addObject(cloud3, 1400, y);
        }
    }
    
    /**
     * Increase score by one if my missile hits one enemy jet.
     * 
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue("Score: " + score);
        
        if (score / 10 == level)
        {
            Greenfoot.delay(3);
            if (level == 10)
            {
                gameWon();
            }
            else
            {
                levelPassed();
            }
        }
    }
    
    /**
     * Return the number of missiles left in the player's jet.
     * 
     */
    public int getMissilesNumber()
    {
        return missilesLeft;
    }
    
    /**
     * Decrease the number of missiles left in the player's jet by one if a missile was launched from the player's jet.
     * 
     */
    public void decreaseMissilesNumber()
    {
        missilesLeft--;
        missilesLeftLabel.setValue("Missiles Left: " + missilesLeft);
    }
    
    /**
     * Current level has been passed and set the world to newLevelIntroScreen.
     * 
     */
    public void levelPassed()
    {
        myJetSound.stop();
        NewLevelIntroScreen newLevelIntroScreen = new NewLevelIntroScreen(level + 1);
        Greenfoot.setWorld(newLevelIntroScreen);
    }
    
    /**
     * The player has won the game and set the world to gameWonScreen.
     * 
     */
    public void gameWon()
    {
        myJetSound.stop();
        GameWonScreen gameWonScreen = new GameWonScreen();
        Greenfoot.setWorld(gameWonScreen);
    }
    
    /**
     * The player has failed this level.
     * 
     */
    public void levelFailed()
    {
        levelFailed = true;
        myJetSound.stop();
        levelFailedMusic.playLoop();
        Label levelFailedLabel = new Label("You Failed", 200);
        addObject(levelFailedLabel, 600, 350);
        Label returnLabel = new Label("Press <R> key to return to the previous level passing screen\nor Level One introduction screen", 40);
        addObject(returnLabel, 600, 500);
        missilesLeft = 0;
        missilesLeftLabel.setValue("Missiles Left: " + missilesLeft);
        act();
    }
    
    /**
     * Return to thisLevelIntroScreen if the player has failed this level and pressed "r" key.
     * 
     */
    public void act()
    {
        if (levelFailed && Greenfoot.isKeyDown("r"))
        {
            levelFailedMusic.stop();
            NewLevelIntroScreen thisLevelIntroScreen = new NewLevelIntroScreen(level);
            Greenfoot.setWorld(thisLevelIntroScreen);
        }
    }
    
    /**
     * Start playing the background music again if the start button is pressed.
     * 
     */
    public void started()
    {
        if (levelFailed)
        {
            levelFailedMusic.playLoop();
        }
        else
        {
            myJetSound.playLoop();
        }
    }
    
    /**
     * Pause the background music if the pause button is pressed.
     * 
     */
    public void stopped()
    {
        if (levelFailed)
        {
            levelFailedMusic.pause();
        }
        else
        {
            myJetSound.pause();
        }
    }
}
