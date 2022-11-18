package example.modelo;
public class SpecificTitle extends Titulo{

    public SpecificTitle(String nome, String nota,String tipo, String lancamento, String sinopse ,String imagem){
        super(nome,nota,tipo,lancamento,sinopse, imagem);
    }
    @Override
    public String getNome() {
        return super.getNome();
    }
    @Override
    public String getImagem() {
        return super.getImagem();
    }



}
