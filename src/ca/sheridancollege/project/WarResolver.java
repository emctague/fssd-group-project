package ca.sheridancollege.project;

/**
 * Handles a 'war' scenario in the game of war.
 * 
 * @author munoj
 * @author mctaguee
 */
public class WarResolver {
    private final WarGameUI ui;
    private final CardComparator comparator;

    public WarResolver(WarGameUI ui, CardComparator comparator) {
        this.ui = ui;
        this.comparator = comparator;
    }

    
    public Player resolveWar(Player user, Player computer, GroupOfCards drawnCards) {
        ui.showTieStart();

        // Need 3 cards each: 2 face-down + 1 face-up
        if (!user.hasAtLeast(3) || !computer.hasAtLeast(3)) {
            ui.showRoundWinner("A player does not have enough cards to continue WAR (needs 3).");
            return null;
        }

        // Draw an additional face-down card.
        // According to https://bicyclecards.com/how-to-play/war, the original
        // tying cards count as the first set, so we only need to draw one
        // additional card per player.
        Card userDown1 = user.playCard();
        Card compDown1 = computer.playCard();
        drawnCards.getCards().add(userDown1);
        drawnCards.getCards().add(compDown1);

        // 3rd card face-up
        Card userUp = user.playCard();
        Card compUp = computer.playCard();
        drawnCards.getCards().add(userUp);
        drawnCards.getCards().add(compUp);

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
            return resolveWar(user, computer, drawnCards); // repeat 2-down + 1-up
        }
    }

}
