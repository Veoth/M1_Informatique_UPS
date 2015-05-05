/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo2;

/**
 *
 * @author Hugues
 */
public class ModeleText {
    private String value;
    VueTextArea vueText;
    
    public ModeleText(VueTextArea v) {
        value = null;
        vueText = v;
    }
    
    public void setValue(String s)
    {
        this.value = s;
    }
    
    public void notifier() {
        
    }
}
