package br.com.fatecmc.geacad.model.domain;

import java.util.ArrayList;

public class Turma extends EntidadeDominio {

    private String nome;
    private String ano;
    private String periodo;
    private ArrayList<Aluno> alunos;

    public Turma() {
        super(0);
        this.nome = "";
        this.ano = "";
        this.periodo = "";

    }

    public Turma(String nome, String ano, String periodo, ArrayList<Aluno> alunos) {
        this.nome = nome;
        this.ano = ano;
        this.periodo = periodo;
        this.alunos = alunos;
    }

    public Turma(String nome, String ano, String periodo) {
        this.nome = nome;
        this.ano = ano;
        this.periodo = periodo;
    }

    public Turma(String nome, String ano, String periodo, int id_turma) {
        this.nome = nome;
        this.ano = ano;
        this.periodo = periodo;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

}
