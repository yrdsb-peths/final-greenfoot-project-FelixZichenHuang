import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The second type of cloud.
 * 
 * @author Felix Huang 
 * @version May 2024
 */
public class Cloud2 extends Actor
{
    /**
     * Act - do whatever the Cloud2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(-6);
        
        MyWorld world = (MyWorld) getWorld();
        
        // Remove this cloud2 object and create a new cloud when its x position is smaller than -200.
        if (getX() <= -200)
        {
            world.removeObject(this);
            world.createCloud();
        }
    }
}
