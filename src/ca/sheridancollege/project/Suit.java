package ca.sheridancollege.project;

/**
 * Suit
 * 
 * Represents the suit of a playing card.
 * @author munoj
 */
public enum Suit {
        
    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs"),
    SPADES("Spades");

    private final String display;

    Suit(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return display;
    }
}
