package com.t11g02.Sidescroller.viewer.game;

import com.t11g02.Sidescroller.gui.GUI;
import com.t11g02.Sidescroller.model.game.elements.PowerUp;

public class PowerUpViewer implements ElementViewer<PowerUp> {
    @Override
    public void draw(PowerUp powerUp, GUI gui) {
        gui.drawText(powerUp.getPosition(), "*", "#FFD700");
    }
}
