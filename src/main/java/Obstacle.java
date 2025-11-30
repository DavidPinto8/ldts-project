import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Obstacle {
    private int x, y;

    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        x--;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.ANSI.RED);
        graphics.putString(x, y, "X");
    }

    public int getX() { return x; }
    public int getY() { return y; }
}