package com.aor.hero.viewer.game;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.elements.PowerUp;

public class PowerUpViewer implements ElementViewer<PowerUp> {
    @Override
    public void draw(PowerUp powerUp, GUI gui) {
        gui.drawPowerUp(powerUp.getPosition());
    }
}
