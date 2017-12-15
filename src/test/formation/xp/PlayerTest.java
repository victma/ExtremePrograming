/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.xp;

import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author malet
 */
public class PlayerTest extends TestCase {
    @Test
    public void testReach() {
        Player player = new Player("Bob");
        
        //mise possible
        int initialMoney = player.getMoney();
        assertEquals("mise faite", 1, player.reach(1));
        assertEquals("monnaie restante", initialMoney - 1, player.getMoney());
        
        //mise impossible
        initialMoney = player.getMoney();
        assertEquals("mise non faite", -1, player.reach(initialMoney + 2));
        assertEquals("monnaie restante", initialMoney, player.getMoney());

    }
    
    @Test
    public void testIsBroke(){
        Player player = new Player("Bob");
        
        player.allIn();
        assertTrue(player.isBroke());
    }
    
    @Test
    public void testGetCurrentBet() {
        Player player = new Player("Bob");
        
        int initialMoney = player.getMoney();
        player.reach(1);
        assertEquals("mise", 1, player.getCurrentBet());
        
        player.reach(initialMoney);
        assertEquals("mise faite", initialMoney, player.getCurrentBet());
           
    }
    
    @Test
    public void testAllIn() {
        Player player = new Player("Bob");
        
        int initialMoney = player.getMoney();
        
        assertEquals("tapis", initialMoney, player.allIn());
        assertEquals("monnaie restante nulle", 0, player.getMoney());
    }
   
}
