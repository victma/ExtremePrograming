/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formation.xp;
import java.util.Random;

/**
 *
 * @author n_dakota
 */
public class CardDistributor {
    public int getRandomCard()
    {
        Random randomGenerator = new Random();
        int card = randomGenerator.nextInt(51);
        
        return card;
    }
    
    public int[] getNRandomCards(int n)
    {
        int[] tab = new int[n];
        boolean isEqual = false;
        for(int i=0; i<n; i++)
        {
            do
            {
                int card = getRandomCard();
                for(int j =0; j<i; j++)
                {
                    if(tab[j] == card)
                    {
                        isEqual = true;
                        break;
                    }
                }
                if(!isEqual)
                    tab[i] = card;
            }
            while(isEqual);
            isEqual = false;
        }
        
        return tab;
    }
}
