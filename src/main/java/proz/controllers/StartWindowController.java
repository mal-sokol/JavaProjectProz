package proz.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import proz.utils.DialogsUtils;
import proz.utils.FxmlUtils;
import java.util.Optional;

public class StartWindowController implements ControlledScreen
{
    private ScreensController myController;

    @FXML
    public void goToLoginPanel(MouseEvent event)
    {

        if(event.getEventType().equals(MouseEvent.MOUSE_CLICKED))
        {
            myController.setScreen(ScreensFramework.loginScreenID);
        }
//        FxmlUtils.switchScene("/fxmlFiles/LoginWindow.fxml", (Node) event.getSource(),
//                "/images/Lock.png");
    }

    private void exitOnOkPressed(Optional<ButtonType> result) {
        if(result.isPresent() && result.get() == ButtonType.OK)
            Platform.exit();
    }

    @FXML
    private void exitProgram()
    {
        Optional<ButtonType> result = DialogsUtils.exitConfirmationDialog();
        exitOnOkPressed(result);
    }

    @FXML
    private void showInformationDialog()
    {
        DialogsUtils.aboutApplicationDialog();
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

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
}
