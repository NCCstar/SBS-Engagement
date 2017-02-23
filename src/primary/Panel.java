/*
TODO: 
*/
package primary;
import levels.*;
import physics.*;
import physics.players.*;
import shapes.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
public class Panel extends JPanel
{
    private Level level;
    private Controller con;
    private Player[] play = new Player[2];
    private static long RATE = 1000000000/240;//(1 second/(frames/second))
    private long lastRun = System.nanoTime();
    public Panel(Level l,Controller c)
    {
        level = l;
        con = c;
        play[0] = new Steven(400,300);
        play[1] = new Mac(600,300);
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.black);
        level.draw(g);
        g.setColor(Color.red.darker());
        play[0].draw(g);
        g.setColor(Color.blue.darker());
        play[1].draw(g);
        if(System.nanoTime()-lastRun>RATE)//check FPS
        {
            lastRun=System.nanoTime();
            for(Player player:play)//for each player
            {
                boolean inAir = true;
                outerLoop: for(Shape l:level.getBoxes())
                {
                    for(Shape p:player.getHitbox().getBoxes())
                    {
                        if(p.getSolid()&&l.getSolid())
                        {
                            if(l.touches(p))
                            {
                                if(player.getYVel()>=0) {
                                    inAir = false;
                                    break outerLoop;
                                }
                            }
                        }
                    }
                }
                player.setInAir(inAir);
            }
            //movement
            if(con.keyA)
            {
                play[0].move(4);
            }
            if(con.keyD)
            {
                play[0].move(2);
            }
            if(con.key4)
            {
                play[1].move(4);
            }
            if(con.key6)
            {
                play[1].move(2);
            }
            //DEBUG
            if(con.keySp)
            {
                play[0].getHitbox().offsetTo(400,300);
                play[1].getHitbox().offsetTo(600,300);
            }
            //end DEGUB

            play[0].tick(con.keyS);//ticks falling, events
            play[1].tick(con.key5);
            //DEBUG TEXT
            g.fillRect(getWidth()-20,0,getWidth(),20);
        }
        g.setColor(Color.red.darker());
        g.drawString(play[0].getHitbox().getBoxes()[0].getX()+":"+play[0].getHitbox().getBoxes()[0].getY(),0,10);
        g.drawString("X:"+play[0].getXVel(),0,20);
        g.drawString("Y:"+play[0].getYVel(),0,30);
        g.setColor(Color.blue.darker());
        g.drawString(play[1].getHitbox().getBoxes()[0].getX()+":"+play[1].getHitbox().getBoxes()[0].getY(),0,40);
        g.drawString("X:"+play[1].getXVel(),0,50);
        g.drawString("Y:"+play[1].getYVel(),0,60);

        repaint();
    }
    public void jump(int pNum,int dirMoving)
    {
        play[pNum].move(1,dirMoving);
    }
    public void attack(int pNum,int dirAtk)
    {
        play[pNum].startAttack(dirAtk);
    }
}