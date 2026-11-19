package service;

import entity.LoginEntity;

public interface LoginService {
    public boolean checkUsernameAndpassword(String userName, String password);
}
