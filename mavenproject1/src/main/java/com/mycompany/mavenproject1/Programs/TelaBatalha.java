/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.Programs;

import com.mycompany.mavenproject1.Models.Ganso;
import com.mycompany.mavenproject1.Models.Guerreiro;
import com.mycompany.mavenproject1.Models.Heroi;
import com.mycompany.mavenproject1.Models.Inimigo;
import com.mycompany.mavenproject1.Models.Mago;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author CLIENTE
 */
public class TelaBatalha extends javax.swing.JFrame {

    /**
     * Creates new form TelaBatalha
     */
    protected Guerreiro guerr;
    protected Ganso gans;
    protected Mago mag;
    protected Inimigo inimg;
    protected Integer desig;

    public TelaBatalha(Heroi personagem, Integer designador, Heroi inimigo) {
        initComponents();

        guerr = new Guerreiro(personagem.getNome(), personagem.getVida(), personagem.getStamina(), personagem.getEspecial(), personagem.getNomeImg());

        gans = new Ganso(personagem.getNome(), personagem.getVida(), personagem.getStamina(), personagem.getEspecial(), personagem.getNomeImg());

        mag = new Mago(personagem.getNome(), personagem.getVida(), personagem.getStamina(), personagem.getEspecial(), personagem.getNomeImg());

        inimg = new Inimigo(inimigo.getNome(), inimigo.getVida(), inimigo.getStamina(), inimigo.getEspecial(), inimigo.getNomeImg());

        ImageIcon heroImage = new ImageIcon(personagem.getNomeImg());
        ImageIcon gitImage = new ImageIcon(inimigo.getNomeImg());

        lbHeroi.setText("");
        lbHeroi.setIcon(heroImage);

        lbNome.setText(personagem.getNome());
        lbVilaoNome.setText(inimigo.getNome());

        lbVilao.setText("");
        lbVilao.setIcon(gitImage);

        pbGitVida.setMaximum(inimigo.getVida());
        //pbGitStamina.setMaximum(inimigo.getStamina());

        pbHeroiVida.setMaximum(personagem.getVida());
        pbHeroiStamina.setMaximum(personagem.getStamina());

        //pbGitStamina.setValue(inimigo.getStamina());
        pbGitVida.setValue(inimigo.getVida());

        pbHeroiVida.setValue(personagem.getVida());
        pbHeroiStamina.setValue(personagem.getStamina());

        desig = designador;
    }

    void tomarDecisao(Integer qualAtaque, Inimigo inimigo, Guerreiro guerreiro, Ganso ganso, Mago mago,
            Integer stamina, Integer especial, Integer vidaGuerreiro, Integer vidaGanso, Integer vidaMago, Integer vidaInimigo) {
        if (inimigo.getVida() >= 30) {
            Integer decisao = ThreadLocalRandom.current().nextInt(0, 2);
            if (decisao == 0) {
                qualAtaqueFisico(qualAtaque, guerreiro, mago, ganso, inimigo, stamina, especial, vidaGuerreiro, vidaGanso, vidaMago);
            } else {
                qualAtaqueMagico(qualAtaque, guerreiro, mago, ganso, inimigo, stamina, especial, vidaGuerreiro, vidaGanso, vidaMago);
            }
        } else if (inimigo.getVida() < 30) {
            inimigo.descansar(inimigo, vidaInimigo);
        }

        if (inimigo.getEspecial() == 5) {
            qualEspecial(qualAtaque, inimigo, guerreiro, mago, ganso, vidaGuerreiro, vidaMago, vidaGanso, especial);
        }

    }

    void qualEspecial(Integer quem, Inimigo inimigo, Guerreiro guerreiro, Mago mago, Ganso ganso,
            Integer vidaGuerr, Integer vidaMago, Integer vidaGanso, Integer especial) {

        if (quem == 1) {
            inimigo.lancarEspecial(guerreiro, inimigo, vidaGuerr, especial);
        } else if (quem == 2) {
            inimigo.lancarEspecial(ganso, inimigo, vidaGanso, especial);

        } else if (quem == 3) {
            inimigo.lancarEspecial(mago, inimigo, vidaMago, especial);
        }
    }

