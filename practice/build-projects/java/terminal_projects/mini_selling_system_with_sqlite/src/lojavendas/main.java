package lojavendas;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();

        dao.criarTabela();

        boolean sistema = false;

        Scanner scanner = new Scanner(System.in);

        while (!sistema) {

            System.out.println("\n--- Sistema de vendas ---");
            System.out.println("Menu de opções: ");
            System.out.println("1 - Inserir novo produto");
            System.out.println("2 - Atualizar preço");
            System.out.println("3 - Verificar estoque atual");
            System.out.println("4 - Excluir produto");
            System.out.println("0 - Sair");

            try {
                System.out.println("\nDigite uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> {
                        System.out.println("Digite o nome do produto: ");
                        String nome_prod = scanner.nextLine();
                        System.out.println("Digite o valor do produto: ");
                        double preco_prod = scanner.nextDouble();
                        scanner.nextLine();

                        dao.inserir(new Produto(nome_prod, preco_prod));
                    }

                    case 2 -> {
                        System.out.println("Digite o id do produto: ");
                        int id_prod = scanner.nextInt();
                        System.out.println("Digite o novo valor do produto: ");
                        double nvpreco_prod = scanner.nextDouble();
                        scanner.nextLine();

                        dao.atualizarPreco(id_prod, nvpreco_prod);
                    }

                    case 3 -> {
                        List<Produto> lista = dao.listarTodos();
                        System.out.println("--- ESTOQUE ATUAL ---");
                        for (Produto p : lista) {
                            System.out.println(p);
                        }
                    }

                    case 4 -> {
                        System.out.println("Digite o id do produto a ser deletado: ");
                        int id_del = scanner.nextInt();
                        scanner.nextLine();

                        dao.deletar(id_del);
                        System.out.printf("\nProduto de ID %s deletado!", id_del);

                        System.out.println("--- ESTOQUE APÓS EXCLUSÃO ---");
                        for (Produto p : dao.listarTodos()) {
                            System.out.println(p);
                        }
                    }

                    case 0 -> {sistema = true;}
                    default -> System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: digite um número válido (use vírgula para decimais, ex: 10,50).");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.printf("Erro: %s%n", e.getMessage());
            }
        }
        scanner.close();
        System.out.println("\n--- Sistema encerrado. ---");
    }
}
