import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyJet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyJet extends Actor
{
    /**
     * Act - do whatever the MyJet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GreenfootSound myMissileSound = new GreenfootSound("MyMissileSound.mp3");
        GreenfootSound explosionSound = new GreenfootSound("ExplosionSound.mp3");
        String pressedKey = Greenfoot.getKey();
        
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(200, getY() - 15);
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            setLocation(200, getY() + 15);
        }
        
        if (pressedKey != null && pressedKey.equals("space"))
        {
            MyMissile myMissile = new MyMissile();
            getWorld().addObject(myMissile, getX() + 220, getY());
            myMissileSound.play();
            if (getWorld().equals(MyWorld.class))
            {
                ((MyWorld) getWorld()).decreaseMissilesNumber();
            }
            else if (getWorld().equals(TitleScreen.class))
            {
                MyWorld world = new MyWorld();
                world.decreaseMissilesNumber();
            }
        }
        
        if (isTouching(EnemyMissile1.class))
        {
            removeTouching(EnemyMissile1.class);
            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(), getY());
            explosionSound.play();
            explosion.setSpeed(0);
            getWorld().removeObject(this);
            return;
        }
        else if (isTouching(EnemyMissile2.class))
        {
            removeTouching(EnemyMissile2.class);
            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(), getY());
            explosionSound.play();
            explosion.setSpeed(0);
            getWorld().removeObject(this);
            return;
        }
    }
}
