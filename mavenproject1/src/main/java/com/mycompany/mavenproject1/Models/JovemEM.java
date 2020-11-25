package com.mycompany.mavenproject1.Models;

public class JovemEM extends Jovem {

    protected String escola;

    public JovemEM(Integer idade, String hobbie, String nome, Boolean trabalha, String escolaridade, Double diversao, Double nota1, Double nota2) {
        super(idade, hobbie, nome, trabalha, escolaridade, diversao, nota1, nota2);
    }

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

}
