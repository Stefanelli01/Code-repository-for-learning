package main;

import java.sql.*;

public class database {
    private static final String URL = "jdbc:sqlite:calculadora_historico.db";

    public static void inicializarBanco() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver SQLite não encontrado no classpath.");
            return;
        }
        String sql = """
            
                CREATE TABLE IF NOT EXISTS historico (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                expressao TEXT NOT NULL,
                resultado REAL NOT NULL,
                data_hora DATETIME DEFAULT (datetime('now', 'localtime'))
            );
            """;

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao inicializar banco: " + e.getMessage());
        }
    }

    public static void salvarOperacao(String expressao, double resultado) {
        String sql = "INSERT INTO historico (expressao, resultado) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, expressao);
            pstmt.setDouble(2, resultado);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar no histórico: " + e.getMessage());
        }
    }

    public static void exibirHistorico(int limite) {
        String sql = "SELECT id, expressao, resultado, data_hora FROM historico ORDER BY id DESC LIMIT ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, limite);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n=== Últimas " + limite + " Operações ===");
            boolean vazio = true;
            while (rs.next()) {
                vazio = false;
                System.out.printf("[%s] %s = %s\n",
                        rs.getString("data_hora"),
                        rs.getString("expressao"),
                        rs.getDouble("resultado"));
            }
            if (vazio) {
                System.out.println("Nenhuma operação registrada ainda.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar histórico: " + e.getMessage());
        }
    }
    }