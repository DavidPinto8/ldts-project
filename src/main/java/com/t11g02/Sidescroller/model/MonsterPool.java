package com.t11g02.Sidescroller.model;

import com.t11g02.Sidescroller.model.game.elements.Monster;

import java.util.ArrayList;
import java.util.List;

public class MonsterPool {
    private final List<Monster> inUse;
    private List<Monster> notInUse;
    private List<Monster> removalBuffer;

    public MonsterPool(int size) {
        inUse = new ArrayList<>();
        notInUse = new ArrayList<>();
        removalBuffer = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            notInUse.add(new Monster(0, 0));
        }
    }

    public void getNewMonsterAt(int x, int y) {
        if (notInUse.isEmpty()){ //The arena has too many monsters
            return;
        }
        Monster m = notInUse.removeFirst();
        m.setPosition(new Position(x, y));
        inUse.add(m);
    }

    public void clearBuffer() {
        for (Monster m : removalBuffer) {
            inUse.remove(m);
            notInUse.add(m);
        }
        removalBuffer.clear();
    }

    public void addToRemovalBuffer(Monster monster) {
        removalBuffer.add(monster);
    }

    public List<Monster> getInUse() {
        return inUse;
    }

    public void setMonsters(List<Monster> monsters){
        inUse.addAll(monsters);
    }
}
