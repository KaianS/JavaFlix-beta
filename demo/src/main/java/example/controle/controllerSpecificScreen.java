package example.controle;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import example.visao.TesteTelas;

public class controllerSpecificScreen {

    @FXML
    private ImageView returnButton;

    @FXML
    void clickReturnButton(MouseEvent event) {
    TesteTelas.changeScene("menu");
    }

}
