/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.Models;

import javax.swing.JOptionPane;

/**
 *
 * @author CLIENTE
 */
public class Mago extends Heroi {

    public Mago(String nome, Integer vida, Integer stamina, Integer especial, String nomeImg) {
        super(nome, vida, stamina, especial, nomeImg);
    }

    public void atacarFisico(Heroi inimigo, Mago personagem, Integer vidaInimigo, Integer stamina, Integer especial) {
        if (vidaInimigo > 0) {
            if (stamina >= 80) {
                vidaInimigo -= 10;
                stamina -= 35;
                JOptionPane.showMessageDialog(null, "To com energia, mas não sou porradeiro");
            } else if (stamina >= 50) {
                vidaInimigo -= 5;
                stamina -= 45;
                JOptionPane.showMessageDialog(null, "To ficando cansado, preciso parar de dar porrada");
            } else if (stamina >= 20) {
                vidaInimigo -= 2;
                stamina -= 15;
                JOptionPane.showMessageDialog(null, "To tão cansado . . . e batendo fraco nele . . .");
            } else {
                stamina = 0;
                JOptionPane.showMessageDialog(null, "Não consigo nem alcançar ele . . .");
            }

        } else {
            vidaInimigo = 0;
        }

        especial++;

        inimigo.setVida(vidaInimigo);
        personagem.setStamina(stamina);
        personagem.setEspecial(especial);
    }

    public void atacarMagico(Heroi inimigo, Mago personagem, Integer vidaInimigo, Integer stamina, Integer especial) {
        if (vidaInimigo > 0) {
            if (stamina >= 80) {
                vidaInimigo -= 30;
                stamina -= 35;
                JOptionPane.showMessageDialog(null, "BOLA DE FOGOOOO!");
            } else if (stamina >= 50) {
                vidaInimigo -= 20;
                stamina -= 25;
                JOptionPane.showMessageDialog(null, "FLECHAS DE GELOOOO!");
            } else if (stamina >= 20) {
                vidaInimigo -= 10;
                stamina -= 15;
                JOptionPane.showMessageDialog(null, "Explosão de flores . . . \n to ficando sem poder . . .");
            } else {
                stamina = 0;
                JOptionPane.showMessageDialog(null, "estou sem mana . . .");
            }

        } else {
            vidaInimigo = 0;
        }

        especial++;

        inimigo.setVida(vidaInimigo);
        personagem.setStamina(stamina);
        personagem.setEspecial(especial);
    }

    public void lancarEspecial(Heroi inimigo, Mago aliado, Integer vidaInimigo, Integer especial) {
        if (especial == 5) {
            vidaInimigo -= 60;
            JOptionPane.showMessageDialog(null, "..... EXPLOSÃO DE VENENO .....");
            especial = 0;
        } else {
            JOptionPane.showMessageDialog(null, "não estou preparado ainda . . .");
            especial -= 1;
        }

        inimigo.setVida(vidaInimigo);
        aliado.setEspecial(especial);
    }

    public void descansar(Mago personagem, Integer vidaPersonagem, Integer stamina) {

        vidaPersonagem += 15;
        stamina += 20;

        JOptionPane.showMessageDialog(null, "Magos nunca descansam(pelo menos não completamente)");
        personagem.setVida(vidaPersonagem);
        personagem.setStamina(stamina);
    }

}
