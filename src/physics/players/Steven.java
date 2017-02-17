package physics.players;
import shapes.*;
import physics.*;
import java.util.*;
public class Steven extends Player
{
    private double oldYVel = 0;
    private double oldXVel = 0;
    private boolean isRight = false;
    public Steven(double x,double y)
    {
        super();
        Shape[] boxes = new Shape[2];
        boxes[0] = new Rect(false,x,y-23,x+17,y);//torso
        boxes[1] = new Rect(true,x-1,y-1,x+18,y+1);//feet
        setHitbox(new Hitbox(boxes));
        defineHitboxes();

        landMove = 1.05;
        jumpPower = 2.3;
        maxJumps = 1;
        airMove = .017;
        airMax = 1.3;
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

        eventLength[0] = 60;
        charBox = (Rect)this.hitbox.getBoxes()[1];
        for(int i=0;i<60;i++)
        {
            eventHitbox[0].add(new Hitbox(new Rect(false,charBox.getLeft()-10,charBox.getTop(),charBox.getRight()+10,charBox.getBottom())));
            eventOffsetX[0].add(0.0);
            eventOffsetY[0].add(0.0);
        }

        eventLength[1] = 120;
        charBox = (Rect)this.hitbox.getBoxes()[1];
        for(int i=0;i<15;i++)
        {
            eventHitbox[1].add(new Hitbox(new Rect(false,charBox.getLeft()-10,charBox.getTop(),charBox.getRight()+10,charBox.getBottom())));
            eventOffsetX[1].add(3.0);
            eventOffsetY[1].add(-1.5);
        }
        for(int i=15;i<45;i++)
        {
            eventHitbox[1].add(new Hitbox(new Rect(false,charBox.getLeft()-10,charBox.getTop(),charBox.getRight()+10,charBox.getBottom())));
            eventOffsetX[1].add(-3.0);
            eventOffsetY[1].add(-1.5);
        }
        for(int i=45;i<75;i++)
        {
            eventHitbox[1].add(new Hitbox(new Rect(false,charBox.getLeft()-10,charBox.getTop(),charBox.getRight()+10,charBox.getBottom())));
            eventOffsetX[1].add(3.0);
            eventOffsetY[1].add(-1.5);
        }
        for(int i=75;i<105;i++)
        {
            eventHitbox[1].add(new Hitbox(new Rect(false,charBox.getLeft()-10,charBox.getTop(),charBox.getRight()+10,charBox.getBottom())));
            eventOffsetX[1].add(-3.0);
            eventOffsetY[1].add(-1.5);
        }
        for(int i=105;i<120;i++)
        {
            eventHitbox[1].add(new Hitbox(new Rect(false,charBox.getLeft()-10,charBox.getTop(),charBox.getRight()+10,charBox.getBottom())));
            eventOffsetX[1].add(3.0);
            eventOffsetY[1].add(-1.5);
        }

        eventLength[2] = 20;
        charBox = (Rect)this.hitbox.getBoxes()[1];
        for(int i=0;i<20;i++)
        {
            eventHitbox[2].add(new Hitbox(new Rect(false,charBox.getLeft()-10,charBox.getTop(),charBox.getRight()+10,charBox.getBottom())));
            eventOffsetX[2].add(5.0);
            eventOffsetY[2].add(0.0);
        }

        eventLength[3] = 40;
        charBox = (Rect)this.hitbox.getBoxes()[1];
        for(int i=0;i<10;i++)
        {
            eventHitbox[3].add(new Hitbox(new Rect(false,charBox.getLeft()-10,charBox.getTop(),charBox.getRight()+10,charBox.getBottom())));
            eventOffsetX[3].add(5.0);
            eventOffsetY[3].add(0.1);
        }
        for(int i=10;i<30;i++)
        {
            eventHitbox[3].add(new Hitbox(new Rect(false,charBox.getLeft()-10,charBox.getTop(),charBox.getRight()+10,charBox.getBottom())));
            eventOffsetX[3].add(-5.0);
            eventOffsetY[3].add(0.1);
        }
        for(int i=30;i<40;i++)
        {
            eventHitbox[3].add(new Hitbox(new Rect(false,charBox.getLeft()-10,charBox.getTop(),charBox.getRight()+10,charBox.getBottom())));
            eventOffsetX[3].add(5.0);
            eventOffsetY[3].add(0.1);
        }

        eventLength[4] = 20;
        charBox = (Rect)this.hitbox.getBoxes()[1];
        for(int i=0;i<20;i++)
        {
            eventHitbox[4].add(new Hitbox(new Rect(false,charBox.getLeft()-10,charBox.getTop(),charBox.getRight()+10,charBox.getBottom())));
            eventOffsetX[4].add(-5.0);
            eventOffsetY[4].add(0.0);
        }
    }

    protected void endEvent(int eventCode) {
        switch(eventCode)
        {
            case 0:
                yVel=0;
                xVel=0;
                break;
            case 1:
                yVel = -1;
                if(isRight)
                    xVel = .5;
                else {
                    xVel = -.5;
                    reverseAttack(1);
                }
                break;
            case 2:
                yVel=0;
                xVel=1;
                break;
            case 4:
                yVel=0;
                xVel=-1;
                break;
        }
    }

    protected boolean canStartAttack(int eventCode) {
        switch(eventCode)
        {
            case 0:
                return airAttacks<2;
            case 1:
                isRight = (oldXVel = xVel)>0;
                //isRight=xVel>0;
                if(!isRight)
                    reverseAttack(1);
                return airAttacks<1;
            case 2:
                return airAttacks<1;
            case 4:
                return airAttacks<1;
        }
        return true;
    }
    private void reverseAttack(int atkCode)
    {
        for(int i=0;i<eventOffsetX[atkCode].size();i++)
        {
            eventOffsetX[atkCode].set(i,eventOffsetX[atkCode].get(i)*-1);
        }
    }
}