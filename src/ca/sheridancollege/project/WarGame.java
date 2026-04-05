/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author munoj
 */
public class WarGame extends Game{
    // Variables to track the number of wins for the user and the computer
    private int userWins;
    private int computerWins;
    private final WarGameUI ui;
    private final CardComparator comparator;
    private final WarResolver warResolver;

    /**
     * Constructor to initialize the WarGame with a given name.
     * Initializes win counters for both players.
     * @param name The name of the game.
     */
    public WarGame(String name, WarGameUI ui, CardComparator comparator) {
        super(name);
        this.ui = ui;
        this.comparator = comparator;
        this.warResolver = new WarResolver(ui, comparator);
        this.userWins = 0;
        this.computerWins = 0;
    }
    /**
     * The main game loop where the actual game logic is implemented.
     * Initializes and shuffles the deck, distributes cards to players, and manages the rounds.
     */
    @Override
    public void play() {
        // Create and shuffle the deck of cards
        GroupOfCards deck = new GroupOfCards();
        deck.populateDeck();
        deck.shuffle();
        // Get the list of players (user and computer)
        ArrayList<Player> players = super.getPlayers();
        Player user = players.get(0);
        Player computer = players.get(1);

        // Distribute cards to both players
        for (int i = 0; i < 26; i++) {
            user.drawCard(deck);
            computer.drawCard(deck);
        }

        // Set up user input and initialize turn counter
      
        int turn = 1;

        // Main game loop

        while (true) {

            boolean continueGame = ui.promptNextTurn(turn);
            if (!continueGame) {
                ui.showRoundWinner("Exiting the game...");
                break;
            }

            Card userCard = user.playCard();
            Card computerCard = computer.playCard();

            ui.showPlayedCards(userCard, computerCard);

            int result = comparator.compare(userCard, computerCard);

            if (result > 0) {
                ui.showRoundWinner("You win this round!");
                user.drawCard(deck);
                userWins++;
            } else if (result < 0) {
                ui.showRoundWinner("Computer wins this round!");
                computer.drawCard(deck);
                computerWins++;
            } else {
                ui.showRoundWinner("It's a tie! GOING TO WAR!");
                Player roundWinner = warResolver.resolveWar(user, computer);

                if (roundWinner == null) {
                    ui.showRoundWinner("No winner in the war. Game over.");
                    break;
                } else {
                    roundWinner.drawCard(deck);
                }
            }

            if (user.getDeck().getCards().isEmpty()) {
                ui.showRoundWinner("You have ran out of cards!");
                break;
            } else if (computer.getDeck().getCards().isEmpty()) {
                ui.showRoundWinner("Computer has ran out of cards!");
                break;
            }

            turn++;
        }
        // Declare the final winner
        declareWinner();
    }


    // Display the final result of the game, delcaring the final winner
    // Compare the number of wins to both players and displays the corresponding message
    @Override
    public void declareWinner() {
        ui.showGameOver(userWins, computerWins);
    }  
}
