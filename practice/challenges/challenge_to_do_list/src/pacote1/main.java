package pacote1;

import java.util.Scanner;

public class main {

    static void main(String[] args) {

        boolean sistema = false;
        boolean welcome = false;

        while (!sistema) {

            while (!welcome) {
                System.out.println("\n== To do List ==");
                System.out.println("Qual o seu nome? ");

                try {
                    Scanner scan1 = new Scanner(System.in);
                    String nome_user = scan1.nextLine();
                    System.out.printf("\nSeja bem-vindo, %s", nome_user);
                } catch (Exception e) {
                    System.out.printf("Erro!, %s", e);
                } finally {
                    sistema = true;
                }
            }

            System.out.println("\nMenu de opções: ");
            System.out.println("\n");

        }
    }
}
