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
        usuario.nome = scanner.nextLine();

        System.out.println("Por favor insira somente o sobrenome do usuário: ");
        usuario.sobrenome = scanner.nextLine();

        System.out.println("Por favor insira a idade do usuário: ");
        usuario.idade = scanner.nextInt();

        System.out.println("Por favor insira a altura do usuário: ");
        usuario.altura = scanner.nextDouble();

        System.out.println("Por favor insira a profissão do usuário: ");
        usuario.profissao = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Usuário cadastrado com sucesso!");

        scanner.close();
    }
}
