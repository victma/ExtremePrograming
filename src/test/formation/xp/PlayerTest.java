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
   
}
