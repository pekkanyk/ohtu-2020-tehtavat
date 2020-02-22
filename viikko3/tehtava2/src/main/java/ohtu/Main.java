package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] AllPlayers = mapper.fromJson(bodyText, Player[].class);
        ArrayList<Player> FilteredPlayers = new ArrayList<>();
        
        for (Player player : AllPlayers){
            if (player.getNationality().equals("FIN") ){
                FilteredPlayers.add(player);
            }
        }
        
        Collections.sort(FilteredPlayers);
        
        System.out.println("Suomalaisten pelaajien tulokset:");
        for (Player player : FilteredPlayers) {
                       System.out.println(player);
                }   
    }
  
}
