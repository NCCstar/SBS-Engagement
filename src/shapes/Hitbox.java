package shapes;
import java.awt.*;
import java.util.*;
public class Hitbox
{
    private Shape[] boxes;
    public Hitbox(Shape[] boxes)
    {
        this.boxes = boxes;
    }
    public Hitbox(Shape box)
    {
        this(new Shape[]{box});
    }
    public Shape[] getBoxes()
    {
        return boxes;
    }
    public void draw(Graphics g)
    {
        for(Shape i:boxes)
        {
            i.draw(g);
        }
    }
    public void offsetX(double off)
    {
        for(Shape i:boxes)
        {
            i.offsetX(off);
        }
    }
    public void offsetY(double off)
    {
        for(Shape i:boxes)
        {
            i.offsetY(off);
        }
    }
    public void offsetTo(double x,double y)
    {
        int xNow = boxes[0].getX();
        int yNow = boxes[0].getY();
        double xDif = x-xNow;
        double yDif = y-yNow;
        for(Shape i:boxes)
        {
            i.offsetX(xDif);
            i.offsetY(yDif);
        }
    }
}