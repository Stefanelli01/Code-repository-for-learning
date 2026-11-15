import java.util.ArrayList;

public class Main {

    static void main() {

    ArrayList<String> clientes = new ArrayList<String>();

    clientes.add("cliente1");
    clientes.add("cliente2");

    System.out.println(clientes.toString());

    clientes.remove(1);

    System.out.println(clientes.get(0));
    }
}
