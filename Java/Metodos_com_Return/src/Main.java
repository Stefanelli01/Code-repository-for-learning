public class Main {

    static void main(String[] args) {
        //método void
        funcao1(10, 5);

        //método com return
        System.out.println(dizerOla("Luiz"));

    }

    //método void
    static void funcao1(int a, int b) {
        System.out.println(a + b);
    }

    //método com return
    static String dizerOla(String nome) {
        return "olá " + nome + "!";
    }
}
