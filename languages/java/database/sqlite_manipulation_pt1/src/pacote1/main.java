import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement; // Novo import necessário

public class main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:comercio.db";

        // Abre a conexão
        try (Connection conn = DriverManager.getConnection(url)) {
            System.out.println("Conectado ao SQLite com sucesso!");

            // Define o comando SQL
            String sql = """
                CREATE TABLE IF NOT EXISTS produtos (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT NOT NULL,
                    preco REAL
                );
                """;

            // Cria o Statement usando a conexão 'conn' e executa o SQL
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(sql);
                System.out.println("Tabela 'produtos' pronta!");
            }

        } catch (SQLException e) {
            System.out.println("Erro no banco: " + e.getMessage());
        }
    }
}