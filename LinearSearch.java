import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * LinearSearch program that generates random arrays, sorts them,
 * and allows the user to search for values with crash-proof input validation.
 *
 * @author Carel Gumuyire
 * @version 1.0
 */
public final class LinearSearch {

    /**
     * Private constructor to hide implicit public one for utility/main class.
     */
    private LinearSearch() {
    }

    /**
     * Populates an array with 10 random integers between 0 and 100.
     *
     * @return an array of 10 random integers
     */
    public static int[] populateArray() {
        final Random random = new Random();
        final int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101);
        }
        return array;
    }

    /**
     * Performs a linear search on an array to find a target number.
     *
     * @param array the array of numbers to search through
     * @param number the target number to find
     * @return the index of the number if found, or -1 if not found
     */
    public static int linearSearch(final int[] array, final int number) {
        int index = 0;
        for (int value : array) {
            if (value == number) {
                return index;
            }
            index++;
        }
        return -1;
    }

    /**
     * Main method running the interactive loop and handling user input.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        boolean running = true;

        do {
            final int[] array = populateArray();
            Arrays.sort(array);

            System.out.println();
            for (int num : array) {
                System.out.print(num + " ");
            }

            System.out.print("\nEnter a number or \"q\" to quit: ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Thanks for playing");
                running = false;
            } else {
                int number = -1;
                boolean valid = false;

                while (!valid) {
                    try {
                        number = Integer.parseInt(input);
                        valid = true;
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid input. Enter a valid "
                                + "number or \"q\" to quit: ");
                        input = scanner.next();
                        if (input.equalsIgnoreCase("q")) {
                            System.out.println("Thanks for playing");
                            running = false;
                            break;
                        }
                    }
                }

                if (running) {
                    final int index = linearSearch(array, number);

                    if (index != -1) {
                        System.out.println("Number found at index: " + index);
                    } else {
                        System.out.println("Number not found");
                    }
                }
            }

        } while (running);

        scanner.close();
    }
}



