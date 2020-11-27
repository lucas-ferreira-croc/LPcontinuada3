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
public class Guerreiro extends Heroi {

    public Guerreiro(String nome, Integer vida, Integer stamina, Integer especial, String nomeImg) {
        super(nome, vida, stamina, especial, nomeImg);
    }

    @Override
    public void atacarFisico(Heroi inimigo, Integer vidaInimigo, Guerreiro personagem, Integer stamina, Integer especial) {
        if (vidaInimigo > 0) {
            if (stamina >= 80) {
                vidaInimigo -= 20;
                stamina -= 25;
                JOptionPane.showMessageDialog(null, "BONK! BONK! TOMA PORRADA FORTE NA CABEÇA");
            } else if (stamina >= 50) {
                vidaInimigo -= 15;
                stamina -= 30;
                JOptionPane.showMessageDialog(null, "BONK! BONK! TOMA PORRADA MÉDIA NA CABEÇA");
            } else if (stamina >= 20) {
                vidaInimigo -= 10;
                stamina -= 10;
                JOptionPane.showMessageDialog(null, "bonkzinho... to fraco nas porrada");
            } else {
                stamina = 0;
                JOptionPane.showMessageDialog(null, "to muito cansado pra dar porrada");
            }
            
            
        } else {
            vidaInimigo = 0;
        }

        especial++;

        inimigo.setVida(vidaInimigo);
        personagem.setStamina(stamina);
        personagem.setEspecial(especial);
    }

    @Override
    public void atacarMagico() {
        JOptionPane.showMessageDialog(null, "TA LOCO DE SOLTAR PODERZIN MAGICO? \n VOCÊ É UM GUERREIRO");
        stamina -= 30;
    }

    @Override
    public void lancarEspecial(Heroi inimigo, Guerreiro aliado, Integer vidaInimigo, Integer especial) {
        if (especial == 5) {
            vidaInimigo -= 40;
            JOptionPane.showMessageDialog(null, "ULTRA MEGA BONK NA CABEÇA \n PORRADÃO DIVINO");
            especial = 0;
        } else {
            JOptionPane.showMessageDialog(null, "não estou preparado ainda . . .");
            especial -= 1;
        }

        inimigo.setVida(vidaInimigo);
        aliado.setEspecial(especial);
    }

    @Override
    public void descansar(Guerreiro personagem, Integer vidaPersonagem) {
        if(vidaPersonagem >= 85){
            vidaPersonagem = 100;
        }
        else if(vidaPersonagem >= 50){
            vidaPersonagem += 15;
        }else if(vidaPersonagem >= 20 ){
            vidaPersonagem += 10;
        }else if(vidaPersonagem > 0){
            vidaPersonagem += 5;
        }

        JOptionPane.showMessageDialog(null, "Descansar é uma parte crucial de ser um guerreiro");
        personagem.setVida(vidaPersonagem);
    }

    public static void main(String[] args) {
        Guerreiro g = new Guerreiro("c", 30, 10, 5, "q");
        //super(nome, vida, stamina, especial, nomeImg);
        Guerreiro inimigo = new Guerreiro("D", 100, 100, 0, "c");

        //public void atacarFisico(Guerreiro inimigo,  Integer vidaInimigo, Guerreiro personagem , Integer stamina, Integer especial)
        //g.atacarFisico(inimigo, inimigo.getVida(), g, g.getStamina(), g.getEspecial());
        //Heroi inimigo, Guerreiro aliado, Integer vidaInimigo, Integer especial
        
        //g.lancarEspecial(inimigo, g, inimigo.getVida(), g.getEspecial());
        
        g.descansar(g, g.getVida());
        
        System.out.println(g.getVida().toString());

        //System.out.println(g.getStamina().toString());

        //System.out.println(g.getEspecial().toString());

        //g.atacarMagico();
    }
}
