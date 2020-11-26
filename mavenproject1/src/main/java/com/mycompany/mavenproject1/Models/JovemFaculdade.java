package com.mycompany.mavenproject1.Models;

public class JovemFaculdade extends Jovem {

    public JovemFaculdade(Integer idade, String nome, Boolean trabalha, Integer escolaridade) {
        super(idade, nome, trabalha, escolaridade);
    }

    @Override
    String trabalhar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    String estudar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void envelhecer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void divertir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

