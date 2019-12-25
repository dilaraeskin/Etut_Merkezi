package com.uniyaz.etut.dao;

import com.uniyaz.etut.domain.Kullanici;
import com.uniyaz.etut.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class KullaniciDao {


    public List<Kullanici> findAllKullanici() {
        List<Kullanici> kullaniciList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql = "Select kullanici From Kullanici kullanici";
            Query query = session.createQuery(hql);
            kullaniciList = query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return kullaniciList;
    }
}
