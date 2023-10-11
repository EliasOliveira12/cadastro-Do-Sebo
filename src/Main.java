//import java.time.LocalDate;
//import java.time.Period;
//import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;


public class Main {
    public static void main(String[] args) {

        ArrayList<CadastroLivros> listaLivros = new ArrayList<>();
        CadastroLivros cadastroLivros = new CadastroLivros();
        System.out.println("Bem vindo ao sistema de cadastro de livros");

        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("Escolha uma opcao:1- CadastrarLivos/2-ListarLivros/VerificarTempo de Lancamento");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    CadastroLivros novolivro = new CadastroLivros();
                    Autor novoautor = new Autor();
                    System.out.println("Digite o titulo");
                    novolivro.titulo = scanner.nextLine();
                    System.out.println("Digite o preco");
                    novolivro.preco = Float.valueOf(scanner.nextLine());
                    System.out.println("Digite a data de publicacao do livro");
                    novolivro.dataLancamento = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Period idadelivro = Period.between(novolivro.dataLancamento, LocalDate.now());
                    if (idadelivro.getYears() >= 5) {
                        System.out.println("o livro possui a idade correta");
                    } else {
                        System.out.println("o livro nao pode ser cadastrado por causa de sua idade");
                    }

                    System.out.println("Digite o nome do autor");
                    novoautor.nome = scanner.nextLine();
                    System.out.println("Digite o local de nascimento do autor");
                    novoautor.LocalNasc = scanner.nextLine();
                    novolivro.autor = novoautor;
                    listaLivros.add(novolivro);
                    System.out.println("Cadastro realizado com sucesso");
                    break;

                case "2":
                    if (listaLivros.size() > 0) {
                        for (CadastroLivros cadalivro : listaLivros) {
                            System.out.println("Titulo: " + cadalivro.titulo);
                            System.out.println("Preco: " + cadalivro.preco);
                            System.out.println("Data de lancamento: " + cadalivro.dataLancamento);
                            System.out.println("Autor: " + cadalivro.autor.nome);
                            System.out.println("Local de nascimento: " + cadalivro.autor.LocalNasc);
                            System.out.println();
                            System.out.println("Aperte 0 para continuar");
                            scanner.nextLine();
                        }
                    } else {
                        System.out.println("Esta lista nao possui nenhum livro");
                    }
                    break;

                case "0":
                    System.out.println("Obrigado por usar o nosso sistema");
                    break;
                default:
                    System.out.println("Digite uma operacao valida");
                    break;
            }

        } while (!opcao.equals("0"));
    }
}



