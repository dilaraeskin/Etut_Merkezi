package com.uniyaz.etut.ui.components;

import com.uniyaz.etut.ui.views.GirisView;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class Content extends VerticalLayout {

    public Content() {
        setWidth(100, Unit.PERCENTAGE);
    }

    public void setContent(Component component) {
        this.removeAllComponents();
        addComponent(component);
    }
}