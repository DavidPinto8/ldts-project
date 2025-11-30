package com.t11g02.Sidescroller.states;

import com.t11g02.Sidescroller.controller.Controller;
import com.t11g02.Sidescroller.controller.menu.MenuController;
import com.t11g02.Sidescroller.model.menu.Menu;
import com.t11g02.Sidescroller.viewer.Viewer;
import com.t11g02.Sidescroller.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
