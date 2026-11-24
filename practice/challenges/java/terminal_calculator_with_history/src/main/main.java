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
                        System.out.println("0 - Sair");


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