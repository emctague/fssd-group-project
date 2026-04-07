package ca.sheridancollege.project;

/**
 * WarGameUI
 * 
 * Abstract interface of a service used to display a user interface for the
 * card game War.
 * 
 * @author mctaguee
 */
public interface WarGameUI {

    String askPlayerName();

    /**
     * @return true if player wants to continue, false if they want to exit
     */
    boolean promptNextTurn(int turn);

    void showGameOver(int userWins, int computerWins);

    void showPlayedCards(Card userCard, Card computerCard);

    void showRoundWinner(String message);

    void showTieCards(Card userTieCard, Card computerTieCard);

    void showTieStart();

    void showWelcome();

}
