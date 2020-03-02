/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author qru19
 */
public class Erotus extends Komento{

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita(){
        try {
            int arvo = Integer.parseInt(syotekentta.getText());
            sovellus.miinus(arvo);
            syotekentta.setText("");
            tuloskentta.setText("" + sovellus.tulos());
            nollaa.disableProperty().set(false);
        } catch (Exception e) {
        }
        
    }

    @Override
    public void peru() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
