package example.controle;

import java.util.*;

import example.data.TituloDados;
import example.modelo.*;

public class ControleTitulosJavaflix {
    private TituloDados titulosJavaflix = new TituloDados();
    private ArrayList<Titulo> tituloControle = new ArrayList<>();
    private ArrayList<Titulo> aux = new ArrayList<>();

    public ArrayList<Titulo> getAux() {
        return aux;
    }

    public boolean cadastrarFilme(Filme f){
        boolean aux;
        if(titulosJavaflix.cadastrarFilme(f))
            aux = true;
        else
            aux = false;

        return aux;
    }
    public boolean cadastrarSerie(Serie s){
        boolean aux;
        if(titulosJavaflix.cadastrarSerie(s))
            aux = true;
        else
            aux = false;

        return aux;
    }
    public boolean cadastrarDocumentario(Documentario doc){
        boolean aux;
        if(titulosJavaflix.cadastrarDocumentario(doc))
            aux = true;
        else
            aux = false;

        return aux;
    }
    public ArrayList<Titulo> listarTitulo() {
        return titulosJavaflix.listarTitulo();
    }

    public String imprimir(){
        String resultado="";
        tituloControle = listarTitulo();
        for (int i = 0; i<tituloControle.size(); i++){
            resultado += tituloControle.get(i).imprimir() + "\n---------\n";
        }
        return resultado;
    }
public ArrayList<Titulo> getTituloControle() {
    return tituloControle;
}
}
