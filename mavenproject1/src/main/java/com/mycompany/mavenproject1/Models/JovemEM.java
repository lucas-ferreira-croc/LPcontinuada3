package com.mycompany.mavenproject1.Models;

public class JovemEM extends Jovem {

    public JovemEM(Integer idade, String nome, Boolean trabalha, Integer escolaridade) {
        super(idade, nome, trabalha, escolaridade);
    }

    String trabalhar() {
        String fraseTrabalho;

        if (!this.trabalha) {
            fraseTrabalho = "Eu não trabalho não. só jogo, durmo e estudo XD";
        } else {
            fraseTrabalho = "Infelizmente eu trabalho desde cedo >:(";
        }
        return fraseTrabalho;
    }

    String estudar() {
        String fraseEstuda = "";

        if (!this.trabalha && this.idade == 15) {
            fraseEstuda = "Cheguei no Ensino Médio agora! to curtindo";

        } else if (!this.trabalha && this.idade == 16) {
            fraseEstuda = "To no segundo ano. Ta ficando difícil";

        } else if (!this.trabalha && this.idade == 17) {
            fraseEstuda = "Terceirão...to morto";
        } 
        
        else{
            if (this.idade == 15) {
                fraseEstuda = "Trabalhar e estudar com 15 anos é  difícil ...";
            }
            else if(this.idade == 16){
                fraseEstuda = "Não to dando muita atenção nem pra um nem pra outro...";;
            }
            else if(this.idade == 17){
                fraseEstuda = "To preocupado com o ENEM e com a conta de luz";
            }
        }

        return fraseEstuda;

    }

    @Override
    void envelhecer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void divertir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        JovemEM jovenzinho = new JovemEM(17, "luvas", false, 1);
        System.out.println(jovenzinho.estudar());
    }
}
