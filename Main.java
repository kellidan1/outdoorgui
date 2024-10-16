import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import javax.swing.Timer;

public class Main extends JPanel {

    Ball ball = new Ball(this);
    Racquet racquet = new Racquet(this);
    int speed = 1;

    public int getScore() {
        return speed - 1;
    }

    public Main() {
        Timer timer = new Timer(10, e -> {
            move();
            repaint();
        });
        timer.start();
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                racquet.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);
            }
        });
        setFocusable(true);
    }

    private void move() {
        ball.move();
        racquet.move();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        racquet.paint(g2d);

        g2d.setColor(Color.GRAY);
        g2d.drawString(String.valueOf(getScore()), 10, 30);
    }

    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Your score is: " + getScore(), "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(0);
    }


    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Mini Tennis");
        Main game = new Main();
        frame.add(game);
        frame.setSize(300, 380);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.requestFocusInWindow();
//        while (true) {
//            game.move();
//            game.repaint();
//            sleep(10);
//        }
    }
}
