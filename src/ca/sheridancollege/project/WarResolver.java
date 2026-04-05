/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author munoj
 */
public class WarResolver {
    private final WarGameUI ui;
    private final CardComparator comparator;

    public WarResolver(WarGameUI ui, CardComparator comparator) {
        this.ui = ui;
        this.comparator = comparator;
    }

    public Player resolveWar(Player user, Player computer) {

        ui.showTieStart();

        if (!user.hasCards() || !computer.hasCards()) {
            ui.showRoundWinner("A player ran out of cards during WAR!");
            return null;
        }

        Card userTieCard = user.playCard();
        Card computerTieCard = computer.playCard();

        if (userTieCard == null || computerTieCard == null) {
            ui.showRoundWinner("Unable to continue WAR due to lack of cards.");
            return null;
        }

        ui.showTieCards(userTieCard, computerTieCard);

        int result = comparator.compare(userTieCard, computerTieCard);

        if (result > 0) {
            ui.showRoundWinner("You win the tie-breaker round!");
            return user;
        } else if (result < 0) {
            ui.showRoundWinner("Computer wins the tie-breaker round!");
            return computer;
        } else {
            ui.showRoundWinner("It's another tie! Continuing WAR...");
            return resolveWar(user, computer);
        }
    }
}
