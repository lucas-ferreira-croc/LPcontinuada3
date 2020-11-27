package com.mycompany.mavenproject1.Models;

public abstract class Heroi {

    protected String nome;
    protected Integer vida;
    protected Integer stamina;
    protected Integer especial;
    protected final String nomeImg;

    public Heroi(String nome, Integer vida, Integer stamina, Integer especial, String nomeImg) {
        this.nome = nome;
        this.vida = vida;
        this.stamina = stamina;
        this.especial = especial;
        this.nomeImg = nomeImg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public Integer getStamina() {
        return stamina;
    }

    public void setStamina(Integer stamina) {
        this.stamina = stamina;
    }

    public Integer getEspecial() {
        return especial;
    }

    public void setEspecial(Integer especial) {
        this.especial = especial;
    }

    public String getNomeImg() {
        return nomeImg;
    }

    public void setNomeImg(String nomeImg) {
        this.nomeImg = nomeImg;
    }
    
    
    
    public abstract void atacarFisico();
    public abstract void atacarMagico();
    public abstract void lancarEspecial();
    public abstract void descansar();
}
