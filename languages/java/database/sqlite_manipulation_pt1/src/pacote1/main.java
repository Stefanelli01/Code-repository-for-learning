import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:comercio.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            System.out.println("Conectado ao SQLite com sucesso!");

            // 1. Criar tabela
            String sqlTabela = """
                CREATE TABLE IF NOT EXISTS produtos (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL,
                    preco REAL
                );
                """;
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(sqlTabela);
            }

            Scanner scanner1 = new Scanner(System.in);

            System.out.println("Qual o nome do produto? ");
            String prod = scanner1.nextLine();

            System.out.println("Qual o valor do produto? ");
            double prec = scanner1.nextDouble();


            String sqlInsert = "INSERT INTO produtos (nome, preco) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {
                pstmt.setString(1, prod);
                pstmt.setDouble(2, prec);
                pstmt.executeUpdate();
                System.out.println("Produto inserido!");
            }

            // 3. Listar produtos
            String sqlSelect = "SELECT id, nome, preco FROM produtos";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sqlSelect)) {

                System.out.println("\n--- LISTA DE PRODUTOS ---");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    double preco = rs.getDouble("preco");

                    System.out.printf("ID: %d | %s | R$ %.2f%n", id, nome, preco);
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }
}