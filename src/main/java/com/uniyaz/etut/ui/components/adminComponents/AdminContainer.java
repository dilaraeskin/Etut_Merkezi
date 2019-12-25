package com.uniyaz.etut.ui.components.adminComponents;

import com.uniyaz.etut.ui.components.Content;
import com.uniyaz.etut.ui.components.Header;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;


public class AdminContainer extends VerticalLayout {

    private Header header;

    public AdminContainer(Header header) {
        this.header = header;
        setWidth(100, Unit.PERCENTAGE);


        Content content = new Content();
        AdminHeaderMenu sideBar = new AdminHeaderMenu(header, content);

        addComponent(sideBar);
        addComponent(content);

        setExpandRatio(sideBar, 2f);
        setExpandRatio(content, 8f);
    }

}
