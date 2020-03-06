package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    //private static final Scanner scanner = new Scanner(System.in);
    private static IO io;
    
    public static void main(String[] args) {
        io = new IO();

        OUTER:
        while (true) {
            io.mainMenu();
            String valinta = io.userInput();
            switch (valinta) {
                case "a":
                    Peli.luoKaksinpeli(io).pelaa();
                    break;
                case "b":
                    Peli.luoYksinpeli(io).pelaa();
                    break;
                case "c":
                    Peli.luoYksinpeli(io, 20).pelaa();
                    break;
                default:
                    break OUTER;
            }
        }

    }
}
