import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The first type of enemy missile.
 * 
 * @author Felix Huang 
 * @version May 2024
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
        
        // Remove this enemyMissile1 object once it's hit by a MyMissile.class object, create an explosion object, and play explosionSound.
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
        
        // Remove this enemyMissile1 object and create a new enemy jet when its x position is smaller than -200.
        if (getX() <= -200)
        {
            world.removeObject(this);
            world.createEnemyMissile();
        }
    }
}
