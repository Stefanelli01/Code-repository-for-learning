package construtores;

public class pessoa {

    String nome;
    int idade;
    int altura;
    String sobrenome;


    pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    pessoa(Int altura, String sobrenome) {
        this.altura = altura;
        this.sobrenome = sobrenome;
    }

    pessoa() {}

}
