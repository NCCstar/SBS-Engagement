package physics;

import shapes.*;

import java.util.*;

public abstract class Player extends Phys {
    public static final int MAX_EVENTS = 4;

    protected List<Hitbox> attacks;
    protected boolean inAir = true;
    protected double airMove;
    protected double ffMulti;
    protected double landMove;
    protected double airMax;
    protected double jumpPower;
    protected int numJumps;
    protected int maxJumps;
    protected int airAttacks = 0;
    protected int eventCode = -1;
    //0=standing, 1=upAttack, 2=rightAttack, 3=downAttack, 4=leftAttack
    protected int[] eventLength;
    protected List<Hitbox>[] eventHitbox;
    protected List<Double>[] eventOffsetX;
    protected List<Double>[] eventOffsetY;
    protected int eventTime;

    public Player(Hitbox hitbox) {
        super(hitbox);
        attacks = new ArrayList();
    }

    protected Player() {
        this(null);
    }

    protected abstract void defineHitboxes();

    public void tick(boolean fastFall) {
        //checkInAir has been done outside
        if (eventCode != -1) {
            if (eventTime >= eventLength[eventCode]) {
                endEvent(eventCode);
                eventCode = -1;
                eventTime = 0;
                attacks.clear();
            } else {
                attacks.clear();
                attacks.add(eventHitbox[eventCode].get(eventTime));
                offsetX(eventOffsetX[eventCode].get(eventTime));
                offsetY(eventOffsetY[eventCode].get(eventTime));
                eventTime++;
            }
        } else if (inAir) {
            if (fastFall)
                yVel += Grav * ffMulti;
            else
                yVel += Grav;
            offsetX(xVel);
            offsetY(yVel);
            if (xVel > 0.01) {
                xVel -= airMove / 6;
            } else if (xVel < 0.01) {
                xVel += airMove / 6;
            }
        }
    }

    protected abstract void endEvent(int eventCode);

    public List<Hitbox> getAttacks() {
        return attacks;
    }

    public void setInAir(boolean bool) {
        inAir = bool;
        if (!inAir) {
            xVel = 0;
            yVel = 0;
            numJumps = 0;
            airAttacks = 0;
        }
    }

    public boolean getInAir() {
        return inAir;
    }

    public void move(int dir, int dirMoving) {
        if (eventCode == -1) {
            if (inAir) {
                switch (dir) {
                    case 2:
                        if (xVel < airMax)
                            xVel += airMove;
                        break;
                    case 4:
                        if (-1 * xVel < airMax)
                            xVel -= airMove;
                        break;
                    case 1:
                        if (numJumps < maxJumps) {
                            yVel = -1 * jumpPower * (maxJumps - numJumps + 3) / (maxJumps + 3);
                            numJumps++;
                        }
                        break;
                    case 3:
                        yVel += Grav * 0.5;
                    default:
                        break;
                }
            } else {
                switch (dir) {
                    case 1:
                        inAir = true;
                        if (dirMoving == 2) {
                            xVel = landMove;
                        } else if (dirMoving == 4) {
                            xVel = landMove * -1;
                        }
                        numJumps++;
                        yVel -= jumpPower;
                        offsetY(-2);
                        break;
                    case 2:
                        offsetX(landMove);
                        break;
                    case 4:
                        offsetX(landMove * -1);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    protected abstract boolean canStartAttack(int eventCode);

    public void startAttack(int dir) {
        if(canStartAttack(dir)) {
            eventCode = dir;
            eventTime = 0;
            airAttacks++;
        }
    }

    public void move(int dir) {
        move(dir, 0);
    }
}