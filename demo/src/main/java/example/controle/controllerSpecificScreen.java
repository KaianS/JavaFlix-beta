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
    private Label labelSinopse;

    @FXML
    private Label labelAva;

    @FXML
    private Label labelLanc;

    @FXML
    private Label labelNsei;

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
                    if (userData.getSinopse().isEmpty()){
                        labelSinopse.setText("Não foi Possível Encontrar Sinopse para este filme");   
                    }
                    else{
                        labelSinopse.setText(userData.getSinopse());
                    }
                    labelAva.setText(userData.getNota());
                    labelLanc.setText(userData.getLancamento());
                    labelNsei.setText(userData.getTipo());

                }
            }
        });

        
    }

    public void changeScene(){

    }


}
