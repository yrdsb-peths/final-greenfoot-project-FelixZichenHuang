import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cloud1 here.
 * 
 * @author Felix Huang 
 * @version May 2024
 */
public class Cloud1 extends Actor
{
    /**
     * Act - do whatever the Cloud1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(-4);
        
        MyWorld world = (MyWorld) getWorld();
        
        if (getX() <= -200)
        {
            world.removeObject(this);
            world.createCloud();
        }
    }
}
