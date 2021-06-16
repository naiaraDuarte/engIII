package br.com.fatecmc.geacad.model.dao;

import br.com.fatecmc.geacad.model.domain.Endereco;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import br.com.fatecmc.geacad.util.ConnectionConstructor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnderecoDAO implements IDAO {

    private Connection conn;

    public EnderecoDAO() {
    }

    public EnderecoDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int salvar(EntidadeDominio entidade) {
        int id = 0;
        try {
            this.conn = ConnectionConstructor.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "INSERT INTO endereco(logradouro, numero, cidade, estado, bairro, cep) VALUES(?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = null;

        if (entidade instanceof Endereco) {
            try {
                conn.setAutoCommit(false);

                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, ((Endereco) entidade).getLogradouro());
                stmt.setString(2, ((Endereco) entidade).getNumero());
                stmt.setString(3, ((Endereco) entidade).getCidade());;
                stmt.setString(4, ((Endereco) entidade).getEstado());
                stmt.setString(5, ((Endereco) entidade).getBairro());
                stmt.setString(6, ((Endereco) entidade).getCep());

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
        try {
            this.conn = ConnectionConstructor.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "UPDATE endereco SET logradouro=?, numero=?, cidade=?, estado=?, bairro=?, cep=? WHERE id_endereco=?";

        PreparedStatement stmt = null;

        if (entidade instanceof Endereco) {
            try {
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, ((Endereco) entidade).getLogradouro());
                stmt.setString(2, ((Endereco) entidade).getNumero());
                stmt.setString(3, ((Endereco) entidade).getCidade());;
                stmt.setString(4, ((Endereco) entidade).getEstado());
                stmt.setString(5, ((Endereco) entidade).getBairro());
                stmt.setString(6, ((Endereco) entidade).getCep());
                stmt.setInt(7, entidade.getId());

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
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "DELETE FROM cursos WHERE id_endereco=?";

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
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * FROM endereco";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Endereco> enderecos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Endereco endereco = new Endereco();

                endereco.setId(rs.getInt("id_endereco"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setNumero(rs.getString("numero"));
                //endereco.setCidade(rs.getString("cidade"));
                //endereco.setDuracao(rs.getInt("duracao"));

                enderecos.add(endereco);
            }

            return enderecos;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionConstructor.closeConnection(conn, stmt, rs);
        }
        return null;
    }

    public List consultarId(int id) {
        return null;
    }
    
    public Endereco consultarParaTeste(int id) {
        try {
            this.conn = ConnectionConstructor.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * FROM endereco WHERE id_endereco=?";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        Endereco endereco = new Endereco();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                //Endereco endereco = new Endereco();

                endereco.setId(rs.getInt("id_endereco"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCep(rs.getString("cep"));

                //enderecos.add(endereco);
            }

            return endereco;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionConstructor.closeConnection(conn, stmt, rs);
        }
        return null;
    }


    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
        try {
            this.conn = ConnectionConstructor.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * FROM endereco WHERE id_endereco=?";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Endereco> enderecos = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(6, ((Endereco) entidade).getId());

            rs = stmt.executeQuery();

            while (rs.next()) {
                Endereco endereco = new Endereco();

                endereco.setId(rs.getInt("id_endereco"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCep(rs.getString("cep"));

                enderecos.add(endereco);
            }

            //return enderecos;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionConstructor.closeConnection(conn, stmt, rs);
        }
        return null;
    }

}
