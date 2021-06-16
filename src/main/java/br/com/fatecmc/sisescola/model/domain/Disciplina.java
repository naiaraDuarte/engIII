package br.com.fatecmc.sisescola.model.domain;

import java.util.ArrayList;

public class Disciplina extends EntidadeDominio {

    private String nome;
    private int carga_horaria;

    public Disciplina() {
    }

    public Disciplina(String nome, int carga_hr, int id_disci) {
        super(id_disci);
        this.nome = nome;
        this.carga_horaria = carga_hr;
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
}
