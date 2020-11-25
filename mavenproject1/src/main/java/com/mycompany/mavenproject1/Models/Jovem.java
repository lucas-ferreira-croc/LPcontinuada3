package com.mycompany.mavenproject1.Models;

public abstract class Jovem {
    
    protected Integer idade;
    protected String hobbie;
    protected final String nome;
    protected Boolean trabalha;
    protected String escolaridade;
    protected Double diversao;
    protected Double nota1;
    protected Double nota2;
    
    public Jovem(Integer idade, String hobbie, String nome , Boolean trabalha,String escolaridade, Double diversao, Double nota1, Double nota2) {
        this.idade = idade;
        this.hobbie = hobbie;
        this.nome = nome;
        this.trabalha = trabalha;
        this.escolaridade = escolaridade;
        this.diversao = diversao;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }   

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getHobbie() {
        return hobbie;
    }

    public void setHobbie(String hobbie) {
        this.hobbie = hobbie;
    }

    public Boolean getTrabalha() {
        return trabalha;
    }

    public void setTrabalha(Boolean trabalha) {
        this.trabalha = trabalha;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Double getDiversao() {
        return diversao;
    }

    public void setDiversao(Double diversao) {
        this.diversao = diversao;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }
    
    
    
    
}

  