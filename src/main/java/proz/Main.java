package proz;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import proz.utils.FxmlUtils;
import proz.utils.exceptions.ApplicationException;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws ApplicationException
    {
        Parent root = FxmlUtils.fxmlLoader("/fxmlFiles/StartWindow.fxml");
        primaryStage.setTitle("SuperTester");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/testSys.png")));
        primaryStage.show();

        //PrepareTestDataBase.insertTestData();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
