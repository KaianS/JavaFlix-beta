package example.modelo;

import javafx.scene.image.ImageView;

public class Serie extends Titulo{
    private int numeroDeEps;
    private int numeroDeTemporadas;

    public Serie(String nome, String nota,String tipo,String lancamento, String sinopse, int numeroDeEps, int numeroDeTemporadas, String imagem){
        super(nome, nota,tipo,lancamento,sinopse, imagem);
        this.numeroDeEps = numeroDeEps;
        this.numeroDeTemporadas = numeroDeTemporadas;
    }

    public int getNumeroDeEps(){
        return numeroDeEps;
    }

    public int getNumeroDeTemporadas(){
        return numeroDeTemporadas;
    }


    public String imprimir(){

        return "Nome: " + super.getNome() + "/ Codigo: " + super.getCodigo() + 
        "/ Nota: " + super.getNota() + "/ Lancamento: " + super.getLancamento() +
        "/ Tipo do Título: " + super.getTipo() + "\nSinopse: " + super.getSinopse()+
        "Numeros de Temporadas/Episódios: " + this.numeroDeTemporadas + this.numeroDeEps;
    }
}
