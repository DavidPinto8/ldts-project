import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JetpackArena {
    private int width, height;
    private JetpackPlayer player;
    private List<Obstacle> obstacles;
    private List<Coin> coins;
    private boolean gameOver = false;
    private boolean win = false;
    private Random random = new Random();
    private boolean jetpackPressed = false;

    public JetpackArena(int width, int height) {
        this.width = width;
        this.height = height;
        this.player = new JetpackPlayer(5, height / 2);
        this.obstacles = new ArrayList<>();
        this.coins = new ArrayList<>();
    }

    public boolean isGameOver() { return gameOver; }
    public boolean isWin() { return win; }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#202020"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width,height),' ');
        graphics.setForegroundColor(TextColor.ANSI.WHITE);
        graphics.putString(1,0,"Score: " + player.getScore());
        for (Obstacle o : obstacles) o.draw(graphics);
        for (Coin c : coins) c.draw(graphics);
        player.draw(graphics);
    }

    public void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp ||
                (key.getKeyType() == KeyType.Character && key.getCharacter() == 'w')) {
            jetpackPressed = true;
        }
    }

    public void update() {
        if (jetpackPressed) player.activateJetpack();
        jetpackPressed = false;

        player.update(height);
        moveObstacles();
        moveCoins();
        spawnObstacles();
        spawnCoins();
        checkCollisions();

        if (player.getScore() >= 10) win = true;
    }

    private void moveObstacles() {
        List<Obstacle> remove = new ArrayList<>();
        for (Obstacle o : obstacles) {
            o.move();
            if (o.getX() < 0) remove.add(o);
        }
        obstacles.removeAll(remove);
    }

    private void moveCoins() {
        List<Coin> remove = new ArrayList<>();
        for (Coin c : coins) {
            c.move();
            if (c.getX() < 0) remove.add(c);
        }
        coins.removeAll(remove);
    }

    private void spawnObstacles() {
        if (random.nextInt(10) == 0) {
            obstacles.add(new Obstacle(width - 1, random.nextInt(height - 2) + 1));
        }
    }

    private void spawnCoins() {
        if (random.nextInt(20) == 0) {
            coins.add(new Coin(width - 1, random.nextInt(height - 2) + 1));
        }
    }

    private void checkCollisions() {
        for (Obstacle o : obstacles) {
            if (o.getX() == player.getX() && o.getY() == player.getY()) gameOver = true;
        }
        Coin toRemove = null;
        for (Coin c : coins) {
            if (c.getX() == player.getX() && c.getY() == player.getY()) {
                toRemove = c;
                player.addCoin();
            }
        }
        if (toRemove != null) coins.remove(toRemove);
    }
}
