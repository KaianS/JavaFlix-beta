package javaflix.controle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javaflix.modelo.Titulo;
import javaflix.visao.StartJavaFlix;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;

public class controllerMenuScreen implements Initializable {

    ArrayList<Titulo> titulosFav = new ArrayList<>();
    @FXML
    private ImageView menuBackground;

    @FXML
    private ListView<Titulo> listViewTitulos;

    @FXML
    private Button buttomFavsSpecific;

    @FXML
    private Button buttomInicioSpecific;

    @FXML
    private TextField searchBar;

    @FXML
    private Button searchButton;

    @FXML
    void clickButtomFavsSpecific(ActionEvent event) {
        for (int i=0; i < titulosFav.size(); i++){
         System.out.println("Filme"+i);
         System.out.println(titulosFav.get(i).getNome());   
        }
        StartJavaFlix.changeScene("favs", null, titulosFav);
        titulosFav.clear();
    }

    @FXML
    void clickButtomInicioSpecific(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StartJavaFlix.addOnChangeScreenListener(new StartJavaFlix.onChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Titulo userData, ArrayList<Titulo> B) {
                if (newScreen.equals("menu")){
                    titulosFav.clear();
                    if(B != null){
                        titulosFav.addAll(B);
                    }
                }
            }
        });
        carregarObListTitulo(1);
        
    }


    public void carregarObListTitulo(int verify) { // Carregamento das Imagens/Lista de Filmes

        if (verify == 1) {
            InicializarFilmes();
        }

        listViewTitulos.setCellFactory(new Callback<ListView<Titulo>, ListCell<Titulo>>() { // Carregamento da ListView

            @Override
            public ListCell<Titulo> call(ListView<Titulo> param) {
                ListCell<Titulo> celula = new ListCell() {

                    @Override
                    protected void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        Titulo titulo = ((Titulo) item);

                        if (titulo != null) {
                            setText(titulo.getNome());
                            setGraphic(new ImageView(titulo.getImagem()));
                            setTooltip(new Tooltip(titulo.getNome()));

                        }

                    }
                };
                return celula;
            }

        });
    }

    
    public ArrayList<Titulo> listarFilmes() { // Auxiliar Para Pesquisar Filmes
        ArrayList<Titulo> titulos = null;
        try {
            titulos = new ArrayList<Titulo>();
            FileInputStream Titulo = new FileInputStream("movie.ser");
            ObjectInputStream lerObj;
            
            while (Titulo.available() > 0) {
                lerObj = new ObjectInputStream(Titulo);
                Titulo d = (Titulo) lerObj.readObject();
                titulos.add(d);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return titulos;
    }
    
    public void InicializarFilmes() { // Utilizado para Inicializar Filmes na Primeira Chamada
        try {
            FileInputStream Titulo = new FileInputStream("movie.ser");
            ObjectInputStream lerObj;
            
            while (Titulo.available() > 0) {
                lerObj = new ObjectInputStream(Titulo);
                Titulo d = (Titulo) lerObj.readObject();
                listViewTitulos.getItems().add(d);
            }
        } 
        
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    Titulo clickListViewTitulos() { // Mudan??a Tela Espec??fica
        Titulo titulo = listViewTitulos.getSelectionModel().getSelectedItem();
        StartJavaFlix.changeScene("specific", titulo, null);
        return titulo;
    }
    
    @FXML
    void search(ActionEvent event) throws IOException { // Fun????o Para Busca de Filmes
        listViewTitulos.getItems().clear();
        ArrayList<Titulo> titulos = listarFilmes();
        ArrayList<Titulo> titulosPesquisa = new ArrayList<>();
        
        for (int i = 0; i < titulos.size(); i++) {
            if (titulos.get(i).getNome().toLowerCase().contains(searchBar.getText().toLowerCase())) {
                titulosPesquisa.add(titulos.get(i));
            }
        }

        if (titulosPesquisa.isEmpty()){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../visao/noMovieFXML.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("../visao/Assets/icon.png")));
        }

        listViewTitulos.getItems().addAll(titulosPesquisa);

        carregarObListTitulo(0);
    }
    
    // public void cadastrarFilme(Titulo titulo){
    
    // try {
    // FileOutputStream fileStream = new FileOutputStream("movie.ser", true);
    // ObjectOutputStream os = new ObjectOutputStream(fileStream);
    // os.writeObject(titulo);
    // os.close();
    // }
    
    // catch(IOException e) {
    // System.out.println(e.getMessage());
    // }
    // catch(SecurityException e) {
    // System.out.println(e.getMessage());
    // }
    // catch(NullPointerException e) {
    // System.out.println(e.getMessage());
    // }
    // }
}
