package com.uniyaz.etut.dao;

import com.uniyaz.etut.domain.Ogrenci;
import com.uniyaz.etut.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class OgrenciDao {

    public Ogrenci saveOgrenci(Ogrenci ogrenci) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();
            ogrenci = (Ogrenci) session.merge(ogrenci);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ogrenci;
    }

    public List<Ogrenci> findAllOgrenci() {
        List<Ogrenci> ogrenciList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession();) {
            String hql = "Select ogrenci From Ogrenci ogrenci";
            Query query = session.createQuery(hql);
                ogrenciList = query.list();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ogrenciList;
    }

}
