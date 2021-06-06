package br.com.fatecmc.geacad.model.dao;

import br.com.fatecmc.geacad.model.domain.Curso;
import br.com.fatecmc.geacad.model.domain.Turma;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import br.com.fatecmc.geacad.util.ConnectionConstructor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO implements IDAO {
    private Connection conn;

    @Override
    public int salvar(EntidadeDominio entidade) {
        int id = 0;
        this.conn = ConnectionConstructor.getConnection();
        String sql = "INSERT INTO turmas(descricao, data_inicio, cursos_id_curso) VALUES(?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Turma){
            try {
                conn.setAutoCommit(false);
                
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, ((Turma) entidade).getDescricao());
                stmt.setDate(2, new Date(((Turma) entidade).getData_inicio().getTime()));
                stmt.setInt(3, ((Turma) entidade).getCurso().getId());

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
        this.conn = ConnectionConstructor.getConnection();
        String sql = "UPDATE turmas SET descricao=?, data_inicio=?, cursos_id_curso=? WHERE id_turma=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Turma){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Turma) entidade).getDescricao());
                stmt.setDate(2, new Date(((Turma) entidade).getData_inicio().getTime()));
                stmt.setInt(3, ((Turma) entidade).getCurso().getId());
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
        this.conn = ConnectionConstructor.getConnection();
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
        this.conn = ConnectionConstructor.getConnection();
        String sql = "SELECT * FROM turmas";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Turma> turmas = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Turma turma = new Turma();
                Curso curso = new Curso();
                
                turma.setId(rs.getInt("id_turma"));
                turma.setDescricao(rs.getString("descricao"));
                turma.setData_inicio(rs.getDate("data_inicio"));
                curso.setId(rs.getInt("cursos_id_curso"));
                
                turma.setCurso(curso);
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
        this.conn = ConnectionConstructor.getConnection();
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
                Curso curso = new Curso();
                
                turma.setId(rs.getInt("id_turma"));
                turma.setDescricao(rs.getString("descricao"));
                turma.setData_inicio(rs.getDate("data_inicio"));
                curso.setId(rs.getInt("cursos_id_curso"));
                
                turma.setCurso(curso);
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
