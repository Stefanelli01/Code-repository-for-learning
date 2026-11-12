package pacote1;

import java.util.Scanner;

public class Main {

    static void main(String[] args) {

        User usuario = new User();
        boolean sistema = false;
        Scanner scanner = new Scanner(System.in);


        while (!sistema) {

            System.out.println("\n Menu de login");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Login");
            System.out.println("3- Sair");
            System.out.println("\nInsira uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                if (opcao == 1) {
                    System.out.println("Teste");
                } else if (opcao == 2) {
                    System.out.println("Teste");
                } else if (opcao == 3) {
                    sistema = true;
                } else {
                    System.out.println("Teste");
                }
            } catch (Exception e) {

            }

        }
    }
}
