package com.uniyaz.etut.ui.views;

import com.uniyaz.etut.dao.EtutDao;
import com.uniyaz.etut.domain.enumPackage.EnumDers;
import com.uniyaz.etut.domain.Etut;
import com.uniyaz.etut.domain.EtutOgrenci;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;

import java.util.Date;
import java.util.List;

public class ListEtutView extends BaseListView {

    private Table table;

    private IndexedContainer indexedContainer;
    private AddEtutView addEtutView;


    EtutOgrenci etutOgrenci;
    Etut etut;

    public ListEtutView() {
     //   buildTableContainer();

        HorizontalLayout layout = new HorizontalLayout();
      //  buildTable();
        layout.addComponent(table);
        layout.setComponentAlignment(table, Alignment.MIDDLE_CENTER);

        addEtutView = new AddEtutView();
        layout.addComponent(addEtutView);
        layout.setComponentAlignment(addEtutView, Alignment.TOP_RIGHT);

        layout.setSpacing(true);
        layout.setMargin(true);
        layout.setMargin(true);
        addComponent(layout);
        setComponentAlignment(layout,Alignment.MIDDLE_CENTER);
      //  fillTable();
    }


    public void fillTable() {
        EtutDao etutDao = new EtutDao();

        List<Etut> etutList = etutDao.findAllEtut();

        for (Etut etut : etutList) {
            Item item = indexedContainer.addItem(etut);
            item.getItemProperty("id").setValue(etut.getId());
            item.getItemProperty("date").setValue(etut.getDate());
            item.getItemProperty("Ders").setValue(etut.getEnumDers());
            item.getItemProperty("ogretmen").setValue(etut.getOgretmen());
//            item.getItemProperty("ogrenci").setValue(etutOgrenci.getOgrenci());

        }
//        for (EtutOgrenci etutOgrenci : etutOgrenciList) {
//            Item item2 = indexedContainer.addItem(etutOgrenci);
//            item2.getItemProperty("ogrenci").setValue(etutOgrenci.getOgrenci());
//
//        }
    }

    public void buildTableContainer() {

        indexedContainer = new IndexedContainer();
        indexedContainer.addContainerProperty("id", Long.class, null);
        indexedContainer.addContainerProperty("date", Date.class, null);
        indexedContainer.addContainerProperty("Ders", EnumDers.class, null);
        indexedContainer.addContainerProperty("ogretmen", String.class, null);

    }



    public void buildTable() {
        table = new Table();

        table.setContainerDataSource(indexedContainer);
        table.setColumnHeaders("ID","TARİH", "DERS", "ÖĞRETMEN ADI");
        table.setSelectable(true);
        table.setMultiSelectMode(MultiSelectMode.SIMPLE);
        table.setMultiSelect(false);

        table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent itemClickEvent) {
                etut = (Etut) itemClickEvent.getItemId();

                addEtutView.fillViewByEtut(etut);
            }
        });
    }
}
