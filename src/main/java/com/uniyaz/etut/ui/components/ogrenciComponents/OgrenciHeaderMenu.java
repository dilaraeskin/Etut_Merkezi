package com.uniyaz.etut.ui.components.ogrenciComponents;

import com.uniyaz.MyUI;
import com.uniyaz.etut.ui.components.Content;
import com.uniyaz.etut.ui.components.Header;
import com.uniyaz.etut.ui.components.MenuButton;
import com.uniyaz.etut.ui.components.adminComponents.AdminGeneral;
import com.uniyaz.etut.ui.components.loginComponents.General;
import com.uniyaz.etut.ui.components.loginComponents.GirisContent;
import com.uniyaz.etut.ui.views.AddEtutView;
import com.uniyaz.etut.ui.views.GirisView;
import com.uniyaz.etut.ui.views.ListEtutView;
import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;


public class OgrenciHeaderMenu extends HorizontalLayout {

    private Header header;
    private Content content;

    private MenuButton btnEtutEkle;
    private MenuButton btnEtutListele;
    private MenuButton btnCikis;




    public OgrenciHeaderMenu(Header header, Content content) {
        this.header = header;
        this.content = content;

        setSpacing(true);
        setMargin(true);


        buildEtutEkleButon();
        addComponent(btnEtutEkle);


        buildEtutListeleButon();
        addComponent(btnEtutListele);

        buildCikisButon();
        addComponent(btnCikis);


    }

    private void buildEtutEkleButon() {
        btnEtutEkle = new MenuButton(FontAwesome.PLUS_SQUARE);
        btnEtutEkle.setCaption("Etüt Ekle");
        btnEtutEkle.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                AddEtutView addEtutView = new AddEtutView();
                content.setContent(addEtutView);
            }
        });
    }

    private void buildEtutListeleButon() {
        btnEtutListele = new MenuButton(FontAwesome.PLUS_SQUARE);
        btnEtutListele.setCaption("Etüt Listele");

        btnEtutListele.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                ListEtutView listEtut = new ListEtutView();
                content.setContent(listEtut);
            }
        });
    }

    private void buildCikisButon() {
        btnCikis = new MenuButton(FontAwesome.PLUS_SQUARE);
        btnCikis.setCaption("Çıkış");

        btnCikis.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {


                MyUI myUI;
                myUI=(MyUI) UI.getCurrent();
                General general = new General();
                myUI.setContent(general);
            }
        });
    }
}