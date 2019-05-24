package proz.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FxmlUtils
{
    private FxmlUtils() {}

    public static Pane fxmlLoader(String fxmlPath)
    {
        FXMLLoader loader = new FXMLLoader(FxmlUtils.class.getResource(fxmlPath));
        try
        {
            return loader.load();
        }
        catch (Exception e)
        {
            DialogsUtils.errorDialog(e.getMessage());
        }
        return null;
    }

    public static FXMLLoader getLoader(String fxmlPath)
    {
        return new FXMLLoader(FxmlUtils.class.getResource(fxmlPath));
    }

    public static void changeApplicationImage(Stage stage, String pathToImage)
    {
        stage.getIcons().clear();
        stage.getIcons().add(new Image(FxmlUtils.class.getResourceAsStream(pathToImage)));
    }

    public static void switchScene(String pathToNextScene, Node currentNode, String pathToImage)
    {
        Parent parent = FxmlUtils.fxmlLoader(pathToNextScene);
        Scene scene = new Scene(parent);
        Stage stage = (Stage) currentNode.getScene().getWindow();
        stage.hide();
        FxmlUtils.changeApplicationImage(stage, pathToImage);
        stage.setScene(scene);
        stage.show();
    }

    public static void createNewStageDialog(String pathToScene, String pathToImage)
    {
        Parent parent = FxmlUtils.fxmlLoader(pathToScene);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.hide();
        FxmlUtils.changeApplicationImage(stage, pathToImage);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
