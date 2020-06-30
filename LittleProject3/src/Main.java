/*
import javax.swing.*;
import java.util.ArrayList;
import java.time.Instant;
import java.time.Duration;

public class Main
{
    GameFrame frame;
    ArrayList <Square> squares;

    int total = 0;
    int missed = 0;

    public Main()
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
        double calc = delta/5d;
        for(int i = 0; i<squares.size(); i++)
        {
            squares.get(i).y+=calc;
            System.out.println("");
            if(squares.get(i).y > 750)
            {
                missed++;
                squares.remove(i);
            }
        }
        String str = "Current score: " + (int)((total - missed)*100/total) + "% Time left: " + ((30000 - totalTime)/1000);

        frame.update(str);
    }

    void play()
    {
        frame = new GameFrame();
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
            if(Duration.between(spawn, Instant.now()).toMillis() >= 1000)
            {
                spawnSquare();
                spawn = Instant.now();
            }
        }
        if((total- missed)/(total*1d) >= 0.5)
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
        new Main().play();


    }
}
*/
