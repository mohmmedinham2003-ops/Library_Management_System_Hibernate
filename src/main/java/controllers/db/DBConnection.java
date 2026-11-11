package controllers.db;

import entity.BookEntity;
import entity.IssueBookEntity;
import entity.MemberEntity;
import entity.ReturnBookEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static SessionFactory sessionFactory;

public static Session getSessionFactory() {
    Configuration configuration = new Configuration()
            .setProperty("hibernate.connection.url",
                    "jdbc:mysql://localhost:3306/library_management_system_v2?createIfNotExist=true")
            .setProperty("hibernate.connection.username", "root")
            .setProperty("hibernate.connection.password", "123456789")
            .setProperty("hibernate.hbm2ddl.auto", "create")
            .setProperty("hibernate.show-sql", "true")
            .addAnnotatedClass(MemberEntity.class)
            .addAnnotatedClass(BookEntity.class)
            .addAnnotatedClass(IssueBookEntity.class)
            .addAnnotatedClass(ReturnBookEntity.class);

    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.openSession();
    return session;
    }
}