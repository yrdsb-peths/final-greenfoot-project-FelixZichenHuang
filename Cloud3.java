import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The third type of cloud.
 * 
 * @author Felix Huang 
 * @version May 2024
 */
public class Cloud3 extends Actor
{
    /**
     * Act - do whatever the Cloud3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(-3);
        
        MyWorld world = (MyWorld) getWorld();
        
        // Remove this cloud3 object and create a new cloud when its x position is smaller than -200.
        if (getX() <= -200)
        {
            world.removeObject(this);
            world.createCloud();
        }
    }
}
