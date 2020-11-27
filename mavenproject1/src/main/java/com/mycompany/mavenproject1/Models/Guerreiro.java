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
    
    
    public void atacarMagico(Guerreiro guerreiro, Integer stamina) {
        JOptionPane.showMessageDialog(null, "TA LOCO DE SOLTAR PODERZIN MAGICO? \n VOCÊ É UM GUERREIRO");
        stamina -= 30;
        
        guerreiro.setStamina(stamina);
    }
    
    
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
    
   
    public void descansar(Guerreiro guerreiro, Integer vidaPersonagem, Integer stamina) {
            vidaPersonagem += 25;
            stamina += 20;
        
            guerreiro.setStamina(stamina);
            guerreiro.setVida(vidaPersonagem);
                    
            JOptionPane.showMessageDialog(null, "Descansar é uma parte crucial de ser um guerreiro");

        }
        
    }
   
 

