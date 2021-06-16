package br.com.fatecmc.sisescola.model.domain;

public class Endereco extends EntidadeDominio {
    private String logradouro;
    private String numero;
    private String cidade;
    private String bairro;
    private String cep;
    private String estado;
    private Pessoa pessoa;

    public Endereco() {
    }

    public Endereco(int id) {
        super(id);
    }

    
    public Endereco(String logradouro, String numero, String cidade, String bairro, String cep, String estado, Pessoa pessoa) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.estado = estado;
        this.pessoa = pessoa;
    }

    public Endereco(String logradouro, String numero, String cidade, String bairro, String cep, String estado, Pessoa pessoa, int id) {
        super(id);
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.estado = estado;
         this.pessoa = pessoa;
    }

    public Endereco(String logradouro, String numero, String cidade, String uf, String bairro, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}

