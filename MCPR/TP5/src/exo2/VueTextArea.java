/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo2;

import java.awt.Font;
import static java.lang.Math.floor;
import static java.lang.Math.round;
import javax.swing.JTextArea;

/**
 *
 * @author Hugues
 */
public class VueTextArea extends JTextArea {

    private Font startFont;
    public VueTextArea() {
        startFont = this.getFont();
        this.setText("");
    }

    public void setFont(int value) {
        Font tmp = new Font(startFont.getName(), startFont.getStyle(), (int) floor(startFont.getSize()*(value/100.0)));
        this.setFont(tmp);
    }
}
