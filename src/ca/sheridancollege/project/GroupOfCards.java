/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards {

    // The group of cards, stored in an ArrayList
    private final ArrayList<Card> cards;

    // Group of Cards Object
    public GroupOfCards() {
        // Making new ArrayList called cards
        cards = new ArrayList<>();
    }

    /**
     * A method that will get the group of cards as an ArrayList and to store multiple cards dynamically
     * @return the group of cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    // Method to populate the Deck with the suits and rank of a standard 52 card deck
    public void populateDeck() {
        // For Loop to produce all possible variations of a card in a deck
        for (Suit suit : Suit.values()) { // For a String called suit will be assigned an element from suits array
            for (Rank rank : Rank.values()) { // A string called rank will be assigned an element from ranks array
                cards.add(new Card(rank, suit)); // Array list cards will add new items from the Card object
            }
        }
    }

    // Shuffle method utilizes the collections to randomly arrange the array list in one line of code instead of using Random
    public void shuffle() {
        Collections.shuffle(cards);
    }

}//end class
