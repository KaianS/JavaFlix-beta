package javaflix.controle;
import javaflix.modelo.*;
import javaflix.visao.StartJavaFlix;

import java.util.ArrayList;

import javaflix.data.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadastroController {

    @FXML
    private TextField userRegister;
    
    @FXML
    private Button voltar;

    @FXML
    private TextField passwordRegister;

    @FXML
    private Label registerMessageLabel;

    @FXML
    private Button cadastrar;

    @FXML
    void cadastrarBut(ActionEvent event) {
        ArrayList<User> userAAA = new ArrayList<>();
        String userR=userRegister.getText();
        String passwordR=passwordRegister.getText();

        User usuario = new User(userR, passwordR);
        UserData UD = new UserData();

        UD.insertUser(usuario);
        userAAA = UD.searchUser();
        boolean aux = false;
        for(int index=0;index<userAAA.size();index++){
            if(userR.equals(userAAA.get(index).getUsername())){
                if(passwordR.equals(userAAA.get(index).getSenha()))
                    aux = true;
            }
        }
        if(aux==false){
            System.out.println("Cadastro invalido");
        }else{
            StartJavaFlix.changeScene("login");
        }

    }
    @FXML
    void voltar(ActionEvent event) {
        StartJavaFlix.changeScene("login");
    }

}
