package physics.players;
import shapes.*;
import physics.*;
import java.util.*;
public class Bob extends Player
{
    private double oldYVel;
    private double oldXVel;
    public Bob(double x,double y)
    {
        super();
        Shape[] boxes = new Shape[1];
        boxes[0] = new Rect(true,x,y-20,x+20,y);
        setHitbox(new Hitbox(boxes));
        defineHitboxes();

        landMove = 1.3;
        jumpPower = .5;
        maxJumps = 4;
        airMove = .015;
        airMax = 1.4;
        Grav = .012;
        ffMulti = 2;
    }
    /*
        0=standing, 1=upAttack, 2=rightAttack, 3=downAttack, 4=leftAttack
       int[] eventLength;
       List<Hitbox>[] eventHitbox;
       List<Double>[] eventOffsetX;
       List<Double>[] eventOffsetY;
    */
    protected void defineHitboxes()
    {
        eventLength = new int[MAX_EVENTS+1];
        eventHitbox = new ArrayList[MAX_EVENTS+1];
        for(int i=0;i<eventHitbox.length;i++)
            eventHitbox[i] = new ArrayList();
        eventOffsetX = new ArrayList[MAX_EVENTS+1];
        for(int i=0;i<eventOffsetX.length;i++)
            eventOffsetX[i] = new ArrayList();
        eventOffsetY = new ArrayList[MAX_EVENTS+1];
        for(int i=0;i<eventOffsetY.length;i++)
            eventOffsetY[i] = new ArrayList();

        Rect charBox;

        eventLength[0] = 30;
        charBox = (Rect)this.hitbox.getBoxes()[0];
        for(int i=0;i<30;i++)
        {
            eventHitbox[0].add(new Hitbox(new Rect(false,charBox.getLeft()-10,charBox.getTop(),charBox.getRight()+10,charBox.getBottom())));
            eventOffsetX[0].add(0.0);
            eventOffsetY[0].add(0.0);
        }

        eventLength[1] = 30;
        charBox = (Rect)this.hitbox.getBoxes()[0];
        for(int i=0;i<30;i++)
        {
            eventHitbox[1].add(new Hitbox(new Rect(false,charBox.getLeft()-10,charBox.getTop(),charBox.getRight()+10,charBox.getBottom())));
            eventOffsetX[1].add(0.0);
            eventOffsetY[1].add(-2.5);
        }

        eventLength[2] = 30;
        charBox = (Rect)this.hitbox.getBoxes()[0];
        for(int i=0;i<30;i++)
        {
            eventHitbox[2].add(new Hitbox(new Rect(false,charBox.getLeft()-10,charBox.getTop(),charBox.getRight()+10,charBox.getBottom())));
            eventOffsetX[2].add(2.5);
            eventOffsetY[2].add(0.0);
        }

        eventLength[3] = 30;
        charBox = (Rect)this.hitbox.getBoxes()[0];
        for(int i=0;i<30;i++)
        {
            eventHitbox[3].add(new Hitbox(new Rect(false,charBox.getLeft()-10,charBox.getTop(),charBox.getRight()+10,charBox.getBottom())));
            eventOffsetX[3].add(0.0);
            eventOffsetY[3].add(2.5);
        }

        eventLength[4] = 30;
        charBox = (Rect)this.hitbox.getBoxes()[0];
        for(int i=0;i<30;i++)
        {
            eventHitbox[4].add(new Hitbox(new Rect(false,charBox.getLeft()-10,charBox.getTop(),charBox.getRight()+10,charBox.getBottom())));
            eventOffsetX[4].add(-2.5);
            eventOffsetY[4].add(0.0);
        }
    }

    protected void endEvent(int eventCode) {
        switch(eventCode)
        {
            case 0:
                yVel=oldYVel;
                xVel=oldXVel;
                break;
            case 1:
                yVel = oldYVel - 1;
                xVel = 0;
                break;
            case 2:
                yVel = oldYVel;
                xVel=1;
                break;
            case 3:
                yVel = 0;
                xVel = 0;
                break;
            case 4:
                yVel = oldYVel;
                xVel = -1;
                break;
        }
    }

    protected boolean canStartAttack(int eventCode) {
        oldYVel = yVel;
        oldYVel = xVel;
        return true;
    }
}