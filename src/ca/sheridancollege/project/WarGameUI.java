/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author munoj
 */
public class WarGameUI {
    private final InputProvider input;

    public WarGameUI(InputProvider input) {
        this.input = input;
    }

    public void showWelcome() {
        System.out.println("Welcome to the game of War!");
    }

    public String askPlayerName() {
        System.out.print("Enter your name: ");
        return input.nextLine();
    }

    /**
     * @return true if player wants to continue, false if they want to exit
     */
    
    public boolean promptNextTurn(int turn) {
        System.out.println("\nTurn " + turn);
        System.out.println("Press ENTER to play your card or type 'exit' to end the game.");
        String userInput = input.nextLine();
        return !userInput.equalsIgnoreCase("exit");
    }

    public void showPlayedCards(Card userCard, Card computerCard) {
        System.out.println("You played: " + userCard);
        System.out.println("Computer played: " + computerCard);
    }

    public void showRoundWinner(String message) {
        System.out.println(message);
    }

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
    public void showTieStart() {
        System.out.println("Tie! Drawing cards to break the tie...");
    }

    public void showTieCards(Card userTieCard, Card computerTieCard) {
        System.out.println("Your tie card: " + userTieCard);
        System.out.println("Computer's tie card: " + computerTieCard);
    }
}
