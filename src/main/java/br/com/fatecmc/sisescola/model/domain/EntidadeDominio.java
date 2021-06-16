package br.com.fatecmc.sisescola.model.domain;

public class EntidadeDominio {
    private int id;

    public EntidadeDominio() {
        this.id = 0;
    }
    
    public EntidadeDominio(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
