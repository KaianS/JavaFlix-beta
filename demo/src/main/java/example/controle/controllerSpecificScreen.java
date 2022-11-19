package example.controle;

import java.net.URL;
import java.util.ResourceBundle;

import example.modelo.Titulo;
import example.visao.StartJavaFlix;
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
        StartJavaFlix.addOnChangeScreenListener(new StartJavaFlix.onChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Titulo userData) {
                if (newScreen.equals("specific")){
                    System.out.println("Nova tela " + newScreen + " Dados " + userData);
                    labelTitle.setText(userData.getNome());
                    imagemFilme.setImage(new Image(userData.getImagem()));
                }
            }
        });

        
    }

    public void changeScene(){

    }


}
