package primary;
import java.awt.event.*;
public class Controller
{
    private Panel game;
    protected boolean keySp=false;

    protected boolean keyW=false;
    protected boolean keyA=false;
    protected boolean keyS=false;
    protected boolean keyD=false;
    protected boolean keySh=false;
    protected boolean keyF=false;

    protected boolean keyI=false;
    protected boolean keyJ=false;
    protected boolean keyK=false;
    protected boolean keyL=false;
    protected boolean keyFs=false;
    protected boolean keyZe=false;

    public Controller()
    {}
    public void setGame(Panel game)
    {
        this.game = game;
    }
    public void checkIn(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_SPACE:keySp=true;
                break;

            case KeyEvent.VK_W:
                keyW=true;
                if(keyA) {
                    game.jump(0, 4);
                    break;
                }
                if(keyD) {
                    game.jump(0, 2);
                    break;
                }
                game.jump(0,0);
                break;
            case KeyEvent.VK_A:keyA=true;
                break;
            case KeyEvent.VK_S:keyS=true;
                break;
            case KeyEvent.VK_D:keyD=true;
                break;
            case KeyEvent.VK_SHIFT:
                keySh=true;
                if(keyD==keyA)//not pointing l/r
                {
                    if(keyW==keyS)//not pointing u/d
                    {
                        game.attack(0,0);
                        break;
                    }
                    {//not l/r, either up or down
                        if(keyW)
                        {
                            game.attack(0,1);
                            break;
                        }
                        game.attack(0,3);
                        break;
                    }
                }//moving l/r
                if(keyD)
                {
                    game.attack(0,2);
                    break;
                }
                game.attack(0,4);
                break;

            case KeyEvent.VK_F:keyF=true;
                break;

            case KeyEvent.VK_I:
                keyI=true;
                if(keyJ)
                    game.jump(1,4);
                else
                if(keyL)
                    game.jump(1,2);
                else
                    game.jump(1,0);
                break;
            case KeyEvent.VK_J:keyJ=true;
                break;
            case KeyEvent.VK_K:keyK=true;
                break;
            case KeyEvent.VK_L:keyL=true;
                break;
            case KeyEvent.VK_PERIOD:
                keyFs=true;
                if(keyJ==keyL)//not pointing l/r
                {
                    if(keyI==keyK)//not pointing u/d
                    {
                        game.attack(1,0);
                        break;
                    }
                    //not l/r, either up or down
                    if(keyI)
                    {
                        game.attack(1,1);
                        break;
                    }
                    game.attack(1,3);
                    break;
                }//moving l/r
                if(keyL)
                {
                    game.attack(1,2);
                    break;
                }
                game.attack(1,4);
                break;
            case KeyEvent.VK_NUMPAD0:keyZe=true;
                break;

            default:
                break;
        }
    }
    public void checkOut(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_SPACE:keySp=false;
                break;

            case KeyEvent.VK_W:keyW=false;
                break;
            case KeyEvent.VK_A:keyA=false;
                break;
            case KeyEvent.VK_S:keyS=false;
                break;
            case KeyEvent.VK_D:keyD=false;
                break;
            case KeyEvent.VK_SHIFT:keySh=false;
                break;
            case KeyEvent.VK_F:keyF=false;
                break;

            case KeyEvent.VK_J:keyJ=false;
                break;
            case KeyEvent.VK_K:keyK=false;
                break;
            case KeyEvent.VK_L:keyL=false;
                break;
            case KeyEvent.VK_I:keyI=false;
                break;
            case KeyEvent.VK_PERIOD:keyFs=false;
                break;
            case KeyEvent.VK_NUMPAD0:keyZe=false;
                break;

            default:
                break;
        }
    }

}