/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Wilfried Tapsoba
 * Last Updated: 9/10/2024
 */
package tapsobaw;

import java.util.Scanner;

/**
 * public class driver
 * contain a number of helper method and main
 * */
public class Driver {

    public static void main(String[] args) {
        boolean tryAgain = false;
        while(!tryAgain){
            try{
                int[] input = getInput();
                int numDice = input[0];
                int numSides = input[1];
                int numRolls = input[2];

                Die[] dice = createDice(numDice, numSides);
                int[] rollResults = rollDice(dice, numRolls);
                int maxCount = findMax(rollResults);

                report(rollResults, maxCount);
                tryAgain = true;

            } catch (NumberFormatException e){
                System.err.println("Invalid input: Make sure your input are all whole numbers.");
            } catch (ArrayIndexOutOfBoundsException e){
                System.err.println("Invalid input: Expected 3 values but only received 2. " +
                        "Separate values by a space.");
            } catch (IllegalArgumentException e){
                System.err.println("Bad die creation: Illegal numbers of sides: ");
            }
        }

    }

    /**
     * getInput() method: Ask the user for 3 numbers in the format 1 3 45
     * number of dice to roll, number of sides, number of times to roll the dice
     * @ return the 3 numbers in an array
     * */
    static int[] getInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Please enter the number of dice to roll, \
                how many sides the dice have,
                and how many rolls to complete, separating the values by a space.
                Example: "2 6 1000\"""");

        String[] input = scanner.nextLine().split(" ");
        int[] result = new int[3];
        for(int i = 0; i<3; i++){
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }

    /**
     * Public createDice() method
     * @ parameters : numDice and numSides
     * @ return an array of Die objects
     * */
    static Die[] createDice(int numDice, int numSides){
        Die[] dice = new Die[numDice];
        for(int i = 0; i < numDice; i++){
            dice[i] = new Die(numSides);
        }
        return dice;
    }

    /**
     * Public rollDice() method: roll all dice
     * total up the values and add to that value's total
     * @ parameter numRolls and an array of Die objects
     * @ return rollResults: an int array
     * */
    static int[] rollDice(Die[] dice, int numRolls){
        int[] rollResults = new int[dice.length*dice[0].numSides+1];

        for(int t = 0; t< numRolls; t++){
            int sum = 0;
            for(Die die: dice){
                die.roll();
                sum += die.getCurrentValue();
            }
            rollResults[sum]++;
        }
        return rollResults;
    }

    /**
     * Public findMax() method: take an array containing rolling results
     * find and return the largest count
     * @ parameter: an array, rollResults
     * @ return largest count: int
     * */
    static int findMax(int[] rollResults){
        int max = 0;
        for(int count: rollResults){
            if(count > max){
                max = count;
            }
        }
        return max;
    }

    /**
     * Public findMax() method: take an array containing rolling results
     * find and return the largest count
     * @ parameter: an array, rollResults
     * @ return largest count: int
     * */
    static void report(int[] rollResults, int maxCount){
        for(int i = 0; i< rollResults.length; i++){
            if(rollResults[i] > 0){
                System.out.print(i+ ": ");
                for(int j = 0; j< rollResults[i]; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        System.out.println("Most frequent count: " + maxCount);
    }

}