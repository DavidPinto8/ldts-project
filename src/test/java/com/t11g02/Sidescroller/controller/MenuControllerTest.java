package com.t11g02.Sidescroller.controller;

import com.t11g02.Sidescroller.controller.menu.MenuController;
import com.t11g02.Sidescroller.model.menu.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class MenuControllerTest {
    private Menu menuModel;
    private MenuController menuController;

    @BeforeEach
    void setUp(){
        menuModel = new Menu();
        menuController = new MenuController(menuModel);
    }

    @Test
    void step() throws IOException {
        Assertions.assertTrue(menuModel.isSelectedStart());
        menuController.step(null, com.t11g02.Sidescroller.gui.GUI.ACTION.UP, 0);
        Assertions.assertTrue(menuModel.isSelectedExit());
        menuController.step(null, com.t11g02.Sidescroller.gui.GUI.ACTION.DOWN, 0);
        Assertions.assertTrue(menuModel.isSelectedStart());
        menuController.step(null, com.t11g02.Sidescroller.gui.GUI.ACTION.DOWN, 0);
        Assertions.assertTrue(menuModel.isSelectedExit());
    }
}
