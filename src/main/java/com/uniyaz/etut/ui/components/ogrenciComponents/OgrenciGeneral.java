package com.uniyaz.etut.ui.components.ogrenciComponents;

import com.uniyaz.etut.ui.components.Header;
import com.vaadin.ui.VerticalLayout;

public class OgrenciGeneral extends VerticalLayout {

    public OgrenciGeneral() {
        Header header = new Header();
        addComponent(header);

        OgrenciContainer ogrenciContainer = new OgrenciContainer(header);
        addComponent(ogrenciContainer);
    }
}