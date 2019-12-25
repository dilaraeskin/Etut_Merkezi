package com.uniyaz.etut.ui.views;

import com.uniyaz.etut.dao.OgrenciDao;
import com.uniyaz.etut.domain.Ogrenci;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;

import java.util.List;

public class OgrenciListeleView extends BaseListView {

    private Table table;
    private IndexedContainer indexedContainer;
    private OgrenciEkleView ogrenciEkleView;

    public OgrenciListeleView() {

       // buildTableContainer();


        HorizontalLayout layout = new HorizontalLayout();
     //   buildTable();
        layout.addComponent(table);
        layout.setComponentAlignment(table, Alignment.MIDDLE_CENTER);

        ogrenciEkleView = new OgrenciEkleView();
        layout.addComponent(ogrenciEkleView);
        layout.setComponentAlignment(ogrenciEkleView, Alignment.TOP_RIGHT);

        layout.setSpacing(true);
        layout.setMargin(true);
        layout.setMargin(true);
        addComponent(layout);
        setComponentAlignment(layout,Alignment.MIDDLE_CENTER);

     //   fillTable();
    }

    public void fillTable() {

        OgrenciDao ogrenciDao = new OgrenciDao();
        List<Ogrenci> ogrenciList = ogrenciDao.findAllOgrenci();

        for (Ogrenci ogrenci : ogrenciList) {
            Item item = indexedContainer.addItem(ogrenci);
            item.getItemProperty("id").setValue(ogrenci.getId());
            item.getItemProperty("ogrenciAd").setValue(ogrenci.getOgrenciAd());
            item.getItemProperty("sinif").setValue(ogrenci.getSinif());
        }
    }

    public void buildTableContainer() {

        indexedContainer = new IndexedContainer();
        indexedContainer.addContainerProperty("id", Long.class, null);
        indexedContainer.addContainerProperty("ogrenciAd", String.class, null);
        indexedContainer.addContainerProperty("sinif", Integer.class, null);
    }

    public void buildTable() {
        table = new Table();
        table.setContainerDataSource(indexedContainer);
        table.setColumnHeaders("ÖĞRENCİ NO", "İSİM","SINIF");
        table.setSelectable(true);
        table.setMultiSelectMode(MultiSelectMode.SIMPLE);
        table.setMultiSelect(false);
        table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent itemClickEvent) {
                Ogrenci ogrenci = (Ogrenci) itemClickEvent.getItemId();
                ogrenciEkleView.fillViewByOgrenci(ogrenci);
            }
        });
    }
}
