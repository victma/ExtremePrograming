package formation.xp;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.Assert;

public class CardDistributorTest extends TestCase {
        protected CardDistributor distributor ;
	
        @Before 
        @Override
        protected void setUp()
        {
            distributor = new CardDistributor();
        }
        
        @After
        public void tearDown()
        {}
        @Test
	public void testGetRandomCard() {
                int card = distributor.getRandomCard();
		assertTrue( (0<=card && card<=53) );
                
	}
        @Test
        public void testGetNRandomCards() {
            int tabSize=  2;
            int[] tab = distributor.getNRandomCards(tabSize);
            for(int i = 0; i<tabSize; i++)            {
                for(int j=i+1; j<tabSize; j++)
                    assertTrue( (tab[i] != tab[j]) );
                            
            }
        }
}
