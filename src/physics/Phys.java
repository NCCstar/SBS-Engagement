package physics;
import shapes.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.*;
public abstract class Phys
{//protected actually working.
    protected double Grav; //gravitational coefficent - diff
    protected double xVel;
    protected double yVel;
    protected Hitbox hitbox;
    public Phys(Hitbox hitbox)
    {
        this.hitbox = hitbox;
    }
    protected Phys()
    {
        this(null);
    }

    public void draw(Graphics g)
    {
        hitbox.draw(g);
        if(this instanceof Player)
        {
            List<Hitbox> boxen =((Player)(this)).getAttacks();
            Color c = g.getColor();
            g.setColor(new Color(c.getRed(),c.getGreen(),c.getBlue(),100));
            for(Hitbox h:boxen)
            {
                h.draw(g);
            }
        }
    }
    public void setHitbox(Hitbox hitbox)
    {
        this.hitbox = hitbox;
    }
    public Hitbox getHitbox()
    {
        return hitbox;
    }
    public void offsetX(double off)
    {
        hitbox.offsetX(off);
    }
    public void offsetY(double off)
    {
        hitbox.offsetY(off);
    }
    //TEMP
    public double getXVel()
    {
        return xVel;
    }
    public double getYVel()
    {
        return yVel;
    }
}