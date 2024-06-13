import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The explosion after the jets and missiles are hit.
 * 
 * @author Felix Huang 
 * @version May 2024
 */
public class Explosion extends Actor
{
    int speed;
    GreenfootImage[] explosionSprite = new GreenfootImage[7];
    SimpleTimer timer = new SimpleTimer();
    
    // Set the moving speed of the explosion object and add the ExplosionSprite to the explosionSprite array.
    public Explosion(int theSpeed)
    {
        speed = theSpeed;
        for (int i = 0; i < 7; i++)
        {
            explosionSprite[i] = new GreenfootImage("images/ExplosionSprite/ExplosionSprite" + (i + 1) + ".png");
        }
        timer.mark();
    }
    
    int index = 0;
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(speed);
        
        // Refresh the images at a rate of 1 iamge per 40 milliseconds.
        if (timer.millisElapsed() < 40)
        {
            return;
        }
        timer.mark();        
        setImage(explosionSprite[index]);
        index++;
        // Remove this explosion object once all the images in the explosionSprite array are displayed.
        if (index == explosionSprite.length)
        {
            getWorld().removeObject(this);
        }
    }
}
