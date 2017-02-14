package primary;
import javax.swing.*;
import levels.*;
import other.Hiragana;
import java.awt.*;
import java.awt.event.*;
public class Driver
{
    private static Panel panel;
    private static Controller controller;
    public static void main(String[] arg)
    {
        JFrame frame = new JFrame(Hiragana.toHiragana("Superibu Bashi Sibilingosu: Sucufele"));//superb bash siblings: scuffle

        Level level = new Last_Terminous();

        controller = new Controller();
        panel = new Panel(level,controller);
        controller.setGame(panel);
        frame.setSize(level.XSIZE,level.YSIZE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.setResizable(true);//may be false
        frame.addKeyListener(new listen());
    }
    public static class listen implements KeyListener
    {
        public void keyTyped(KeyEvent e){}
        public void keyPressed(KeyEvent e)
        {
            controller.checkIn(e);
        }
        public void keyReleased(KeyEvent e)
        {
            controller.checkOut(e);
        }
    }
}