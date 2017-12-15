package formation.xp;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class GameTest extends TestCase {
    @Test
    public void testCreateGame() {
        Game testGame = new Game(new String[]{"Bob", "Cecile"});
        
        //create players
        assertEquals("définir nombre joueurs", 2, testGame.getNbPlayers());
        assertEquals("nom premier joueur", "Bob", testGame.getPlayer(0).getName());
        assertEquals("nom deuxième joueur", "Cecile", testGame.getPlayer(1).getName());
        assertNull("abscence troisième joueur", testGame.getPlayer(2));
        
        //start at round 1
        assertEquals("initialiser au tour 1", 1, testGame.getRound());
        
        assertEquals("pot initial nul", 0, testGame.getTotalBet());
        
        assertEquals("mise minimale nulle", 0, testGame.getCurrentBet());
    }
    
    @Test
    public void testBet() {
        Game testGame = new Game(new String[]{"Bob", "Cecile"});
        
        testGame.raise(testGame.getPlayer(0), 1);
                
        assertEquals("montant pot", 1, testGame.getTotalBet());
    }
    
    @Test
    public void testExcludePlayer(){
        Game testGame = new Game(new String[]{"Bob", "Cecile"});
        
        assertTrue(testGame.excludePlayer().isEmpty());
        
        testGame.getPlayer(0).setMoney(0);
        assertEquals(testGame.excludePlayer().size(), 1);
        assertEquals(testGame.excludePlayer().get(0), 0);
    }
    @Test
    public void testCall() {
        Game testGame = new Game(new String[]{"Bob", "Cecile"});
        testGame.raise(testGame.getPlayer(0), 1);
        testGame.call(testGame.getPlayer(1));
                
        assertEquals("montant pot", 2, testGame.getTotalBet());
        assertEquals("mise minimale", 1, testGame.getCurrentBet());
    }
}
