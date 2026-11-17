package service;

import controllers.db.DBConnection;
import entity.LoginEntity;
import repository.LoginRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServiceImpl {
    LoginRepository loginRepository = new LoginRepository();

    public boolean checkUsernameAndpassword(String userName, String password) {
    LoginEntity loginEntity =  loginRepository.checkCredentials(userName,password);

    if (loginEntity.getUserName().equals(userName) & loginEntity.getPassword().equals(password)){
        return true;
    }
    return false;
    }

}
