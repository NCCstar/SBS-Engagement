package physics.players;
import shapes.*;
import physics.*;
import java.util.*;
public class Mac extends Player
{
    public Mac(double x,double y)
    {
        super();
        Shape[] boxes = new Shape[1];
        boxes[0] = new Rect(true,x,y-18,x+18,y);
        setHitbox(new Hitbox(boxes));

        landMove = 2.25;
        jumpPower = 1.45;
        maxJumps = 2;
        airMove = .011;
        airMax = 1.6;
        Grav = .012;
        ffMulti = 3;
    }
    /*
       int[] eventLength;
       List<Hitbox>[] eventHitbox;
       List<Double>[] eventOffsetX;
       List<Double>[] eventOffsetY;
    */
    protected void defineHitboxes()
    {

    }
    protected void endEvent(int eventCode) {

    }
    protected boolean canStartAttack(int eventCode) {
        return false;
    }
}