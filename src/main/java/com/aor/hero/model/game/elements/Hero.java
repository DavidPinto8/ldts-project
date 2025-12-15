package com.aor.hero.model.game.elements;

public class Hero extends Element {
    private int energy;

    public Hero(int x, int y) {
        super(x, y);
        this.energy = 10;
    }

    public void decreaseEnergy() {
        if (this.energy > 0) {
            this.energy--;
        }
    }

    public void increaseEnergy() {
        if (this.energy < 10) { // máximo de 10
            this.energy++;
        }
    }


    public int getEnergy() {
        return energy;
    }
}
