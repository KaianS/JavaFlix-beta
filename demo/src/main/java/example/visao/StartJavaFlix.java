package example.visao;

import java.io.IOException;
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

    public static void changeScene(String scr) {
        switch (scr) {
            case "start":
                stage.setScene(startScene);
                break;
            case "menu":
            stage.setScene(menuScene);
            break;
            case "specific":
            stage.setScene(specificScene);
            break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
