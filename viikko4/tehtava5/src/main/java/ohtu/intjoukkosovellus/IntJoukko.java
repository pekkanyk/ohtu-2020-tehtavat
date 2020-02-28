
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(KAPASITEETTI);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti,OLETUSKASVATUS);
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");//heitin vaan jotain :D
        }
        ljono = new int[kapasiteetti];
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (!onkoJoTaulussa(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            laajennaTarvittaessa();
            return true;
        }
        return false;
    }
    
    public void laajennaTarvittaessa(){
        if (alkioidenLkm % ljono.length == 0) {
                int[] taulukkoOld = new int[ljono.length];
                taulukkoOld = ljono;
                kopioiTaulukko(ljono, taulukkoOld);
                ljono = new int[alkioidenLkm + kasvatuskoko];
                kopioiTaulukko(taulukkoOld, ljono);
            }
    }

    public boolean onkoJoTaulussa(int luku) {
        return haeIndeksiLuvulle(luku)>=0;
    }
    
    public int haeIndeksiLuvulle(int luku){
        for (int i=0;i<alkioidenLkm;i++){
            if (ljono[i] == luku){
                return i;
            }
        }
        return -1;
    }

    public void siirraAlkioitaKohdasta(int kohta){
        int apu;
        for (int j = kohta; j < alkioidenLkm - 1; j++) {
                apu = ljono[j];
                ljono[j] = ljono[j + 1];
                ljono[j + 1] = apu;
            }
        alkioidenLkm--;
    }
    
    public boolean poista(int luku) {
        int kohta = haeIndeksiLuvulle(luku);
        if (kohta != -1) {
            siirraAlkioitaKohdasta(kohta);
            return true;
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        switch (alkioidenLkm) {
            case 0:
                return "{}";
            case 1:
                return "{" + ljono[0] + "}";
            default:
                String tuotos = "{";
                for (int i = 0; i < alkioidenLkm - 1; i++) {
                    tuotos += ljono[i];
                    tuotos += ", ";
                }
                tuotos += ljono[alkioidenLkm - 1];
                tuotos += "}";
                return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }
    
    public static IntJoukko laskutoimitus(IntJoukko a, IntJoukko b, String toiminto){
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        if ("lisaa".equals(toiminto) || "erotus".equals(toiminto)){
            for (int i = 0; i < aTaulu.length; i++) {
                x.lisaa(aTaulu[i]);
            }
            for (int i = 0; i < bTaulu.length; i++) {
                if ("lisaa".equals(toiminto)){
                    x.lisaa(bTaulu[i]);
                }
                else if ("erotus".equals(toiminto)){
                    x.poista(bTaulu[i]);
                }
            }
        }
        else if("leikkaus".equals(toiminto)){
            for (int i = 0; i < aTaulu.length; i++) {
                for (int j = 0; j < bTaulu.length; j++) {
                    if (aTaulu[i] == bTaulu[j]) {
                        x.lisaa(bTaulu[j]);
                    }
                }
            }
        }
        
        return x;
    }
    
    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        return laskutoimitus(a,b,"lisaa");
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        return laskutoimitus(a,b,"leikkaus");
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        return laskutoimitus(a,b,"erotus");
    }
        
}
