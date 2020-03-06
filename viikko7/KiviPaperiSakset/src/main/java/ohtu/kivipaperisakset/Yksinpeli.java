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
public class Yksinpeli extends Peli{
    private Tekoaly tekoaly;
    
    public Yksinpeli(IO io) {
        super(io);
        tekoaly = Tekoaly.luoPerustekoaly();
    }
    
    public Yksinpeli(IO io, int muistinkoko){
        super(io);
        tekoaly = Tekoaly.luoParempiTekoaly(muistinkoko);
    }
    
    @Override
    public void pelaa() {
        while (true){
            io.vuoro("pelaaja");
            String ekanSiirto = io.userInput();
            if (!onkoOkSiirto(ekanSiirto))
                break;
            String tkSiirto = tekoaly.annaSiirto();
            io.tekoalynSiirto(tkSiirto);
            tekoaly.asetaSiirto(tkSiirto);
            
            tuomari.kirjaaSiirto(ekanSiirto, tkSiirto);
            io.pelitilanne(tuomari);
        }
        
        io.pelinLopetus(tuomari);
        
    }
}
