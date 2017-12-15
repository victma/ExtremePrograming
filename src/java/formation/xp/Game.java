/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.xp; 
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author malet
 */
public class Game {
    
    private Player[] players;
    private int round;
    private int totalBet;
    private int currentBet;
        
    
    public Game(String[] playerNames) {
        players = new Player[playerNames.length];
        
        
        for (int i=0; i < playerNames.length; i++) {
            players[i] = new Player(playerNames[i]);
        }
        
        round = 1;
        totalBet = 0;
        currentBet = 0;
    }
    public void newRound()
    {
        CardDistributor dist = new CardDistributor();
        for(int i=0; i<players.length; i++)
        {
            players[i].setCards(dist.getNRandomCards(2));
        }
    }
    public int getNbPlayers() {
        return players.length;
    }
    
    public int getRound() {
        return round;
    }
    
    public Player getPlayer(int positionPlayer) {
        if (positionPlayer >= 0 && positionPlayer < players.length) {
            return players[positionPlayer];
        }
        return null;
    }
    
    public int getTotalBet() {
        return totalBet;
    }
    
    public int getCurrentBet() {
        return currentBet;
    }
    
    public void raise(Player player, int amount) {
        int added = player.reach(currentBet + amount);
        if (added >=0) {
            totalBet += added;
            currentBet += amount;
        }
    }
    
    public void call(Player player) {
        int added = player.reach(currentBet); 
        if (added >= 0) {
            totalBet += added;
        }
    }
    
    public List excludePlayer(){
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<this.getNbPlayers(); i++){
            if(players[i].isBroke())
                list.add(i);
        }
        
        return list;
    }
    
}
