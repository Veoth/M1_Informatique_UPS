/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo3;

import java.awt.Color;
import java.awt.event.KeyEvent;

/**
 *
 * @author Hugues
 */
public class MVC extends javax.swing.JFrame {
    
    private Etat etat;
    private ModelePourcent mPourcent;
    private int enteredVal;
    private int calcPourcent;

    /**
     * Creates new form MVC
     */
    public MVC() {
        initComponents();
        mPourcent = new ModelePourcent(vueCamembert, vueDown, vueUp, vueLabel);
        
        etat = Etat.INIT;
        enteredVal = 0;
        calcPourcent = 0;
        
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

        vueLabel = new exo3.VueLabel();
        vueCamembert = new exo3.VueCamembert();
        vueDown = new exo3.VueDown();
        vueUp = new exo3.VueUp();
        jStart = new javax.swing.JButton();
        jStop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        vueLabel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabelFocusGained(evt);
            }
        });
        vueLabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabelKeyPressed(evt);
            }
        });

        vueCamembert.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                vueCamembertMouseDragged(evt);
            }
        });
        vueCamembert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCamembertMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vueCamembertMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout vueCamembertLayout = new javax.swing.GroupLayout(vueCamembert);
        vueCamembert.setLayout(vueCamembertLayout);
        vueCamembertLayout.setHorizontalGroup(
            vueCamembertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
        );
        vueCamembertLayout.setVerticalGroup(
            vueCamembertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 154, Short.MAX_VALUE)
        );

        vueDown.setText("DOWN");
        vueDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDownActionPerformed(evt);
            }
        });

        vueUp.setText("UP");
        vueUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUpActionPerformed(evt);
            }
        });

        jStart.setText("START");
        jStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStartActionPerformed(evt);
            }
        });

        jStop.setText("STOP");
        jStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jStop))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(vueCamembert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vueDown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vueUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(vueUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(vueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(vueDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(vueCamembert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jStart)
                    .addComponent(jStop))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStartActionPerformed
        switch (etat) {
            case INIT:
                etat = Etat.NODOWN;
                activationNoDown();
                break;
            case NODOWN:
            // IMPOSSIBLE
            case DOWN:
            // IMPOSSIBLE
            case OK:
            // IMPOSSIBLE
            case NOUP:
            // IMPOSSIBLE
            case EDITING:
            // IMPOSSIBLE
        }
    }//GEN-LAST:event_jStartActionPerformed

    private void jStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStopActionPerformed
        switch (etat) {
            case INIT:
            // IMPOSSIBLE
            case NODOWN:
                etat = Etat.INIT;
                activationInit();
                break;
            case DOWN:
            // IMPOSSIBLE
            case OK:
                etat = Etat.INIT;
                activationInit();
                break;
            case NOUP:
                etat = Etat.INIT;
                activationInit();
                break;
            case EDITING:
            // IMPOSSIBLE
        }
    }//GEN-LAST:event_jStopActionPerformed

    private void jDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDownActionPerformed
        switch (etat) {
            case INIT:
            // IMPOSSIBLE
            case NODOWN:
            // IMPOSSIBLE
            case DOWN:
            // IMPOSSIBLE
            case OK:
                if (mPourcent.getValue() > 1) {
                    etat = Etat.OK;
                    mPourcent.setValue(mPourcent.getValue() - 1);
                    mPourcent.notifier();
                    activationOk();
                } else {
                    etat = Etat.NODOWN;
                    mPourcent.setValue(0);
                    mPourcent.notifier();
                    activationNoDown();
                }
                break;
            case NOUP:
                etat = Etat.OK;
                mPourcent.setValue(mPourcent.getValue() - 1);
                mPourcent.notifier();
                activationOk();
                break;
            case EDITING:
            // IMPOSSIBLE
        }
    }//GEN-LAST:event_jDownActionPerformed

    private void vueCamembertMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vueCamembertMouseDragged
        switch (etat) {
            case INIT:
            // IMPOSSIBLE
            case NODOWN:
            // IMPOSSIBLE
            case DOWN:
                etat = Etat.DOWN;
                calcPourcent = UtilitiesPieChart.pointToPercentage(vueCamembert, evt.getX(), evt.getY());
                mPourcent.setValue(calcPourcent);
                mPourcent.notifier();
                activationDown();
                break;
            case OK:
            // IMPOSSIBLE
            case NOUP:
            // IMPOSSIBLE
            case EDITING:
            // IMPOSSIBLE
        }
    }//GEN-LAST:event_vueCamembertMouseDragged

    private void jUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUpActionPerformed
        switch (etat) {
            case INIT:
            // IMPOSSIBLE
            case NODOWN:
                etat = Etat.OK;
                mPourcent.setValue(mPourcent.getValue() + 1);
                mPourcent.notifier();
                activationOk();
                break;
            case DOWN:
            // IMPOSSIBLE
            case OK:
                if (mPourcent.getValue() < 99) {
                    etat = Etat.OK;
                    mPourcent.setValue(mPourcent.getValue() + 1);
                    mPourcent.notifier();
                    activationOk();
                } else {
                    etat = Etat.NOUP;
                    mPourcent.setValue(mPourcent.getValue() + 1);
                    mPourcent.notifier();
                    activationNoDown();
                }
                break;
            case NOUP:
            // IMPOSSIBLE
            case EDITING:
            // IMPOSSIBLE
        }
    }//GEN-LAST:event_jUpActionPerformed

    private void jLabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabelKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            switch (etat) {
                case INIT:
                // IMPOSSIBLE
                case NODOWN:
                // IMPOSSIBLE
                case DOWN:
                // IMPOSSIBLE
                case OK:
                // IMPOSSIBLE
                case NOUP:
                // IMPOSSIBLE
                case EDITING:
                    try {
                        enteredVal = Integer.valueOf(vueLabel.getText());
                        
                        if (enteredVal >= 100) {
                            etat = Etat.NOUP;
                            enteredVal = 100;
                            mPourcent.setValue(enteredVal);
                            mPourcent.notifier();
                            activationNoUp();
                        } else if (enteredVal < 100 && enteredVal > 0) {
                            etat = Etat.OK;
                            //enteredVal = enteredVal;
                            mPourcent.setValue(enteredVal);
                            mPourcent.notifier();
                            activationOk();
                        } else {
                            etat = Etat.NODOWN;
                            enteredVal = 0;
                            mPourcent.setValue(enteredVal);
                            mPourcent.notifier();
                            activationNoDown();
                        }
                    } catch (NumberFormatException e) {
                        etat = Etat.EDITING;
                        mPourcent.setValue(mPourcent.getValue());
                    }
            }
        }
    }//GEN-LAST:event_jLabelKeyPressed

    private void jLabelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabelFocusGained
        switch (etat) {
            case INIT:
            // IMPOSSIBLE
            case NODOWN:
                etat = Etat.EDITING;
                activationEditing();
                break;
            case DOWN:
            // IMPOSSIBLE
            case OK:
                etat = Etat.EDITING;
                activationEditing();
                break;
            case NOUP:
                etat = Etat.EDITING;
                activationEditing();
                break;
            case EDITING:
            // IMPOSSIBLE
        }
    }//GEN-LAST:event_jLabelFocusGained

    private void jCamembertMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCamembertMousePressed
        switch (etat) {
            case INIT:
            // IMPOSSIBLE
            case NODOWN:
                if (UtilitiesPieChart.isPointInCircle(vueCamembert, evt.getX(), evt.getY())) {
                    etat = Etat.DOWN;
                    activationDown();
                }
                break;
            case DOWN:
            // IMPOSSIBLE
            case OK:
            // IMPOSSIBLE
            case NOUP:
            // IMPOSSIBLE
            case EDITING:
            // IMPOSSIBLE
        }
    }//GEN-LAST:event_jCamembertMousePressed

    private void vueCamembertMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vueCamembertMouseReleased
        switch (etat) {
            case INIT:
            // IMPOSSIBLE
            case NODOWN:
            // IMPOSSIBLE
            case DOWN:
                calcPourcent = UtilitiesPieChart.pointToPercentage(vueCamembert, evt.getX(), evt.getY());
                
                if (calcPourcent == 0) {
                    etat = Etat.NODOWN;
                    calcPourcent = 0;
                    mPourcent.setValue(calcPourcent);
                    mPourcent.notifier();
                    activationNoDown();
                } else if (calcPourcent == 100) {
                    etat = Etat.NOUP;
                    calcPourcent = 100;
                    mPourcent.setValue(calcPourcent);
                    mPourcent.notifier();
                    activationNoUp();
                } else {
                    etat = Etat.OK;
                    // calcPourcent = calcPourcent;
                    mPourcent.setValue(calcPourcent);
                    mPourcent.notifier();
                    activationOk();
                }
                break;
            case OK:
            // IMPOSSIBLE
            case NOUP:
            // IMPOSSIBLE
            case EDITING:
            // IMPOSSIBLE
        }
    }//GEN-LAST:event_vueCamembertMouseReleased
    
    private void activationInit() {
        jStart.setEnabled(true);
        jStop.setEnabled(false);
        vueDown.setEnabled(false);
        vueUp.setEnabled(false);
        //vueCamembert.setFocusable(false);
        vueLabel.setFocusable(false);
    }
    
    private void activationNoDown() {
        jStart.setEnabled(false);
        jStop.setEnabled(true);
        vueDown.setEnabled(false);
        vueUp.setEnabled(true);
        //vueCamembert.setFocusable(true);
        vueLabel.setFocusable(true);
    }
    
    private void activationDown() {
        jStart.setEnabled(false);
        jStop.setEnabled(false);
        vueDown.setEnabled(false);
        vueUp.setEnabled(false);
        //vueCamembert.setFocusable(true);
        vueLabel.setFocusable(false);
    }
    
    private void activationOk() {
        jStart.setEnabled(false);
        jStop.setEnabled(true);
        vueDown.setEnabled(true);
        vueUp.setEnabled(true);
        //vueCamembert.setFocusable(true);
        vueLabel.setFocusable(true);
    }
    
    private void activationNoUp() {
        jStart.setEnabled(false);
        jStop.setEnabled(true);
        vueDown.setEnabled(true);
        vueUp.setEnabled(false);
        //vueCamembert.setFocusable(true);
        vueLabel.setFocusable(true);
    }
    
    private void activationEditing() {
        jStart.setEnabled(false);
        jStop.setEnabled(false);
        vueDown.setEnabled(false);
        vueUp.setEnabled(false);
        //vueCamembert.setFocusable(false);
        vueLabel.setFocusable(false);
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
            java.util.logging.Logger.getLogger(MVC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MVC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MVC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MVC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MVC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jStart;
    private javax.swing.JButton jStop;
    private exo3.VueCamembert vueCamembert;
    private exo3.VueDown vueDown;
    private exo3.VueLabel vueLabel;
    private exo3.VueUp vueUp;
    // End of variables declaration//GEN-END:variables
}
