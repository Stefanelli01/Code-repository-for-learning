package pessoaspacote;

public class Pessoa {

    String nome;
    int peso;

    void comer(Comida comida) {
        this.peso += comida.peso;
    }

}
