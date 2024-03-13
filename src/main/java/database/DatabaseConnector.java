package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {

    private static final String url = "jdbc:postgresql://localhost:5432/";
    private static final String username = "postgres";
    private static final String password = "postgres";
    private static final String databaseName = "db_cadastro_pessoas";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = connectToDatabase(databaseName);
            System.out.println("Connected to the database: " + databaseName);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Disconnected from the database: " + databaseName);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static Connection connectToDatabase(String dbName) throws SQLException {
        // Criando a URL do DB
        String dbURL = url + dbName;

        // Tentativa de conexao ao DB
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Connected to existing database: " + dbName);
            return conn;
        } catch (SQLException e) {
            // "Se o DB nao existir, crie-o"
            if (e.getSQLState().equals("3D000")) {
                createDatabase(dbName);
                System.out.println("Created and connected to new database: " + dbName);
                return DriverManager.getConnection(dbURL, username, password);
            } else {
                throw e;
            }
        }
    }

    public static void createDatabase(String dbName) throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement statement = conn.createStatement()) {
            // Criando novo DB pelo SQL
            String sql = "CREATE DATABASE " + dbName;
            statement.executeUpdate(sql);
            System.out.println("Database created successfully: " + dbName);
        }
    }
}
