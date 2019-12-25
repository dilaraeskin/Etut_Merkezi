package com.uniyaz.etut.ui.views;

import com.uniyaz.etut.dao.EtutDao;
import com.uniyaz.etut.dao.OgrenciDao;
import com.uniyaz.etut.domain.Etut;
import com.uniyaz.etut.domain.Ogrenci;
import com.uniyaz.etut.ui.components.KaydetButton;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;

public class OgrenciEkleView extends BaseAddView {

    @PropertyId("id")
    private TextField idField;
    @PropertyId("ogrenciAd")
    private TextField ogrenciAdField;
    @PropertyId("sinif")
    private TextField sinifField;

    private FormLayout mainLayout;
    private BeanItem<Ogrenci> item;
    private FieldGroup binder;

    public OgrenciEkleView() {
        fillViewByOgrenci(new Ogrenci());
    }

    public void fillViewByOgrenci(Ogrenci ogrenci) {
        item = new BeanItem<Ogrenci>(ogrenci);
        binder = new FieldGroup(item);
        binder.bindMemberFields(this);
    }

    public void buildMainLayout() {
        mainLayout = new FormLayout();
        addComponent(mainLayout);


        VerticalLayout layout = new VerticalLayout();

        idField = new TextField("Ögrenci No:");
        idField.setEnabled(false);
        layout.addComponent(idField);
        layout.setComponentAlignment(idField, Alignment.MIDDLE_CENTER);


        ogrenciAdField = new TextField("Ögrenci Ad");
        layout.addComponent(ogrenciAdField);
        layout.setComponentAlignment(ogrenciAdField, Alignment.MIDDLE_CENTER);


        sinifField = new TextField("Sınıf:");
        layout.addComponent(sinifField);
        layout.setComponentAlignment(sinifField, Alignment.MIDDLE_CENTER);


        KaydetButton kaydetButton = new KaydetButton();
        kaydetButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

               saveView();
            }
        });
        layout.addComponent(kaydetButton);
        layout.setComponentAlignment(kaydetButton, Alignment.MIDDLE_CENTER);
        mainLayout.addComponent(layout);

    }

    @Override
    public void saveView() {
//        Long idFieldValue = null;
//        if (idField.getValue() != "") {
//            idFieldValue = Long.parseLong(idField.getValue());
//        }
//        String ogrenciAdValue = ogrenciAdField.getValue();
//
//        String sinifValue=sinifField.getValue();
//        int sinifValueint=Integer.parseInt(sinifValue);
//
//
//        Ogrenci ogrenci = new Ogrenci();
//        ogrenci.setId(idFieldValue);
//        ogrenci.setOgrenciAd(ogrenciAdValue);
//        ogrenci.setSinif(sinifValueint);
//
//        OgrenciDao ogrenciDao = new OgrenciDao();
//        ogrenci = ogrenciDao.saveOgrenci(ogrenci);
//        idField.setValue(ogrenci.getId().toString());

        try {
            binder.commit();
            Ogrenci ogrenci = item.getBean();

            OgrenciDao ogrenciDao = new OgrenciDao();
            ogrenci = ogrenciDao.saveOgrenci(ogrenci);
            idField.setValue(ogrenci.getId().toString());

        } catch (FieldGroup.CommitException e) {
            System.out.println(e.getMessage());
        }
    }
}