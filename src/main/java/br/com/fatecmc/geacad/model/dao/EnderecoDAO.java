package br.com.fatecmc.geacad.model.dao;

import br.com.fatecmc.geacad.model.domain.Curso;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import br.com.fatecmc.geacad.util.ConnectionConstructor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO implements IDAO {
    private Connection conn;

    @Override
    public int salvar(EntidadeDominio entidade) {
        int id = 0;
        this.conn = ConnectionConstructor.getConnection();
        String sql = "INSERT INTO cursos(nome, turno, descricao, duracao) VALUES(?, ?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Curso){
            try {
                conn.setAutoCommit(false);
                
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, ((Curso) entidade).getNome());
                stmt.setString(2, ((Curso) entidade).getTurno());
                stmt.setString(3, ((Curso) entidade).getDescricao());
                stmt.setInt(4, ((Curso) entidade).getDuracao());

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
        String sql = "UPDATE cursos SET nome=?, turno=?, descricao=?, duracao=? WHERE id_curso=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Curso){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Curso) entidade).getNome());
                stmt.setString(2, ((Curso) entidade).getTurno());
                stmt.setString(3, ((Curso) entidade).getDescricao());
                stmt.setInt(4, ((Curso) entidade).getDuracao());
                stmt.setInt(5, entidade.getId());

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
        String sql = "DELETE FROM cursos WHERE id_curso=?";

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
        String sql = "SELECT * FROM cursos";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Curso> cursos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Curso curso = new Curso();
                
                curso.setId(rs.getInt("id_curso"));
                curso.setNome(rs.getString("nome"));
                curso.setTurno(rs.getString("turno"));
                curso.setDescricao(rs.getString("descricao"));
                curso.setDuracao(rs.getInt("duracao"));
                
                cursos.add(curso);
            }
                
            return cursos;
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
        String sql = "SELECT * FROM cursos WHERE id_curso=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Curso> cursos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Curso curso = new Curso();
                
                curso.setId(rs.getInt("id_curso"));
                curso.setNome(rs.getString("nome"));
                curso.setTurno(rs.getString("turno"));
                curso.setDescricao(rs.getString("descricao"));
                curso.setDuracao(rs.getInt("duracao"));
                
                cursos.add(curso);
            }
                
            return cursos;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionConstructor.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
}
