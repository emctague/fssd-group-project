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

        // Need 3 cards each: 2 face-down + 1 face-up
        if (!user.hasAtLeast(3) || !computer.hasAtLeast(3)) {
            ui.showRoundWinner("A player does not have enough cards to continue WAR (needs 3).");
            return null;
        }

        // 2 cards face-down (burn cards)
        Card userDown1 = user.playCard();
        Card userDown2 = user.playCard();
        Card compDown1 = computer.playCard();
        Card compDown2 = computer.playCard();

        // 3rd card face-up
        Card userUp = user.playCard();
        Card compUp = computer.playCard();

        // Defensive (shouldn't happen because hasAtLeast(3), but safe)
        if (userUp == null || compUp == null) {
            ui.showRoundWinner("Unable to continue WAR due to lack of cards.");
            return null;
        }

        // Optional UI messaging
        ui.showRoundWinner("Each player places 2 cards face-down...");
        ui.showTieCards(userUp, compUp); // reuse your existing UI method for the face-up cards

        int result = comparator.compare(userUp, compUp);

        if (result > 0) {
            ui.showRoundWinner("You win the WAR!");
            return user;
        } else if (result < 0) {
            ui.showRoundWinner("Computer wins the WAR!");
            return computer;
        } else {
            ui.showRoundWinner("WAR tied again! Continuing...");
            return resolveWar(user, computer); // repeat 2-down + 1-up
        }
    }

}
