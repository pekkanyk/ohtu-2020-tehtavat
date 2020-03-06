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
public abstract class Peli {
    protected IO io;
    protected Tuomari tuomari;
    
    public Peli(IO io){
        this.io = io;
        this.tuomari = new Tuomari();
        io.startGreet();
    }
    
    public abstract void pelaa();
    
    public static Peli luoKaksinpeli(IO io){
        return new Kaksinpeli(io);
    }
    
    public static Peli luoYksinpeli(IO io, int muistinkoko){
        return new Yksinpeli(io, muistinkoko);
    }
    
    public static Peli luoYksinpeli(IO io){
        return new Yksinpeli(io);
    }
    
    public static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
