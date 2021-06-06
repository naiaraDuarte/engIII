package br.com.fatecmc.geacad.model.domain;

import java.util.Date;

public class Aluno extends Pessoa {
    private String ra;
    private Turma turma;
    private Endereco endereco;

    public Aluno() {
    }

    public Aluno(String ra, Turma turma, Endereco endereco) {
        this.ra = ra;
        this.turma = turma;
        this.endereco = endereco;
    }

    public Aluno(String ra, Turma turma, Endereco endereco, String nome, String telefone, String cpf, Date data_nascimento, String sexo) {
        super(nome, telefone, cpf, data_nascimento, sexo);
        this.ra = ra;
        this.turma = turma;
        this.endereco = endereco;
    }

    public Aluno(String ra, Turma turma, Endereco endereco, String nome, String telefone, String cpf, Date data_nascimento, String sexo, int id) {
        super(nome, telefone, cpf, data_nascimento, sexo, id);
        this.ra = ra;
        this.turma = turma;
        this.endereco = endereco;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
    
}
