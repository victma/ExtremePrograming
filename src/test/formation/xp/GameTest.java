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
    public void testNewRound(){
        Game testGame = new Game(new String[]{"Bob", "Cecile"});
                
        testGame.getPlayer(0).allIn();
        testGame.newRound();
        assertEquals("éliminer les joueurs fauchés", 1, testGame.getNbPlayers());
    }
    
    @Test
    public void testCall() {
        Game testGame = new Game(new String[]{"Bob", "Cecile"});
        testGame.raise(testGame.getPlayer(0), 1);
        testGame.call(testGame.getPlayer(1));
                
        assertEquals("montant pot", 2, testGame.getTotalBet());
        assertEquals("mise minimale", 1, testGame.getCurrentBet());
    }
    
    @Test
    public void testAllIn() {
        Game testGame = new Game(new String[]{"Bob", "Cecile"});
        int amountAllIn = testGame.getPlayer(0).getMoney(); 
        
        testGame.allIn(testGame.getPlayer(0));
                
        assertEquals("montant pot", amountAllIn, testGame.getTotalBet());
        assertEquals("mise minimale", amountAllIn, testGame.getCurrentBet());
    }
    
    @Test
    public void testTurns() {
        Game testGame = new Game(new String[]{"Bob", "Cecile"});
        
        assertEquals("premier tour", "Bob", testGame.getCurrentPlayer().getName());
        testGame.next();
        assertEquals("premier tour", "Cecile", testGame.getCurrentPlayer().getName());
        testGame.next();
        assertEquals("premier tour", "Bob", testGame.getCurrentPlayer().getName());
    }
    
    @Test
    public void testDealer() {
        Game testGame = new Game(new String[]{"Bob", "Cecile"});
        int initialMoney = testGame.getPlayer(1).getMoney();
        testGame.newRound();
        
        assertEquals("payer la petite blind", initialMoney - Game.smallBlind, testGame.getPlayer(1).getMoney());
    }
}
