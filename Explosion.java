import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author Felix Huang 
 * @version May 2024
 */
public class Explosion extends Actor
{
    int speed;
    
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(speed);
    }
    
    public void setSpeed(int theSpeed)
    {
        speed = theSpeed;
    }
}
