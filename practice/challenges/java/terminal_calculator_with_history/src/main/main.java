package main;

import java.util.Scanner;

public class main {

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean sistema = false;
        boolean sistema_op = false;

        while (!sistema) {

            System.out.println("\n=== Calculadora ===");
            System.out.println("1 - Menu de operações");
            System.out.println("2 - Visualizar histórico");
            System.out.println("0 - Sair");
            System.out.println("\nDigite uma opção: ");
            int opcao_principal = scanner.nextInt();
            scanner.nextLine();

            switch (opcao_principal) {

                case 1 -> {
                    while (!sistema_op) {

                        System.out.println("\n=== Menu de Operações ===");
                        System.out.println("1 - Soma");
                        System.out.println("2 - Subtração");
                        System.out.println("3 - Divisão");
                        System.out.println("4 - Multiplicação");
                        System.out.println("5 - Operação Aberta");
                        System.out.println("0 - Voltar ao menu principal");
                        int opcao_op = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao_op) {

                         case 1 -> {
                             System.out.println("Digite o primeiro valor: ");
                             double a = scanner.nextDouble();
                             System.out.println("Digite o segundo valor: ");
                             double b = scanner.nextDouble();

                             System.out.printf("%s + %s = %s", a, b, (a+b));
                         }
                         case 2 -> {

                         }
                         case 3 -> {

                         }
                         case 4 -> {

                         }
                         case 5 -> {

                         }
                         case 0 ->{
                             System.out.println("Voltando ao menu inicial");
                             sistema_op = true;
                         }
                         default -> {

                         }
                        }
                    }
                }

                case 2 -> {}

                case 0 -> {
                    System.out.println("Encerrando calculadora");
                    sistema = true;
                }

                default -> {
                    System.out.println("Digite uma opção existente. ");
                }
            }
        }
        scanner.close();
    }
}