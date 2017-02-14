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

    protected boolean key4=false;
    protected boolean key5=false;
    protected boolean key6=false;
    protected boolean key8=false;
    protected boolean keyEn=false;
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

            case KeyEvent.VK_NUMPAD8:
                if(key4)
                    game.jump(1,4);
                else
                if(key6)
                    game.jump(1,2);
                else
                    game.jump(1,0);
                break;
            case KeyEvent.VK_NUMPAD4:key4=true;
                break;
            case KeyEvent.VK_NUMPAD5:key5=true;
                break;
            case KeyEvent.VK_NUMPAD6:key6=true;
                break;
            case KeyEvent.VK_ENTER:keyEn=true;
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

            case KeyEvent.VK_NUMPAD4:key4=false;
                break;
            case KeyEvent.VK_NUMPAD5:key5=false;
                break;
            case KeyEvent.VK_NUMPAD6:key6=false;
                break;
            case KeyEvent.VK_NUMPAD8:key8=false;
                break;
            case KeyEvent.VK_ENTER:keyEn=false;
                break;
            case KeyEvent.VK_NUMPAD0:keyZe=false;
                break;

            default:
                break;
        }
    }

}