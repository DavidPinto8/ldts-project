package com.t11g02.Sidescroller.viewer.game;

import com.t11g02.Sidescroller.gui.GUI;
import com.t11g02.Sidescroller.model.game.elements.Hero;

public class HeroViewer implements ElementViewer<Hero> {
    @Override
    public void draw(Hero hero, GUI gui) {
        gui.drawHero(hero.getPosition());
    }
}
