package br.com.fatecmc.sisescola.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionConstructor {
    
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/crudEngIII";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível acessar a classe de Conexão.\nErro: " + ex.getMessage());
            return null;
        } catch (SQLException ex) {
            System.out.println("Não foi possível acessar o banco de dados.\nErro: " + ex.getMessage());
            return null;
        }
    }
    
    public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Não foi possível fechar a conexão.\nErro: " + ex.getMessage());
            }
        }
    }
    
    public static void closeConnection(Connection conn, PreparedStatement stmt){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Não foi possível fechar a conexão.\nErro: " + ex.getMessage());
            }
        }
        closeConnection(conn);
    }
    
    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Não foi possível fechar a conexão.\nErro: " + ex.getMessage());
            }
        }
        closeConnection(conn, stmt);
    }
    
}
