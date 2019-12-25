package com.uniyaz.etut.ui.components.adminComponents;

import com.uniyaz.MyUI;
import com.uniyaz.etut.ui.components.Content;
import com.uniyaz.etut.ui.components.Header;
import com.uniyaz.etut.ui.components.MenuButton;
import com.uniyaz.etut.ui.components.loginComponents.General;
import com.uniyaz.etut.ui.views.AddEtutView;
import com.uniyaz.etut.ui.views.ListEtutView;
import com.uniyaz.etut.ui.views.OgrenciEkleView;
import com.uniyaz.etut.ui.views.OgrenciListeleView;
import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;

@Theme("tests-valo-dark")
public class AdminHeaderMenu extends HorizontalLayout {

    private Header header;
    private Content content;

    private MenuButton btnEtutEkle;
    private MenuButton btnEtutListele;

    private MenuButton btnOgrenciEkle;
    private MenuButton btnOgrenciListele;

    private MenuButton btnEtutOgrenciEkle;
    private MenuButton btnEtutOgrenciListele;

    private MenuButton btnCikis;


    public AdminHeaderMenu(Header header, Content content) {

        this.header = header;
        this.content = content;

        setSpacing(true);
        setMargin(true);

        buildEtutEkleButon();
        addComponent(btnEtutEkle);

        buildEtutListeleButon();
        addComponent(btnEtutListele);

        buildOgrenciEkleButon();
        addComponent(btnOgrenciEkle);


        buildOgrenciListeleButon();
        addComponent(btnOgrenciListele);


        buildEtutOgrenciEkleButon();
        addComponent(btnEtutOgrenciEkle);


        buildEtutOgrenciListeleButon();
        addComponent(btnEtutOgrenciListele);

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

    private void buildOgrenciEkleButon() {
        btnOgrenciEkle = new MenuButton(FontAwesome.PLUS_SQUARE);
        btnOgrenciEkle.setCaption("Öğrenci Ekle");
        btnOgrenciEkle.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {


                OgrenciEkleView ogrenciEkleView = new OgrenciEkleView();
                content.setContent(ogrenciEkleView);
            }
        });
    }

    private void buildOgrenciListeleButon() {
        btnOgrenciListele = new MenuButton(FontAwesome.PLUS_SQUARE);
        btnOgrenciListele.setCaption("Öğrenci Listele");
        btnOgrenciListele.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                OgrenciListeleView ogrenciListeleView = new OgrenciListeleView();
                content.setContent(ogrenciListeleView);
            }
        });
    }

    private void buildEtutOgrenciEkleButon() {
        btnEtutOgrenciEkle = new MenuButton(FontAwesome.PLUS_SQUARE);
        btnEtutOgrenciEkle.setCaption("Etüt Öğrenci Ekle");
        btnEtutOgrenciEkle.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {


            }
        });
    }

    private void buildEtutOgrenciListeleButon() {
        btnEtutOgrenciListele = new MenuButton(FontAwesome.PLUS_SQUARE);
        btnEtutOgrenciListele.setCaption("Etüt Öğrenci Listele");
        btnEtutOgrenciListele.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {


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
                myUI = (MyUI) UI.getCurrent();
                General general = new General();
                myUI.setContent(general);
            }
        });
    }
}