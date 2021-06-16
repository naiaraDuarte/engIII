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
        Aluno aluno = (Aluno) entidade;
        try {
            this.conn = ConnectionConstructor.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "INSERT INTO aluno(ra, cpf, telefone, data_nasc, sexo, fk_turma, nome, fk_endereco) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;

        EnderecoDAO enderecoDAO = new EnderecoDAO(conn);
        Endereco end = aluno.getEndereco();
        end.setId(enderecoDAO.salvar(end));
        aluno.setEndereco(end);

        if (entidade instanceof Aluno) {
            try {
                conn.setAutoCommit(false);

                Date convertedDate = new java.sql.Date(aluno.getData_nascimento().getTime());

                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, aluno.getRa());
                stmt.setString(2, aluno.getCpf());
                stmt.setString(3, aluno.getTelefone());
                stmt.setDate(4, convertedDate);
                stmt.setString(5, aluno.getSexo());
                stmt.setInt(6, aluno.getTurma().getId());
                stmt.setString(7, aluno.getNome());
                stmt.setInt(8, aluno.getEndereco().getId());

                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                }

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
        Aluno aluno = (Aluno) entidade;
        try {
            this.conn = ConnectionConstructor.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        PreparedStatement stmt = null;
        ResultSet rs = null;

        EnderecoDAO enderecoDAO = new EnderecoDAO(conn);
        Endereco end = aluno.getEndereco();
        enderecoDAO.alterar(end);
        aluno.setEndereco(end);

        try {

            String sql = "UPDATE aluno SET ra=?, cpf=?, telefone=?, data_nasc=?, sexo=?, fk_turma=?, fk_endereco=?, nome=? WHERE id_aluno=?";
            stmt = conn.prepareStatement(sql);

            if (entidade instanceof Aluno) {
                try {
                    Date convertedDate = new java.sql.Date(aluno.getData_nascimento().getTime());

                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, aluno.getRa());
                    stmt.setString(2, aluno.getCpf());
                    stmt.setString(3, aluno.getTelefone());
                    stmt.setDate(4, convertedDate);
                    stmt.setString(5, aluno.getSexo());
                    stmt.setInt(6, aluno.getTurma().getId());
                    stmt.setInt(7, aluno.getEndereco().getId());
                    stmt.setString(8, aluno.getNome());
                    stmt.setInt(9, aluno.getId());

                    if (stmt.executeUpdate() == 1) {
                        return true;
                    }
                } catch (SQLException ex) {
                    System.out.println("Não foi possível alterar os dados no banco de dados.\nErro: " + ex.getMessage());
                } finally {
                    ConnectionConstructor.closeConnection(conn, stmt);
                }
            }

        } catch (Exception e) {

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

                aluno.setId(rs.getInt("id_aluno"));
                aluno.setRa(rs.getString("ra"));
                aluno.setNome(rs.getString("nome"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setData_nascimento(rs.getDate("data_nasc"));
                aluno.setSexo(rs.getString("sexo"));

                EnderecoDAO enderecoDAO = new EnderecoDAO(conn);
                Endereco end = aluno.getEndereco();
                end = enderecoDAO.consultarParaTeste(rs.getInt("fk_endereco"));
                aluno.setEndereco(end);

                //aluno.setEndereco();

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
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
        // o consultar do prof esta diferente, não é uma consulta no banco;

        return null;
    }

    @Override
    public List consultarId(int id) {
        try {
            this.conn = ConnectionConstructor.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * FROM aluno WHERE id_aluno=?";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<EntidadeDominio> alunos = new ArrayList<>();
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
