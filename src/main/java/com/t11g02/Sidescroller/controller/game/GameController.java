package com.t11g02.Sidescroller.controller.game;

import com.t11g02.Sidescroller.controller.Controller;
import com.t11g02.Sidescroller.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
