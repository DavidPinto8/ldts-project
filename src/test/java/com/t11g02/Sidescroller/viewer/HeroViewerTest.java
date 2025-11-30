package com.t11g02.Sidescroller.viewer;

import com.t11g02.Sidescroller.gui.GUI;
import com.t11g02.Sidescroller.model.game.elements.Hero;
import com.t11g02.Sidescroller.viewer.game.HeroViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HeroViewerTest {
    private Hero hero;
    private HeroViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        hero = new Hero(10, 10);
        viewer = new HeroViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(hero, gui);
        Mockito.verify(gui, Mockito.times(1)).drawHero(hero.getPosition());
    }
}