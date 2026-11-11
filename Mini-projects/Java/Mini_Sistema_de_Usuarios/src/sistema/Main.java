package sistema;
import java.util.Scanner;

public class Main {

    static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        boolean sistema = false;
        Pessoa usuario = new Pessoa();


        while (!sistema) {
            System.out.println("\n== Sistema de Usuários ==");
            System.out.println("\n Menu de opções: ");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Visualizar usuário");
            System.out.println("3 - Sair");
            System.out.println("\n Por favor insira uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {

            usuario.gerar_usuario();

            } else if (opcao == 2) {

                System.out.println("\n== Visualização de Usuário ==");
                System.out.printf("\nNome do usuário: %s", usuario.nome);
                System.out.printf("sobrenome do usuário: %s", usuario.sobrenome);
                System.out.printf("idade do usuário: %s", usuario.idade);
                System.out.printf("Altura do usuário: %s", usuario.altura);
                System.out.printf("Profissão do usuário: %s", usuario.profissao);
            }


        }

        scanner.close();

    }
}
