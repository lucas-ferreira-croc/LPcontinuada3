package com.mycompany.mavenproject1.Models;

public class JovemTrabalhador extends Jovem {
    
    protected String empresa;
    protected Double salario;
    protected String cargo;
    
    public JovemTrabalhador(Integer idade, String hobbie, String nome, Boolean trabalha, String escolaridade, Double diversao, Double nota1, Double nota2) {
        super(idade, hobbie, nome, trabalha, escolaridade, diversao, nota1, nota2);
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
