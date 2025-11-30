package com.t11g02.Sidescroller.viewer.game;

import com.t11g02.Sidescroller.gui.GUI;
import com.t11g02.Sidescroller.model.game.elements.Monster;

public class MonsterViewer implements ElementViewer<Monster> {
    @Override
    public void draw(Monster monster, GUI gui) {
        gui.drawMonster(monster.getPosition());
    }
}
