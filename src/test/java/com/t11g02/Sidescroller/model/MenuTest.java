package com.t11g02.Sidescroller.model;

import com.t11g02.Sidescroller.model.menu.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuTest {
    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu();
    }

    @Test
    void getNumberEntries() {
        Assertions.assertEquals(2, menu.getNumberEntries());
    }

    @Test
    void getEntry() {
        Assertions.assertEquals("Start", menu.getEntry(0));
        Assertions.assertEquals("Exit", menu.getEntry(1));
    }

    @Test
    void moveEntries() {
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedExit());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedStart());
        menu.previousEntry();
        Assertions.assertTrue(menu.isSelectedExit());
        menu.previousEntry();
        Assertions.assertTrue(menu.isSelectedStart());
    }

    @Test
    void isSelected() {
        Assertions.assertTrue(menu.isSelected(0));
        Assertions.assertFalse(menu.isSelected(1));
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelected(1));
        Assertions.assertFalse(menu.isSelected(0));
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelected(0));
        Assertions.assertFalse(menu.isSelected(1));
    }
}
