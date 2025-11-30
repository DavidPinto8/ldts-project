package com.t11g02.Sidescroller.viewer.game;

import com.t11g02.Sidescroller.gui.GUI;
import com.t11g02.Sidescroller.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
