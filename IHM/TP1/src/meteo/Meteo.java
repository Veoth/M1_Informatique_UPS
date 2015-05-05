/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

/**
 *
 * @author 21206989
 */
public class Meteo extends javax.swing.JFrame {

    private Etat etat;
    private int nbClicTic;

    /**
     * Creates new form Meteo
     */
    public Meteo() {
        initComponents();
        etat = Etat.INIT;
        nbClicTic = 0;
        vide();
        activationInit();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jStop = new javax.swing.JButton();
        jStart = new javax.swing.JButton();
        jTic = new javax.swing.JButton();
        jMeteo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jStop.setText("STOP");
        jStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStopActionPerformed(evt);
            }
        });

        jStart.setText("START");
        jStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStartActionPerformed(evt);
            }
        });

        jTic.setText("TIC");
        jTic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTicActionPerformed(evt);
            }
        });

        jMeteo.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jStop)
                .addGap(36, 36, 36)
                .addComponent(jStart)
                .addGap(39, 39, 39)
                .addComponent(jTic)
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jMeteo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jMeteo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jStop)
                    .addComponent(jStart)
                    .addComponent(jTic))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStopActionPerformed
        switch (etat) {
            case INIT:
                throw new RuntimeException("Etat interdit");
            case EMARCHE:
                etat = Etat.INIT;
                nbClicTic = 0;
                pouf();
                activationInit();
                break;
        }
    }//GEN-LAST:event_jStopActionPerformed

    private void jStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStartActionPerformed
        switch (etat) {
            case INIT:
                etat = Etat.EMARCHE;
                nbClicTic = 0;
                soleil();
                activationEMarche();
                break;
            case EMARCHE:
                throw new RuntimeException("Etat interdit");
        }
    }//GEN-LAST:event_jStartActionPerformed

    private void jTicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTicActionPerformed
        switch (etat) {
            case INIT:
                throw new RuntimeException("Etat interdit");
            case EMARCHE:
                if (nbClicTic == 0) {
                    etat = Etat.EMARCHE;
                    nbClicTic++;
                    nuage();
                    activationEMarche();
                } else if (nbClicTic == 1) {
                    etat = Etat.EMARCHE;
                    nbClicTic++;
                    pluie();
                    activationEMarche();
                } else if (nbClicTic == 2) {
                    etat = Etat.EMARCHE;
                    nbClicTic++;
                    eclair();
                    activationEMarche();
                } else {
                    etat = Etat.INIT;
                    nbClicTic = 0;
                    vide();
                    activationInit();
                }
                break;
        }
    }//GEN-LAST:event_jTicActionPerformed

    void activationInit() {
        jStop.setEnabled(false);
        jStart.setEnabled(true);
        jTic.setEnabled(false);
    }

    void activationEMarche() {
        jStop.setEnabled(true);
        jStart.setEnabled(false);
        jTic.setEnabled(true);
    }

    void vide() {
        jMeteo.setText("VIDE");
    }

    void soleil() {
        jMeteo.setText("SOLEIL");
    }

    void nuage() {
        jMeteo.setText("NUAGE");
    }

    void pluie() {
        jMeteo.setText("PLUIE");
    }

    void eclair() {
        jMeteo.setText("ECLAIR");
    }

    void pouf() {
        jMeteo.setText("POUF");
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
            java.util.logging.Logger.getLogger(Meteo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Meteo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Meteo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Meteo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Meteo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jMeteo;
    private javax.swing.JButton jStart;
    private javax.swing.JButton jStop;
    private javax.swing.JButton jTic;
    // End of variables declaration//GEN-END:variables
}