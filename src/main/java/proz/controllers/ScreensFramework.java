package proz.controllers;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreensFramework extends Application {

    public static String startScreenID = "start";
    public static String startScreenFxmLFile = "/fxmlFiles/StartWindow.fxml";
    public static String startScreenImages = "/images/testSys.png";
    public static String loginScreenID = "login";
    public static String loginScreenFxmLFile = "/fxmlFiles/LoginWindow.fxml";

    public static String studentWindowID = "student";
    public static String studentWindowFxmlFile = "/fxmlFiles/StudentChoiceWindow.fxml";

    public static String testScreenID = "test";
    public static String testScreenFxmlFile = "/fxmlFiles/TestWindow.fxml";

    public static String teacherWindowID = "teacher";
    public static String teacherWindowFxmlFile = "/fxmlFiles/TeacherChoiceWindow.fxml";

    @Override
    public void start(Stage primaryStage) {

        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(startScreenID, startScreenFxmLFile);
        mainContainer.loadScreen(loginScreenID, loginScreenFxmLFile);
        mainContainer.loadScreen(studentWindowID, studentWindowFxmlFile);
        mainContainer.loadScreen(testScreenID, testScreenFxmlFile);
        mainContainer.loadScreen(teacherWindowID, teacherWindowFxmlFile);

        mainContainer.setScreen(startScreenID);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}