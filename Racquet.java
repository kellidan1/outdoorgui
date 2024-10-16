import java.awt.*;
import java.awt.event.KeyEvent;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class Racquet {

    private Main game;
    int x = 0;
    int xs = 0;
    private BufferedImage image;

    public Racquet (Main game) {
        this.game = game;
        try {
            image = ImageIO.read(getClass().getResource("/tennisracket.png")); // Load the image
            image = scaleImage(image, 90, 50); // Scale to desired size
            System.out.println("Image loaded and scaled successfully.");
        } catch (IOException e) {
            System.out.println("Failed to load image: " + e.getMessage());
            e.printStackTrace(); // Handle exceptions
        }
    }

    public void move() {
        if (x + xs > 0 && x + xs < game.getWidth()-60){
            x = x + xs;
        }
    }

    public void paint(Graphics2D g) {
        if (image != null) {
            g.drawImage(image, x, 280, null); // Draw the racquet image at the specified position
        } else {
            g.drawRect(x, 330, 60, 10); // Optionally draw a placeholder rectangle for debugging
        }
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
        if (image != null) {
            return new Rectangle(x, 330, image.getWidth(), image.getHeight());
        } else {
            return new Rectangle(x, 330, 60, 10); // Default bounds if image is null
        }
    }
    private BufferedImage scaleImage(BufferedImage originalImage, int width, int height) {
        BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = scaledImage.createGraphics();
        g.drawImage(originalImage, 0, 10, width, height, null);
        g.dispose();
        return scaledImage;
    }

    public int getTopY() {
        return 330;
    }
}
