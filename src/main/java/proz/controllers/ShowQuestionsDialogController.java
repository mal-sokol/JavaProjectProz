package proz.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import proz.database.daos.QuestionDao;
import proz.models.AnswerDataModel;
import proz.models.QuestionDataModel;
import proz.models.QuestionFxModel;
import proz.models.TestDataModel;
import proz.utils.DialogsUtils;
import proz.utils.FxmlUtils;
import proz.utils.exceptions.ApplicationException;

import java.io.IOException;
import java.util.Optional;

public class ShowQuestionsDialogController
{
    @FXML
    private TableView<QuestionFxModel> questionTable;
    @FXML
    private ContextMenu questionContextMenu;

    private void loadAnswersOnQuestionPicked()
    {
        questionTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            QuestionDataModel.setQuestion(newValue);
            if(QuestionDataModel.getQuestion() != null)
            {
                try {
                    AnswerDataModel.getAnswersFromQuestion(QuestionDataModel.getQuestion().getQuestionId());
                } catch (ApplicationException e) {
                    DialogsUtils.errorDialog(e.getMessage());
                }
            }
        });
    }

    private void disableContextMenusOptionsWhenCannotBeUsed()
    {
        questionContextMenu.getItems().get(1).disableProperty().bind(questionTable.getSelectionModel()
                .selectedItemProperty().isNull());
        questionContextMenu.getItems().get(2).disableProperty().bind(questionTable.getSelectionModel()
                .selectedItemProperty().isNull());
    }

    @FXML
    private void initialize()
    {
        questionTable.setItems(QuestionDataModel.getQuestions());
        loadAnswersOnQuestionPicked();
        disableContextMenusOptionsWhenCannotBeUsed();
        if(!questionTable.getItems().isEmpty())
            questionTable.getSelectionModel().selectFirst();

    }

    @FXML
    private void addQuestion()
    {
        if(TestDataModel.getTest() == null)
        {
            DialogsUtils.testNotSelectedDialog();
        }
        else
        {
            FxmlUtils.createNewStageDialog("/fxmlFiles/AddQuestionDialog.fxml", "/images/teacher.png");
        }
    }

    @FXML
    private void editQuestion()
    {
        if(QuestionDataModel.getQuestion() == null)
        {
            DialogsUtils.questionNotSelectedDialog();
        }
        else
        {
            FXMLLoader loader = FxmlUtils.getLoader("/fxmlFiles/EditQuestionDialog.fxml");
            Scene newScene = null;
            try {
                newScene = new Scene(loader.load());
            } catch (IOException e) {
                DialogsUtils.errorDialog(e.getMessage());
            }
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.hide();
            EditQuestionDialogController controller = loader.getController();
            controller.setViewElementsToTheirExistingValues();
            FxmlUtils.changeApplicationImage(stage, "/images/teacher.png");
            stage.setScene(newScene);
            stage.showAndWait();
        }
    }

    @FXML
    private void deleteQuestionWithAnswers(ActionEvent event)
    {
        QuestionFxModel selectedQuestion = QuestionDataModel.getQuestion();
        if(selectedQuestion== null)
        {
            DialogsUtils.questionNotSelectedDialog();
        }
        else
        {
            Optional<ButtonType> result = DialogsUtils.DeleteQuestionConfirmationDialog();
            deleteQuestionWhenOkPressed(selectedQuestion, result);
        }
    }

    private void deleteQuestionWhenOkPressed(QuestionFxModel selectedQuestion, Optional<ButtonType> result)
    {
        if(result.isPresent() && result.get() == ButtonType.OK)
        {
            try {
                QuestionDataModel.deleteQuestion(selectedQuestion);
            } catch (ApplicationException e) {
                DialogsUtils.errorDialog(e.getMessage());
            }
            questionTable.getSelectionModel().selectNext();
            questionTable.refresh();
        }
    }
}
