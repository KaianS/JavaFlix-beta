package example;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbMovies.MovieMethod;
import info.movito.themoviedbapi.model.Artwork;
import info.movito.themoviedbapi.model.ArtworkType;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.MovieImages;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {   
        /*TmdbMovies movies = new TmdbApi("79f8ad578459c24567ff304e079010d9").getMovies();
        for(int i = 1; i < 2; i++){
            MovieDb movie = movies.getMovie(102, null, MovieMethod.images);
            Artwork actual = movie.getImages(ArtworkType.POSTER).get(i);
            System.out.println(actual.getFilePath());
            
        }*/
        TmdbMovies movies = new TmdbApi("79f8ad578459c24567ff304e079010d9").getMovies();

        for(int i = 0; i < 20; i++){
            MovieResultsPage movie = movies.getPopularMovies("pt-br", 1);
            List<MovieDb> results = movie.getResults();
            MovieDb actualMovie = results.get(i);
            System.out.println(actualMovie.hashCode());
        }
        //launch(args);
    }

    /*@Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("applicationController.fxml"));
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();
        
    }
*/
    
    
}
