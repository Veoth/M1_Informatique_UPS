/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo3;

import javax.swing.JTextField;

/**
 *
 * @author Hugues
 */
public class VueLabel extends JTextField {
    private Integer value;
    
    public VueLabel() {
        this.value = 0;
        this.setText("0");
    }
    
    public void setValue(int value) {
        this.value = value;
        this.setText(this.value.toString());
    }
}
