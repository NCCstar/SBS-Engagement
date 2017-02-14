package levels;
import shapes.*;
import java.util.*;
import java.awt.Graphics;
public abstract class Level
{
    public int XSIZE;
    public int YSIZE;
    private List<Shape> boxes = new ArrayList();
    public Level()
    {
        XSIZE = 0;
        YSIZE = 0;
    }
    public List<Shape> getBoxes()
    {
        return boxes;
    }
    public void addBox(Shape box)
    {
        boxes.add(box);
    }
    public void draw(Graphics g)
    {
        for(Shape i:boxes)
        {
            i.draw(g);
        }
    }
}