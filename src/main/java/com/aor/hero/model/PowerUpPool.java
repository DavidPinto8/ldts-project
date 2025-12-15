package com.aor.hero.model;

import com.aor.hero.model.game.elements.PowerUp;

import java.util.ArrayList;
import java.util.List;

public class PowerUpPool {
    private final List<PowerUp> inUse;
    private final List<PowerUp> notInUse;
    private final List<PowerUp> removalBuffer;

    public PowerUpPool(int size) {
        inUse = new ArrayList<>();
        notInUse = new ArrayList<>();
        removalBuffer = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            notInUse.add(new PowerUp(0, 0));
        }
    }

    public void spawnAt(int x, int y) {
        if (notInUse.isEmpty()) return;
        PowerUp p = notInUse.remove(0);
        p.setPosition(new Position(x, y));
        inUse.add(p);
    }

    public void addToRemovalBuffer(PowerUp p) {
        removalBuffer.add(p);
    }

    public void clearBuffer() {
        for (PowerUp p : removalBuffer) {
            inUse.remove(p);
            notInUse.add(p);
        }
        removalBuffer.clear();
    }

    public List<PowerUp> getInUse() {
        return inUse;
    }
    public void movePowerUps() {
        for (PowerUp p : inUse) {
            p.setPosition(p.getPosition().getLeft());
            if (p.getPosition().getX() < 0) {
                addToRemovalBuffer(p); // Remove power-ups que saem da tela
            }
        }
        clearBuffer();
    }
}
