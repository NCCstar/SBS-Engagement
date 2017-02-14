package shapes;
import java.awt.*;
public class Rect implements Shape
{
    private boolean solid;
    private double left;
    private double right;
    private double top;
    private double bottom;
    private double width;
    private double height;
    public Rect(boolean solid,double x1,double y1,double x2,double y2)
    {
        this.solid = solid;
        left = Math.min(x1,x2);
        right = Math.max(x1,x2);
        top = Math.min(y1,y2);
        bottom = Math.max(y1,y2);
        width = right - left;
        height = bottom - top;
    }

    public void draw(Graphics g)
    {
        g.fillRect((int)left,(int)top,(int)width,(int)height);
    }
    public boolean getSolid()
    {
        return solid;
    }
    public double getLeft()
    {
        return left;
    }
    public double getRight()
    {
        return right;
    }
    public double getTop()
    {
        return top;
    }
    public double getBottom()
    {
        return bottom;
    }
    public double getWidth()
    {
        return width;
    }
    public double getHeight()
    {
        return height;
    }
    public int getX()
    {
        return (int)left;
    }
    public int getY()
    {
        return (int)top;
    }
    public boolean touches(Shape other)
    {
        if(other instanceof Rect)
        {
            Rect rect = (Rect)other;
            return (this.left<rect.right&&this.right>rect.left) && (this.top<rect.bottom&&this.bottom>rect.top);
        }
        return false;
    }
    public void offsetX(double x)
    {
        left+=x;
        right+=x;
    }
    public void offsetY(double y)
    {
        top+=y;
        bottom+=y;
    }
    public void offsetTo(double x,double y)
    {
        left=x;
        top=y;
        right=x+width;
        bottom=y+height;
    }
}