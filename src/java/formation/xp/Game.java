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
    
    static public int smallBlind = 5;
    
    private ArrayList<Player> players;
    private int round;
    private int totalBet;
    private int currentBet;
    private int currentPlayerIdx;
    private int dealerIdx;        

    
    public Game(String[] playerNames) {
        players = new ArrayList<Player>(playerNames.length);
        
        for (int i=0; i < playerNames.length; i++) {
            players.add(new Player(playerNames[i]));
        }
        
        round = 1;
        totalBet = 0;
        currentBet = 0;
        currentPlayerIdx = 0;
        dealerIdx = 0;
    }
    
    public void newRound()
    {
        for (int i=players.size() - 1; i >= 0; i--) {
            if(players.get(i).isBroke()) {
                players.remove(i);
            }
        }
        
        currentPlayerIdx = dealerIdx;
        next();
        
        raise(players.get(currentPlayerIdx), Game.smallBlind);
        
        CardDistributor dist = new CardDistributor();
        for(int i=0; i < players.size(); i++)
        {
            players.get(i).setCards(dist.getNRandomCards(2));
        }
    }
    public int getNbPlayers() {
        return players.size();
    }
    
    public int getRound() {
        return round;
    }
    
    public Player getPlayer(int positionPlayer) {
        if (positionPlayer >= 0 && positionPlayer < players.size()) {
            return players.get(positionPlayer);
        }
        return null;
    }
    
    public int getTotalBet() {
        return totalBet;
    }
    
    public int getCurrentBet() {
        return currentBet;
    }
    
    public Player getCurrentPlayer() {
        return players.get(currentPlayerIdx);
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
    
    public void allIn(Player player) {   
        int added = player.allIn(); 
        if (added >= 0) {
            totalBet += added;
            currentBet = Math.max(player.getCurrentBet(), currentBet);
        }
    }
    
    public void next() {
        currentPlayerIdx = (currentPlayerIdx + 1) % players.size();
        if (getCurrentPlayer().isBroke()) {
            next();
        }
    } 
}
