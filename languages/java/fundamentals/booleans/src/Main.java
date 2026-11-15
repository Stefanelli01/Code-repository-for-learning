public class Main {

    static void main(String[] args) {

        boolean teste = 5 > 10;

        if (teste) {
            System.out.println("Verdade");
        } else {
            System.out.println("Falso");
        }

        int idade = 17;
        System.out.println(maiorDeIdade(idade));
    }

    static boolean maiorDeIdade(int idade) {
        return idade > 18;
    }

}
