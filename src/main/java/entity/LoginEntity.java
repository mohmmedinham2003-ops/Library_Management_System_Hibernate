package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "adminT")
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userName;
    private String password;

    public LoginEntity() {
    }

    public LoginEntity(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginEntity{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
