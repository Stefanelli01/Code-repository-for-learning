package pacote1;

public class Teste2 {

    static void main(String[] args) {

        Carro carro1 = new Carro();
        carro1.cor = "verde";

        Carro carro2 = new Carro();
        carro2.cor = "amarelo";

        System.out.println(Carro.definicao);
        System.out.println(carro1.cor);
        System.out.println(carro2.cor);

    }
}
