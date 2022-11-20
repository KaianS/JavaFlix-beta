package javaflix.modelo;

import java.util.List;

public class SpecificTitle extends Titulo{

    public SpecificTitle(String nome, float nota, List genero, String lancamento, String sinopse,String imagem){
        super(nome,nota,genero,lancamento,sinopse,imagem);
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
