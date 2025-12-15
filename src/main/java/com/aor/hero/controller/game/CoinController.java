package com.aor.hero.controller.game;

import com.aor.hero.Game;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.Coin;

import java.io.IOException;

public class CoinController extends GameController {

    public CoinController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        getModel().getCoinPool().clearBuffer();
        for(Coin coin : getModel().getCoins()) {
            if(coin.getPosition().equals(getModel().getHero().getPosition())) {
                getModel().increaseScore();
                getModel().getCoinPool().addToRemovalBuffer(coin);
            }
        }
        getModel().getCoinPool().moveCoins();
    }
}
