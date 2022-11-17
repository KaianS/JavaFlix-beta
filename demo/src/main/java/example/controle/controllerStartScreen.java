package example.controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import example.visao.TesteTelas;

public class controllerStartScreen {

    @FXML
    private ImageView javaflixBackground;

    @FXML
    private ImageView startButton;

    @FXML
    void clickButtonStart(ActionEvent event) {
        TesteTelas.changeScene("menu");
    }
}