    void qualAtaqueFisico(Integer quem, Guerreiro guerreiro, Mago mago, Ganso ganso,
            Inimigo inimigo, Integer stamina, Integer especial, Integer vidaGuerreiro,
            Integer vidaGanso, Integer vidaMago) {

        if (quem == 1) {
            inimigo.atacarFisico(guerreiro, inimigo, vidaGuerreiro, stamina, especial);
        } else if (quem == 2) {
            inimigo.atacarFisico(ganso, inimigo, vidaGanso, stamina, especial);

        } else if (quem == 3) {
            inimigo.atacarFisico(mago, inimigo, vidaMago, stamina, especial);
        }
    }

    void qualAtaqueMagico(Integer quem, Guerreiro guerreiro, Mago mago, Ganso ganso,
            Inimigo inimigo, Integer stamina, Integer especial, Integer vidaGuerreiro,
            Integer vidaGanso, Integer vidaMago) {
        if (quem == 1) {
            inimigo.atacarMagico(guerreiro, inimigo, vidaGuerreiro, stamina, especial);
        } else if (quem == 2) {
            inimigo.atacarMagico(ganso, inimigo, vidaGanso, stamina, especial);

        } else if (quem == 3) {
            inimigo.atacarMagico(mago, inimigo, vidaMago, stamina, especial);
        }
    }

    void atualizarTela(JProgressBar pbVidaPersonagem, JProgressBar pbStaminaPersonagem, JProgressBar pbInimigoBar,
            JLabel lbEspecial, Integer vidaPersonagem, Integer vidaInimigo, Integer especialPersonagem,
            Integer staminaPersonagem) {

        pbVidaPersonagem.setValue(vidaPersonagem);
        pbStaminaPersonagem.setValue(staminaPersonagem);

        pbInimigoBar.setValue(vidaInimigo);
        lbEspecial.setText(especialPersonagem.toString());
    }

    void gitMorreu(Inimigo inimigo) {
        if (inimigo.getVida() == 0) {
            JOptionPane.showMessageDialog(null, "O GATOPOLVO . . . \nSUCUMBIU");

            btAtacar.setEnabled(false);
            btDescansar.setEnabled(false);
            btEspecial.setEnabled(false);
            btMagia.setEnabled(false);
        }
    }

