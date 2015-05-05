/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.SwingUtilities;

/**
 *
 * @author Hugues
 */
public class Poly extends javax.swing.JPanel implements MouseListener, MouseMotionListener, KeyListener {

    private Etat etat;
    private Integer nbClics;
    private LinkedList polygones;
    private LinkedList polyGrey;
    private Point movePoint;

    /**
     * Creates new form Poly
     */
    public Poly() {
        //initComponents();
        this.setPreferredSize(new Dimension(600, 450));
        this.setFocusable(true);

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);

        etat = Etat.REPOS;
        nbClics = 0;

        polygones = new LinkedList();
        polyGrey = new LinkedList();
        movePoint = null;
    }

    // Actions
    private void ajouterPoint(Point p) {
        polyGrey.add(p);
    }

    private void retirerPoint() {
        polyGrey.removeLast();
    }

    private void stockerPolygone() {
        LinkedList tmp = new LinkedList(polyGrey);
        polygones.add(tmp);
        polyGrey.clear();
    }

    private void dessinerGhost(Point p) {
        movePoint = p;
        repaint();
    }

    private void dessinerListRed() {
        repaint();
    }

    private void dessinerListGrey() {
        repaint();
    }

    private void effacer() {
        movePoint = null;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Affichage de tous les polygones finis, RED
        if (!polygones.isEmpty()) {
            g.setColor(Color.RED);

            for (int i = 0; i < polygones.size(); i++) {
                Iterator it = ((LinkedList) polygones.get(i)).iterator();

                Point a = (Point) it.next();
                Point b = new Point();

                while (it.hasNext()) {

                    b = (Point) it.next();
                    g.drawLine((int) a.getX(), (int) a.getY(), (int) b.getX(), (int) b.getY());
                    a = b;
                }

                a = (Point) ((LinkedList) polygones.get(i)).getFirst();
                g.drawLine((int) b.getX(), (int) b.getY(), (int) a.getX(), (int) a.getY());
            }
        }

        g.setColor(Color.BLACK);

        // Affichage du polygone en cours de dessin, NOIR
        if (!polyGrey.isEmpty()) {
            Iterator it = polyGrey.iterator();

            Point a = (Point) it.next();
            Point b = new Point();

            while (it.hasNext()) {

                b = (Point) it.next();
                g.drawLine((int) a.getX(), (int) a.getY(), (int) b.getX(), (int) b.getY());
                a = b;
            }
        }

        // Affichage de la ligne entre le dernier point et la souris
        if (movePoint != null) {
            Point p = (Point) polyGrey.getLast();
            g.drawLine((int) p.getX(), (int) p.getY(), (int) movePoint.getX(), (int) movePoint.getY());
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (SwingUtilities.isLeftMouseButton(me)) {
            switch (etat) {
                case REPOS:
                    etat = Etat.ONECLIC;
                    nbClics = 1;
                    ajouterPoint(me.getPoint());
                    activationOneClic();
                    break;
                case ONECLIC:
                    etat = Etat.CLICS;
                    nbClics++;
                    ajouterPoint(me.getPoint());
                    effacer();
                    // dessinerGhost();
                    // dessinerListRed();
                    // dessinerListGrey();
                    activationClics();
                    break;
                case CLICS:
                    etat = Etat.CLICS;
                    nbClics++;
                    ajouterPoint(me.getPoint());
                    effacer();
                    // dessinerGhost();
                    // dessinerListRed();
                    // dessinerListGrey();
                    activationClics();
                    break;
            }

        } else if (SwingUtilities.isRightMouseButton(me)) {
            switch (etat) {
                case REPOS:
                    etat = Etat.REPOS;
                    nbClics = 0;
                    activationRepos();
                    break;
                case ONECLIC:
                    etat = Etat.REPOS;
                    nbClics = 0;
                    retirerPoint();
                    effacer();
                    // dessinerListRed();
                    activationRepos();
                    break;
                case CLICS:
                    if (nbClics > 2) {
                        etat = Etat.CLICS;
                        nbClics--;
                        retirerPoint();
                        effacer();
                        dessinerGhost(me.getPoint());
                        // dessinerListRed();
                        // dessinerListGrey();
                        activationClics();
                    } else {
                        etat = Etat.ONECLIC;
                        nbClics--;
                        retirerPoint();
                        effacer();
                        dessinerGhost(me.getPoint());
                        // dessinerListRed();
                        // dessinerListGrey();
                        activationOneClic();
                    }
                    break;
            }
        } else {
            // IMPOSSIBLE
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        switch (etat) {
            case REPOS:
                etat = Etat.REPOS;
                nbClics = 0;
                activationRepos();
                break;
            case ONECLIC:
                etat = Etat.ONECLIC;
                // nbClics = nbClics;
                effacer();
                dessinerGhost(me.getPoint());
                // dessinerListRed();
                activationOneClic();
                break;
            case CLICS:
                etat = Etat.CLICS;
                // nbClics = nbClics;
                effacer();
                dessinerGhost(me.getPoint());
                // dessinerListRed();
                // dessinerListGrey();
                activationClics();
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
            switch (etat) {
                case REPOS:
                    etat = Etat.REPOS;
                    nbClics = 0;
                    activationRepos();
                    break;
                case ONECLIC:
                    etat = Etat.REPOS;
                    nbClics = 0;
                    retirerPoint();
                    effacer();
                    // dessinerListRed();
                    activationRepos();
                    break;
                case CLICS:
                    etat = Etat.REPOS;
                    nbClics = 0;
                    stockerPolygone();
                    effacer();
                    // dessinerListRed();
                    activationRepos();
                    break;
            }
        }
    }

    private void activationRepos() {

    }

    private void activationOneClic() {

    }

    private void activationClics() {

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
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseDragged(MouseEvent me) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }
}
