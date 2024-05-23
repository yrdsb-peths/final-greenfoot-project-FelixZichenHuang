import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int score = 0;
    int level = 1;
    int missilesLeft = 18;
    Label scoreLabel;
    Label levelLabel;
    Label missilesLeftLabel;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false);
        
        MyJet myJet = new MyJet();
        addObject(myJet, 200, 400);
        
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
    }
    
    public void createEnemyJet()
    {
        int r1 = Greenfoot.getRandomNumber(4);
        if (r1 == 0)
        {
            EnemyJet1 enemyJet1 = new EnemyJet1();
            int y1 = Greenfoot.getRandomNumber(600) + 100;
            addObject(enemyJet1, 1400, y1);
        }
        else if (r1 == 1)
        {
            EnemyJet2 enemyJet2 = new EnemyJet2();
            int y1 = Greenfoot.getRandomNumber(600) + 100;
            addObject(enemyJet2, 1400, y1);
        }
        else if (r1 == 2)
        {
            EnemyJet3 enemyJet3 = new EnemyJet3();
            int y1 = Greenfoot.getRandomNumber(600) + 100;
            addObject(enemyJet3, 1400, y1);
        }
        else if (r1 == 3)
        {
            EnemyJet4 enemyJet4 = new EnemyJet4();
            int y1 = Greenfoot.getRandomNumber(500) + 150;
            addObject(enemyJet4, 1400, y1);
        }
    }
    
    public void createEnemyMissile()
    {
        int r2 = Greenfoot.getRandomNumber(2);
        if (r2 == 0)
        {
            EnemyMissile1 enemyMissile1 = new EnemyMissile1();
            int y2 = Greenfoot.getRandomNumber(600) + 100;
            addObject(enemyMissile1, 1400, y2);
        }
        else if (r2 == 1)
        {
            EnemyMissile2 enemyMissile2 = new EnemyMissile2();
            int y2 = Greenfoot.getRandomNumber(600) + 100;
            addObject(enemyMissile2, 1400, y2);
        }
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue("Score: " + score);
        
        int levelPassingScore = 0;
        for (int l = 1; l <= level; l++)
        {
            levelPassingScore += 15 * l;
        }
        if (score % levelPassingScore == 0)
        {
            level++;
            levelLabel.setValue("Level: " + level);
            missilesLeft = 18 * level;
        }
    }
    
    public void decreaseMissilesNumber()
    {
        missilesLeft--;
        missilesLeftLabel.setValue("Missiles Left: " + missilesLeft);
    }
}
