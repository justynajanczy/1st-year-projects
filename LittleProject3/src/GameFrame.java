/*
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameFrame
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
*/
