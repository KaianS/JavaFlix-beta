package javaflix.visao;

import java.io.IOException;
import java.util.ArrayList;

import javaflix.modelo.Titulo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartJavaFlix extends Application {
    private static Stage stage;
    private static Scene startScene;
    private static Scene menuScene;
    private static Scene specificScene;

    @Override
    public void start(Stage stagePrimary) throws IOException {
        stage = stagePrimary;
        stagePrimary.setTitle("JavaFlix - 2022");

        Parent fxmlStart = FXMLLoader.load(getClass().getResource("startScreenFXML.fxml"));
        startScene = new Scene(fxmlStart);

        Parent fxmlMenu = FXMLLoader.load(getClass().getResource("MenuScreenFXML.fxml"));
        menuScene = new Scene(fxmlMenu);
        menuScene.getStylesheets().add("style.css");

        Parent fxmlSpecific = FXMLLoader.load(getClass().getResource("specificScreenFXML.fxml"));
        specificScene = new Scene(fxmlSpecific);

        stagePrimary.setScene(startScene);
        stagePrimary.setResizable(false);
        stagePrimary.show();
    }

    public static void changeScene(String scr, Titulo userData) {
        switch (scr) {
            case "start":
                stage.setScene(startScene);
                notifyAllListeners("main", userData);
                break;
            case "menu":
                stage.setScene(menuScene);
                notifyAllListeners("menu", userData);
                break;
            case "specific":
                stage.setScene(specificScene);
                notifyAllListeners("specific", userData);
                break;
        }
    }

    public static void changeScene(String scr) {
        changeScene(scr, null);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static ArrayList<onChangeScreen> listeners = new ArrayList<>();

    public static interface onChangeScreen {
        void onScreenChanged(String newScreen, Titulo userData);
    }

    public static void addOnChangeScreenListener(onChangeScreen newListener) {
        listeners.add(newListener);
    }

    public static void notifyAllListeners(String newScreen, Titulo userData) {
        for (onChangeScreen l : listeners)
            l.onScreenChanged(newScreen, userData);
    }

}