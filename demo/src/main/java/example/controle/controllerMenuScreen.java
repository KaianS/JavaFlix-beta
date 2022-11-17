package example.controle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import example.modelo.Titulo;
import example.visao.StartJavaFlix;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

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
        StartJavaFlix.changeScene("specific");
    }

}
