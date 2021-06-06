package br.com.fatecmc.geacad.model.domain;

import java.util.ArrayList;
import java.util.Date;

public class Turma extends EntidadeDominio {
    private String nome;
    private String ano;
    private String periodo;
    private ArrayList<Disciplina> disciplinas;
    
    public Turma() {
        super(0);
        this.nome = "";
        this.ano= "";
        this.periodo="";
                    
    }

    public Turma(String nome, String ano, ArrayList<Disciplina> disciplinas, String periodo) {
        this.nome = nome;
        this.ano = ano;
        this.disciplinas = disciplinas;
        this.periodo = periodo;
    }

    public Turma(String nome, String ano, String periodo, Disciplina disciplina, int id_turma) {
        this.nome = nome;
        this.ano = ano;
        this.disciplinas = disciplinas;
        this.periodo = periodo;
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

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
}

    