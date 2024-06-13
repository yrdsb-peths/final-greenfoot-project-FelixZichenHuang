import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The first type of enemy jet.
 * 
 * @author Felix Huang 
 * @version May 2024
 */
public class EnemyJet1 extends Actor
{
    /**
     * Act - do whatever the EnemyJet1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(-12);
        
        GreenfootSound explosionSound = new GreenfootSound("ExplosionSound.mp3");
        
        MyWorld world = (MyWorld) getWorld();
        
        // Remove this enemyJet1 object once it's hit by a MyMissile.class object, create an explosion object, play explosionSound, and increase score by one.
        if (isTouching(MyMissile.class))
        {
            explosionSound.play();
            removeTouching(MyMissile.class);
            Explosion explosion = new Explosion(-8);
            world.addObject(explosion, getX(), getY());
            world.createEnemyJet();
            getWorld().removeObject(this);
            world.increaseScore();
            return;
        }
        
        // Remove this enemyJet1 object and create a new enemy jet when its x position is smaller than -200.
        if (getX() <= -200)
        {
            world.removeObject(this);
            world.createEnemyJet();
        }
    }
}
