/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Hugues
 */
public class Select extends javax.swing.JPanel implements MouseListener, MouseMotionListener {

    private Etat etat;
    private Boolean move;
    private Point a, b;
    private Color color;
    /**
     * Creates new form Select
     */
    public Select() {
        //initComponents();
        this.setPreferredSize(new Dimension(600,450));
        
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        
        a = null;
        b = null;
        color = Color.BLACK;
        
        etat = Etat.INIT;
        move = false;
    }
    
    
    private void drawLine(Point p) {
        b = p;
        color = Color.BLACK;
        repaint();
    }

    private void drawSelect() {
        color = Color.RED;
        repaint();
    }

    private void clean() {
        a = null;
        b = null;
        this.repaint();
    }

    public void stockerPointA(Point p) {
        a = p;
    }
    
    public void stockerPointB(Point p) {
        b = p;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (a != null && b != null) {
            g.setColor(color);
            g.drawLine((int)a.getX(), (int)a.getY(), (int)b.getX(), (int)b.getY());
        }
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        switch (etat) {
            case INIT:
                etat = Etat.PRESSED;
                clean();
                stockerPointA(me.getPoint());
                break;
            case PRESSED:
                // IMPOSSIBLE
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        switch (etat) {
            case INIT:
                // IMPOSSIBLE
            case PRESSED:
                if (!move) {
                    etat = Etat.INIT;
                    move = false;
                    clean();
                } else {
                    etat = Etat.INIT;
                    move = false;
                    drawSelect();
                }
                break;
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent me) {
        switch (etat) {
            case INIT:
                etat = Etat.INIT;
                break;
            case PRESSED:
                etat = Etat.PRESSED;
                move = true;
                drawLine(me.getPoint());
                break;
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }
}
