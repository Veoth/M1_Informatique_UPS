/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo2;

import java.awt.Font;
import javax.swing.JTextArea;

/**
 *
 * @author Hugues
 */
public class ModeleZoom {
    private int value;
    private VueTextArea vueText;
    
    public ModeleZoom(VueTextArea v) {
        value = 100;
        vueText = v;
    }
    
    public void setValue(int i)
    {
        this.value = i;
    }
    
    public void notifier() {
        vueText.setFont(value);
    }
}
