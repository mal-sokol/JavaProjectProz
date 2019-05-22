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
import proz.database.models.User;
import proz.models.UserDataModel;
import proz.utils.DialogsUtils;
import proz.utils.FxmlUtils;
import proz.utils.converters.UserConverter;
import proz.utils.exceptions.ApplicationException;

import java.util.List;

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

    private void bindModelWithView()
    {
        usernameTextField.textProperty().bindBidirectional(UserDataModel.getCurrentUser().usernameProperty());
        passwordField.textProperty().bindBidirectional(UserDataModel.getCurrentUser().passwordProperty());
        passwordField.disableProperty().bind(UserDataModel.getCurrentUser().usernameProperty().isEmpty());
        teacherCheckBox.disableProperty().bind(UserDataModel.getCurrentUser().passwordProperty().isEmpty());
        loginButton.disableProperty().bind(UserDataModel.getCurrentUser().passwordProperty().isEmpty());
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

    private List<User> getMatchingUser(boolean teacherIsLoggingIn, String username, String password)
    {
        try {
            return UserDataModel.getUserDao().queryForUser(UserDataModel.getUserDao(), username, password, teacherIsLoggingIn);
        } catch (ApplicationException e) {
//            DialogsUtils.errorDialog(e.getMessage()); // wyrzuca dwa dialogi niepotrzebnie
        }
        return null;
    }

    private void loginAsUser(Event event, boolean teacherIsLoggingIn, List<User> userList)
    {
        UserDataModel.setCurrentUser(UserConverter.userToUserFx(userList.get(0)));
        if(teacherIsLoggingIn)
        {
            FxmlUtils.switchScene("/fxmlFiles/TeacherChoiceWindow.fxml",
                    (Node) event.getSource(), "/images/teacher.png");
        }
        else
        {
            FxmlUtils.switchScene("/fxmlFiles/StudentChoiceWindow.fxml",
                    (Node) event.getSource(), "/images/student.png");
        }
    }

    private void loginIfUsernameAndPasswordMatches(Event event, boolean teacherIsLoggingIn, String username, String password)
    {
        List<User> userList;
        userList = getMatchingUser(teacherIsLoggingIn, username, password);
        if(userList == null || userList.isEmpty())// potrzebne oba warunki żeby nie wypluwało błędów
        {
            DialogsUtils.unsuccessfulLoginDialog();
        }
        else
        {
            loginAsUser(event, teacherIsLoggingIn, userList);
        }
    }

    @FXML
    private void login(Event event)
    {
        boolean teacherIsLoggingIn = teacherCheckBox.isSelected();
        String username = usernameTextField.getText().trim();
        String password = passwordField.getText();
        loginIfUsernameAndPasswordMatches(event, teacherIsLoggingIn, username, password);
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

    @FXML
    private void selectWhenEnterPressed(KeyEvent keyEvent)
    {
        if(keyEvent.getCode().equals(KeyCode.ENTER))
        {
            if(teacherCheckBox.isSelected())
                teacherCheckBox.setSelected(false);
            else
                teacherCheckBox.setSelected(true);
        }
    }
}
