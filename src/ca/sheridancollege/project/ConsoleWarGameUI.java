package ca.sheridancollege.project;

/**
 * ConsoleWarGameUI
 * 
 * Provides command-line implementation of a user interface for the game War.
 * @author munoj
 * @author mctaguee
 */
public class ConsoleWarGameUI implements WarGameUI {
    private final InputProvider input;

    public ConsoleWarGameUI(InputProvider input) {
        this.input = input;
    }

    @Override
    public void showWelcome() {
        System.out.println("Welcome to the game of War!");
    }

    @Override
    public String askPlayerName() {
        System.out.print("Enter your name: ");
        return input.nextLine();
    }

    /**
     * @return true if player wants to continue, false if they want to exit
     */
    
    @Override
    public boolean promptNextTurn(int turn) {
        System.out.println("\nTurn " + turn);
        System.out.println("Press ENTER to play your card or type 'exit' to end the game.");
        String userInput = input.nextLine();
        return !userInput.equalsIgnoreCase("exit");
    }

    @Override
    public void showPlayedCards(Card userCard, Card computerCard) {
        System.out.println("You played: " + userCard);
        System.out.println("Computer played: " + computerCard);
    }

    @Override
    public void showRoundWinner(String message) {
        System.out.println(message);
    }

    @Override
    public void showGameOver(int userWins, int computerWins) {
        System.out.println("\n*** GAME OVER ***");
        if (userWins > computerWins) {
            System.out.println("Congratulations! You win the game with " + userWins + " wins!");
        } else if (userWins < computerWins) {
            System.out.println("Computer wins the game with " + computerWins + " wins!");
        } else {
            System.out.println("It's a tie! Both players have " + userWins + " wins.");
        }
    }
    @Override
    public void showTieStart() {
        System.out.println("Tie! Drawing cards to break the tie...");
    }

    @Override
    public void showTieCards(Card userTieCard, Card computerTieCard) {
        System.out.println("Your tie card: " + userTieCard);
        System.out.println("Computer's tie card: " + computerTieCard);
    }
}
