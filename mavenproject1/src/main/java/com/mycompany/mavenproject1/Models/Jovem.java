package com.mycompany.mavenproject1.Models;

public abstract class Jovem {

    protected Integer idade;
    protected final String nome;
    protected Boolean trabalha;
    protected Integer escolaridade;

    public Jovem(Integer idade, String nome, Boolean trabalha, Integer escolaridade) {
        this.idade = idade;
        this.nome = nome;
        this.trabalha = trabalha;
        this.escolaridade = escolaridade;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Boolean getTrabalha() {
        return trabalha;
    }

    public void setTrabalha(Boolean trabalha) {
        this.trabalha = trabalha;
    }

    public Integer getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Integer escolaridade) {
        this.escolaridade = escolaridade;
    }

    abstract String trabalhar();
    abstract String estudar();
    abstract void envelhecer();
    abstract void divertir();
}
