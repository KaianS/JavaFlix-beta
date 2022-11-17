package example.controle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import example.modelo.Titulo;
import example.visao.TesteTelas;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbMovies.MovieMethod;
import info.movito.themoviedbapi.model.Artwork;
import info.movito.themoviedbapi.model.ArtworkType;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.MovieImages;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

public class controllerMenuScreen implements Initializable {

    @FXML
    private ImageView HouseButton;

    @FXML
    private ImageView favsButton;

    @FXML
    private ImageView menuBackground;

    @FXML
    private ListView<Titulo> listViewTitulos;

    @FXML
    void clickFavsButton(MouseEvent event) {

    }
    
    @FXML
    void clickHouseButton(MouseEvent event) {
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarObListTitulo();
        
    }
    
    public void carregarObListTitulo(){
        /*String titulo;
        String undefined;
        String tipo = "Filme";
        String ano;
        String descricao;
        String imagefullURL;
        TmdbMovies movies = new TmdbApi("79f8ad578459c24567ff304e079010d9").getMovies();
        //String teste = "https://image.tmdb.org/t/p/w200/oR4Hzc17SqjfPzKbR8Qcy5QxZJF.jpg";
        String baseURL = "https://image.tmdb.org/t/p/w200";
        for(int i = 0; i < 20; i++){
          
            MovieResultsPage movie = movies.getPopularMovies("pt-br", 2);
            List<MovieDb> results = movie.getResults();
            MovieDb actualMovie = results.get(i);
            titulo = actualMovie.getTitle(); //TITULO
            undefined = titulo; // nao sei
            ano = actualMovie.getReleaseDate(); // ano do filme
            descricao = actualMovie.getOverview(); // Descrição
            int movieID = results.get(i).getId();
            MovieDb getImage = movies.getMovie(movieID, null, MovieMethod.images);
            Artwork actual = getImage.getImages(ArtworkType.POSTER).get(0);
            imagefullURL = baseURL.concat(actual.getFilePath());
            Titulo fullMovie = new Titulo(titulo, undefined, tipo, ano, descricao, imagefullURL);
            //listViewTitulos.getItems().add(fullMovie);
            cadastrarFilme(fullMovie);
            //System.out.println(imprimir());
             
        }*/
        listarFilmes();

        listViewTitulos.setCellFactory(new Callback<ListView<Titulo>,ListCell<Titulo>>() {

            @Override
            public ListCell<Titulo> call(ListView<Titulo> param) {
                ListCell<Titulo> celula = new ListCell() {

                    @Override
                    protected void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        Titulo titulo = ((Titulo)item);

                        if(titulo != null){
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

    public void cadastrarFilme(Titulo titulo){

        try {
            FileOutputStream fileStream = new FileOutputStream("filmes.ser", true);
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(titulo);
            os.close();
        }

        catch(IOException e) {
            System.out.println(e.getMessage());
        }
        catch(SecurityException e) {
            System.out.println(e.getMessage());
        }
        catch(NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Titulo> listarFilmes() {
        ArrayList<Titulo> titulos = null;
        try {
            titulos = new ArrayList<Titulo>();
            FileInputStream Titulo = new FileInputStream("filmes.ser");
            ObjectInputStream lerObj;

            while(Titulo.available() > 0) {
                lerObj = new ObjectInputStream(Titulo);
                Titulo d = (Titulo)lerObj.readObject();
                listViewTitulos.getItems().add(d);
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return titulos;

    }
    public String imprimir() {
		String res = "";
		ArrayList<Titulo> disc = listarFilmes();
		for (int i = 0; i < disc.size(); i++) {
			res += disc.get(i).imprimir() + "\n---------\n";
		}
		return res;
	}

    @FXML
    void clickListViewTitulos(MouseEvent event) {
        Titulo titulo = listViewTitulos.getSelectionModel().getSelectedItem();
        System.out.println("Título Selecionado pelo mouse" + titulo);
        TesteTelas.changeScene("specific");
    }

}
