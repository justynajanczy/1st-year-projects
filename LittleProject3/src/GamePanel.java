/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GamePanel extends JPanel
{
    ArrayList<Square> squares;

    void checkForClicks(MouseEvent e)
    {
        for(int i = 0; i< squares.size(); i++)
        {
            if(e.getX() >= squares.get(i).x && e.getX() <= squares.get(i).x+70 && e.getY() >= squares.get(i).y && e.getY() <= squares.get(i).y+70)
            {
                squares.remove(i);
                return;
            }

        }
    }
    public void paint(Graphics g)
    {
        for(int i = 0; i<squares.size(); i++)
        {
            g.setColor(Color.YELLOW);
            g.fillRect((int)squares.get(i).x, (int)squares.get(i).y, 70, 70);
            g.setColor(Color.black);
            g.drawRect((int)squares.get(i).x, (int)squares.get(i).y, 70, 70);

        }
        g.setColor(Color.YELLOW);

    }

}
*/
