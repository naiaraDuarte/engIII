package br.com.fatecmc.geacad.model.dao;

import br.com.fatecmc.geacad.model.domain.*;
import br.com.fatecmc.geacad.util.ConnectionConstructor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisciplinaDAO implements IDAO {
    private Connection conn;

    @Override
    public int salvar(EntidadeDominio entidade) {
        int id = 0;
        try {
            this.conn = ConnectionConstructor.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "INSERT INTO disciplina(nome, carga_horaria) VALUES(?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Disciplina){
            try {
                conn.setAutoCommit(false);
                
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, ((Disciplina) entidade).getNome());
                stmt.setInt(2, ((Disciplina) entidade).getCarga_horaria());
               
                stmt.executeUpdate();
                
                ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next()) id = rs.getInt(1);
                
                conn.commit();	
            } catch (SQLException ex) {
                System.out.println("Não foi possível salvar os dados no banco de dados.\nErro: " + ex.getMessage());
            } finally {
                ConnectionConstructor.closeConnection(conn, stmt);
            }
        }
        return id;
    }

    @Override
    public boolean alterar(EntidadeDominio entidade) {
        try {
            this.conn = ConnectionConstructor.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "UPDATE disciplina SET nome=?, carga_horaria=? WHERE id_disciplina=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Disciplina){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Disciplina) entidade).getNome());
                stmt.setInt(2, ((Disciplina) entidade).getCarga_horaria());
                stmt.setInt(9, entidade.getId());

                if(stmt.executeUpdate() == 1) return true;
            } catch (SQLException ex) {
                System.out.println("Não foi possível alterar os dados no banco de dados.\nErro: " + ex.getMessage());
            } finally {
                ConnectionConstructor.closeConnection(conn, stmt);
            }
        }
        return false;
    }

    @Override
    public boolean excluir(int id) {
        try {
            this.conn = ConnectionConstructor.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "DELETE FROM disciplina WHERE id_disciplina=?";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            if(stmt.executeUpdate() == 1) return true;
        } catch (SQLException ex) {
            System.out.println("Não foi possível excluir os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionConstructor.closeConnection(conn, stmt);
        }
        return false;
    }
    
    @Override
    public List consultar() {
        try {
            this.conn = ConnectionConstructor.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * FROM disciplina";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Disciplina> disciplinas = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Disciplina disciplina = new Disciplina();
                
                disciplina.setId(rs.getInt("id_disciplina"));
                disciplina.setNome(rs.getString("nome"));
                disciplina.setCarga_horaria(rs.getInt("carga_horaria"));
                        
                disciplinas.add(disciplina);
            }
                
            return disciplinas;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionConstructor.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List consultarId(int id) {
        try {
            this.conn = ConnectionConstructor.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * FROM disciplinas WHERE id_disciplina=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Disciplina> disciplinas = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Disciplina disciplina = new Disciplina();
                
                disciplina.setId(rs.getInt("id_disciplina"));
                disciplina.setNome(rs.getString("nome"));
                disciplina.setCarga_horaria(rs.getInt("carga_horaria"));                
                disciplinas.add(disciplina);
            }
                
            return disciplinas;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionConstructor.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
}
