package repository;

import controllers.db.HibernateUtil;
import entity.LoginEntity;
import org.hibernate.Session;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepository {
    Session session = HibernateUtil.getSession();

    public LoginEntity checkCredentials(String userName, String password) {
        String HQL = "FROM users WHERE username = :userName_1 AND password = :password_1";

        LoginEntity loginEntity= session.createQuery(HQL, LoginEntity.class)
                .setParameter("userName_1",userName)
                .setParameter("password_1",password)
                .uniqueResult();

        return loginEntity;

    }
}
