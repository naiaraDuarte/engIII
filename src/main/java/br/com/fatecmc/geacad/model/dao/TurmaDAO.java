package br.com.fatecmc.geacad.model.dao;

import br.com.fatecmc.geacad.model.domain.Disciplina;
import br.com.fatecmc.geacad.model.domain.Turma;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import br.com.fatecmc.geacad.util.ConnectionConstructor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TurmaDAO implements IDAO {
    private Connection conn;

    @Override
    public int salvar(EntidadeDominio entidade) {
        int id = 0;
        
        try {
            this.conn = ConnectionConstructor.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        //verificar esse fk_disciplina
        String sql = "INSERT INTO turma(nome, ano, periodo) VALUES(?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Turma){
            try {
                conn.setAutoCommit(false);
                
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, ((Turma) entidade).getNome());
                stmt.setString(2, ((Turma) entidade).getAno());                
                stmt.setString(3, ((Turma) entidade).getPeriodo());
                
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
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "UPDATE turma SET nome=?, ano=?, periodo=? WHERE id_turma=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Turma){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Turma) entidade).getNome());
                stmt.setString(2, ((Turma) entidade).getAno());                
                stmt.setString(3, ((Turma) entidade).getPeriodo());
                stmt.setInt(4, ((Turma) entidade).getId());

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
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "DELETE FROM turma WHERE id_turma=?";

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
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * FROM turma";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Turma> turmas = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Turma turma = new Turma();
                
                
                turma.setId(rs.getInt("id_turma"));
                turma.setNome(rs.getString("nome"));
                turma.setAno(rs.getString("ano"));
                turma.setPeriodo(rs.getString("periodo"));
                turmas.add(turma);
            }
                
            return turmas;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionConstructor.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
    @Override
    public List consultarId(int id) {
        try {
            this.conn = ConnectionConstructor.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * FROM turma WHERE id_turma=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Turma> turmas = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Turma turma = new Turma();
                //se tiver disciplina incluir aqui
                turma.setId(rs.getInt("id_turma"));
                turma.setNome(rs.getString("nome"));
                turma.setPeriodo(rs.getString("periodo"));
                turmas.add(turma);
            }
                
            return turmas;
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
    
}
