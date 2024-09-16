/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: Wilfried Tapsoba
 * Last Updated: 9/10/2024
 */
package tapsobaw;

import java.util.Random;

/**
 * Public Die class
 * Keep track of the number of sides on the Die 2-100
 * */
public class Die extends DieNotRolledException {
    protected int numSides; //number of sides of the die
    protected int currentValue; //current value of the die
    protected Random random;  //Random object for rolling the die


    /**
     * constructor class
     * @param numSides = number of sides
     * @throws IllegalArgumentException e
     * */
    public Die(int numSides) throws IllegalArgumentException {
        final int minSides = 2;
        final int maxSides = 100;
        if(numSides <= minSides || numSides >= maxSides){
            throw new IllegalArgumentException("Number of sides must be between 2 and 100.");
        }
        this.numSides = numSides;
        this.random = new Random();
    }

    /**
     * Method to roll the die and generate a new random value
     * */
    public void roll(){
        this.currentValue = random.nextInt(numSides)+1; // Random value 1-numSides
    }

    /**
     * Method to get the current value and reset it
     * @ no parameter
     * @return current value: an int
     * @throws DieNotRolledException e
     * */
    public int getCurrentValue() throws DieNotRolledException {
        if(currentValue < 1 || currentValue > numSides){
            System.err.println(getMessage());
        }
        int value = currentValue;
        this.currentValue = 0; //Reset currentValue so it must be rolled again
        return value;
    }

}