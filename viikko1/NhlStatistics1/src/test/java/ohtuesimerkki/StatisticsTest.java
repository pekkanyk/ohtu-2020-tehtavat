/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author qru19
 */
public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka k‰ytt‰‰ "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void PelaajaLoytyy(){
        Player player;
        player = stats.search("Gretzky");
        String name = player.getName();
        assertEquals("Gretzky", name);
    }
    
    @Test
    public void PelaajaEiLoydy(){
        Player player;
        player = stats.search("Sel‰nne");
        
        assertEquals(null, player);
    }

    @Test
    public void JoukkueenPelaajat(){
        List<Player> playersOfTeam = stats.team("PIT");
        
        assertEquals("Lemieux", playersOfTeam.get(0).getName());
    }
    
    @Test
    public void top2(){
        List<Player> top2 = stats.topScorers(1);
        
        assertEquals(2, top2.size());
    }
}
