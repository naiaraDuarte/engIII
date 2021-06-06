package br.com.fatecmc.geacad.model.domain;

import java.util.Date;

public abstract class Pessoa extends EntidadeDominio {
    private String nome;
    private String telefone;
    private String cpf;
    private Date data_nascimento;
    private String sexo;
    
    public Pessoa() {
        super(0);
        this.nome = "";
        this.telefone = "";
        this.cpf = "";
        this.data_nascimento = new Date();
        this.sexo = "";
    }

    public Pessoa(String nome, String telefone, String cpf, Date data_nascimento, String sexo) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
    }

    public Pessoa(String nome, String telefone, String cpf,Date data_nascimento, String sexo, int id) {
        super(id);
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
    
}
