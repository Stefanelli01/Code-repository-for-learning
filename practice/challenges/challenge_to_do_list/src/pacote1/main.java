package pacote1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    static void main(String[] args) {

        Scanner scanner = new Scanner();
        int opcao = -1;

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
                    scan1.close();
                } catch (Exception e) {
                    System.out.printf("Erro!, %s", e);
                } finally {
                    sistema = true;
                }
            }

            System.out.println("\nMenu de opções: ");
            System.out.println("\n1 - Criar tarefa");
            System.out.println("(2- Verificar tarefas");
            System.out.println("3 - Concluir tarefa");
            System.out.println("4 - Remover tarefa");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){

                case 1:
                    System.out.println("Descrição da tarefa: ");
                    String desc = scanner.nextLine();
                    adicionar(desc);
                    break;

                case 2:
                    listar();
                    break;

                case 3:
                    System.out.println("ID da tarefa a ser concluída: ");
                    int idConcluir = scanner.nextInt();
                    remover(idConcluir);
                    break;

                case 4:
                    System.out.println("ID da tarefa a ser removida: ");
                    int idRemover = scanner.nextInt();
                    remover(idRemover);
                    break;

                case 0:


            }
        }
    }
}

public class Tarefa {
    private int id;
    private String descricao;
    private boolean concluída;

    public Tarefa(int id, String descricao, boolean concluída) {
        this.id = id;
        this.descricao = descricao;
        this.concluída = concluída;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean is

    public boolean isConcluída() {
        return concluída;
    }

    public void setConcluída(boolean concluída) {
        this.concluída = concluída;
    }
}
