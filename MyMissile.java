import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyMissile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyMissile extends Actor
{
    /**
     * Act - do whatever the MyMissile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(15);
        MyWorld world = (MyWorld) getWorld();
        
        if (getX() >= 1400)
        {
            world.removeObject(this);
        }
    }
}
