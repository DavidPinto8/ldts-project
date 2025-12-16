package com.t11g02.Sidescroller.model.game.elements;

public class Hero extends Element {

    private int energy = 10;
    private long lastHitTime = 0;

    public Hero(int x, int y) {
        super(x, y);
    }

    public int getEnergy() {
        return energy;
    }

    public void increaseEnergy() {
        energy++;
    }

    public void decreaseEnergy(long hitTime) {
        if (hitTime - lastHitTime > 550) { // evita que perda muita energia de uma vez (os monstros movem-se a cada 500)
            energy--;
            lastHitTime = hitTime;
        }
    }
}
