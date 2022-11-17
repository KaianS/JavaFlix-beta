package example.controle;

import example.visao.StartJavaFlix;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class controllerSpecificScreen {

    @FXML
    private ImageView returnButton;

    @FXML
    void clickReturnButton(MouseEvent event) {
    StartJavaFlix.changeScene("menu");
    }

}
