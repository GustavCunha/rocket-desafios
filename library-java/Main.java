import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        // Adicionar autores
        Autor autor1 = new Autor(1, "Miguel de Cervantes", LocalDate.of(1547, 9, 29));
        Autor autor2 = new Autor(2, "J.R.R. Tolkien", LocalDate.of(1892, 1, 3));
        Autor autor3 = new Autor(3, "Jane Austen", LocalDate.of(1775, 12, 16));

        // Adicionar livros aos autores
        Livro livro1 = new Livro(1, "Dom Quixote", autor1);
        Livro livro2 = new Livro(2, "A Galeria de Retratos", autor1);
        Livro livro3 = new Livro(3, "O Senhor dos Anéis", autor2);
        Livro livro4 = new Livro(4, "O Hobbit", autor2);
        Livro livro5 = new Livro(5, "Orgulho e Preconceito", autor3);
        Livro livro6 = new Livro(6, "Razão e Sensibilidade", autor3);

        // Adicionar livros à biblioteca
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);
        biblioteca.adicionarLivro(livro4);
        biblioteca.adicionarLivro(livro5);
        biblioteca.adicionarLivro(livro6);

        // Menu interativo
        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Listar livros disponíveis");
            System.out.println("2. Realizar empréstimo");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            if (opcao == 1) {
                List<Livro> livrosDisponiveis = biblioteca.listarLivrosDisponiveis();
                if (livrosDisponiveis.isEmpty()) {
                    System.out.println("Não há livros disponíveis no momento.");
                } else {
                    System.out.println("\nLivros disponíveis:");
                    for (Livro livro : biblioteca.listarLivrosDisponiveis()) {
                        System.out.println(livro);
                    }
                }
            } else if (opcao == 2) {
                System.out.print("Digite o ID do livro para empréstimo: ");
                int idLivro = scanner.nextInt();
                scanner.nextLine(); // Consumir quebra de linha

                Livro livroSelecionado = biblioteca.buscarLivroPorId(idLivro);

                if (livroSelecionado != null) {
                    System.out.print("Digite seu nome: ");
                    String nomeUsuario = scanner.nextLine();
                    biblioteca.emprestarLivro(livroSelecionado, nomeUsuario);
                    System.out.println("O livro " + livroSelecionado.getTitulo() + " foi empresatado para " + nomeUsuario);
                } else {
                    System.out.println("Livro não encontrado");
                }

            } else if (opcao == 3) {
                System.out.println("Encerrando o programa. Até logo!");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
