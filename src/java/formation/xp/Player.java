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
    private int[] cards;
    private int currentBet;
    
    public Player(String playerName) {
        name = playerName;
        money = 20000;
        currentBet = 0;
        cards = new int[2];
    }

    public String getName() {
        return name;
    }

    public void setCards(int c1, int c2) {
        cards[0] = c1;
        cards[1] = c2;
    }

    public int[] getCards() {
        return cards;
    }

    public static String convertIntToCard(int c) {
        int couleur = c / 14;
        int val = c % 14;
        String nomCarte = new String();

        switch (val) {
            case 11:
                nomCarte += "Valet";
                break;
            case 12:
                nomCarte += "Dame";
                break;
            case 13:
                nomCarte += "Roi";
                break;
            default:
                nomCarte += Integer.toString(val);
                break;
        }
        nomCarte+=" de ";
        switch(couleur)
        {
            case 0:
                nomCarte+="Pique";
                break;
            case 1:
                nomCarte+="Carreau";
                break;
            case 2:
                nomCarte+="Coeur";
                break;
            case 3:
                nomCarte+="Trèfle";
                break;
                
        }
        return nomCarte;
    }

    public int getMoney() {
        return money;
    }
    
    public int getCurrentBet() {
        return currentBet;
    }

    public void setMoney(int m) {
        money = m;
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
    
    public int allIn() {
        return reach(money + currentBet);
    }

    public void check()
    {}
    
    public boolean isBroke()
    {
        return (money == 0);
    }
}
