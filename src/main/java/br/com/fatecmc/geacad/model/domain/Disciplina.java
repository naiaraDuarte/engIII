package br.com.fatecmc.geacad.model.domain;

import java.util.ArrayList;

public class Disciplina extends EntidadeDominio {
    private String nome;
    private int carga_horaria;
    private Professor professor;

    public Disciplina() {
    }
    
    public Disciplina(String nome, int carga_horaria, Professor professor) {
        this.nome = nome;
        this.carga_horaria = carga_horaria;
        this.professor = professor;;
    }

    public Disciplina(String nome, int carga_hr, Professor professor, int id_disci) {
        this.nome = nome;
        this.carga_horaria = carga_horaria;
        this.professor = professor;        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
   
}
