package pacote1;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    static void main(String[] args) throws IOException {

        String caminho = "C:/Users/luizs/Documents/Code/Learning-projects/Java/Escrevendo_em_arquivo/src/pacote1//arquivo.txt";

        String conteudo = "olá";

        FileWriter escritor = new FileWriter(caminho);
        escritor.write(conteudo);
        escritor.close();


    }
}
