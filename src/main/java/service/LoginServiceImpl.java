package service;

import controllers.db.DBConnection;
import repository.LoginRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServiceImpl {
    LoginRepository loginRepository = new LoginRepository();

    public boolean checkUsernameAndpassword(String userName, String password) {
    return loginRepository.checkCredentials(userName,password);

    }

}
