
package ohtu;

public class Player implements Comparable<Player>{
    private int goals;
    private int assists;
    private String name;
    private int penalties;
    private String team;
    private String nationality;
    

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name +"  "+team+"    "+goals+" + "+assists+" = "+(goals+assists);
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
   
    @Override
    public int compareTo(Player p) {
        return (p.getGoals()+p.getAssists())-(this.getGoals()+this.getAssists());
    }


      
}
