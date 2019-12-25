package com.uniyaz.etut.ui.components;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;


public class Header extends VerticalLayout {

    public Header() {
        setWidth(100, Unit.PERCENTAGE);
        setHeight(100, Unit.PIXELS);
        Image image=new Image(null,new ExternalResource("../VAADIN/themes/mytheme/images/meb_banner.jpg"));
        image.setSizeFull();
        addComponent(image);

    }
}
