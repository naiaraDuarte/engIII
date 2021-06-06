package br.com.fatecmc.geacad.model.domain;

import java.util.Date;

public class Professor extends Pessoa {
    private String titulacao;
    private  Endereco endereco;
    private Disciplina disciplina;

    public Professor() {
    }

    public Professor(String titulacao, Endereco endereco, String nome, String rg, String cpf, Date data_nascimento, String sexo) {
        super(nome, rg, cpf, data_nascimento, sexo);
        this.titulacao = titulacao;
        this.endereco = endereco;
    }

    public Professor(String titulacao, Endereco endereco, String nome, String rg, String cpf, Date data_nascimento, String sexo, int id) {
        super(nome, rg, cpf, data_nascimento, sexo, id);
        this.titulacao = titulacao;
        this.endereco = endereco;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
 public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }    
    
    
       
}
