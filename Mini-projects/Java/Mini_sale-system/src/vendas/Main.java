package vendas;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean sistema = false;

        while (!sistema) {

            boolean opcaoValida = false;
            boolean quantidades = false;

            String cliente_nome = "Não informado";
            double quantidade = 0;

            System.out.println("\n==Sistema de Vendas==");
            System.out.println("\n Menu de opções:");
            System.out.println("1- Realizar venda");
            System.out.println("2- Sair");
            System.out.println("\nDigite a opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {

                System.out.println("\nDigite o nome do produto a ser vendido: ");
                String nome_produto = scanner.nextLine();

                while (!quantidades) {
                    System.out.println("\nDigite a quantidade que produtos: ");
                    quantidade = scanner.nextDouble();

                    if (quantidade <= 0) {
                        System.out.println("A quantidade não pode ser negativa");
                    } else {
                        quantidades = true;
                    }
                }

                System.out.println("\nDigte o valor unitário do produto: ");
                double valor_produto = scanner.nextDouble();
                scanner.nextLine();

                while (!opcaoValida) {

                    System.out.println("\nDeseja informar o nome do cliente? (S / N)");
                    String escolha_nome = scanner.nextLine();

                    if (escolha_nome.equals("S")) {
                        System.out.println("\nDigite o nome do cliente: ");
                        cliente_nome = scanner.nextLine();
                        opcaoValida = true;
                    } else if (escolha_nome.equals("N")) {
                        opcaoValida = true;
                    } else {
                        System.out.println("\nDigite uma opção existente.");
                    }
                }

                double resultado = quantidade * valor_produto;

                String nomeExibicao = (quantidade > 1) ? nome_produto + "s" : nome_produto;

                System.out.printf("\nO cliente *%s* comprou *%s %s*, o valor final foi de: *%s* reais.", cliente_nome, quantidade, nomeExibicao, resultado);
            } else if (opcao == 2) {
                sistema = true;
            } else {
                System.out.println("\nDigite uma opção válida");
            }

        }


        scanner.close();
    }

}
