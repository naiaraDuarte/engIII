package br.com.fatecmc.geacad.model.domain;

import java.util.ArrayList;
import java.util.Date;

public class Turma extends EntidadeDominio {
    private String descricao;
    private String ano;
    private String periodo;
    private ArrayList<Disciplina> disciplinas;
    
    public Turma() {
        super(0);
        this.descricao = "";
        this.ano= "";
        this.periodo="";
                    
    }

    public Turma(String descricao, String ano, ArrayList<Disciplina> disciplinas, String periodo) {
        this.descricao = descricao;
        this.ano = ano;
        this.disciplinas = disciplinas;
        this.periodo = periodo;
    }

    public Turma(String descricao, String ano, String periodo, int id_turma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    }

    