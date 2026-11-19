package controllers.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import scene.SceneManager;
import service.LoginService;
import service.LoginServiceImpl;

public class LoginPageController {
    LoginService loginService = new LoginServiceImpl();
    Stage stage = new Stage();

    @FXML
    private Button btnClear;

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnClearOnAction(ActionEvent event) {
    txtUserName.clear();
    txtPassword.clear();
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) {

         if(loginService.checkUsernameAndpassword(txtUserName.getText(),txtPassword.getText())){
           SceneManager.switchPage("/view/main_dashboard.fxml");

         }

    }
}
