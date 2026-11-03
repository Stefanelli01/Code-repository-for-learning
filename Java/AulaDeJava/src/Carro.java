public class Carro {

    String modelo;
    String cor;
    int ano;
    double velocidadeAtual;


    //Acelerar
    public void acelerar(double quantidade){
        velocidadeAtual += quantidade;
        System.out.println(modelo + " Acelerou, velocidade atual: " + velocidadeAtual + "km/h");
    }

    //Frear
    public void frear(double quantidade) {
        velocidadeAtual -= quantidade;
        if (velocidadeAtual < 0) velocidadeAtual = 0;
        System.out.println(modelo + " Freiou, Velocidade atual: " + velocidadeAtual + "km/h");
    }

    //Exibir info do carro
    public void exigirInfo() {
        System.out.println("Informações do Veículo");
        System.out.println("Modelo: " + modelo);
        System.out.println("Cor: " + cor);
        System.out.println("Ano: " + ano);
    }

}
