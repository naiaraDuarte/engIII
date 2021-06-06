package br.com.fatecmc.geacad.model.domain;

import java.util.Date;

public class Aluno extends Pessoa {
    private String ra;
    private Turma turma;

    public Aluno(String ra, Turma turma) {
        this.ra = ra;
        this.turma = turma;
    }

    public Aluno(String ra, Turma turma, String nome, String rg, String cpf, Date data_nascimento, String sexo) {
        super(nome, rg, cpf, data_nascimento, sexo);
        this.ra = ra;
        this.turma = turma;
    }

    public Aluno() {
    }
    
    public Aluno(String ra, Turma turma, String nome, String rg, String cpf, Date data_nascimento, String sexo, int id) {
        super(nome, rg, cpf, data_nascimento, sexo, id);
        this.ra = ra;
        this.turma = turma;
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
    
   

    
    
}
