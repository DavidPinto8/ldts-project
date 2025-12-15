package com.t11g02.Sidescroller.viewer.game;

import com.t11g02.Sidescroller.gui.GUI;
import com.t11g02.Sidescroller.model.game.elements.Coin;

public class CoinViewer implements ElementViewer<Coin> {
    @Override
    public void draw(Coin coin, GUI gui) {
        gui.drawText(coin.getPosition(), "C", "#FFD700");
    }
}
