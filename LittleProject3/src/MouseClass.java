import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClass extends MouseAdapter {

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

