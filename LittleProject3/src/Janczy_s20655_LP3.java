/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

class Square
{

    double x;
    double y;

    public Square (double x, double y)
    {
        this.x = x;
        this.y = y;
    }
}

class GamePanel extends JPanel
{
    ArrayList<Square> squares;
    int [] toDel = new int[1];

    void checkForClicks(MouseEvent e)
    {
        for(int i = 0; i< squares.size(); i++)
        {
            toDel[0] = -1;
            if(e.getX() >= squares.get(i).x && e.getX() <= squares.get(i).x+70 && e.getY() >= squares.get(i).y && e.getY() <= squares.get(i).y+70)
            {
                toDel[0] = i;
                return;
            }
        }
    }
    public void paint(Graphics g)
    {
        //this for setting background color
        super.paint(g);

        for(int i = 0; i<squares.size(); i++)
        {//parameters of squares
            g.setColor(Color.BLUE);
            g.fillRect((int)squares.get(i).x, (int)squares.get(i).y, 70, 70);
            g.setColor(Color.black);
            g.drawRect((int)squares.get(i).x, (int)squares.get(i).y, 70, 70);
        }

    }

}

class GameFrame
{
    JFrame gameFrame;
    GamePanel gamePanel;
    JPanel scorePanel;
    JLabel score;

    GameFrame()
    {
        gameFrame = new JFrame();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setPreferredSize(new Dimension(600, 800));

        gamePanel = new GamePanel();

        scorePanel = new JPanel();

        score = new JLabel("Score:  ");

        scorePanel.add(score);
        scorePanel.setSize(600,50);

        gamePanel.setSize(600, 750);
        gamePanel.setBackground(Color.YELLOW);

        gamePanel.addMouseListener(new MouseClass(gamePanel));
        gameFrame.add(gamePanel);
        gameFrame.add(scorePanel, BorderLayout.SOUTH);

        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }

    void update(String s)
    {
        SwingUtilities.invokeLater(() ->
        {
            score.setText(s);
            gameFrame.repaint();
        });


    }
}

class MouseClass extends MouseAdapter
{

    GamePanel g;

    public MouseClass(GamePanel g)
    {
        this.g = g;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        g.checkForClicks(e);

    }

}


public class Janczy_s20655_LP3
{
    GameFrame frame;
    ArrayList <Square> squares;
    int[] del = new int[1];

    int total = 0;
    int missed = 0;

    public Janczy_s20655_LP3()
    {
        squares = new ArrayList<Square>();
    }

    void spawnSquare()
    {
        squares.add(new Square(Math.random()*480, 0));
        total++;
    }

    void update(long delta, long totalTime)
    {
        double calc = delta/0.1125d;
        frame.gamePanel.toDel = del;

        for(int i = 0; i<squares.size(); i++)
        {
            squares.get(i).y+=calc;
            //fastens
            System.out.println("");

            if(squares.get(i).y > 750) {
                missed++;
                squares.remove(i);
            }
            if(del[0] != -1)
            {
                squares.remove(del[0]);
                del[0] = -1;
            }
        }
        String str = "Current score: " + (int)((total - missed)*100/total) + "% Time left: " + ((30000 - totalTime)/1000);

        frame.update(str);
    }

    void play()
    {
        frame = new GameFrame();
        //synchronizes
        frame.gamePanel.squares = squares;
        boolean playing = true;

        Instant start = Instant.now();
        Instant playTime = Instant.now();
        Instant spawn = Instant.now();

        spawnSquare();
        while(playing)
        {
            long delta = Duration.between(start, Instant.now()).toMillis();
            update(delta, Duration.between(playTime, Instant.now()).toMillis());
            start = Instant.now();

            if(Duration.between(playTime, Instant.now()).toMillis() >= 30000)
            {
                playing = false;
            }
            if(Duration.between(spawn, Instant.now()).toMillis() >= 900)
            {
                spawnSquare();
                spawn = Instant.now();
            }
        }
        if((total- missed)/(total*1d) >= 0.85)
        {
            JOptionPane.showMessageDialog(frame.gameFrame, "You won");
        }
        else
        {
            JOptionPane.showMessageDialog(frame.gameFrame, "You lose.");
        }
        System.exit(0);
    }
    public static void main(String[] args)
    {
        new Janczy_s20655_LP3().play();
    }
}
*/
