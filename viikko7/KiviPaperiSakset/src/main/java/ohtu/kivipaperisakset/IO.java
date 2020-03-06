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
public class IO {
    
    private Scanner scanner;
    
    public IO (){
        this.scanner = new Scanner(System.in);
    }
    
    public void mainMenu(){
        System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmist√§ vastaan "
                    + "\n (b) teko√§ly√§ vastaan"
                    + "\n (c) parannettua teko√§ly√§ vastaan"
                    + "\n (x) (tai mik‰ vain muu) lopettaa");
    }
    
    public String userInput(){
        return scanner.nextLine();
    }
    
    public void startGreet() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
    }
    
    public void vuoro(String pelaaja) {
        System.out.println("Vuorossa: "+pelaaja+" Anna syˆte : ");
    }
    
    public void pelitilanne(Tuomari tuomari) {
        System.out.println(tuomari.pelitilanne());
    }
    
    public void pelinLopetus(Tuomari tuomari) {
        System.out.println("\n Kiitos pelist‰. Pistetilanne lopuksi:");
        System.out.println(tuomari.pelitilanne());
    }
    
    public void tekoalynSiirto(String tkSiirto) {
        System.out.println("Tietokone valitsi: "+tkSiirto);
    }
}
