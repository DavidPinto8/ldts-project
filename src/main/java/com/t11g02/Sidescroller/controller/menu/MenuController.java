package com.t11g02.Sidescroller.controller.menu;

import com.t11g02.Sidescroller.Game;
import com.t11g02.Sidescroller.controller.Controller;
import com.t11g02.Sidescroller.gui.GUI;
import com.t11g02.Sidescroller.model.game.arena.LoaderArenaBuilder;
import com.t11g02.Sidescroller.model.menu.Menu;
import com.t11g02.Sidescroller.states.GameState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
        }
    }
}
