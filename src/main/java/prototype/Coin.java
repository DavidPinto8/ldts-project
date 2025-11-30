package prototype;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin {
    private int x, y;
    public int score = 0;


    public Coin(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() { x--; }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.ANSI.YELLOW);
        graphics.putString(x, y, "o");
    }



    public int getX() { return x; }
    public int getY() { return y; }
}