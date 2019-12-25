package com.uniyaz.etut.dao;

import com.uniyaz.etut.domain.EtutOgrenci;
import com.uniyaz.etut.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class EtutOgrenciDao {

    public EtutOgrenci save(EtutOgrenci etutOgrenci){

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();

            etutOgrenci= (EtutOgrenci) session.merge(etutOgrenci);

            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return etutOgrenci;
    }

    public List<EtutOgrenci> findAllEtut() {
        List<EtutOgrenci> EtutOgrenciList = null;

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession();) {
            Query query = session.createQuery("Select etutOgrenci From EtutOgrenci etutOgrenci" +
                                                 " left join fetch etutOgrenci.ogrenci ogrenci " +
                                                 "left join fetch etutOgrenci.etut etut");

            EtutOgrenciList = query.list();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return EtutOgrenciList;
    }
}
