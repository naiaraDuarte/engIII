package br.com.fatecmc.esiii.cadastros;

import br.com.fatecmc.esiii.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Aluno {
    protected int id;
    private String nome;
    private String sobrenome;
    private String materia;

    public Aluno() {

    }

    public Aluno(String nome, String sobrenome, String materia) {
        
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void salvar() throws Exception {
        Connection connection=null;
		PreparedStatement pst=null;			
		try {
			connection = Conexao.getConnectionPostgres();	
			connection.setAutoCommit(false);				

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO aluno(nome, sobrenome, materia)");
			sql.append("VALUES (?, ?, ?)");	
					
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, nome);
			pst.setString(2, sobrenome);
			pst.setString(3, materia);
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();			
			if(rs.next())
				id = rs.getInt(1);
			
			connection.commit();		
		} catch (SQLException | ClassNotFoundException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			
		}finally{
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

    }

}
