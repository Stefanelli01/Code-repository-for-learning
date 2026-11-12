package pacote1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:/Users/luizs/Documents/Code/Learning-projects/Java/Lendo_arquivo/src/pacote1/Arquivo.txt");

        Scanner scan = new Scanner(file);

        while(scan.hasNextLine()) {

            System.out.println(scan.nextLine());

        }
    }
}
