package example.modelo;
import java.io.*;

public class Titulo implements Serializable {
    private int codigo;
    private static int contador = 0;
    private String nome;
    private String nota;
    private String lancamento;
    private String sinopse;
    private String tipo;
    private String imagem;

    
    
    public Titulo(String nome, String nota,String tipo, String lancamento, String sinopse ,String imagem){
        this.codigo = ++contador;
        this.nome = nome;
        this.nota = nota;
        this.lancamento = lancamento;
        this.sinopse = sinopse;
        this.tipo = tipo;
        this.imagem = imagem;
    }
    
    
    //getters
    public String getImagem() {
        return imagem;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public String getNota() {
        return nota;
    }
    public String getTipo() {
        return tipo;
    }
    public String getLancamento() {
        return lancamento;
    }
    public String getSinopse() {
        return sinopse;
    }
    @Override
    public String toString() {
        return super.toString();
    }
    
    //setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNota(String nota) {
        this.nota = nota;
    }
    public void setTipo(String tipo) {
            this.tipo = tipo;
    }
    public void setLancamento(String lancamento) {
        this.lancamento = lancamento;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String imprimir(){
        return "Nome: " + this.getNome() + "/ Codigo: " + this.getCodigo() + 
        "/ Nota: " + this.getNota() + "/ Lancamento: " + this.getLancamento() +
        "/ Tipo do Título: " + this.getTipo() + "\nSinopse: " + this.getSinopse() + "\nSinopse: " + this.getImagem() ;
    }
    
}
    