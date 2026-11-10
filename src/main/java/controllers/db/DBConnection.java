package controllers.db;

import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
//    private static Connection connection;
//    private static DBConnection instance;
//   private DBConnection(){
//       try {
//           connection = DriverManager.getConnection(
//                   "jdbc:mysql://localhost:3306/library_management_system_v1",
//                   "root",
//                   "123456789"
//           );
//       } catch (SQLException e) {
//           throw new RuntimeException(e);
//       }
//
//   }
//
//   public static DBConnection getInstance(){
//       if (instance == null){
//           instance = new DBConnection();
//       }
//       return instance;
//   }
//
//   public Connection getConnection(){return connection;}

    Configuration configuration = new Configuration()
            .setProperty("hibernate.connection.url",
                    "jdbc:mysql://localhost:3306/library_management_system_v1?createIfNotExist=true")
                            .setProperty("hibernate.connection.username","root")
                            .setProperty("hibernate.connection.password","123456789")
                            .setProperty("hibernate.hbm2ddl.auto","create")
                            .setProperty("hibernate.show-sql","true")
                            //.addAnnotatedClass()

            ;

}