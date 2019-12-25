package com.uniyaz.etut.ui.components.ogrenciComponents;

import com.uniyaz.etut.ui.components.Content;
import com.uniyaz.etut.ui.components.Header;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;


public class OgrenciContainer extends VerticalLayout {

    private Header header;

    public OgrenciContainer(Header header) {
        this.header = header;
        setWidth(100, Unit.PERCENTAGE);


        Content content = new Content();
        OgrenciHeaderMenu sideBar = new OgrenciHeaderMenu(header, content);

        addComponent(sideBar);
        addComponent(content);

        setExpandRatio(sideBar, 2f);
        setExpandRatio(content, 8f);
    }

}
