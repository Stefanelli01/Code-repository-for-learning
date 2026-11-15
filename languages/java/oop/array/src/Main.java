public class Main {


    static void main() {

        int n1;
        n1 = 5;

        int tamanhoArray = 10;

        int[] numeros;
        numeros = new int[tamanhoArray];

        numeros[0] = 1;
        numeros[1] = 2;
        numeros[2] = 3;

        System.out.println(numeros[1]);

        for (int n: numeros) {
            System.out.println(n);
        }


        String[] nomes = {"João", "Maria", "Carlos"};

        nomes[0] = "Joaquina";

        for (String nome: nomes) {
            System.out.println(nome);
        }



    }
}
