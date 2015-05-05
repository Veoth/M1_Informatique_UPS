/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo3;

/**
 *
 * @author Hugues
 */
public class ModelePourcent {
    private VueCamembert vueCamembert;
    private VueDown vueDown;
    private VueUp vueUp;
    private VueLabel vueLabel;
    private int value;
    
    public ModelePourcent(VueCamembert vueCamembert, VueDown vueDown, VueUp vueUp, VueLabel vueLabel) {
        this.vueCamembert = vueCamembert;
        this.vueDown = vueDown;
        this.vueUp = vueUp;
        this.vueLabel = vueLabel;
        value = 0;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
         
    public int getValue() {
        return value;
    }
    
    public void notifier() {
        vueCamembert.setAngle(value);
        vueLabel.setValue(value);
    }
}
