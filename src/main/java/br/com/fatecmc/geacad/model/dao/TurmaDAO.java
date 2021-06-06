package br.com.fatecmc.geacad.model.dao;

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
        String sql = "INSERT INTO turmas(nome, ano, periodo, fk_disciplina) VALUES(?, ?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Turma){
            try {
                conn.setAutoCommit(false);
                
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, ((Turma) entidade).getNome());
                stmt.setString(2, ((Turma) entidade).getAno());                
                stmt.setString(3, ((Turma) entidade).getPeriodo());
                //stmt.set(4, ((Turma) entidade).getDisciplinas().get(1));

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
        String sql = "UPDATE turmas SET nome=?, ano=?, periodo=? WHERE id_turma=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Turma){
            try {
                stmt = conn.prepareStatement(sql);
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, ((Turma) entidade).getNome());
                stmt.setString(2, ((Turma) entidade).getAno());                
                stmt.setString(3, ((Turma) entidade).getPeriodo());
                //preciso arrumar isso
                //stmt.set(4, ((Turma) entidade).getDisciplinas().get(1));
                stmt.setInt(4, entidade.getId());

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
        String sql = "DELETE FROM turmas WHERE id_turma=?";

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
        String sql = "SELECT * FROM turmas";
        
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
                turma.setPeriodo(rs.getString("periodo"));
                turma.setId(rs.getInt("disciplinas_id_disciplina"));                
                //turma.setDisciplina(disciplina);
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
    public List consultar(int id) {
        try {
            this.conn = ConnectionConstructor.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * FROM turmas WHERE id_turma=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Turma> turmas = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Turma turma = new Turma();
                
                turma.setId(rs.getInt("id_turma"));
                turma.setNome(rs.getString("nome"));
                turma.setPeriodo(rs.getString("periodo"));
                turma.setId(rs.getInt("disciplinas_id_disciplina"));                
                //turma.setDisciplina(disciplina);
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
    
}
