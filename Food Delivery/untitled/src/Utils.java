import java.util.Scanner;

/**
 * Utility class that provides helper methods for collecting user input.
 *
 * Simplifies common console input interactions such as reading strings and integers.
 *
 * Author: Reyan
 * Version: 1.0
 */
public class Utils
{
    //Shared scanner for all the input methods
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user and returns the entered line of input as a trimmed string.
     *
     * @param prompt the message to display before waiting for input
     * @return the trimmed user input
     */
    public static String getInput(String prompt)
    {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    /**
     * Prompts the user and reads an integer from the input.
     *
     * @param prompt the message to display before waiting for input
     * @return the parsed integer from user input
     * @throws NumberFormatException if input is not a valid integer
     */
    public static int getIntInput(String prompt)
    {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine());
    }
}
