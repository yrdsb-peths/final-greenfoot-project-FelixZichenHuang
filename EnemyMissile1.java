
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyMissile1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyMissile1 extends Actor
{
    /**
     * Act - do whatever the EnemyMissile1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(-17);
        
        GreenfootSound explosionSound = new GreenfootSound("ExplosionSound.mp3");
        
        MyWorld world = (MyWorld) getWorld();
        
        if (isTouching(MyMissile.class))
        {
            world.increaseScore();
            Explosion explosion = new Explosion();
            world.addObject(explosion, getX(), getY());
            explosionSound.play();
            explosion.setSpeed(-13);
            world.createEnemyMissile();
            getWorld().removeObject(this);
            return;
        }
        
        if (getX() <= -200)
        {
            world.removeObject(this);
            world.createEnemyMissile();
        }
    }
}
