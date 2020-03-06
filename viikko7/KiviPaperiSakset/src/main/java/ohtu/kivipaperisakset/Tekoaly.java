/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

/**
 *
 * @author qru19
 */
public abstract class Tekoaly {
    
    public abstract String annaSiirto();
    public abstract void asetaSiirto(String siirto);
    
    public static Tekoaly luoPerustekoaly(){
        return new TekoalyV1();
    }
    
    public static Tekoaly luoParempiTekoaly(int muistinkoko){
        return new TekoalyV2(muistinkoko);
    }
    
}
