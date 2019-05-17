package proz.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import proz.models.UserFxModel;
import proz.utils.DialogsUtils;
import proz.utils.FxmlUtils;

public class LoginWindowController
{
    @FXML
    private CheckBox teacherCheckBox;
    @FXML
    private Button loginButton;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameTextField;

    private UserFxModel userFxModel = new UserFxModel();

    private void bindModelWithView()
    {
        usernameTextField.textProperty().bindBidirectional(userFxModel.usernameProperty());
        passwordField.textProperty().bindBidirectional(userFxModel.passwordProperty());
        passwordField.disableProperty().bind(userFxModel.usernameProperty().isEmpty());
        teacherCheckBox.disableProperty().bind(userFxModel.passwordProperty().isEmpty());
        loginButton.disableProperty().bind(userFxModel.passwordProperty().isEmpty());
    }

    private void clearPasswordOnUsernameEmpty()
    {
        usernameTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.trim().isEmpty())
                passwordField.clear();
        });
    }

    @FXML
    private void initialize()
    {
        bindModelWithView();
        clearPasswordOnUsernameEmpty();
    }

    @FXML
    private void backToStartWindow(MouseEvent event)
    {
        FxmlUtils.switchScene("/fxmlFiles/StartWindow.fxml", (Node) event.getSource(),
                "/images/testSys.png");

    }

    /* TODO: Tu trzebaby odwołać sie do bazy i sprawdzic czy jest w niej ten uzytkownik z tym hasłem,
    możnaby zrobić query do bazy i sprawdzić czy lista którą zwróci jest pusta, dla ucznia query idzie imie , nazwisko i
    to ze nie jest nauczycielem, a dla nauczyciela imie nazwisko i to ze jest nauczycielem, wybor zalezy od zaznaczenia checkboxa
    co odzwierciedla zmienna teacherIsLoggingIn, trzeba bedzie dopisać to query do userDao
     */
    @FXML
    private void login(Event event)
    {
        boolean teacherIsLoggingIn = teacherCheckBox.isSelected();
        String username = usernameTextField.getText().trim();//Tu jest ten użytkownik
        String password = passwordField.getText();// Tu jest to hasło
        if(teacherIsLoggingIn)
        {
            if(username.equals("Ann") && password.equals("pass"))
            {
                FxmlUtils.switchScene("/fxmlFiles/TeacherChoiceWindow.fxml",
                        (Node) event.getSource(), "/images/teacher.png");
            }
            else
            {
                DialogsUtils.unsuccessfulLoginDialog();
            }
        }
        else
        {
            if(username.equals("Tommy") && password.equals("pass"))
            {
                FxmlUtils.switchScene("/fxmlFiles/StudentChoiceWindow.fxml",
                        (Node) event.getSource(), "/images/student.png");
            }
            else
            {
                DialogsUtils.unsuccessfulLoginDialog();
            }
        }
    }

    @FXML
    private void loginWhenEnterPressed(KeyEvent keyEvent)
    {
        if(keyEvent.getCode().equals(KeyCode.ENTER))
        {
            login(keyEvent);
        }
    }

    @FXML
    private void highlightOnEnterButtonArea(MouseEvent mouseEvent)
    {
        if(mouseEvent.getEventType().equals(MouseEvent.MOUSE_ENTERED))
        {
            ((Button) mouseEvent.getSource()).setEffect(new DropShadow());
        }
    }

    @FXML
    private void stopHighlightingOnExitButtonArea(MouseEvent mouseEvent)
    {
        if(mouseEvent.getEventType().equals(MouseEvent.MOUSE_EXITED))
        {
            ((Button) mouseEvent.getSource()).setEffect(null);
        }
    }
}
