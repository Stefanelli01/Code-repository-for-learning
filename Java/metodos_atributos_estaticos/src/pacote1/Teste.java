package pacote1;

public class Teste {

    static String nome = "Bruce";

    public static void main(String[] args) {

        Teste teste = new Teste();

        System.out.println(nome);
        teste.ola();
        System.out.println(nome); // estático, não printa a variável da instância
    }

    void ola(){
        System.out.println(nome); // não estático, printa variável da instância
    }

}
