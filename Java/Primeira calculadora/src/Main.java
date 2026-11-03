import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Funcoes calc = new Funcoes();

        System.out.println("== Calculadora em Java ==");
        System.out.println("\nMenu de Operações\n");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");

        System.out.print("\nEscolha uma opção: ");
        int escolha = scanner.nextInt();

        if (escolha >= 1 && escolha <= 4) {
            System.out.print("\nDigite o primeiro valor: ");
            double primeiroValor = scanner.nextDouble();

            System.out.print("Digite o segundo valor: ");
            double segundoValor = scanner.nextDouble();

            System.out.print("\nResultado: ");

            switch (escolha) {
                case 1:
                    System.out.println(calc.soma((int) primeiroValor, (int) segundoValor));
                    break;
                case 2:
                    System.out.println(calc.subtracao((int) primeiroValor, (int) segundoValor));
                    break;
                case 3:
                    System.out.println(calc.multiplicacao(primeiroValor, segundoValor));
                    break;
                case 4:
                    System.out.println(calc.divisao(primeiroValor, segundoValor));
                    break;
            }
        } else {
            System.out.println("\nEntrada inválida.");
        }

        scanner.close();
    }
}