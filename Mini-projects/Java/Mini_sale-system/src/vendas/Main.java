package vendas;
import java.util.Scanner;

public class Main {

    static void main(String[] args) {

        while True {

            Scanner scanner = new Scanner(System.in);

            System.out.println("==Sistema de Vendas==");
            System.out.println("\n Menu de opções:");
            System.out.println("1 - Realizar venda");
            System.out.println("2 - Sair");
            System.out.println("\n - Digite a opção: ");

            int opcao = scanner.nextLine();

            if (opcao == 1) {

                System.out.println("\n Digite o nome do produto a ser vendido: ");
                String nome_produto = scanner.nextLine();

                System.out.println("\n Digite a quantidade que produtos: ");
                int quantidade = scanner.nextInt();

                System.out.println("\n Digte o valor do produto: ");
                int valor_produto = scanner.nextInt();

                System.out.println("Deseja informar o nome do cliente? (S / N");
                String escolha_nome = scanner.nextLine();

                if ( escolha_nome == "S" ) {
                    System.out.println("Digite o nome do cliente: ");
                    String cliente_nome = scanner.nextLine();
                }



            }


            scanner.close();

        }


    }

}
