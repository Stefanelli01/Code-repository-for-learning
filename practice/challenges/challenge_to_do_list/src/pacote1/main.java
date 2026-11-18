package pacote1;

import java.util.ArrayList;
import java.util.List;
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
            System.out.println("3 - Remover tarefa");
            System.out.println("4 - Sair");


            Scanner scan2 = new Scanner(System.in):
            int option = scan2.nextLine();

            try{

                if (option == 1){

                }



            } catch (

            )

        }
    }
}

public class tarefa {

    List<tarefa> tarefas = new ArrayList<>();

    public void adicionar(String descricao) {

        int proximoID = 1;
        tarefa nova = tarefa(proximoID, descricao, false);
        tarefas.add(nova);
        proximoID++;
        
    }
}
