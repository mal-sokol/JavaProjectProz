package proz;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import proz.database.utils.DbManager;
import proz.utils.FxmlUtils;
import proz.utils.exceptions.ApplicationException;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws ApplicationException
    {
        Parent root = FxmlUtils.fxmlLoader("/fxmlFiles/StartWindow.fxml");
        primaryStage.setTitle("SuperTester3000 - name still in progress");
        primaryStage.setScene(new Scene(root, 560, 340));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/testSys.png")));
        primaryStage.show();

        DbManager.initDatabase();
        //PrepareTestDataBase.insertTestData();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
