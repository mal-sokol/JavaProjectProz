package proz.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import proz.utils.DialogsUtils;
import javafx.util.Duration;
import proz.utils.FxmlUtils;

import java.util.HashMap;

public class ScreensController extends StackPane {

    private HashMap<String, Node> screens = new HashMap<>();

    public ScreensController() {
        super();
        super.setAlignment(Pos.CENTER);
        super.setPrefSize(960, 650);
    }

    public void addScreen(String name, Node screen) {
        screens.put(name, screen);
//        images.put(name, pathToImage);
    }

    public  Node getScreen(String name) {
        return screens.get(name);
    }

    public boolean loadScreen(String name, String resource) {
        try {
            Parent loadScreen = FxmlUtils.fxmlLoader(resource);
            ControlledScreen screenController = FxmlUtils.getController();
            screenController.setScreenParent(this);
            addScreen(name, loadScreen);
            return true;

        } catch (Exception e) {
            DialogsUtils.errorDialog(e.getMessage());
            return false;
        }
    }

    public boolean setScreen(final String name) {
        if(screens.get(name) != null) {
            final DoubleProperty opacity = opacityProperty();

            if(!getChildren().isEmpty()) {
                Timeline fade = new Timeline(
                       new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(100), (ActionEvent actionEvent) -> {

                            getChildren().remove(0);
                            getChildren().add(0, screens.get(name));

                            Timeline fadein = new Timeline(
                                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                    new KeyFrame(new Duration(100), new KeyValue(opacity, 1.0))

                                );
                                fadein.play();

                        }, new KeyValue(opacity, 0.0)));
                 fade.play();
            } else {
                setOpacity(0.0);
                getChildren().add(screens.get(name));
                Timeline fadein = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(500), new KeyValue(opacity, 1.0))
                );
                fadein.play();
            } return true;
        } else {
            DialogsUtils.errorDialog("No screen loaded!");
            return false;
        }
    }

    public boolean unloadScreen(String name) {
        if(screens.remove(name) == null) {
            DialogsUtils.errorDialog("Trying to remove not existing screen");
            return false;
        } else {
            return true;
        }
    }
}
