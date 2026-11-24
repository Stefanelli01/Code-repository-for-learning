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
                        System.out.println("\nDigite uma opção: ");
                        int opcao_op = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcao_op) {

                         case 1 -> {
                             System.out.println("\nDigite o primeiro valor: ");
                             double a = scanner.nextDouble();
                             System.out.println("Digite o segundo valor: ");
                             double b = scanner.nextDouble();

                             System.out.printf("\n%s + %s = %s", a, b, (a+b));
                         }
                         case 2 -> {
                             System.out.println("nDigite o primeiro valor: ");
                             double a = scanner.nextDouble();
                             System.out.println("Digite o segundo valor: ");
                             double b = scanner.nextDouble();

                             System.out.printf("\n%s - %s = %s", a, b, (a-b));
                         }
                         case 3 -> {
                             System.out.println("\nDigite o primeiro valor: ");
                             double a = scanner.nextDouble();
                             System.out.println("Digite o segundo valor: ");
                             double b = scanner.nextDouble();

                             System.out.printf("\n%s / %s = %s", a, b, (a/b));
                         }
                         case 4 -> {
                             System.out.println("\nDigite o primeiro valor: ");
                             double a = scanner.nextDouble();
                             System.out.println("Digite o segundo valor: ");
                             double b = scanner.nextDouble();

                             System.out.printf("\n%s * %s = %s", a, b, (a*b));
                         }
                         case 5 -> {

                             System.out.print("Digite a expressão completa (ex: 10 + 5 * 2): ");
                             String expressao = scanner.nextLine();
                             try {
                                 double resultado = avaliarExpressao(expressao);
                                 System.out.println("Resultado: " + resultado);
                             } catch (Exception e) {
                                 System.out.println("Expressão inválida! Use apenas números e +, -, *, /.");
                             }
                             break;
                         }
                         case 0 ->{
                             System.out.println("Voltando ao menu inicial");
                             sistema_op = true;
                         }
                         default -> {
                             System.out.println("Digite uma opção válida.");
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
public static double avaliarExpressao(String expr) {
    expr = expr.replaceAll("\\s+", "");
    java.util.List<Double> numeros = new java.util.ArrayList<>();
    java.util.List<Character> operadores = new java.util.ArrayList<>();

    StringBuilder numAtual = new StringBuilder();
    for (int i = 0; i < expr.length(); i++) {
        char c = expr.charAt(i);
        if (Character.isDigit(c) || c == '.') {
            numAtual.append(c);
        } else if (c == '+' || c == '-' || c == '*' || c == '/') {
            numeros.add(Double.parseDouble(numAtual.toString()));
            numAtual.setLength(0);
            operadores.add(c);
        } else {
            throw new IllegalArgumentException("Caractere inválido");
        }
    }
    numeros.add(Double.parseDouble(numAtual.toString()));

    for (int i = 0; i < operadores.size(); i++) {
        char op = operadores.get(i);
        if (op == '*' || op == '/') {
            double n1 = numeros.get(i);
            double n2 = numeros.get(i + 1);
            if (op == '/' && n2 == 0) throw new ArithmeticException("Divisão por zero");
            double res = (op == '*') ? (n1 * n2) : (n1 / n2);

            numeros.set(i, res);
            numeros.remove(i + 1);
            operadores.remove(i);
            i--;
        }
    }
    
    double resultadoFinal = numeros.get(0);
    for (int i = 0; i < operadores.size(); i++) {
        char op = operadores.get(i);
        double proximoNum = numeros.get(i + 1);
        if (op == '+') resultadoFinal += proximoNum;
        if (op == '-') resultadoFinal -= proximoNum;
    }

    return resultadoFinal;
}