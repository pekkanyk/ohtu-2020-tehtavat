/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author qru19
 */
public class Kaksinpeli extends Peli{

    public Kaksinpeli(IO io) {
        super(io);
    }

    @Override
    public void pelaa() {
        while (true){
            io.vuoro("pelaaja 1");
            String ekanSiirto = io.userInput();
            if (!onkoOkSiirto(ekanSiirto))
                break;
            io.vuoro("pelaaja 2");
            String tokanSiirto = io.userInput();
            if (!onkoOkSiirto(tokanSiirto))
                break;
            
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            io.pelitilanne(tuomari);
        }
        
        io.pelinLopetus(tuomari);
    }
    
}
