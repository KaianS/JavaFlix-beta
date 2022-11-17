package example;

import java.net.URL;
import java.util.ResourceBundle;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbMovies.MovieMethod;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.ResponseStatus;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class Controller implements Initializable{
    @FXML
    private ListView<String> myListView;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

        ResponseStatus response = new ResponseStatus();

        TmdbMovies movies = new TmdbApi("79f8ad578459c24567ff304e079010d9").getMovies();
        for(int i = 119; i < 120; i++){
            if(movies.getMovie(i, "pt-br", MovieMethod.credits) != null){
                MovieDb movie = movies.getMovie(i, "pt-br", MovieMethod.credits);
                myListView.getItems().add(movie.getTitle());
            }
        }
    }
    
}
