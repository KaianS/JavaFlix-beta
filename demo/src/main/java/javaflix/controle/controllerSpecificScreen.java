package javaflix.controle;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.Action;

import javaflix.modelo.Titulo;
import javaflix.visao.StartJavaFlix;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

public class controllerSpecificScreen implements Initializable{

    
    @FXML
    private Button buttomInicioSpecific;

    @FXML
    private ImageView imagemFilme;

    @FXML
    private Label labelGen;

    @FXML
    private Label labelLancamento;

    @FXML
    private Label labelNota;

    @FXML
    private Label labelSinopse;

    @FXML
    private Label labelTitle;
    
    @FXML
    private Button buttomFavsSpecific;

    @FXML
    private Button AddbuttonFavs;

    @FXML
    void clickButtomFavsSpecific(ActionEvent event) {
    }

    @FXML
    void buttonAddFavs(ActionEvent event) {
            AddbuttonFavs.setStyle("-fx-background-color: #0097cc");
    }

    @FXML
    void removeFav(ActionEvent event){
        AddbuttonFavs.setStyle("-fx-background-color: #191b1f");
    }

    @FXML
    void clickButtomInicioSpecific(ActionEvent event) {
        StartJavaFlix.changeScene("menu");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StartJavaFlix.addOnChangeScreenListener(new StartJavaFlix.onChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Titulo userData) {
                if (newScreen.equals("specific")){
                    labelTitle.setText(userData.getNome());
                    imagemFilme.setImage(new Image(userData.getImagem()));
                    if (userData.getSinopse().isEmpty()){
                        labelSinopse.setText("Não foi Possível Encontrar Sinopse para este filme");   
                    }
                    else{
                        labelSinopse.setText(userData.getSinopse());
                    }
                    String notaConvertida = String.format("%.1f", userData.getNota());
                    String genero = "";
                    for(int i = 0; i < userData.getGenero().size(); i++){
                        if(userData.getGenero().get(i) != null){
                            genero += userData.getGenero().get(i) + ", ";
                        }
                    }
                    labelNota.setText(notaConvertida);
                    labelGen.setText(genero);
                    labelLancamento.setText(userData.getLancamento());
                }
            }
        });

        
    }


}
