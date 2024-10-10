import java.awt.*;
import java.awt.event.KeyEvent;

public class Racquet {

    private Main game;
    int x = 0;
    int xs = 0;

    public Racquet (Main game) {
        this.game = game;
    }

    public void move() {
        if (x + xs > 0 && x + xs < game.getWidth()-60){
            x = x + xs;
        }
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, 330, 60, 10);
    }

    public void keyReleased(KeyEvent e) {
        xs = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xs = -game.speed;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xs = game.speed;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, 330, 60, 10);
    }

    public int getTopY() {
        return 330;
    }

}