    void voceMorreu(Guerreiro guerreiro, Mago mago) {
        if (guerreiro.getVida() == 0 || mago.getVida() == 0) {
            JOptionPane.showMessageDialog(null, "VOCÊ . . . \nPERECEU");

            btAtacar.setEnabled(false);
            btDescansar.setEnabled(false);
            btEspecial.setEnabled(false);
            btMagia.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        lbHeroi = new javax.swing.JLabel();
        lbVilao = new javax.swing.JLabel();
        btAtacar = new javax.swing.JButton();
        btDescansar = new javax.swing.JButton();
        btMagia = new javax.swing.JButton();
        btEspecial = new javax.swing.JButton();
        pbHeroiVida = new javax.swing.JProgressBar();
        pbHeroiStamina = new javax.swing.JProgressBar();
        pbGitVida = new javax.swing.JProgressBar();
        lbNome = new javax.swing.JLabel();
        lbVilaoNome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbEspecial = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbHeroi.setText("placeholder");

        lbVilao.setText("placeholder");

        btAtacar.setText("Atacar");
        btAtacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtacarActionPerformed(evt);
            }
        });

        btDescansar.setText("Descansar");

        btMagia.setText("Magia");
        btMagia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMagiaActionPerformed(evt);
            }
        });

        btEspecial.setText("Especial");

        pbHeroiVida.setBackground(new java.awt.Color(255, 102, 102));

        lbNome.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbNome.setText("placeHolder");

        lbVilaoNome.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbVilaoNome.setText("placeHolder");

        jLabel1.setText("Especial: ");

        lbEspecial.setText("0");

        jLabel3.setText("/5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btDescansar)
                                .addGap(18, 18, 18)
                                .addComponent(btEspecial))
                            .addComponent(pbHeroiVida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pbHeroiStamina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbHeroi)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btAtacar)
                                .addGap(18, 18, 18)
                                .addComponent(btMagia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbEspecial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lbNome)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbVilaoNome)
                    .addComponent(lbVilao)
                    .addComponent(pbGitVida, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAtacar)
                    .addComponent(btMagia)
                    .addComponent(jLabel1)
                    .addComponent(lbEspecial)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDescansar)
                    .addComponent(btEspecial))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pbHeroiVida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pbGitVida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pbHeroiStamina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(lbVilao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lbHeroi)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(lbVilaoNome))
                .addGap(155, 155, 155))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAtacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtacarActionPerformed
        if (inimg.getVida() != 0) {
            tomarDecisao(desig, inimg, guerr, gans, mag, inimg.getStamina(), inimg.getEspecial(), guerr.getVida(), gans.getVida(), mag.getVida(), inimg.getVida());
        }

        if (desig == 1) {
            guerr.atacarFisico(inimg, inimg.getVida(), guerr, guerr.getStamina(), guerr.getEspecial());
            System.out.println(guerr.getStamina().toString());
            atualizarTela(pbHeroiVida, pbHeroiStamina, pbGitVida, lbEspecial, guerr.getVida(), inimg.getVida(), guerr.getEspecial(), guerr.getStamina());

        } else if (desig == 2) {
            gans.atacarFisico(inimg);
            atualizarTela(pbHeroiVida, pbHeroiStamina, pbGitVida, lbEspecial, mag.getVida(), inimg.getVida(), mag.getEspecial(), mag.getStamina());

        } else {
            mag.atacarFisico(inimg, mag, inimg.getVida(), inimg.getStamina(), inimg.getEspecial());
            atualizarTela(pbHeroiVida, pbHeroiStamina, pbGitVida, lbEspecial, mag.getVida(), inimg.getVida(), mag.getEspecial(), mag.getStamina());

        }

        guerr.setVida(0);
        mag.setVida(0);
        
        gitMorreu(inimg);
        voceMorreu(guerr, mag);
        
    }//GEN-LAST:event_btAtacarActionPerformed

    private void btMagiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMagiaActionPerformed
        if (inimg.getVida() != 0) {
            tomarDecisao(desig, inimg, guerr, gans, mag, inimg.getStamina(), inimg.getEspecial(), guerr.getVida(), gans.getVida(), mag.getVida(), inimg.getVida());
        }

        if (desig == 1) {

            guerr.atacarMagico(guerr, guerr.getStamina());

            atualizarTela(pbHeroiVida, pbHeroiStamina, pbGitVida, lbEspecial, guerr.getVida(), inimg.getVida(), guerr.getEspecial(), guerr.getStamina());

        } else if (desig == 2) {

            gans.atacarMagico(inimg);

            atualizarTela(pbHeroiVida, pbHeroiStamina, pbGitVida, lbEspecial, mag.getVida(), inimg.getVida(), mag.getEspecial(), mag.getStamina());

        } else {

            mag.atacarMagico(inimg, mag, inimg.getVida(), mag.getStamina(), mag.getEspecial());

            atualizarTela(pbHeroiVida, pbHeroiStamina, pbGitVida, lbEspecial, mag.getVida(), inimg.getVida(), mag.getEspecial(), mag.getStamina());
        }

        gitMorreu(inimg);
        voceMorreu(guerr, mag);
    }//GEN-LAST:event_btMagiaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaBatalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBatalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBatalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBatalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtacar;
    private javax.swing.JButton btDescansar;
    private javax.swing.JButton btEspecial;
    private javax.swing.JButton btMagia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lbEspecial;
    private javax.swing.JLabel lbHeroi;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbVilao;
    private javax.swing.JLabel lbVilaoNome;
    private javax.swing.JProgressBar pbGitVida;
    private javax.swing.JProgressBar pbHeroiStamina;
    private javax.swing.JProgressBar pbHeroiVida;
    // End of variables declaration//GEN-END:variables
}
