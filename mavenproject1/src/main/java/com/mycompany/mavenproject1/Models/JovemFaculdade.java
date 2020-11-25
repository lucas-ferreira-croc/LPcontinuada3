package com.mycompany.mavenproject1.Models;

public class JovemFaculdade extends Jovem {
    
    protected String universidade;
    protected String curso;

    
    public JovemFaculdade(Integer idade, String hobbie, String nome, Boolean trabalha, String escolaridade, Double diversao, Double nota1, Double nota2) {
        super(idade, hobbie, nome, trabalha, escolaridade, diversao, nota1, nota2);
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    
}

