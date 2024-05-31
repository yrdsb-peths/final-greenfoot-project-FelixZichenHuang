import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyMissile here.
 * 
 * @author Felix Huang 
 * @version May 2024
 */
public class MyMissile extends Actor
{
    /**
     * Act - do whatever the MyMissile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(5);
        
        if (getX() >= 1400)
        {
            getWorld().removeObject(this);
            return;
        }
        
        if (isTouching(Explosion.class))
        {
            getWorld().removeObject(this);
            return;
        }
    }
}
