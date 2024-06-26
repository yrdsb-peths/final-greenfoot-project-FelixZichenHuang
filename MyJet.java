import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The player's jet.
 * 
 * @author Felix Huang 
 * @version May 2024
 */
public class MyJet extends Actor
{
    /**
     * Act - do whatever the MyJet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GreenfootSound myMissileSound = new GreenfootSound("MyMissileSound.mp3");
        GreenfootSound explosionSound = new GreenfootSound("ExplosionSound.mp3");
        String pressedKey = Greenfoot.getKey();
        
        // When the "left" or "right" key is pressed, move up or down respectively.
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(200, getY() - 15);
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            setLocation(200, getY() + 15);
        }
        
        // When the space bar is pressed for one time, launch a missile. If the jet is in MyWorld.class, decrease the total missile number by one.
        if (pressedKey != null && pressedKey.equals("space"))
        {
            myMissileSound.play();
            if (getWorld().getClass().equals(TitleScreen.class))
            {
                MyMissile myMissile = new MyMissile();
                getWorld().addObject(myMissile, getX() + 220, getY());
            }
            else if (getWorld().getClass().equals(MyWorld.class) && ((MyWorld) getWorld()).getMissilesNumber() > 0)
            {
                MyMissile myMissile = new MyMissile();
                getWorld().addObject(myMissile, getX() + 220, getY());
                ((MyWorld) getWorld()).decreaseMissilesNumber();
            }
        }
        
        // Remove this MyJet object once it's hit by a EnemyMissile1.class object or EnemyMissile2.class object, create an explosion object, and play explosionSound.
        if (isTouching(EnemyMissile1.class))
        {
            explosionSound.play();
            removeTouching(EnemyMissile1.class);
            Explosion explosion = new Explosion(0);
            getWorld().addObject(explosion, getX(), getY());
            ((MyWorld) getWorld()).levelFailed();
            getWorld().removeObject(this);
            return;
        }
        else if (isTouching(EnemyMissile2.class))
        {
            explosionSound.play();
            removeTouching(EnemyMissile2.class);
            Explosion explosion = new Explosion(0);
            getWorld().addObject(explosion, getX(), getY());
            ((MyWorld) getWorld()).levelFailed();
            getWorld().removeObject(this);
            return;
        }
    }
}
