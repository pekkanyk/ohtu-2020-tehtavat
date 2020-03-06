/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author qru19
 */
public class QueryBuilder {
    Matcher matcher;
    
    public QueryBuilder(){
        matcher = new All();
    }
    
    public Matcher build(){
        Matcher temp = this.matcher;
        this.matcher = new All();
        return temp;
    }
    
    public QueryBuilder hasAtLeast(int value, String category){
        this.matcher = new And(this.matcher,new HasAtLeast(value,category));
        //this.matcher = new HasAtLeast(value, category);
        return this;
    }
    
    public QueryBuilder playsIn(String team){
        this.matcher = new And(this.matcher,new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category){
        this.matcher = new And(this.matcher,new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers){
        this.matcher = new Or(matchers);
        return this;  
    }
}
