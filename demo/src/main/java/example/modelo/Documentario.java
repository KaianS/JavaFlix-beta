package example.modelo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.*;

public class Documentario extends Titulo {
    private String tipoDoc;

    public Documentario(String nome, String nota,String tipo,String lancamento, String sinopse, String tipoDoc, String imagem){
        super(nome, nota,tipo,lancamento,sinopse, imagem);
        this.tipoDoc = tipoDoc;
    }

    public String getTipoDoc(){
        return tipoDoc;
    }

    public String imprimir(){

        return "Nome: " + super.getNome() + "/ Codigo: " + super.getCodigo() + 
        "/ Nota: " + super.getNota() + "/ Lancamento: " + super.getLancamento() +
        "/ Tipo do Título: " + super.getTipo() + "/ Tipo do Documentário: " + this.tipoDoc 
        + "\nSinopse: " + super.getSinopse();
    }
}
