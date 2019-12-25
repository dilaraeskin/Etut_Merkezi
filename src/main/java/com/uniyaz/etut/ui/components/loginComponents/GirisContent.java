package com.uniyaz.etut.ui.components.loginComponents;

import com.uniyaz.etut.ui.views.GirisView;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class GirisContent extends VerticalLayout {

    public GirisContent() {

        setWidth(100, Unit.PERCENTAGE);

        GirisView girisView=new GirisView();
        setContent(girisView);

    }

    public void setContent(Component component) {
        this.removeAllComponents();
        addComponent(component);
    }
}