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
        MyWorld world = (MyWorld) getWorld();
        
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(200, getY() - 12);
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            setLocation(200, getY() + 12);
        }
        
        if (Greenfoot.isKeyDown("up"))
        {
            MyMissile myMissile = new MyMissile();
            world.addObject(myMissile, getX() + 220, getY());
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
