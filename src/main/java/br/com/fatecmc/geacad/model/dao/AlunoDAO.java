package br.com.fatecmc.geacad.model.dao;

import br.com.fatecmc.geacad.model.domain.*;
import br.com.fatecmc.geacad.util.ConnectionConstructor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDAO implements IDAO {

    private Connection conn;

    @Override
    public int salvar(EntidadeDominio entidade) {
        int id = 0;
        try {
            this.conn = ConnectionConstructor.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "INSERT INTO aluno(ra, cpf, telefone, data_nasc, sexo, fk_turma, nome) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;

        if (entidade instanceof Aluno) {
            try {
                conn.setAutoCommit(false);

                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, ((Aluno) entidade).getRa());
                stmt.setString(2, ((Aluno) entidade).getCpf());
                stmt.setString(3, ((Aluno) entidade).getTelefone());
                stmt.setDate(4, (Date) ((Aluno) entidade).getData_nascimento());
                stmt.setString(5, ((Aluno) entidade).getSexo());
                stmt.setInt(6, ((Aluno) entidade).getTurma().getId());
                stmt.setString(7, ((Aluno) entidade).getNome());

                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                }

                //EnderecoDAO enderecoDAO = new EnderecoDAO(conn);
               // Endereco endereco = new Endereco();
                //endereco.setId_pessoa(id);
                //enderecoDAO.salvar(endereco);

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
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "UPDATE aluno SET ra=?, cpf=?, telefone=?, data_nasc=?, sexo=?, fk_turma=?, fk_endereco=?, nome=? WHERE id_aluno=?";

        PreparedStatement stmt = null;

        if (entidade instanceof Aluno) {
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Aluno) entidade).getRa());
                stmt.setString(2, ((Aluno) entidade).getCpf());
                stmt.setString(3, ((Aluno) entidade).getTelefone());
                stmt.setDate(4, (Date) ((Aluno) entidade).getData_nascimento());
                stmt.setString(5, ((Aluno) entidade).getSexo());
                stmt.setInt(6, ((Aluno) entidade).getTurma().getId());
                stmt.setInt(7, ((Aluno) entidade).getEndereco().getId());
                stmt.setString(8, ((Aluno) entidade).getNome());

                if (stmt.executeUpdate() == 1) {
                    return true;
                }
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
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "DELETE FROM aluno WHERE id_aluno=?";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            if (stmt.executeUpdate() == 1) {
                return true;
            }
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
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * FROM aluno";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Aluno> alunos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno();
                Turma turma = new Turma();
                Endereco endereco = new Endereco();

                aluno.setId(rs.getInt("id_aluno"));
                aluno.setRa(rs.getString("ra"));
                aluno.setNome(rs.getString("nome"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setData_nascimento(rs.getDate("data_nasc"));
                aluno.setSexo(rs.getString("sexo"));
                //aluno.setEndereco(rs.getString("Endereco"));
                //aluno.setEndereco;

                turma.setId(rs.getInt("fk_turma"));

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
        try {
            this.conn = ConnectionConstructor.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * FROM aluno WHERE id_aluno=?";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Aluno> alunos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno();
                Turma turma = new Turma();

                aluno.setId(rs.getInt("id_aluno"));
                aluno.setRa(rs.getString("ra"));
                aluno.setNome(rs.getString("nome"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setData_nascimento(rs.getDate("data_nasc"));
                aluno.setSexo(rs.getString("sexo"));
                turma.setId(rs.getInt("fk_turma"));

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
