/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
public class Card {
    //default modifier for child classes

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    private final Rank rank; // Rank constant
    private final Suit suit; // Suit constant

    // Card Object with parameters needed to define the card
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // Create getters for the two variables but not setters as the variables are final and will be defined
    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    // toString method used to display the rank and suit of the Card when displayed in the game
    @Override
    public String toString() {
        return rank + " of " + suit;
    }

}
