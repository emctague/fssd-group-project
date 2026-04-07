
package ca.sheridancollege.project;

/**
 * RankCardComparator
 * 
 * Compares two cards based on the integer value of their rank.
 * 
 * @author munoj
 */
public class RankCardComparator implements CardComparator{
    @Override
    public int compare(Card a, Card b) {        
        // Assumes a and b are not null (we already guard before calling)
        return Integer.compare(a.getRank().getValue(), b.getRank().getValue());

    }
}
