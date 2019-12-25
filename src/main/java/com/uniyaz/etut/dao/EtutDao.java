package com.uniyaz.etut.dao;

import com.uniyaz.etut.domain.Etut;
import com.uniyaz.etut.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class EtutDao {

    public Etut saveEtut(Etut etut){

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession();) {
            session.getTransaction().begin();

            etut= (Etut) session.merge(etut);

            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return etut;
    }

    public List<Etut> findAllEtut() {
        List<Etut> etutList = null;

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession();) {
            Query query = session.createQuery("Select etut From Etut etut");

            etutList = query.list();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return etutList;
    }

}
