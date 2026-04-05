/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author munoj
 */
public class WarGameApp {
    public static void main(String[] args) {
        InputProvider input = new ConsoleInputProvider();
        WarGameUI ui = new WarGameUI(input);
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
