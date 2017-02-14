package shapes;
import java.awt.*;
public interface Shape
{
    void draw(Graphics g);
    void offsetX(double off);
    void offsetY(double off);
    void offsetTo(double x,double y);
    int getX();
    int getY();
    boolean getSolid();
    boolean touches(Shape other);
}