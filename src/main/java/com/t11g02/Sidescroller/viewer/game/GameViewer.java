package com.t11g02.Sidescroller.viewer.game;

import com.t11g02.Sidescroller.gui.GUI;
import com.t11g02.Sidescroller.model.Position;
import com.t11g02.Sidescroller.model.game.arena.Arena;
import com.t11g02.Sidescroller.model.game.elements.Element;
import com.t11g02.Sidescroller.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {

    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getMonsters(), new MonsterViewer());
        drawElements(gui, getModel().getCoinPool().getInUse(), new CoinViewer());
        drawElements(gui, getModel().getPowerUpPool().getInUse(), new PowerUpViewer());
        drawElement(gui, getModel().getHero(), new HeroViewer());

        // VIDA
        gui.drawText(
                new Position(1, 0),
                "Life: " + getModel().getHero().getEnergy(),
                "#4DD65D"
        );

        // SCORE
        gui.drawText(
                new Position(getModel().getWidth() - 10, 0),
                "Score: " + getModel().getScore().getScore(),
                "#FFD700"
        );
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
