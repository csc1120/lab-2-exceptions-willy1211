/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Wilfried Tapsoba
 * Last Updated: 9/10/2024
 */
package tapsobaw;

public class Driver {
    public static void main(String[] args) {
        try{
            Die die = new Die(6); //create a die with 6 sides
            die.roll();  //roll the die
            System.out.println("Rolled value: " + die.getCurrentValue()); //get and print the rolled value

            //Try to get value again without rolling will throw DieNotRolledException
            System.out.println("Attempting to get value again: " + die.getCurrentValue());
        } catch (DieNotRolledException e) {
            System.out.println(e.getMessage());
        }
    }

}