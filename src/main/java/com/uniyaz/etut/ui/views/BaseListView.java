package com.uniyaz.etut.ui.views;

import com.vaadin.ui.VerticalLayout;

public abstract class BaseListView extends VerticalLayout {

    public BaseListView() {
        buildTableContainer();
        buildTable();
        fillTable();


    }

    public abstract void fillTable();

    public abstract void buildTableContainer();


    public abstract void buildTable();


}
