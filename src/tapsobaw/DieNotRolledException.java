/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: Wilfried Tapsoba
 * Last Updated: 9/10/2024
 */
package tapsobaw;

/**
 * Method to roll the die and generate a new value
 * custom exception to be thrown when the die is not rolled yet
 * */
public class DieNotRolledException extends RuntimeException {
    /**
     * custom exception to be thrown when the die is not rolled yet
     * @return string
     * */
    public String getMessage() {
        return "Die has not been rolled or invalid value.";
    }

}
