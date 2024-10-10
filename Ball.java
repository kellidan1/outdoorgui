import java.awt.*;

public class Ball {
    int x = 0;
    int y = 0;
    int xs = 1;
    int ys = 1;
    private Main game;

    public Ball(Main game) {
        this.game = game;
    }

    void move() {
        if (x + xs < 0) {
            xs = game.speed;
        }
        if (x + xs > game.getWidth() - 30) {
            xs = -game.speed;
        }
        if (y + ys < 0) {
            ys = game.speed;
        }
        if (y + ys > game.getHeight() - 30) {
            game.gameOver();
        }
        if (collision()) {
            ys = -game.speed;
            y = game.racquet.getTopY() - 30;
            game.speed++;
        }

        x = x + xs;
        y = y + ys;
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, 30, 30);
    }

    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 30, 30);
    }
}
