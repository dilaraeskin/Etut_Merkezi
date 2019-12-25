package com.uniyaz.etut.ui.views;

import com.uniyaz.etut.domain.Etut;
import com.vaadin.ui.VerticalLayout;


public  abstract class BaseAddView extends VerticalLayout {

    public BaseAddView() {
        buildMainLayout();
    }

    public abstract void buildMainLayout();

    public abstract void saveView();
}