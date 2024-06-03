import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyJet3 here.
 * 
 * @author Felix Huang 
 * @version May 2024
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
        GreenfootSound explosionSound = new GreenfootSound("ExplosionSound.mp3");
        
        MyWorld world = (MyWorld) getWorld();
        
        if (isTouching(MyMissile.class))
        {
            explosionSound.play();
            Explosion explosion = new Explosion(-8);
            world.addObject(explosion, getX(), getY());
            world.createEnemyJet();
            getWorld().removeObject(this);
            world.increaseScore();
            return;
        }
        
        if (getX() <= -200)
        {
            world.removeObject(this);
            world.createEnemyJet();
        }
    }
}
