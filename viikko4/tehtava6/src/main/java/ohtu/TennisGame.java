package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            player1Score += 1;
        else
            player2Score += 1;
    }
    
    public boolean gameEven(){
        return player1Score==player2Score;
    }
    public String evenScoresToString(int score){
        switch (score){
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }
    
    public boolean advantage(){
        return player1Score>=4 || player2Score>=4;
    }
    
    public String advantageToString(){
        int p1ScoreMinusP2Score = player1Score - player2Score;
        if (p1ScoreMinusP2Score == 1){
            return "Advantage "+player1Name;
        }
        else if (p1ScoreMinusP2Score == -1){
            return "Advantage "+player2Name;
        }
        else if (p1ScoreMinusP2Score >= 2){
            return "Win for "+player1Name;
        }
        else {
            return "Win for "+player2Name;
        }
    }
    
    public String scoreToString(int score){
        switch (score){
            default:
                return "Love";
            case 1: 
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
    }

    public String getScore() {
        if (gameEven()){
            return evenScoresToString(player1Score);
        }
        
        else if (advantage()){
            return advantageToString();
        }
        else{
            return scoreToString(player1Score)+ "-"+scoreToString(player2Score);
        }
    }
}