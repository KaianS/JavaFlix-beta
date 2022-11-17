// package example.visao;

// import example.controle.ControleTitulosJavaflix;
// import example.modelo.*;
// import java.util.*;
// import java.io.*;
// import java.nio.charset.StandardCharsets;

// public class TesteCadastroArquivoTitulo {
//     public static String menu() {
//         return "------------\nDigite:\n" +
//                 "1) - Cadastrar titulo\n" +
//                 "2) - Listar títulos\n" +
//                 "3) - Apagar todo o arquivo\n" +
//                 "0) - Sair\n";
//     }

//     public static String menu2() {
//         return "------------\nDigite:\n" +
//                 "1) - Cadastrar Filme\n" +
//                 "2) - Cadastrar Serie\n" +
//                 "3) - Cadastrar Documentário\n" +
//                 "0) - Sair\n";
//     }

//     public static void main(String[] args) {
//         ControleTitulosJavaflix cT = new ControleTitulosJavaflix();
//         Scanner entrada = new Scanner(System.in);
//         ArrayList<Titulo> titulo = new ArrayList<>();

//         System.out.println(menu());
//         System.out.println("Insira a opção desejada: ");
//         String operador = entrada.nextLine();
//         byte[] bytes = operador.getBytes(StandardCharsets.US_ASCII);
//         int operadorAux = bytes[0];

//         while (operadorAux != 48) {
//             switch (operadorAux) {
//                 case 49: {
//                     System.out.println(menu2());
//                     System.out.println("Insira a opção desejada: ");
//                     int operador2 = Integer.parseInt(entrada.nextLine());
//                     if (operador2 == 1) {
//                         String film = "filme";
//                         System.out.println("Digite o nome do filme");
//                         String nome = entrada.nextLine();
//                         System.out.println("Digite a nota do filme");
//                         String nota = entrada.nextLine();
//                         System.out.println("Digite o ano de lancamento do filme");
//                         String lancamento = entrada.nextLine();
//                         System.out.println("Qual a duração do filme em segundos? ");
//                         long  duracao = Long.parseLong(entrada.nextLine());
//                         System.out.println("Insira a sinopse");
//                         String sinopse = entrada.nextLine();

//                         Filme f = new Filme(nome, nota, film, lancamento, sinopse, duracao, null);
//                         Titulo tF = new Titulo(nome, nota, film, lancamento, sinopse, null);
//                         titulo.add(tF);

//                         if (cT.cadastrarFilme(f)) {
//                             System.out.println("Filme cadastrado com sucesso!");
//                             break;
//                         } else
//                             System.out.println("Erro ao cadastrar filme!");

//                         break;
//                     } else if (operador2 == 2) {
//                         String se = "serie";
//                         System.out.println("Digite o nome da Série");
//                         String nome = entrada.nextLine();
//                         System.out.println("Digite a nota da Série");
//                         String nota = entrada.nextLine();
//                         System.out.println("Digite o ano de lancamento da Série");
//                         int lancamento = Integer.parseInt(entrada.nextLine());
//                         System.out.println("Quantidade de episódios da série: ");
//                         int duracaoEps = Integer.parseInt(entrada.nextLine());
//                         System.out.println("Quantidade de temporadas da série: ");
//                         int duracaoTemps = Integer.parseInt(entrada.nextLine());
//                         System.out.println("Insira a sinopse");
//                         String sinopse = entrada.nextLine();

//                         //Serie s = new Serie(nome, nota, se, lancamento, sinopse, duracaoEps, duracaoTemps, null);
//                         //Titulo tS = new Titulo(nome, nota, se, lancamento, sinopse, null);
//                         titulo.add(tS);

//                         if (cT.cadastrarSerie(s)) {
//                             System.out.println("Série cadastrada com sucesso!");
//                             break;
//                         } else
//                             System.out.println("Erro ao cadastrar a série!");

//                         break;
//                     } else if (operador2 == 3) {
//                         String doct = "documentario";
//                         System.out.println("Digite o nome do Documentário");
//                         String nome = entrada.nextLine();
//                         System.out.println("Digite a nota do Documentário");
//                         String nota = entrada.nextLine();
//                         System.out.println("Digite o ano de lancamento do documentário");
//                         int lancamento = Integer.parseInt(entrada.nextLine());
//                         System.out.println("Qual o foco do documentário? ");
//                         String tipoDoc = entrada.nextLine();
//                         System.out.println("Insira a sinopse");
//                         String sinopse = entrada.nextLine();

//                         //Documentario doc = new Documentario(nome, nota, doct, lancamento, sinopse, tipoDoc, null);
//                         //Titulo tD = new Titulo(nome, nota, doct, lancamento, sinopse, null);
//                         titulo.add(tD);

//                         if (cT.cadastrarDocumentario(doc)) {
//                             System.out.println("Documentário cadastrado com sucesso!");
//                             break;
//                         } else
//                             System.out.println("Erro ao cadastrar documentário!");
//                         break;
//                     }
//                     else if (operador2 == 0) {
//                         System.out.println("SAINDO...");
//                         break;
//                     }
//                     break;
//                 }
//                 case 50: {

//                     System.out.println(cT.imprimir());

//                     break;
//                 }
//                 case 51: {
//                     File arquivo = new File("titulosDB.ser");
//                     arquivo.delete();
//                     System.out.println("Arquivos de dados deletado!");
//                     break;
//                 }
//                 default: {
//                     System.out.println("Entrada Inválida!");
//                 }

//             }
//             System.out.println(menu());
//             System.out.println("Insira a opção desejada: ");
//              operador = entrada.nextLine();
//             bytes = operador.getBytes(StandardCharsets.US_ASCII);
//             operadorAux = bytes[0];
//         }
//         entrada.close();

//     }

// }
