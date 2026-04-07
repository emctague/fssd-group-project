package ca.sheridancollege.project;

/**
 * WarGameAppp
 * 
 * Main entry point for an app that plays the card game War.
 * 
 * @author munoj
 */
public class WarGameApp {
    public static void main(String[] args) {
        InputProvider input = new ConsoleInputProvider();
        ConsoleWarGameUI ui = new ConsoleWarGameUI(input);
        ui.showWelcome();

        String userName = ui.askPlayerName();

        Player user = new Player(userName);
        Player computer = new Player("Computer");

        CardComparator comparator = new RankCardComparator();
        // Create a new instance of the game and add players
        WarGame warGame = new WarGame("War Game", ui, comparator);
        warGame.getPlayers().add(user);
        warGame.getPlayers().add(computer);
        warGame.play();
    }
}
