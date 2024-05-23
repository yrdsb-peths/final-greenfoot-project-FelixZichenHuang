import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyJet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyJet extends Actor
{
    //GreenfootSound myJetSound = new GreenfootSound("MyJetSound.mp3");
    
    /**
     * Act - do whatever the MyJet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        String pressedKey = Greenfoot.getKey();
        MyWorld world = (MyWorld) getWorld();
        //myJetSound.play();
        
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(200, getY() - 15);
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            setLocation(200, getY() + 15);
        }
        
        if (pressedKey != null && pressedKey.equals("up"))
        {
            MyMissile myMissile = new MyMissile();
            world.addObject(myMissile, getX() + 220, getY());
            world.decreaseMissilesNumber();
        }
        
        if (isTouching(EnemyMissile1.class))
        {
            removeTouching(EnemyMissile1.class);
            Explosion explosion = new Explosion();
            world.addObject(explosion, getX(), getY());
            explosion.setSpeed(0);
            getWorld().removeObject(this);
            return;
        }
        if (isTouching(EnemyMissile2.class))
        {
            removeTouching(EnemyMissile2.class);
            Explosion explosion = new Explosion();
            world.addObject(explosion, getX(), getY());
            explosion.setSpeed(0);
            getWorld().removeObject(this);
            return;
        }
    }
}
