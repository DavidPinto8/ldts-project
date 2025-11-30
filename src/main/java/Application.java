import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Application {
    public static void main(String[] args) throws Exception {
        TerminalSize terminalSize = new TerminalSize(40, 20);
        DefaultTerminalFactory terminalFactory =
                new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);

        Terminal terminal = terminalFactory.createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        JetpackArena arena = new JetpackArena(
                terminalSize.getColumns(),
                terminalSize.getRows()
        );

        Game game = new Game(screen, arena);
        game.run();
    }
}