import java.util.Locale;

public class Main {

    static void main() {

        String nome = "Luiz";

        System.out.println(nome);
        System.out.println(nome.toUpperCase());
        System.out.println(nome.toLowerCase());
        System.out.println(nome + " Stefanelli");
        System.out.printf("Nome: %s", nome);


        String info = String.format("\nNome: %s", nome);
        System.out.println(info);

        System.out.println(info.contains("Luiz"));

        String frase = "Eu sou brasileiro";
        System.out.println(frase.concat("!!!"));

        frase = frase.toUpperCase().concat("!!");
        System.out.println(frase);

        frase = frase
                .toUpperCase()
                .concat("!!");

        System.out.println(frase);

    }
}
