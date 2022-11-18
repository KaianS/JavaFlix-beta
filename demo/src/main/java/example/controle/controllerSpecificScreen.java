package example.controle;

import java.net.URL;
import java.util.ResourceBundle;

import example.modelo.SpecificTitle;
import example.modelo.Titulo;
import example.visao.StartJavaFlix;
import javafx.collections.ListChangeListener.Change;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class controllerSpecificScreen implements Initializable{

    @FXML
    private ImageView returnButton;

    @FXML
    private ImageView imagemFilme;

    @FXML
    private Label labelTitle;

    @FXML
    private controllerMenuScreen controller;

    @FXML
    void clickReturnButton(MouseEvent event) {
    StartJavaFlix.changeScene("menu");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelTitle.setText("FOIUHSFUHSF");
    }


}
