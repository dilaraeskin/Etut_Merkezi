package com.uniyaz;

import com.uniyaz.etut.dao.KullaniciDao;
import com.uniyaz.etut.domain.Kullanici;
import com.uniyaz.etut.ui.components.adminComponents.AdminGeneral;
import com.uniyaz.etut.ui.components.ogrenciComponents.OgrenciGeneral;
import com.uniyaz.etut.ui.views.GirisView;
import com.vaadin.ui.Label;

import java.util.List;

public class GirisKontrol {
/*
    GirisView girisView=new GirisView();
    String dbUsername;
    String dbPassword;
    String  dbYetki;
    MyUI myUI = new MyUI();

    private void GirisKontrol() {

        KullaniciDao kullaniciDao = new KullaniciDao();
        List<Kullanici> kullaniciList = kullaniciDao.findAllKullanici();
        for (Kullanici kullanici : kullaniciList) {

            String usernameValue = girisView.getUsername().getValue();
            String passwordValue = girisView.getPassword().getValue();


            dbYetki = kullanici.getEnumKullaniciYetki().toString();
            dbUsername = kullanici.getUsername();
            dbPassword = kullanici.getPassword();

            if (usernameValue.equals(dbUsername)) {

                if (passwordValue.equals(dbPassword)) {


                    if (dbYetki.equals("USER")) {
                        OgrenciGeneral ogrenciGeneral = new OgrenciGeneral();
                        myUI.setContent(ogrenciGeneral);
                    }

                    else if (dbYetki.equals("ADMIN")) {
                        AdminGeneral adminGeneral = new AdminGeneral();
                        myUI.setContent(adminGeneral);

                    }
                }
            }
        }
    }
}
*/}