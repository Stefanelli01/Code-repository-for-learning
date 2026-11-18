package pacote1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    private static List<Tarefa> tarefas = new ArrayList<>();
    private static int proximoId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=-= MENU =-=");
            System.out.println("\n1 - Adicionar");
            System.out.println("2 - Listar");
            System.out.println("3 - Concluir");
            System.out.println("4 - Remover");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Descrição da tarefa: ");
                    String desc = scanner.nextLine();
                    adicionar(desc);
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    System.out.print("ID da tarefa para concluir: ");
                    int idConcluir = scanner.nextInt();
                    concluir(idConcluir);
                    break;
                case 4:
                    System.out.print("ID da tarefa para remover: ");
                    int idRemover = scanner.nextInt();
                    remover(idRemover);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    private static void adicionar(String descricao) {
        Tarefa nova = new Tarefa(proximoId, descricao, false);
        tarefas.add(nova);
        proximoId++;
        System.out.println("Tarefa adicionada!");
    }

    private static void listar() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        for (Tarefa t : tarefas) {
            String status = t.isConcluida() ? "[X]" : "[ ]";
            System.out.println("[" + t.getId() + "] " + status + " " + t.getDescricao());
        }
    }

    private static Tarefa buscarPorId(int id) {
        for (Tarefa t : tarefas) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    private static void concluir(int id) {
        Tarefa alvo = buscarPorId(id);
        if (alvo != null) {
            alvo.setConcluida(true);
            System.out.println("Tarefa marcada como concluída!");
        } else {
            System.out.println("ID não encontrado.");
        }
    }

    private static void remover(int id) {
        boolean removeu = tarefas.removeIf(t -> t.getId() == id);
        if (removeu) {
            System.out.println("Tarefa removida!");
        } else {
            System.out.println("ID não encontrado.");
        }
    }
}



class Tarefa {
    private int id;
    private String descricao;
    private boolean concluida;

    public Tarefa(int id, String descricao, boolean concluida) {
        this.id = id;
        this.descricao = descricao;
        this.concluida = concluida;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}