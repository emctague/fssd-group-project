package ca.sheridancollege.project;

/**
 * CardComparator
 * 
 * Provides a comparison between two cards according to some rule.
 * @author munoj
 */
public interface CardComparator {
     /**
     * @return positive if a > b, negative if a < b, 0 if equal
     */
    int compare(Card a, Card b);
}
