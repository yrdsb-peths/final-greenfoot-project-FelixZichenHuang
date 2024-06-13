import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The missile that belongs to the player's Jet.
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
        
        // Remove this MyMissile object and when its x position is greater than 1400.
        if (getX() >= 1400)
        {
            getWorld().removeObject(this);
            return;
        }
    }
}
