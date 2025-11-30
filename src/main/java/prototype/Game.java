package prototype;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Game {
    private Screen screen;
    private JetpackArena arena;

    public Game(Screen screen, JetpackArena arena) {
        this.screen = screen;
        this.arena = arena;
    }

    public void run() throws IOException {
        while (!arena.isGameOver() && !arena.isWin()) {
            draw();
            KeyStroke key = screen.pollInput();
            if (key != null) {
                if (key.getKeyType() == KeyType.EOF) break;
                if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') break;
                arena.processKey(key);
            }
            arena.update();
            try {
                Thread.sleep(50);
            } catch (InterruptedException ignored) {}
        }

        screen.clear();
        TextGraphics graphics = screen.newTextGraphics();
        if (arena.isWin()) {
            graphics.setForegroundColor(TextColor.ANSI.GREEN);
            graphics.putString(
                    (screen.getTerminalSize().getColumns() / 2) - 2,
                    screen.getTerminalSize().getRows() / 2,
                    "WIN!");
        } else if (arena.isGameOver()) {
            graphics.setForegroundColor(TextColor.ANSI.RED);
            graphics.putString(
                    (screen.getTerminalSize().getColumns() / 2) - 4,
                    screen.getTerminalSize().getRows() / 2,
                    "GAME OVER");
        }
        screen.refresh();
        screen.readInput();
        screen.close();
    }

    private void draw() throws IOException {
        screen.clear();
        TextGraphics graphics = screen.newTextGraphics();
        arena.draw(graphics);
        screen.refresh();
    }
}
