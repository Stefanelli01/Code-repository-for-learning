package pessoaspacote;

public class Main {

    public static void main(String[] args) {

        int n1 = 5;

        Pessoa pessoa1 = new Pessoa();
        pessoa1.nome = "Luiz";
        pessoa1.peso = 70;

        Comida comida1 = new Comida();
        comida1.peso = 60;

        pessoa1.comer(comida1);

        System.out.println(pessoa1.peso);
    }
}
