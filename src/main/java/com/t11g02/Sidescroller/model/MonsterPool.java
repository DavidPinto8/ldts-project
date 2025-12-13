package com.t11g02.Sidescroller.model;

import com.t11g02.Sidescroller.model.game.elements.Monster;

import java.util.ArrayList;
import java.util.List;

public class MonsterPool extends ObjectPool<Monster> {

    public MonsterPool(int size) {
        super();
        for (int i = 0; i < size; i++) {
            notInUse.add(new Monster(0, 0));
        }
    }

    public Monster getNewMonsterAt(int x, int y) {
        Monster m = super.getNewObject();
        if (m != null) {
            m.setPosition(new Position(x, y));
        }
        return m;
    }

    public void setMonsters(List<Monster> monsters){
        inUse.addAll(monsters);
    }
}
