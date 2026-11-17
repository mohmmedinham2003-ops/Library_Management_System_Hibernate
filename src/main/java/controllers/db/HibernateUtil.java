package controllers.db;

import entity.BookEntity;
import entity.IssueBookEntity;
import entity.MemberEntity;
import entity.ReturnBookEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static Session session;
    private static HibernateUtil instance;

    private HibernateUtil(){
        Configuration configure = new Configuration().configure()
                .addAnnotatedClass(MemberEntity.class)
                .addAnnotatedClass(BookEntity.class)
                .addAnnotatedClass(IssueBookEntity.class)
                .addAnnotatedClass(ReturnBookEntity.class);

        SessionFactory sessionFactory = configure.buildSessionFactory();

        Session session = sessionFactory.openSession();

    }
    public static HibernateUtil getInstance(){
        if (instance == null){
            instance = new HibernateUtil();
        }
        return instance;


    }

    public Session getSession(){return session;}
}
