package example.modelo;

public class Filme extends Titulo {
    private double duracaoEmSegs;

    public Filme(String nome, String nota,String tipo,String lancamento, String sinopse, double duracaoEmSegs,String imagem){
        super(nome,nota,tipo,lancamento,sinopse, imagem);
        this.duracaoEmSegs = duracaoEmSegs;
    }

    public double getDuracaoEmSegs(){
        return duracaoEmSegs;
    }

    public String converteSegsHora(double duracaoEmSegs){
        long horas; 
        long minutos;
        long segundos;

        horas = ((duracaoEmSegs/3600) >= 1 )? (long)(duracaoEmSegs/3600) : 0;
        duracaoEmSegs -= horas*3600;

        minutos = ((duracaoEmSegs/60) >= 1 )? (long)(duracaoEmSegs/60) : 0;
        duracaoEmSegs -= minutos*60;

        segundos = (long)duracaoEmSegs;

        return horas + "/" + minutos + "/" + segundos;  
    }

    public String imprimir(){
        return "Nome: " + super.getNome() + "/ Codigo: " + super.getCodigo() + 
        "/ Nota: " + super.getNota() + "/ Lancamento: " + super.getLancamento() +
        "/ Tipo do Título: " + super.getTipo() +"/ Duração do Filme: " + converteSegsHora(this.duracaoEmSegs) +
        "\nSinopse: " + super.getSinopse();
    }
}
