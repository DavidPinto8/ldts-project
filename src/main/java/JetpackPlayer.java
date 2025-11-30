import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.TextColor;

public class JetpackPlayer {
    private int x, y;
    private double velocityY = 0;
    private final double gravity = 0.2;
    private final double jetpackPower = -0.5;
    private int score = 0;

    public void addCoin() {
        score++;
    }

    public int getScore() {
        return score;
    }


    private boolean jetpackActive = false;

    public JetpackPlayer(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void activateJetpack() {
        jetpackActive = true;
    }

    public void update(int maxHeight) {

        if (jetpackActive) {
            velocityY = jetpackPower;
        }

        velocityY += gravity;
        y += velocityY;

        // limites
        if (y < 1) {
            y = 1;
            velocityY = 0;
        }
        if (y >= maxHeight - 1) {
            y = maxHeight - 2;
            velocityY = 0;
        }

        jetpackActive = false;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.ANSI.YELLOW);
        graphics.putString(x, y, "J");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}