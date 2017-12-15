/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.xp;

/**
 *
 * @author malet
 */
public class Player {
    private String name;
    private int money;
    private int currentBet;
    
    public Player(String playerName) {
        name = playerName;
        money = 20000;
        currentBet = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public int getMoney() {
        return money;
    }
    
    public int reach(int amount) {
        int diff = amount - currentBet;
        
        if (diff > money) {
            return -1;
        }
        
        money -= diff;
        currentBet = amount;
        
        return diff;
    }
}
