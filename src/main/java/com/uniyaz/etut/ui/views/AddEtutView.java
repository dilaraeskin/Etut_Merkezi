package com.uniyaz.etut.ui.views;

import com.uniyaz.etut.dao.EtutDao;
import com.uniyaz.etut.dao.OgrenciDao;
import com.uniyaz.etut.domain.Etut;
import com.uniyaz.etut.domain.enumPackage.EnumDers;
import com.uniyaz.etut.ui.components.KaydetButton;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.*;

public class AddEtutView  extends BaseAddView {

    @PropertyId("id")
    private TextField idField;
    @PropertyId("date")
    private DateField dateField;
    @PropertyId("ogretmen")
    private TextField ogretmenAdField;
    @PropertyId("enumDers")
    private ComboBox enumDersComboCox;
    @PropertyId("ogrenciComboBox")
    private ComboBox ogrenciComboBox;
    private FormLayout mainLayout;
    private BeanItem<Etut> item;
    private FieldGroup binder;


    public AddEtutView() {
        fillViewByEtut(new Etut());
    }

    public void fillViewByEtut(Etut etut) {

        item = new BeanItem<Etut>(etut);
        binder = new FieldGroup(item);
        binder.bindMemberFields(this);


    }

    public void buildMainLayout() {

        mainLayout = new FormLayout();
        addComponent(mainLayout);

        VerticalLayout layout = new VerticalLayout();


        idField = new TextField("Id");
        idField.setEnabled(false);
        layout.addComponent(idField);
        layout.setComponentAlignment(idField, Alignment.MIDDLE_CENTER);


        ogretmenAdField = new TextField("Öğretmen Adı:");
        layout.addComponent(ogretmenAdField);
        layout.setComponentAlignment(ogretmenAdField, Alignment.MIDDLE_CENTER);



        dateField = new DateField("Tarih:");
        dateField.setResolution(Resolution.HOUR);
        layout.addComponent(dateField);
        layout.setComponentAlignment(dateField, Alignment.MIDDLE_CENTER);


        OgrenciDao ogrenciDao = new OgrenciDao();

        ogrenciComboBox = new ComboBox("Öğrenci Seçiniz", ogrenciDao.findAllOgrenci());
        ogrenciComboBox.setCaption("Öğrenci");
        layout.addComponent(ogrenciComboBox);



        layout.setComponentAlignment(ogrenciComboBox, Alignment.MIDDLE_CENTER);


        enumDersComboCox = new ComboBox("Ders Seçin:");
        for (EnumDers value : EnumDers.values()) {
            enumDersComboCox.addItem(value);
        }


        layout.addComponent(enumDersComboCox);
        layout.setComponentAlignment(enumDersComboCox, Alignment.MIDDLE_CENTER);


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
//
//        }
//
//        String ogretmenAdFieldValue = ogretmenAdField.getValue();
//        Date dateFieldValue = dateField.getValue();
//        Ogrenci ogrenciValue= (Ogrenci) ogrenciComboBox.getValue();
//        EnumDers enumDersValue= (EnumDers) enumDersComboCox.getValue();
//
//
//        Etut etut = new Etut();
//        EtutOgrenci etutOgrenci=new EtutOgrenci();
//
//        etut.setId(idFieldValue);
//        etut.setOgretmen(ogretmenAdFieldValue);
//        etut.setDate(dateFieldValue);
//        etut.setEnumDers(enumDersValue);
//        etutOgrenci.setOgrenci(ogrenciValue);
//        etutOgrenci.setEtut(etut);
//
//
//
//        EtutDao etutDao = new EtutDao();
//        EtutOgrenciDao etutOgrenciDao=new EtutOgrenciDao();
//
//        etut = etutDao.saveEtut(etut);
//        idField.setValue(etut.getId().toString());
//
//        etutOgrenci = etutOgrenciDao.save(etutOgrenci);
//
//
//        Notification.show("İşlem Başarılı");
        try {
            binder.commit();
            Etut etut = item.getBean();

            EtutDao etutDao = new EtutDao();
            etut = etutDao.saveEtut(etut);
            idField.setValue(etut.getId().toString());

        } catch (FieldGroup.CommitException e) {
            System.out.println(e.getMessage());
        }
    }


}
