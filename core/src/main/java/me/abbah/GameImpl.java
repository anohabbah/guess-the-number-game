package me.abbah;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameImpl implements Game {
    // == Constants ==
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    // == Fields ==
    private NumberGenerator numberGenerator;
    private int guessCount = 10;
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @Override
    public void reset() {
        this.smallest = 0;
        this.guess = 0;
        this.remainingGuesses = this.guessCount;
        this.biggest = this.numberGenerator.getMaxNumber();
        this.number = this.numberGenerator.next();
        log.debug("The number is {}", this.number);
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    @Override
    public int getGuess() {
        return this.guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return this.smallest;
    }

    @Override
    public int getBiggest() {
        return this.biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return this.remainingGuesses;
    }

    @Override
    public void check() {
        checkValidNumberRange();

        if (validNumberRange) {
            if (guess > number) {
                biggest = guess - 1;
            }

            if (guess < number) {
                smallest = biggest + 1;
            }
        }

        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return this.validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return this.guess == this.number;
    }

    @Override
    public boolean isGameLost() {
        return !this.isGameWon() && this.remainingGuesses <= 0;
    }

    private void checkValidNumberRange() {
        this.validNumberRange = (this.guess >= this.smallest) && (this.guess <= this.biggest);
    }
}
