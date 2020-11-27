/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.Models;

import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author CLIENTE
 */
public class Inimigo extends Heroi {

    public Inimigo(String nome, Integer vida, Integer stamina, Integer especial, String nomeImg) {
        super(nome, vida, stamina, especial, nomeImg);
    }

    @Override
    public void atacarFisico(Heroi personagem, Heroi inimigo, Integer vidaInimigo, Integer stamina, Integer especial) {

        vidaInimigo -= 20;
        especial++;
        stamina -= 15;

        personagem.setVida(vidaInimigo);
        inimigo.setStamina(stamina);
        inimigo.setEspecial(especial);

        JOptionPane.showMessageDialog(null, "O GATOPOLVO DÁ UMA CHICOTADA EM VOCÊ COM UM DE SEUS TENTÁCULOS");

    }

    @Override
    public void atacarMagico(Heroi personagem, Heroi inimigo, Integer vidaInimigo, Integer stamina, Integer especial) {

        vidaInimigo -= 25;
        especial++;
        stamina -= 20;

        personagem.setVida(vidaInimigo);
        inimigo.setStamina(stamina);
        inimigo.setEspecial(especial);

        JOptionPane.showMessageDialog(null, "O GATOPOLVO LANÇA UMA DENSA E ESPESSA NUVEM DE TINTA PRETA");

    }

    @Override
    public void lancarEspecial(Heroi personagem, Heroi inimigo, Integer vidaInimigo, Integer especial) {

        vidaInimigo -= 50;
        especial = 0;

        personagem.setVida(vidaInimigo);
        inimigo.setEspecial(especial);

        JOptionPane.showMessageDialog(null, "USANDO SEU PODER DE VERSIONAMENTO , O GATOPOLVO \n"
                + " FEZ VOCÊ VOLTAR A UMA VERSÃO MAIS FRACA DE SI MESMO");

    }

    @Override
    public void descansar(Heroi inimigo, Integer vida) {
        vida += 15;
        inimigo.setVida(vida);
        JOptionPane.showMessageDialog(null, "USANDO SEU PODER DE VERSIONAMENTO, O GATOPOLVO \n"
                + "VOLTOU A UMA VERSÃO MAIS SAUDÁVEL");
    }

    
    public static void main(String[] args) {
        Inimigo polvo = new Inimigo("polvo", 100, 100, 5, "oi");
        //polvo.lancarEspecial(polvo, polvo, 100, 5);

        for (int i = 0; i < 10; i++) {
            Integer oi = ThreadLocalRandom.current().nextInt(0,5);
            
            System.out.println(oi);
        }
    }
}
