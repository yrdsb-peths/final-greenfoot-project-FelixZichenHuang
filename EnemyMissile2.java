import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyMissile2 here.
 * 
 * @author Felix Huang 
 * @version May 2024
 */
public class EnemyMissile2 extends Actor
{
    /**
     * Act - do whatever the EnemyMissile2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(-17);
        
        GreenfootSound explosionSound = new GreenfootSound("ExplosionSound.mp3");
        
        MyWorld world = (MyWorld) getWorld();
        
        if (isTouching(MyMissile.class))
        {
            explosionSound.play();
            removeTouching(MyMissile.class);
            Explosion explosion = new Explosion(-13);
            world.addObject(explosion, getX(), getY());
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
