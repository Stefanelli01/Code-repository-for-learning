package pacote1;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        File pasta = new File("data");
        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        File file_senha = new File(pasta,"senha.txt");
        File file_username = new File(pasta,"username.txt");

        boolean sistema = false;
        boolean cadastro = false;
        boolean login_username = false;
        boolean login_senha = false;
        int tentativas = 0;
        int resto = 3;
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
                    cadastro = false;
                    login_username = false;
                    tentativas = 0;

                    FileWriter file_wsenha = new FileWriter(file_senha);
                    FileWriter file_wusername = new FileWriter(file_username);

                    try {

                        System.out.println("\nDigite o nome de usuário a ser cadastrado: ");
                        String username_cad = scanner.nextLine();
                        file_wusername.write(username_cad);
                        file_wusername.close();

                    } catch (Exception e) {
                        System.out.printf("Erro! %s", e);
                    }

                    while (!cadastro) {
                        System.out.println("\nDigite a senha a ser cadastrada: ");
                        String senha_cad = scanner.nextLine();
                        System.out.println("\nConfirme a senha: ");
                        String senha_cad_conf = scanner.nextLine();

                        if (senha_cad.equals(senha_cad_conf)) {
                            System.out.println("\nCadastro realizado com sucesso!");
                            file_wsenha.write(senha_cad);
                            file_wsenha.close();
                            cadastro = true;
                        } else {
                            System.out.println("\nSenhas difrentes! ");
                        }
                    }

                } else if (opcao == 2) {

                    cadastro = false;
                    login_username = false;
                    tentativas = 0;
                    login_senha = false;

                    Scanner scanner_file_u = new Scanner(file_username);
                    Scanner scanner_file_s = new Scanner(file_senha);

                    String username_salvo = scanner_file_u.nextLine();
                    String senha_salva = scanner_file_s.nextLine();

                    scanner_file_u.close();
                    scanner_file_s.close();

                    while (!login_username) {
                        System.out.println("\nDigite o username: ");
                        String login_user = scanner.nextLine();

                        if (login_user.equals(username_salvo)) {
                            login_username = true;
                        } else {
                            System.out.println("\nUsername não encontrado.");
                        }
                    }

                    while (!login_senha) {
                        System.out.println("\nDigite a senha: ");
                        String login_sen = scanner.nextLine();

                        if (login_sen.equals(senha_salva)) {
                            System.out.println("\nLogin realizado com sucesso!");
                            login_senha = true;
                            sistema = true;
                        } else {
                            tentativas ++;
                            resto = resto - tentativas;
                            System.out.println("\nSenha incorreta, tente novamente.");
                            System.out.printf("Restam %s tentativas", resto);
                            resto = 3;

                            if (tentativas == 3) {
                                System.out.println("\nSenha incorreta, Sistema bloqueado.");
                                login_senha = true;
                                sistema = true;
                            }
                        }
                    }
                    scanner_file_u.close();
                    scanner_file_s.close();

                } else if (opcao == 3) {
                    sistema = true;
                } else {
                    System.out.println("Teste");
                }
            } catch (Exception e) {
            }
        }
        scanner.close();
    }
}
