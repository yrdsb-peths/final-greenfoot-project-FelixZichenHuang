import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cloud3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        
        if (getX() <= -200)
        {
            world.removeObject(this);
            world.createCloud();
        }
    }
}
