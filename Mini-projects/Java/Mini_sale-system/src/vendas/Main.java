package vendas;
import java.util.Scanner;

public class Main {

    static void main(String[] args) {

        boolean sistema = false;

        while (!sistema) {

            Scanner scanner = new Scanner(System.in);
            boolean opcaoValida = false;
            String cliente_nome = "";

            System.out.println("==Sistema de Vendas==");
            System.out.println("\n Menu de opções:");
            System.out.println("1 - Realizar venda");
            System.out.println("2 - Sair");
            System.out.println("\n - Digite a opção: ");

            int opcao = scanner.nextInt();

            if (opcao == 1) {

                System.out.println("\n Digite o nome do produto a ser vendido: ");
                String nome_produto = scanner.nextLine();

                System.out.println("\n Digite a quantidade que produtos: ");
                double quantidade = scanner.nextDouble();

                System.out.println("\n Digte o valor do produto: ");
                double valor_produto = scanner.nextDouble();

                while (!opcaoValida) {

                    System.out.println("\n Deseja informar o nome do cliente? (S / N");
                    String escolha_nome = scanner.nextLine();

                    if (escolha_nome.equals("S")) {
                        System.out.println("\n Digite o nome do cliente: ");
                        cliente_nome = scanner.nextLine();
                        opcaoValida = true;
                    } else if (escolha_nome.equals("N")) {
                        opcaoValida = true;
                    } else {
                        System.out.println("\n Digite uma opção existente.");
                    }
                }

                double resultado = quantidade * valor_produto;

                System.out.printf("\n O cliente %s comprou %s %s, o valor final foi de: %s reais.", cliente_nome, quantidade, nome_produto, resultado);
            } else if (opcao == 2) {
                sistema = true;
            } else {
                System.out.println("\n Digite uma opção válida");
            }


            scanner.close();

        }


    }

}
