package proz.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class TestWindowController implements ControlledScreen
{
    private ScreensController myController;


    @FXML
    private TableView<?> questionsTable;

    @FXML
    private Button submitTestButton;

    @FXML
    private Button escapeButton;

    @FXML
    private Label questionLabel;

    @FXML
    private CheckBox answerA;

    @FXML
    private CheckBox answerB;

    @FXML
    private CheckBox answerC;

    @FXML
    private CheckBox answerD;

    @FXML
    private Button previousButton;

    @FXML
    private Button submitButton;

    @FXML
    private Button nextButton;


    @FXML
    void goBack(Event event) {
        if(event.getEventType().equals(javafx.scene.input.MouseEvent.MOUSE_CLICKED))
        {
            myController.setScreen(ScreensFramework.studentWindowID);
        }
    }

    @FXML
    void highlightOnEnterButtonArea(Event event) {
        if(event.getEventType().equals(javafx.scene.input.MouseEvent.MOUSE_ENTERED))
        {
            ((Button) event.getSource()).setEffect(new DropShadow());
        }
    }

    @FXML
    void stopHighlightingOnExitButtonArea(Event event) {
        if(event.getEventType().equals(javafx.scene.input.MouseEvent.MOUSE_EXITED))
        {
            ((Button) event.getSource()).setEffect(null);
        }
    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
}
