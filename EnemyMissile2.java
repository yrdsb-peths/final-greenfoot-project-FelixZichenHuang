import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyMissile2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyMissile2 extends Actor
{
    /**
     * Act - do whatever the EnemyMissile2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(-17);
        MyWorld world = (MyWorld) getWorld();
        
        if (getX() <= -200)
        {
            world.removeObject(this);
            world.createEnemyMissile();
        }
    }
}
