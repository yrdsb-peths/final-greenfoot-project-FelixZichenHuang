import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyJet3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyJet3 extends Actor
{
    /**
     * Act - do whatever the EnemyJet3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(-12);
        MyWorld world = (MyWorld) getWorld();
        
        if (isTouching(MyMissile.class))
        {
            removeTouching(MyMissile.class);
            Explosion explosion = new Explosion();
            world.addObject(explosion, getX(), getY());
            explosion.setSpeed(-8);
            world.createEnemyJet();
            getWorld().removeObject(this);
            return;
        }
        
        if (getX() <= -200)
        {
            world.removeObject(this);
            world.createEnemyJet();
        }
    }
}
