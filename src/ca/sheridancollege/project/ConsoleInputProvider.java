package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * ConsoleInputProvider
 * 
 * An input provider that reads input from System.in.
 * @author munoj
 */
public class ConsoleInputProvider implements InputProvider{
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
}
