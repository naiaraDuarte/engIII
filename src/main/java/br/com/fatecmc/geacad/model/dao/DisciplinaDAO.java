package br.com.fatecmc.geacad.model.dao;

import br.com.fatecmc.geacad.model.domain.*;
import br.com.fatecmc.geacad.util.ConnectionConstructor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO implements IDAO {
    private Connection conn;

    @Override
    public int salvar(EntidadeDominio entidade) {
        int id = 0;
        this.conn = ConnectionConstructor.getConnection();
        String sql = "INSERT INTO disciplinas(nome, carga_horaria, ementa, objetivo, bibliografia, "
                + "semestre_recomendado, cursos_id_curso, professores_id_professor) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Disciplina){
            try {
                conn.setAutoCommit(false);
                
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, ((Disciplina) entidade).getNome());
                stmt.setInt(2, ((Disciplina) entidade).getCarga_horaria());
                stmt.setString(3, ((Disciplina) entidade).getEmenta());
                stmt.setString(4, ((Disciplina) entidade).getObjetivo());
                stmt.setString(5, ((Disciplina) entidade).getBibliografia());
                stmt.setInt(6, ((Disciplina) entidade).getSemestre_recomendado());
                stmt.setInt(7, ((Disciplina) entidade).getCurso().getId());
                stmt.setInt(8, ((Disciplina) entidade).getProfessor().getId());

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
        String sql = "UPDATE disciplinas SET nome=?, carga_horaria=?, ementa=?, objetivo=?, "
                + "bibliografia=?, semestre_recomendado=?, cursos_id_curso=?, professores_id_professor=? WHERE id_disciplina=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Disciplina){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Disciplina) entidade).getNome());
                stmt.setInt(2, ((Disciplina) entidade).getCarga_horaria());
                stmt.setString(3, ((Disciplina) entidade).getEmenta());
                stmt.setString(4, ((Disciplina) entidade).getObjetivo());
                stmt.setString(5, ((Disciplina) entidade).getBibliografia());
                stmt.setInt(6, ((Disciplina) entidade).getSemestre_recomendado());
                stmt.setInt(7, ((Disciplina) entidade).getCurso().getId());
                stmt.setInt(8, ((Disciplina) entidade).getProfessor().getId());
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
        this.conn = ConnectionConstructor.getConnection();
        String sql = "DELETE FROM disciplinas WHERE id_disciplina=?";

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
        String sql = "SELECT * FROM disciplinas";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Disciplina> disciplinas = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Disciplina disciplina = new Disciplina();
                Curso curso = new Curso();
                Professor professor = new Professor();
                
                disciplina.setId(rs.getInt("id_disciplina"));
                disciplina.setNome(rs.getString("nome"));
                disciplina.setCarga_horaria(rs.getInt("carga_horaria"));
                disciplina.setEmenta(rs.getString("ementa"));
                disciplina.setObjetivo(rs.getString("objetivo"));
                disciplina.setBibliografia(rs.getString("bibliografia"));
                disciplina.setSemestre_recomendado(rs.getInt("semestre_recomendado"));
                curso.setId(rs.getInt("cursos_id_curso"));
                professor.setId(rs.getInt("professores_id_professor"));
                
                disciplina.setCurso(curso);
                disciplina.setProfessor(professor);
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
    public List consultar(int id) {
        this.conn = ConnectionConstructor.getConnection();
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
                Curso curso = new Curso();
                Professor professor = new Professor();
                
                disciplina.setId(rs.getInt("id_disciplina"));
                disciplina.setNome(rs.getString("nome"));
                disciplina.setCarga_horaria(rs.getInt("carga_horaria"));
                disciplina.setEmenta(rs.getString("ementa"));
                disciplina.setObjetivo(rs.getString("objetivo"));
                disciplina.setBibliografia(rs.getString("bibliografia"));
                disciplina.setSemestre_recomendado(rs.getInt("semestre_recomendado"));
                curso.setId(rs.getInt("cursos_id_curso"));
                professor.setId(rs.getInt("professores_id_professor"));
                
                disciplina.setCurso(curso);
                disciplina.setProfessor(professor);
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
