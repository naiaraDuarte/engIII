package br.com.fatecmc.geacad.model.dao;

import br.com.fatecmc.geacad.model.domain.*;
import br.com.fatecmc.geacad.util.ConnectionConstructor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO implements IDAO {
    private Connection conn;

    @Override
    public int salvar(EntidadeDominio entidade) {
        int id = 0;
        this.conn = ConnectionConstructor.getConnection();
        String sql = "INSERT INTO alunos(status, ra, pessoas_id_pessoa, turmas_id_turma) VALUES(?, ?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Aluno){
            try {
                conn.setAutoCommit(false);
                
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, ((Aluno) entidade).getStatus());
                stmt.setString(2, ((Aluno) entidade).getRa());
                stmt.setInt(3, ((Aluno) entidade).getId_pessoa());
                stmt.setInt(4, ((Aluno) entidade).getTurma().getId());

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
        String sql = "UPDATE alunos SET status=?, ra=?, pessoas_id_pessoa=?, turmas_id_turma=? WHERE id_aluno=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Aluno){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Aluno) entidade).getStatus());
                stmt.setString(2, ((Aluno) entidade).getRa());
                stmt.setInt(3, ((Aluno) entidade).getId_pessoa());
                stmt.setInt(4, ((Aluno) entidade).getTurma().getId());
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
        String sql = "DELETE FROM alunos WHERE id_aluno=?";

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
        String sql = "SELECT * FROM alunos LEFT JOIN pessoas ON pessoas_id_pessoa = id_pessoa";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Aluno> alunos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Aluno aluno = new Aluno();
                Turma turma = new Turma();
                
                aluno.setId(rs.getInt("id_aluno"));
                aluno.setStatus(rs.getString("status"));
                aluno.setRa(rs.getString("ra"));
                aluno.setId_pessoa(rs.getInt("pessoas_id_pessoa"));
                aluno.setNome(rs.getString("nome"));
                aluno.setTelefone(rs.getString("rg"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setEmail(rs.getString("email"));
                aluno.setData_nascimento(rs.getDate("data_nascimento"));
                aluno.setSexo(rs.getString("sexo"));
                turma.setId(rs.getInt("turmas_id_turma"));
                
                aluno.setTurma(turma);
                alunos.add(aluno);
            }
                
            return alunos;
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
        String sql = "SELECT * FROM alunos LEFT JOIN pessoas ON pessoas_id_pessoa = id_pessoa WHERE id_aluno=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Aluno> alunos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Aluno aluno = new Aluno();
                Turma turma = new Turma();
                
                aluno.setId(rs.getInt("id_aluno"));
                aluno.setStatus(rs.getString("status"));
                aluno.setRa(rs.getString("ra"));
                aluno.setId_pessoa(rs.getInt("pessoas_id_pessoa"));
                aluno.setNome(rs.getString("nome"));
                aluno.setTelefone(rs.getString("rg"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setEmail(rs.getString("email"));
                aluno.setData_nascimento(rs.getDate("data_nascimento"));
                aluno.setSexo(rs.getString("sexo"));
                turma.setId(rs.getInt("turmas_id_turma"));
                
                aluno.setTurma(turma);
                alunos.add(aluno);
            }
                
            return alunos;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionConstructor.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
}
