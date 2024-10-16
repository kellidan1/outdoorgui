import java.awt.*;

public class Ball {
    int x = 0;
    int y = 0;
    int xs = 1;
    int ys = 1;
    private static final int MAX_SPEED = 5;
    private Main game;

    public Ball(Main game) {
        this.game = game;
    }

//    void move() {
//        if (x + xs < 0) {
//            xs = game.speed;
//        }
//        if (x + xs > game.getWidth() - 30) {
//            xs = -game.speed;
//        }
//        if (y + ys < 0) {
//            ys = game.speed;
//        }
//        if (y + ys > game.getHeight() - 30) {
//            game.gameOver();
//        }
//        if (collision()) {
//            ys = Math.min(-game.speed, -MAX_SPEED);
//            y = game.racquet.getTopY() - 30;
//            game.speed = Math.min(game.speed + 1, MAX_SPEED);
//        }
//
//        x = x + xs;
//        y = y + ys;
//    }

    void move() {
        // Check for left wall collision
        if (x + xs < 0) {
            xs = game.speed; // Change direction
        }

        // Check for right wall collision
        if (x + xs > game.getWidth() - 30) {
            xs = -game.speed; // Change direction
        }

        // Check for top wall collision
        if (y + ys < 0) {
            ys = game.speed; // Change direction
        }

        // Check for bottom wall collision (game over condition)
        if (y + ys > game.getHeight() - 30) {
            game.gameOver(); // End the game
        }

        // Check for collision with the racquet
        if (collision()) {
            ys = -game.speed; // Reverse the Y direction
            y = game.racquet.getTopY() - 30; // Position the ball just above the racquet
            game.speed = Math.min(game.speed + 1, MAX_SPEED); // Increase speed, capped at MAX_SPEED
        }

        // Update ball position
        x += xs;
        y += ys;
    }


    public void paint(Graphics2D g) {
        g.fillOval(x, y, 30, 30);
    }

    private boolean collision() {
        Rectangle ballBounds = getBounds();
        Rectangle racquetBounds = game.racquet.getBounds();
        return racquetBounds.intersects(ballBounds);
    }


    public Rectangle getBounds() {
        return new Rectangle(x, y, 30, 30);
    }
}
