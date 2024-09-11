/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Wilfried Tapsoba
 * Last Updated: 9/10/2024
 */
package tapsobaw;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        int[] input = getInput();
        int numDice = input[0];
        int numSides = input[1];
        int numRolls = input[2];
        System.out.println(numDice + " "+ numSides + " "+numRolls);


    }

    /**
     * getInput() method: Ask the user for 3 numbers in the format 1 3 45
     * number of dice to roll, number of sides, number of times to roll the dice
     * @ return the 3 numbers in an array
     * */
    static int[] getInput(){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Please enter the number of dice to roll, how many sides the dice have,\n" +
                "and how many rolls to complete, separating the values by a space.\n" +
                "Example: \"2 6 1000\"");

        String[] input = scanner.nextLine().split(" ");
        int[] result = new int [3];
        for(int i = 0; i<3; i++){
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }

    /**
     * Public createDice() class
     * @ parameters : numDice and numSides
     * @ return an array of Die objects
     * */
    static Die[] createDice(int numDice, int numSides){
        Die[] dice = new Die[numDice];
        for(int i = 0; i < numDice; i++){
            dice[i] = new Die (numSides);
        }
        return dice;
    }

}