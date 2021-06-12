package br.com.fatecmc.geacad.model.dao;

import br.com.fatecmc.geacad.model.domain.Endereco;
import br.com.fatecmc.geacad.model.domain.Professor;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import br.com.fatecmc.geacad.util.ConnectionConstructor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfessorDAO  implements IDAO{
    private Connection conn;

    @Override
    public int salvar(EntidadeDominio entidade){
        int id = 0;
         Professor professor = (Professor)entidade;
        try {
            this.conn = ConnectionConstructor.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "INSERT INTO professor(nome, cpf, telefone, sexo, formacao, data_nasc, fk_disciplina) VALUES(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;
        
        if(entidade instanceof Professor){
            try {
                conn.setAutoCommit(false);
                
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, ((Professor) entidade).getNome());
                stmt.setString(2, ((Professor) entidade).getCpf());
                stmt.setString(3, ((Professor) entidade).getTelefone());
                stmt.setString(4, ((Professor) entidade).getSexo());                
                stmt.setString(5, ((Professor) entidade).getTitulacao());
                stmt.setDate(6, (Date) ((Professor) entidade).getData_nascimento());
                stmt.setInt(7, ((Professor) entidade).getDisciplina().getId());
                                              
                stmt.executeUpdate();
                
                ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next()) id = rs.getInt(1);
                
                EnderecoDAO enderecoDAO = new EnderecoDAO(conn);
                Endereco endereco = new Endereco();
                Endereco end = professor.getEndereco();
                endereco.setPessoa(professor);
                enderecoDAO.salvar(end);
                
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
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "UPDATE professor SET salario=?, titulacao=?, pessoas_id_pessoa=? WHERE id_professor=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Professor){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Professor) entidade).getNome());
                stmt.setString(2, ((Professor) entidade).getCpf());
                stmt.setString(3, ((Professor) entidade).getTelefone());
                stmt.setString(4, ((Professor) entidade).getSexo());                
                stmt.setString(5, ((Professor) entidade).getTitulacao());
                stmt.setObject(6, ((Professor) entidade).getEndereco());
                stmt.setDate(7, (Date) ((Professor) entidade).getData_nascimento());
                stmt.setObject(7, ((Professor) entidade).getDisciplina());
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
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "DELETE FROM professor WHERE id_professor=?";

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
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * FROM professor";
        //"SELECT * FROM tb_alunos alu + INNER JOIN tb_endereco ende on alu.id_endereco = ende.id")
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Professor> professores = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Professor professor = new Professor();

                professor.setId(rs.getInt("id_professor"));
                professor.setTitulacao(rs.getString("formacao"));
                professor.setNome(rs.getString("nome"));
                professor.setTelefone(rs.getString("telefone"));
                professor.setCpf(rs.getString("cpf"));
                professor.setData_nascimento(rs.getDate("data_nasc"));
                professor.setSexo(rs.getString("sexo"));
                
                professores.add(professor);
            }
                
            return professores;
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
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }//acho que isso ta errado
        String sql = "SELECT * FROM professor LEFT JOIN pessoas ON pessoas_id_professor = id_professor WHERE id_professor=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Professor> professores = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Professor professor = new Professor();

                professor.setId(rs.getInt("id_professor"));
                professor.setTitulacao(rs.getString("titulacao"));;
                professor.setNome(rs.getString("nome"));
                professor.setTelefone(rs.getString("telefone"));
                professor.setCpf(rs.getString("cpf"));
                professor.setData_nascimento(rs.getDate("data_nascimento"));
                professor.setSexo(rs.getString("sexo"));
                
                professores.add(professor);
            }
                
            return professores;
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
