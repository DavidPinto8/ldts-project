package com.t11g02.Sidescroller.states;

import com.t11g02.Sidescroller.controller.Controller;
import com.t11g02.Sidescroller.controller.game.ArenaController;
import com.t11g02.Sidescroller.model.game.arena.Arena;
import com.t11g02.Sidescroller.viewer.Viewer;
import com.t11g02.Sidescroller.viewer.game.GameViewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}
