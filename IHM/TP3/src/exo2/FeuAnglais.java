/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo2;

import javax.swing.Timer;

/**
 *
 * @author Hugues
 */
public class FeuAnglais extends javax.swing.JFrame {

    private Etat etat;
    private Timer tRouge, tRougeOrange, tOrange, tVert, tPanneOn, tPanneOff;

    /**
     * Creates new form FeuAnglais
     */
    public FeuAnglais() {
        initComponents();

        etat = Etat.INIT;

        // Initialisation du timer de la couleur rouge
        tRouge = new Timer(1500, null);
        tRouge.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timerRougeActionPerfomed(evt);
            }
        });

        // Initialisation du timer de la couleur orange
        tOrange = new Timer(700, null);
        tOrange.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timerOrangeActionPerfomed(evt);
            }
        });

        // Initialisation du timer de la couleur verte
        tVert = new Timer(1600, null);
        tVert.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timerVertActionPerfomed(evt);
            }
        });

        // Initialisation du timer de la panne on
        tPanneOn = new Timer(600, null);
        tPanneOn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timerPanneOnActionPerfomed(evt);
            }
        });

        // Initialisation du timer de la panne off
        tPanneOff = new Timer(400, null);
        tPanneOff.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timerPanneOffActionPerfomed(evt);
            }
        });

        // Initialisation du timer de la panne off
        tRougeOrange = new Timer(500, null);
        tRougeOrange.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timerRougeOrangeActionPerfomed(evt);
            }
        });

        activationInit();
    }

    private void allumerRouge() {

    }
    
    private void allumerRougeOrange() {

    }
    
    private void allumerOrange() {

    }

    private void allumerVert() {

    }

    private void eteindreTous() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMarche = new javax.swing.JButton();
        jArret = new javax.swing.JButton();
        jPanne = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 223, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
        );

        jMarche.setText("Marche");
        jMarche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMarcheActionPerformed(evt);
            }
        });

        jArret.setText("Arrêt");
        jArret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jArretActionPerformed(evt);
            }
        });

        jPanne.setText("Panne");
        jPanne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPanneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jMarche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jArret, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanne, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jMarche)
                        .addGap(87, 87, 87)
                        .addComponent(jArret)
                        .addGap(88, 88, 88)
                        .addComponent(jPanne)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMarcheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMarcheActionPerformed
        switch (etat) {
            case INIT:
                etat = Etat.ROUGE;
                allumerRouge();
                activationRouge();
                break;
            case ROUGE:
                throw new RuntimeException("Etat interdit");
            case ROUGEORANGE:
                throw new RuntimeException("Etat interdit");
            case ORANGE:
                throw new RuntimeException("Etat interdit");
            case VERT:
                throw new RuntimeException("Etat interdit");
            case PANNEON:
                etat = Etat.ROUGE;
                allumerRouge();
                activationRouge();
                break;
            case PANNEOFF:
                etat = Etat.ROUGE;
                allumerRouge();
                activationRouge();
                break;
        }
    }//GEN-LAST:event_jMarcheActionPerformed

    private void jArretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jArretActionPerformed
        switch (etat) {
            case INIT:
                throw new RuntimeException("Etat interdit");
            case ROUGE:
                etat = Etat.INIT;
                eteindreTous();
                activationInit();
                break;
            case ROUGEORANGE:
                etat = Etat.INIT;
                eteindreTous();
                activationInit();
                break;   
            case ORANGE:
                etat = Etat.INIT;
                eteindreTous();
                activationInit();
                break;
            case VERT:
                etat = Etat.INIT;
                eteindreTous();
                activationInit();
                break;
            case PANNEON:
                etat = Etat.INIT;
                eteindreTous();
                activationInit();
                break;
            case PANNEOFF:
                etat = Etat.INIT;
                eteindreTous();
                activationInit();
                break;
        }
    }//GEN-LAST:event_jArretActionPerformed

    private void jPanneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPanneActionPerformed
        switch (etat) {
            case INIT:
                throw new RuntimeException("Etat interdit");
            case ROUGE:
                etat = Etat.PANNEON;
                allumerOrange();
                activationPanneOn();
                break;
            case ROUGEORANGE:
                etat = Etat.PANNEON;
                allumerOrange();
                activationPanneOn();
                break;      
            case ORANGE:
                etat = Etat.PANNEON;
                allumerOrange();
                activationPanneOn();
                break;
            case VERT:
                etat = Etat.PANNEON;
                allumerOrange();
                activationPanneOn();
                break;
            case PANNEON:
                throw new RuntimeException("Etat interdit");
            case PANNEOFF:
                throw new RuntimeException("Etat interdit");
        }
    }//GEN-LAST:event_jPanneActionPerformed

    private void timerRougeActionPerfomed(java.awt.event.ActionEvent evt) {
        switch (etat) {
            case INIT:
                throw new RuntimeException("Etat interdit");
            case ROUGE:
                etat = Etat.ROUGEORANGE;
                allumerRougeOrange();
                activationRougeOrange();
                break;
            case ROUGEORANGE:
                throw new RuntimeException("Etat interdit");    
            case ORANGE:
                throw new RuntimeException("Etat interdit");
            case VERT:
                throw new RuntimeException("Etat interdit");
            case PANNEON:
                throw new RuntimeException("Etat interdit");
            case PANNEOFF:
                throw new RuntimeException("Etat interdit");
        }
    }

    private void timerRougeOrangeActionPerfomed(java.awt.event.ActionEvent evt) {
        switch (etat) {
            case INIT:
                throw new RuntimeException("Etat interdit");
            case ROUGE:
                throw new RuntimeException("Etat interdit");
            case ROUGEORANGE:
                etat = Etat.VERT;
                allumerVert();
                activationVert();
                break;  
            case ORANGE:
                throw new RuntimeException("Etat interdit");
            case VERT:
                throw new RuntimeException("Etat interdit");
            case PANNEON:
                throw new RuntimeException("Etat interdit");
            case PANNEOFF:
                throw new RuntimeException("Etat interdit");
        }
    }

    private void timerOrangeActionPerfomed(java.awt.event.ActionEvent evt) {
        switch (etat) {
            case INIT:
                throw new RuntimeException("Etat interdit");
            case ROUGE:
                throw new RuntimeException("Etat interdit");
            case ROUGEORANGE:
                throw new RuntimeException("Etat interdit");    
            case ORANGE:
                etat = Etat.ROUGE;
                allumerRouge();
                activationRouge();
                break;
            case VERT:
                throw new RuntimeException("Etat interdit");
            case PANNEON:
                throw new RuntimeException("Etat interdit");
            case PANNEOFF:
                throw new RuntimeException("Etat interdit");
        }
    }

    private void timerVertActionPerfomed(java.awt.event.ActionEvent evt) {
        switch (etat) {
            case INIT:
                throw new RuntimeException("Etat interdit");
            case ROUGE:
                throw new RuntimeException("Etat interdit");
            case ROUGEORANGE:
                throw new RuntimeException("Etat interdit");    
            case ORANGE:
                throw new RuntimeException("Etat interdit");
            case VERT:
                etat = Etat.ORANGE;
                allumerOrange();
                activationOrange();
                break;
            case PANNEON:
                throw new RuntimeException("Etat interdit");
            case PANNEOFF:
                throw new RuntimeException("Etat interdit");
        }
    }

    private void timerPanneOnActionPerfomed(java.awt.event.ActionEvent evt) {
        switch (etat) {
            case INIT:
                throw new RuntimeException("Etat interdit");
            case ROUGE:
                throw new RuntimeException("Etat interdit");
            case ROUGEORANGE:
                throw new RuntimeException("Etat interdit");    
            case ORANGE:
                throw new RuntimeException("Etat interdit");
            case VERT:
                throw new RuntimeException("Etat interdit");
            case PANNEON:
                etat = Etat.PANNEOFF;
                eteindreTous();
                activationPanneOff();
                break;
            case PANNEOFF:
                throw new RuntimeException("Etat interdit");
        }
    }

    private void timerPanneOffActionPerfomed(java.awt.event.ActionEvent evt) {
        switch (etat) {
            case INIT:
                throw new RuntimeException("Etat interdit");
            case ROUGE:
                throw new RuntimeException("Etat interdit");
            case ROUGEORANGE:
                throw new RuntimeException("Etat interdit");    
            case ORANGE:
                throw new RuntimeException("Etat interdit");
            case VERT:
                throw new RuntimeException("Etat interdit");
            case PANNEON:
                throw new RuntimeException("Etat interdit");
            case PANNEOFF:
                etat = Etat.PANNEON;
                allumerOrange();
                activationPanneOn();
                break;
        }
    }

    private void activationInit() {
        jMarche.setEnabled(true);
        jArret.setEnabled(false);
        jPanne.setEnabled(false);
        tRouge.stop();
        tRougeOrange.stop();
        tOrange.stop();
        tVert.stop();
        tPanneOff.stop();
        tPanneOn.stop();
    }

    private void activationRouge() {
        jMarche.setEnabled(false);
        jArret.setEnabled(true);
        jPanne.setEnabled(true);
        tRouge.start();
        tRougeOrange.stop();
        tOrange.stop();
        tVert.stop();
        tPanneOff.stop();
        tPanneOn.stop();
    }
    
    private void activationRougeOrange() {
        jMarche.setEnabled(false);
        jArret.setEnabled(true);
        jPanne.setEnabled(true);
        tRouge.stop();
        tRougeOrange.start();
        tOrange.stop();
        tVert.stop();
        tPanneOff.stop();
        tPanneOn.stop();
    }

    private void activationOrange() {
        jMarche.setEnabled(false);
        jArret.setEnabled(true);
        jPanne.setEnabled(true);
        tRouge.stop();
        tRougeOrange.stop();
        tOrange.start();
        tVert.stop();
        tPanneOff.stop();
        tPanneOn.stop();
    }

    private void activationVert() {
        jMarche.setEnabled(false);
        jArret.setEnabled(true);
        jPanne.setEnabled(true);
        tRouge.stop();
        tRougeOrange.stop();
        tOrange.stop();
        tVert.start();
        tPanneOff.stop();
        tPanneOn.stop();
    }

    private void activationPanneOn() {
        jMarche.setEnabled(true);
        jArret.setEnabled(true);
        jPanne.setEnabled(false);
        tRouge.stop();
        tRougeOrange.stop();
        tOrange.stop();
        tVert.stop();
        tPanneOff.stop();
        tPanneOn.start();
    }

    private void activationPanneOff() {
        jMarche.setEnabled(true);
        jArret.setEnabled(true);
        jPanne.setEnabled(false);
        tRouge.stop();
        tRougeOrange.stop();
        tOrange.stop();
        tVert.stop();
        tPanneOff.start();
        tPanneOn.stop();
    }

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
            java.util.logging.Logger.getLogger(FeuAnglais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FeuAnglais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FeuAnglais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FeuAnglais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FeuAnglais().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jArret;
    private javax.swing.JButton jMarche;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jPanne;
    // End of variables declaration//GEN-END:variables
}
