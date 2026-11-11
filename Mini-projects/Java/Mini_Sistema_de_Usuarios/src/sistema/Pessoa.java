package sistema;
import java.util.Scanner;

public class Pessoa {

    String nome;
    String sobrenome;
    int idade;
    double altura;
    String profissao;

    public void gerar_usuario() {

        Pessoa usuario = new Pessoa();

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nPor favor insira somente o primeiro nome do usuário: ");
        this.nome = scanner.nextLine();

        System.out.println("Por favor insira somente o sobrenome do usuário: ");
        this.sobrenome = scanner.nextLine();

        System.out.println("Por favor insira a idade do usuário: ");
        this.idade = scanner.nextInt();

        System.out.println("Por favor insira a altura do usuário: ");
        this.altura = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Por favor insira a profissão do usuário: ");
        this.profissao = scanner.nextLine();

        System.out.println("Usuário cadastrado com sucesso!");

    }
}
