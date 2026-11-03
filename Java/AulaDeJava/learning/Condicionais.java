public class Condicionais {

    static void main() {

        double salario = 1500.50;
        double valorsaque = 500.50;

        if (salario >= valorsaque) {

            System.out.println("Saque autorizado! Novo saldo: " + (salario - valorsaque));

        } else {

            System.out.println("Saldo insuficiente!");
        }
    }
}
