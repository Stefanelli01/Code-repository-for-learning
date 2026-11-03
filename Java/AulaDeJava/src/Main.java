public class Main {

    public static void main() {

        // Criando o primeiro objeto carro
        Carro carro1 = new Carro();
        carro1.modelo = "Civic";
        carro1.cor = "Azul";
        carro1.ano = 2023;

        // Criadno o segundo objeto carro
        Carro carro2 = new Carro();
        carro2.modelo = "Civic";
        carro2.cor = "Preto";
        carro2.ano = 2021;

        // Usando métodos
        carro1.exigirInfo();
        carro2.acelerar(10);
        carro1.frear(15);
        carro1.exigirInfo();

        System.out.println("");

        carro2.exigirInfo();
        carro2.acelerar(10);
        carro2.frear(20);
        carro2.exigirInfo();

    }

}
